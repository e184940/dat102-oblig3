package mengder;

public class HobbyMatchMain {

	public static void main(String[] args) {
		Person åse = new Person("Åse", "Fiske", "TikTok", "GPT");
		Person per = new Person("Per", "Brus", "Kjefte", "Danse"); // Denne har ingen til felles med noen
		Person asle = new Person("Asle", "Trene", "TikTok", "GPT");
		
		System.out.println("Tester match formel:");
		
		// sjekke om p1 og p2 gir samme score
		System.out.println("De her skal gi samme score:");
		System.out.println(match(åse, per));
		System.out.println(match(per, åse));
		
		// Asle er perfekt match for Asle
		System.out.println("Asle er perfekt match for Asle:");
		System.out.println(match(asle, asle));
		
		// Asle og Åse har to hobbyer til felles
		System.out.println("Åse og Asle har to hobbyer til felles: ");
		System.out.println(match(asle, åse));
		
	}
	
	private static int antallFelles(Person a, Person b) {
		return (a.getHobby().snitt(b.getHobby())).antallElementer();
	}
	
	private static int antallUnik(Person a, Person b) {
		return (a.getHobby().minus(b.getHobby())).antallElementer();
	}

	
	private static int antallTotal(Person a, Person b) {
	    return a.getHobby().union(b.getHobby()).antallElementer();
	}
	
	private static double match(Person a, Person b) {
	    double felles = antallFelles(a, b);
	    double unikA = antallUnik(a, b);
	    double unikB = antallUnik(b, a);
	    double totalt = antallTotal(a, b);

	    return felles - ((unikA + unikB) / totalt);
	}

}
