package Week4;

public class Soal1 {
    
    /* 
    Pada algoritma ini, program akan melakukan dualoop sejumlah n. 
    Loop pertama digunakan untuk mencari gelas penuh yang akanditukar di index 0-n, 
    dan loop kedua akan mencari gelas kosong di index n hingga akhir. Setelah 
    gelas yang posisinya tidak sesuai ditemukan, gelas akan ditukar posisinya
   
    Kompleksitas
    Algoritma ini mempunyai kompleksitas O(n^2) karena memerlukan dua loop
    Tidak ada best/worst case untuk kasus ini karena urutan gelasnya selalu tetap 
    dimana gelas yang terisi(1) selalu berada di n posisi terdepan
    dan gelas kosng(0) menenmpati sisanya
    */
    
    static int[] sortGelas(int gelas[],int n){
        for(int i = 0; i < n; i++){//Loop sejumlah n
            if(i % 2 != 0){//Jika index ganjil, maka gelas penuh akan ditukar
                while(n < gelas.length){//While loop
                    if(gelas[n] == 0 && n % 2 == 0){//Jika gelas di n kosong dan                        
                        int temp = gelas[n];  //n adalah index genap
                        gelas[n] = gelas[i];  //Tukar gelas di n dengan gelas di i
                        gelas[i] = temp;
                        break;//Stop search
                    }
                    n++;
                }
            }
        }
        return gelas;
    }
    
    static void start(){
        int gelas[] = {1,1,1,1,0,0,0,0}; //Gelas direpresentasikan dengan array
        System.out.println("Posisi gelas awal");
        for(int i = 0; i < gelas.length;i++){
            System.out.print(gelas[i] + " ");
        }
        int n = gelas.length/2;
        gelas = sortGelas(gelas,n);
        System.out.println("Posisi gelas akhir");
        for(int i = 0; i < gelas.length;i++){
            System.out.print(gelas[i] + " ");
        }
    }
    
    public static void main(String args[]) {
       start();
    }
}
