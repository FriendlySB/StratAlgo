package Week3;

public class BubbleSort {
    public static int[] bubbleSort (int[] array){
       for (int i = 0; i < array.length - 1; i++){
           for (int j = 0; j < array.length - i - 1; j++){
               if (array[j] > array[j + 1]){
                   int temp = array[j];
                   array[j] = array[j + 1];
                   array[j + 1] = temp;
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
        bubbleSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String args[]) {
        Main();
    }
}
