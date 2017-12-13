/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

import static petstore.Gender.*;

/**
 *
 * @author dalemusser
 */
public class PetStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog dog = new Dog("Orion", 3, MALE);
        
        
        System.out.println(dog.getAge());
        
        
                
    }
    
}
