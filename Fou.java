

public class Fou extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Fou(){
    	super();
    }
    
    public Fou(int id,int x,int y)
    throws BadIdException,BadXYException {
    	
if(id==3 || id==6 || id==27 || id==30 ){
    		this.move=0;
    		this.id=id;
    		this.x=x;
    		this.y=y;
    		if(id==3 || id==6){
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

    


    public Fou(int id)
    		throws BadIdException{
    	if(id==3 || id==6 || id==27 || id==30 ){
    		this.move=0;
			    	if(id==3){
			    		this.id=id;
			    		this.x=2;
			    		this.y=0;
			    		this.color=0;
			    		addWhite();
			    		this.Make_Road();
			    		Plateau.setCase(2,0,this);
			    	}
			    	
			    	else if(id==6){
			    		this.id=id;
			    		this.x=5;
			    		this.y=0;
			    		this.color=0;
			    		addWhite();
			    		this.Make_Road();
			    		Plateau.setCase(5,0,this);
			    	}
			
			
			    	else if(id==27){
			    		this.id=id;
			    		this.x=2;
			    		this.y=7;
			    		this.color=1;
			    		addBlack();
			    		this.Make_Road();
			    		Plateau.setCase(2,7,this);
			    	}
			    	
			    	else if(id==30){		    			
			    		this.id=id;
			    		this.x=5;
			    		this.y=7;
			    		this.color=1;
			    		addBlack();
			    		this.Make_Road();
			    		Plateau.setCase(5,7,this);
			    	}
    	}
    	else
    		throw new BadIdException();
    }
    
    
    
    
    
	public boolean Mouvement(int x, int y/*,Plateau tab*/) {/*suspendu*/
		if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
			System.out.println("Ces coordonées son hors des limites du plateau ou ne deplace pas la piece");
			return false;
		}
		if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id)) )
				||
			((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id))) ){
    		
			if(Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.getP(x,y)!=null)){
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
		else {
			System.out.println("Ce mouvement n'est pas possible actuellement");
			return false;
		}
	}
    
    
    
    
    
    
    
    
    
    public void Make_Road(){

    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
        	
    		do{

				if(i==0){/*Haut droite*/
					l--;
					c++;
				}
				if(i==1){/*Bas Droite*/
					c++;
					l++;
				}
				if(i==2){/*Bas Gauche*/
					l++;
					c--;
				}
				if(i==3){/*Haut Gauches*/
					c--;
					l--;
				}
				if(zone_Plateau(c,l))
	    		Plateau.addInRoad(c,l,-this.id);

    		}while(zone_Plateau(c,l)&&Plateau.getP(c,l)==null);
    		
			if(zone_Plateau(c,l) && Plateau.getP(c,l)!=null){
    	    	Plateau.addInRoad(c,l,-this.id);
			}/**/
			
    		i++;
    	}/*end while*/
    	
    }/*end Make_Road*/
    
    
    
    public void Clean_Road(int t){

    	int i=0;
    	while(i<4){
    		
        int l = this.y;
        int c = this.x;
        	
    		do{
    			
				if(i==0){/*Haut droite*/
					l--;
					c++;
				}
				if(i==1){/*Bas Droite*/
					c++;
					l++;
				}
				if(i==2){/*Bas Gauche*/
					l++;
					c--;
				}
				if(i==3){/*Haut Gauches*/
					c--;
					l--;
				}
				
			if(zone_Plateau(c,l))
		    Plateau.rmInRoad(c,l,-this.id);
    		}while(zone_Plateau(c,l)&&Plateau.getP(c,l)==null);
    		
			if(zone_Plateau(c,l) && Plateau.getP(c,l)!=null){
    	    	Plateau.rmInRoad(c,l,-this.id);
			}/**/

    		i++;
		    if(i==4 && t==1){/*Pour retirer l'identifiant de l'ancienne position*/
		    	Plateau.setCase(this.x,this.y,null);
		    }
    	}/*end while*/
    	
    }/*end Make_Road*/
     

}/*end class Fou*/

