/**
 * Created by Deepak on 15-04-2017.
 */
/**
 CHALLENGE DESCRIPTION:
 A robot is located in the upper-left corner of a 4×4 grid. The robot can move either up, down, left, or right,
 but cannot go to the same location twice. The robot is trying to reach the lower-right corner of the grid. Your task is
 to find out the number of unique ways to reach the destination.

 INPUT SAMPLE:
 There is no input for this program.

 OUTPUT SAMPLE:
 Print out the number of unique ways for the robot to reach its destination. The number should be printed out as
 an integer ≥0.
 */


public class RobotMovements {

    /* Returns count of possible paths to reach cell at row number m and column
    number n from the topmost leftmost cell (cell at 1, 1) */
    int uniquePaths(int m, int n) {

        /* Create a 2D table to store results of sub problems */
        int count[][] = new int[m][n];

        /* Count of paths to reach any cell in first column is 1 */
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        /* Count of paths to reach any cell in first column is 1 */
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }

        /* Calculate count of paths for other cells in bottom-up manner using the recursive solution */
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {
                /* By adding the "+ count[i-1][j-1]" to the code, can calculate the total possible paths
                if the diagonal Movements are allowed */
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        return count[m-1][n-1];
    }
    public static void main(String[] args) {
        RobotMovements robotMovements = new RobotMovements();

        /* Change the m x n value to change the grid count */
        System.out.print(robotMovements.uniquePaths(4,4));
    }
}
