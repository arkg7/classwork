package cs3345.fix;
import java.util.Scanner;
import java.util.Stack;
public class postfix{
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an infix expression: ");
        String infix = scan.nextLine();
        String postfix = "";
        String popped;
        Stack<String> opStack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            switch (infix.charAt(i)) {
                case ('(') -> opStack.push(infix.substring(i,i+1));
                case (')') -> {
                    popped = opStack.pop();
                    while(!popped.equals("(")){
                        postfix += popped;
                        popped = opStack.pop();
                    }
                }
                case ('^') -> {
                    popped = opStack.pop();
                    postfix += popped;
                    opStack.push(infix.substring(i,i+1));
                }
                case ('*') -> {
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*")||opStack.peek().equals("^"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                }
                case ('/') -> {
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*")||opStack.peek().equals("^"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                }
                case ('+') -> {
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*")||opStack.peek().equals("+")||opStack.peek().equals("-")||opStack.peek().equals("^"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                }
                case ('-') -> {
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*")||opStack.peek().equals("+")||opStack.peek().equals("-")||opStack.peek().equals("^"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                }
                default -> postfix += infix.charAt(i);
            }
        }
        while(!opStack.isEmpty()){
            postfix+=opStack.pop();
        }
        System.out.println("Postfix: "+postfix);
        scan.close();
    }
}