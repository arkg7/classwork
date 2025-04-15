package project1;
//Archer Games
//axg230108
import java.io.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) throws IOException{
        double[][][] coord = new double[20][16][2]; 
        String[] pilot = new String[20];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the file containing flight data.");
        String input = scan.nextLine();
        scan.close();
        populate(coord, pilot, input);
        write(coord, pilot);
        scan.close();
    }
    //the FUN part >:3
    public static void populate(double[][][] table, String[] list, String in) throws FileNotFoundException{
        //creates a scanner
        Scanner read = new Scanner(new File(in));
        //if there is another line to be read...
        for(int i=0;read.hasNextLine();i++){
            //... it reads it and puts the line into an array of each item seperated by a space
            String[] data = read.nextLine().split(" ");
            //assigns the pilot's name to the first item in the array
            list[i] = data[0];
            //fills the double[][][] array with each set of coordinates, seperated by a ",", for each pilot
            for(int j=1;j<data.length;j++){
                String[] xy = data[j].split(",");
                table[i][j-1][0] = new Double(xy[0]);
                table[i][j-1][1] = new Double(xy[1]);
            }
        }
    }
    public static double calcArea(double[][][] table, String[] list, int index){
        double area = 0;
        //The provided math equation to calculate the area of the area patrolled
        for(int i=0;i<table[0].length-2;i++){
            area += (table[index][i+1][0]+table[index][i][0])*(table[index][i+1][1]-table[index][i][1]);
        }
        area = Math.abs(area/2);
        //rounding.
        area = Math.round(area*100);
        area = area/100;
        return area;
    }
    public static void write(double[][][] table, String[] list) throws IOException{
        //creates the output file
        FileWriter writer = new FileWriter("pilot_areas.txt");
        //as long as there is another pilot...
        for(int j=0;j<list.length&&list[j]!=null&&j<20;j++){
            //... it will build a string for proper output, utilizing the calcArea method.
            String out = String.format("%s %.2f",list[j],calcArea(table, list, j));
            //writes the output string to the output file.
            writer.write(out);
            //if there is another pilot, it will add a new line for them.
            if(j!=19){
                if(list[j+1]!=null){
                    writer.write("\n");
                }
            }
            writer.flush();
        }
        writer.close();
    }
}