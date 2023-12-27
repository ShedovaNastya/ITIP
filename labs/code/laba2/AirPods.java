public class AirPods extends Nayshniki {
    private boolean originality;

    public AirPods(int a, boolean b, int g, boolean o){
        super(a, b, g);
        originality = o;
    }
    public AirPods(){
        this(21000, false, 250, true);
    }
    public boolean getOr(){
        return originality;
    }
    public void setOr(boolean a){
        originality = a;
    }
    @Override
    public void Filosofy(){
        System.out.println(" I'm nayshniki");

    }
}