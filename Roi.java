
public class Roi extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	
    public Roi(){
    	super();
    }
    
    public Roi(int id,int x,int y){
        	if(id==5 || id==29){
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
        	}
       }
    
    public Roi(int id){
    	if(id==5 || id==29){
    		this.id=id;
    		if(id==5 ){
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
   }
    
    public int getId() {
        return this.id;
    }
    
	public boolean Mouvement(int x, int y/*,Plateau tab*/) {/*suspendu*/
		if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
			System.out.println("C'est 1");
			return false;
		}
		if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id)) && (ennemi_Road(x,y)==false) )
				||
			((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id)) && (ennemi_Road(x,y)==false) ) ){
    		
			if(Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.getP(x,y)!=null)){
				Plateau.Death(x,y);
			}
			
			Plateau.NettoyagePlateau();
    		Plateau.setCase(x,y,this);
    		Clean_Road(1);
    		this.setX(x);				
    		this.setY(y);
    		Plateau.MiseAJour();
    		return true;
		}
		else {
			System.out.println("C'est 2");
			return false;
		}
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
