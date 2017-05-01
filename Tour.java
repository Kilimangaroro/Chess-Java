


public class Tour extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Tour(){
    	super();
    }
    
    public Tour(int id,int x,int y){
    	if(id==1 || id==7 || id==25 || id==32 ){
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
	    }
    }
    
    
    
    
    
    
    
public Tour(int id){
	
	if(id==1){
		this.id=id;
		this.x=0;
		this.y=0;
		this.color=0;
		addWhite();
		this.Make_Road();
		Plateau.setCase(0,0,this);
	}
	
	if(id==7){
		this.id=id;
		this.x=7;
		this.y=0;
		this.color=0;
		addWhite();
		this.Make_Road();
		Plateau.setCase(7,0,this);
	}


	if(id==26){
		this.id=id;
		this.x=0;
		this.y=5;
		this.color=1;
		addBlack();
		this.Make_Road();
		Plateau.setCase(0,5,this);
	}
	
		if(id==31){		    			
		this.id=id;
		this.x=7;
		this.y=7;
		this.color=1;
		addBlack();
		this.Make_Road();
		Plateau.setCase(7,7,this);
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
			System.out.println("C'est 2");
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
