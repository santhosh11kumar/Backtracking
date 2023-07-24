package _1_Recurssion_easy_practice._7Backtracking;


import java.util.Arrays;

public class Practice_7_4_Sudoku_solver {
    public static void main(String[] args) {
      int[][] sudoku = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
             helper(sudoku);
        for(int nums[]:sudoku)
        {

                System.out.println(Arrays.toString(nums));

        }
    }


    static boolean helper(int[][] sudoku)
    {
        // iterating the entire maze
        for(int row = 0;row<sudoku.length;row++)
        {
            for(int col = 0;col< sudoku.length;col++)
            {
                if(sudoku[row][col] == 0)  // condition for the desired index for getting answer
                {
                    // As same as hit and trail method considering the present index answer by giving checking 1-9 possible numbers
                    for(int value = 1;value<=9;value++)
                    {
                        if(isvalid_answer(sudoku,row,col,value))  // if the answer is valid then the value is taken consider
                        {
                            sudoku[row][col] = value;          // if true then the present index value is replaced by possible value

                            // when next or lower recursion calls do execute and provide the answer
                            if(helper(sudoku))
                            {
                                return true;    // this will execute at the last recursion call & if it's true then it means we found a possible sudoku
                            }
                            else
                            {
                                sudoku[row][col] =0;  // if anything goes wrong or the value get violated the present answer is replaced with zero

                            }
                        }
                    }
                    return false;    // and pass the false to upper recursion calls
                }
            }
        }
        return true;  // when there is no zero or empty place then the initial if condition doesn't execute

    }



    static boolean isvalid_answer(int[][] sudoku,int row,int col,int possible_ans)
    {
        for(int i = 0;i<sudoku.length;i++)
        {
            if(sudoku[row][i] == possible_ans) // if we found the possible_ans with in the same row then the possible_ans is not any more possible answer
            {
                return false; // so return false;
            }
            if(sudoku[i][col] == possible_ans) // if we found the possible_ans with in the same colomun then the possible_ans is not any more possible answer
            {
                return false; // so return false
            }
        }
        // below can be written in above for loop also to make things easier i have split this tricky formula one

        int row_of_matrix_3_x_3 = 3 * (row/3);
        int col_of_matrix_3_x_3 = 3 * (col/3);

        // checking the possible_ans in 3X3 matrix
        for(int i = 0;i<sudoku.length;i++)
        {
            // if we found the possible_ans with in the same 3X3 matrix then the possible_ans is not any more possible answer
            if(sudoku[row_of_matrix_3_x_3 + (i/3)][col_of_matrix_3_x_3 + (i % 3)] == possible_ans)
            {
                return false;
            }
        }
        //if we don't find the answer then it means the possible_ans is correct to that index
        return true;



    }






}
