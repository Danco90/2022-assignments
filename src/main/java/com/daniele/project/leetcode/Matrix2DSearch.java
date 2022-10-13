package com.daniele.project.leetcode;

public class Matrix2DSearch
{
    public boolean searchMatrix(int[][] matrix, int target)
    {   System.out.println();
        int bigO =0 ;
        int rowLen = matrix.length;
        for(int m=0; m<rowLen; m++)
        {   int colLen = matrix[m].length;
            for(int n=0; n<colLen; n++)
            {
                if(rowLen >1 && colLen >1)
                {
                    int max_m = rowLen/2;
                    int max_n = colLen/2;
                    if(m >= max_m && n >= max_n && target < matrix[max_m][max_n])
                        break;

                    if(m <= max_m && n<= max_n && target > matrix[max_m][max_n])
                        continue;
                }

                System.out.println("Comparing matrix["+ m +"]["+ n +"]="+matrix[m][n]+" with "+target); bigO++;
                if(matrix[m][n] == target)
                {   System.out.println("Actual steps : O("+ bigO +")");
                    return true;
                }
            }
        }
        System.out.println("Actual steps : O("+bigO+")");
        return false;
    }

}
