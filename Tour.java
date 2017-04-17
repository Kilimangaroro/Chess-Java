import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Tour extends Piece {

    private int id;
    
    public Tour(){
    	this.id=-98;
    	addWhite();
    }
    
    public Tour(int id,int x,int y){
    	if(id==1 || id==7 || id==25 || id==32 ){
	    	this.id=id;
	    		if(id==1 || id==7)
	    			addWhite();
	    		else
	    			addBlack();
    	}
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean Mouvement(int x,int y,int[][] tab){
    	
    	if(x==this.x && y==this.y || (zone_plateau(x,y)==false))
    		return false;
    	
    	int H = moveLimit(0,tab);/*negatif*/
    	int D = moveLimit(1,tab);/*positif*/
    	int B = moveLimit(2,tab);/*positif*/
    	int G = moveLimit(3,tab);/*negatif*/
    	
    	if( (y>=(this.y+H)||y<=(this.y+B)&&x==this.x) || (x>=(this.x+G)||x<=(this.x+D)&&y==this.y) ){
    		Clean_Road(tab);
    		tab[x][y]=this.id;
    		setX(x);
    		setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else
    		return false;
    }
    
    public void Make_Road(int[][] tab){
    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
		    			while(zone_plateau(c,l) && tab[l][c]<=0){
		    				if(i==0)
		    					l--;
		    				if(i==1)
		    					c++;
		    				if(i==2)
		    					l++;
		    				if(i==3)
		    					c--;
		    				
		    				tab[l][c]-=this.id;
		    			}
		    			i++;
    	}/*end for*/
    	 	
    }/*end Make_Road*/
    
    
    public void Clean_Road(int[][] tab){
    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
        	
			while(zone_plateau(c,l) && tab[l][c]<=0){
				if(i==0)
					l--;
				if(i==1)
					c++;
				if(i==2)
					l++;
				if(i==3)
					c--;
				tab[l][c]+=this.id;
			}
			i++;	
		    if(i==4){/*Pour retirer l'identifiant de l'ancienne position*/
		    	tab[this.y][this.x]-=this.id;
		    }
    		
    	}/*end for*/
    	 	
    }/*end Clean_Road*/
    
    public int moveLimit(int i/*Option HAUT:0 DROITE:1 BAS:2 GAUCHE:3*/,int[][] tab){
    	int l = this.y;
    	int c = this.x;
    	int compteur=0;

	    			while(zone_plateau(c,l) && tab[l][c]<=0){
	    				if(i==0){
		    				compteur--;
		    				l--;
	    				}
	    				if(i==1){
		    				compteur++;
		    				c++;
	    				}
	    				if(i==2){
		    				compteur++;
		    				l++;
	    				}
	    				if(i==3){
		    				compteur--;
		    				c--;
	    				}
	    			}
	    			if(tab[l][c]>0){
	    				if(Mangeable(this.id,tab[l][c])){
		    				if(i==0){
			    				compteur--;
		    				}
		    				if(i==1){
			    				compteur++;	
		    				}
		    				if(i==2){
			    				compteur++;
		    				}
		    				if(i==3){
			    				compteur--;
		    				}
	    					
	    				}
	    					
	    			}
	    			if( (zone_plateau(c,l)==false) ){
	    					compteur=0;
	    			}
	    	return compteur;
	    	}/*end moveLimit*/

}/*end Class Tour*/
