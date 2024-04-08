package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class generate_bill extends JFrame implements ActionListener {
    Choice searchmonthcho;
    String meter;
    JTextArea area;
    JButton bill;

    generate_bill(String meter) {
        this.meter = meter;
        setSize(600, 700);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill");
        heading.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel meter_no = new JLabel("Meter Number: " + meter);

        searchmonthcho = new Choice();
        searchmonthcho.add("January");
        searchmonthcho.add("February");
        searchmonthcho.add("March");
        searchmonthcho.add("April");
        searchmonthcho.add("May");
        searchmonthcho.add("June");
        searchmonthcho.add("July");
        searchmonthcho.add("August");
        searchmonthcho.add("September");
        searchmonthcho.add("October");
        searchmonthcho.add("November");
        searchmonthcho.add("December");

        area = new JTextArea(30, 40);
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane pane = new JScrollPane(area);
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        panel.add(heading);
        panel.add(meter_no);
        panel.add(new JLabel("Select Month:"));
        panel.add(searchmonthcho);
        panel.add(bill);
        add(panel, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            database c = new database();
            String smonth = searchmonthcho.getSelectedItem();
            area.setText("\nPower Limited\nElectricity Bill For Month of " + smonth + ", 2023\n\n");

            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no ='" + meter + "'");
            if (resultSet.next()) {
                area.append("\nCustomer Name        : " + resultSet.getString("name"));
                area.append("\nCustomer Meter Number: " + resultSet.getString("meter_no"));
                area.append("\nCustomer Address     : " + resultSet.getString("address"));
                area.append("\nCustomer City        : " + resultSet.getString("city"));
                area.append("\nCustomer State       : " + resultSet.getString("state"));
                area.append("\nCustomer Email       : " + resultSet.getString("email"));
                area.append("\nCustomer Phone Number: " + resultSet.getString("phone_no"));
            }

            resultSet = c.statement.executeQuery("select * from meter_info where meter_number ='" + meter + "'");
            if (resultSet.next()) {
                area.append("\nCustomer Meter Location: " + resultSet.getString("meter_location"));
                area.append("\nCustomer Meter Type    : " + resultSet.getString("meter_type"));
                area.append("\nCustomer Phase Code    : " + resultSet.getString("phase_code"));
                area.append("\nCustomer Bill Type     : " + resultSet.getString("bill_type"));
                area.append("\nCustomer Days          : " + resultSet.getString("Days"));
            }

            resultSet = c.statement.executeQuery("select * from tax");
            if (resultSet.next()) {
                area.append("\nCost Per Unit    : " + resultSet.getString("cost_per_unit"));
                area.append("\nMeter Rent       : " + resultSet.getString("meter_rent"));
                area.append("\nService Charge   : " + resultSet.getString("service_charge"));
                area.append("\nService Tax      : " + resultSet.getString("service_tax"));
                area.append("\nSwacch Bharat    : " + resultSet.getString("swacch_bharat"));
                area.append("\nFixed Tax        : " + resultSet.getString("fixed_tax"));
            }

            resultSet = c.statement.executeQuery("select * from bill where meter_no = '" + meter + "' and month = '" + searchmonthcho.getSelectedItem() + "'");
            if (resultSet.next()) {
                area.append("\nCurrent Month      : " + resultSet.getString("month"));
                area.append("\nUnits Consumed     : " + resultSet.getString("unit"));
                area.append("\nTotal Charges      : " + resultSet.getString("total_bill"));
                area.append("\nTotal Payable      : " + resultSet.getString("total_bill"));
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new generate_bill("");
    }
}
