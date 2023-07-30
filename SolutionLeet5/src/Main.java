import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        while(true){
            System.out.print("String: ");
            Scanner sc = new Scanner(System.in);
            String string = sc.next();
            System.out.println("Longest palindromic string: " + longestPalindromicString(string) + "\n");
        }

    }

    public static String longestPalindromicString(String s){
        if (s == null){
            return "";
        }
        if (s.length() == 1){
            return s;
        }
        int start = 0, //beginning index of the longest palindrome
                end = 0; //
        for (int i = 0; i<s.length(); i++){ //i is the middle one
            int a = expandFromMiddle(s, i, i); //"aba" start with "b"
            int b = expandFromMiddle(s, i, i+1); //"abba" start with "bb"
            int len = Math.max(a, b);

            //find longest
            //end - start = len of the previous palindrome

            if(len > end - start + 1){
                start = i - ((len-1)/2);
                        //((len-1)/2) is the median
                end = i + (len/2);
                        //same thing, median
            }
        }
        return s.substring(start, end + 1);
    }
    public static int expandFromMiddle(String s, int left, int right){
        if (s==null || left>right){return 0;}

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        //return the length of the palindrome
        return (right-1) - (left+1) + 1;
    }
}