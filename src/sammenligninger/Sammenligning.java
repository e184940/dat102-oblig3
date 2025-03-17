package sammenligninger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Sammenligning {
	
	private static final int ANTALLELEMENT = 100_000;
	private static final int ANTALLSØK = 10_000;
	private static final int ØVREGRENSE = 999_999;

	public static void main(String[] args) {
		
		int[] tabell = new int[ANTALLELEMENT];
		HashSet<Integer> hash = new HashSet<>(ANTALLELEMENT, 1.0f);
		
		int tall = 376;
		for (int i = 0; i < ANTALLELEMENT; i++) {
			tabell[i] = tall;
			hash.add(tall);
			tall = (tall + 45713) % 100_000;
		}
		
		Arrays.sort(tabell);
		
//		for(int i = 0; i < 4; i++) {
//			System.out.println(tabell[i]);
//		}
		
		int[] tabellTreff = new int[ANTALLSØK];
		Random random = new Random();
		
		long startTid = System.nanoTime();
		
		for (int i = 0; i < ANTALLSØK; i++) {
			Arrays.binarySearch(tabellTreff, random.nextInt(ØVREGRENSE));
		}			
		System.out.println();

		
		long sluttTid = System.nanoTime();
		System.out.println("Binærsøk tid: " + (sluttTid-startTid) + " ns");
		
		long startTid2 = System.nanoTime();
		
		int hashTreff = 0;
		
		for (int i = 0; i < ANTALLSØK; i++) {
			if (hash.contains(random.nextInt(ØVREGRENSE))) {
				hashTreff++;
			}
		}
		System.out.println(hashTreff);
		long sluttTid2 = System.nanoTime();
		System.out.println("Contains søk tid: " + (sluttTid2-startTid2) + " ns");

	}
	
	
	
}
