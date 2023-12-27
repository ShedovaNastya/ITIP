public class Nayshniki extends Komp_periferiya{
    private int gram;
    public Nayshniki(int a, boolean b, int g){
        super(a,b);
        gram = g;
    }
    public Nayshniki(){
        this(500, true, 345);
    }
    public int getGram(){
        return gram;
    }
    public void setGram(int a){
        gram = a;
    }
    @Override
    public void Filosofy(){
        System.out.println(" I'm nayshniki");
    }
    public void fr(){
        System.out.println("It's very cool nayshniki");
    }

}
