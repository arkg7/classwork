package cs3345;
public class runtime{
    public static void main(String[] args) {
        long start = System.nanoTime();
        int sum = 0;
        int n = 1000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i*i; j++) {
                if(j % i == 0){
                    for (int k = 0; k < j; k++){
                        sum++;
                    }
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Sum: "+sum);
        System.out.println("Input size: "+n);
        System.out.println("Start time: "+start);
        System.out.println("End time: "+end);
        System.out.println("Elapsed duration: "+(end-start)+" nanoseconds");
    }
}   