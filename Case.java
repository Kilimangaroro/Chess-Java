
public class Case {
	
	private Piece p;
	private int couleur;
	private	int[] who_In_Road;


	
	Case(){
		p = null ;
		who_In_Road=new int[15];
	}
	
	public Piece getP(){
		return p;
	}
	
	public int getId(){
		if(this.p==null)
			return -500;
		else
			return p.getId();
	}
	
	public void setP(Piece p){
		this.p=p;
	}
	
	
	
	public boolean add_InRoad(int nb){
		if(nb<0 && nb<=-1 && nb>=-32){
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
		if(nb<0 && nb<=-1 && nb>=-32){
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
