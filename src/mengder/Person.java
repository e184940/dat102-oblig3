package mengder;

public class Person {
	
	private String navn;
	private TabellMengde<String> hobbyer;
	
	public Person(String navn, String ... hobbyer) {
		this.hobbyer = new TabellMengde<String>();
		
		for (int i = 0; i < hobbyer.length; i++) {
			this.hobbyer.leggTil(hobbyer[i]);
		}
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return this.navn;
	}
	
	public void setHobby(String hobby) {
		this.hobbyer.leggTil(hobby);
	}
	
	public TabellMengde<String> getHobby() {
		return this.hobbyer;
	}

}
