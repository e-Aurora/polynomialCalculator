package Homework;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JButton multiplyButton;
    JButton addButton;
    JButton subtractButton;
    JTextField polynomial1;
    JTextField polynomial2;
    JTextField result;
    JLabel getPol;
    JLabel res;

    GUI(){
        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        frame.add(panel);

        multiplyButton = new JButton("Multiply");
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        polynomial1 = new JTextField();
        polynomial2 = new JTextField();
        result = new JTextField();
        getPol = new JLabel("Enter Polynomials");
        res = new JLabel("Result");

        panel.add(polynomial1);
        panel.add(getPol);
        getPol.setSize(200,50);
        getPol.setLocation(50,50);
        polynomial1.setBackground(Color.lightGray);
        polynomial1.setSize(200,50);
        polynomial1.setLocation(50,100);
        panel.add(polynomial2);
        polynomial2.setBackground(Color.lightGray);
        polynomial2.setSize(200,50);
        polynomial2.setLocation(50,150);

        panel.add(multiplyButton);
        multiplyButton.setBackground(Color.pink);
        multiplyButton.setSize(100,50);
        multiplyButton.setLocation(50,250);
        panel.add(addButton);
        addButton.setBackground(Color.pink);
        addButton.setSize(100,50);
        addButton.setLocation(200,250);
        panel.add(subtractButton);
        subtractButton.setBackground(Color.pink);
        subtractButton.setSize(100,50);
        subtractButton.setLocation(350,250);

        panel.add(result);
        panel.add(res);
        res.setSize(100,50);
        res.setLocation(50,350);
        result.setBackground(Color.darkGray);
        result.setForeground(Color.white);
        result.setSize(200,50);
        result.setLocation(50,400);
        result.setEditable(false);

        multiplyButton.addActionListener(new multiplyButtonListener());
        addButton.addActionListener(new addButtonListener());
        subtractButton.addActionListener(new subtractButtonListener());

        frame.validate();

    }

    public static void main(String[] args) {
        new GUI();
    }

    class multiplyButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String p1 = polynomial1.getText();
            String p2 = polynomial2.getText();
            result.setText(Polynomial.multiply(new Polynomial(p1), new Polynomial(p2)).print());
        }
    }

    class addButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String p1 = polynomial1.getText();
            String p2 = polynomial2.getText();
            result.setText(Polynomial.addition(new Polynomial(p1), new Polynomial(p2)).print());
        }
    }

    class subtractButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String p1 = polynomial1.getText();
            String p2 = polynomial2.getText();
            result.setText(Polynomial.subtraction(new Polynomial(p1), new Polynomial(p2)).print());
        }
    }
}




