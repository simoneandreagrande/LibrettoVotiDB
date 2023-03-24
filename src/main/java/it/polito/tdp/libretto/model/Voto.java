package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto implements Comparable<Voto> {
	
	private String corso;
	private int punti; // voto dell'esame da 18 a 31
	private LocalDate dataEsame;
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	
	
	
	// costruisco un altro costruttore che prenda come parametro un altro oggetto voto
	// costruisco un voto prendendo da un voto esistente
	
	/**
	 * Copy constructor di voto
	 * @param v
	 */
	
	public Voto(Voto v) {
		this.corso = v.corso; // oppure v.corso.clone? Nel caso di una string anon serve, per un oggetto complesso sì
		this.punti = v.punti;
		this.dataEsame = v.dataEsame;
		
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	
	public boolean isDuplicato(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) &&
			this.getPunti() == altro.getPunti();
			// ritorna true se è uguale il nome e contemporaneamente sono uguali i punti
	}
	
	
	
	public boolean isConflitto(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) &&
			this.getPunti() != altro.getPunti();
			// ritorna true se è uguale il nome e contemporaneamente i punti sono diversi
	}
	
	
	/**
	 * metodo che costruisce esso stesso un nuovo oggetto copiando i dati dell'oggetto esistente,
	 * e lui sapra se a sua volta fare una reference o un clone degli oggetti nel suo contenuto
	 */
	public Voto clone() {
		return new Voto(this.corso, this.punti, this.dataEsame);
	}
	
	

	@Override
	public String toString() {
		return corso + " (" + punti + " pt) il " + dataEsame;
	}
	
	
	@Override
	public int compareTo(Voto other) {
		// TODO calcola this - other (differenza) in base all'antecedenza o alla susseguenza di this rispetto ad other
		// confronta this con other e restituisce un valore positivo, nullo o negativo
		return 0;
	}
	
	
	
	
	

}
