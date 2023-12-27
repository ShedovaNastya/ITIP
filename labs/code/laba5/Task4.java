public class Task4 {
    public static void main(String[] args){
        System.out.println(validator("255.255.255.255"));
        System.out.println(validator("10.0.0.255"));
        System.out.println(validator("203.120.235.173"));
        System.out.println(validator("0.0.0.0"));
        System.out.println(validator("0.0.0.0.0"));
        System.out.println(validator("192.0.2.300"));
        System.out.println(validator("255.255.255.256"));
        System.out.println(validator("172.300.254"));
        
    }

    public static boolean validator(String ip){
        String octeta = "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)";
        // | или
        String regex = octeta + "\\." + octeta + "\\." + octeta + "\\." + octeta;

        if (ip.matches(regex)){
            return true;
        }
        else{
            return false;
        }
    }
}
