package com.tsmc.problems;

public class ProblemA {

    /*
     * Complete the 'getSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING input_str
     *  2. INTEGER k
     */

    private static final Character TAR_CHAR = '1';

    private static String res = "";
    private static String temp = "";
    private static int tempNum = 0;

    public static String getSubstring(String input_str, int k) {
        // Write your code here\
        System.out.println(input_str);
        System.out.println(k);
        for(int i=0;i<input_str.length();i++){
            Character c = input_str.charAt(i);
            temp += c;
            // System.out.println(temp);
            if(TAR_CHAR.equals(c))
                tempNum++;
            checkNum(k);
        }
        return res;
    }

    private static void checkNum(int k){
        if(k == tempNum){
            temp = removeFrontZero(temp);
            // System.out.println(tempNum);
            System.out.println(temp);
            if(res.length()==0 || compare(temp, res))
                res = temp;
            tempNum--;
            temp = temp.substring(1, temp.length());
            // System.out.println("after:"+tempNum);
            // System.out.println("after:"+temp);
        }
    }

    private static String removeFrontZero(String temp){
        // System.out.println(temp);
        while(!TAR_CHAR.equals(temp.charAt(0))){
            temp = temp.substring(1);
        }
        // System.out.println("after:"+temp);
        return temp;
    }

    private static boolean compare(String temp, String res){
        if(temp.length() < res.length()){
            return true;
        } else if(temp.length() > res.length()){
            return false;
        } else {
            for(int i=0;i<res.length();i++){
                if(temp.charAt(i)<res.charAt(i)){
                    System.out.println(i+"true:"+temp.charAt(i));
                    return true;
                } else if(temp.charAt(i)>res.charAt(i)){
                    System.out.println(i+"false:"+temp.charAt(i));
                    return false;
                }
            }
            return false;
        }
    }
}
