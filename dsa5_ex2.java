// Amir Valeev CSE-06
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class dsa5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Creating array with distance values and filling it
        int[][] arr_1 = new int[n][m];
        arr_1[0][0] = arr[0][0];

        // Computing distance for 1st row
        for (int j = 1; j < m; j++) {
            arr_1[0][j] = arr_1[0][j - 1] + arr[0][j];
        }

        //Computing distance for 1st column
        for (int i = 1; i < n; i++) {
            arr_1[i][0] = arr_1[i - 1][0] + arr[i][0];
        }

        //Computing distance for others
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr_1[i][j-1] <= arr_1[i-1][j]){
                    arr_1[i][j] = arr_1[i][j-1] + arr[i][j];
                } else {
                    arr_1[i][j] = arr_1[i-1][j] + arr[i][j];
                }
            }
        }

        // Creating arraylist for path with minimal distance
        List<Integer> path = new ArrayList<>();
        path.add(arr[n - 1][m - 1]);
        int i = n - 1;
        int j = m - 1;

        while (i != 0 || j != 0) {
            if (i == 0) {
                path.add(arr[i][j - 1]);
                j--;
            } else if (j == 0) {
                path.add(arr[i - 1][j]);
                i--;
            } else {
                if (arr_1[i][j - 1] > arr_1[i - 1][j]) {
                    path.add(arr[i - 1][j]);
                    i--;
                } else {
                    path.add(arr[i][j - 1]);
                    j--;
                }
            }
        }

        //Printing results
        System.out.println(arr_1[n - 1][m - 1]);
        for (int k = path.size() - 1; k > -1; k--) {
            System.out.print(path.get(k) + " ");
        }
    }
}
