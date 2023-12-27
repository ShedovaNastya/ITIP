public class Graficheskiy_planshet extends Komp_periferiya {
    private int frequency;
    public Graficheskiy_planshet(int a, boolean b, int f){
        super(a,b);
        frequency = f;
    }
    public Graficheskiy_planshet(){
        this(1250, false, 120);
    }
    public int getFreq(){
        return frequency;
    }
    public void setFreq(int a){
        frequency = a;
    }
    @Override
    public void Filosofy(){
        System.out.println(" I'm graficheskiy planshet");
    }
    public void brig(){
        System.out.println("Bright screen");
    }
}
