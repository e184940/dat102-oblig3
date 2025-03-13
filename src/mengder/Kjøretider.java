package mengder;

public class Kjøretider {

	public static void main(String[] args) {
		LenketMengde<Integer> Lmengde1 = new LenketMengde<>();
		LenketMengde<Integer> Lmengde2 = new LenketMengde<>();

		TabellMengde<Integer> Tmengde1 = new TabellMengde<>();
		TabellMengde<Integer> Tmengde2 = new TabellMengde<>();

		
		for (int i = 0; i < 1000; i++) {
			Lmengde1.leggTil(i);
			Tmengde1.leggTil(i);
			Lmengde2.leggTil(i + 200);
			Tmengde2.leggTil(i + 200);
		}
		
		long startTid;
		long sluttTid; 
		
		
		// I
		System.out.println("inneholder(): ");
		startTid = System.nanoTime();
		Lmengde1.inneholder(500);
		sluttTid = System.nanoTime();	
		
		System.out.println("Kjøretid for LenketMengde: " + (sluttTid - startTid) + " nanosekund");
		
		startTid = System.nanoTime();
		Tmengde1.inneholder(500);
		sluttTid = System.nanoTime();

		System.out.println("Kjøretid for TabellMengde: " + (sluttTid - startTid) + " nanosekund");
		System.out.println();
		
		/*
		 * TabellMengde: 
		 * Best case - O(1), element er i start av tabell
		 * Worst case - O(n),element fins ikke eller er i slutt av tabell
		 * LenketMengde:
		 * Best case - O(1), element er i start av tabell
		 * Worst case - O(n),element fins ikke eller er i slutt av tabell
		 */
		
		// II
		System.out.println("erDelmengdeAv(): ");
		startTid = System.nanoTime();
		Lmengde1.erDelmengdeAv(Lmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for LenketMengde: " + (sluttTid - startTid) + " nanosekunder");
		
		startTid = System.nanoTime();
		Tmengde1.erDelmengdeAv(Tmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for TabellMengde: " + (sluttTid - startTid) + " nanosekunder");
		System.out.println();
		
		/*
		 * TabellMengde:
		 * Best case - O(1), dersom mengde er tom
		 * Worst case - O(n * m), for hvert n-te element i mengden må man sjekke hvert m-te element i andre mengden
		 * LenketMengde:
		 * Best case - O(1), dersom mengde er tom
		 * Worst case - O(n*m), for hvert n-te element i mengden må man sjekke hvert m-te element i andre mengden
		 */
		
		// III
		System.out.println("erLik(): ");
		startTid = System.nanoTime();
		Lmengde1.erLik(Lmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for LenketMengde: " + (sluttTid - startTid) + " nanosekunder");

		startTid = System.nanoTime();
		Tmengde1.erLik(Tmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for TabellMengde: " + (sluttTid - startTid) + " nanosekunder");
		System.out.println();
		
		/*
		 * TabellMengde:
		 * Best case - O(1), dersom antall element er ulikt
		 * Worst case - O(n * m), må sjekke at hvert element n og m i mengdene er like
		 * LenketMengde:
		 * Best case - O(1), dersom antall element er ulikt
		 * Worst case - O(n * m), må sjekke at hvert element n og m i mengdene er like
		 */
		
		// IV
		System.out.println("union(): ");
		startTid = System.nanoTime();
		Lmengde1.union(Lmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for LenketMengde: " + (sluttTid - startTid) + " nanosekunder");
		
		startTid = System.nanoTime();
		Tmengde1.union(Tmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for TabellMengde: " + (sluttTid - startTid) + " nanosekunder");
		System.out.println();
		
		/*
		 * TabellMengde: 
		 * Best case - O(n + m), dersom ingen elementer overlappen
		 * Worst case - O(n * m), dersom alle overlapper og man må sjekke for duplikater
		 * LenketMengde:
		 * Best case - O(n + m), dersom ingen elementer overlappen
		 * Worst case - O(n * m), dersom alle overlapper og man må sjekke for duplikater
		 */
		
		// V
		System.out.println("fjern(): ");
		startTid = System.nanoTime();
		Lmengde1.fjern(700);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for LenketMengde: " + (sluttTid - startTid) + " nanosekunder");
		
		startTid = System.nanoTime();
		Tmengde1.fjern(700);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for TabellMengde: " + (sluttTid - startTid) + " nanosekunder");
		System.out.println();
		
		/*
		 * TabellMengde:
		 * Best case - O(1), element er i start av tabell
		 * Worst case - O(n),element fins ikke eller er i slutt av tabell
		 * LenketMengde:
		 * Best case - O(1), element er i start av tabell
		 * Worst case - O(n),element fins ikke eller er i slutt av tabell
		 */
	}

}
