package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.DAO.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDAO;

	//home.do path is redirected from web.xml welcome file using home.jsp
	@RequestMapping(path= {"/", "home.do"})
	public String index() {
		return "WEB-INF/home.jsp";
	}
	@RequestMapping(path= {"/", "addFilm.do"})
	public String createFilmForm() {
		return "WEB-INF/addFilm.jsp";
	}
	@RequestMapping(path= {"/", "deleteFilm.do"})
	public String delete() {
		return "WEB-INF/delete.jsp";
	}
	//filmDetails.do is a path we execute from our home.jsp, 
	//we then pass a 'filmId' parameter input by user using the form "searchByFilmId" inside home.jsp
	//we can duplicate this method for the keyword search user story 5 changing 
	//parameter in take to String 'keyword' along with params="keyword"
	
	@RequestMapping(path= "filmDetails.do", params="filmId", method=RequestMethod.GET)
	public ModelAndView retrieveFilmDetails(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<>();
		films.add(filmDAO.findFilmById(filmId));
		mv.addObject("films", films);
		
		mv.setViewName("WEB-INF/filmResults.jsp");
		
		return mv;
	}
	
	
	@RequestMapping(path= "createdFilm.do", method=RequestMethod.POST)
	public ModelAndView createFilm(Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDAO.createFilm(film);
		System.out.println("**********************INSIDE OF CREATEFILM()****************");
		System.out.println(newFilm);
		mv.addObject("film", newFilm);
		mv.setViewName("redirect:thisFilmIsReallyCreated.do");
		return mv;
	}
	
	@RequestMapping(path= "thisFilmIsReallyCreated.do", method=RequestMethod.GET)
	public ModelAndView filmHasBeenCreated() throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/filmResults.jsp");
		return mv;
	}

	
	@RequestMapping(path= "deleteFilm.do", params="filmId", method=RequestMethod.GET)
	public ModelAndView deleteFilm(int filmId) throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		boolean deleted = filmDAO.deleteFilm(filmId);
		mv.addObject("deleted", deleted);
		mv.addObject("filmId", filmId);
		mv.setViewName("WEB-INF/home.jsp");
		
		return mv;
	}

	
}
