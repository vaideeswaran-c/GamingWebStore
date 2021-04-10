package com.ilp.services;

import java.util.ArrayList;

import com.ilp.beans.Game;

public interface ServiceInterface<T> {
	ArrayList<T> findAll();

	T findById(String name);

	void update(T obj);

	T save(T obj);

	void delete(String name);

	ArrayList<T> findByTypeAndString(String searchType, String searchString);

}
