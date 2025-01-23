package project3;
//Archer Games
//axg230108
import java.util.ArrayList;

public class Graph {
    ArrayList<String> vertices = new ArrayList<String>();
    ArrayList<ArrayList<String>> edges = new ArrayList<ArrayList<String>>();
    public Graph(){
    }
    public Graph(String vertex, String[] edge){
        vertices.add(vertex);
        edges.add(new ArrayList<String>());
        for(String i:edge){
            edges.get(vertices.indexOf(vertex)).add(i);
        }
    }
    public void addVert(String vertex, String[] edge){
        if(!vertices.contains(vertex)){
            vertices.add(vertex);
            edges.add(new ArrayList<String>());
            for(String i:edge){
                edges.get(vertices.indexOf(vertex)).add(i);
            }
        }
        else{
            for(String i:edge){
                if(!edges.get(vertices.indexOf(vertex)).contains(i)){
                    edges.get(vertices.indexOf(vertex)).add(i);
                }
            }
        }
    }
    public int getWeight(String start, String end){
        if(!vertices.contains(start)){
            return -1;
        }
        else{
            for(String edge:edges.get(vertices.indexOf(start))){
                if(edge.split(",")[0].equals(end)){
                    return Integer.parseInt(edge.split(",")[1]);
                }
            }
        }
        return -1;
    }
    public String toString(){
        String out = "";
        for(int i=0;i<vertices.size();i++){
            out+=vertices.get(i)+"\n";
            for(String j:edges.get(i)){
                out+="\t"+j+"\n";
            }
        }
        return out;
    }
}
