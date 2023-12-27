import java.util.Arrays;

public class practika3 {
    public static void main(String[] args){
        System.out.println("-----Задание 1-----");
        System.out.println(replaceVovls("atrtrerru"));
        System.out.println("-----Задание 2-----");
        System.out.println(stringTransform("hhhello"));
        System.out.println("-----Задание 3-----");
        System.out.println(doesBlockFit(1, 2,2,1,1));
        System.out.println("-----Задание 4-----");
        System.out.println(numCheck(52));
        System.out.println("-----Задание 5-----");
        int[] num1 = {1, -6, 9};
        System.out.println(countRoots(num1));
        System.out.println("-----Задание 6-----");
        String[][] sh = {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                         {"Banana", "Shop2", "Shop3", "Shop4"},
                         {"Orange", "Shop1", "Shop3", "Shop4"},
                         {"Pear", "Shop2", "Shop4"}};
        String[][] sh2 = {{"Fridge", "Shop2", "Shop3"},
                         {"Microwave","Shop1", "Shop2", "Shop3", "Shop4"},
                         {"Laptop", "Shop3", "Shop4"},
                         {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        
        System.out.println(Arrays.toString(salesData(sh)));
        System.out.println(Arrays.toString(salesData(sh2)));
        System.out.println("-----Задание 7-----");
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("-----Задание 8-----");
        int[] nums1 = {1,2, -6,10,3};
        System.out.println(waveForm(nums1));
        System.out.println("-----Задание 9-----");
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("-----Задание 10-----");
        int[][] nums2 = {{6,4,19,0,0},
                        {81, 25, 3, 1, 17},
                        {48,12,60,32,14},
                        {91,47,16,65,217},
                        {5,73,0,4,21}};
        int[][] rrr = dataScience(nums2);
        for(int i = 0; i< nums2.length; i++){
            System.out.println(Arrays.toString(rrr[i]));
            
        }

    }
    public static String replaceVovls(String a){
        a = a.toLowerCase();
        String ot = "";
        String s = "eyuiao";
        for(int i=0; i < a.length(); i++){
            if(s.contains(String.valueOf(a.charAt(i)))){
                ot += "*";
            }
            else{
                ot += String.valueOf(a.charAt(i));
            }
            
        }
        return ot;
    }
    public static String stringTransform(String a){
        a = a.toLowerCase();
        int flag = 0;
        String ot = "";
        for(int i =0;i < a.length()-1;i++){
            String sim1 = String.valueOf(a.charAt(i));
            String sim2 = String.valueOf(a.charAt(i+1));
            if(flag == 1){
                flag = 0;
                continue;
            }
            if(sim1.equals(sim2)){
                ot += "Double" + sim1.toUpperCase();
                flag = 1;
            }
            else{
                ot += sim1;
            }
        }
        return ot;
    }
    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        int maxx = Math.max(Math.max(a,b),c);
        int minn = Math.min(Math.min(a,b),c);
        int middle = a+b+c - maxx - minn;

        return(minn <= Math.min(w,h) && middle <= Math.max(w,h));
        
    }
    public static boolean numCheck(int a){
        String s = "" + a;
        int ot = 0;
        for(int i = 0; i < s.length(); i++){
            ot += (Integer.parseInt(String.valueOf(s.charAt(i))))%2;
        }
        return(ot %2 == a %2);
    }
    public static int countRoots(int[] k){
        int a = k[0];
        int b = k[1];
        int c = k[2];
        if(a == 0){
            if(b != 0){
                if(-c % b == 0){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        else{
            int d = b*b - 4*a*c;
            int ot = 0;
            if(d > 0){
                double n = Math.pow(d,0.5);
                if((-b + n) % (2*a) == 0){
                    ot += 1;
                    if((-b - n) % (2*a) == 0){
                        ot += 1;
                    }
                }
                return ot;
            }
            if(d == 0){
                if(-b % (2*a) == 0){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            return 0;
            }
    }
    public static String[] salesData(String[][] a){
        String[] shop = new String[15];
        int len_shop = 0;
        for(int i = 0; i < a.length; i ++){
            for(int j = 1; j < a[i].length; j ++){
                for(int s=0; s < shop.length; s++){
                    if(shop[s] == null){
                        shop[s] = a[i][j];
                        len_shop += 1;
                        break;
                    }
                    else if(a[i][j].equals(shop[s])){
                        break;
                    }
                }

            }

        }
        String ot = "";
        for(int i = 0; i < a.length; i++){
            if((a[i].length- 1) == len_shop){
                ot += a[i][0] + " ";
            }
        }
        return ot.split(" ");
    }
    public static boolean validSplit(String s){
        String[] words  = s.split(" ");
        String[] start = new String[words.length];
        String[] end = new String[words.length];
        for(int i= 0; i< words.length; i++){
            start[i] = String.valueOf(words[i].charAt(0));
            end[i] = String.valueOf(words[i].charAt(words[i].length()-1));
        }
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        int diff = 0;
        for(int i = 0; i < alphabet.length(); i++){
            int cntStart = 0;
            int cntEnd = 0;
            for(int j = 0; j < start.length; j++){
                if(String.valueOf(alphabet.charAt(i)).equals(start[j])){
                    cntStart += 1;
                }
                if(String.valueOf(alphabet.charAt(i)).equals(end[j])){
                    cntEnd += 1;
                }
            }
            diff += Math.abs(cntStart - cntEnd);
            if(diff > 2){
                return false;
            }

        }
        return true;
    }
    public static boolean waveForm(int[] nums){
        int flag = 0;
        if(nums[0] < nums[1]){
            flag = 1;
        }
        else if(nums[0]==nums[1]){
            return false;
        }
        else{
            flag = 0;
        }
        for(int i=1; i< nums.length - 2; i++){
            if(flag == 0 && nums[i] > nums[i+1]){
                flag = 1;
            }
            else if(flag == 1 && nums[i]< nums[i+1]){
                flag = 0;
            }
            else{
                return false;
            }
        
        }
        return true;
    }
    public static String commonVovel(String s){
        s = s.toLowerCase();
        char[] sl = {'a', 'e', 'y', 'u', 'i','o'};
        int[] counts = new int[sl.length];
        for (int i =0; i < sl.length; i++){
            for(int j = 0; j < s.length(); j++){
                if(sl[i] == (s.charAt(j))){
                    counts[i] ++;
                }

            }
        }
        int maxInd = -1;
        String ans = "";
        for(int i=0; i < counts.length ;i++){
            if(counts[i] > maxInd){
                maxInd = counts[i];
                ans = String.valueOf(sl[i]);
            }
        }
        return ans;

    }
    public static int[][] dataScience(int[][] nums){
        double n = nums.length;
        for(int i=0; i < n; i++){
            double sr_sum = 0;
            for(int j=0; j< n; j ++){
                if(i != j){
                   sr_sum += nums[j][i]; 
                }
                
            }
            double ot = Math.round(sr_sum/(n-1));
            nums[i][i] = (int) ot;
        }
        return nums;
    }

}

