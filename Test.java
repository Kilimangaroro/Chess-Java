
public class Test {

	public static void main(String[] args) {
		
		
		Plateau Echequier= new Plateau();
		
		Piece p = new Fou(26);
		Piece z= new Tour(1);
		Piece y= new Tour(7);

		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);
		
		p.Mouvement(0,5);
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);
		
		z.Mouvement(0, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);

		z.Mouvement(7, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);
		
		y.Mouvement(7, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);
		
		y.Mouvement(0, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);
		
		z.Mouvement(7, 0);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(7);
		Plateau.affichageTab(26);
		
		
		
		
		/*if(p.Mouvement(4,1))
			System.out.println("C'est bon");
		else
			System.out.println("C'est pas bon");
		
		p.affichage();
		p.affichage(26);
		
		if(p.Mouvement(3,3))
			System.out.println("C'est bon");
		else
			System.out.println("C'est pas bon");
		
		p.affichage(26);
		
		if(p.Mouvement(5,4))
			System.out.println("C'est bon");
		else
			System.out.println("C'est pas bon");
		
		p.affichage(26);
		p.affichage();
		p.affichage(26);
		
		if(p.Mouvement(7,2))
			System.out.println("C'est bon");
		else
			System.out.println("C'est pas bon");
		
		p.affichage(26);
		p.affichage();
		p.affichage(26);*/
	}

}
