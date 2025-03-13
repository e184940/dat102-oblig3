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
		
		
		// i
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
		
		// ii
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
		
		// iii
		System.out.println("erLik(): ");
		startTid = System.nanoTime();
		Lmengde1.erLik(Lmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for LenketMengde: " + (sluttTid - startTid) + " nanosekunder");

		startTid = System.nanoTime();
		Tmengde1.erLik(Tmengde2);
		sluttTid = System.nanoTime();
		
		System.out.println("Kjøretid for tabellMengde: " + (sluttTid - startTid) + " nanosekunder");
		System.out.println();
	}

}
