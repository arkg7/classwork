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
            if(curNode.getValue()==node.getValue()){
                System.out.println("Key "+node.getValue()+" is already present in the tree.");
                break;
            }
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
        if(inserted){
           splay(node.getValue()); 
        }
    }
    public Node search(int searchValue){
        splay(searchValue);
        return root;
    }
    public void delete(int key){
        if(splay(key)){
            if(root.getValue()==key){
                if(root.hasLeftChild()&&root.hasRightChild()){
                    Node curNode = root.getLeftChild();
                    while(curNode.hasRightChild()){
                        curNode = curNode.getRightChild();
                    }
                    splay(curNode.getValue());
                    if(root.getRightChild().hasRightChild()){
                        root.setRightChild(root.getRightChild().getRightChild());
                        root.getRightChild().setParent(root);
                    }else{
                        root.setRightChild(null);
                    }
                }else if(root.hasLeftChild()){
                    root = root.getLeftChild();
                    root.setParent(null);
                }else if(root.hasRightChild()){
                    root = root.getRightChild();
                    root.setParent(null);
                }
            }
        }else{
            System.out.println("Node "+key+" could not be found.");
        }
    }
    public Boolean splay(int splayNode){
        Node curNode = root;
        //Initializes curNode to the root, and moves down the tree to the desired node using binary search algorithm
        while(curNode.getValue()!=splayNode){
            //If key less than node, moves left.
            if(splayNode<curNode.getValue()){
                if(curNode.hasLeftChild()){
                   curNode = curNode.getLeftChild(); 
                }else{
                    //returns false if it reaches an end and cannot find the node.
                    return false;
                }
            //moves right if key greater than node.
            }else if(splayNode>curNode.getValue()){
                if(curNode.hasRightChild()){
                    curNode = curNode.getRightChild();
                }else{
                    //end reached and node not found.
                    return false;
                }
                
            }
        }
        while(curNode!=root){
            if (curNode.getSide()<0){
                //Right rotation
                //If not doing root rotation
                if(curNode.getParent().hasParent()){
                    //Gets side of parent node relative to grandparent node
                    if(curNode.getParent().getSide()>0){
                        curNode.getParent().getParent().setRightChild(curNode);
                    }else{
                        curNode.getParent().getParent().setLeftChild(curNode);
                    }
                    //
                    //Transfer right child to then-parent's then slot, sets null if no left child.
                    if(curNode.hasRightChild()){
                        curNode.getParent().setLeftChild(curNode.getRightChild());
                        curNode.getRightChild().setParent(curNode.getParent());
                    }else{
                        curNode.getParent().setLeftChild(null);
                    }
                    //Sets then-parent to now-right-child, and corrects parent, and then-right-child's parent relations
                    curNode.setRightChild(curNode.getParent());
                    curNode.setParent(curNode.getRightChild().getParent());
                    curNode.getRightChild().setParent(curNode);
                //
                //Doing root rotation
                }else{
                    //If has right child, move then-right-child to then-parent-left-child space, else set then-parent-left-child space to null
                    if(curNode.hasRightChild()){
                        curNode.getParent().setLeftChild(curNode.getRightChild());
                        curNode.getRightChild().setParent(curNode.getParent());
                    }else{
                        curNode.getParent().setLeftChild(null);
                    }
                    //
                    //Set then-parent to now-right-child, and corrects parent, and then-right-child's parent relations
                    curNode.setRightChild(curNode.getParent());
                    curNode.getRightChild().setParent(curNode);
                    curNode.setParent(null);
                    root = curNode;
                    //Sets now-root-parent space to null
                }
            }else if (curNode.getSide()>0){
                //Left Rotation
                //If not doing root rotation
                if(curNode.getParent().hasParent()){
                    //Gets side of parent node to adjust side of child
                    if(curNode.getParent().getSide()>0){
                        curNode.getParent().getParent().setRightChild(curNode);
                    }else{
                        curNode.getParent().getParent().setLeftChild(curNode);
                    }
                    //
                    //Transfer left child to then-parent's right slot, sets null if no left child.
                    if(curNode.hasLeftChild()){
                        curNode.getParent().setRightChild(curNode.getLeftChild());
                        curNode.getLeftChild().setParent(curNode.getParent());
                    }else{
                        curNode.getParent().setRightChild(null);
                    }
                    //Sets then-parent to now-left-child, and corrects parent, and then-left-child's parent relations
                    curNode.setLeftChild(curNode.getParent());
                    curNode.setParent(curNode.getLeftChild().getParent());
                    curNode.getLeftChild().setParent(curNode);
                //
                //Doing root rotation
                }else{
                    //If has left child, move then-left-child to then-parent-right-child space, else set then-parent-right-child space to null
                    if(curNode.hasLeftChild()){
                        curNode.getParent().setRightChild(curNode.getLeftChild());
                        curNode.getLeftChild().setParent(curNode.getParent());
                    }else{
                        curNode.getParent().setRightChild(null);
                    }
                    //
                    //Set then-parent to now-right-child, and corrects parent, and then-right-child's parent relations
                    curNode.setLeftChild(curNode.getParent());
                    curNode.getLeftChild().setParent(curNode);
                    curNode.setParent(null);
                    root = curNode;
                    //Sets now-root-parent space to null
                }
            }
        }
        //returns true for a successful splay
        return true;
    }
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        System.out.print(" "+node.getValue());
        if(node.getSide()<0){
            System.out.print("L ");
        }else if(node.getSide()>0){
            System.out.print("R ");
        }else{
            System.out.print("RT ");
        }
        if(node.hasLeftChild()){
            preOrder(node.getLeftChild());
        }
        if(node.hasRightChild()){
            preOrder(node.getRightChild());
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(Node node){
        if(node.hasLeftChild()){
            inOrder(node.getLeftChild());
        }
        System.out.print(" "+node.getValue());
        if(node.getSide()<0){
            System.out.print("L ");
        }else if(node.getSide()>0){
            System.out.print("R ");
        }else{
            System.out.print("RT ");
        }
        if(node.hasRightChild()){
            inOrder(node.getRightChild());
        }
    }
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(Node node){
        if(node.hasLeftChild()){
            postOrder(node.getLeftChild());
        }
        if(node.hasRightChild()){
            postOrder(node.getRightChild());
        }
        System.out.print(" "+node.getValue());
        if(node.getSide()<0){
            System.out.print("L ");
        }else if(node.getSide()>0){
            System.out.print("R ");
        }else{
            System.out.print("RT ");
        }
    }
}
