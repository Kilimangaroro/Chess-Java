


public class Pion extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	
	//private static Piece permute; /*Il faut cr�e le coup speciale et le changement de piece quand on arrive a la ligne de l'adversaire*/

	
	
    public Pion(){
    	super();
    	//permute=null;
    }
    
    public Pion(int id,int x,int y)
    throws BadIdException,BadXYException{
    	
if((id>=9 && id<=16) || (id>=17&&id<=24)){
			    	//permute=null;
		    		this.move=0;
		    		this.id=id;
		    		this.x=x;
		    		this.y=y;
			    	if(id>=9 && id<=16){
			    		this.color=0;
			    		addWhite();
			    	}
			    	else if(id>=17&&id<=24){
			    		this.color=1;
			    		addBlack();
			    	}

			 			   if(zone_Plateau(x,y)){
			 	 			   	this.Make_Road();
			 			   		Plateau.setCase(x, y, this);
			 			   		}
			 			   else
			 		    		throw new BadXYException();
    	}
    	else
    		throw new BadIdException();
    }
    
    public Pion(int id)
    throws BadIdException{
    	if((id>=9 && id<=16) || (id>=17&&id<=24)){
			    //	permute=null;
			    	if(id>=9 && id<=16){
			    		
			    		this.id=id;
			    		this.x=(white-8);
			    		this.y=1;
			    		this.color=0;
			    		this.move=0;
			    		addWhite();
			    		Plateau.setCase((white-8),1,this);
			    		
			    	}
				
			    	if(id>=17&&id<=24){
			    		
			    		this.id=id;
			    		this.x=black;
			    		this.y=1;
			    		this.color=1;
			    		this.move=0;
			    		addBlack();
			    		Plateau.setCase(black, 6, this);
			    		
			    	}
    	}
    	else
    		throw new BadIdException();
    	
    }
    
	public boolean Mouvement(int x, int y) {
		
		
		
		if(this.id>=1 && this.id<=16){/*Blanc*/
			
			
			
			if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
				System.out.println("Ces coordon�es son hors des limites du plateau ou ne deplace pas la piece");
				return false;
			}
			if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id) && (this.x!=x)) )
					||
				((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id))&& (this.x==x)) 
					||
					
			( this.y==4 && ( (Mangeable(this.id,Plateau.getId(this.x-1,this.y)) && (x==this.x-1&&y==this.y-1) ) || (Mangeable(this.id,Plateau.getId(this.x+1,this.y)) && (x==this.x+1&&y==this.y+1)))
				&&	(Plateau.here_Or_No(x,y,-this.id))    )	
					
					){
				
				System.out.println(Plateau.getId(x,y));
				
				if(Mangeable(this.id,Plateau.getId(x,y)) ){
					Plateau.Death(x,y);
				}
		
				if(this.y==4 && Mangeable(this.id,Plateau.getId(x,(y-1))) ){/*Prise en passant*/
					Plateau.Death(x,y-1);
				}
				
				Plateau.NettoyagePlateau();
	    		Plateau.setCase(x,y,this);
	    		Clean_Road(1);
	    		this.move+=1;
	    		this.setX(x);				
	    		this.setY(y);
				if(Mangeable(this.id,Plateau.getId(x,(y-1))) ){/*Prise en passant*/
					Plateau.Death(x,(y-1));
				}
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
				System.out.println("Ces coordon�es son hors des limites du plateau ou ne deplace pas la piece");
				return false;
			}
			if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id))&& (this.x!=x) )
					||
				((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id)))&& (this.x==x) 
					||
				( this.y==3 && ( (Mangeable(this.id,Plateau.getId(this.x-1,this.y)) && x==this.x-1 ) || (Mangeable(this.id,Plateau.getId(this.x+1,this.y)) && x==this.x+1))
				&&	(Plateau.here_Or_No(x,y,-this.id))    )	 ){
				
				System.out.println(Plateau.getId(x,y));
				
				if(Mangeable(this.id,Plateau.getId(x,y)) && Mangeable(this.id,Plateau.getId(x,(y+1))) ){
					Plateau.Death(x,y);
				}
				if(Mangeable(this.id,Plateau.getId(x,(y+1))) ){/*Prise en passant*/
					Plateau.Death(x,(y+1));
				}
				
				
				Plateau.NettoyagePlateau();
	    		Plateau.setCase(x,y,this);
	    		Clean_Road(1);
	    		this.move+=1;
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
					if(this.move==0 && this.y==1){/*Pour le premier coup*/
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
					else if(this.move>0){
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
				
				if(this.id>=17 && this.id<=32){
					if(this.move==0 && this.y==6){/*Pour le premier coup*/
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
					else if(this.move>0){
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
				
	}

	public void Clean_Road(int t) {

		int c=this.x;
		int l=this.y;
		
				if(this.id>=1 && this.id<=16){
					if(this.move==0){/*Pour le premier coup*/
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
					else if(this.move>0){
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
				
				if(this.id>=17 && this.id<=32){
					if(this.move==0){/*Pour le premier coup*/
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
					else if(this.move>0){
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
			if(t==1)
			Plateau.setCase(this.x,this.y, null);
	}
	

}
