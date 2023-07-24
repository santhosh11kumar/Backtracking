package _1_Recurssion_easy_practice._7Backtracking;

public class Practice_7_2_N_Queens {
    public static void main(String[] args) {


    }
    static int nqueens(boolean[][] maze,int row)
    {
        if(row == maze.length)
        {
            for(boolean[] col : maze) // printing the path positions of n queens
            {
                for(boolean value : col)
                {
                    if(value == true)
                    {
                        System.out.print(" Q ");
                    }
                    else
                    {
                        System.out.print(" x ");
                    }
                }
                System.out.println("");
            }
            System.out.println("");
            return 1;
        }
        int count = 0;

        for (int col = 0;col< maze.length;col++)
        {
            if(ispossible(maze,row,col))
            {
                maze[row][col] = true; // making that present call true
                count = count + nqueens(maze,row+1);
                maze[row][col] = false; // when we finally get the answer this will excute and return with the false
            }

        }
        return count;
    }
    static boolean ispossible(boolean[][] maze,int row, int col)
    {
        for(int i = 0;i< row;i++)  // checking the elements from row zero till present call row whether there
        {
            if(maze[i][col] == true) // true when there is a element
            {
                return false;  // when element is already present in the col then we should not place the value so return false
            }
        }
        int left_check = Math.min(row,col);
        for(int i = 1;i<=left_check;i++) // for checking the left upward diagonal
        {
            if(maze[row-i][col-i] == true) // true when there is a element at that position
            {
                return false;  // when we found element then we cant place the queen at that position so return false
            }
        }

        int right_check = Math.min(row,maze.length - col -1);
        for(int i = 1;i<=right_check;i++) // for checking the left upward diagonal
        {
            if(maze[row - i][col+i] == true) // true when there is a element at that position
            {
                return false;  // when we found element then we cant place the queen at that position so return false
            }
        }

        return true; // when dont get any answer form above it means this is the possible case for queen to be palced
    }


}
