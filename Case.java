
public class Case {
	
	private Piece p;
	private int couleur;/*BLANC:0 NOIR:1 Si non definie Default:-1000*/
	private	int[] who_In_Road;
	private int caseId;
	private static int cNb=1;


	
	Case(){
		p = null ;
		who_In_Road=new int[15];
		
				int i=0;
				while(i<15){
					who_In_Road[i]=0;
					i++;
				}
		
		this.couleur=-1000;
		this.caseId=cNb;
		cNb+=1;
	}
	
	
    public void Death(){
    	if(p!=null){
    	p.Clean_Road(1);
    	}
    }
	
	public int getCouleurCase(){
		return this.couleur;
	}
	
	public void setCouleurCase(int i){/*0:Blanc 1:Noir*/
		this.couleur=i;
	}
	
	public int getCaseId(){
		return this.caseId;
	}
	
	public void setCaseId(int ident){
		this.caseId=ident;
	}
	
	public Piece getP(){
		return p;
	}
	
	public void setP(Piece p){
		this.p=p;
	}
	
	
	public int getId(){
		int re=-1000;
		if(this.p!=null){
		return p.getId();}
		else 
			return re;
	}
	
	public void Clean(){
		if(p!=null)
		p.Clean_Road(0);
	}
	
	public void Make(){
		if(p!=null)
		this.p.Make_Road();
	}

    public void setEch(Plateau e){
    	Piece.ech=e;
    }
	
	public boolean add_InRoad(int nb){
		
		boolean val=false;
		
		if(nb<=-1 && nb>=-32){
			int i=0;
			while(i<15){
				
				if(this.who_In_Road[i]==0 && i<15 && val==false){
					this.who_In_Road[i]=nb;
					val=true;
				}
				i++;
			}
		}

		return val;
	}
	
	
	public boolean rm_InRoad(int nb){/*remove_InRoad a utilise lors du deplacement d'une piece*/
		
	boolean val=false;
	
	if(nb<=-1 && nb>=-32){
			
			int i=0;
			while(i<15){
				
				if(this.who_In_Road[i]==nb && i<15 && val==false){
					this.who_In_Road[i]=0;
					val=true;
				}
				i++;
			}
		}
			return val;
			
	}
	
	public boolean here_Or_Not(int ident){/*Entré un nombre negatif svp le id en negatif*/
		int i=0;
		boolean val = false;
		while(i<15){
			if(this.who_In_Road[i]==ident)
				val=true;
			i++;
		}
		return val;
		

	}
	


}
