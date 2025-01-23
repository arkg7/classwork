package cs2336;
import java.util.Scanner;
public class number{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int num = 0;
        System.out.println("Enter an integer: ");
        int in = scan.nextInt();
        while(in != 0){
            sum += in;
            num++;
            System.out.println("Enter an integer: ");
            in = scan.nextInt();
        }
        System.out.println("The sum is "+sum);
        System.out.println("The number of integers entered was: "+num);
    }
}