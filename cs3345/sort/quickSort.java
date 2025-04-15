package cs3345.sort;
//quicksort - median of three partition - cutoff 15

public class quickSort {
    public static void sort(int[] arr){
        quickRecur(arr, 0, arr.length-1);
    }

    private static void quickRecur(int[] arr, int start, int end){
        if(end-start<=15){insertSort(arr, start, end);return;}
        median(arr, start, end);
        int partIndex = partition(arr, start, end);

        quickRecur(arr, start, partIndex-1);
        quickRecur(arr, partIndex+1, end);
        
    } 

    private static void median(int[] arr, int l, int r){
        int mid = (l + r)/2;
        if(arr[l]>=arr[mid]&&arr[0]<=arr[r]||arr[l]<=arr[mid]&&arr[l]>=arr[r]){
            swap(arr, l, r);
        }else if(arr[mid]>=arr[l]&&arr[mid]<=arr[r]||arr[mid]<=arr[l]&&arr[mid]>=arr[r]){
            swap(arr, mid, r);
        }
    }

    private static int partition(int[] arr, int l, int r){
        int i = l;
        int j = r-1;
        while(i<j){
            if(arr[i]>arr[j]){
                swap(arr, i, j);
            }
            while(arr[i]<arr[r]){
                i++;
            }
            while(arr[j]>arr[r]){
                j--;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void insertSort(int[] arr, int left, int right){
        for(int i = left+1; i <= right;i++){
            if(arr[i]<arr[i-1]){
                int idx = i;
                int temp = arr[i];
                while(idx>left&&temp<arr[idx-1]){
                    arr[idx] = arr[idx-1];
                    idx--;
                }
                arr[idx] = temp;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
