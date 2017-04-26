import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Pion extends Piece {

	//protected int id;
    //protected int x;
    //protected int y;
    //protected int color;

    public Pion(){
    	this.id=-98;
    }
    
    public Pion(int id){
    	if(id>=9 && <=17)
    	this.id=id;
    }
    
    
    public int getId() {


        return this.id;
    }



    public void Mouvement() {
    }

}
