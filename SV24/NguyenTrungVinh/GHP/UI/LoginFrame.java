package SV24.NguyenTrungVinh.GHP.UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import SV24.NguyenTrungVinh.GHP.Controller.LoginController;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameText, passwordText;
    private JButton loginButton;
    private KeyListener listener;

    public LoginFrame(){
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH | this.getExtendedState()); 
        this.setTitle("Quản lý trung tâm ngoại ngữ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setListener();
        this.setComponent();
        this.addKeyListener(listener);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setVisible(true);
    }

    private void setListener(){
        listener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    login();
                }
            }
            
        };

    }

    private void setComponent(){
        int x = 690;
        int y = 360;
        int width = 120;
        int height = 30;

        usernameText = new JLabel("Username");
        usernameText.setBounds(x, y-25, width, height);
        usernameField = new JTextField();
        usernameField.setBounds(x, y, width, height);

        passwordText = new JLabel("Password");
        passwordText.setBounds(x, y+5+height, width, height);
        passwordField = new JPasswordField();
        passwordField.setBounds(x, y+30+height, width, height);
        passwordField.addKeyListener(listener);

        loginButton = new JButton("Login");
        loginButton.setBounds(x, y + 120, width, height);
        loginButton.addActionListener(l -> login());

        this.add(usernameText);
        this.add(usernameField);
        this.add(passwordText);
        this.add(passwordField);
        this.add(loginButton);
    }

    private void login(){
        String username = usernameField.getText();
        char[] passByte = passwordField.getPassword();
        String password = new String(passByte);

        if(LoginController.loginWithUsernameAndPassword(username, password)){
            // open Manager frame
            new HomeFrame();
            this.dispose();
            return;
        }

        // show failed dialog
        JOptionPane.showMessageDialog(this, "Incorrect username or password", "Login failed", JOptionPane.ERROR_MESSAGE);
    }

}
