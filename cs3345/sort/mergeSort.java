package cs3345.sort;

public class mergeSort {
    public static void sort(int[] arr){
        mergeSplit(arr, arr.length);
    }
    @SuppressWarnings("ManualArrayToCollectionCopy")
    private static void mergeSplit(int[] arr, int n){
        if(arr.length<=1){
            return;
        }

        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];

        for(int i=0;i<l.length;i++){
            l[i] = arr[i];
        }
        for(int i=0;i<r.length;i++){
            r[i] = arr[mid+i];
        }
        mergeSplit(l, mid);
        mergeSplit(r, n-mid);

        merge(arr, l, r, mid, n-mid);
    }
    private static void merge(int[] arr, int[] left, int[] right, int lLen, int rLen){
        int i = 0;
        int j = 0;
        int k = 0;
        while( i < lLen && j < rLen){
            if( left[i]<=right[j] ){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while (i < lLen){
            arr[k++] = left[i++];
        }
        while (j < rLen){
            arr[k++] = right[j++];
        }
    }
}
