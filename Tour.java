import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Tour extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Tour(){
    	this.id=-98;
    	addWhite();
    }
    
    public Tour(int id,int x,int y){
    	if(id==1 || id==7 || id==25 || id==32 ){
	    	this.id=id;
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
    
    
    
    
    
    
    
public Tour(int id,Case[][]tab){
    	if(id==1 || id==8 || id==25 || id==32 ){
	    	this.id=id;
	    	
	    		if(id==1 || id==8){
	    			addWhite();
	    			color=0;
	    			if(id==1){
	    				this.x=2;
	    				this.y=0;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    			if(id==8){
	    				this.x=9;
	    				this.y=0;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    		}
	    		
	    		else{
	    			addBlack();
	    			color=1;
	    			if(id==25){
	    				this.x=2;
	    				this.y=7;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    			if(id==32){
	    				this.x=9;
	    				this.y=7;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    		}
	    }
    }
    
    
    
    
    
    
    
    public int getId() {
        return this.id;
    }
    
    public boolean Mouvement(int x,int y,Case[][] tab){
    	
    	if(x==this.x && y==this.y || (zone_Plateau(x,y)==false))
    		return false;
    	
    	int H = moveLimit(0,tab);/*negatif*/
    	int D = moveLimit(1,tab);/*positif*/
    	int B = moveLimit(2,tab);/*positif*/
    	int G = moveLimit(3,tab);/*negatif*/
    	
    	if( (y>=(this.y+H) ||  y<=(this.y+B)  &&  x==this.x) 
    		|| 
    		(x>=(this.x+G) || x<=(this.x+D)  &&  y==this.y) )
    	
    	{
    		tab[y][x].setP(tab[this.y][this.x].getP());
    		Clean_Road(tab);
    		this.setX(x);
    		this.setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else
    		return false;
    }/*end Mouvement*/
    
    public void Make_Road(Case[][] tab){
    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
		    			while(zone_Plateau(c,l) && tab[l][c].getP()==null){
		    				if(i==0)
		    					l--;
		    				if(i==1)
		    					c++;
		    				if(i==2)
		    					l++;
		    				if(i==3)
		    					c--;
		    				
		    				tab[l][c].add_InRoad(-this.id);
		    			}
		    			
		    			
		    			if(tab[l][c].getP()!=null){
			    				if(i==0){
			    					tab[l][c].add_InRoad(-this.id);
			    				}
			    				if(i==1){
			    					tab[l][c].add_InRoad(-this.id);
			    				}
			    				if(i==2){
			    					tab[l][c].add_InRoad(-this.id);
			    				}
			    				if(i==3){
			    					tab[l][c].add_InRoad(-this.id);
			    				}
		    			}
		    			
		    			
		    			i++;
    	}/*end for*/
    	 	
    }/*end Make_Road*/
    
    
    public void Clean_Road(Case[][] tab){
    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
        	
			while(zone_Plateau(c,l) && tab[l][c].getP()!=null){
				if(i==0)
					l--;
				if(i==1)
					c++;
				if(i==2)
					l++;
				if(i==3)
					c--;
				tab[l][c].rm_InRoad(-this.id);
			}		    			
			
			if(tab[l][c].getP()!=null){
    				if(i==0){
    					tab[l][c].rm_InRoad(-this.id);
    				}
    				if(i==1){
    					tab[l][c].rm_InRoad(-this.id);
    				}
    				if(i==2){
    					tab[l][c].rm_InRoad(-this.id);
    				}
    				if(i==3){
    					tab[l][c].rm_InRoad(-this.id);
    				}

			}
			
			
			
			i++;	
		    if(i==4){/*Pour retirer l'identifiant de l'ancienne position*/
		    	tab[this.y][this.x].setP(null);
		    }
    		
    	}/*end for*/
    	 	
    }/*end Clean_Road*/
    
    public int moveLimit(int i/*Option HAUT:0 DROITE:1 BAS:2 GAUCHE:3*/,Case[][] tab){
    	int l = this.y;
    	int c = this.x;
    	int compteur=0;

	    			while(zone_Plateau(c,l) && tab[l][c].getP()==null){
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
	    			if(tab[l][c].getP()!=null){
	    				if(Mangeable(this.id,tab[l][c].getId()) ){
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
	    			if( (zone_Plateau(c,l)==false) ){
	    					compteur=0;
	    			}
	    	return compteur;
	    	}/*end moveLimit*/

}/*end Class Tour*/
