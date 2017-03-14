package som;

public class SOMLattice {
	
	private int width, height;
	private SOMNode[][] matrix;
	
	/** Creates a new instance of SOMLattice,
	 *  which is a 2x2 array of SOMNodes. For now, it
	 *  assumes an input vector of three values, and
	 *  randomly initializes the array as such.
	 */
	public SOMLattice(int w, int h) {
		width = w;
		height = h;
		matrix = new SOMNode[width][height];
		float xstep = .5f / (float)width;
		float ystep = .5f / (float)height;
		for (int x=0; x<w; x++) {
			for (int y=0; y<h; y++) {
				matrix[x][y] = new SOMNode(3);
				matrix[x][y].setX(x);
				matrix[x][y].setY(y);
			}
		}
	}
	
	// Returns the SOMNode at the given point (x,y)
	public SOMNode getNode(int x, int y) {
		return matrix[x][y];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	/** Finds the best matching unit for the given
	 *  inputVector
	 */
	public SOMNode getBMU(SOMVector inputVector) {
		// Start out assuming that 0,0 is our best matching unit
		SOMNode bmu = matrix[0][0];
		double bestDist = inputVector.euclideanDist(bmu.getVector());
		double curDist;
		
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				curDist = inputVector.euclideanDist(matrix[x][y].getVector());
				if (curDist < bestDist) {
					
					bmu = matrix[x][y];
					bestDist = curDist;
				}
			}
		}
		
		return bmu;
	}
	
}
