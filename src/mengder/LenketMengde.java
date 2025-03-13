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
			// her sjekkes om element er i mengden
			if (element.equals(aktiv.data)) {
				funnet = true;
			} else {
				aktiv = aktiv.neste;
			}
		}
		return funnet;
	}

	
	// TODO !!!
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		Node aktiv = forste;
		
		// itererer gjennom alle element i mengden
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
		// sjekker om antall element er like
		if (antall != annenMengde.antallElementer()) {
			return false;
		}
		// dersomm de er like, og er delmengde av annenMengde, så er de like
		return erDelmengdeAv(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		Node aktiv = forste;
		
		while (aktiv != null) {
			// sjekker om det er element som er i begge menggder
			if (annenMengde.inneholder(aktiv.data)) {
				// ikke disjunkt dersom det fins
				return false;
			}
			aktiv = aktiv.neste;
		}
		// ellers er mengdene det
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		// oppretter ny mengde for snittet mellom mengdene
		LenketMengde<T> snittMengde = new LenketMengde<>();
		Node aktiv = forste;
		
		while (aktiv != null) {
			// legger til element dersom det fins i begge mengder
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
			// legger til alle elelment  i unionmengden
			unionMengde.leggTil(aktiv.data);
			aktiv = aktiv.neste;
		}
		
		// henter ut element fra annenMengde i tabbel
		T[] annenTabell = annenMengde.tilTabell();
		for (T element : annenTabell) {
			// legger til element fra første mengden til den nye
			unionMengde.leggTil(element);
		}
		return unionMengde;
		
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		LenketMengde<T> minusMengde = new LenketMengde<>();
		Node aktiv = forste;
		
		while(aktiv != null) {
			// legger til element som ikke finns i annenMengde
			if (!annenMengde.inneholder(aktiv.data)) {
				// inn i minusMengden
				minusMengde.leggTil(aktiv.data);
			}
			aktiv = aktiv.neste;
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		// om et element ikke finns fra før
		if (!inneholder((element))) {
			// oprette ny node me elementet
			Node ny = new Node(element);
			// setter ny node sin nestereferanse til å peke på første 
			ny.neste = forste;
			// oppdaterer forste nodes referanse til den ny noden
			forste = ny;
			// øker antall element
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		// henter ut element fra annenMengde i form av en tabell
		T[] annenTabell = annenMengde.tilTabell();
		// legger til alle element i annenMegde
		for (T element : annenTabell) {
			leggTil(element);
		}
	}

	
	// TODO !!!
	@Override
	public T fjern(T element) {
		// lagrer referanse til elelment som slettes
		T fjernetElement = null;
		if (forste != null) {
			// henter data fra første element
			fjernetElement = forste.data;
			// oddtarerer referansen til første, til neste node
			forste = forste.neste;
			//reduserer antall element
			antall--;
		}
		return fjernetElement;
	}

	
	// TODO !!!
	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		// oppretter tabell for å lagre element
		T[] tabell = (T[]) new Object[antall];
		Node aktiv = forste;
		int indx = 0;
		
		// itererer gjennom alle noder
		while (aktiv != null) {
			// legger til data fra noder i tabell
			tabell[indx] = aktiv.data;
			aktiv = aktiv.neste;
			indx++;
		}
		return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}


}
