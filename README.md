# SpringMVCFilmCRUD

## Team
* Jordy Castorena
* Samantha Heisterkamp
* Zach Kotterer

## Overview
For our week 8 project we were tasked with creating a full-stack Spring MVC web application that allows users to create, update, retrieve, and delete persistent records. This application implements full web-based C.R.U.D. functionality, using Spring MVC and the DAO pattern. When the user runs the application they are first brought to our home.jsp where the user will have three options to choose from. The first option allows the user to search for a film  using the film's Id, when the user enters a film Id that does not correspond to a film Id in the database, the user will be brought to a page that informs them that no such film exists. If the user enters a film Id and the film does exist, the user will be brought to a page that displays all of the film's details. In addition to searching for a film with the film's Id, the user may also search for a film using a keyword. If the user enters a keyword, the keyword must be in the film's title or description, otherwise they will be brought to a page that informs them that there were no films that matched their search. If the keyword entered does exist in the film's title or description, the user will be brought to a page that displays each film and it's details that contains the keyword. The last option on the home page allows the user to create a new film, if the user selects this option they will be brought to a new page that prompts them to enter all of the details of the film they would like to add. In addition to creating a film and being able to search for films by an Id or keyword, the user also has the option to  update the details of a film as well as remove a film from the database. 

## Technologies Used

* Java 
* Spring MVC 
* SQL, MySQL 
* JDB
* CSS
* Gradle
* Git
* HTML
* BootStrap

## Lessons Learned

Communication was key during this project build. This prevented merge conflict and when merge conflicts did arise, we were able to walk each team mate through the process of fixing our merges. Open communication about ideas, schedules, pair programming, and pushing kept our project build clean. 
Naming our methods and .do's turned out to be really important. We learned early on that using very specific names would help us know where we were in the terminal during troubleshooting. 
We learned how to properly implement Spring MVC into our Dynamic Web Application.    
