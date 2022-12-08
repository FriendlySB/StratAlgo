package Week10;
import java.util.ArrayList;

public class KoinKembalian {
    
    /* 
    Kompleksitas Waktu
    Program ini mempunyai kompleksitas O(n^2) karena memerlukan dua loop    
    */
    
    static void hitungKembalian(int koin[], int n){
        ArrayList<Integer> hasil = new ArrayList<>();
        for(int i = 0; i < koin.length; i++){
            while(n >= koin[i]){
                n -= koin[i];
                hasil.add(koin[i]);
            }
        }
        print(hasil);
    }
    
    static void print(ArrayList<Integer> hasil){
        System.out.println("Kembalian:");
        for(int i = 0; i < hasil.size(); i++){
            System.out.print(hasil.get(i) + " ");
        }
    }
    
    static void start(){
        int koin[] = {100,50,25,10,5,1};
        int n = 332;
        hitungKembalian(koin, n);
    }
    
    public static void main(String args[]) {
        start();
    }
}
