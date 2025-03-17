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
		System.out.println("Asle er perfekt match for Asle");
		System.out.println(match(asle, asle));
		
		// Asle og Åse har to hobbyer til felles
		System.out.println("Åse og Asle har to hobbyer til felles: ");
		System.out.println(match(asle, åse));
		
	}
	
	private static int antallFelles(Person a, Person b) {
		//System.out.println("Antall felles er: " + (a.getHobby().snitt(b.getHobby())).antallElementer());
		return (a.getHobby().snitt(b.getHobby())).antallElementer();
	}
	
	private static int antallUnik(Person a, Person b) {
		//System.out.println("Antall Unik: " + (a.getHobby().minus(b.getHobby())).antallElementer());
		return (a.getHobby().minus(b.getHobby())).antallElementer();
	}
	
	private static int antallTotal(Person a, Person b) {
		//System.out.println(a.getHobby().antallElementer() + b.getHobby().antallElementer());
		return (a.getHobby().antallElementer() + b.getHobby().antallElementer());
	}
	
	private static double match(Person a, Person b) {
		double match = (antallFelles(a, b) - antallUnik(a, b) + antallUnik(b, a) / antallTotal(a, b));
		return match;
	}

}
