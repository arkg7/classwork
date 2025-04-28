package cs3345.maze;

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

        while(union[0]!=(n*m*-1)){
            
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
}
