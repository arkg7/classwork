package cs3345.splay;

public class Splaytree {
    private Node root;
    public Splaytree(Node root){
        this.root = root;
    }
    public Node getRoot(){
        return root;
    }
    public void insert(Node node){
        Node curNode = root;
        Boolean inserted = false;
        while(!inserted){
            if(node.compareTo(curNode)<0){
                if(curNode.hasLeftChild()){
                    curNode = curNode.getLeftChild();
                    continue;
                }
                curNode.setLeftChild(node);
                node.setParent(curNode);
                inserted = true;
                continue;
            }
            if(node.compareTo(curNode)>0){
                if(curNode.hasRightChild()){
                    curNode = curNode.getRightChild();
                    continue;
                }
                curNode.setRightChild(node);
                node.setParent(curNode);
                inserted = true;
            }
        }
        splay(node.getValue());
    }
    public void splay(int splayNode){
        Node curNode = root;
        while(curNode.getValue()!=splayNode){
            if(splayNode<curNode.getValue()){
                curNode = curNode.getLeftChild();
                continue;
            }
            if(splayNode>curNode.getValue()){
                curNode = curNode.getRightChild();
                continue;
            }
        }
        while(curNode!=root){
            if(curNode.getParent().getLeftChild()==curNode){
                curNode.getParent().getParent().setLeftChild(curNode);
                curNode.getParent().setLeftChild(curNode.getRightChild());
                curNode.setRightChild(curNode.getParent());
                curNode.setParent(curNode.getRightChild().getParent());
                curNode.getRightChild().setParent(curNode);

            }
            if(curNode.getParent().getRightChild()==curNode){
                curNode.getParent().getParent().setRightChild(curNode);
                curNode.getParent().setRightChild(curNode.getLeftChild());
                curNode.setLeftChild(curNode.getParent());
                curNode.setParent(curNode.getLeftChild().getParent());
                curNode.getRightChild().setParent(curNode);

            }
        }
    }
    public void preOrder(Node node){
        System.out.print(" "+node.getValue()+" ");
        if(node.hasLeftChild()){
            preOrder(node.getLeftChild());
        }
        if(node.hasRightChild()){
            preOrder(node.getRightChild());
        }
        
    }
    public void inOrder(Node node){
        if(node.hasLeftChild()){
            preOrder(node.getLeftChild());
        }
        System.out.print(" "+node.getValue()+" ");
        if(node.hasRightChild()){
            preOrder(node.getRightChild());
        }
    }
    public void postOrder(Node node){
        if(node.hasLeftChild()){
            preOrder(node.getLeftChild());
        }
        if(node.hasRightChild()){
            preOrder(node.getRightChild());
        }
        System.out.print(" "+node.getValue()+" ");
    }
}
