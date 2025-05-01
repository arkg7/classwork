package cs3345.maze;

import java.util.Random;

public class Maze {
    private int[][] maze;
    private int[] union;
    private int wid;
    private int hig;
    public Maze(int n, int m){
        maze = new int[n][m];
        union = new int[n*m];
        hig = n;
        wid = m;
        for(int i = 0; i<union.length;i++){
            union[i] = -1;
        }
        maze[0][0] = 8;
        maze[n-1][m-1] = 2;
        Random r = new Random();
        while(union[0]!=(n*m*-1)){
            int cell = r.nextInt(n*m);
            while(union[cell]>=0){
                cell = r.nextInt(n*m);
            }
            int side = r.nextInt(4);
            while(!isValid(cell, side)){
                side = r.nextInt(4);
            }
            side = (int)Math.pow(2, side);
            switch (side) {
                case 1 -> {
                    if(getParent(cell)!=getParent(cell-m)){
                        maze[cell/m][cell%m] |= 1;
                        maze[(cell-m)/m][cell%m] |= 4;
                        if(cell<getParent(cell-m)){
                            union[cell] = union[getParent(cell-m)]+union[cell];
                            union[getParent(cell-m)] = cell;
                        }else{
                            union[getParent(cell-m)] = union[getParent(cell-m)]+union[cell];
                            union[cell] = cell-m;
                        }
                    }
                }
                case 2 -> {
                    if(getParent(cell)!=getParent(cell+1)){
                        maze[cell/m][cell%m] |= 2;
                        maze[cell/m][(cell+1)%m] |= 8;
                        if(cell<getParent(cell+1)){
                            union[cell] = union[getParent(cell+1)]+union[cell];
                            union[getParent(cell+1)] = cell;
                        }else{
                            union[getParent(cell+1)] = union[getParent(cell+1)]+union[cell];
                            union[cell] = cell+1;
                        }
                    }
                }
                case 4 -> {
                    if(getParent(cell)!=getParent(cell+m)){
                        maze[cell/m][cell%m] |= 4;
                        maze[(cell+m)/m][cell%m] |= 1;
                        if(cell<getParent(cell+m)){
                            union[cell] = union[getParent(cell+m)]+union[cell];
                            union[getParent(cell+m)] = cell;
                        }else{
                            union[getParent(cell+m)] = union[getParent(cell+m)]+union[cell];
                            union[cell] = cell+m;
                        }
                        
                    }
                }
                case 8 -> {
                    if(getParent(cell)!=getParent(cell-1)){
                        maze[cell/m][cell%m] |= 8;
                        maze[cell/m][(cell-1)%m] |= 2;
                        if(cell<getParent(cell-1)){
                            union[cell] = union[getParent(cell-1)]+union[cell];
                            union[getParent(cell-1)] = cell;
                        }else{
                            union[getParent(cell-1)] = union[getParent(cell-1)]+union[cell];
                            union[cell] = cell-1;
                        }
                    }
                }
            }
        }
    }
    private int getParent(int cell){
        int index;
        int parent = union[cell];
        if(parent<0){
            return cell;
        }else{
            do{
                index = parent;
                parent = union[parent];
            }while(parent>=0);
        }
        
        return index;
    }
    private boolean isValid(int cell, int side){
        if(cell/wid==0&&side==0){
            return false;
        }
        if(cell%wid==wid-1&&side==1){
            return false;
        }
        if(cell/wid==hig-1&&side==2){
            return false;
        }
        if(cell%wid==0&&side==3){
            return false;
        }else{
            return true;
        }
        
    }
    public String toString(){
        String out = "";
            for(int i: maze[0]){
                out+=(" _");
            }
            for(int[] i: maze){
                out+="\n";
                for(int j: i){
                    if((j|12)==j){
                        out+=("  ");
                    }else if ((j|4)==j) {
                        out+=("| ");
                    }else if ((j|8)==j) {
                        out+=(" _");
                    }else{
                        out+=("|_");
                    }
                }
                if((i[wid-1]|2)!=i[wid-1]){
                    out+=("|\t\t");
                }else{
                    out+=("\t\t");
                }
                
                for(int j: i){
                    out+=(j+"\t");
                }
            }
            out+="\n";
        return out;
    }
    private boolean canMove(int cell,int side){
        if((maze[cell/wid][cell%wid]|side)==maze[cell/wid][cell%wid]){
            return true;
        }
        return false;
    }
    public String getPath(){
        String out = "";
        int cell = 0;
        for(int i = 1; i<=2;i++){
            int side = (int)Math.pow(2, i);
            if(canMove(cell, side)){
                if(side == 2){
                    out+= "E" + getPath(cell+1, side);
                }else if(side == 4){
                    out+= "S" + getPath(cell+wid, side);
                }
            }
        }
        return out;
    }
    private String getPath(int cell, int from){
        if(cell==hig*wid-1){
            return "E+";
        }else{
            for(int i = 0; i<=3;i++){
                int side = (int)Math.pow(2, i);
                if(canMove(cell, side)){
                    if(side == 1&&from!=4){
                        return "N" + getPath(cell-wid, side);
                    }else if(side == 2&&from!=8){
                        return "E" + getPath(cell+1, side);
                    }else if(side == 4&&from!=1){
                        return "S" + getPath(cell+wid, side);
                    }else if(side == 8&&from!=2){
                        return "W" + getPath(cell-1, side);
                    }
                }
            }
        }
        return "-";
    }
}
