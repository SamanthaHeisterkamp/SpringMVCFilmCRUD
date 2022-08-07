package com.skilldistillery.film.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO{
	private static final String user = "student";
	private static final String pass = "student";
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static Connection conn;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		
		try {
		conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM film WHERE id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film();

			film.setFilmId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setActorList(findActorsByFilmId(filmId));
			film.setLanguage(convertLanguageId(filmId));

		}

		filmResult.close();
		stmt.close();

		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;

		conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM actor WHERE id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);

		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor();

			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
		}

		actorResult.close();
		stmt.close();

		conn.close();

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		List<Actor> actors = new ArrayList<>();

		conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT id, first_name, last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet ar = stmt.executeQuery();

		while (ar.next()) {
			int id = ar.getInt("id");
			String firstName = ar.getString("first_name");
			String lastName = ar.getString("last_name");
			Actor actor = new Actor(id, firstName, lastName);
			actors.add(actor);
		}
		ar.close();
		stmt.close();
		conn.close();

		return actors;
	}

	@Override
	public String convertLanguageId(int filmId) throws SQLException {
		conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT language.name FROM language JOIN film on film.language_id = language.id WHERE film.id = ?";
		String lang = "";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			lang = rs.getString("language.name");
		}
		rs.close();
		stmt.close();
		conn.close();
 
		return lang;

	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();

		conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		keyword = "%" + keyword + "%";
		stmt.setString(1, keyword);
		stmt.setString(2, keyword);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");

			films.add(findFilmById(id));

		}
		rs.close();
		stmt.close();

		conn.close();

		return films;
	}

	@Override
	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO actor (first_name, last_name) " + " VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newActorId = keys.getInt(1);
					actor.setId(newActorId);
					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Film film : actor.getFilms()) {
							stmt.setInt(1, film.getFilmId());
							stmt.setInt(2, newActorId);
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + actor);
		}
		return actor;
	}

	@Override
	public boolean saveActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE actor SET first_name=?, last_name=? " + " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			stmt.setInt(3, actor.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE actor_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actor.getId());
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
				for (Film film : actor.getFilms()) {
					stmt.setInt(1, film.getFilmId());
					stmt.setInt(2, actor.getId());
					updateCount = stmt.executeUpdate();
				}
				conn.commit(); // COMMIT TRANSACTION
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film createFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate,  length,  replacement_cost, rating, special_features )"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?) ";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();

				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setFilmId(newFilmId);
					System.out.println(film);
					conn.commit();
				}
				keys.close();
				stmt.close();
				conn.close();

			}

		} catch (SQLException e) {
			System.err.println("Error trying to insert");
			e.printStackTrace();
		}
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.err.println("Error trying to rollback");
				e2.printStackTrace();
			}
		}

		return film;
	}

	@Override
	public boolean editFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			//special_features was spelled incorrectly
			String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?,  rental_duration = ?, "
					+ "rental_rate = ?, length = ?, replacement_cost = ?,  rating = ?, special_features = ? "
					+ "WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			stmt.setInt(11, film.getFilmId());

			int updateCount = stmt.executeUpdate();

			conn.commit();
			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteFilm(int filmId) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			String sql = "DELETE FROM film WHERE film.id = ? ";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);

			int updateCount = stmt.executeUpdate();

			conn.commit();
			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}

		return true;
	}

	

}
