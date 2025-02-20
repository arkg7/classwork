package cs3345;
import java.util.Stack;
public class postfix{
    public static void main(String[] args) {
        String infix = "A+(B*C+D)/E";
        String postfix = "";
        String popped;
        Stack<String> opStack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            System.out.println("Opstack: "+opStack);
            System.out.println("Char:"+infix.charAt(i));
            System.out.println("Postfix:"+postfix+"\n");
            switch (infix.charAt(i)) {
                case ('('):
                    opStack.push(infix.substring(i,i+1));
                    break;
                case (')'):
                    popped = opStack.pop();
                    while(!popped.equals("(")){
                        postfix += popped;
                        popped = opStack.pop();
                    }   
                    break;
                case ('*'):
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                    break;
                case ('/'):
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                    break;
                case ('+'):
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*")||opStack.peek().equals("+")||opStack.peek().equals("-"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                    break;
                case ('-'):
                    while(!opStack.isEmpty()&&(opStack.peek().equals("/")||opStack.peek().equals("*")||opStack.peek().equals("+")||opStack.peek().equals("-"))){
                        popped = opStack.pop();
                        postfix += popped;
                    }
                    opStack.push(infix.substring(i,i+1));
                    break;
                default:
                    postfix += infix.charAt(i);
            }
        }
        while(!opStack.isEmpty()){
            postfix+=opStack.pop();
        }
        System.out.println("Postfix: "+postfix);
    }
}