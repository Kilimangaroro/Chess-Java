import java.util.*;
public class Case {
	
	private Piece p;
	private int valeur;
	private	int[] who_In_Road;


	
	Case(){
		who_In_Road=new int[15];
		valeur=0;
	}
	
	public int getValeur(){
		return this.valeur;
	}
	
	public void setValeur(int valeur){
		this.valeur=valeur;
	}
	
	
	public boolean add_InRoad(int nb){
		if(nb<0 && nb>=1 && nb<=32){
			int i=0;
			while(this.who_In_Road[i]<0 && i<15){
				i++;
			}
			if(i<15){
				this.who_In_Road[i]=nb;
				return true;
			}
			else
				return false;
		}
		else 
			return false;
	}
	
	
	public boolean rm_InRoad(int nb){/*remove_InRoad a utilise lors du deplacement d'une piece*/
		if(nb<0 && nb>=1 && nb<=32){
			int i=0;
			while(this.who_In_Road[i]!=nb && i<15){
				i++;
			}
			if(i<15){
				this.who_In_Road[i]=0;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean here_Or_Not(int ident){
		int i=0;
		while(this.who_In_Road[i]!=ident && i<15){
			i++;
		}
		if(i>=15)
			return false;
		else
			return true;
	}
	


}
