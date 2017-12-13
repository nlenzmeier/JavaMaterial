/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2languagebasics;

/**
 *
 * @author Nicolle
 */
public class Nalyv2LanguageBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //variables
        byte sample1 = 0x3A;
        byte sample2 = 58;
        short heartRate = 85;
        long deposits = 135002796;
        float acceleration = 9.584f;
        float mass = 14.6f;
        double distance = 129.763001d;
        boolean lost = true;
        boolean expensive = true;
        int choice = 1;
        char integral = '\u222B';
        char letter1 = 'a';
        char letter2 = 97;
        String greeting = "Hello";
        String name = "Karen";
        
        if(sample1 == sample2){
            System.out.println("The samples are equal.");	
        }
        else{
            System.out.println("The samples are not equal.");	
        }
        
        if(heartRate >= 40 && heartRate <= 80){
            System.out.println("Heart rate is normal.");	
        }
        else{
            System.out.println("Heart rate is not normal.");	
        }
             
        if(deposits >= 100000000){
            System.out.println("You are exceedingly wealthy.");	
        }
        else{
            System.out.println("Sorry you are so poor.");	
        }
        
        float force=(mass*acceleration);
        System.out.printf("Force = %f and %f is the distance.", force, distance);
        
        if(lost==true){
            if(expensive==true){
                System.out.println("I am really sorry! I will get the manager.\n");	
            }
            else{
                System.out.println("Here is a coupon for 10% off.\n");	
            }
        }
        
        switch(choice){
            case 1:
              System.out.println("You chose 1!\n");
              break;
            case 2:
                System.out.println("You chose 2!\n");
                break;
            case 3:
                System.out.println("You chose 3!\n");
                break;
            default:
                System.out.println("You made an unknown choice!\n");
                break;
        }
        
        System.out.printf("%c is an integral\n\n", integral);
        
        if(letter1 == letter2){
            System.out.printf("%c and %c are the same.\n\n", letter1, letter2);	
        }
        else{
            System.out.printf("%c and %c are not the same.\n\n", letter1, letter2);	
        }
        
        int i;
        for(i=5; i<=10; i++){
            System.out.printf("i = %d\n", i);	
        }
        System.out.printf("\n");	
        
        int age = 0;
        while(age < 6){
            System.out.printf("Age = %d\n", age);
            age++;
        }
        
        System.out.printf("\n%s %s", greeting, name);	
    }
    
}
