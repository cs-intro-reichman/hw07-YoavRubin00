/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if(n==0){
			StdDraw.line(x1, y1, x2, y2);
            return;}
			//לחלק ל 3 חלקים שווים
			double p1x = x1+ (x2-x1)/3.0;
			double p1y = y1+ (y2-y1)/3.0;
			double p3x = x1+ 2*(x2-x1)/3.0;
			double p3y = y1+ 2*(y2-y1)/3.0;
			//קצה המשולש
        double sqrt3 = Math.sqrt(3);
        double p2x = (p1x+ p3x) / 2.0 + (sqrt3 / 2.0) * (p1y-p3y);
        double p2y = (p1y+ p3y) / 2.0 + (sqrt3 / 2.0) * (p3x-p1x);
		//קריאה לרקורסיה עבור הקווים הרלוונטיים
		curve(n-1,x1,y1,p1x,p1y);
		curve(n-1,p1x,p1y,p2x,p2y);
		curve(n-1,p2x,p2y,p3x,p3y);
		curve(n-1,p3x,p3y,x2,y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
        double v1x = 0.2, v1y = 0.35; // Bottom left
        double v2x = 0.8, v2y = 0.35; // Bottom right
        double h = Math.sqrt(3) / 2 * (v2x - v1x);
        double v3x = 0.5, v3y = v1y + h; 
        curve(n, v1x, v1y, v3x, v3y); // Left side
        curve(n, v3x, v3y, v2x, v2y); // Right side
        curve(n, v2x, v2y, v1x, v1y); // Bottom side
    }
}
