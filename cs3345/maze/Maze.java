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
            int cell = 0;
            while(maze[cell/m][cell%m]!=-1){
                cell = r.nextInt(n*m);
            }
            int side = (int)Math.pow(2, r.nextInt(4));
            while(!isValid(n, m, cell, side)){
                side = (int)Math.pow(2, r.nextInt(4));
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
        while(parent>0){
            parent = union[parent];
        }
        return parent;
    }
    private boolean isValid(int n, int m, int cell, int side){
        if(cell/m==0&&side==1){
            return false;
        }
        if(cell/m==n&&side==4){
            return false;
        }
        if(cell%m==0&&side==8){
            return false;
        }
        if(cell%m==n&&side==2){
            return false;
        }
        return true;
    }
}
