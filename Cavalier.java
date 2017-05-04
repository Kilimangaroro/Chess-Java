


public class Cavalier extends Piece {
	
	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	
    public Cavalier(){
    	super();
    }
    
    public Cavalier(int id,int x,int y)
    throws BadIdException,BadXYException{
    	
 if(id==2 || id==7 || id==26 || id==31){
			    	this.id=id;
			    	this.x=x;
			    	this.y=y;
			    	this.move=0;
			    	
			    	if(id>=1&&id<=16){
			    		this.color=0;
			    		addWhite();
			    	}
			    	if(id>=17&&id<=32){
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

    
    public Cavalier(int id)
    throws BadIdException {
    	
    	if(id==2 || id==7 || id==26 || id==31){
    	this.move=0;
	    			if(id==2){
	    				this.id=id;
	    				this.x=1;
	    				this.y=0;
		    			this.color=0;
		    			addWhite();
		    			this.Make_Road();
	    				Plateau.setCase(1,0,this);
	    			}
	    			
	    			else if(id==7){
	    				this.id=id;
	    				this.x=6;
	    				this.y=0;
		    			this.color=0;
		    			addWhite();
		    			this.Make_Road();
	    				Plateau.setCase(6,0,this);
	    			}


	    			else if(id==26){
	    				this.id=id;
	    				this.x=1;
	    				this.y=7;
		    			this.color=1;
		    			addBlack();
		    			this.Make_Road();
	    				Plateau.setCase(1,7,this);
	    			}
	    			else if(id==31){		    			
	    				this.id=id;
	    				this.x=6;
	    				this.y=7;
		    			this.color=1;
		    			addBlack();
		    			this.Make_Road();
	    				Plateau.setCase(6,7,this);
	    			}
    	}
    	else
    		throw new BadIdException();

    }
    
    
    
	public boolean Mouvement(int x, int y/*,Plateau tab*/) {/*suspendu*/
		if((zone_Plateau(x,y)==false) || (x==this.x && y==this.y)){
			System.out.println("C'est 1");
			return false;
		}
		if((Mangeable(this.id,Plateau.getId(x,y)) && (Plateau.here_Or_No(x,y,-this.id)) )
				||
			((Plateau.getP(x,y)==null) && (Plateau.here_Or_No(x,y,-this.id))) ){
			
			Plateau.NettoyagePlateau();
    		Plateau.setCase(x,y,this);
    		this.move+=1;
    		Clean_Road(1);
    		this.setX(x);				
    		this.setY(y);
    		Plateau.MiseAJour();
    		return true;
		}
		else {
			System.out.println("C'est 2");
			return false;
		}
	}

	//@Override
	public void Make_Road(/*Plateau tab*/) {
		int c,l,ybis,xbis;
		int i=0;
		while (i<2){
			l=this.y;
			c=this.x;
			ybis=0;
				while(ybis<2){
					
					if(i==0)
						l--;
					if(i==1)
						l++;
					
						xbis=0;
						if(ybis==0){
								while(xbis<2){
									
									if(xbis==0){
										c+=2;
										if(zone_Plateau(c,l)){
											if(Plateau.addInRoad(c,l,-this.id))
												System.out.println("Oui _x:"+c+"_y:"+l);
										}
									}
									
									else if(xbis==1){
										c-=4;
										if(zone_Plateau(c,l)){
											if(Plateau.addInRoad(c,l,-this.id))
												System.out.println("Oui _x:"+c+"_y:"+l);
										}
									}
									xbis++;
								}
						}/*end ybis1*/
						
					if(ybis==1){
							while(xbis<2){
								
								if(xbis==0){
									c+=1;
									if(zone_Plateau(c,l)){
										if(Plateau.addInRoad(c,l,-this.id))
											System.out.println("Oui _x:"+c+"_y:"+l);
									}
								}
								
								else if(xbis==1){
									c+=2;
									if(zone_Plateau(c,l)){
										if(Plateau.addInRoad(c,l,-this.id))
											System.out.println("Oui _x:"+c+"_y:"+l);
									}
								}
								xbis++;
							}
					}

				ybis++;		
				}/*end ybis*/
				
			i++;
		}/*end BIG while*/
		
	}

	public void Clean_Road(int t/*Plateau tab*/) {
		int c,l,ybis,xbis;
		int i=0;
		while (i<2){
			l=this.y;
			c=this.x;
			ybis=0;
				while(ybis<2){
					
					if(i==0)
						l--;
					if(i==1)
						l++;
					
						xbis=0;
						if(ybis==0){
								while(xbis<2){
									
									if(xbis==0){
										c+=2;
										if(zone_Plateau(c,l))
											Plateau.rmInRoad(c,l,-this.id);
									}
									
									else if(xbis==1){
										c-=4;
										if(zone_Plateau(c,l))
											Plateau.rmInRoad(c,l,-this.id);
									}
									xbis++;
								}
						}/*end ybis1*/
						
					if(ybis==1){
							while(xbis<2){
								
								if(xbis==0){
									c+=1;
									if(zone_Plateau(c,l))
										Plateau.rmInRoad(c,l,-this.id);
								}
								
								else if(xbis==1){
									c+=2;
									if(zone_Plateau(c,l))
										Plateau.rmInRoad(c,l,-this.id);
								}
								xbis++;
							}
					}

				ybis++;		
				}/*end ybis*/
			i++;
			if(i==2 && t==1)
				Plateau.setCase(this.x,this.y,null);
		}/*end BIG while*/
		
	}



}
