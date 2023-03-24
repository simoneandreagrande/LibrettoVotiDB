package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 2", 21, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 3", 22, LocalDate.of(2020, 2, 15)));
		lib.add(new Voto("Informatica", 25, LocalDate.of(2021, 2, 15)));

		// lib.stampaPuntiUguali(29);
		
		Voto v = lib.cercaVotoPerNome("Analisi 1");
		System.out.println(v);
		// System.out.println(v.getPunti()); stampo il voto dell'esame cercato
		v = lib.cercaVotoPerNome("Analisi 2");
		System.out.println(v);
		
		Voto a1bis = new Voto("Analisi 1", 29, LocalDate.of(2025, 12, 12));
		Voto a1ter = new Voto("Analisi 1", 28, LocalDate.of(2025, 12, 12));
		
		
		System.out.println(a1bis+" è duplicato " + lib.esisteVotoDuplicato(a1bis));
		System.out.println(a1ter+" è duplicato " + lib.esisteVotoDuplicato(a1ter));
		
		
		try {
		lib.add(new Voto("Informatica", 25, LocalDate.of(2023, 2, 15)));
		} catch(IllegalArgumentException e) {
			System.out.println("Errore nell'inserimento voto.");
			System.out.println(e.getMessage());
		}
		
		
//		lib.librettoOrdinatoAlfabeticamente().stampa();
	
		System.out.println("LIBRETTO ORIGINARIO: ");
		lib.stampa();
	
		Libretto migliore = lib.librettoMigliorato();
		
		System.out.println("LIBRETTO MIGLIORATO: ");
		migliore.stampa();
		System.out.println("LIBRETTO ORIGINARIO: ");
		lib.stampa();
		
		// dopo questa stampa il libretto originario viene sovrascritto con il libretto migliorato
		// dovrò fare una copia dei singoli elementi, facendo una copia di ogni singolo voto
		
		
//		lib.cancellaVotiInferiori(24);
//		System.out.println("LIBRETTO ORIGINARIO CON PUNTI > 24: ");
//		lib.stampa();
		
		// aggiungendo Fisica 3, con questo metodo, pur essendo di punteggio 22, non viene cancellato
		// problema di indici graviù
		
		// eccezione CurrentModificationException
		// non si sega il ramo su cui sei seduto, se non sai cosa stai facendo
		// lavorando con gli indici, non si ha nessuna protezione e bisogna fare attenzione
		
		// morale da tenere a mente:
		// ogni volta che itero e devo modificare una lista, non fare mai le modifiche dentro il ciclo in cui sto cercando gli elementi
		
		// non modificare la lista su cui si sta iterando
		
		// cosa fare? Creare lista di comodo con gli elementi da cancellare e poi li cancello sulla prima
		// attenzione ad add e remove, mai sulla stessa lista
		
		// si ha un'eccezione oppure un risultato sbagliato
		
		// si crea ambiguità tra gli indici
		
		// non è impossibile fare lavorare bene questo codice, bisogna però ragionarci bene e trovare una soluzione che avrà sempre qualche fragilità
		
		
		System.out.println("PER ORDINE ALFABETICO:");
		lib.librettoOrdinatoAlfabeticamente().stampa();
		
		System.out.println("PER VOTO:");
		lib.librettoOrdinatoPerVoto().stampa();
		
	}


}
