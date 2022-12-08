package Week9;

public class KnapsackProblem {
    
    /*
    1121018 - Friendly Sejati Bunardi
    Time complexity dari algortima ini adalah O(n^2) dimana algoritma ini 
    memerlukan dua buah loop sepanjang jumlah weight barang dan jumlah value barang
    untuk melakukan perhitungan
    
    Space complexity dari algoritma ini adalah O(n^2) dimana algoritma ini
    membutuhkan sebuah array dua dimensi untuk menampung perhitungan weight dan
    value barang
    */
    
    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    
    static int knapsackProblem(int w, int n, int value[], int weight[]){
        int mat[][] = new int[n + 1][w + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= w; j++){
                if(i == 0 || j == 0){
                    mat[i][j] = 0;
                } else if (weight[i - 1] <= j){
                    mat[i][j] = max(value[i - 1] + mat[i - 1][j - weight[i - 1]], mat[i - 1][j]);
                } else {
                    mat[i][j] = mat[i - 1][j];
                }
            }
        }
        return mat[n][w];
    }
    
    static void start(){
        int w = 40;
        int value[] = {30,40,10,20};
        int weight[] = {10,15,20,25};
        int n = value.length;
        System.out.println("Maximum value : " +knapsackProblem(w, n, value, weight));
    }
    
    public static void main(String args[]) {
        start();
    }
}
