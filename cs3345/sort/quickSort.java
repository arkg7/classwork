package cs3345.sort;
//quicksort - median of three partition - cutoff 15

public class quickSort {
    public static void sort(int[] arr){
        quickRecur(arr, 0, arr.length-1);
    }

    private static void quickRecur(int[] arr, int start, int end){
        median(arr, start, end);
        partition(arr, start, end);
        
    } 

    private static void median(int[] arr, int l, int r){
        int mid = (l + r)/2;
        if(arr[l]>=arr[mid]&&arr[0]<=arr[r]||arr[l]<=arr[mid]&&arr[l]>=arr[r]){
            swap(arr, l, r);
        }else if(arr[mid]>=arr[l]&&arr[mid]<=arr[r]||arr[mid]<=arr[l]&&arr[mid]>=arr[r]){
            swap(arr, mid, r);
        }
    }

    private static void partition(int[] arr, int l, int r){
        int i = l;
        int j = r-1;
        while(i<j){
            while(arr[i]<arr[r]){
                i++;
            }
            while(arr[j]>arr[r]){
                j--;
            }
            if(arr[i]>arr[j]){
                swap(arr, i, j);
            }
        }
        swap(arr, i, r);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
