package java_assiganment;

import java.util.*; // needed for the Scanner class in the enhanced version

public class MeanAndVariance {
    private double[] data;
    public double mean () {
        // method implementation here
        int length=data.length;
        double m=0;
        for (int i = 0;i < length;i++){
            m=m+data[i];
        }
        return m/length;
    }
    public double variance () {
        // method implementation here
        int length=data.length;
        double m=mean();
        double v=0;
        for (int i = 0;i < length;i++){
            v=v+(data[i]-m)*(data[i]-m);
        }
        return v/length;
    }
    public double[] getData () {
        return data;
    }
    public void setData (double[] newData) {
        data = newData;
    }
    @Override // overrides Object toString - all Java classes inherit (ultimately) from Object
    public String toString () {
        // method implementation here
        String s = "";
        for (double d : data){
            s = s + d + " ";
        }
                
        return s;
    }
    public MeanAndVariance (double[] myData) { // constructor, called indirectly via new
        data = myData;
    }
    public MeanAndVariance () { // constructor with no data, called indirectly via new
        data = null;
    }
    private static int getNumOfData (Scanner input) {
        System.out.printf("Enter the number of arguments:\n");
        int ndata;
        while (true) { // loop until we get it correctly
            ndata = input.nextInt();
            if (ndata < 2) {
                System.out.printf("the number of data should be >=2 !\n");
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        }
        return ndata;
    }
    
    public void getDataSet (Scanner input) {
        int ndata = getNumOfData(input);
        data = new double[ndata]; // we create the array instance variable
        // here you should write code that gets exactly ndata numbers
        // from the standard input and initialises the array elements
        // you will need a while (true) loop as above
        // and you should use the Scanner nextDouble method
        System.out.printf("Enter the elements:\n");
        int i=0;
        double inputData;
        while (true) { // loop until we get it correctly
            inputData=input.nextDouble();
            data[i]=inputData;
            i=i+1;
            if (i==ndata){
                break;
            }
        }

    }
    public static void main (String[] args) {
     
        Scanner input = new Scanner(System.in);
        // initialise data1 values here
        MeanAndVariance mv = new MeanAndVariance(); // create new object instance
 mv.getDataSet(input);
        System.out.printf("The mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());

        //double[] data2 = new double[5];
        // initialise data2 values here
        mv.getDataSet(input); // reset data set
        System.out.printf("\nThe mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());

        System.out.printf( "Mean: %f Variance: %f\n", mv.mean(), mv.variance());
    }
} // end class