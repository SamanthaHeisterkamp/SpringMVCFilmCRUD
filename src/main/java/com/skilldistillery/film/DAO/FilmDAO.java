package com.skilldistillery.film.DAO;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;



public interface FilmDAO {
	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;

	public String convertLanguageId(int filmId) throws SQLException;

	public List<Film> findFilmByKeyword(String keyword) throws SQLException;

	public Actor createActor(Actor actor);

	boolean saveActor(Actor actor);

	boolean deleteActor(Actor actor);
	
	public Film createFilm(Film film);
	
	boolean editFilm(Film film);
	
	boolean deleteFilm(int filmId);

	public String convertCategoryId(int filmId) throws SQLException;

}
