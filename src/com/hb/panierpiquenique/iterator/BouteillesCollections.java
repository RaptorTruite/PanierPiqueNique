package com.hb.panierpiquenique.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hb.panierpiquenique.model.Bouteille;

public class BouteillesCollections implements Iterator<Bouteille>, Iterable<Bouteille>{
	
	private List<Bouteille> bottles = new ArrayList<>();
	private int offset;

	@Override
	public Iterator<Bouteille> iterator() {
		offset = 0;
		return bottles.iterator();
	}

	@Override
	public boolean hasNext() {
		return offset > bottles.size();
	}

	@Override
	public Bouteille next() {
		return bottles.get(offset++);
	}

	public int size() {
		return bottles.size();
	}
	
	public Bouteille getBottle(int index) {
		return bottles.get(index);
	}
	
	public List<Bouteille> getBottles(){
		return bottles;
	}
	
	public void addBottle(Bouteille b) {
		bottles.add(b);
	}
}
