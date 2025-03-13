package cs3345.splay;

public class Main {
    public static void main(String[] args) {
        Splaytree splay = new Splaytree(new Node(2));
        splay.insert(new Node(1));
        splay.insert(new Node(3));
        System.out.println("\nPre:");
        splay.preOrder(splay.getRoot());
        System.out.println("\nIn:");
        splay.inOrder(splay.getRoot());
        System.out.println("\nPost:");
        splay.postOrder(splay.getRoot());
    }
}
