import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Roi extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	
    public Roi(){
    	this.id=-98;
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
    
    public int getId() {
        return this.id;
    }
    
    public boolean Mouvement(int x,int y,Case[][]tab){
    	
    	if(x==this.x && y==this.y || (zone_Plateau(x,y)==false))
    		return false;
    	
    	if(sous_Pos(this.x,x)==1 || sous_Pos((this.y+1),(y+1))==1 
    			||
    	(sous_Pos(this.x,x)==1 && sous_Pos((this.y+1),(y+1))==1)  
    	&&
    	(ennemi_Road(x,y,tab)==false) 
    	&&
    	( Mangeable(this.id,tab[y][x].getId())||tab[y][x].getP()==null )  ){
    		tab[y][x].setP(tab[this.y][this.x].getP());
    		Clean_Road(tab);
    		this.setX(x);
    		this.setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else return false;
    	
    }
    
    
    
    public void Clean_Road(Case[][] tab){
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
		    				tab[l][c].rm_InRoad(-this.id);
		    				if(i==0)
		    					l++;
		    				if(i==1)
		    					l--;
		    				z++;
		    				if(z==3){
		    					if(i==0 && zone_Plateau(c,l)){
		    						c--;
				    				tab[l][c].rm_InRoad(-this.id);
		    						}
		    					if(i==1 && zone_Plateau(c,l)){
		    						c++;
				    				tab[l][c].rm_InRoad(-this.id);
		    					}
		    				}/*end if z==3*/

		    			}/*end while*/
		    			i++;
		    		    if(i==2){/*Pour retirer l'identifiant de l'ancienne position*/
		    		    	tab[this.y][this.x].setP(null);
		    		    }
    	}/*end big while*/
    	 	
    }/*end Clean_Road*/
    
    
    
    public void Make_Road(Case[][] tab){
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
		    				tab[l][c].add_InRoad(-this.id);
		    				if(i==0)
		    					l++;
		    				if(i==1)
		    					l--;
		    				z++;
		    				if(z==3){
		    					if(i==0 && zone_Plateau(c,l)){
		    						c--;
				    				tab[l][c].add_InRoad(-this.id);
		    						}
		    					if(i==1 && zone_Plateau(c,l)){
		    						c++;
				    				tab[l][c].add_InRoad(-this.id);
		    					}
		    				}/*end if z==3*/

		    			}/*end while*/
		    			i++;
    	}/*end big while*/
    	 	
    }/*end Clean_Road*/
    
    
   public boolean ennemi_Road(int x,int y,Case[][]tab){/*Renvoie true si cette Case est sur le chemin d'un ennemie et false sinon utile pour savoir si une piece est proteger par une autre ou non*/
    	
    	if((zone_Plateau(x,y)==false))
    			return false;
    		
    	if(this.id>=17 && this.id<=32){/*ForBlack*/
        	int i=-1;
    		while(i>-16 && tab[y][x].here_Or_Not(i)){
    			i--;
    		}
    		if(tab[y][x].here_Or_Not(i))
    			return true;
    		else 
    			return false;
    	}
    	
    	
    	else if(this.id>=1 && this.id<=16){/*ForWhite*/
    		int i=-17;
    		while(i>-32 && tab[y][x].here_Or_Not(i)){
    			i--;
    		}
    		if(tab[y][x].here_Or_Not(i))
    			return true;
    		else 
    			return false;
    	}
    	
    	else return false;
    }/*end ennemi_Road*/

}/*end class Roi*/
