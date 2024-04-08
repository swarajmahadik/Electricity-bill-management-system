 package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {
    Choice loginASCho;
    TextField meterText, EmployerText, userNameText, nameText, passwordText;
    JButton create, back;

    Signup() {
        super("Signup Page");
        getContentPane().setBackground(new Color(168, 203, 255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30, 50, 125, 20);
        add(createAs);

        loginASCho = new Choice();
        loginASCho.add("Admin");
        loginASCho.add("Customer");
        loginASCho.setBounds(170, 50, 120, 20);
        add(loginASCho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30, 100, 125, 20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170, 100, 125, 20);
        meterText.setVisible(false);
        add(meterText);

        JLabel employerLabel = new JLabel("Employer ID");
        employerLabel.setBounds(30, 100, 125, 20);
        employerLabel.setVisible(true);
        add(employerLabel);

        EmployerText = new TextField();
        EmployerText.setBounds(170, 100, 125, 20);
        EmployerText.setVisible(true);
        add(EmployerText);

        JLabel userName = new JLabel("Username");
        userName.setBounds(30, 140, 125, 20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(170, 140, 125, 20);
        add(userNameText);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 180, 125, 20);
        add(nameLabel);

        nameText = new TextField("");
        nameText.setBounds(170, 180, 125, 20);
        add(nameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 220, 125, 20);
        add(passwordLabel);

        passwordText = new TextField();
        passwordText.setBounds(170, 220, 125, 20);
        add(passwordText);

        loginASCho.addItemListener(e -> {
            String user = loginASCho.getSelectedItem();
            if (user.equals("Customer")) {
                employerLabel.setVisible(false);
                nameText.setEditable(false);
                EmployerText.setVisible(false);
                meterNo.setVisible(true);
                meterText.setVisible(true);
            } else {
                employerLabel.setVisible(true);
                EmployerText.setVisible(true);
                meterNo.setVisible(false);
                meterText.setVisible(false);
            }
        });

        create = new JButton("Create");
        create.setBackground(new Color(66, 127, 219));
        create.setForeground(Color.black);
        create.setBounds(50, 285, 100, 25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(66, 127, 219));
        back.setForeground(Color.black);
        back.setBounds(180, 285, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyLabel = new JLabel(boyIcon2);
        boyLabel.setBounds(320, 30, 250, 250);
        add(boyLabel);

        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            String sloginAs = loginASCho.getSelectedItem();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeter = meterText.getText();

            try {
                database c = new database();
                String query;
                if (sloginAs.equals("Admin")) {
                    query = "INSERT INTO Signup VALUES('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + sloginAs + "')";
                } else {
                    query = "UPDATE Signup SET username = '" + susername + "', password = '" + spassword + "', usertype = '" + sloginAs + "' WHERE meter_no = '" + smeter + "'";
                }

                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created/Updated Successfully!");
                setVisible(false);
                new Login();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}