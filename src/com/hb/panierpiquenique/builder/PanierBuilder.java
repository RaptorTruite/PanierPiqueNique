package com.hb.panierpiquenique.builder;

import com.hb.panierpiquenique.factory.GiftFactory;
import com.hb.panierpiquenique.model.Bouteille;
import com.hb.panierpiquenique.model.Panier;
import com.hb.panierpiquenique.model.PiqueNique;

public class PanierBuilder {
	
	private Panier panier = null;
	
	public PanierBuilder() {
		this.panier = new Panier();
	}
	
	public void setPiqueNique(PiqueNique picnic) {
		panier.setPiqueNique(picnic);
	}
	
	public void setNumberOfPerson(int number) {
		panier.setNumberOfPerson(number);
	}
	
	public void setBottle(Bouteille bottle) {
		panier.setBottle(bottle);
	}
	
	public void setMessage(String s) {
		panier.setMessage(s);
	}
	
	public void setGift() {
		panier.setGift(GiftFactory.getInstance().getGift());
	}
	
	public Panier getPanier() {
		return panier;
	}
}
