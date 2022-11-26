//package eksamensoving;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Eksamen {

	public static void main (String[] args) {
		
		//test comment
	
	String s = "Java";
	List<String> spraakliste = Arrays.asList("Java", "C#", "Rust");
	
//	b)
//	i
	Stringfunksjon storebokstaver = String::toUpperCase; //metodereferanse
	skrivUtFormatert(s,storebokstaver); 
		//("hva skal endres", og "hvordan det skal endres")
	
//	ii
	Stringfunksjon innrammet = (s1) -> "["+s1+"]";
	skrivUtFormatert(s,innrammet);
	
//	iii
	Stringfunksjon mellomrom = (s1) -> s1.replaceAll(".(?!$)", "$0 ");
	skrivUtFormatert(s,mellomrom);
	
//	System.out.print(mellomrom.anvend(s));
	
//the thought was that if it returns something, we can just use the object itself at the return type, but we need to run it for that to happen
			//String here is the return type, not param, as it has none									
	Supplier<String> sp = () -> {return "hei"; }; //an object that tells you how things are gonna happen, amazing
	//at this level, sp is not a String, it is a functional interface-implementation,
	//aka just a method;
	//we need to run the method for it to actually return the string
	//give it life, aka make it actually return the thing:
	
	System.out.println(sp.get());
	//man kan ikke bruke oppskriften på boller som en bolle, man må faktisk lage bollen for å bruke den

	
	
	Supplier<Object> sp2 = () -> {return new Object(); }; //hard to read
	Supplier<Object> sp3 = Object::new; //use a constructor reference instead!
	
	Object o1 = sp2.get();
	System.out.println(o1);
	
	Object o2 = sp3.get();
	System.out.println(o2);
	
//	Consumer<String> c2 = System.out::print; 
//	c2.accept("heh");

//	Runnable r = System.out::println; //tom parameterliste funker forsåvidt også
//	r.run();
//	r.run();
//	r.run();
//	r.run();
	
	
//	Runnable r = System.out::print; //no can do
//	r.run();
	
//	c)
	skrivUtFormatert(s,kombiner(storebokstaver, innrammet)); //kan kjøre mellomromm på innrammet
														//	og da vil jo rammene også være med i ordet
														//	så de vil også få mellomrom
	
	
	
	
//	d) i.
	spraakliste.forEach(st-> System.out.print("["+st+"]"));
	
	
//	ii. antar at man ikke får lov til å bruke streams i det hele tatt
	for(String str:spraakliste) {
	skrivUtFormatert(str, innrammet);
	}
	
//	ii hvis man får lov å bruke streams:
	spraakliste.forEach(str2 -> skrivUtFormatert(str2, innrammet));

	
	}
	
	/**
	* Metoden endrer på strengen som kommer inn v.hj.a. Stringfunksjon format,
	* og skriver deretter resultatet ut på skjermen (med System.out.print).
	*/
	private static void skrivUtFormatert(String inn, Stringfunksjon format){
		System.out.print(format.anvend(inn));
	}
	
	
		
		
	
	
//	c)
	private static Stringfunksjon kombiner(Stringfunksjon sf1, Stringfunksjon sf2) {
		return (s) -> sf2.anvend(sf1.anvend(s));
	}
	
	
	//lambdaøving: complete
	
	

	

	
	
	
	
	
	

	
	
}
