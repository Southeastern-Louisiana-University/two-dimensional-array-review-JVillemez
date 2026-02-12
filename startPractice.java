// starting point for class activities
import java.util.Scanner;

public class TwoDArrayPractice {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matrix = new int[10][10];   // 10 rows, 10 columns

        // 1) Initialize with user input values
        fillWithUserInput(matrix, input);

        // 2) Print the array
        System.out.println("\nMatrix after user input:");
        printMatrix(matrix);

        // 3) Sum all elements
        int total = sumAll(matrix);
        System.out.println("\nSum of ALL elements = " + total);

        // 4) Sum elements by column
        System.out.println("\nColumn sums:");
        printColumnSums(matrix);

        // 5) Which row has the largest sum?
        int maxRowIndex = rowWithLargestSum(matrix);
        System.out.println("\nRow with largest sum = " + maxRowIndex);

        // 6) Random shuffling
        shuffle2D(matrix);
        System.out.println("\nMatrix after shuffling:");
        printMatrix(matrix);

        // 7) Initialize with random values (example use)
        fillWithRandom(matrix);
        System.out.println("\nMatrix after random fill (0-99):");
        printMatrix(matrix);

        input.close();
    }

    // 1) User input fill
    public static void fillWithUserInput(int[][] matrix, Scanner input) {
        System.out.println("Enter 100 integers for a 10x10 matrix:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.nextInt();
            }
        }
    }

    // 2) Random fill (0-99)
    public static void fillWithRandom(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (int)(Math.random() * 100); // 0..99
            }
        }
    }

    // 3) Print matrix
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%3d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    // 4) Sum all elements
    public static int sumAll(int[][] matrix) {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                total += matrix[row][col];
            }
        }
        return total;
    }

    // 5) Sum by column
    public static void printColumnSums(int[][] matrix) {
        int columns = matrix[0].length; // assume all rows same length
        for (int col = 0; col < columns; col++) {
            int total = 0;
            for (int row = 0; row < matrix.length; row++) {
                total += matrix[row][col];
            }
            System.out.println("Column " + col + " sum = " + total);
        }
    }

    // 6) Row with largest sum (returns index)
    public static int rowWithLargestSum(int[][] matrix) {
        int indexOfMaxRow = 0;

        // sum row 0 first as the starting "max"
        int maxRowSum = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            maxRowSum += matrix[0][col];
        }

        // now compare rows 1..end
        for (int row = 1; row < matrix.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                rowSum += matrix[row][col];
            }

            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                indexOfMaxRow = row;
            }
        }

        return indexOfMaxRow;
    }

    // 7) Shuffle all elements (swap each element with a random element)
    public static void shuffle2D(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                int randomRow = (int)(Math.random() * matrix.length);
                int randomCol = (int)(Math.random() * matrix[0].length);

                // swap matrix[row][col] with matrix[randomRow][randomCol]
                int temp = matrix[row][col];
                matrix[row][col] = matrix[randomRow][randomCol];
                matrix[randomRow][randomCol] = temp;
            }
        }
    }
}
