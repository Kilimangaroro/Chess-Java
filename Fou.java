import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Fou extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Fou(){
    	this.id=-98;
    }
    
    public Fou(int id,int x,int y){
    	if(id==3 || id==6 || id==27 || id==30 ){
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
    	}
   }

    


    public Fou(int id,Case[][]tab){
    	if(id==3 || id==6 || id==27 || id==30 ){
	    	this.id=id;
	    	
	    		if(id==3 || id==6){
	    			addWhite();
	    			color=0;
	    			if(id==3){
	    				this.x=4;
	    				this.y=0;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    			if(id==6){
	    				this.x=7;
	    				this.y=0;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    		}
	    		
	    		else{
	    			addBlack();
	    			color=1;
	    			if(id==27){
	    				this.x=4;
	    				this.y=7;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    			if(id==30){
	    				this.x=7;
	    				this.y=7;
	    				Mouvement(this.x,this.y,tab);
	    			}
	    		}
	    }
    }
    
    
    
    
    
    public boolean Mouvement(int x,int y,Case[][]tab){
    	if(x==this.x && y==this.y || (zone_Plateau(x,y)==false))
    		return false;
    	
    		int HD = moveLimit(0,tab);
    		int HD2=HD*-1;/*negatif*/
    		
    		int BD = moveLimit(1,tab);
    		//int BD2 = BD*-1;/*negatif*/
    		
    		int BG = moveLimit(2,tab);
    		int BG2 = BG*-1;/*negatif*/
    		
    		int HG = moveLimit(3,tab);
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
    		tab[y][x].setP(tab[this.y][this.x].getP());
    		Clean_Road(tab);
    		this.setX(x);
    		this.setY(y);
    		Make_Road(tab);
    		return true;
    	}
    	else 
    		return false;
    		
    	
    	
    }
    
    
    
    
    
    
    
    
    
    public void Make_Road(Case[][]tab){

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
    
    
    
    
    
    
    public void Clean_Road(Case[][]tab){

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
    
    
    
    
    
    
    
    
    
    public int moveLimit(int i,Case[][]tab){
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

    	
    }/*end moveLimit*/
    
    
    

}/*end class Fou*/
