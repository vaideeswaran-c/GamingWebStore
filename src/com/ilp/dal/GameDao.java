package com.ilp.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.ilp.beans.Game;
import com.ilp.utilities.*;

public class GameDao implements DaoInterface<Game> {

	@Override
	public ArrayList<Game> findAll() {
		Connection con = DbCon.getConnection();
		ArrayList<Game> gameList = new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM GAME");
			ResultSet rs=ps.executeQuery();
		    while (rs.next()) {
		    	//System.out.println("Resultset "+ rs.toString());
		        Game game = new Game(rs.getString("NAME"), rs.getInt("YEAR"), rs.getDouble("COST"), rs.getString("CONSOLE"), rs.getString("TYPE"), rs.getString("DESCRIPTION"));
		        game.setId(rs.getInt("ID"));
		        gameList.add(game);
		    }
		    ps.close();
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return gameList;
	}
	
	public ArrayList<Game> findByTypeAndString(String searchType, String searchString) {
		Connection con = DbCon.getConnection();
		ArrayList<Game> gameList = new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM GAME WHERE "+ searchType +" LIKE ?");
			ps.setString(1, "%" +searchString+ "%");
			System.out.println("ps "+ ps.toString());
			ResultSet rs=ps.executeQuery();
		    while (rs.next()) {
		    	System.out.println("Resultset "+ rs.toString());
		        Game game = new Game(rs.getString("NAME"), rs.getInt("YEAR"), rs.getDouble("COST"), rs.getString("CONSOLE"), rs.getString("TYPE"), rs.getString("DESCRIPTION"));
		        game.setId(rs.getInt("ID"));
		        gameList.add(game);
		    }
		    ps.close();
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return gameList;
	}

	@Override
	public Game findById(String id) {

		Connection con = DbCon.getConnection();
		Game game = null;
		try {
			String sql = "SELECT * FROM GAME WHERE NAME = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			game = new Game(rs.getString("NAME"), rs.getInt("YEAR"), rs.getDouble("COST"), rs.getString("CONSOLE"), rs.getString("TYPE"), rs.getString("DESCRIPTION"));
			game.setId(rs.getInt("ID"));
			ps.close();
		    rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return game;

	}

	@Override
	public void update(Game game) {
		Connection con = DbCon.getConnection();
		try {
			System.out.println("Update game" + game);
			String updateSql = "UPDATE GAME SET NAME = ?, YEAR = ?, COST = ? , CONSOLE = ?, TYPE = ? , DESCRIPTION = ? WHERE ID = ?";
			PreparedStatement stmt=con.prepareStatement(updateSql);
			stmt.setString(1, game.getName());
			stmt.setInt(2, game.getYear());
			stmt.setDouble(3, game.getCost());
			stmt.setString(4, game.getConsole());
			stmt.setString(5, game.getType());
			stmt.setString(6, game.getDescription());
			stmt.setInt(7, game.getId());
				
			stmt.executeUpdate();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

	}

	@Override
	public Game save(Game game) {
		Connection con = DbCon.getConnection();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO GAME (NAME, YEAR, COST, CONSOLE, TYPE, DESCRIPTION) VALUES ( ?, ? ,? ,?, ?, ?)"); 
			stmt.setString(1, game.getName());
			stmt.setInt(2, game.getYear());
			stmt.setDouble(3, game.getCost());
			stmt.setString(4, game.getConsole());
			stmt.setString(5, game.getType());
			stmt.setString(6, game.getDescription());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return null;

	}

	@Override
	public void delete(String id) {
		Connection con = DbCon.getConnection();
		try {
			String deleteSQL = "DELETE FROM GAME WHERE ID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(deleteSQL);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

	}

}
