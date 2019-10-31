/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPet;

import User.UserDB;
import User.UserList;
import User.UserModel;
import Pet.Cat;
import Pet.Dog;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author phaisan
 */
public class PetController extends JFrame {

    private GameView gameView;
    private MenuView menuView;

    private UserModel model;
    private int actionCount = 3;
    private UserList userList;
    private UserDB userDB;

    private void displayDialogueText(String line) {
        this.gameView.getDialogueTextArea().setText("\n  Day :" + this.model.getPet().getDayCount() + "\n    " + line);
    }

    private void displayStatsTextArea(String line) {
        this.gameView.getStatsTextArea().setText(line);
    }

    private void eventHandleFeedButton() {
        this.model.getPet().feed();
        this.actionCount--;
        displayDialogueText(this.model.getPet().getName() + " has been fed");
        displayStatsTextArea(this.model.getPet().toString());
        checkDay();
    }

    private void eventHandlePetButton() {
        this.model.getPet().pet();
        this.actionCount--;
        displayDialogueText(this.model.getPet().getName() + " has been pet");
        displayStatsTextArea(this.model.getPet().toString());
        checkDay();

    }

    private void eventHandleWalkButton() {
        this.model.getPet().walk();
        this.actionCount--;
        displayDialogueText(this.model.getPet().getName() + " has been walked");
        displayStatsTextArea(this.model.getPet().toString());
        checkDay();

    }

    private void eventHandleRestButton() {
        this.model.getPet().rest();
        this.actionCount--;
        displayDialogueText(this.model.getPet().getName() + " has been feed");
        displayStatsTextArea(this.model.getPet().toString());
        checkDay();

    }

    private void eventHandleKeyReleased(KeyEvent e) {
        String userName = this.menuView.getInputTextField().getText();
        if (userName != null && !userName.equals("")) {
            if (this.userList.containsUser(userName)) {
                this.menuView.getButton2().setEnabled(true);
            } else {
                this.menuView.getButton2().setEnabled(false);
            }
            this.menuView.getButton1().setEnabled(true);
        } else {
            this.menuView.getButton1().setEnabled(false);
            this.menuView.getButton2().setEnabled(false);

        }
    }

    private void eventHandleKeyReleased2(KeyEvent e) {
        String petName = this.menuView.getInputTextField().getText();

        if (petName != null && !petName.equals("")) {
            this.menuView.getButton1().setEnabled(true);
            this.menuView.getButton2().setEnabled(true);
        } else {
            this.menuView.getButton1().setEnabled(false);
            this.menuView.getButton2().setEnabled(false);
        }
    }

    private void eventHandleNewCatButton(String userName) {
        String petName = this.menuView.getInputTextField().getText();
        this.model = new UserModel(userName, new Cat(petName));

        this.getContentPane().removeAll();
        this.repaint();
        this.gamingPlay();

        this.displayStatsTextArea(this.model.getPet().toString());
        this.displayDialogueText("");

    }

    private void eventHandleNewDogButton(String userName) {
        String petName = this.menuView.getInputTextField().getText();
        this.model = new UserModel(userName, new Dog(petName));

        this.getContentPane().removeAll();
        this.repaint();
        this.gamingPlay();

        this.displayStatsTextArea(this.model.getPet().toString());
        this.displayDialogueText("");

    }

    private void eventHandleLoadButton() {
        String userName = this.menuView.getInputTextField().getText();
        this.model = userList.getUser(userName);

        this.getContentPane().removeAll();
        this.repaint();
        this.gamingPlay();

        this.displayStatsTextArea(model.getPet().toString());
        this.displayDialogueText("");

    }

    private void eventHandleNewButton() {
        String userName = this.menuView.getInputTextField().getText();
        this.menuView.choosePet();

        this.menuView.getInputTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                eventHandleKeyReleased2(e);
            }
        });
        this.menuView.getButton1().addActionListener((ActionEvent e) -> {
            eventHandleNewCatButton(userName);
        });
        this.menuView.getButton2().addActionListener((ActionEvent e) -> {
            eventHandleNewDogButton(userName);
        });
    }

    /**
     * The method to run panel game view and run game
     *
     */
    public void gamingPlay() {

        this.gameView = new GameView(model.getPet().getClass().getSimpleName().toLowerCase());

        this.gameView.getFeedButton().addActionListener((ActionEvent e) -> {
            eventHandleFeedButton();
        });

        this.gameView.getWalkButton().addActionListener((ActionEvent e) -> {
            eventHandleWalkButton();
        });

        this.gameView.getPetButton().addActionListener((ActionEvent e) -> {
            eventHandlePetButton();
        });

        this.gameView.getRestButton().addActionListener((ActionEvent e) -> {
            eventHandleRestButton();
        });

        this.getContentPane().setLayout(null);
        this.getContentPane().add(this.gameView);

    }

    /**
     * The constructor to start view and display manu
     *
     * @param userDb
     */
    public PetController(UserDB userDb) {
        menuView = new MenuView();
        this.userList = new UserList();
        this.userDB = userDb;
        userDB.getData(this.userList);

        //Blocking key
        this.menuView.getInputTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                eventHandleKeyReleased(e);
            }
        });

        //Listener to the button
        this.menuView.getButton1().addActionListener((ActionEvent e) -> {
            eventHandleNewButton();
        });
        this.menuView.getButton2().addActionListener((ActionEvent e) -> {
            eventHandleLoadButton();
        });

        //Closing window Listenner
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Save data
                if (model != null) {
                    model.getPet().sleep();
                    model.getPet().addDayCount();
                    userList.addUser(model.getName(), model.getPet());
                    userDB.setData(userList);
                }

                userDB.closeConnections();
                e.getWindow().dispose();
            }
        });

        //set panel into frame
        this.getContentPane().setLayout(null);
        this.getContentPane().add(this.menuView);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        setSize(this.menuView.getWidth(), this.menuView.getHeight()); // manually computed sizes
        setResizable(true);

    }

    /**
     * The main to run program
     *
     * @param args
     */
    public static void main(String[] args) {
        UserList userList = new UserList();

        userList.addUser("Phaisan", new Dog("ban"));
        UserDB user = new UserDB();
        PetController app = new PetController(user);
        app.setVisible(true);
    }

    /**
     * Check the day
     *
     */
    public void checkDay() {
        if (this.model.getPet().checkStats()) {
            gameOver();
        }
        if (this.actionCount <= 0) {
            this.model.getPet().rest();
            this.actionCount = 3;
            this.model.getPet().addDayCount();
            displayDialogueText(model.getPet().getName() + " have been sleep ");
        }

    }

    /**
     * The method when game over
     */
    public void gameOver() {
        this.getContentPane().removeAll();
        this.repaint();
        this.userList.removeUser(this.model.getName());
        this.userDB.setData(userList);
        this.userDB.closeConnections();
        this.getContentPane().removeAll();
        this.repaint();
        this.add(this.gameView.getGameOver());
        this.setBackground(Color.BLACK);

        timer(1000, 1000);

    }

    /**
     * Timer 
     *
     * @param delay delay
     * @param period period
     */
    public void timer(int delay, int period) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeUp();
            }
        }, delay, period);

    }

    /**
     * when time is up
     *
     */
    public void timeUp() {
        this.dispose();
        System.exit(0);
    }

}
