package eksamensoving;


import java.util.Arrays;
import java.util.List;

public class Eksamen {

	public static void main (String[] args) {
	
	String s = "Java";
	List<String> spraakliste = Arrays.asList("Java", "C#", "Rust");
	
//	b)
	Stringfunksjon storebokstaver = String::toUpperCase; //metodereferanse
	Stringfunksjon innrammet = (s1) -> "["+s1+"]";
	Stringfunksjon mellomrom = (s1) -> s1.replaceAll(".(?!$)", "$0 ");
	
										
												
	skrivUtFormatert(s,storebokstaver); //får feil som sier at p2 er string også(?)..? er det fordi den returnerer string?
	skrivUtFormatert(s,innrammet);
	skrivUtFormatert(s,mellomrom);
	//"hva skal endres", og "hvordan det skal endres"

	
//	c)
	skrivUtFormatert(s,kombiner(mellomrom, innrammet)); //kan kjøre mellomromm på innrammet
														//	og da vil jo rammene også være med i ordet
														//	så de vil også få mellomrom
	
	
	
	
//	d) i.
	spraakliste.forEach(st-> System.out.print("["+st+"]"));
	
	
//	ii. antar at man ikke får lov til å bruke streams i det hele tatt
	for(String str:spraakliste) {
	skrivUtFormatert(str, innrammet);
	}

	
	}
	
	/**
	* Metoden endrer på strengen som kommer inn v.hj.a. Stringfunksjon format,
	* og skriver deretter resultatet ut på skjermen (med System.out.print).
	*/
	private static void skrivUtFormatert(String inn, Stringfunksjon format){
		System.out.print(format.anvend(inn));
	}
	
	
		
		
	
	
	
	private static Stringfunksjon kombiner(Stringfunksjon sf1, Stringfunksjon sf2) {
		return (s) -> sf2.anvend(sf1.anvend(s));
	}
	
	
	//lambdaøving: complete
	
	

	

	
	
	
	
	
	

	
	
}
