package Week1;

import java.util.Scanner;

public class Fibonacci {
    static int fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Fib:");
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print(fibonacci(i) + " ");
        }
    }
}
