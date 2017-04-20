import java.util.*;

import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Plateau {

    public Case [][] Tab2D;

    public Plateau (){
    
    	Tab2D= new Case[8][12];
    	piece = new ArrayList<Piece>();
    
    }
    
    start_chess(){/*Pas finie du tout a suivre plus tard */
    	
		Piece test = new Piece();
    	ListIterator<Piece> curs= null;
		curs = piece.listIterator();
    	
	    	if(piece.isEmpty()){
	    		curs.add(new Tour(test.getWhite(),2,Tab2D));
	    		}//end if not here
	    	
////PROBLEMES a REGARDER N'oublie pas de FAIRE LE TRUC PR L'ID 1 ET pour le white +1 
	    	Piece T=NULL;
	    			while((test.getWhite+test.getBlack)<32){
	    				
									    switch (note)
									    {
									      case 1:
									        piece.add(new Tour(test.getWhite+test.getBlack),0,2);
									        T = piece.get(0);
									        T.mouvement(T.getX,T.getY);
									        break;
									      case 2:
									        System.out.println("Parfait !");
									        break;
									      case 3:
										        System.out.println("Parfait !");
										        break;
									      case 4:
										        System.out.println("Parfait !");
										        break;
									      case 5:
										        System.out.println("Parfait !");
										        break;
									      case 6:
										        System.out.println("Parfait !");
										        break;
									      case 7:
										        System.out.println("Parfait !");
										        break;

									        System.out.println("Il faut davantage travailler.");
									    }//end switch
									    
							    if(test.getWhite()==16){
							    	test.addBlack();
							    }
    
	    			}//end while
	    			
	    
    	}//end start_chess
    



}
