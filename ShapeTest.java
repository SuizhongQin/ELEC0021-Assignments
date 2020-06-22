package java_assiganment;

import java.util.*; 
public class ShapeTest {
    
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        String command="";
        Shape []shapes = new Shape[1000000];// create a list, for store all shapes data
        int index=0,x,y,r,h;
        while (true){
            System.out.printf("Please type the shape you want to creat: point/circle/cylinder/quit \n");
            command=input.next();
            if (command.equals("quit")){
                break;
            }else if (command.equals("point")){
                System.out.printf("Please input point's X-coordinate: \n");
                x=input.nextInt();
                System.out.printf("Please input point's Y-coordinate: \n");
                y=input.nextInt();
                shapes[index]=new Point(x,y);// store data into list create before
            }else if (command.equals("circle")){
                System.out.printf("Please input circle's X-coordinate: \n");
                x=input.nextInt();
                System.out.printf("Please input circle's Y-coordinate: \n");
                y=input.nextInt();
                System.out.printf("Please input circle's radius: \n");
                r=input.nextInt();
                shapes[index]=new Circle(x,y,r);// store data into list create before
            }else if (command.equals("cylinder")){
                System.out.printf("Please input cylinder's X-coordinate:\n");
                x=input.nextInt();
                System.out.printf("Please input cylinder's Y-coordinate:\n");
                y=input.nextInt();
                System.out.printf("Please input cylinder's radius: \n");
                r=input.nextInt();
                System.out.printf("Please input cylinder's height: \n");
                h=input.nextInt();
                shapes[index]=new Cylinder(x,y,r,h);// store data into list create before
            } 
            index++;
        }
        
        for (int i=0;i<index;i++){
            System.out.printf("The shape %d is %s",i,shapes[i].getName());
            System.out.printf("\n");
            System.out.printf("The details : "+shapes[i].toString());// toString in shape find not abstract to String in point
            System.out.printf("\n");
            if (shapes[i] instanceof Cylinder){ //interface to Cylinder check
                System.out.printf("The area is %f",((Cylinder)shapes[i]).getArea());
                System.out.printf("\n");
                System.out.printf("The volume is %f",((Cylinder)shapes[i]).getVolume());
                System.out.printf("\n");
            }else if (shapes[i] instanceof Circle){
                System.out.printf("The area is %f",((Circle) shapes[i]).getArea());
                System.out.printf("\n");
            }
            
            System.out.printf("\n");
        }
        input.close();
    }
} // end class