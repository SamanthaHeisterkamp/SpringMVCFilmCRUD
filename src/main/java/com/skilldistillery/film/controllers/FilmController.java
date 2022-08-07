package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(path= "filmDetails.do", params="keyword", method=RequestMethod.GET)
	public ModelAndView retrieveFilmDetails(String keyword) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmByKeyword(keyword);
		mv.addObject("films", films);
		
		mv.setViewName("WEB-INF/filmResults.jsp");
		
		return mv;
	}
	
	
	@RequestMapping(path= "createdFilm.do", method=RequestMethod.POST)
	public ModelAndView createFilm(Film film, RedirectAttributes redir) throws SQLException{
		Film newFilm = filmDAO.createFilm(film);
//		boolean createdFilm = newFilm.getFilmId() > 0 ? true : false;
		ModelAndView mv = new ModelAndView();
		System.out.println("**********************INSIDE OF CREATEFILM()****************");
		System.out.println(newFilm);
		boolean yesThisIsCreated = true;
		redir.addFlashAttribute("createdFilm", yesThisIsCreated);
		mv.addObject("film", newFilm);
		mv.setViewName("redirect:thisFilmIsReallyCreated.do");
		return mv;
	}
	
	@RequestMapping(path= "thisFilmIsReallyCreated.do", method=RequestMethod.GET)
	public ModelAndView filmHasBeenCreated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/createdConfirmation.jsp");
		return mv;
	}


	
	@RequestMapping(path= "deleteFilm.do", params="filmId", method=RequestMethod.GET)
	public ModelAndView deleteFilm(int filmId) throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		boolean deleted = filmDAO.deleteFilm(filmId);
		mv.addObject("deleted", deleted);
		mv.addObject("filmId", filmId);
		mv.setViewName("WEB-INF/deletedFilm.jsp");
		
		return mv;
	}
	
	//This path is hit from the filmResults.jsp edit button.
	//It passes the filmId so we can find the film to edit in the DAO by using findFilmById(filmId)
	//We use a GET request to populate the form with the previous values.
	//We add the object which is the currentFilm to the model and view which will support that GET request with all the values
	// of the currentFilm.
	//then we set the model and view to hit the editFilm.jsp
	@RequestMapping(path="editFilmForm.do", params="filmId", method=RequestMethod.GET)
	public ModelAndView updateFilmForm(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film currentFilm = filmDAO.findFilmById(filmId);
		mv.addObject("film", currentFilm);
		
		mv.setViewName("WEB-INF/editFilm.jsp");
		return mv;
	}
	
	//When we click the Update Film button, this path will be taken.
	//We use a POST request whenever we want to modify or in CRUD terms "Update"
	//We pass in the actual Film object and pass the film object into the editFilm() method.
	@RequestMapping(path="filmIsEdited.do", method=RequestMethod.POST)
	public ModelAndView currentlyUpdatingFilm(Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		filmDAO.editFilm(film);
		System.out.println("***********INSIDE OF currentlyUpdatingFilm()*******");
		System.out.println(film);
		mv.setViewName("WEB-INF/filmResults.jsp");
		return mv;
	}
	
}
