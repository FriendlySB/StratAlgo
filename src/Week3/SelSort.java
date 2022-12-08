
package Week3;

public class SelSort {

    static int[] sorting(int array[]){
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                int temp;
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    
    
    static void Main (){
        int array[] = {11,12,7,1,9,3,22,21,10,5,4,15};
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n------------------------------");
        sorting(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String args[]) {
        Main();
    }
}
