package Week4;

import java.util.Arrays;

public class Soal3Ver2 {
    
    static int cariFPB(int a, int b){
        //Algoritma Euclid untuk mencari FPB
        while(b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    
    static int compareFPB(int tongkat[],int panjang){
        int fpb = tongkat[0]/panjang;//FPB untuk mementukan jumlah pemootongan
                             //yang dapat dilakukan secara bersamaaan
        if(panjang == 1){
            return cekTongkatTerpendek(tongkat);//Jika panjang potongan 1cm,maka 
                                                //jumlah pemotongan akan berjumlah 
                                                //sama dengan panjang tongkat terpedek
        }
        else {
            for(int i = 0; i < tongkat.length;i++){
                fpb = cariFPB(fpb,tongkat[i]/panjang);//Mencari FPB dari seluruh
                                             //panjang tongkat
            }
        }
        return fpb;
    }
    
    static int cekTongkatTerpendek(int tongkat[]){
        int min = tongkat[0];
        for(int i = 1; i < tongkat.length;i++){
            if(tongkat[i] < min){
                min = tongkat[i];
            }
        }
        return min;
    }
    
    static void start(){
        int tongkat[] = {4,8,16};//Panjang tongkat yang dipotong 
                                      //direpresentasikan kedalam array
        int jumlahTongkat = tongkat.length;//Jumlah tongkat yang akan dipotong
        
        int panjangPotongan = 4; //Panjang potongan dari tongkat
        
        int fpb = compareFPB(tongkat,panjangPotongan);
        
        int jumlahPotongan = fpb * tongkat.length;//Hasil akhir adalah FPB tongkat
                                                //dikali dengan jumlah tongkat 
                                                //yang ada
        System.out.println("Tongkat: " + Arrays.toString(tongkat));                                        
        System.out.println("Jumlah potongan minimum dari memotong " + 
                jumlahTongkat + " tongkat secara bersamaan dengan panjang " + 
                panjangPotongan + " cm adalah " + jumlahPotongan + " potongan");
        
        /* 
        Rumus menentukan jumlah potongan minimum:
            
            FPB dari array tongkat yang panjangnya telah dibagi dengan panjang
            potongan dikali dengan jumlah tongkat:
            
            FPB dari (tongkat/panjangPotongan)*jumlahTongkat
        */
    }
    
    public static void main(String args[]) {
       start();
    }
}
