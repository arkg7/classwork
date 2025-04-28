package cs3345.maze;

public class cell {
    private int[] paths = {0,0,0,0};
    public cell(){
    }
    public void breakWall(String dir){
        if(dir.equals("N")){
            paths[0] = 1;
        }if(dir.equals("E")){
            paths[1] = 1;
        }if(dir.equals("S")){
            paths[2] = 1;
        }if(dir.equals("W")){
            paths[3] = 1;
        }
    }
    public int[] getPaths(){
        return paths;
    }
}
