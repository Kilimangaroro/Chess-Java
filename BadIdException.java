
public class BadIdException extends Exception {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public BadIdException(){
			 System.out.println("Vous avez introduit le mauvais 'Id' pour ce type de piece veuillez voir la liste suivante :\n"
				 		+"Tour: 1-8(White)  25-32(Black)\n" 
				 		+"Cavalier: 2-7(White)  26-31(Black)\n"
				 		+"Fou: 3-6(White)  27-30(Black)\n"
				 		+"Roi: 5(White)  29(Black)\n"
				 		+"Reine: 4(White)  28(Black)\n"
				 		+"Pion: [9..16](White)  [17..24](Black)\n"
				 		);
		}
	
}
