package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorList;
	private String language;
	private String category;

	public Film() {
		super();
	}
	
	public Film(int filmId, String title, String desc, int releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features, List<Actor> actors, String cat) {
		this.filmId = filmId;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.languageId = langId;
		this.rentDuration = rentDur;
		this.rentalRate = rate;
		this.length = length;
		this.replacementCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
		this.actorList = actors;
		this.category  =  cat;

	}

	// method to be called in sub menu when user wishes to see all details
	public void printAllDetails(int filmId) {
		System.out.println("Film ID: " + filmId + "\nTitle: " + title + "\nRelease year: " + releaseYear + "\nRating: "
				+ rating + "\nDescription: " + description + "\nLanguage: " + language + "\nRental Duration: "
				+ rentDuration + "\nRental Rate: " + rentalRate + "\nLength: " + length +"mins" + "\nReplacement Cost: $"
				+ replacementCost + "\nSpecial Features: " + specialFeatures + "\nCast: \n" + actorList);
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String features) {
		this.specialFeatures = features;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(actorList, category, description, filmId, language, languageId, length, rating, releaseYear,
				rentDuration, rentalRate, replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actorList, other.actorList) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && filmId == other.filmId
				&& Objects.equals(language, other.language) && languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentDuration == other.rentDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [filmId=");
		builder.append(filmId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", releaseYear=");
		builder.append(releaseYear);
		builder.append(", languageId=");
		builder.append(languageId);
		builder.append(", rentDuration=");
		builder.append(rentDuration);
		builder.append(", rentalRate=");
		builder.append(rentalRate);
		builder.append(", length=");
		builder.append(length);
		builder.append(", replacementCost=");
		builder.append(replacementCost);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", specialFeatures=");
		builder.append(specialFeatures);
		builder.append(", actorList=");
		builder.append(actorList);
		builder.append(", language=");
		builder.append(language);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}

	

//	@Override
//	public String toString() {
//		String s = "\n\nFilm Id: " + filmId + "\nFilm Title: " + title + "\nDescription: " + description
//				+ "\nReleaseYear: " + releaseYear + "\nRating: " + rating + "\nLanguage: " + language + " \nActors:\n";
//		for (Actor actor : actorList) {
//			s += actor;
//
//		}
//		return s;
//	}
	
	


}
