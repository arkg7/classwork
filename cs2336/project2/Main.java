package project2;
//Archer Games
//axg230108
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        //Entry of file names
        System.out.println("Enter the name of the file containing drivers' routes. (File Extension too.)");
        String routefile = input.nextLine();
        System.out.println("Enter the name of the file containing the search and sort. (File Extension too.)");
        String cmdfile = input.nextLine();
        input.close();
        //Reading routes file
        Scanner routeReader = new Scanner(new File(routefile));
        while(routeReader.hasNextLine()){
            //Validation tests - Name
            String[] routeLine = routeReader.nextLine().split(" ");
            if(!Pattern.matches("[a-zA-Z[0-9][-][']]+",routeLine[0])){
                continue;
            }
            //Validate first coord = last coord
            else if (!(routeLine[1].equals(routeLine[routeLine.length-1].replace("\n","")))){
                continue;
            }
            //Validate that each coord is formatted right
            for(int i = 1;i<routeLine.length;i++){
                if(!Pattern.matches("[-[0-9]]+,[-[0-9[\n]]]+",routeLine[i])){
                    continue;
                }
            }
            //Gather data for node creation
            String driver = routeLine[0];
            double[][] coords = new double[routeLine.length-1][2];
            for(int i=1;i<coords.length+1;i++){
                String[] coord = routeLine[i].split(",");
                coords[i-1][0] = Double.parseDouble(coord[0]);
                coords[i-1][1] = Double.parseDouble(coord[1]);
            }
            double area = 0;
            for(int i=0;i<coords.length-1;i++){
                area += (coords[i+1][0]+coords[i][0])*(coords[i+1][1]-coords[i][1]);
            }
            area = Math.abs(area/2);
            //Adding node to list
            list.addBackNode(new Node(new Driver(driver,area)));
        }
        System.out.println(list.toString());
        //Reading cmd file
        Scanner cmdReader = new Scanner(new File(cmdfile));
        while(cmdReader.hasNextLine()){
            String cmdLine = cmdReader.nextLine();
            //Validtion tests - sort
            if(Pattern.matches("sort (driver|area) (asc|des)",cmdLine)){
                String[] cmd = cmdLine.split(" ");
                Driver.setComparable(cmd[1],cmd[2]);
                list.sort();
                System.out.println(list.toString());
            }
            //Validate number search
            else if(Pattern.matches("[0-9[.]]+",cmdLine)){
                System.out.println(list.search(Double.parseDouble(cmdLine)));
            }
            //Validate driver search
            else if(Pattern.matches("[a-zA-Z[0-9][-][']]+",cmdLine)){
                System.out.println(list.search(cmdLine));
            }
            else {
                continue;
            }
        }
    }
}
