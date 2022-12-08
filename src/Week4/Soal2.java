package Week4;

public class Soal2 {
    
    /* 
    Pada algoritma ini, program akan melakukan sebuah loop sejumlah n, dan dua
    loop terpisah di dalam loop tersebut untuk mencari gelas yang akan ditukar
    Dalam algoritma ini, semakin banyak gelas yang telah di sort urutannya, akan
    semakin pendek pencarian yang dilakukan untuk mencari gelas yang akan ditukar
    
    Kompleksitas
    Algoritma ini mempunyai kompleksitas O(n^2) karena memerlukan sebuah loop
    didalam loop. Best case dari kasus ini adalah urutan gelas sudah benar semua,
    sedangkan worst casenya adalah urutan gelas tertukar semua
    */
    
    static int[] sortGelas(int gelas[],int n){
        int posisiFull = 0; //Index genap akan diisi gelas full
        int posisiKosong = posisiFull + 1; //Index ganjil akan diisi gelas kosong
        
        for(int i = 0; i < n; i++){//Loop sebanyak n
            if(gelas[posisiFull] != 1){//Jika gelas di posisi ganjil kosong
                //Loop dari posisi di depan posisiFull dan cari gelas yang full
                //kemudian tukar posisi mereka Semakin maju pencarian, 
                //semakin pendek pencarian yang harus dilakukan
                for(int j = posisiFull + 1; j < gelas.length; j++){
                    if(gelas[j] == 1){
                        int temp = gelas[posisiFull];
                        gelas[posisiFull] = gelas[j];
                        gelas[j] = temp;
                    }
                }
            }
            if(gelas[posisiKosong] != 0){
                //Lakukan proses yang sama untuk gelas di posisiKosong
                //Perbedaannya hanyalah mencari gelas yang kosong
                for(int j = posisiKosong + 1; j < gelas.length; j++){
                    if(gelas[j] == 0){
                        int temp = gelas[posisiKosong];
                        gelas[posisiKosong] = gelas[j];
                        gelas[j] = temp;
                    }
                }
            }
            //Setelah penukaran dilakukan, maka posisiFull akan maju dua index
            //karena index didepannya sudah pasti benar isinya. index posisiFull
            //juga dimasukan ke depan posisiFull
            posisiFull = posisiFull + 2;
            posisiKosong = posisiFull + 1;
        }
        return gelas;
    }
    
    static void start(){
        int gelas[] = {1,0,0,1,1,1,0,0};
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
