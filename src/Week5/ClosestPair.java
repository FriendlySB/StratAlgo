package Week5;

public class ClosestPair {
    
    static double bruteForce(double[] x, double[] y){
        double distance = 40000;
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < y.length; j++){
                double temp = Math.sqrt(Math.pow(x[i] + x[j],2) 
                        + Math.pow(y[i] + y[j],2));
                if(temp < distance){
                    distance = temp;
                }
            }
        }
        return distance;
    }
    
    static double closestPair(double[] x, double[] y){
        int n = x.length;
        if(n <= 3){
            return bruteForce(x, y);
        } else {
            
        }
        return 0;
    }
    
    static void start(){
        double x[] = {3, 5, 9, 12};
        double y[] = {4, 12, 12, 16};
    }    
    
    public static void main(String args[]) {
        start();
    }
}
