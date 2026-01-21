package javaswing;

import javax.swing.*;
import java.awt.event.*; // importing prebuilt GUI components and event handling classes 

public class Loginform extends JFrame { // creates a class that inherits all features from Jframe
    public Loginform() { 	//constructor
        setSize(800, 600); 		//sets the window size (800 pixels wide & 600 pixels tall)
        setTitle("LoginForm");	//sets the text that appears in windows title bar 
        setLayout(null);	
        
        JLabel jl = new JLabel("Username");	//creates a text label that displays "username"
        jl.setBounds(100, 200, 140, 30);	//positions the label at x=100,y=200 ,width=140,and height = 30
        add(jl);		//adds the username label to the window 
        
        JTextField jt = new JTextField();	//creates a empty text input box where i can type 
        jt.setBounds(250, 200, 150, 30);
        add(jt);
        
        JLabel jl1 = new JLabel("Password");	//creates a text label that displays "Password"
        jl1.setBounds(100, 250, 140, 30);
        add(jl1);
        
        JPasswordField jp = new JPasswordField(); 	//creates a password field
        jp.setBounds(250, 250, 150, 30);
        add(jp);
        
        JButton jb = new JButton("Login");	//creates a clickable button with text "login" on it 
        jb.setBounds(200, 350, 100, 40);
        add(jb); 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	 // Makes the program exit completely when you close the window
        setVisible(true);	  // Makes the window visible on screen (without this, window stays hidden)
        
       
        jb.addActionListener(new ActionListener() {	// Attaches a listener to the button that waits for clicks
            @Override
            public void actionPerformed(ActionEvent e) {
               
                System.out.println("Login button clicked");
            }
        });
    }
    
    public static void main(String[] args) {
        new Loginform(); 	// Creates a new Loginform object, which triggers the constructor and displays the window
    }
}