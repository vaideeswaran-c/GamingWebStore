package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.beans.Game;
import com.ilp.services.GameService;

/**
 * Servlet implementation class GameReadServlet
 */
@WebServlet("/Game/List")
public class GameReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameReadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchType = request.getParameter("searchType");
		String searchString = request.getParameter("searchString");
		if (searchType != null && searchString != null ) {
			System.out.println(searchType+ searchString);
			GameService service = new GameService();
			ArrayList<Game> games = service.findByTypeAndString(searchType, searchString);
			HttpSession session = request.getSession();
			session.setAttribute("games", games);
			request.getRequestDispatcher("/jsp/GamePages/DisplayGames.jsp").forward(request, response);
		} else {
			String idString = request.getParameter("id");
			if (idString != null) {
				GameService service = new GameService();
				Game game = service.findById(idString);
				HttpSession session = request.getSession();
				session.setAttribute("game", game);
				request.getRequestDispatcher("/jsp/GamePages/update.jsp").forward(request, response);
			} else {
				GameService service = new GameService();
				ArrayList<Game> games = service.findAll();
				for (Game game : games) {
					System.out.println(game);
				}
				HttpSession session = request.getSession();
				session.setAttribute("games", games);
				request.getRequestDispatcher("/jsp/GamePages/DisplayGames.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
