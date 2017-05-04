
public class BadXYException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadXYException(){
		System.out.print("Les coordonées demander sont hors du plateau de l'echiquier, les limites sont x[0..7] y[0..7]");
	}

}
