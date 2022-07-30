package interfaces;

import logic.coffeeShopController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginFormViewController extends JFrame {
    private JTextField usernameTextField;
    private JButton loginButton;
    private JPanel panel;
    private JPasswordField passwordField;
    private coffeeShopController csc;
    private addBeverageViewController abvc;

    public loginFormViewController() {

        csc = new coffeeShopController();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = csc.authenticateAdmin(usernameTextField.getText() , passwordField.getText());

                if(valid) {
                  setVisible(false);

                    abvc = new addBeverageViewController();
                    abvc.run();

                } else {
                    JOptionPane.showMessageDialog(null , "Login faild!");
                }

            }
        });
    }

    public void run() {
        this.setContentPane(panel);
        this.setTitle("Login Form");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
