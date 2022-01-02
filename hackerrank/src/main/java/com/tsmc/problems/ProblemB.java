package com.tsmc.problems;

import java.util.ArrayList;
import java.util.List;

public class ProblemB {

    /*
     * Complete the 'triangleType' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY triangleToy as parameter.
     */

    private static String ISOSCELES = "Isosceles";
    private static String EQUILATERAL = "Equilateral";
    private static String NONE_OF_THESE = "None of these";
    private static String SPLIT_CHAR = " ";

    public static List<String> triangleType(List<String> triangleToy) {
        // Write your code here
        List<String> res = new ArrayList<>();
        for(String triangle : triangleToy){
            String[] triStr = triangle.split(SPLIT_CHAR);
            Integer x = Integer.parseInt(triStr[0]);
            Integer y = Integer.parseInt(triStr[1]);
            Integer z = Integer.parseInt(triStr[2]);
            
            if(vaildTriangle(x, y, z))
                res.add(NONE_OF_THESE);
            else if(equTriangle(x, y, z))
                res.add(EQUILATERAL);
            else if(isoTriangle(x, y, z))
                res.add(ISOSCELES);
            else
                res.add(NONE_OF_THESE);
                
        }
        return res;
    }

    private static boolean vaildTriangle(Integer x, Integer y, Integer z){
        return (x+y)<z || (y+z)<x || (z+x)<y;
    }

    private static boolean equTriangle(Integer x, Integer y, Integer z){
        return x.equals(y) && y.equals(z);
    }

    private static boolean isoTriangle(Integer x, Integer y, Integer z){
        return x.equals(y) || y.equals(z) || z.equals(x);
    }
}
