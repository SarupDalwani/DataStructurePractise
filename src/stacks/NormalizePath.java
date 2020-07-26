package stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * Problem : Write a program which takes a pathname, and returns the shortest equivalent path¬ name. Assume individual directories and files have names that use only alphanu¬ meric characters. Subdirectory names may be combined using forward slashes (/), the current directory (.), and parent directory (..).
 *<br>
 *<br>
 * Time Complexity : O(n)
 * <br>
 * Space Complexity : O(n) for stack
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href="https://leetcode.com/problems/simplify-path">LeetCode</a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class NormalizePath {
    public static void main(String[] args) {
        String input1 = "/home/";
        String input2 = "/../";
        String input3 = "/home//foo/";
        String input4 = "/a/./b/../../c/";
        String input5 = "/a/../../b/../c//.//";
        String input6 = "/a//b////c/d//././/..";

        System.out.println("Path : "+input1+" Normalized Path : "+normalize(input1));
        System.out.println("Path : "+input2+" Normalized Path : "+normalize(input2));
        System.out.println("Path : "+input3+" Normalized Path : "+normalize(input3));
        System.out.println("Path : "+input4+" Normalized Path : "+normalize(input4));
        System.out.println("Path : "+input5+" Normalized Path : "+normalize(input5));
        System.out.println("Path : "+input6+" Normalized Path : "+normalize(input6));

    }

    public static String normalize(String path){
        String[] tokens = path.split("/");
        Deque<String> stk = new LinkedList<>();
        for(String token : tokens){
            switch (token.trim()){
                case ".":
                case "":
                    break;
                case "..":
                    if(!stk.isEmpty())stk.pop();
                    break;
                default:
                    stk.push(token);
                    break;
            }
        }

        String ans = "";
        while (!stk.isEmpty()){
            ans = "/"+stk.pop() + ans;
        }
        if(ans.length()==0)return "/";
        return ans;
    }
}
