public class Palindrome {
    public static void main(String[] args){
        for (int i=0; i<args.length; i++){
            System.out.println((isPalindrome(args[i])));
        }
        }
    
    public static String reverseString(String n){
        String r = "";
        for(int i = n.length() - 1; i >= 0; i--){
            r += (n.charAt(i));
        }
        return r;
    }
    public static boolean isPalindrome(String s){
        if (s.equals(reverseString(s))){
            return true;
        }
        return false;
    }
}