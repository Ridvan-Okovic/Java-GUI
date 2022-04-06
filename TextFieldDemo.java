/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class TextFieldDemo extends JFrame implements ActionListener {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_CHAR = 30;

    
    private JTextField name;
    private JTextField age;
    
    public void DigitCheck(String inputString) throws DigitNotAllowedException {
        char character;
        for (int i = 0; i < inputString.length(); i++) {
            character = inputString.charAt(i);
            if(Character.isDigit(character)) {
                throw new DigitNotAllowedException("Error. Digits not allowed.");
            }
        }
    }
    
    public void StringCheck(String inputString) throws LetterNotAllowedException {
        char character;
        for (int i = 0; i < inputString.length(); i++) {
           character = inputString.charAt(i);
           if(Character.isLetter(character)) {
               throw new LetterNotAllowedException("Error. Letters not allowed.");
           }
        }
    }
           
    public TextFieldDemo() {
        super("Text field demo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel namePanel = new JPanel();
        namePanel.setBackground(Color.WHITE);
        namePanel.setLayout(new FlowLayout());
        name = new JTextField("", NUMBER_OF_CHAR);
        JLabel nameLabel = new JLabel("Enter your name here");
        namePanel.add(nameLabel);
        namePanel.add(name);
        
        age = new JTextField("", NUMBER_OF_CHAR);
        JLabel ageLabel = new JLabel("Enter age");
        namePanel.add(ageLabel);
        namePanel.add(age);
        add(namePanel, NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.BLUE);
        
        JButton compute = new JButton("Ok");
        compute.addActionListener(this);
        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        
        buttonPanel.add(compute);
        buttonPanel.add(reset);
        add(buttonPanel, CENTER);
    }


    public static void main(String[] args) {
        TextFieldDemo gui = new TextFieldDemo();
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        try {
            if (actionCommand.equals("Ok")) {
                    DigitCheck(name.getText());
                    StringCheck(age.getText());
            }
            else if (actionCommand.equals("Reset")) {
                name.setText("");
                age.setText("");
            }
            else {
                name.setText("An unexpected error occurred.");
            }
        }
        catch (DigitNotAllowedException e1) {
            name.setText(e1.getMessage());
        }
        catch (LetterNotAllowedException e2) {
            age.setText(e2.getMessage());
        }
    } 
}
