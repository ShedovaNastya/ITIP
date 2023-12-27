public class Main2 {
    public static void main(String[] args){
        Klaviatura b = new Klaviatura(1420, false, 108);
        Nayshniki c = new Nayshniki(999, true, 150);
        Graficheskiy_planshet d = new Graficheskiy_planshet(2999, false, 60);
        AirPods e = new AirPods(22000, false, 300, true);

        
        System.out.printf("%s, %s, %s, %s",b.getPrice(), b.getBy(), b.getNum(), b.getCnt() +"\n");
        System.out.printf("%s, %s, %s, %s",c.getPrice(), c.getBy(), c.getGram(), c.getCnt() +"\n");
        System.out.printf("%s, %s, %s, %s",d.getPrice(), d.getBy(), d.getFreq(), d.getCnt() +"\n");
        System.out.printf("%s, %s, %s, %s",e.getPrice(), e.getBy(), e.getOr(), e.getCnt() +"\n\n\n");
        b.setBy(true);
        c.setGram(230);
        d.setFreq(120);
        e.setOr(false);
        System.out.printf("%s, %s, %s, %s",b.getPrice(), b.getBy(), b.getNum(), b.getCnt() +"\n");
        System.out.printf("%s, %s, %s, %s",c.getPrice(), c.getBy(), c.getGram(), c.getCnt() +"\n");
        System.out.printf("%s, %s, %s, %s",d.getPrice(), d.getBy(), d.getFreq(), d.getCnt() +"\n");
        System.out.printf("%s, %s, %s, %s",e.getPrice(), e.getBy(), e.getOr(), e.getCnt() +"\n\n\n");


        
    }
}
