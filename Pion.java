


public class Pion extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	private int first_move;
	private static Piece permute; /*Il faut crée le coup speciale et le changement de piece quand on arrive a la ligne de l'adversaire*/

	
	
    public Pion(){
    	super();
    	first_move=1;
    	permute=null;
    }
    
    public Pion(int id,int x,int y){
    	if(id>=9 && id<=17){
    		
    		this.id=id;
    		this.x=x;
    		this.y=y;
    		this.color=0;
    		this.first_move=1;
    		addWhite();
    		
    	}
	
    	if(id>=17&&id<=24){
    		
    		this.id=id;
    		this.x=x;
    		this.y=y;
    		this.color=1;
    		this.first_move=1;
    		addBlack();
    		
    	}
    	
    }
    
    public int getFirstMove(){
    	return this.first_move;
    }
    
   public void setFirstMove(int i){
    	this.first_move=i;
    }
    public int getId() {
        return this.id;
    }



    public void Mouvement() {
    	if(first_move==1){
    		
    	}
    
    }

	public boolean Mouvement(int x, int y) {
		if(this.id>=1 && this.id<=16){/*Blanc*/
			if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
				System.out.println("C'est 1");
				return false;
			}
			if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id) && (this.x!=x)) )
					||
				((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id))&& (this.x==x)) ){
				
				System.out.println(Plateau.getId(x,y));
				
				if(Mangeable(this.id,Plateau.getId(x,y)) ){
					Plateau.Death(x,y);
				}
				Plateau.NettoyagePlateau();
	    		Plateau.setCase(x,y,this);
	    		Clean_Road(1);
	    		this.setX(x);				
	    		this.setY(y);
	    		Plateau.MiseAJour();
	    		return true;
			}
			else {
				System.out.println(Plateau.getId(x,y));
				System.out.println("C'est 2");
				return false;
			}
		}
		else if(this.id>=17&&this.id<=32){
			if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
				System.out.println("C'est 1");
				return false;
			}
			if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id))&& (this.x!=x) )
					||
				((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id)))&& (this.x==x) ){
				
				System.out.println(Plateau.getId(x,y));
				
				if(Mangeable(this.id,Plateau.getId(x,y)) ){
					Plateau.Death(x,y);
				}
				Plateau.NettoyagePlateau();
	    		Plateau.setCase(x,y,this);
	    		Clean_Road(1);
	    		this.setX(x);				
	    		this.setY(y);
	    		Plateau.MiseAJour();
	    		return true;
			}
			else {
				System.out.println(Plateau.getId(x,y));
				System.out.println("C'est 2");
				return false;
			}
		}else return false;
	}

	public void Make_Road() {

		int c=this.x;
		int l=this.y;
		
				if(this.id>=1 && this.id<=16){
					if(this.first_move==1){/*Pour le premier coup*/
						int i=0;
						while(i<2){
							l--;
							if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
									if(i==0){
										c++;
										if(zone_Plateau(c,l))
											Plateau.addInRoad(c, l,-this.id);
										c-=2;
										if(zone_Plateau(c,l))
											Plateau.addInRoad(c, l,-this.id);
										c+=1;
									}
									i++;
								}
							}
					else if(this.first_move!=1){
						l--;
						if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
						c++;
						if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
						c-=2;
						if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
					}
				}
				
				if(this.id>=17 && this.id<=32){
					if(this.first_move==1){/*Pour le premier coup*/
						int i=0;
						while(i<2){
							l++;
							if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
									if(i==0){
										c++;
										if(zone_Plateau(c,l))
											Plateau.addInRoad(c, l,-this.id);
										c-=2;
										if(zone_Plateau(c,l))
											Plateau.addInRoad(c, l,-this.id);
										c+=1;
									}
									i++;
								}
							}
					else if(this.first_move!=1){
						l++;
						if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
						c++;
						if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
						c-=2;
						if(zone_Plateau(c,l))
							Plateau.addInRoad(c, l,-this.id);
					}
				}
				
	}

	public void Clean_Road(int t) {

		int c=this.x;
		int l=this.y;
		
				if(this.id>=1 && this.id<=16){
					if(this.first_move==1){/*Pour le premier coup*/
						int i=0;
						while(i<2){
							l--;
							if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
									if(i==0){
										c++;
										if(zone_Plateau(c,l))
											Plateau.rmInRoad(c, l,-this.id);
										c-=2;
										if(zone_Plateau(c,l))
											Plateau.rmInRoad(c, l,-this.id);
										c+=1;
									}
									i++;
								}
							}
					else if(this.first_move!=1){
						l--;
						if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
						c++;
						if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
						c-=2;
						if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
					}
				}
				
				if(this.id>=17 && this.id<=32){
					if(this.first_move==1){/*Pour le premier coup*/
						int i=0;
						while(i<2){
							l++;
							if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
									if(i==0){
										c++;
										if(zone_Plateau(c,l))
											Plateau.rmInRoad(c, l,-this.id);
										c-=2;
										if(zone_Plateau(c,l))
											Plateau.rmInRoad(c, l,-this.id);
										c+=1;
									}
									i++;
								}
							}
					else if(this.first_move!=1){
						l++;
						if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
						c++;
						if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
						c-=2;
						if(zone_Plateau(c,l))
							Plateau.rmInRoad(c, l,-this.id);
					}
				}
			if(t==1)
			Plateau.setCase(this.x,this.y, null);
	}
	

}
