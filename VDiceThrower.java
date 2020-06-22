package java_assiganment;

import java.util.*;

public class VDiceThrower {
    private static int NumOfSide;
    private static int NumOfThrow;


    private static void getNumOfData (Scanner input) {
        String input_value = " ";

        System.out.printf("Please enter the number of the virtual dice sides(sides >= 2):\n");


        //get number of sides
        while (true) { // loop until we get it correctly
            input_value = input.nextLine();

            try{
                NumOfSide = Integer.parseInt(input_value);
            }
           
            
            catch (NumberFormatException e){
                System.err.printf("Exception: %s \n", e);
                System.err.printf("The input should be an integer greater or equal to 2 , please enter again:\n");
                continue;
            }


            if (NumOfSide < 2) {
                System.err.printf("The number of sides should be >=2 !\n Please enter it again: \n");
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        }

        //get number of throws
        System.out.printf("Enter the number of throws of the virtual dice (should multiple of number of sides):\n");
        while (true) { // loop until we get it correctly

            input_value = input.nextLine();

            try{
                NumOfThrow = Integer.parseInt(input_value);
            }

            catch (NumberFormatException e){
                System.err.printf("Exception: %s \n", e);
                System.err.printf("The input should be an integer which is multiple of number of sides, try again\n");
                continue;
            }

            if (NumOfThrow % NumOfSide != 0) {
                System.err.printf("The number of throws should be multiple of number of sides! \nRe-enter the number! \n");
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        }

    }



    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        getNumOfData(input);
        // array for displaying result and initialise it
        int[] result = new int[NumOfSide];
        for(int i = 0; i < NumOfSide; i++){
            result[i] = 0;
        }

        //random generation
        Random randGen = new Random(); // create new random generator object
        for (int i = 1; i <= NumOfThrow; i++) {
            int thisFace = randGen.nextInt(NumOfSide); // generate next random
            result[thisFace] += 1;
        }

        //print result
        for(int i = 1; i <= NumOfSide; i++){
            System.out.println("Side " + i + " came " + result[i - 1] + " times");
        }

    }
}