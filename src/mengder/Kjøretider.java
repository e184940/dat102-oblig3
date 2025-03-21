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
		
		
		// I - inneholder()
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
		 * Avg case - O(n), søk gjennom halve mengden
		 * Worst case - O(n), element fins ikke eller er i slutt av mengde
		 * LenketMengde:
		 * Best case - O(1), element er i start av tabell
		 * Avg case - O(n), søk gjennom halve mengden
		 * Worst case - O(n),element fins ikke eller er i slutt av mengde
		 */
		
		
		// II - erDelmengdeAv()
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
		 * Avg case - o(n * m), for hvert element i mengden, må man søke gjennom halve elementene i den andre mengden
		 * Worst case - O(n * m), for hvert n-te element i mengden må man sjekke hvert m-te element i andre mengden
		 * LenketMengde:
		 * Best case - O(1), dersom mengde er tom		 
		 * Avg case - o(n * m), for hvert element i mengden, må man søke gjennom halve elementene i den andre mengden
		 * Worst case - O(n*m), for hvert n-te element i mengden må man sjekke hvert m-te element i andre mengden
		 */
		
		
		// III - erLik()
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
		 * Avg case - O(n * m), for hvert element i mengden, må man søke gjennom halve elementene i den andre mengden
		 * Worst case - O(n * m), må sjekke at hvert element n og m i mengdene er like
		 * LenketMengde:
		 * Best case - O(1), dersom antall element er ulikt
		 * Avg case - O(n * m), for hvert element i mengden, må man søke gjennom halve elementene i den andre mengden
		 * Worst case - O(n * m), må sjekke at hvert element n og m i mengdene er like
		 */
		
		
		// IV - union()
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
		 * Avg case - O(n + m), dersom man legge til alle elementene fra begge mengdene
		 * Worst case - O(n * m), dersom alle overlapper og man må sjekke for duplikater
		 * LenketMengde:
		 * Best case - O(n + m), dersom ingen elementer overlappen
		 * Avg case - O(n + m), dersom man legger til alle elementene fra begge mengdene
		 * Worst case - O(n * m), dersom alle overlapper og man må sjekke for duplikater
		 */
		
		
		// V - fjern()
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
		 * Avg case - O(n), søk gjennom halve tabell
		 * Worst case - O(n), element fins ikke eller er i slutt av tabell
		 * LenketMengde:
		 * Best case - O(1), element er i start av tabell
		 * Avg case - O(n), søk gjennom halve tabell
		 * Worst case - O(n), element fins ikke eller er i slutt av tabell
		 */
	}

}
