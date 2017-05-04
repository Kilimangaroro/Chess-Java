
public class Test {

	public static void main(String[] args) throws BadIdException, BadXYException {
		
		
		new Plateau();
		
		Piece z= new Cavalier(66);
		
		Piece zer=new Pion(13,4,4);
		Piece zer2=new Pion(17,2,5);

		zer2.Mouvement(5,4);

		Plateau.affichageTab();
		Plateau.affichageTab(13);
		Plateau.affichageTab(17);
		Plateau.affichageTab(26);
		
		zer.Mouvement(5, 5);
		z.Mouvement(2, 5);
		
		Plateau.affichageTab();
		Plateau.affichageTab(13);
		Plateau.affichageTab(17);
		Plateau.affichageTab(26);


		
		
		
		/*Plateau.affichageTab(3);
		Plateau.affichageTab(28);
		
		f.Mouvement(7, 7);
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);

		Plateau.affichageTab(3);
		Plateau.affichageTab(28);*/
		
		/*Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);
		
		p.Mouvement(0,5);
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);
		
		z.Mouvement(0, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);

		z.Mouvement(7, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);
		
		y.Mouvement(7, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);
		
		y.Mouvement(0, 5);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);
		
		z.Mouvement(7, 0);
		
		
		Plateau.affichageTab();
		Plateau.affichageTab(1);
		Plateau.affichageTab(8);
		Plateau.affichageTab(3);*/
		
		
		
		
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
