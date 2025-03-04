package mengder;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T>{
	
	// definerer standardkapasiteten til tabellen
	private static final int KAPASISTET = 100;
	// deklarerer en generiak array-tabell for lagring av element
	private T[] tabell;
	// deklarerer en variabel for å holde styr på antall element i tab
	private int antall;
	
	// undertrykker advarsler om ukontrollert typekonvertering
	@SuppressWarnings("unchecked")
	// kontruktør, intialiserer tabell med sstandarkapasitet, og setter antall lik 0
	public TabellMengde() {
		tabell = (T[]) new Object[KAPASISTET];
		antall = 0;
	}
	
	// metode for å utvide kapasiteten til tabell dersom den blir full
	@SuppressWarnings("unchecked")
	private void utvidKapasitet() {
		// opretter ny array med dobbelt så stor plass
		T[] nyTabell = (T[]) new Object[tabell.length * 2];
		// kopierer innhold over til ny utvidet tabell
		System.arraycopy(tabell, 0, nyTabell, 0, antall);
		tabell = nyTabell;
	}
	
	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		// itererer gjennom alle element i tabell
		for (int i = 0; i < antall; i++) {
			// sjekker om element fins
			if (tabell[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++){
			// sjekker om ALLE element i tabell og er i annenMengde
			if(!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		// sjekker om antall element er like
		if (antall != annenMengde.antallElementer()) {
			return false;
		}
		// dersomm de er like, og er delmengde av annenMengde, så er de like
		return erDelmengdeAv(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			// sjekker om det er element som er i begge mengder
			if (annenMengde.inneholder(tabell[i])) {
				// dersom det er, så er de ikke disjunkt
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		// oppretter ny mengde for snitt melllom mengdene
		TabellMengde<T> snittMengde = new TabellMengde<>();
		for (int i = 0; i < antall; i++) {
			// ser gjennom element, og legger det til dersom det er i begge
			if(annenMengde.inneholder(tabell[i])) {
				snittMengde.leggTil(tabell[i]);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		TabellMengde<T> unionMengde = new TabellMengde<>();
		for(int i = 0; i < antall; i++) {
			// legger til alle element i union tabellen
			unionMengde.leggTil(tabell[i]);
		}
		// henter ut element fra annenMengde i form av en tabell
		T[] annenTabell = annenMengde.tilTabell();
		for(T element : annenTabell) {
			// legger til element fra første mengde til den nye
			unionMengde.leggTil(element);
		}
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		TabellMengde<T> minusMengde = new TabellMengde<>();
		for (int i = 0; i < antall; i++) {
			// dersom ett element ikke finns i annenMengde -
			if(!annenMengde.inneholder(tabell[i])) {
				// - legges det til i minusMengden
				minusMengde.leggTil(tabell[i]);
			}
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		// sjekker om element allerede fins
		if(!inneholder(element)) {
			// utvider tabell dersom den er full
			if(antall == tabell.length) {
				utvidKapasitet();
			}
			// legger til element, og øker antall
			tabell[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		// henter ut element fra annenMengde i form av en tabell
		T[] annenTabell = annenMengde.tilTabell();
		// legger til alle element i annenMengde
		for(T element : annenTabell) {
			leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
		for (int i = 0; i < antall; i++) {
			if(tabell[i].equals(element)) {
				// lagrer element før sletting
				T fjernetElement = tabell[i];
				// flytter siste element til den ledig plassen
				tabell[i] = tabell[antall - 1];
				// fjerner siste element, og reduserer antall
				tabell[antall - 1] = null;
				antall--;
				return fjernetElement;
			}
		}
		return null;
	}

	@Override
	public T[] tilTabell() {
		return Arrays.copyOf(tabell, antall);
	}

	@Override
	public int antallElementer() {
		return antall;
	}
	
}
