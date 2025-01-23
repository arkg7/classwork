package project3;
//Archer Games
//axg230108
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the name of the file containing the galaxy map. (File extension included.)");
        String input = userInput.nextLine();
        Scanner mapReader = new Scanner(new File(input));
        Graph map = new Graph();
        while(mapReader.hasNextLine()){
            String line = mapReader.nextLine();
            String vertice = line.split(" ")[0];
            line = line.substring(vertice.length()+1);
            String[] edges = line.split(" ");
            map.addVert(vertice, edges);
        }
        mapReader.close();
        ArrayList<String> pilots = new ArrayList<String>();
        System.out.println("Enter the name of the file containing the pilot routes. (File extension included.)");
        input = userInput.nextLine();
        Scanner pilotReader = new Scanner(new File(input));
        while(pilotReader.hasNextLine()){
            String line = pilotReader.nextLine();
            int pathWeight = 0;
            String validity = "valid";
            String name = line.split(" ")[0];
            line = line.substring(name.length()+1);
            String[] vertices = line.split(" ");
            for(int i = 0;i<vertices.length-1;i++){
                int subWeight = map.getWeight(vertices[i],vertices[i+1]);
                pathWeight += subWeight;
                if(subWeight == -1){
                    validity = "invalid";
                    pathWeight *= 0;
                    continue;
                }
            }
            pilots.add(name+"\t"+pathWeight+"\t"+validity);
        }
        pilotReader.close();
        userInput.close();
        for(int i=0;i<pilots.size();i++){
            for(int j=0;j<pilots.size()-1;j++){
                if(Integer.parseInt(pilots.get(j).split("\t")[1])<Integer.parseInt(pilots.get(j+1).split("\t")[1])){
                    Collections.swap(pilots, j, j+1);
                }
            }
        }
        for(int i=0;i<pilots.size();i++){
            for(int j=0;j<pilots.size()-1;j++){
                if(Integer.parseInt(pilots.get(j).split("\t")[1])==Integer.parseInt(pilots.get(j+1).split("\t")[1])){
                    if(pilots.get(j).split("\t")[0].compareTo(pilots.get(j+1).split("\t")[0])>0){
                        Collections.swap(pilots, j, j+1);
                    }
                }
            }
        }
        FileWriter out = new FileWriter("patrols.txt");
        for(int i=0;i<pilots.size();i++){
            out.write(pilots.get(i));
            if(i<pilots.size()-1){
                out.write("\n");
            }
            out.flush();
        }
        out.close();
        System.out.println(map.toString());
    }    
}
