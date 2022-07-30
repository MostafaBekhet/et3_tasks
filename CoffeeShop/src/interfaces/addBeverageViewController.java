package interfaces;

import logic.IBeverage;
import logic.coffeeShopController;
import logic.houseBlend;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addBeverageViewController extends JFrame {
    private JTextField idBeverageTextField;
    private JTextField priceTextField;
    private JTextField nameBeverageTextField1;
    private JTextField categoryIdTextField1;
    private JButton addBeverageButton;
    private JTable table1;
    private JPanel panel;
    private coffeeShopController csc;

    public addBeverageViewController() {

        csc = new coffeeShopController();

        addBeverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                csc.addBeverage(Integer.parseInt(idBeverageTextField.getText()) , nameBeverageTextField1.getText(),
                        Integer.parseInt(priceTextField.getText()) , Integer.parseInt(categoryIdTextField1.getText()),
                        Integer.parseInt(categoryIdTextField1.getText()));

                JOptionPane.showMessageDialog(null , "Beverage record add successfully!");

                loadBeverageTable();

                idBeverageTextField.setText("");
                nameBeverageTextField1.setText("");
                priceTextField.setText("");
                categoryIdTextField1.setText("");
            }
        });
    }

    public void loadBeverageTable() {
        table1.setModel(DbUtils.resultSetToTableModel(this.csc.getBeverageTabel()));
    }

    public void run() {
        this.setContentPane(panel);
        this.setTitle("Add Beverage Form");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        loadBeverageTable();
    }
}
