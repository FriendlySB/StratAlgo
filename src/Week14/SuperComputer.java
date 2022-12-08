
package Week14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SuperComputer {

    public SuperComputer() {
        
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            int J = in.nextInt();
            int D = in.nextInt();
            
            A[i][0] = J;
            A[i][1] = J + D - 1;
        }

        Arrays.sort(A, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int num = 1;
        int lim = A[0][1];

        for (int i = 1; i < N; i++) {

            if (lim < A[i][0]) {
                lim = A[i][1];
                num++;
            }
        }
        System.out.println(num);
    }
}
