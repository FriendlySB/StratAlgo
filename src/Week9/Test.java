package Week9;

public class Test {

    static int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }
    
    static int knapSack(int w, int wt[],int val[], int n){
        int i, j;
        int mat[][] = new int[n + 1][w + 1];
 
        // Build table mat[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= w; j++)
            {
                if (i == 0 || j == 0)
                    mat[i][j] = 0;
                else if (wt[i - 1] <= j)
                    mat[i][j] = max(val[i - 1] + mat[i - 1][j - wt[i - 1]], mat[i - 1][j]);
                else
                    mat[i][j] = mat[i - 1][j];
            }
        }
 
        return mat[n][w];
    }
    
    public static void main(String args[]) {
        int n = 1;
    }
}
