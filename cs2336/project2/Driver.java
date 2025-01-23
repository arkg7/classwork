package project2;
//Archer Games
//axg230108
public class Driver implements Comparable<Driver>{
    private String name;
    private double area;
    private static String[] comparable = new String[2];
    public Driver(String nameIn, double areaIn){
        name = nameIn;
        area = areaIn;
    }
    public Driver(String nameIn){
        name = nameIn;
    }
    public String getName(){
        return name;
    }
    public double getArea(){
        return area;
    }
    public void setName(String nameIn){
        name = nameIn;
    }
    public void setArea(double areaIn){
        area = areaIn;
    }
    public static void setComparable(String compIn,String order){
        comparable[0] = compIn;
        comparable[1] = order;
    }
    //compareTo.
    public int compareTo(Driver otherDriver){
        int out = 0;
        //standard asc order compareTo
        //blah blah if area number is greater driver is greater.
        if(comparable[0].equals("area")){
            if(area<otherDriver.getArea()){
                out = -1;
            }
            else if(area>otherDriver.getArea()){
                out = 1;
            }
            //flips the result if requested order is descending
            if(comparable[1].equals("des")){
                out*=-1;
            }
            return out;
        }
        //compares names using standard string compareTo
        else if(comparable[0].equals("driver")){
            out = (name.compareTo(otherDriver.name));
            //flips result for if requested in descending order.
            if(comparable[1].equals("des")){
                out*=-1;
            }
        }
        return out;
    }
    //the toString.
    public String toString(){
        double areaOut = (int)(area*100);
        areaOut = areaOut/100;
        return(String.format("%s\t%.2f\n", name,areaOut));
    }
}
