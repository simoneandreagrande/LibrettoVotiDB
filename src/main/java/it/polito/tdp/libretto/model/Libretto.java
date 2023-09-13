// E' IL NOSTRO MODELLO CHE CONTIENE LE OPERAZIONE E I DATI, QUESTA CLASSE GESTISCE TUTTO


package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Libretto {

	private List<Voto> voti; // ovunque possibile usare interfaccia, la classe non sa che tipo di lista
								// concreta stiamo usando

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}

	/**
	 * Aggiungi un nuovo voto al libretto (per ora non fa nessun controllo)
	 * 
	 * @param v il Voto da aggiungere
	 * @return true
	 */

	// la classe libretto incapsula una lista non rendnendola visibile all'esterno,
	// perchè all'esterno ci servono solo alcune operazioni su questa list
	// creare una classe libretto per gestire una lista di voti

	// metodo add per l'inserimento dei voti

	public boolean add(Voto v) {
		// public void add(String corso, int punti, LocalDate data) non va bene perchè
		// modificando la classe Voto in futuro è più semplice da lavorare nel primo
		// caso
		
		// prima di aggiungere un voto verfico se non si verifica nessuna delle due condizioni sotto
		if (this.esisteVotoConflitto(v) || this.esisteVotoDuplicato(v) ) { // vera se esiste almeno un corso con lo stesso nome, i
			// non aggiungere voto, cosa faccio
//			System.out.println("Voto errato"); questo non è completo, non arriva all'utente questa informazione

			// primo metodo, ragioniamo sul valore di ritorno
			throw new IllegalArgumentException("Voto errato: " + v);
			// oppure ritorno un valore nulla
		
		}
		return this.voti.add(v); // ritorna un valore boolean che è sempre vero
	}

	public String toString() {
		String txt = "";
		for (Voto v : this.voti) {
			txt = txt + v.toString() + "\n";
		}
		return txt;
	}
	
	public void stampa() {
		for (Voto v : this.voti) {
			System.out.println(v);
		}
	}

	public void stampaPuntiUguali(int valore) {
		for (Voto v : this.voti) {
			if (v.getPunti() == valore) {
				System.out.println(v);
			}
		}

	}
	
	public Voto cercaVotoPerNome(String corso) {
		for (Voto v : this.voti) {
			// if (v.getCorso().compareTo(corso)==0) { // uso compareTo() o equals() per conforntare oggetti e == per i numeri
			if (v.getCorso().equals(corso)) { // uso compareTo() o equals() per conforntare oggetti e == per i numeri
				return v;
			}
		}
		return null;
		
		// throw new RuntimeException("Voto non trovato");

	}
	
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for(Voto v: this.voti) {
			// if(v.equalsCorsoPunti(nuovo)) {
//			if(v.getCorso().equals(nuovo.getCorso()) &&
//					v.getPunti() == nuovo.getPunti())
//			{
//				return true;
//			}
			// delego un metodo equalsCorsoPunti oppure confronto le singole voci nella classe voto
			
			if(v.isDuplicato(nuovo))
				return true;
		
		}
		return false;
	}

	
	public boolean esisteVotoConflitto(Voto nuovo) {
		for(Voto v: this.voti) {
//			if(v.getCorso().equals(nuovo.getCorso()) &&
//					v.getPunti() != nuovo.getPunti())
//			{ // stesso nome corso e punti diversi
//				return true;
//			}
			if(v.isConflitto(nuovo))
				return true;
		}
		return false;
	}
	
	
	
	
	// creo un nuovo metodo che duplichi il libretto esistento e modifichi il duplicato
	
	/**
	 * Metodo 'factory' che mi aiuta a creare ub oggetto nuovo con certe caratteristiche, con certi dati che dipendono di volta in volta 
	 * perchè il chiamante non ha tutte le informazioni per poterlo creare come serve, ossia con i voti migliorati
	 * 
	 * @return
	 */
	public Libretto librettoMigliorato() {
		
		Libretto migliore = new Libretto();
		// migliore.voti = this.voti; non va bene perchè avrei milgiore e voti che sono due libretti diversi ma che condividono la stessa lista di voti
		migliore.voti = new ArrayList<>(); // due libretti, ciascun libretto con una nuova lista. E' una nuova lista.
		// creo un nuovo libretto che è fatto a sua volta
		// una nuova lista, che è fatta di oggetti tutti nuovi, che saranno inizialmente copie identiche di ciò che avevo già prims
		for(Voto v: this.voti) {
//			migliore.voti.add(v.clone()); // è più chiaro, creo una nuova lista con i cloni degli oggetti esistenti
//			migliore.voti.add(new Voto(
//					v.getCorso(), v.getPunti(), v.getDataEsame()
//					));
			migliore.voti.add(new Voto(v)); // creo un nuovo oggetto e lo inizializzo con il costruttore copia
		}
		for(Voto v : migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		return migliore;
	}
	
	
	
	public void cancellaVotiInferiori(int punti) {
//		scandiamo lista voti, se troviamo un voto minore di 'punti' allora lo cancelliamo
		List<Voto> daCancellare = new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getPunti()<punti) {
				daCancellare.add(v); // rimuove il primo elemento, se compare pià volte nella lista compare solo il primo
			}
		}
		// dentro le parentesi graffe la lista voti non si modifica, sto aggiungendo ad un'altra list agli elementi che voglio cancellare
		
//		for(Voto v1: daCancellare) {
//			this.voti.remove(v1);
//		}
		// itero su daCancellare e daCancellare non viene modificata
		
		// forma più compatta migliore, metodo più di alto livello che lavora sulla collection anzichè sul singolo elemento
		this.voti.removeAll(daCancellare);
		
//		for(int i=0; i<this.voti.size(); i++) {
//			if(this.voti.get(i).getPunti()<punti) {
//				this.voti.remove(i);
//			}
//		}
		
		
//		per risolvere questi problemi, una soluzione generale:
//		separo le operaizoni di 
//		a) cpaire quali elementi cancellare
//		b) cancello
	}
	
	
	
	// public List<Voto>getVoti() {
	// return this.voti;
	// }

	// metodo getVoti alla classe libretto così la classe TestLibretto può prendersi
	// la lista voti e lo stampa lei, ma è meglio controllare l
	
	
	// creao un clone libretto ordinato alfabeticamente
	
	public Libretto librettoOrdinatoAlfabeticamente() {
		// simile al metodo librettoMigliorato, che clona la lista dei voti contenuti nella lista
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new ComparatorByName()); // definizione di un criterio di ordinamento, come tutti gli oggetti di tipo lista, vi è un metodo sort()
		// Collections.sort(ordinato.voti, new ComparatorByName()); // l'errore è lo stesso in entrambi i casi
		
		
		// N.B. non dimenticarsi new perchè noi definiamo classe ma dobbiamo passare un oggetto
		// In Java non esistono funzioni che siano al di fuori delle classi, bisogna fare un'istanza di quella classe che andiamo a creare
		
	
		return ordinato;

	}
	
	
	
	
	public Libretto librettoOrdinatoPerVoto() {
		// simile al metodo librettoMigliorato
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);

		// fornisco il nome di un'interfaccia, non di una classe
		ordinato.voti.sort(new Comparator<Voto>() {
		//due parentesi, parentesi graffe come inline, dentro una parentesi di una chioamata al sort sto creando un'altra classe
		// con new sto chiamando un costruttore
		
		@Override
		public int compare(Voto o1, Voto o2) {
			return o2.getPunti()-o1.getPunti(); // ordinamento decrescente
		}
		
		});
	
		return ordinato;
	}	
}
