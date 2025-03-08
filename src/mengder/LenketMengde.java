package mengder;

public class LenketMengde<T> implements MengdeADT<T> {	
	
	// definerer en indre klasse for Node
	class Node {
		T data;
		Node neste;
		
		// konstrukør for Node klassen
		public Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}
	
	// referanse til første node, samt variabel for antall element
	private Node forste;
	private int antall;
	
	// kontruktør for en lenket mengde med noder
	public LenketMengde() {
		forste = null;  
		antall = 0;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		// startet med at element ikke er funnet
		boolean funnet = false;
		Node aktiv = forste;
		
		// itererer gjennom mengden helt til element er funnet
		while (!funnet && (aktiv != null)) {
			if (element.equals(aktiv.data)) {
				funnet = true;
			} else {
				aktiv = aktiv.neste;
			}
		}
		return funnet;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		Node aktiv = forste;
		
		while (aktiv != null) {
			// sjekker at alle element er  i begge mengder
			if (!annenMengde.inneholder(aktiv.data)) {
				return false;
			} else {
				aktiv = aktiv.neste;
			}
		}
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
		Node aktiv = forste;
		
		while (aktiv != null) {
			if (annenMengde.inneholder(aktiv.data)) {
				return false;
			}
			aktiv = aktiv.neste;
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		LenketMengde<T> snittMengde = new LenketMengde<>();
		Node aktiv = forste;
		
		while (aktiv != null) {
			if (annenMengde.inneholder(aktiv.data)) {
				snittMengde.leggTil(aktiv.data);
			}
			aktiv = aktiv.neste;
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		LenketMengde<T> unionMengde = new LenketMengde<>();
		Node aktiv = forste;
		
		while(aktiv != null) {
			unionMengde.leggTil(aktiv.data);
			aktiv = aktiv.neste;
		}
		
		T[] annenTabell = annenMengde.tilTabell();
		for (T element : annenTabell) {
			unionMengde.leggTil(element);
		}
		return unionMengde;
		
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		LenketMengde<T> minusMengde = new LenketMengde<>();
		Node aktiv = forste;
		
		while(aktiv != null) {
			if (!annenMengde.inneholder(aktiv.data)) {
				minusMengde.leggTil(aktiv.data);
			}
			aktiv = aktiv.neste;
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder((element))) {
			Node ny = new Node(element);
			ny.neste = forste;
			forste = ny;
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		T[] annenTabell = annenMengde.tilTabell();
		for (T element : annenTabell) {
			leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
		T fjernetElement = null;
		if (forste != null) {
			fjernetElement = forste.data;
			forste = forste.neste;
			antall--;
		}
		return fjernetElement;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] tabell = (T[]) new Object[antall];
		Node aktiv = forste;
		
		while (aktiv != null) {
			tabell[antall] = aktiv.data;
			aktiv = aktiv.neste;
			antall++;
		}
		return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}


}
