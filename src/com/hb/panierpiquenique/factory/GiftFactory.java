package com.hb.panierpiquenique.factory;

import java.util.Random;

import com.hb.panierpiquenique.model.CouvertsBambou;
import com.hb.panierpiquenique.model.Gift;
import com.hb.panierpiquenique.model.Nappe;
import com.hb.panierpiquenique.model.PanierOsier;

public final class GiftFactory {
	
	private static GiftFactory instance = null;
	
	private GiftFactory() {
	}
	
	public static GiftFactory getInstance() {
		if (instance == null) {
			synchronized (GiftFactory.class) {
				if (instance == null) {
					instance = new GiftFactory();
				}
			}
		}
		return instance;
	}

	public Gift getGift() {
		Random random = new Random();
		int r = random.nextInt(3);
		
		switch (r) {
			case 0:
			{
				return new PanierOsier();
			}
			case 1:
			{
				return new CouvertsBambou();
			}
			case 2:
			{
				return new Nappe();
			}
			default :
				System.out.println("problem");
		}
		return null;
	}
}
