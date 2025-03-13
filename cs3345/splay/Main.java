package cs3345.splay;

public class Main {
    public static void main(String[] args) {
        Splaytree splaytree = new Splaytree(new Node(2));
        splaytree.insert(new Node(1));
        splaytree.insert(new Node(3));
        System.out.println("\nPre:");
        splaytree.preOrder(splaytree.getRoot());
        System.out.println("\nIn:");
        splaytree.inOrder(splaytree.getRoot());
        System.out.println("\nPost:");
        splaytree.postOrder(splaytree.getRoot());
        splaytree.splay(3);
        System.out.println("\nSplay: 3");
        splaytree.inOrder(splaytree.getRoot());
    }
}
