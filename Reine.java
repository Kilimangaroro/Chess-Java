


public class Reine extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Reine(){
    	super();
    }
    
    public Reine(int id){
    	if(id==4){
    		this.id=id;
    		this.x=3;
    		this.y=0;
    		
    	}
    				
    	if(id==28){
    		
    	}

    }
    
    


    public int getId() {
        return this.id;
    }

	public boolean Mouvement(int x, int y, Case[][] tab) {
		if(MouvementRoi(x,y,tab))
			return true;
		else if(MouvementFou(x,y,tab))
			return true;
		else if(MouvementTour(x,y,tab))
			return true;
		else
		return false;
	}

	public void Make_Road(Case[][] tab) {
		
		Make_RoadRoi(tab);
		Make_RoadFou(tab);
		Make_RoadTour(tab);
		
	}

	public void Clean_Road(Case[][] tab) {
		// TODO Auto-generated method stub
		Clean_RoadRoi(tab);
		Clean_RoadFou(tab);
		Clean_RoadTour(tab);
		
	}
	
	
	
	
	/*En dessous la TOUR*/
	
    public void Make_RoadTour(Case[][] tab){
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
	
	
	
	
	
    public void Clean_RoadTour(Case[][] tab){
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
	
	
	
	
	
	
	
	
    public int moveLimitTour(int i/*Option HAUT:0 DROITE:1 BAS:2 GAUCHE:3*/,Case[][] tab){
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
	
	
	
	
	
	
    public boolean MouvementTour(int x,int y,Case[][] tab){
    	
    	if(x==this.x && y==this.y || (zone_Plateau(x,y)==false))
    		return false;
    	
    	int H = moveLimitTour(0,tab);/*negatif*/
    	int D = moveLimitTour(1,tab);/*positif*/
    	int B = moveLimitTour(2,tab);/*positif*/
    	int G = moveLimitTour(3,tab);/*negatif*/
    	
    	if( (y>=(this.y+H) ||  y<=(this.y+B)  &&  x==this.x) 
    		|| 
    		(x>=(this.x+G) || x<=(this.x+D)  &&  y==this.y) )
    	
    	{
    		tab[y][x].setP(this/*tab[this.y][this.x].getP()*/);
    		Clean_Road(tab);
    		this.setX(x);
    		this.setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else
    		return false;
    }/*end Mouvement*/
	
	
	
	
	
	
	
	/*En dessous FOU*/
	
	
    public void Make_RoadFou(Case[][]tab){

    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
        	
    		while(tab[l][c].getP()==null && zone_Plateau(c,l)){
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
    			tab[l][c].add_InRoad(-this.id);
    		}/**/
    		
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
			}/* */
			
    		i++;
    	}/*end while*/
    	
    }/*end Make_Road*/
	
	
	
	
    public void Clean_RoadFou(Case[][]tab){

    	int i=0;
    	while(i<4){
    		
        	int l = this.y;
        	int c = this.x;
    		
    		while(tab[l][c].getP()==null && zone_Plateau(c,l)){
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
    			tab[l][c].rm_InRoad(-this.id);
    		}/**/
    		
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
					
				}/*end if*/	
			
			
    		i++;
		    if(i==4){/*Pour retirer l'identifiant de l'ancienne position*/
		    	tab[this.y][this.x].setP(null);
		    }
    	}/*end while*/
    	
    }/*end Clean_Road*/
	
	
	
	
	
    public int moveLimitFou(int i,Case[][]tab){
    	int l=this.y;
    	int c=this.x;
    	int compteur=0;

    		while(tab[l][c].getP()==null && zone_Plateau(c,l)){
				if(i==0){/*Haut droite*/
					compteur++;
					l--;
					c++;
				}
				if(i==1){/*Bas Droite*/
					compteur++;
					c++;
					l++;
				}
				if(i==2){/*Bas Gauche*/
					compteur++;
					l++;
					c--;
				}
				if(i==3){/*Haut Gauches*/
					compteur++;
					c--;
					l--;
				}
    		}/**/
    		
			if(tab[l][c].getP()!=null){
				if(Mangeable(this.id,tab[l][c].getId()) ){
    				if(i==0){
	    				compteur++;
    				}
    				if(i==1){
	    				compteur++;	
    				}
    				if(i==2){
	    				compteur++;
    				}
    				if(i==3){
	    				compteur++;
    				}
					
				}/*end if*/
					
			}/* */

	if( (zone_Plateau(c,l)==false) ){
			compteur=0;
	}
	return compteur;

    	
    }
	
	
	
	
	
    public boolean MouvementFou(int x,int y,Case[][]tab){
    	if(x==this.x && y==this.y || (zone_Plateau(x,y)==false))
    		return false;
    	
    		int HD = moveLimitFou(0,tab);
    		int HD2=HD*-1;/*negatif*/
    		
    		int BD = moveLimitFou(1,tab);
    		//int BD2 = BD*-1;/*negatif*/
    		
    		int BG = moveLimitFou(2,tab);
    		int BG2 = BG*-1;/*negatif*/
    		
    		int HG = moveLimitFou(3,tab);
    		int HG2 = HG*-1;/*negatif*/
    		
    	if(  
    		(x<=this.x+HD && x>this.x) && (y>=this.y+HD2 && y<this.y) && (x-this.x==(this.y+1)-(y+1) ) /*Haut Droite*/
    			|| 
    		(x<=this.x+BD && x>this.x) && (y<=this.y+BD && y>this.y) && (x-this.x==(y+1)-(this.y+1) )/*Bas Droite*/
    			||
    		(x>=this.x+BG2 && x<this.x) && (y<=this.y+BG && y>this.y) && (this.x-x==(y+1)-(this.y+1) )/*Bas Gauche*/
    			||
    		(x>=this.x+HG2 && x<this.x) && (y>=this.y+HG2 && y<this.y) && (this.x-x==(this.y+1)-(y+1))/*Haut Gauche*/
    	){
    		tab[y][x].setP(this/*tab[this.y][this.x].getP()*/);
    		Clean_Road(tab);
    		this.setX(x);
    		this.setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else 
    		return false;
    }
	
	
	
	
	
	
/*En dessous ROI*/
	
	
	
	
    public void Make_RoadRoi(Case[][] tab){
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
    
    public void Clean_RoadRoi(Case[][] tab){
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
    
    public boolean MouvementRoi(int x,int y,Case[][]tab){
    	
    	if(x==this.x && y==this.y || (zone_Plateau(x,y)==false))
    		return false;
    	
    	if(sous_Pos(this.x,x)==1 || sous_Pos((this.y+1),(y+1))==1 
    			||
    	(sous_Pos(this.x,x)==1 && sous_Pos((this.y+1),(y+1))==1)  
    	&&
    	(ennemi_Road(x,y,tab)==false) 
    	&&
    	( Mangeable(this.id,tab[y][x].getId())||tab[y][x].getP()==null )  ){
    		tab[y][x].setP(this/*tab[this.y][this.x].getP()*/);
    		Clean_Road(tab);
    		this.setX(x);
    		this.setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else return false;
    	
    }
    

}
