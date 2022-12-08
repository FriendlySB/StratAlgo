package Week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Pekerjaan {
    String nama;
    int durasi;

    public Pekerjaan(String nama, int durasi) {
        this.nama = nama;
        this.durasi = durasi;
    }
    
}

public class NumberOfTasks {
    
    static void sortArray(int hariPekerjaan[]){
        
    }
    
    static int cariPekerjaan(int hariPekerjaan[], int jumlahHari){
        Arrays.sort(hariPekerjaan);
        int jumlahPekerjaan = 0;
        int index = 0;
        for(int i = 0; i < hariPekerjaan.length; i++){
            if(hariPekerjaan[i] < jumlahHari){
                jumlahHari -= hariPekerjaan[index];
                jumlahPekerjaan += 1;
            }
        }
        return jumlahPekerjaan;
    }
    
    static void start(){
        int hariPekerjaan[] = {4,3,1,5,2};
        String namaPekerjaan[] = {"UI/UX Design","Database Modeling","Documentation",
        "Implementation","Testing and Evaluation"};
        int jumlahHari = 7;
        System.out.println("Jumlah pekerjaan: " + cariPekerjaan(hariPekerjaan,jumlahHari));
    }
    
    public static void main(String args[]) {
        start();
    }
}
