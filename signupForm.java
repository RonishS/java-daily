package javaswing;
import javax.swing.*;
import java.awt.event.*; // importing prebuilt GUI components and event handling classes

public class signupForm extends JFrame { // creates a class that inherits all features from JFrame
    
    public signupForm() { 	//constructor
        setSize(800, 600); 		//sets the window size (800 pixels wide & 600 pixels tall)
        setTitle("SignupForm");	//sets the text that appears in windows title bar
        setLayout(null);

        JLabel jl1 = new JLabel("Full Name");	//creates a text label that displays "Full Name"
        jl1.setBounds(100, 150, 140, 30);	//positions the label at x=100,y=150 ,width=140,and height = 30
        add(jl1);		//adds the full name label to the window

        JTextField jt1 = new JTextField();	//creates a empty text input box for full name
        jt1.setBounds(250, 150, 150, 30);
        add(jt1);

        JLabel jl2 = new JLabel("Email");	//creates a text label that displays "Email"
        jl2.setBounds(100, 200, 140, 30);
        add(jl2);

        JTextField jt2 = new JTextField();	//creates a empty text input box for email
        jt2.setBounds(250, 200, 150, 30);
        add(jt2);

        JLabel jl3 = new JLabel("Username");	//creates a text label that displays "Username"
        jl3.setBounds(100, 250, 140, 30);
        add(jl3);

        JTextField jt3 = new JTextField();	//creates a empty text input box for username
        jt3.setBounds(250, 250, 150, 30);
        add(jt3);

        JLabel jl4 = new JLabel("Password");	//creates a text label that displays "Password"
        jl4.setBounds(100, 300, 140, 30);
        add(jl4);

        JPasswordField jp1 = new JPasswordField(); 	//creates a password field
        jp1.setBounds(250, 300, 150, 30);
        add(jp1);

        JLabel jl5 = new JLabel("Confirm Password");	//creates a text label that displays "Confirm Password"
        jl5.setBounds(100, 350, 140, 30);
        add(jl5);

        JPasswordField jp2 = new JPasswordField(); 	//creates a confirm password field
        jp2.setBounds(250, 350, 150, 30);
        add(jp2);

        JButton jb = new JButton("Sign Up");	//creates a clickable button with text "Sign Up" on it
        jb.setBounds(200, 420, 100, 40);
        add(jb);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	 // Makes the program exit completely when you close the window
        setVisible(true);	  // Makes the window visible on screen (without this, window stays hidden)

        jb.addActionListener(new ActionListener() {	// Attaches a listener to the button that waits for clicks
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gets the text from all input fields when button is clicked
                String fullName = jt1.getText();
                String email = jt2.getText();
                String username = jt3.getText();
                String password = new String(jp1.getPassword());
                String confirmPassword = new String(jp2.getPassword());

                // Simple validation to check if passwords match
                if (password.equals(confirmPassword)) {
                    System.out.println("Sign Up button clicked");
                    System.out.println("Full Name: " + fullName);
                    System.out.println("Email: " + email);
                    System.out.println("Username: " + username);
                } else {
                    System.out.println("Passwords do not match!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new signupForm(); 	// Creates a new signupForm object, which triggers the constructor and displays the window
    }
}