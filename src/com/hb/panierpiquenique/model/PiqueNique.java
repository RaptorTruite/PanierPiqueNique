package com.hb.panierpiquenique.model;

public class PiqueNique {

	private static int ID = 0;
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
	
	public PiqueNique() {
	}
	public PiqueNique(String name, double price) {
		id = ID++;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return id + " Pique Nique " + name + " /prix : " + price + "€";
	}
}
