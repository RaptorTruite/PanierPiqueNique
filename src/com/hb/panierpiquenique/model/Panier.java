package com.hb.panierpiquenique.model;

public class Panier {

	private PiqueNique piqueNique;
	private int numberOfPerson;
	private Bouteille bottle;
	private double price = 10.0;
	private String message;
	private Gift gift;
	
	public PiqueNique getPiqueNique() {
		return piqueNique;
	}
	public void setPiqueNique(PiqueNique piqueNique) {
		this.piqueNique = piqueNique;
		price += numberOfPerson * piqueNique.getPrice();
	}
	public int getNumberOfPerson() {
		return numberOfPerson;
	}
	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	public Bouteille getBottle() {
		return bottle;
	}
	public void setBottle(Bouteille bottle) {
		this.bottle = bottle;
		price += bottle.getPrice();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public Panier() {
	}

	public void show() {
		String msg = "Panier " + piqueNique.getName() + " pour " + numberOfPerson + " personnes";
		
		if (bottle != null)
			msg += " avec une " + bottle.getName();
		
		System.out.println(msg);
		
		System.out.println("Prix du panier : " + price + "€");
		System.out.println("Message personnalisé : " + message);
		System.out.println("Cadeau : " + gift.getName());
	}
}
