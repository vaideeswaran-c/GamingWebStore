package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ilp.beans.Game;
import com.ilp.services.GameService;

/**
 * Servlet implementation class GameWriteServlet
 */
@WebServlet("/Game")
public class GameWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.setName(request.getParameter("game_name"));
		game.setYear(Integer.parseInt(request.getParameter("game_year")));
		game.setCost(Double.parseDouble(request.getParameter("game_cost")));
		game.setConsole(request.getParameter("game_console"));
		game.setType(request.getParameter("game_type"));
		game.setDescription(request.getParameter("game_description"));
		System.out.println("Given game data " + game);

		String action = request.getParameter("action");

		GameService service = new GameService();

		if (action.equals("add")) {
			service.save(game);
			System.out.println("Added!");
		} else if (action.equals("update")) {
			System.out.println("Update " + game);
			service.update(game);
			HttpSession session = request.getSession();
			session.setAttribute("message", "Game updated.");
		}
		request.getRequestDispatcher("/GameReadAllServlet").forward(request, response);
	}

}
