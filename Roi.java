
public class Roi extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	private int move;
	
    public Roi(){
    	super();
    }
    
    public Roi(int id,int x,int y)
    throws BadIdException,BadXYException{
    	
    if(id==5 || id==29){
        		this.move=0;
        		this.id=id;
        		this.x=x;
        		this.y=y;
        		if(id==5 ){
        			this.color=0;
        			addWhite();
        		}
        		else{
        			this.color=1;
        			addBlack();
        		}


 			   if(zone_Plateau(x,y)){
 	 			   	this.Make_Road();
 			   		Plateau.setCase(x, y, this);
 			   		}
 			   else
 		    		throw new BadXYException();
 				   
        }
       else
    	   throw new BadIdException();
   }
    
    public Roi(int id)
    throws BadIdException{
    	if(id==5 || id==29){
    		this.move=0;
    		if(id==5 ){
        		this.id=id;
    			this.color=0;
    			this.x=4;
    			this.y=0;
    			addWhite();
    			this.Make_Road();
    			Plateau.setCase(4,0,this);
    		}
    		else if(id==29){
    			this.color=1;
    			this.x=4;
    			this.y=7;
    			addBlack();
    			this.Make_Road();
    			Plateau.setCase(4,7,this);
    		}
    	}
    	else
    		throw new BadIdException();
   }
    
	public boolean Mouvement(int x, int y/*,Plateau tab*/) {
		
		
		if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
			System.out.println("Ces coordonées son hors des limites du plateau ou ne deplace pas la piece");
			return false;
		}
		if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id)) && (ennemi_Road(x,y)==false) )
				||
			((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id)) && (ennemi_Road(x,y)==false) )
				){
    		
			if(Mangeable(this.id,Plateau.getId(x,y))){
				Plateau.Death(x,y);
			}
			
			Plateau.NettoyagePlateau();
    		Plateau.setCase(x,y,this);
    		this.move+=1;
    		Clean_Road(1);
    		this.setX(x);				
    		this.setY(y);
    		Plateau.MiseAJour();
    		return true;
		}
		else if(move==0 && roque(x,y) ){
			return true;
		}
		else {
			System.out.println("Ce mouvement n'est pas possible actuellement");
			return false;
		}
	}
    
	private boolean roque(int x,int y){
		
		if(this.id==5){
			if(move==0 && zone_Plateau(x,y) && (Plateau.getId(x, y)==1||Plateau.getId(x, y)==8) && Plateau.getMove(x,y)==0 ){
					if(Plateau.getId(x, y)==1){
									if((ennemi_Road(this.x-1,this.y)==false && ennemi_Road(this.x-2,this.y)==false && ennemi_Road(this.x-3,this.y)==false)
											&&
									(Plateau.getP(this.x-1,this.y)==null && Plateau.getP(this.x-2,this.y)==null && Plateau.getP(this.x-3,this.y)==null)){
							    		Plateau.getMouvement(x,y,3,0);
										Plateau.NettoyagePlateau();
							    		Plateau.setCase(2,0,this);
							    		this.move+=1;
							    		Clean_Road(1);
							    		this.setX(2);				
							    		this.setY(0);
							    		Plateau.MiseAJour();
							    		return true;
									}
									else return false;
					}
					else if(Plateau.getId(x, y)==8){
										if((ennemi_Road(this.x+1,this.y)==false && ennemi_Road(this.x+2,this.y)==false )
												&&
										(Plateau.getP(this.x+1,this.y)==null && Plateau.getP(this.x+2,this.y)==null) ){
								    		Plateau.getMouvement(x,y,5,0);
											Plateau.NettoyagePlateau();
								    		Plateau.setCase(6,0,this);
								    		this.move+=1;
								    		Clean_Road(1);
								    		this.setX(6);				
								    		this.setY(0);
								    		Plateau.MiseAJour();
								    		return true;
										}
										else return false;
					}/*End for 8*/
					else return false;
					
			}/*End for Gigant if*/
			else return false;
		}/*End for Roi 5*/
		
		
		else if(this.id==29){
			if(move==0 && zone_Plateau(x,y) && (Plateau.getId(x, y)==25||Plateau.getId(x, y)==32) && Plateau.getMove(x,y)==0 ){
					if(Plateau.getId(x, y)==25){
									if((ennemi_Road(this.x-1,this.y)==false && ennemi_Road(this.x-2,this.y)==false && ennemi_Road(this.x-3,this.y)==false)
											&&
									(Plateau.getP(this.x-1,this.y)==null && Plateau.getP(this.x-2,this.y)==null && Plateau.getP(this.x-3,this.y)==null)){
							    		Plateau.getMouvement(x,y,3,7);
										Plateau.NettoyagePlateau();
							    		Plateau.setCase(2,7,this);
							    		this.move+=1;
							    		Clean_Road(1);
							    		this.setX(2);				
							    		this.setY(7);
							    		Plateau.MiseAJour();
							    		return true;
									}
									else return false;
					}
					else if(Plateau.getId(x, y)==32){
										if((ennemi_Road(this.x+1,this.y)==false && ennemi_Road(this.x+2,this.y)==false )
												&&
										(Plateau.getP(this.x+1,this.y)==null && Plateau.getP(this.x+2,this.y)==null) ){
								    		Plateau.getMouvement(x,y,5,7);
											Plateau.NettoyagePlateau();
								    		Plateau.setCase(6,7,this);
								    		this.move+=1;
								    		Clean_Road(1);
								    		this.setX(6);				
								    		this.setY(7);
								    		Plateau.MiseAJour();
								    		return true;
										}
										else return false;
					}/*End for 32*/
					else return false;
			}/*End for Gigant if*/
			else return false;
		}/*End for Roi 29*/
		else return false;
		
		
	}
    
    
    public void Clean_Road(int t){
    	int i=0;
    	while(i<2){
    		
        	int l = this.y;
        	int c = this.x;
        	int z=0;
        	
        		if(i==0){
        			l--;
        			c++;
        		}
        		if(i==1){
        			l++;
        			c--;
        		}
		    			while(z<3){
		    				if(zone_Plateau(c,l))
		    				Plateau.rmInRoad(c,l,-this.id);
		    				if(i==0 && z<2)
		    					l++;
		    				if(i==1 && z<2)
		    					l--;
		    				z++;
		    				if(z==3){
		    					if(i==0 && zone_Plateau(c,l)){
		    						c--;
				    				Plateau.rmInRoad(c,l,-this.id);
		    						}
		    					if(i==1 && zone_Plateau(c,l)){
		    						c++;
				    				Plateau.rmInRoad(c,l,-this.id);
		    					}
		    				}/*end if z==3*/

		    			}/*end while*/
		    			i++;
		    		    if(i==2 && t==1){/*Pour retirer l'identifiant de l'ancienne position*/
		    		    	Plateau.setCase(this.x,this.y,null);
		    		    }
    	}/*end big while*/
    	 	
    }/*end Clean_Road*/
    
    
    
    public void Make_Road(){
    	int i=0;
    	while(i<2){
    		
        	int l = this.y;
        	int c = this.x;
        	int z=0;
        	
        		if(i==0){/*Haut droite*/
        			l--;
        			c++;
        		}
        		if(i==1){/*Bas Gauche*/
        			l++;
        			c--;
        		}
		    			while(z<3){	
		    				if(zone_Plateau(c,l))
		    				Plateau.addInRoad(c,l,-this.id);
		    				if(i==0 && z<2)
		    					l++;
		    				if(i==1 && z<2)
		    					l--;
		    				z++;
		    				if(z==3){
		    					if(i==0 && zone_Plateau(c,l)){
		    						c--;

				    				Plateau.addInRoad(c,l,-this.id);
		    						}
		    					if(i==1 && zone_Plateau(c,l)){
		    						c++;

				    				Plateau.addInRoad(c,l,-this.id);
		    					}
		    				}/*end if z==3*/

		    			}/*end while*/
		    			i++;
    	}/*end big while*/
    	 	
    }/*end Clean_Road*/
    
public boolean Danger(){
	return ennemi_Road(this.x,this.y);
}
    
    
}/*end class Roi*/
