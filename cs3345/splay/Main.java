package cs3345.splay;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cmd;
        System.out.println("Enter a integer: ");
        int splaykey = scan.nextInt();
        Splaytree splaytree = new Splaytree(new Node(1));
        for (int i = 2; i <= splaykey; i++){
            splaytree.insert(new Node(i));
        }
        System.out.println("\nPre:");
        splaytree.preOrder();
        scan.nextLine();
        String input; 
        do { 
            System.out.println("\nEnter a command (insert|delete|search key) or type \"exit\" to stop.");
            input = scan.nextLine();
            cmd = input.split(" ");
            switch (cmd[0].toLowerCase()) {
                case "insert" -> {
                    splaytree.insert(new Node(Integer.parseInt(cmd[1])));
                    System.out.println("\nPre:");
                    splaytree.preOrder();
                }
                case "delete" -> {
                    splaytree.delete(Integer.parseInt(cmd[1]));
                    System.out.println("\nPre:");
                    splaytree.preOrder();
                }
                case "search" -> {
                    splaytree.search(Integer.parseInt(cmd[1]));
                    System.out.println("\nPre:");
                    splaytree.preOrder();
                }
                case "exit" -> {

                }
                default -> System.out.println("Command not found.");
            }
        } while (!input.equals("exit"));
        scan.close();
    }
}
