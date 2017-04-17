import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Piece {

    protected int x;
    protected int y;


    protected static int black = 0;
    protected static int white = 1;
/*Problème d'attribution d'id via les variables BLACK n WHITE regler par bidouillage dans la methode start de plateau*/
    
    
    
    public Piece(){
    	this.x=-99;
    	this.y=-99;
    }
    
    public Piece(int x , int y){
    	this.x=x;
    	this.y=y;
    			
    }

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
    

    
    public boolean Mouvement(int x,int y,int[][] tab) {
    }
    public boolean Manger(int x,int y,int[][] tab) {
    }
    public void Make_Road(int[][] tab){
    }
    public void Clean_Road(int[][] tab){
    }
    
    public boolean Mangeable(int id,int tokill){/*Retourne false si la piece a manger est le Roi ou si c'est une piece de notre equipe*/
    	if(id<=0 || tokill==5 || tokill==29)
    		return false;
    	if(id>=1 && id<=16 && tokill>=17)
    		return true;
    	else if(id>=17 && id<=32 && tokill<=16)
    		return true;
    	else 
    		return false;	
    }
    
    public boolean zone_plateau(int x,int y){/*Retourne False quand tu est a l'exterieur du plateau et True sinon*/
    	if(x<2 || x>9)
    		return false;
    	if(y<0 || y>7)
    		return false;
    	else
    		return true;
    }

}
