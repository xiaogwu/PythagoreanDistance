/* Xiao G. Wu
 * CS111A - Assignment 9
 * 10/26/2011
 */

/** This class uses the pythagorean distance formula to calculate the distance of each cell from a randomly selected origin in a 80 x 20 matrix. */

public class PythagoreanDistance {

    /** Main method */

    public static void main(String[] args) {

        // Constants
        final int ROWS = 20; // Rows
        final int COLS = 80; // Columns 

        // Create matrix
        double[][] matrix = new double[ROWS][COLS];

        // Variables
        int[] origin = {0, 0};

        origin = setOrigin(matrix); // Set origin

        int x = origin[0]; // For convenience x-coordinate of origin
        int y = origin[1]; // For convenience y-coordinate of origin

        // Calculate distances for each cell
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = Math.pow((Math.pow(r - y, 2.0) + Math.pow(c - x, 2.0) ), 0.5);
            }
        }

        // Print matrix
        printMatrix(matrix);
    }
    
    /** This method specifies the origin 
     * @params matrix Two dimensional matrix
     * @returns One dimensional array holding the x and y coordinate designating origin
     */

    public static int[] setOrigin(double[][] matrix) {
        int minInt = 1;
        int rows = matrix.length; // Get matrix rows
        int columns = matrix[0].length; // Get matrix columns
        int[] origin = {0, 0}; // Create origin array

        // Choose random values for origin
        origin[0] = minInt + (int)(Math.random() * ((columns - minInt)));
        origin[1] = minInt + (int)(Math.random() * ((rows - minInt)));

        return origin;
    }

    /** This method iterates over the array and prints the value of each element
     * @params matrix Two dimenional matrix
     */

    public static void printMatrix(double[][] matrix) {
        int asterisks = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                //System.out.printf("%.1f  ", matrix[r][c]);

                // Print matrix based on distance from origin
                if (matrix[r][c] == 0.0) System.out.printf("@");
                else if (matrix[r][c] >= 9.0 && matrix[r][c] <= 10.5) {
                    System.out.printf("*");
                    asterisks++;
                }
                else if (matrix[r][c] > 10.5 && matrix[r][c] <= 12.5) System.out.printf(".");
                else if (matrix[r][c] > 12.5 && matrix[r][c] <= 14.5) System.out.printf("-");
                else if (matrix[r][c] > 14.5 && matrix[r][c] <= 16.5) System.out.printf("+");
                else if (matrix[r][c] > 16.5 && matrix[r][c] <= 18.5) System.out.printf("$");
                else if (matrix[r][c] > 18.5 && matrix[r][c] <= 20.5) System.out.printf("X");
                else if (matrix[r][c] > 20.5 && matrix[r][c] <= 22.5) System.out.printf("#");
                else System.out.printf(" ");
            }
            System.out.println(); //Print new line for each row
        }
        System.out.println("Number of asterisks: " + asterisks);
    }
}
