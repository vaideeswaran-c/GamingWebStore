package com.ilp.beans;

public class Game {
	
	private int id;
	
	private String name;
	
	private int year;
	
	private Double cost;
	
	private String console;
	
	private String type;
	
	private String description;
	
	public Game(String name, int year, Double cost, String console, String type, String description) {
		super();
		this.name = name;
		this.year = year;
		this.cost = cost;
		this.console = console;
		this.type = type;
		this.description = description;
	}
	
	public Game() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", year=" + year + ", cost=" + cost + ", console=" + console
				+ ", type=" + type + ", description=" + description + "]";
	}

}
