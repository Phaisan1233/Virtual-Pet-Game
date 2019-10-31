/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPet;

import Pet.Pet;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Phaisan
 * @author Shannon Imbo - 1303744
 */
public class GameView extends JPanel {

    // The user interface components needed by the controller
    private JButton feedButton;
    private JButton walkButton;
    private JButton petButton;
    private JButton restButton;

    private JTextArea statsTextArea;
    private JTextArea dialogueTextArea;

    /**
     * The constructor to create panel view of the game
     *
     * @param pet
     */
    public GameView(String pet) {

        setLayout(null);

        this.feedButton = new JButton("Feed");
        this.feedButton.setBounds(950, 100, 200, 50);
        this.add(this.feedButton);

        // Adds the Walk button
        this.walkButton = new JButton("Walk");
        this.walkButton.setBounds(950, 200, 200, 50);
        this.add(this.walkButton);

        // Adds the Pet button
        this.petButton = new JButton("Pet");
        this.petButton.setBounds(950, 300, 200, 50);
        this.add(this.petButton);

        this.restButton = new JButton("Rest");
        this.restButton.setBounds(950, 400, 200, 50);
        this.add(this.restButton);

        this.statsTextArea = new JTextArea("");
        this.statsTextArea.setBounds(25, 100, 230, 150);
        this.statsTextArea.setFont(new Font("Serif", Font.PLAIN, 25));
        this.statsTextArea.setEditable(false);
        this.add(this.statsTextArea);

        this.dialogueTextArea = new JTextArea("");
        this.dialogueTextArea.setBounds(400, 500, 400, 100);
        this.dialogueTextArea.setFont(new Font("Serif", Font.PLAIN, 25));
        this.dialogueTextArea.setEditable(false);
        this.add(this.dialogueTextArea);

        this.add(createImagePet(pet));

        //set blackgrounf image
        JPanel backgroundPanel = new JPanel();
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("room1.png"));
        backgroundPanel.add(new JLabel(backgroundImage));
        backgroundPanel.setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        this.add(backgroundPanel);

        setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
    }

    /**
     * The method to create pet image
     *
     * @param pet
     * @return
     */
    public JPanel createImagePet(String pet) {
        JPanel petPanel = new JPanel();
        String pic = pet + "gif.gif";
        ImageIcon catImage = new ImageIcon(getClass().getResource(pic));
        petPanel.add(new JLabel(catImage), BorderLayout.CENTER);
        petPanel.setSize(275, 200);
        petPanel.setLocation(490, 200);
        return petPanel;
    }

    // Get and Set method -------------------------------
    public JButton getFeedButton() {
        return feedButton;
    }

    public JButton getWalkButton() {
        return walkButton;
    }

    public JButton getPetButton() {
        return petButton;
    }

    public JButton getRestButton() {
        return restButton;
    }

    public JTextArea getStatsTextArea() {
        return statsTextArea;
    }

    public JTextArea getDialogueTextArea() {
        return dialogueTextArea;
    }
    //----------------------------------------------------
    
    /**
     *The method to get image of game over
     * 
     * @return
     */
    public JPanel getGameOver(){
        JPanel gameover = new JPanel();
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("gameOver.png"));
        gameover.add(new JLabel(backgroundImage));
        gameover.setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        return gameover;
    }

}
