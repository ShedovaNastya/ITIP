public class Klaviatura extends Komp_periferiya{
    private int num_of_case;
    public Klaviatura(int a, boolean b, int n){
        super(a,b);
        num_of_case = n;
    }
    public Klaviatura(){
        this(100, true, 104);
    }
    public int getNum(){
        return num_of_case;
    }
    public void setNum(int a){
        num_of_case = a;
    }
    @Override
    public void Filosofy(){
        System.out.println(" I'm Klaviatura");
    }
    public void Sound(){
        System.out.println("klac Klac klac");
    }
}
