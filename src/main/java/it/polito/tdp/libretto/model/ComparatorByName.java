package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Voto> {

	@Override
	public int compare(Voto o1, Voto o2) {
		// è una classe terza confronta due oggetti, non serve più il this
		
		
		return o1.getCorso().compareTo(o2.getCorso());
	}

}
