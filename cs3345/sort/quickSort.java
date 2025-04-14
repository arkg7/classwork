package cs3345.sort;
//quicksort - median of three partition - cutoff 15
public class quickSort {
    public static void sort(int[] arr){
        int partIndex = partition(arr);
    }
    private static int partition(int[] arr){
        int[] med = {arr[0],arr[arr.length/2],arr[arr.length]};
        if(med[0]>med[1]){
            int temp = med[0];
            med[0] = med[1];
            med[1] = med[0];
        }
        int value = med[2];
        int i = 1;
        while(value<med[i--]){
            med[i+1]=med[i];
        }
        med[i] = value;

    }
}
