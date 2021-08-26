package com.hb.panierpiquenique.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hb.panierpiquenique.builder.PanierBuilder;
import com.hb.panierpiquenique.iterator.BouteillesCollections;
import com.hb.panierpiquenique.model.Bouteille;
import com.hb.panierpiquenique.model.PiqueNique;

public class PanierPiqueNiqueMain {
	static Scanner scan = new Scanner(System.in);
	static List<PiqueNique> piqueniques = new ArrayList<>();
	static BouteillesCollections bottles = new BouteillesCollections();
	static PanierBuilder builder = new PanierBuilder();

	public static void main(String[] args) {
		generateBottles();
		generatePiqueNique();

		createPanier();

	}

	public static void createPanier() {
		getNumberPerson();	
	}

	public static void getNumberPerson() {
		int numberPerson = getEntry("Veuillez selectionner le nombre de personnes : 2/4/6");
		while (numberPerson != 2 && numberPerson != 4 && numberPerson != 6) {
			numberPerson = getEntry("Veuillez choisir une valeur proposée : 2/4/6");
		}
		builder.setNumberOfPerson(numberPerson);
		getPiqueNique();
	}

	public static void getPiqueNique() {
		afficherPiqueNique();

		int IDPiqueNique = getEntry("Veuillez selectioner le numéro du pique nique");
		PiqueNique picnic = null;

		for (PiqueNique p : piqueniques) {
			if (p.getId() == IDPiqueNique)
				picnic = p;
		}
		if (picnic != null) {
			builder.setPiqueNique(picnic);	
			checkBottle();
		}
		else
			getPiqueNique();
	}

	public static void checkBottle() {
		System.out.println("Souhaitez vous ajouter une bouteille dans votre panier ? O/N");
		String choice = "";

		while (choice.equals("")) {
			choice = scan.nextLine();

			if (!choice.equalsIgnoreCase("o") && !choice.equalsIgnoreCase("n")) {
				System.out.println("Veuillez entrer une instruction valide");
				choice = "";
			}
		}

		if (choice.equalsIgnoreCase("o")) 
			getBottle();	
		else if (choice.equalsIgnoreCase("n")) 
			getMessage();
		else
			System.out.println("normalement impossible");
		
	}

	public static void getBottle() {
		afficherBouteille();
		int IDBouteille = getEntry("Veuillez selectioner le numéro de la bouteille");
		Bouteille bottle = null;

		for (Bouteille b : bottles) {
			if (b.getId() == IDBouteille)
				bottle = b;
		}
		if (bottle != null) {
			builder.setBottle(bottle);	
			getMessage();
		}
		else
			getBottle();
	}

	public static void getMessage() {
		System.out.println("Veuillez entrer votre message personnalisé");
		String msg = scan.nextLine();
		builder.setMessage(msg);
		finalization();
	}

	public static void finalization() {
		builder.setGift();
		System.out.println("\n");
		builder.getPanier().show();
		scan.close();
	}
	
	public static int getEntry(String s) {
		System.out.println(s);

		int entry = -1;

		while(entry == -1) {
			try {
				entry = Integer.parseInt(scan.nextLine());				
			}
			catch(NumberFormatException e) {
				System.out.println("Veuillez entrer un nombre");
			}
		}
		return entry;
	}

	public static void generateBottles() {
		bottles.addBottle((new Bouteille("Bouteille de rosé", 8)));
		bottles.addBottle(new Bouteille("Bouteille de vin blanc", 12.5));
		bottles.addBottle(new Bouteille("Bouteille de vin rouge", 15));
		bottles.addBottle(new Bouteille("Bouteille de champagne", 30));
	}

	public static void generatePiqueNique() {
		piqueniques.add(new PiqueNique("Burgundy", 33.5));
		piqueniques.add(new PiqueNique("Healthy de Jour", 19.9));
		piqueniques.add(new PiqueNique("Frichti", 7));
		piqueniques.add(new PiqueNique("La Maison Nordique", 14.5));
	}

	public static void afficherBouteille() {
		for (Bouteille b : bottles) 
			System.out.println(b);	
	}

	public static void afficherPiqueNique() {
		for (PiqueNique p : piqueniques)
			System.out.println(p);
	}

}
