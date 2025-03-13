package cs3345.fix;
import java.util.Scanner;
import java.util.Stack;
public class infix{
    public static void main(String[] args) {
        Stack<String> opStack = new Stack<>();
        String infix = "";
        Scanner scan = new Scanner(System.in);
        String postfix = scan.nextLine();
        System.out.println("Postfix:"+postfix);
        for (int i = 0; i < postfix.length(); i++) {
            String op1;
            String op2;
            switch(postfix.charAt(i)){
                case('*'):
                    op1 = opStack.pop();
                    op2 = opStack.pop();
                    opStack.push("("+op2+postfix.charAt(i)+op1+")");
                    break;
                case('/'):
                    op1 = opStack.pop();
                    op2 = opStack.pop();
                    opStack.push("("+op2+postfix.charAt(i)+op1+")");
                    break;
                case('+'):
                    op1 = opStack.pop();
                    op2 = opStack.pop();
                    opStack.push("("+op2+postfix.charAt(i)+op1+")");
                    break;
                case('-'):
                    op1 = opStack.pop();
                    op2 = opStack.pop();
                    opStack.push("("+op2+postfix.charAt(i)+op1+")");
                    break;
                default:
                    opStack.push(postfix.substring(i,i+1));
                    break;
            }
            
        }
        if(opStack.size()==1){
                infix += opStack.pop();
        }
        System.out.println("Postfix:"+infix);
    }
}