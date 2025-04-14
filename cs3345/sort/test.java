package cs3345.sort;

public class test {
    public static void main(String[] args) {
        int[] arr = {11,4,6,3,6,7,8,1,3,6,10,2};
        int[] arr2 = arr;
        mergeSort.sort(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
        quickSort.sort(arr2);
        for(int i: arr){
            System.out.print(i+" ");
        }

    }
}
