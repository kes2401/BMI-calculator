/*
 * This program will prompt the user to enter their weight in stones and pounds,
 * or in kilograms, then prompt the user to enter their height in feet and 
 * inches, or in centimetres, before calculating their BMI and displaying the
 * result along with further information based on their BMI score.
 */

/*
 * Program written by Keith Scully.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class BMICalc {
    
    public static void main(String[] args) {
        
        int weightStones;
        int weightPounds;
        int weightTotalPounds;
        double weightKilos = 0;
        int heightFeet;
        int heightInches;
        int heightTotalInches;
        int heightCentimetres;
        double heightMeters = 0; //for BMI calculation
        double bmiScore;
        int choice = 0;
        Boolean continueLoop = true;

        final double KILOGRAMS_PER_POUND = 0.45359237; // Constant variable for conversions
        final double METERS_PER_INCH = 0.0254; // Constant variable for conversions

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome!");
        System.out.println("This program will calculate your body mass index (BMI).");
        System.out.println();

        // GET USER WEIGHT AND CONVERT VALUES
        System.out.println("Would you like to enter your weight in (1)Kilograms or (2)Stones/Pounds?");
        do{
            try{
                do{
                    System.out.print("(Please enter 1 or 2): ");
                    choice = input.nextInt();
                    if(choice != 1 && choice != 2){
                        System.out.println("Opps! Please enter a valid option.");
                    }
                } while(choice != 1 && choice != 2);
                continueLoop = false;
            } // end try
            
            catch(InputMismatchException inputMismatchException){
                System.out.println("You must enter a valid number."); 
                input.nextLine(); //discard input
            }
            
        } while(continueLoop);
        
        continueLoop = true;
        do{
            try{
                if(choice == 1){
                    do{
                        System.out.print("Please enter the number of kilograms: ");
                        weightKilos = input.nextDouble();
                        if(weightKilos <= 0){
                            System.out.println("Your weight should be greater than zero.");
                        }
                    } while(weightKilos <= 0);
                    
                    System.out.println("You have entered " + weightKilos + "kg.");
                    System.out.println(""); //blank line spacing
                    
                    // CONVERSIONS
                    weightTotalPounds = (int)(weightKilos / KILOGRAMS_PER_POUND); // Calculate total pounts from kilos entered then round down to nearest pound.
                    weightStones = weightTotalPounds / 14; // Finds number of stones in total pounds
                    weightPounds = weightTotalPounds % 14; // Calculates remaining pounds after stones are counted
                    
                } else if(choice == 2){
                    do{    
                        System.out.print("Please enter the number of stones: ");
                        weightStones = input.nextInt();
                        System.out.print("Please enter the number of pounds: ");
                        weightPounds = input.nextInt();
                        if((weightStones == 0 && weightPounds == 0) || (weightStones < 0 || weightPounds < 0)){
                            System.out.println("Either Stones or Pounds must be greater than zero, and you cannot enter negative values.");
                        }
                    } while((weightStones == 0 && weightPounds == 0) || (weightStones < 0 || weightPounds < 0));
                    
                    System.out.println("You have entered " + weightStones + "st " + weightPounds + "lb.");
                    System.out.println(""); //blank line spacing
                    
                    // CONVERSIONS
                    weightTotalPounds = (weightStones * 14) + weightPounds; // Calculates total pounds from stones & pounds.
                    weightKilos = weightTotalPounds * KILOGRAMS_PER_POUND; // Converts total pounds to kilograms.
                    
                }
                continueLoop = false;    
            } // end try
            
            catch(InputMismatchException inputMismatchException){
                System.out.println("You must enter whole numbers only, although decimal numbers may be used when entering in kilograms."); 
                input.nextLine(); //discard input
            } // end catch       
            
        } while(continueLoop);

        // GET USER HEIGHT AND CONVERT VALUES
        System.out.println("Would you like to enter your height in (1)Centimetres or (2)Feet/Inches?");
        continueLoop = true;
        do{
            try{
                do{
                    System.out.print("(Please enter 1 or 2): ");
                    choice = input.nextInt();
                    if(choice != 1 && choice != 2){
                        System.out.println("Opps! Please enter a valid option.");
                    }
                } while(choice != 1 && choice != 2);
                continueLoop = false;
            } // end try
            
            catch(InputMismatchException inputMismatchException){
                System.out.println("You must enter a valid number."); 
                input.nextLine(); //discard input
            }
            
        } while(continueLoop);
        
        continueLoop = true;
        do{
            try{
                if(choice == 1){
                    do{
                        System.out.print("Please enter the number of centimetres: ");
                        heightCentimetres = input.nextInt(); 
                        if(heightCentimetres <= 0){
                            System.out.println("Your height should be greater than zero.");
                        }
                    } while(heightCentimetres <= 0);

                    System.out.println("You have entered " + heightCentimetres + "cm.");
                    System.out.println(""); //blank line spacing
                    
                    // CONVERSIONS
                    heightMeters = heightCentimetres / 100.00;
                    heightTotalInches = (int)(heightMeters / METERS_PER_INCH); // Rounds height in meters down to nearest inch
                    heightFeet = heightTotalInches / 12; // Finds number of feet in total inches
                    heightInches = heightTotalInches % 12; // Calculates remaining inches after feet are counted 
                    
                } else if(choice == 2){
                    do{
                        System.out.print("Please enter the number of feet: ");
                        heightFeet = input.nextInt();
                        System.out.print("Please enter the number of inches: ");
                        heightInches = input.nextInt();
                        if((heightFeet == 0 && heightInches == 0) || (heightFeet < 0 || heightInches < 0)){
                            System.out.println("Either Feet or Inches must be greater than zero, and you cannot enter negative values.");
                        }
                    } while((heightFeet == 0 && heightInches == 0) || (heightFeet < 0 || heightInches < 0));
                    
                    System.out.println("You have entered " + heightFeet + "ft " + heightInches + "in.");
                    System.out.println(""); //blank line spacing
                    
                    // CONVERSIONS
                    heightTotalInches = (heightFeet * 12) + heightInches; // Calculates total height in inches from feet & inches.
                    heightCentimetres = (int)((heightTotalInches * METERS_PER_INCH) * 100); // Converts total height in inches to total centimeters and rounds down to nearest cm.  
                    heightMeters = heightCentimetres / 100.00;
                    
                }
            continueLoop = false;
            } // end try
            
            catch(InputMismatchException inputMismatchException){
                System.out.println("You must enter whole numbers only."); 
                input.nextLine(); //discard input
            } // end catch  
            
        } while(continueLoop);

        // CALCULATE BMI VALUE
        bmiScore = (weightKilos / (heightMeters * heightMeters));

        // OUTPUT INFORMATION TO THE USER
        System.out.printf("Your BMI Score is %.2f.", bmiScore);
        System.out.println(""); //blank line spacing
        System.out.println(""); //blank line spacing

        if(bmiScore > 80 || bmiScore <= 0){
            System.out.println("This result seems unlikely, please check that the information you have\n"
                    + "entered is correct");
        } else if(bmiScore > 0 && bmiScore < 18.5){
            System.out.println("According to your BMI, you are underweight and it is recommended you see\n"
                    + "a GP. Many people are naturally slim and are still healthy. But be aware that\n"
                    + "being underweight means you are more likely to get osteoporosis.");
        } else if(bmiScore >= 18.5 && bmiScore < 25){
            System.out.println("According to your BMI you fall into the healthy weight range. This means\n"
                    + "you are less likely to develop weight related problems such as type 2 diabetes, heart\n"
                    + "disease and certain cancers. Continue to eat a good balanced diet and be physically\n"
                    + "active regularly.");
        } else if(bmiScore >= 25 && bmiScore < 30){
            System.out.println("This BMI indicates you are overweight. There is an increased risk of developing\n"
                    + "heart disease, type 2 diabetes and certain cancers with a BMI in this range. Losing\n"
                    + "weight is beneficial and can be achieved through healthy eating and being active daily.\n"
                    + "It is a good idea to set a realistic target of amount of weight you would like to lose\n"
                    + "over a number of weeks. If you are muscular as a result of a lot of sport you don't need\n"
                    + "to lose weight.");
        } else if(bmiScore > 30){
            System.out.println("According to your BMI you fall into the obese category. Your risk of weight\n"
                    + "related diseases such as type 2 diabetes and heart disease is increased. Seek advice\n"
                    + "from a GP for a medical examination before losing weight due to the increased risk of\n"
                    + "weight related diseases. It is a good idea to set a realistic target of amount of weight\n"
                    + "you would like to lose over a number of weeks.");
        }        
        
        System.out.println(""); //blank line spacing
        
    } // end of main method
} // end of class BMICalc
