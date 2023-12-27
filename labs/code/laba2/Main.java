public class Main {
    public static void main(String[] args){
        Point2d a = new Point2d(4,5);
        Point3d b = new Point3d(8,2,9);
        Point3d c = new Point3d();
        System.out.printf("%s, %s",a.getX(), a.getY()+"\n");
        System.out.printf("%s, %s, %s",b.getX(), b.getY(), b.getZ()+"\n");
        System.out.printf("%s, %s, %s",c.getX(), c.getY(), c.getZ()+"\n");
        a.setX(2);
        b.setY(6);
        c.setZ(3);
        System.out.printf("%s, %s",a.getX(), a.getY()+"\n");
        System.out.printf("%s, %s, %s",b.getX(), b.getY(), b.getZ()+ "\n");
        System.out.printf("%s, %s, %s",c.getX(), c.getY(), c.getZ()+"\n");
    }
    
}
