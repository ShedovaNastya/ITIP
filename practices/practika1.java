
public class practika1{
    public static void main(String[] args){
        System.out.println("----task 1----");
        System.out.println("convert(5) -> " + convert(5));
        System.out.println("convert(3) -> " + convert(3));
        System.out.println("convert(8) -> " + convert(8) + "\n");
        System.out.println("----task 2----");
        System.out.println("fitCals(15, 1) -> " + fitCals(1, 15));
        System.out.println("fitCals(24, 2) -> " + fitCals(24, 2));
        System.out.println("fitCals(41, 3) -> " + fitCals(41, 3) + "\n");
        System.out.println("----task 3----");
        System.out.println("containers(3, 4, 2) -> " + containers(3, 4, 2));
        System.out.println("containers(5, 0, 2) -> " + containers(5, 0, 2));
        System.out.println("containers(4, 1, 4) -> " + containers(4, 1, 4) + "\n");
        System.out.println("----task 4----");
        System.out.println("triangleeType(5, 5, 5) -> " + triangleType(5, 5, 5));
        System.out.println("triangleeType(5, 4, 5) -> " + triangleType(5, 4, 5));
        System.out.println("triangleeType(3, 4, 5) -> " + triangleType(3, 4, 5));
        System.out.println("triangleeType(5, 1, 1) -> " + triangleType(5, 1, 1) + "\n");
        System.out.println("----task 5----");
        System.out.println("ternaryEvaluation(8, 4) -> " + ternaryEvaluation(8, 4));
        System.out.println("ternaryEvaluation(1, 11) -> " + ternaryEvaluation(1, 11));
        System.out.println("ternaryEvaluation(5, 9) -> " + ternaryEvaluation(5, 9) + "\n");
        System.out.println("----task 6----");
        System.out.println("howManyItems(22, 1.4, 2) -> " + howManyItems(22, 1.4f, 2));
        System.out.println("howManyItems(45, 1.8, 1.9) -> " + howManyItems(45, 1.8f, 1.9f));
        System.out.println("howManyItems(100, 2, 2) -> " + howManyItems(100, 2, 2) + "\n");
        System.out.println("----task 7----");
        System.out.println("factorial(3) -> " + factorial(3));
        System.out.println("factorial(5) -> " + factorial(5));
        System.out.println("factorial(7) -> " + factorial(7)+ "\n");
        System.out.println("----task 8----");
        System.out.println("gcd(48,18) -> " + gcd(48, 18));
        System.out.println("gcd(52,8) -> " + gcd(52, 8));
        System.out.println("gcd(259,28) -> " + gcd(259, 28) + '\n');
        System.out.println("----task 9----");
        System.out.println("ticketSaler(70, 1500) -> " + ticketSaler(70, 1500));
        System.out.println("ticketSaler(24, 950) -> " + ticketSaler(24, 950));
        System.out.println("ticketSaler(53, 1250) -> " + ticketSaler(53, 1250)+ "\n");
        System.out.println("----task 10----");
        System.out.println("tables(5, 2) -> "+ tables(5, 2));
        System.out.println("tables(31, 20) -> "+ tables(31, 20));
        System.out.println("tables(123, 58) -> "+ tables(123, 58));
      
    } 
    public static float convert(int num){
        return num* 3.785f;
    }
    public static int fitCals(int min, int load){
        return min * load;
    }
    public static int containers(int c, int m, int b){
        return 20*c + 50 * m + 100 * b;
    }
    public static String triangleType(int x, int y, int z){
        if(x + y < z | x + z < y | y + z < x){
            return "not a triangle";
        }
        else if(x == y & y == z){
            return "equilateral";
        }
        
        else if(x == y | x == z | z == y){
            return "isosceles";
        }
        else{
            return "different-sided";
        }

    }
    public static int ternaryEvaluation(int a, int b){
        return a > b ? a : b;
    }
    public static int howManyItems(int n, float w, float h){
        return (int) (n / (w*h * 2));
    }
    public static int factorial(int n){
        int ot = 1;
        for(int i=1; i<=n; i++){
            ot *= i;
        }
        return ot;
    }
    public static int gcd(int a, int b){
        int n = 0;
        if(a > b){
            n = a;
        }
        else{
            n = b;
        }
            for(int i=n; i>=1; i=i-1){
                if(a % i == 0 && b % i == 0){
                    return i;
                }
            }
        return 1;
    }
    public static int ticketSaler(int a, int b){
        return (int) (a * b * 0.72);
    }
    public static int tables(int a, int b){
        if (b*2 > a){
            return 0;
        }
        else if((a-b*2)%2 == 0){
            return(a -b*2)/2;
        }
        else{
            return(a -b*2)/2 + 1;
        }
    }
}