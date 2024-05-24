/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.model;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class Employee {
    
    private  int  id = -1;
    private String  firstName;
    private String  lastName;
    private String  address;
    
    
    public  void  setId(int inId){
        id = inId;
    }
    
    
    public  void  setFirstName(String inFirstName){
        firstName = inFirstName;
    }
    
    public  void  setLastName(String inLastName){
        lastName = inLastName;
    }
    
    
    public  void  setAddress(String inAddress){
        address = inAddress;
    }
    
    
    
    
     public  int  getId(){
        return   id;
    }
    
    
    public  String  getFirstName(){
        return    firstName;
    }
    
    public  String  getLastName(){
        return    lastName;
    }
    
    
    public  String  getAddress(){
        return    address;
    }
    
    
}
