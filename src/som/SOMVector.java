package som;

public class SOMVector extends java.util.Vector {
	
	/** Creates a new instance of VariantVector */
	public SOMVector() {
	}
	
	public double euclideanDist(SOMVector v2) {
		if (v2.size() != size())
			return -999;
		
		double summation = 0, temp;
		for (int x=0; x<size(); x++) {
			temp = ((Double)elementAt(x)).doubleValue() -
				   ((Double)v2.elementAt(x)).doubleValue();
			temp *= temp;
			summation += temp;
		}
		
		return summation;
	}
	
}
