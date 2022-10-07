package nur.nicht.ohne;

/**
 * Jede Aktion, an der Pumuckl beteiligt ist, löst diese Exception aus
 * @author Alfa
 *
 */
@SuppressWarnings("serial")
public class PumucklException extends Exception{

	public PumucklException() {
		super("Und wieder hat Pumuckl Unsinn gemacht!");
	}
}
