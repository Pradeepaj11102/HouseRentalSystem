package HouseRental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class TenantSignin implements ActionListener {
 
    JFrame frame33;//creating object of first JFrame
    JLabel nameLabel;//creating object of JLabel
    JTextField nameTextField;//creating object of JTextfield
    JButton fetchButton;//creating object of JButton
   // JButton resetButton;//creating object of JButton
    
    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class
    int flag=0;
 
 
    TenantSignin() {
 
        frame33 = new JFrame();
        frame33.setTitle("Search TENANT");//setting the title of first JFrame
        frame33.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation
        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints
        frame33.setSize(500, 300);//setting the size of first JFrame
        frame33.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
 
        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
 
      //Setting the property of JLabel and adding it to the first JFrame
        nameLabel = new JLabel("Enter Password");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame33.add(nameLabel, bagConstraints);
 
      //Setting the property of JTextfield and adding it to the first JFrame
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame33.add(nameTextField, bagConstraints);
 
      //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame33.add(fetchButton, bagConstraints);
 
      //Setting the property of JButton(Reset Data) and adding it to the second JFrame
        //resetButton = new JButton("Reset Data");
        //bagConstraints.gridx = 1;
        //bagConstraints.gridy = 1;
      //  frame33.add(resetButton, bagConstraints);
 
        //adding ActionListener to both buttons
        fetchButton.addActionListener(this);
       // resetButton.addActionListener(this);
 
 
        frame33.setVisible(true);//Setting the visibility of First JFrame
        frame33.validate();//Performing relayout of the First JFrame
 
 
    }
 
    public static void main(String[] args) {
        new TenantSignin();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if (e.getSource() == fetchButton) {
 
            String Password = nameTextField.getText().toString();//getting text of username text field and storing it in a String variable
            frameSecond(Password);//passing the text value to frameSecond method
 
        }
        //if (e.getSource() == resetButton) {
          //  nameTextField.setText("");//resetting the value of username text field
       // }
 
    }
 
 
    public void frameSecond(String Password) {
    
     //setting the properties of second JFrame
        frame2 = new JFrame("TENANT Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(900, 700);
 
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(700, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("USERNAME");
        defaultTableModel.addColumn("PASSWORD");
        defaultTableModel.addColumn("CURRENT ADDRESS");
 
 
 
 
        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:2777/houserental", "root", "Deepa9111");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from tenant where password = '" + Password + "'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
 
 
            while (resultSet.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String name = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String add = resultSet.getString("CURRENT ADDRESS");
                if (Password.equalsIgnoreCase(name)) {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{name, pass, add});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();
                    break;
                }
 
            }
 
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such Username Found");//When invalid username is entered
            }
 
 
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 
 
    }
}

