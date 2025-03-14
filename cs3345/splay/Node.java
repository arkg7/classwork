package cs3345.splay;

public class Node implements Comparable<Node> {
    @SuppressWarnings("FieldMayBeFinal")
    private int value;
    private Node parentNode;
    private int parentSide;
    private Node leftSubNode;
    private Node rightSubNode;
    public Node(int nodeValue){
        value = nodeValue;
    }
    public void setLeftChild(Node childNode){
        leftSubNode = childNode;
        if(childNode!=null){
            childNode.setSide(-1);
        }
    }
    public void setRightChild(Node childNode){
        rightSubNode = childNode;
        if(childNode!=null){
            childNode.setSide(1);
        }
    }
    public void setParent(Node node){
        parentNode = node;
        if(node == null){
            parentSide = 0;
        }
    }
    public void setSide(int side){
        parentSide = side;
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
    public int getSide(){
        return parentSide;
    }
    public Boolean hasLeftChild(){
        return leftSubNode!=null;
    }
    public Boolean hasRightChild(){
        return rightSubNode!=null;
    }
    public Boolean hasParent(){
        return parentNode!=null;
    }
    @Override
    public String toString(){
        String out = ""+value;
        return out;
    }
    @Override
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
