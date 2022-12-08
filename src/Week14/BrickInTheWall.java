package Week14;

import java.util.Arrays;
import java.util.Scanner;

public class BrickInTheWall {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int bricks[] = new int[N];
        for(int i = 0; i < N; i++){
            bricks[i] = in.nextInt();
        }
        
        Arrays.sort(bricks);

        double W = 0;

        for (int i = 0; i < N; i++){
            int L = i / X;
            W += L * .65 * bricks[N-i-1];
        }
        System.out.println(String.format("%.3f", Math.round(W * 1000) / 1000.0));
    }
}
