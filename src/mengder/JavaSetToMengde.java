package mengder;

import java.util.HashSet;
import java.util.Set;

import mengder.LenketMengde.Node;

public class JavaSetToMengde<T> implements MengdeADT<T> {
	
	private Set<T> mengde;
	int antall;
	
	public JavaSetToMengde() {
		mengde = new HashSet<>();
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		return mengde.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		// itererer gjennom hvert element i mengden
		for(T element : mengde) {
			// returnerer false dersom ingen element fra mengde er i annenMengde
			if (!annenMengde.inneholder(element)) {
				return false;
			}
		}
		// returnerer true dersom de er det
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (antall != annenMengde.antallElementer()) {
			return false;
		}
		return erDelmengdeAv(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		// itererer for å sjekke om det er like element
		for (T element : mengde) {
			// false siden den ikke er disjunkt hvis det er fellleselementer
			if (annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> snittMengde = new JavaSetToMengde<>();
		// itererer gjennom mengden
		for (T element : mengde) {
			// legger til hvert element felles for mengdene
			if(annenMengde.inneholder(element)) {
				snittMengde.leggTil(element);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> unionMengde = new JavaSetToMengde<>();
		// legger til alle element fra første mengde -
		for (T element : mengde) {
			// - i unionMengden
			unionMengde.leggTil(element);
		}
		
		// henter ut element fra annenmengde som tabell
		T[] annenTabell = annenMengde.tilTabell();
		for (T element : annenTabell) {
			// legger til element fra annenmengde til unionmengden
			unionMengde.leggTil(element);
		}
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> minusMengde = new JavaSetToMengde<>();
		
		for (T element : mengde) {
			// dersom et element i mengde ikke finns i annemengde
			if(!annenMengde.inneholder(element)) {
				// legges det til i diferansemengdenn
				minusMengde.leggTil(element);
			}
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		// legger til element i mengden
		if (mengde.add(element)) {
			//  og øker antall dersom det ble lagt til
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		// henter ut element fra annenMengde i form av en tabell
		T[] annenTabell = annenMengde.tilTabell();
		// legger til alle element fra første mengde til annenMegde
		for (T element : annenTabell) {
			leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
		// fjerner element fra mengde
		if (mengde.remove(element)) {
			// reduserer antall
			antall--;
			// returnerer det slettede element
			return element;
		}
		return null;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		// oppretter tabell for å lagre element
		T[] tabell = (T[]) new Object[mengde.size()];
		int indx = 0;
		
		//itererer gjennom mengde
		for (T element : mengde) {
			// legger til hvert element til tilsvarende index i tabell
			tabell[indx] = element;
			indx++;
		}
		return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}
	

}
