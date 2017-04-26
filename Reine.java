import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Reine extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;
    
    public Reine(){
    	this.id=-98;
    }
    
    public Reine(int id){
    	if(id==4 || id==28 )
    	this.id=id;
    }
    
    


    public int getId() {
        return this.id;
    }

}
