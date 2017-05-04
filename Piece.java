


public abstract class Piece {

	protected int id;
    protected int x;
    protected int y;
    protected int color;/*Blanc=0 Noir=1*/
	protected int move;
    protected static Plateau ech;

    protected static int check_White=0;
    protected static int check_Black=0;
    

    protected static int black = 0;
    protected static int white = 0;
/*Probl�me d'attribution d'id via les variables BLACK n WHITE regler par bidouillage dans la methode start de plateau*/
    
    public Piece(){
    	this.id=-1000;
    	this.x=-1000;
    	this.y=-1000;
    	this.color=-1000;
    	this.move=0;
    	ech=null;
    }
    
    
    
    public void affichage(){
    	Plateau.affichageTab();
    }
    public void affichage(int ident){
    	Plateau.affichageTab(ident);
    }
    
    public Plateau getPlateu(){
    	return (Plateau)ech;
    }
    
    public void setEch(Plateau e){
    	Piece.ech=e;
    }
    
    public Piece(int id,int x ,int y,int color,Plateau ech){
    	this.x=x;
    	this.y=y;
    	this.color=color;
    }
    
    public int getColor(){return this.color;}
    public int getId(){return this.id;}
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    
    public int getBlack(){return black;}
    public int getWhite(){return white;}
    
    public void addBlack(){if(black<16)black+=1;}
    public void lessBlack(){if(black>1)black-=1;}

    public void addWhite(){if(white<16)black+=1;}
    public void lessWhite(){if(white>1)black-=1;}
    
    public int getMove(){
    	return this.move;
    }

    
    public abstract boolean Mouvement(int x,int y/*,Plateau tab*/);
    //public abstract boolean Manger(int x,int y,int[][] tab);
    public abstract void Make_Road(/*Plateau tab*/);
    public abstract void Clean_Road(int i/*Plateau tab*/);
    
    public boolean Mangeable(int id,int tokill){/*Retourne false si la piece a manger est le Roi ou si c'est une piece de notre equipe*/
    	if(id<=0 || tokill==5 || tokill==29)
    		return false;
    	
    	if((id>=1 && id<=16) && (tokill>=17 && tokill<=32) )
    		return true;
    else if((id>=17 && id<=32) &&(tokill>=1 && tokill<=16))
    		return true;
    	else 
    		return false;	
    }
    
    public boolean zone_Plateau(int x,int y){/*Retourne False quand tu est a l'exterieur du plateau et True sinon*/
    	if(x<0 || x>7)
    		return false;
    	if(y<0 || y>7)
    		return false;
    	else
    		return true;
    }
    
    public int sous_Pos(int i,int z){
    	if(i<z)
    		return z-i;
    	else
    		return i-z;
    }
    
   public boolean ennemi_Road(int x,int y/*,Case[][]tab*/){/*Renvoie true si cette Case est sur le chemin d'un ennemie et false sinon utile pour savoir si une piece est proteger par une autre ou non*/
    	
    	if((zone_Plateau(x,y)==false))
    			return false;
    		
    	if(this.id>=17 && this.id<=32){/*ForBlack*/
        	int i=-1;
    		while(i>-16 && Plateau.here_Or_No(x,y,i)){
    			i--;
    		}
    		if(Plateau.here_Or_No(x,y,i))
    			return true;
    		else 
    			return false;
    	}
    	
    	
    	else if(this.id>=1 && this.id<=16){/*ForWhite*/
    		int i=-17;
    		while(i>-32 && Plateau.here_Or_No(x,y,i)){
    			i--;
    		}
    		if(Plateau.here_Or_No(x,y,i))
    			return true;
    		else 
    			return false;
    	}
    	
    	else return false;
    }/*end ennemi_Road*/
    

}

