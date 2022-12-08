package Week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Jadwal {
    int start;
    int finish;

    public Jadwal(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class Penjadwalan {
    
    static void sort(Jadwal listJadwal[]){
        Arrays.sort(listJadwal, new Comparator<Jadwal>() {
            @Override
            public int compare(Jadwal jadwal1,Jadwal jadwal2){
                return jadwal1.finish - jadwal2.finish;
            }
        });
    }
    
    static boolean max(int val1, int val2){
        if(val1 > val2){
            return true;
        }
        return false;
    }
    
    static void penjadwalan(int start[], int finish[]){
        ArrayList<Jadwal>jadwalTerpilih = new ArrayList<>();
        Jadwal listJadwal[] = new Jadwal[finish.length];
        for(int i = 0; i < listJadwal.length; i++){
            listJadwal[i] = new Jadwal(start[i],finish[i]);
        }
        sort(listJadwal);
        System.out.println("Jadwal Sorted");
        for(int i = 0; i < listJadwal.length; i++){
            System.out.println(listJadwal[i].start + " " + listJadwal[i].finish);
        }
        System.out.println("------------------------------");
        jadwalTerpilih.add(listJadwal[0]);
        int indexJadwalTerpilih = 0;
        for(int i = 1; i < listJadwal.length; i++){
            if(jadwalTerpilih.get(indexJadwalTerpilih).finish <= listJadwal[i].start){
                jadwalTerpilih.add(listJadwal[i]);
                indexJadwalTerpilih++;
            }
        }
        System.out.println("Jadwal diambil");
        for(int i = 0; i < jadwalTerpilih.size(); i++){
            System.out.println(jadwalTerpilih.get(i).start + " " + jadwalTerpilih.get(i).finish);
        }
        System.out.println("------------------------------");
        int maxirisan = 0;
        for(int i = 0; i < jadwalTerpilih.size() - 1; i++){
            int temp = jadwalTerpilih.get(i+1).start - jadwalTerpilih.get(i).finish;
            if(max(temp,maxirisan)){
                maxirisan = temp;
            }
        }
        System.out.println("Selisih Max: " + maxirisan);
        sort(listJadwal);
        
    }
    
    static void start(){
        int start[] = {0,1,3,3,4,5,6,8};
        int finish[] = {6,4,5,8,7,9,10,11};
        penjadwalan(start,finish);
    }
    
    public static void main(String args[]) {
        start();
    }
}
