/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week9;

/**
 *
 * @author USER
 */
public class Coin {
    
    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    
    static int coinRow(int c[]){
        int n = c.length;
        if(n == 1){
            return c[0];
        }
        if(n == 2){
            return max(c[0],c[1]);
        }
        
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = c[0];
        for(int i = 2; i <= n; i++){
            f[i] = max(c[i - 1] + f[i - 2], f[i - 1]);
        }
        return f[n];
    }
    
    static void start(){
        int coin[] = {5,1,2,10,6,2};
        System.out.println("Hasil = " + coinRow(coin));
    }
    
    public static void main(String args[]) {
        start();
    }
}
