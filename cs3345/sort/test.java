package cs3345.sort;

public class test {
    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 10, 3, 6, 9, 2, 8, 5};
        int[] arr2 = {43, 18, 9, 27, 3, 31, 47, 39, 19, 50,
            2, 22, 26, 33, 15, 24, 36, 44, 7, 12,
            35, 17, 4, 13, 42, 28, 11, 32, 23, 8,
            30, 5, 38, 6, 40, 46, 1, 10, 14, 21,
            25, 37, 48, 20, 34, 41, 29, 16, 49, 45};
        int[] arr3 = {81, 25, 68, 11, 70, 33, 87, 7, 93, 63,
            55, 14, 32, 22, 47, 9, 19, 85, 53, 77,
            73, 41, 62, 27, 18, 36, 91, 16, 20, 8,
            42, 98, 97, 2, 6, 12, 84, 31, 29, 59,
            65, 26, 5, 35, 67, 38, 69, 49, 17, 40,
            61, 3, 10, 90, 71, 86, 13, 23, 43, 45,
            94, 4, 50, 24, 21, 75, 28, 64, 66, 99,
            58, 76, 96, 30, 39, 37, 74, 15, 44, 72,
            34, 48, 80, 78, 46, 1, 83, 52, 79, 88,
            89, 56, 60, 95, 92, 51, 100, 57, 54, 82};
        speedTest(arr1);
        System.out.println("Test 1");
        long[] test1 = speedTest(arr1);
        System.out.println("Test 2");
        long[] test2 = speedTest(arr2);
        System.out.println("Test 3");
        long[] test3 = speedTest(arr3);

        for(int i = 0; i<2; i++){
            if(i==0){
                System.out.println("\nMergesort Time elapsed (nanoseconds):\t\t\tTest 1 (10 int)\t\tTest 2 (50 int)\t\tTest 3 (100 int)");
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
