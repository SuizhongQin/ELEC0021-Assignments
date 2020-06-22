package java_assiganment;

public class Circle extends Point{
    private double r;
    
    public Circle(){super();r=0;}
    public Circle(int x,int y, double r){ super(x,y); setRadius(r);}
    
    public double getRadius(){return r;}
    public void   setRadius(double rval){r=rval<0?0:rval;}

    public double getArea(){return Math.PI*r*r;}

    @Override
    public String getName(){return "Circle";}

    @Override
    public String toString(){return "C="+super.toString()+";R="+r;}
}