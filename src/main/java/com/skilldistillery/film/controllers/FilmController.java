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
	
	//filmDetails.do is a path we execute from our home.jsp, 
	//we then pass a 'filmId' parameter input by user using the form "searchByFilmId" inside home.jsp
	@RequestMapping(path= "filmDetails.do", params="filmId", method=RequestMethod.GET)
	public ModelAndView retrieveFilmDetails(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<>();
		films.add(filmDAO.findFilmById(filmId));
		mv.addObject("films", films);
		
		mv.setViewName("WEB-INF/filmResults.jsp");
		
		return mv;
	}
}
