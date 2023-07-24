package _1_Recurssion_easy_practice._7Backtracking;

import java.util.Scanner;


// count not working



public class Practice_7_3_N_Knights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        boolean[][] maze = new boolean[len][len]; // n queens and there should be a n size maze

        System.out.println("The number of possible ways are : " + nknights(maze,0,0,len,0));
    }

    static int nknights(boolean[][] maze,int row,int col, int knights,int count)
    {
        // when we placecd all the knights then it's better to break and print all the outcomes
        if(knights == 0)
        {
            display(maze,row,col);
            System.out.println("");
            return 1;
        }

        if(row == maze.length -1 && col == maze.length)
        {
            return 1;
        }

        // when we find all the possibilities of a column then it's better to go for next row
        if(col == maze.length)
        {
            return nknights(maze,row+1,0,knights,count);

        }
        // checking whether the condition of being a knight
        if(isknights(maze,row,col))
        {
            maze[row][col] = true; // making the present call true to display the possible position of the knight

             nknights(maze,row,col+1,knights-1,count+1);

            maze[row][col] = false; // back tracking so, that we can  find the other possible outcomes

        }

        // if we dont find the possible position of the knight then it's better to check the next to it possible or not


                nknights(maze,row,col+1,knights,count);
               return count;


    }
    static void display(boolean[][] maze, int row, int col)
    {
        for(boolean[] ro : maze)
        {
            for (boolean value : ro)
            {
                if(value == true)
                {
                    System.out.print(" k ");
                }
                else
                {
                    System.out.print(" * ");
                }
            }
            System.out.println("");
        }
    }




    static boolean isknights(boolean[][] maze,int row, int col)
    {
        if(isvalid(maze,row-2,col-1))
        {
            if(maze[row-2][col-1] == true)
            {
                return false;
            }
        }

        if(isvalid(maze,row-2,col+1))
        {
            if(maze[row-2][col+1] == true)
            {
                return false;
            }
        }

        if(isvalid(maze,row-1,col+2))
        {
            if(maze[row-1][col+2] == true)
            {
                return false;
            }
        }

        if(isvalid(maze,row-1,col-2))
        {
            if(maze[row-1][col-2] == true)
            {
                return false;
            }
        }

        return true;


    }



    static boolean isvalid(boolean[][] maze,int row, int col)
    {
        if(row <= maze.length-1 && col <= maze.length-1 && row>=0 && col>=0)
        {
            return true;
        }
        return false;
    }

}
