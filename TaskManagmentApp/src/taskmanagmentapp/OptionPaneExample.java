/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagmentapp;
import javax.swing.*;  
public class OptionPaneExample {  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();  
    JOptionPane.showMessageDialog(f,"New account has been registered successfully");  
}  
public static void main(String[] args) {  
    new OptionPaneExample();  
}  
} 