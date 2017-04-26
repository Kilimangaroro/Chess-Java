import java.util.*;

import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Plateau {

    private Case [][] Tab2D;
	private Piece[] piece;

    public Plateau (){
    
    	Tab2D= new Case [8][12];
    	piece = new Piece[32];
    
    }
    
    public Piece getRefOfList(int ident){
    	if(ident>=1&&ident<=32){
    		
    	int i=0;
    	while(i<32 && piece[i].getId()!=ident){
    		i++;
    	}
    	if(i>=32)
    		return null;
    	else
    		return piece[i];
    	}
    	return null;
    }
    
    
    
    start_chess(){/*Pas finie du tout a suivre plus tard */

	    
    	}//end start_chess
    



}
