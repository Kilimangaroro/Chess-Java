


public class Tour extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    public Tour(){
    	super();
    }
    
    public Tour(int id,int x,int y)
    throws BadIdException,BadXYException{
    	
if(id==1 || id==8 || id==25 || id==32 ){
    		this.move=0;
	    	this.id=id;
	    	this.x=x;
	    	this.y=y;
	    		if(id==1 || id==7){
	    			addWhite();
	    			color=0;
	    		}
	    		else{
	    			addBlack();
	    			color=1;
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
    
    
    
    
    
    
    
public Tour(int id)
throws BadIdException{
	if(id==1 || id==8 || id==25 || id==32 ){
		this.move=0;
					if(id==1){
						this.id=id;
						this.x=0;
						this.y=0;
						this.color=0;
						addWhite();
						this.Make_Road();
						Plateau.setCase(0,0,this);
					}
					
					else if(id==8){
						this.id=id;
						this.x=7;
						this.y=0;
						this.color=0;
						addWhite();
						this.Make_Road();
						Plateau.setCase(7,0,this);
					}
				
				
					else if(id==25){
						this.id=id;
						this.x=0;
						this.y=7;
						this.color=1;
						addBlack();
						this.Make_Road();
						Plateau.setCase(0,7,this);
					}
					
					else if(id==32){		    			
						this.id=id;
						this.x=7;
						this.y=7;
						this.color=1;
						addBlack();
						this.Make_Road();
						Plateau.setCase(7,7,this);
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
			
			System.out.println(Plateau.getId(x,y));
			
			if(Mangeable(this.id,Plateau.getId(x,y)) ){
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
			System.out.println(Plateau.getId(x,y));
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
		    				if(i==0)
		    					l--;
		    				if(i==1)
		    					c++;
		    				if(i==2)
		    					l++;
		    				if(i==3)
		    					c--;
		    				if(zone_Plateau(c,l))
		    				Plateau.addInRoad(c, l,-this.id);
		    			}while(zone_Plateau(c,l) && Plateau.getP(c,l)==null);
		    			
		    			i++;
		    			if(zone_Plateau(c,l) && Plateau.getP(c,l)!=null){
		    				if(zone_Plateau(c,l))
		    				Plateau.addInRoad(c,l,-this.id);
		    			}
    	}/*end for*/
    	 	
    }/*end Make_Road*/
    
  
    public void Clean_Road(int val){
    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
		    			do{

		    				if(i==0)
		    					l--;
		    				if(i==1)
		    					c++;
		    				if(i==2)
		    					l++;
		    				if(i==3)
		    					c--;
		    				if(zone_Plateau(c,l))
		    				Plateau.rmInRoad(c, l,-this.id);
		    			}while(zone_Plateau(c,l) && Plateau.getP(c,l)==null);
		    			
		    					    			
		    			i++;
		    			if(zone_Plateau(c,l) && Plateau.getP(c,l)!=null){
		    				if(zone_Plateau(c,l))
		    				Plateau.rmInRoad(c,l,-this.id);
		    			}
		    			if(i==4 && val==1)
		    				Plateau.setCase(this.x,this.y, null);
    	}/*end for*/
    	 	
    }/*end Make_Road*/  

}/*end Class Tour*/
