package com.ilp.dal;

import java.util.ArrayList;

public interface DaoInterface<T> {
	ArrayList<T> findAll();
	
	ArrayList<T> findByTypeAndString(String searchType, String searchString);

	T findById(String name);

	void update(T obj);

	T save(T obj);

	void delete(String name);
}