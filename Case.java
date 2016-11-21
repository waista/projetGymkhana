import java.util.*;


abstract class Case{

	private int coordx;
	private int coordy;

	protected Case(){
		int coordx;
		int coordy;
	}

	protected Case(int x,int y){
		coordx = x;
		coordy = y;
	}

	public int getCoordx(){
		return coordx;
	}

	public int getCoordy(){
		return coordy;
	}

	abstract public String toString();

}
