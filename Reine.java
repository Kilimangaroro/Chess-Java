


public class Reine extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Reine(){
    	super();
    }
    
    
    public Reine(int id,int x,int y)
    throws BadIdException,BadXYException{
        if(id==4 || id==28){
        		this.move=0;
        		this.id=id;
        		this.x=x;
        		this.y=y;
        		if(id==4 ){
        			this.color=0;
        			addWhite();
        		}
        		else if(id==28){
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
    
    
    
    public Reine(int id)
    throws BadIdException{
    	
    	if(id==4 || id==28){
    		this.move=0;
    		
		    if(id==4){
		    		this.id=id;
		    		this.x=3;
		    		this.y=0;
		        	this.move=0;
		    		addWhite();
		    		this.Make_Road();
		    		Plateau.setCase(3,0,this);
		    		
		    	}
		    				
		    else if(id==28){
		    		this.id=id;
		    		this.x=3;
		    		this.y=7;
		        	this.move=0;
		    		addBlack();
		    		this.Make_Road();
		    		Plateau.setCase(3,7,this);
		    		
		    	}
    	}
    	else
    		throw new BadIdException();

    }
    
	public boolean Mouvement(int x, int y) {

		if(MouvementFou(x,y))
			return true;
		else if(MouvementTour(x,y))
			return true;
		else
		return false;
	}

	public void Make_Road() {
		

		Make_RoadFou();
		Make_RoadTour();
		
	}

	public void Clean_Road(int i) {
		// TODO Auto-generated method stub
		Clean_RoadFou(i);
		Clean_RoadTour(i);
		
	}
	
	
	
	
	/*En dessous la TOUR*/
	
    public void Make_RoadTour(){
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
	
	
	
	
	
    public void Clean_RoadTour(int val){
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
    	 	
    }/*end Clean_Road*/
	
	
    public boolean MouvementTour(int x,int y){
		if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
			System.out.println("Ces coordon�es son hors des limites du plateau ou ne deplace pas la piece");
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
    }/*end Mouvement*/
	
	
	
	
	
	
	
	/*En dessous FOU*/
	
	
    public void Make_RoadFou(){

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
	
	
	
	
    public void Clean_RoadFou(int t){

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
    	
    }/*end Clean_Road*/
	
	
  public boolean MouvementFou(int x,int y){
		if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
			System.out.println("C'est 1");
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
	
}
