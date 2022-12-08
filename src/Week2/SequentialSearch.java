package Week2;

public class SequentialSearch {
    
    static int search(int array[], int search){
        for(int i = 0; i < array.length; i++){
            if(array[i] == search){
                return i;
            }
        }
        return -1;
    }
    
    static void MainMenu (){
        //Array yang akan disearch
        int array[] = {3,6,7,1,8,10,2,9,5,4,6,7,8,1,2,3,4,5,8,11,21,33,45,56,56,
            78,98,45,35,69,56,56,44,10,0,11,12,12,10,13,14,53,23,44,76,89,12,16,
            19,29,12,44,56,77,0,22,34,56,78,89,21,45,77,32,12,44,70,24,98,20,21,
            45,67,23,34,56,99,23,67,79,81,24,23,56,76,89,20,33,92,20,21,1,2,5,6,
            7,99,2,33,1};
        //Angka yang dicari
        int search = 100;
        int index = search(array, search);
        if(index == - 1){
            System.out.println("Data not found");
        }
        else {
            System.out.println("Data found at index " + index);
        }
    }
    
    public static void main(String args[]) {
        MainMenu();
    }
}
