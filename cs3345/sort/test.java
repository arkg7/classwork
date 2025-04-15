package cs3345.sort;

public class test {
    public static void main(String[] args) {
        int[] arr = {43, 2, 19, 12, 50, 27, 3, 35, 6, 41, 24, 38, 11, 46, 22, 5, 9, 17,
            48, 8, 33, 45, 29, 13, 25, 21, 18, 39, 7, 30, 36, 10, 20, 1, 26, 44
            };
        int[] arr2 = {43, 2, 19, 12, 50, 27, 3, 35, 6, 41, 24, 38, 11, 46, 22, 5, 9, 17,
            48, 8, 33, 45, 29, 13, 25, 21, 18, 39, 7, 30, 36, 10, 20, 1, 26, 44
            };
        mergeSort.sort(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
        quickSort.sort(arr2);
        for(int i: arr2){
            System.out.print(i+" ");
        }

    }
}
