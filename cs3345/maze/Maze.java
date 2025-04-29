package cs3345.maze;

import java.util.Random;

public class Maze {
    private int[][] maze;
    private int[] union;
    public Maze(int n, int m){
        maze = new int[n][m];
        union = new int[n*m];
        for(int i = 0; i<union.length;i++){
            union[i] = -1;
        }
        maze[0][0] = 8;
        maze[n-1][m-1] = 2;
        Random r = new Random();
        while(union[0]!=(n*m*-1)){
            System.out.println();
            for(int[] i: maze){
                for(int j: i){
                    System.out.print(j+"\t");
                }
                System.out.println();
            }
            System.out.println();
            for(int i = 0; i<union.length;i++){
                System.out.print(i+"\t");
            }
            System.out.println();
            for(int i : union){
                System.out.print(i+"\t");
            }
            System.out.println("\n");
            int cell = r.nextInt(n*m);
            while(union[cell]!=-1){
                cell = r.nextInt(n*m);
            }
            int side = r.nextInt(4);
            while(!isValid(n, m, cell, side)){
                side = r.nextInt(4);
            }
            side = (int)Math.pow(2, side);
            System.out.println(cell+" "+side);
            switch (side) {
                case 1 -> {
                    if(getParent(cell)!=getParent(cell-m)||(getParent(cell)==-1&&getParent(cell-m)==-1)){
                        maze[cell/m][cell%m] |= 1;
                        maze[(cell-m)/m][cell%m] |= 4;
                        union[cell] = getParent(cell-m);
                        union[cell-m] -=1;
                    }
                }
                case 2 -> {
                    if(getParent(cell)!=getParent(cell+1)||(getParent(cell)==-1&&getParent(cell+1)==-1)){
                        maze[cell/m][cell%m] |= 2;
                        maze[cell/m][(cell+1)%m] |= 8;
                        union[cell+1] = getParent(cell);
                    }
                }
                case 4 -> {
                    if(getParent(cell)!=getParent(cell+m)||(getParent(cell)==-1&&getParent(cell+m)==-1)){
                        maze[cell/m][cell%m] |= 4;
                        maze[(cell+m)/m][cell%m] |= 1;
                        union[cell+m] = getParent(cell);
                    }
                }
                case 8 -> {
                    if(getParent(cell)!=getParent(cell-1)||(getParent(cell)==-1&&getParent(cell-1)==-1)){
                        maze[cell/m][cell%m] |= 8;
                        maze[cell/m][(cell-1)%m] |= 2;
                        union[cell] = getParent(cell-1);
                        union[cell-1] -=1;
                    }
                }
            }

        }
        System.out.println();
        for(int[] i: maze){
            for(int j: i){
                System.out.print(j+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i<union.length;i++){
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i : union){
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    private int getParent(int cell){
        int parent = union[cell];
        if(parent==-1){
            return cell;
        }
        while(parent>0){
            parent = union[parent];
        }
        return parent;
    }
    private boolean isValid(int n, int m, int cell, int side){
        if(cell/m==0&&side==0){
            return false;
        }
        if(cell%m==m-1&&side==1){
            return false;
        }
        if(cell/m==n-1&&side==2){
            return false;
        }
        if(cell%m==0&&side==3){
            return false;
        }else{
            return true;
        }
        
    }
}
