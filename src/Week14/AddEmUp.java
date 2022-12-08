package Week14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddEmUp {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }

        int cost = 0;

        while (list.size() > 1){
            Collections.sort(list);
            
            int minSum = list.get(0) + list.get(1);
            
            cost += minSum;

            list.remove(0);
            list.remove(0);
            list.add(minSum);
        }
        System.out.println(cost);
    }
}
