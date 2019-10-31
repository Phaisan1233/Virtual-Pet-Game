/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPet;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author gsj6766
 */
public class MenuView extends JPanel {

    private JButton button1; // New game or new Cat
    private JButton button2; //Load game or new dog

    private JTextField inputTextField;
    private JLabel inputLabel;

    private JLabel title;

    /**
     * The constructor to create panel view of the game
     *
     */
    public MenuView() {

        setLayout(null);

        title = new JLabel("PET OWNER SIMULATOR");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setBounds(400, 50, 600, 200);
        add(title);

        inputTextField = new JTextField();
        inputTextField.setFont(new Font("Serif", Font.PLAIN, 20));
        inputTextField.setBounds(480, 250, 220, 50);
        this.add(inputTextField);

        inputLabel = new JLabel("User name :");
        inputLabel.setFont(new Font("Serif", Font.BOLD, 20));
        inputLabel.setBounds(480, 220, 150, 50);
        add(inputLabel);

        button1 = new JButton("New Game!");
        button1.setFont(new Font("Serif", Font.PLAIN, 20));
        button1.setBounds(430, 315, 150, 70);
        button1.setEnabled(false);
        add(button1);

        button2 = new JButton("Load game...");
        button2.setFont(new Font("Serif", Font.PLAIN, 20));
        button2.setBounds(630, 315, 150, 70);
        button2.setEnabled(false);
        add(button2);

        //Set image
        JPanel backgroundPanel = new JPanel();
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("menu.jpg"));
        backgroundPanel.add(new JLabel(backgroundImage));
        backgroundPanel.setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        this.add(backgroundPanel);

        setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight()); // set size

    }

    /**
     * The method to change text change to second panel
     *
     */
    public void choosePet() {

        this.remove(title);

        inputTextField.setText("");
        inputLabel.setText("Pet name :");

        button1.setText("choose a cat");
        button1.setEnabled(false);

        button2.setText("choose a dog");
        button2.setEnabled(false);

    }

    //Get and Set method
    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public JLabel getInputLabel() {
        return inputLabel;
    }

    public JLabel getTitle() {
        return title;
    }

}
