package nur.nicht.ohne;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Beispiele für Exceptions:  (Runtime-Exceptions)
 * java.lang.NullPointerException
 * java.lang.ArrayIndexOutOfBoundsException
 * java.lang.NumberFormatException
 * java.lang.ArithmeticException
 * java.time.DateTimeException:
 * throw: Löst eine Exception aus
 * 
 * Zwei Typen von Exception: Runtime-Exception: Unchecked: Fehler des Programmieres
 * 		Checked-Exceptions: Situationen, auf die der Programmierer keinen direkten Einfluss hat,
 * 					die aber trotzdem geplant werden: try/catch behandelt
 * 
 * 4 neue Schlüsselwörter: throw, throws, try, catch
 * 
 *
 */
public class AunahmenMuessenSein {

	public static void main(String[] args) throws PumucklException {
		System.out.println("Anfang\n");
		String[] texte = new String[1];
		System.out.println( texte[0] == null ?"NICHTS DRIN" : texte[0].toUpperCase()); 
		int index = 1;
		if(index < texte.length) {
			texte[index] = "Ausnahme";
		}
		texte[0] = "Eins";
//		int zahl = Integer.parseInt(texte[0]);
		int bruch;
		int zaehler = 1;
		int nenner = 0;
//		bruch = zaehler / nenner;
//		LocalDate einGanzBesonderesDatum = LocalDate.of(2022, 10, 32);
		int zahl1 = 100_000;
		int zahl2 = 100_100_100;
		try {
		     System.out.println("Produkt ist: " + multiplizieren(zahl1, zahl2));
		} catch(NumberFormatException ausnahme) {
			System.out.println("Auffangen von Runtime-Exceptions ist nicht gewünscht aber möglich");
			ausnahme.printStackTrace();
		}
			
		
		try {
			System.out.println("VOR Methoden-Aufruf");
			checkenAufPause();
			System.out.println("NACH Methoden-Aufruf: Nur sichtbar in den Pausen!");
		} catch (InterruptedException e) {
			System.out.println("Nur noch kurz warten, gleich gibt es frischen Kaffee");
		}
		
		//Handle Or Declare Rule
		//throws an der main möglich aber BÖSE!!!!!
		keinenUnsinnMachen("Pumuckl räumt auf");
		
		System.out.println("\nEnde");
	}
	
	
	/**
	 * Löst die eigene Exception Pumuckl-Exception ais
	 * @param aktion
	 * @throws PumucklException
	 */
	public static void keinenUnsinnMachen(String aktion) throws PumucklException {
		if(aktion.contains("Pumuckl")) {
			throw new PumucklException();
		}
		
		System.out.println("Das möchte ich heute tun: " + aktion);
	}
	
	/**
	 * Ein Exception die keine Erweiterung von Runtime-Exception ist: Checked Exception
	 * Wenn ein Checked Exception ausgelöst wird (throw): Handle Or Declare Rule
	 * 1. Möglichkeit: Handle: try/catch
	 * 2. Möglichkeit: Declare: throws an Methoden-Signatur/Kopf
	 * 
	 * ...|| LocalTime.of(10, 0).plusMinutes(15).isBefore(LocalTime.now())
	 * 
	 * @throws InterruptedException wenn die Methode außerhalb der Pausenzeiten aufgerufen wird
	 */
	public static void checkenAufPause() throws InterruptedException{
		
		if(LocalTime.now().isBefore(LocalTime.of(10, 0)) || LocalTime.of(10, 0).plusMinutes(15).isBefore(LocalTime.now())) {
			throw new InterruptedException("Ist noch keine Pause");
		}
		
		System.out.println("Jetzt ist Pause");
	}
	
	public static int multiplizieren(int eins, int zwei) {
		int maxInt = Integer.MAX_VALUE;
		int rest = maxInt / eins;
		if(zwei > rest) {
			throw new NumberFormatException("Wert " + eins + " und der Wert " + zwei 
					+ " können nicht im Wertebereich des Integers multipliziert werden");
		}
		System.out.println("Kurz vor Return");
		return eins * zwei;
	}

}
