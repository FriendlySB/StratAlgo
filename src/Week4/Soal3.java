package Week4;

public class Soal3 {
    
    static int potongTongkat(int panjangTongkat, int panjangPotongan){
        if (panjangTongkat == 0) {
            return 0;
        }
        return (int)Math.ceil(Math.log(panjangTongkat/panjangPotongan) / Math.log(2));
    }
    
    static void start(){
        int panjangTongkat = 32;
        int panjangPotongan = 2;
        System.out.println("Akan dilakukan minimum " 
                + potongTongkat(panjangTongkat,panjangPotongan) + " kali pemotongan untuk mendapatkan"
                        + " potongan sepanjang " + panjangPotongan + " cm");
    }
    
    /* 
        Rumus:
        log((panjangTongkat/panjangPotongan))/log(2)
    */
    
    public static void main(String args[]) {
        start();
    }
}
