package com.ilp.services;

import java.util.ArrayList;
import com.ilp.beans.Game;
import com.ilp.dal.GameDao;

public class GameService implements ServiceInterface<Game> {
	private static GameDao dao;

	public GameService() {
		dao = new GameDao();
	}

	@Override
	public Game save(Game game) {
		return dao.save(game);
	}

	@Override
	public ArrayList<Game> findAll() {
		return dao.findAll();
	}

	@Override
	public Game findById(String id) {
		return dao.findById(id);
	}

	@Override
	public void update(Game obj) {
		dao.update(obj);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}
	
	public ArrayList<Game> findByTypeAndString(String searchType, String searchString) {
		return dao.findByTypeAndString(searchType, searchString);
	}
	
}