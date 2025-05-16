import java.util.Scanner;

public class Matrix_2x2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter matrix size n (n ≤ 10): ");
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        System.out.println("\n--- Input matrix elements ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nThe matrix you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n--- Sum of each row ---");
        for (int i = 0; i < n; i++) {
            int sumRow = 0;
            for (int j = 0; j < n; j++) {
                sumRow += a[i][j];
            }
            System.out.printf("Sum of row %d = %d\n", i + 1, sumRow);
        }

        System.out.println("\n--- Sum of each column ---");
        for (int j = 0; j < n; j++) {
            int sumCol = 0;
            for (int i = 0; i < n; i++) {
                sumCol += a[i][j];
            }
            System.out.printf("Sum of column %d = %d\n", j + 1, sumCol);
        }

        int max = a[0][0], min = a[0][0];
        int maxI = 0, maxJ = 0, minI = 0, minJ = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    maxI = i;
                    maxJ = j;
                }
                if (a[i][j] < min) {
                    min = a[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }
        System.out.printf("\nMaximum value = %d at (row %d, column %d)\n",
                max, maxI + 1, maxJ + 1);
        System.out.printf("Minimum value = %d at (row %d, column %d)\n",
                min, minI + 1, minJ + 1);

        int sumMain = 0, sumSecondary = 0;
        for (int i = 0; i < n; i++) {
            sumMain += a[i][i];
            sumSecondary += a[i][n - 1 - i];
        }
        System.out.printf("\nSum of main diagonal = %d\n", sumMain);
        System.out.printf("Sum of secondary diagonal = %d\n", sumSecondary);

        boolean isSymmetric = true;
        for (int i = 0; i < n && isSymmetric; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
        }
        if (isSymmetric) {
            System.out.println("\nThe matrix is symmetric across its main diagonal.");
        } else {
            System.out.println("\nThe matrix is NOT symmetric across its main diagonal.");
        }

        sc.close();
    }
}

