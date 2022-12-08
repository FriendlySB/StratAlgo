package Week10;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
    
}

public class KnapsackProblemGreedy {
    /*
    1121018 - Friendly Sejati Bunardi
    
    Algorithm knapsackProblem(capacity, value[0...n-1], weight[0...n-1]){
    
        //Masukkan value dan weight ke array itemList sebagai objek Item
        for i <- 0 to n - 1 do itemList[i] <- Item{value[i], weight[i])

        Sort(itemList)//Sort array berdasarkan ratio value/weight secara 
                      //descending

        totalValue <- 0

        for i <- 0 to n do
            currentWeight <- itemList[i].weight
            currentValue <- itemList[i].value
            if capacity - currentWeight >= 0
                capacity <- capacity - currentWeight
                totalValue <- totalValue + currentValue
            else
                fraction <- capacity/currentWeight
                totalValue <- totalValue + (currentValue * fraction)
                break
        return totalValue
    }
    
    Analisis
    Algoritma ini membutuhkan sebuah loop untuk melakukan pengecekan pada setiap
    item dalam array itemList untuk mengetahui apakah item muat atau tidak dalam
    knapsack. Dari sini, dapa dilihat bahwa time complexity nya adalah O(n).
    
    Akan tetapi, perlu dilakukan sorting terlebih dahulu terhadap array listItem 
    secara descending dengan melihat ratio value/weight nya. Proses sorting ini
    menggunakan fungsi Arrays.Sort bawaan Java dengan time complexity O(n log n)
    
    Dengan demikian, pada best case scenario dimana listItem sudah terurut dengan
    benar, makan time complexity nya adalah O(n)
    
    Namun jika listItem belum terurut, maka time complexity nya adalah O(n log n)
    
    Space complexity dari algoritma ini adalah O(n) dimana algoritma ini
    membutuhkan sebuah array listItem untuk menampung class item yang 
    merupakan kombinasi weight dan value
    
    Jika dibandingkan dengan algoritma knapsack lainnya, yaitu 
    knapsack bruteforce dengan time complexity O(2^n) dan knapsack dynamic
    programming dengan time complexity O(n^2), maka algortima fractional
    knapsack problem jauh lebih efisien jika kita membandingkan time complexity
    nya
    
    Pembuktian
    Misalkan n = 4
    Brute force = 2^4 = 16
    Dynamic programming = 4^2 = 16
    Fractional knapsack = 4 * log(2)4 = 8
    */
    
    //Sort array dengan fungsi bawaan java
    static void sort(Item itemList[]){
        Arrays.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item item1,Item item2){
                double cpr1 = (double)item1.value / (double)item1.weight;
                double cpr2 = (double)item2.value / (double)item2.weight;
                if (cpr1 < cpr2){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
    
    static double knapsackProblem(int capacity, int value[], int weight[]){
        Item itemList[] = new Item[value.length];
        for(int i = 0; i < itemList.length; i++){
            itemList[i] = new Item(value[i],weight[i]);
        }
        sort(itemList);
        
        double totalValue = 0;
        
        for (Item i : itemList) {
 
            int currentWeight = (int)i.weight;
            int currentValue = (int)i.value;
 
            if (capacity - currentWeight >= 0) {
                capacity = capacity - currentWeight;
                totalValue += currentValue;
            }
            else {
                double fraction = ((double)capacity / (double)currentWeight);
                totalValue += (currentValue * fraction);
                break;
            }
        }
                
        return totalValue;
    }
    
    static void start(){
        int capacity = 50;
        int value[] = {30,40,10,20};
        int weight[] = {10,15,20,25};
        
        System.out.println("Total value: " + knapsackProblem(capacity,value,weight));
    }
    
    public static void main(String args[]) {
        start();
    }
}
