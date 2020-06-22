package java_assiganment;

public class Point implements Shape{
    private int x; 
    private int y;

    public Point () {x=0;y=0;}
    public Point (int xval, int yval) {x=xval;y=yval;}

    public int getX() {return x;}
    public int getY() {return y;}
    public void setX(int xval) {x=xval;}
    public void setY(int yval) {y=yval;}
 
    @Override
    public String getName() {return "Point";}
 
    @Override
    public String toString() {return "["+x+","+y+"]";}
 
}