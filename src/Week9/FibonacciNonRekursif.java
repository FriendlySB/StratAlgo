package Week9;

import java.util.Scanner;

public class FibonacciNonRekursif {
    static int fibonacci(int n) {
        int fibonacci[] = new int[n + 2];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for(int i = 2; i <= n; i++){
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
        return fibonacci[n];
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Fib:");
        int n = scan.nextInt();
        System.out.println(fibonacci(n - 1));
    }
}
