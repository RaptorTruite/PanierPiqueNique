package com.hb.panierpiquenique.model;

public class Bouteille {

	private static int ID = 1;
	private int id;
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
	public Bouteille() {
	}
	public Bouteille(String name, double price) {
		id = ID++;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " prix : " + price + "€";
	}
}
