package HouseRental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class SeeProfile implements ActionListener {
 
    JFrame frame31;//creating object of first JFrame
    JLabel nameLabel;//creating object of JLabel
    JTextField nameTextField;//creating object of JTextfield
    JButton fetchButton;//creating object of JButton
    //JButton resetButton;//creating object of JButton
    
    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class
    int flag=0;
 
 
    SeeProfile() {
 
        frame31 = new JFrame();
        frame31.setBackground(Color.PINK);
        frame31.setBackground(new Color(250, 128, 114));
        frame31.setTitle("Search Profile by Name");//setting the title of first JFrame
        frame31.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation
        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints
        frame31.setSize(500, 300);//setting the size of first JFrame
        frame31.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
 
        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
 
      //Setting the property of JLabel and adding it to the first JFrame
        nameLabel = new JLabel("Enter Name");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame31.add(nameLabel, bagConstraints);
 
      //Setting the property of JTextfield and adding it to the first JFrame
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame31.add(nameTextField, bagConstraints);
 
      //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        fetchButton = new JButton("VIEW PROFILE");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame31.add(fetchButton, bagConstraints);
 
      //Setting the property of JButton(Reset Data) and adding it to the second JFrame
        //resetButton = new JButton("Reset Data");
        //bagConstraints.gridx = 1;
        //bagConstraints.gridy = 1;
        //frame31.add(resetButton, bagConstraints);
 
        //adding ActionListener to both buttons
        fetchButton.addActionListener(this);
        //resetButton.addActionListener(this);
 
 
        frame31.setVisible(true);//Setting the visibility of First JFrame
        frame31.validate();//Performing relayout of the First JFrame
 
 
    }
 
    public static void main(String[] args) {
        new SeeProfile();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if (e.getSource() == fetchButton) {
 
            String NAME = nameTextField.getText().toString();//getting text of username text field and storing it in a String variable
            frameSecond(NAME);//passing the text value to frameSecond method
 
        }
       // if (e.getSource() == resetButton) {
         //   nameTextField.setText("");//resetting the value of username text field
        //}
 
    }
 
 
    public void frameSecond(String NAME) {
    
     //setting the properties of second JFrame
        frame2 = new JFrame("Profile Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(1200, 700);
 
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("NAME");
        defaultTableModel.addColumn("GENDER");
        defaultTableModel.addColumn("AGE");
        defaultTableModel.addColumn("MOBILE");
        defaultTableModel.addColumn("eMAIL");
        defaultTableModel.addColumn("ADDRESS");
        defaultTableModel.addColumn("FATHER'sNAME");
        defaultTableModel.addColumn("DATEOFBIRTH");
        defaultTableModel.addColumn("OCCUPATION");
        defaultTableModel.addColumn("ANNUALINCOME");
        defaultTableModel.addColumn("QUALIFICATION");
        
        
 
 
 
 
        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:2777/onlinehouserental", "root", "Deepa9111");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from persons where NAME = '" + NAME  + "'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
 
 
            while (resultSet.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String name = resultSet.getString("NAME");
                String GENDER = resultSet.getString("GENDER");
                String AGE = resultSet.getString("AGE");
                String MOBILE = resultSet.getString("MOBILE");
                String eMAIL = resultSet.getString("eMAIL");
                String ADDRESS = resultSet.getString("ADDRESS");
                String FATHERNAME = resultSet.getString("FATHER'sNAME");
                String DATEOFBIRTH = resultSet.getString("DATEOFBIRTH");
                String OCCUPATION = resultSet.getString("OCCUPATION");
                String INCOME = resultSet.getString("ANNUALINCOME");
                String QUALIFICATION = resultSet.getString("QUALIFICATION");
                
                
                if (NAME.equalsIgnoreCase(name)) {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{name, GENDER, AGE, MOBILE, eMAIL, ADDRESS, FATHERNAME, DATEOFBIRTH, OCCUPATION, INCOME, QUALIFICATION});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();
                    break;
                }
 
            }
 
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such profile with name Found");//When invalid username is entered
            }
 
 
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 
 
    }
}