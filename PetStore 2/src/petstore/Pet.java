/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author dalemusser
 */
public class Pet {
    private String type;
    public String name;
    private Integer age;
    public Gender gender;
    
    public Pet() {
        age = 0;
    }
    
    public Pet(String type, String name) {
        this();
        this.type = type;
        this.name = name;
    }
    
    public Pet(String type, String name, int age, Gender gender) {
        this(type, name);
        this.age = age;
        this.gender = gender;
    }
    
    public String getType() {
        return type;
    }
    
    public void birthday() {
        age++;
    }
    
    public int getAge() {
        return age;
    }
    
}
