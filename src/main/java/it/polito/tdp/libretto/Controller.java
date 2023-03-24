package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;

public class Controller { // controller non deve mai fare la new del modello, la new la fa il main e il controller riceve le informazioni

	// controller non deve fare mai la new del modello
	private Libretto model;

	public void setModel(Libretto model) {
		this.model = model;
	}
}
