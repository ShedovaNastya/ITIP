import java.util.Arrays;
import java.security.SecureRandom;
public class practika2 {
    public static void main(String[] args){
        System.out.println("-----Задание 1-----");
        System.out.println("duplicateChars('Donald') -> " + duplicateChars("Donald"));
        System.out.println("duplicateChars('orange') -> " + duplicateChars("orange")+ "\n");
        System.out.println("-----Задание 2-----");
        System.out.println( "getInitials('Ryan Gosling') -> " + getInitials("Ryan Gosling"));
        System.out.println( "getInitials('Barack Obama') -> " + getInitials("Barack Obama")+ "\n"); 
        System.out.println("-----Задание 3-----");
        int[] nums1 = {44, 32, 86, 19};
        int[] nums2 = {22, 50, 16, 63, 31, 55};
        System.out.println( "differenceEvenOdd([44, 32, 86, 19]) -> " + differenceEvenOdd(nums1)); 
        System.out.println( "differenceEvenOdd([22, 50, 16, 63, 31, 55]) -> " + differenceEvenOdd(nums2) + "\n"); 
        System.out.println("-----Задание 4-----");
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {1, 2, 3, 4, 6};
        System.out.println("equalToAvg([1, 2, 3, 4, 5] ->" + equalToAvg(nums3));
        System.out.println("equalToAvg([1, 2, 3, 4, 6] ->" + equalToAvg(nums4) + "\n");
        System.out.println("-----Задание 5-----");
        int[] nums5 = {1, 2, 3};
        int[] nums6 = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(nums5)));
        System.out.println(Arrays.toString(indexMult(nums6))+ "\n");
        System.out.println("-----Задание 6-----");
        System.out.println(reverse("The quick brown fox.")+ "\n");
        System.out.println("-----Задание 7-----");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11)+ "\n");
        System.out.println("-----Задание 8-----");
        System.out.println(pseudoHash(11)+ "\n");
        System.out.println("-----Задание 9-----");
        System.out.println(botHelper("Hello, I’m under the water, please help me")+ "\n");
        System.out.println("-----Задание 10-----");
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));

    }
    public static boolean duplicateChars(String a){
        a = a.toLowerCase();
        for(int i = 0; i < a.length(); i++){
            String n = "";
            n += a.charAt(i);
            for(int j= 0; j < a.length();j++){
                String n2 = "";
                n2 += a.charAt(j);
                if(j != i && n.equals(n2)){
                    return true;
                }
            }
        }
        return false;
    }
    public static String getInitials(String a){
        String fi[] = a.split(" ");
        String f = String.valueOf(fi[0].charAt(0));
        String i = String.valueOf(fi[1].charAt(0));
        return f+i;
    }
    public static int differenceEvenOdd(int[] nums){
        int ch = 0;
        int nech = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                ch += nums[i];
            }
            else{
                nech += nums[i];
            }
        }
        if(ch > nech){
            return ch - nech;
        }
        else{
            return nech - ch;
        }
    }
    public static boolean equalToAvg(int[] nums){
        double suum = 0;
        double sr = 0;
        for(int i = 0; i < nums.length; i++){
            suum += nums[i];
        }
        sr = suum / (nums.length);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == sr){
                return true;
            }
        }
        return false;
    }
    public static int[] indexMult(int[] nums){
        int[] otv = new int[nums.length];
         for(int i = 0; i < nums.length; i++){
            otv[i] = nums[i] * i;
        }
        return otv;
    }
    public static String reverse(String a){
        String otv = "";
        for(int i = a.length() - 1; i >= 0 ; i--){
            otv += a.charAt(i);
        }
        return otv;
    }
    public static int Tribonacci(int n){
        int a0 = 0;
        int a1 = 0;
        int a2 = 1;
        int otv = 0;
        for(int i = 3; i < n; i++){
            otv += a0 + a1 + a2;
            a0 = a1;
            a1 = a2;
            a2 = otv;
            otv = 0;
        }
        return a2;
    }
    public static String pseudoHash(int n){
        String bla = "abcdef0123456789";
        String otv = "";
        SecureRandom d = new SecureRandom();
        for(int i = 0; i < n; i++){
            int ch = d.nextInt(bla.length());
            otv += bla.charAt(ch);
        }
        return otv;
    }
    public static String botHelper(String s){
        s = s.toLowerCase();
        String[] bla = s.split(" ");
        for(int i = 0; i < bla.length; i++){
            if(bla[i].equals("help")){
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
            
        
    }
    public static boolean isAnagram(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();
        if(a.length() != b.length()){
            return false;
        }
        int[] a1 = new int[256];
        int[] b1 = new int[256];
        for(int i = 0; i < 256; i++){
            a1[i] = 0;
            b1[i] = 0;
        }
        for(int i = 0; i < a.length(); i ++){
            int s1 = a.charAt(i);
            int s2 = b.charAt(i);
            a1[s1] += 1;
            b1[s2] += 1;
        }
        for(int i = 0; i <256; i++){
            if(a1[i] != b1[i]){
                return false;
            }
        }
        return true;
    }


}