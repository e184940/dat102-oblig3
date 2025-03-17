package mengder;

public class HobbyMatchMain {

	public static void main(String[] args) {
		Person åse = new Person("Åse", "Fiske", "TikTok", "GPT");
		Person per = new Person("Per", "Fiske", "Kjefte", "Danse");
		Person asle = new Person("Asle", "Trene", "TikTok", "GPT");
		
		System.out.println(match(åse, asle));
		System.out.println(match(åse, per));
		System.out.println(match(per, asle));
		System.out.println(match(asle, asle));
		
		// sjekke om p1 og p2 gir samme score
		System.out.println("De her skal gi samme score:");
		System.out.println(match(åse, per));
		System.out.println(match(per, åse));
		
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
