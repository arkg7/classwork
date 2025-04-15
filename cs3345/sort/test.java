package cs3345.sort;

public class test {
    public static void main(String[] args) {
        int[] arr1 = {43, 2, 19, 12, 50, 27, 3, 35, 6, 41};
        int[] arr2 = {43, 2, 19, 12, 50, 27, 3, 35, 6, 41, 24, 38, 11, 46, 22, 5, 9, 17,
            48, 8};
        int[] arr3 = {43, 2, 19, 12, 50, 27, 3, 35, 6, 41, 24, 38, 11, 46, 22, 5, 9, 17,
            48, 8, 33, 45, 29, 13, 25, 21, 18, 39, 7, 30};
        System.out.println("Test 1");
        long[] test1 = speedTest(arr1);
        test1 = speedTest(arr1);
        System.out.println("Test 2");
        long[] test2 = speedTest(arr2);
        System.out.println("Test 3");
        long[] test3 = speedTest(arr3);

        for(int i = 0; i<2; i++){
            if(i==0){
                System.out.println("\nMergesort Time elapsed (nanoseconds):\t\t\tTest 1\t\t\tTest 2\t\t\tTest 3");
            }else{
                System.out.println("\nQuicksort Time elapsed (nanoseconds):");
            }
            System.out.print("\t\t\t\t\t\t\t");
            System.out.print(test1[i]+"\t\t\t");
            System.out.print(test2[i]+"\t\t\t");
            System.out.print(test3[i]+"\t\t\t");
            System.out.println();
        }
    }
    private static long[] speedTest(int[] arr){
        long start;
        long end;
        long mergeSortTime;
        long quickSortTime;
        int[] arr11 = new int[arr.length];
        int[] arr12 = new int[arr11.length];
        System.arraycopy(arr, 0, arr11, 0, arr11.length);
        System.arraycopy(arr, 0, arr12, 0, arr12.length);
        System.out.println("Unsorted Array: ");
        for(int i: arr11){
            System.out.print(i+" ");
        }
        System.out.println("\n");
        start = System.nanoTime();
        mergeSort.sort(arr11);
        end = System.nanoTime();
        System.out.println("Start: "+start);
        System.out.println("End:   "+end);
        mergeSortTime = end-start;
        System.out.println("Mergesorted Array: ");
        for(int i: arr11){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Mergesort Elapsed time (nanoseconds): "+mergeSortTime+"\n");
        start = System.nanoTime();
        quickSort.sort(arr12);
        end = System.nanoTime();
        System.out.println("Start: "+start);
        System.out.println("End:   "+end);
        quickSortTime = end-start;
        System.out.println("Quicksorted Array: ");
        for(int i: arr12){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Quicksort Elapsed time (nanoseconds): "+quickSortTime+"\n");
        long[] out = {mergeSortTime, quickSortTime};
        return (out);
    }
}
