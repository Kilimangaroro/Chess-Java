import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Cavalier extends Piece {
	
	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
	
    public Cavalier(){
    	this.id=-98;
    }
    
    public Cavalier(int id){
    	if(id==2 || id==7 || id==26 || id==31 )
    	this.id=id;
    }



}
