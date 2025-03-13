package cs3345.splay;

public class Node implements Comparable<Node> {
    private int value;
    private Node parentNode;
    private Node leftSubNode;
    private Node rightSubNode;
    public Node(int value){
        this.value = value;
    }
    public void setLeftChild(Node childNode){
        leftSubNode = childNode;
    }
    public void setRightChild(Node childNode){
        rightSubNode = childNode;
    }
    public void setParent(Node node){
        parentNode = node;
    }
    public int getValue(){
        return value;
    }
    public Node getLeftChild(){
        return leftSubNode;
    }
    public Node getRightChild(){
        return rightSubNode;
    }
    public Node getParent(){
        return parentNode;
    }
    public Boolean hasLeftChild(){
        if(leftSubNode!=null){
            return true;
        }
        return false;
    }
    public Boolean hasRightChild(){
        if(rightSubNode!=null){
            return true;
        }
        return false;
    }
    public Boolean hasParent(){
        if(parentNode!=null){
            return true;
        }
        return false;
    }
    public String toString(){
        String out = ""+value;
        return out;
    }
    public int compareTo(Node compNode){
        if(value<compNode.getValue()){
            return -1;
        }
        if(value>compNode.getValue()){
            return 1;
        }
        else return 0;
    }
    
}
