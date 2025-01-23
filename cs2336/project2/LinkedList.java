package project2;
//Archer Games
//axg230108
public class LinkedList {
    private Node head;
    private Node tail;
    public LinkedList(){
    }
    public LinkedList(Node nodeIn){
        head = nodeIn;
        tail = nodeIn;
    }
    public String getHead(){
        return head.toString();
    }
    public String getTail(){
        return tail.toString();
    }
    public void setHead(Node headIn){
        head = headIn;
    }
    public void setTail(Node tailIn){
        tail = tailIn;
    }
    //Attaches new head node //Sets node to tail if there are no nodes
    public void addFrontNode(Node nodeIn){
        if(head==null&&tail==null){
            head = nodeIn;
            tail = nodeIn;
        }
        else{
            nodeIn.setNext(head);
            head.setPrevious(nodeIn);
            head = nodeIn;
        }
    }
    //Attaches new tail node //Sets node to tail if there are no nodes.
    public void addBackNode(Node nodeIn){
        if(head==null&&tail==null){
            head = nodeIn;
            tail = nodeIn;
        }
        else{
            nodeIn.setPrevious(tail);
            tail.setNext(nodeIn);
            tail = nodeIn;
        }
    }
    //Checks to see if the list is sorted: used in the sort algorithm.
    private boolean sorted(){
        boolean sorted = true;
        Node checkSort = head;
        while(checkSort.next()!=null){
            if(checkSort.compareTo(checkSort.next())>0){
                sorted = false;
            }
            checkSort = checkSort.next();
        }
        return sorted;
    }
    //the toString.
    public String toString(){
        Node currentNode = head;
        String out = currentNode.toString();
        while (currentNode!=tail){
            currentNode = currentNode.next();
            out += currentNode.toString();
        }
        return out;
    }
    //searches the list for a node containing the requested double, returns first result
    public String search(double queryIn){
        Node currentNode = head;
        double query = (int)(queryIn*100);
        query/=100;
        String[] nodeInfo = currentNode.toString().split("\t");
        while(Double.parseDouble(nodeInfo[1].replace("\n",""))!=query){
            if(currentNode.equals(tail)){
                return (String.format("%.2f not found\n",queryIn));
            }
            currentNode = currentNode.next();
            nodeInfo = currentNode.toString().split("\t");

        }
        return currentNode.toString();
    }
    //searches the list for a node containing the requested name, returns first result.
    public String search(String queryIn){
        Node currentNode = head;
        String[] nodeInfo = currentNode.toString().split("\t");
        while(!nodeInfo[0].equals(queryIn)){
            if(currentNode.equals(tail)){
                return queryIn+" not found";
            }
            currentNode = currentNode.next();
            nodeInfo = currentNode.toString().split("\t");
        }
        return currentNode.toString();
    }
    //the sort.
    public void sort(){
        //goes until list is sorted (sort runs n time for bubble sort where n is length of list)
        while(!sorted()){
        Node currentNode = head;
        Node nextNode = head.next();
        //go from front of list to back of list
        while(nextNode!=null){
        //comparing nodes
        if(currentNode.compareTo(nextNode)>0){
            //node swap time
            //if they need swap and is first node is not head
            if(currentNode.previous()!=null){
                currentNode.previous().setNext(nextNode);
            }
            //if they need swap and first node is head
            else{
                setHead(nextNode);
            }
            //if they need swap and second node is not tail
            if(nextNode.next()!=null){
                nextNode.next().setPrevious(currentNode);
            }
            //if they need swap and second node is tail
            else{
                setTail(currentNode);
            }
            //changing pointers so that they reference the nodes in the right order.
            currentNode.setNext(nextNode.next());
            nextNode.setPrevious(currentNode.previous());
            currentNode.setPrevious(nextNode);
            nextNode.setNext(currentNode);
            //swapping the nodes
            Node temp = currentNode;
            currentNode = nextNode;
            nextNode = temp;
        }
        //move on to next nodes.
        currentNode = currentNode.next();
        nextNode = currentNode.next();
        }
        }
    }
}
