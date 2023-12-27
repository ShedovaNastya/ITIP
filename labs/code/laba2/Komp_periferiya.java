public abstract class Komp_periferiya {
    protected int price;
    protected boolean by;
    protected static int cnt = 0;

    public Komp_periferiya(int a, boolean b){
        price = a;
        by = b;
        cnt += 1;
    }
    public Komp_periferiya(){
        this(0, false);
        cnt += 1;
    }
    public int getPrice(){
        return price;
    }
    public boolean getBy(){
        return by;
    }
    public int getCnt(){
        return cnt;
    }
    public void setPrice(int val){
        price = val;
    }
    public void setBy(boolean val){
        by= val;
    }
    public abstract void Filosofy();
    
}
