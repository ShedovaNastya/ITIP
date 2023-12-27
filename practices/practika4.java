import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class practika4 {
    public static void main(String[] args){
        System.out.println("----задание 1----");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println("----задание 2----");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println("----задание 3----");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println("----задание 4----");
        System.out.println(alphabeticRow("aaaaaaaaa"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println("----задание 5----");
        System.out.println(blabla("aaabbcdd"));
        System.out.println(blabla("vvvvaajaaaaa"));
        System.out.println("----задание 6----");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println("----задание 7----");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("11111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println("----задание 8----");
        int[][] nums1 = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        int[][] nums2 = {{2,7,3},
                        {1,4,8},
                        {4,5,9}};
        System.out.println(shortestWay(nums1));
        System.out.println(shortestWay(nums2));
        System.out.println("----задание 9----");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println("----задание 10----");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));


    }
    public static String nonRepeatable(String s){
        if(s.length() == 1){
            return s;
        }
        char first = s.charAt(0);

        String remainder = s.substring(1).replaceAll(String.valueOf(first), "");

        return first + nonRepeatable(remainder);
    }
    public static List<String> generateBrackets(int n){
        List<String> ans = new ArrayList<>();
        recurent(n, 0, 0, ans, "");
        return ans;
    }
    public static void recurent(int n, int open, int close, List<String> ans, String current){
        if(current.length() == n*2){
            ans.add(current);
            return;
        }
        if(open < n){
            recurent(n, open+1,close, ans, current+"(");
        }
        if(close < open){
            recurent(n, open, close+1, ans, current+")");
        }
    }
    public static List<String> binarySystem(int n){
        List<String> ans = new ArrayList<>();
        recurent2(n, 0, ans,"");
        return ans;
    }
    public static void recurent2(int n,int flag0, List<String> ans, String current){
        if(current.length() == n){
            ans.add(current);
            return;
    }   
        if(flag0 == 1){
            recurent2(n, 0, ans, current+"1");
        }
        if(flag0 == 0){
            recurent2(n, 1, ans, current+"0");
             recurent2(n, 0, ans, current+"1");
        }

    }
    public static String alphabeticRow(String s){
        String cur_decrease = s.charAt(0)+ "";
        String cur_increase = s.charAt(0)+ "";
        String max_increase =  "";
        String max_decrease = "";
        for(int i =1; i < s.length(); i++){
            if(s.charAt(i) - s.charAt(i-1) == 1){
                cur_increase += s.charAt(i);
            }
            else{
                cur_increase = s.charAt(i)+"";
            }
            if(max_increase.length() < cur_increase.length()){
                max_increase = cur_increase;
            }

            //decrease
            if(s.charAt(i-1) - s.charAt(i) == 1){
                cur_decrease += s.charAt(i);
            }
            else{
                cur_decrease = s.charAt(i)+"";
            }
            if(max_decrease.length() < cur_decrease.length()){
                max_decrease = cur_decrease;
            }
            
        }
        if(max_increase.length() > max_decrease.length()){
            return max_increase;
        }
        return max_decrease;
    }
    public static String blabla(String s){
        List<String> ans = new ArrayList<>();
        int cur = 1;
        char symbol = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if((s.charAt(i) == s.charAt(i-1))){ 
                cur += 1;
            }
            else{
                ans.add(symbol + String.valueOf(cur));
                symbol = s.charAt(i);
                cur = 1;
            }
        }
        ans.add(symbol + String.valueOf(cur));

        String ot = "";
        while(ans.size() != 0){
            int cur_min = Integer.MAX_VALUE;
            String cur_stroka = "";
            
            for(int i = 0; i < ans.size(); i++){
                int num = Integer.parseInt(ans.get(i).substring(1));
                if(num < cur_min){
                    cur_min = num;
                    cur_stroka = ans.get(i);
                }            
            }
            ot += cur_stroka;
            ans.remove(cur_stroka);}
        return ot;
        }
        
    public static int convertToNum(String s){
        HashMap<String, Integer> dictinary = new HashMap<>();
        dictinary.put("zero", 0);
        dictinary.put("one", 1);
        dictinary.put("two", 2);
        dictinary.put("three", 3);
        dictinary.put("four", 4);
        dictinary.put("five", 5);
        dictinary.put("six", 6);
        dictinary.put("seven", 7);
        dictinary.put("eight", 8);
        dictinary.put("nine", 9);
        dictinary.put("ten", 10);
        dictinary.put("eleven", 11);
        dictinary.put("twelve", 12);
        dictinary.put("thirteen", 13);
        dictinary.put("fourteen", 14);
        dictinary.put("fiveteen", 15);
        dictinary.put("sixteen", 16);
        dictinary.put("seventeen", 17);
        dictinary.put("eighteen", 18);
        dictinary.put("nineteen", 19);
        dictinary.put("twenty", 20);
        dictinary.put("thirty", 30);
        dictinary.put("fourty", 40);
        dictinary.put("fivety", 50);
        dictinary.put("sixty", 60);
        dictinary.put("seventy", 70);
        dictinary.put("eighty", 80);
        dictinary.put("ninety", 90);

        String[] s2 = s.split(" ");
        int ans = 0;
        for(String word: s2){
            if(!word.equals("hundred")){
                ans += dictinary.get(word);
            }
            else{
                ans *= 100;
            }
        }
    return ans;
    }
    public static String uniqueSubstring(String s){
        String cur_str = "";
        String max_str = "";
        for(int i = 0; i < s.length();i++){
            if(!cur_str.contains(String.valueOf(s.charAt(i)))){
                cur_str += s.charAt(i);
            }
            else{
                cur_str = s.charAt(i) + "";
            }
            if(cur_str.length() > max_str.length()){
                max_str = cur_str;
            }
        }
        return max_str;
    }
    public static int shortestWay(int[][] s){
        int[][] cur_sum = new int[s.length][s.length];

        for(int i = 0;  i < s.length; i++){
            for(int j=0; j < s.length; j++){
                if(i== 0 && j == 0){
                    cur_sum[0][0] = s[0][0];
                }
                else if(i == 0){
                    cur_sum[i][j] = s[i][j] + cur_sum[i][j-1];
                }
                else if(j == 0){
                    cur_sum[i][j] = s[i][j]+cur_sum[i-1][j];
                }
                else{
                    cur_sum[i][j] = s[i][j] + Math.min(cur_sum[i-1][j], cur_sum[i][j-1]);
                }
                }
            }
       
        return cur_sum[s.length-1][s.length-1];
    }
    public static String numericOrder(String s){
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        char[] nums = "123456789".toCharArray();
        for(int i = 0; i < words.length; i++){
            for(char num: nums){
                if(words[i].contains(String.valueOf(num))){
                    String w = words[i].replaceAll(String.valueOf(num), "");
                    int index = Integer.parseInt(String.valueOf(num)) - 1;
                    ans[index] = w;
                    break;

                }
            }

        }
    return String.join(" ", ans);
    }
    public static String switchNums(int a, int b){
        char[] nums_a = String.valueOf(a).toCharArray();
        char[] nums_b = String.valueOf(b).toCharArray();
        for(int i=0; i < nums_a.length; i++){
            char cur_max = '0';
            int cur_index = 0;
            for(int j= 0; j < nums_a.length; j++){
                if(cur_max < nums_a[j]){
                    cur_max = nums_a[j];
                    cur_index = j;
                }
            
            }
            nums_a[cur_index] = 0;
            for(int rep = 0; rep < nums_b.length; rep ++){
                if(cur_max > nums_b[rep]){
                    nums_b[rep] = cur_max;
                    break;
                }
            }  
        }
        return String.valueOf(nums_b);
    }

}
    