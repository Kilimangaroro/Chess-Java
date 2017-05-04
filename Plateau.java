//import java.util.ArrayList;

public class Plateau {

    protected static Case Tab2D[][];
    //ArrayList<Case> Save;


    public Plateau (){
    	Tab2D= new Case[8][8];
    	int i=0;
    	while(i<8){
    		
    			int z=0;
    			while(z<8){
    					Tab2D[i][z]=new Case();
    				z++;	
    			}
    			i++;
    	}
    	Tab2D[0][0].setEch(this);
    }
    
	public static boolean getMouvement(int x,int y,int px,int py){
		return Tab2D[y][x].getMouvement(px,py);
	}
    
	public static int getMove(int x , int y){
		return Tab2D[y][x].getMove();
	}
    
	public static void setCaseId(int x,int y,int ident){
		Tab2D[y][x].setCaseId(ident);
	}
	
	public static int getCaseId(int x,int y){
		return Tab2D[y][x].getCaseId();
	}
	
    public static void Death(int x,int y){
    	Tab2D[y][x].Death();
    }
	
    public static int getId(int x,int y){
    	return Tab2D[y][x].getId();
    }

    public static Piece getP(int x,int y){
    	return Tab2D[y][x].getP();
    }
    
    public static void setCase(int x,int y,Piece p){
    	Tab2D[y][x].setP(p);
    }
    
    
    
    public static Case[][] getTab(){
    	return Tab2D;
    }
    
    public static boolean caseEmpty(int id){/*Si il y a une piece renvoie true*/
    	boolean val=false;
    	int i=0;
    	while(i<8){
    		
    			int z=0;
    			while(z<8){
    					if(getCaseId(z,i)==id){
    						if(Tab2D[z][i].getP()!=null && val==false)
    							val=true;
    					}
    					z++;
    			}
    			i++;
    	}
    	return val;
    }
    
    public static int caseNotEmpty(int id){/*Si il y a une piece renvoie true*//* A supprimer si tu veux*/
    	int val=-1;
    	int i=0;
    	while(i<8){
    		
    			int z=0;
    			while(z<8){
    					if(getCaseId(z,i)==id){
    						if(Tab2D[z][i].getP()!=null && val==-1)
    							val=Tab2D[z][i].getId();
    					}
    					z++;
    			}
    			i++;
    	}
    	return val;
    }
    
    public static Case getCT(int x,int y){
    	return Tab2D[y][x];
    }
    
    public static boolean here_Or_No(int x,int y,int ident){
    	return Tab2D[y][x].here_Or_Not(ident);
    }
    
    public static boolean addInRoad(int x,int y,int ident){
     return Tab2D[y][x].add_InRoad(ident);
    }
    
    public static boolean rmInRoad(int x,int y,int ident){
        return Tab2D[y][x].rm_InRoad(ident);
       }
    
 public static void affichageTab(){
    	int i=0;
    	while(i<8){
    		
    			int z=0;
    			while(z<8){
    				if(z<7)
    					System.out.print(Tab2D[i][z].getId()+ "|");
    				if(z==7)
        				System.out.println(Tab2D[i][z].getId()+ "|");
    				z++;	
    			}
    			i++;
    			if(i>=8)
    				System.out.println("");
    	}
    }
 
 
 public static void NettoyagePlateau(){
 	int i=0;
 	while(i<8){
 		
 			int z=0;
 			while(z<8){
 					if(Tab2D[i][z].getP()!=null)
 					Tab2D[i][z].Clean();
 				z++;	
 			}
 			i++;
 	}
 }
 
 public static void MiseAJour(){
	 	int i=0;
	 	while(i<8){
	 		
	 			int z=0;
	 			while(z<8){
	 					if(Tab2D[i][z].getP()!=null)
	 					Tab2D[i][z].Make();
	 				z++;	
	 			}
	 			i++;
	 	}
	 }
    
    public static void affichageTab(int ident){
    	int i=0;
    	while(i<8){
    		
    			int z=0;
    			while(z<8){
    				if(z<7){
    					if(Tab2D[i][z].getP()==null && (Tab2D[i][z].here_Or_Not(-ident)==false) )
    						System.out.print("0|");
    					else if(Tab2D[i][z].here_Or_Not(-ident))
    						System.out.print("3|");
    					else	
    						System.out.print(Tab2D[i][z].getId()+ "|");
    				}
    				
    				if(z==7){
    					if(Tab2D[i][z].getP()==null && (Tab2D[i][z].here_Or_Not(-ident)==false) )
    						System.out.println("0|");
    					else if(Tab2D[i][z].here_Or_Not(-ident))
    						System.out.println("1|");
    					else	
    						System.out.println(Tab2D[i][z].getId()+ "|");
    				}
    				z++;	
    			}
    			i++;
    			if(i>=8)
    				System.out.println("");
    	}
    }
    

}
