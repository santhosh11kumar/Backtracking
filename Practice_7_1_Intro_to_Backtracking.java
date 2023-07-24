package _1_Recurssion_easy_practice._7Backtracking;

import java.util.Arrays;

public class Practice_7_1_Intro_to_Backtracking {


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter the length of the row  ");
//        int Length_row = sc.nextInt();
//
//        System.out.println("Enter the length of the col ");
//        int Length_col = sc.nextInt();
//
//        boolean [][] maze = new boolean[Length_row][Length_col];
//        for (int row = 0;row<Length_row;row++)
//        {
//            for (int col = 0;col<Length_col;col++)
//            {
//                System.out.println("Enter the value of maze at index " + row +","+ col+ " is ");
//                maze[row][col]=sc.nextBoolean();
//            }
//        }
//
//        System.out.println(Arrays.deepToString(maze));


        int [][] maze = new int[3][3];  // because when int is initialize it contains zeros and in boolean it contains false


        int[][] tracker= new int[maze.length][maze[0].length];

        Tracking("",maze,0,0,tracker,1);
    }



    static void Tracking(String ans,int[][] maze,int row,int col,int[][] Tracker_represention,int count)
    {

        if(row == maze.length-1  && col == maze.length-1 )
        {
            Tracker_represention[row][col] = count;
            System.out.println(""); 

            for(int[] arr:Tracker_represention)
            {

                System.out.println(Arrays.toString(arr));
            }

            System.out.println(ans);

            return;
        }

        if(maze[row][col] != 0)
        {
            return;
        }

        maze[row][col] = 1;
        Tracker_represention[row][col] = count;


        if(row<maze.length-1)
        {
            Tracking(ans + "-DO",maze,row+1,col,Tracker_represention,count+1);
        }
        if(col<maze[0].length-1)
        {
            Tracking(ans + "-RI",maze,row,col+1,Tracker_represention,count+1);
        }
        if(0<row)
        {
            Tracking(ans + "-UP",maze,row-1,col,Tracker_represention,count+1);
        }
        if(0<col)
        {
            Tracking(ans + "-LE",maze,row,col-1,Tracker_represention,count+1);
        }
        if(row < maze.length -1 && col < maze.length -1)
        {
            Tracking(ans + "-DG",maze,row+1,col+1,Tracker_represention,count+1);
        }

        Tracker_represention[row][col] = 0;
        maze[row][col] = 0;




    }
}
