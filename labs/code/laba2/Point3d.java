public class Point3d extends Point2d{// наследуем класс Point2d
    private double zCoord;//координата z
    public Point3d(double x, double y, double z){//конструктор инициализации
        super(x,y);
        zCoord=z;
    }
    public Point3d(){//конструктор по умолчанию
        this(0,1,0);
    }
    public double getZ(){//возвращение координаты z
        return zCoord;
    }
    public void setZ(double val){//установка значния координаты z
        zCoord = val;
    }
}

