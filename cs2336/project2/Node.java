package project2;
//Archer Games
//axg230108
public class Node implements Comparable<Node>{
    //I really dont think anything in here is significantly complex enough to warrant a comment.
    private Driver driver;
    private Node nextNode;
    private Node previousNode;
    public Node(Driver driverIn){
        driver = driverIn;
    }
    public Node(Node nodeIn){
        driver = nodeIn.getDriver();
        nextNode = nodeIn.next();
        previousNode = nodeIn.previous();
    }
    public Node previous(){
        return previousNode;
    }
    public Node next(){
        return nextNode;
    }
    public Driver getDriver(){
        return driver;
    }
    public void setPrevious(Node previousIn){
        previousNode = previousIn;
    }
    public void setNext(Node nextIn){
        nextNode = nextIn;
    }
    public int compareTo(Node nodeIn){
        return(driver.compareTo(nodeIn.driver));
    }
    public String toString(){
        return driver.toString();
    }
}
