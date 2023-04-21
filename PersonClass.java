package HouseRental;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class PersonClass extends JFrame {

	private JPanel contentPane;
	private JLabel lbWelcome;
	private JTextField txNAME;
	private JTextField txAGE;
	private JTextField txMOBILE;
	private JTextField txeMAIL;
	private JTextField txADDRESS;
	private JTextField txFNAME;
	private JTextField txDOB;
	private JTextField txOCCUPATION;
	private JTextField txAnnual;
	private JTextField txQUALIFICATION;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonClass frame10 = new PersonClass();
					frame10.setVisible(true);
					//frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonClass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahul\\Pictures\\beautiful-house.jpg"));
		setForeground(new Color(250, 128, 114));
		setBackground(new Color(250, 128, 114));
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		setTitle("PERSONAL INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1320, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NAME = new JLabel("NAME:");
		NAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
		NAME.setBounds(10, 130, 148, 14);
		contentPane.add(NAME);
		
		txNAME = new JTextField();
		txNAME.setBounds(168, 121, 336, 35);
		contentPane.add(txNAME);
		txNAME.setColumns(10);
		
		JLabel AGE = new JLabel("AGE:");
		AGE.setFont(new Font("Times New Roman", Font.BOLD, 15));
		AGE.setBounds(10, 196, 148, 14);
		contentPane.add(AGE);
		
		txAGE = new JTextField();
		txAGE.setBounds(168, 185, 336, 38);
		contentPane.add(txAGE);
		txAGE.setColumns(10);
		
		JLabel GENDER = new JLabel("GENDER:");
		GENDER.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GENDER.setBounds(10, 268, 148, 14);
		contentPane.add(GENDER);
		
		JLabel MOBILE = new JLabel("MOBILE:");
		MOBILE.setFont(new Font("Times New Roman", Font.BOLD, 15));
		MOBILE.setBounds(10, 343, 148, 14);
		contentPane.add(MOBILE);
		
		txMOBILE = new JTextField();
		txMOBILE.setBounds(168, 332, 336, 38);
		contentPane.add(txMOBILE);
		txMOBILE.setColumns(10);
		
		JLabel eMAIL = new JLabel("eMAIL:");
		eMAIL.setFont(new Font("Times New Roman", Font.BOLD, 15));
		eMAIL.setBounds(10, 431, 148, 14);
		contentPane.add(eMAIL);
		
		JLabel ADDRESS = new JLabel(" ADDRESS:");
		ADDRESS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ADDRESS.setBounds(10, 527, 142, 29);
		contentPane.add(ADDRESS);
		
		txeMAIL = new JTextField();
		txeMAIL.setBounds(168, 420, 336, 38);
		contentPane.add(txeMAIL);
		txeMAIL.setColumns(10);
		
		txADDRESS = new JTextField();
		txADDRESS.setBounds(168, 496, 336, 121);
		contentPane.add(txADDRESS);
		txADDRESS.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text= txNAME.getText();
				lbWelcome.setText("Hello!!!  " + text + "  Welcome to HOUSE RENTAL MANAGEMENT");
			}
		});
		btnOK.setForeground(new Color(139, 0, 0));
		btnOK.setBackground(Color.CYAN);
		btnOK.setBounds(633, 576, 233, 58);
		contentPane.add(btnOK);
		
		JButton btnButton1 = new JButton("\"CLICK HERE\" if you are a Owner");
		btnButton1.setBackground(Color.CYAN);
		btnButton1.setForeground(new Color(128, 0, 0));
		btnButton1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mailstr=txeMAIL.getText();
				String namestr=txNAME.getText();
				String ageestr=txAGE.getText();
				String mobistr=txMOBILE.getText();
				String addrstr=txADDRESS.getText();
				String fnamstr=txFNAME.getText();
				String dobbstr=txDOB.getText();
				String occustr=txOCCUPATION.getText();
				String annustr=txAnnual.getText();
				String qualstr=txQUALIFICATION.getText();
				if(!(namestr.isEmpty() || mailstr.isEmpty() || ageestr.isEmpty() || mobistr.isEmpty() || addrstr.isEmpty() || fnamstr.isEmpty() ||dobbstr.isEmpty() || occustr.isEmpty() || annustr.isEmpty() || qualstr.isEmpty() ))
				{
					OwnerClass frame15 = new OwnerClass();
					frame15.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Your Profile is incomplete !!!","Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnButton1.setBounds(10, 645, 554, 58);
		contentPane.add(btnButton1);
		
		JButton btnButton2 = new JButton("\"CLICK HERE\" if you are a tenant");
		btnButton2.setBackground(Color.CYAN);
		btnButton2.setForeground(new Color(128, 0, 0));
		btnButton2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mailstr=txeMAIL.getText();
				String namestr=txNAME.getText();
				String ageestr=txAGE.getText();
				String mobistr=txMOBILE.getText();
				String addrstr=txADDRESS.getText();
				String fnamstr=txFNAME.getText();
				String dobbstr=txDOB.getText();
				String occustr=txOCCUPATION.getText();
				String annustr=txAnnual.getText();
				String qualstr=txQUALIFICATION.getText();
				if(!(namestr.isEmpty() || mailstr.isEmpty() || ageestr.isEmpty() || mobistr.isEmpty() || addrstr.isEmpty() || fnamstr.isEmpty() ||dobbstr.isEmpty() || occustr.isEmpty() || annustr.isEmpty() || qualstr.isEmpty() ))
				{
					TenantClass frame2 = new TenantClass();
					frame2.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Your Profile is incomplete !!!","Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnButton2.setBounds(729, 645, 554, 58);
		contentPane.add(btnButton2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		comboBox.setBounds(168, 261, 336, 29);
		contentPane.add(comboBox);
		
		JButton registerbutton = new JButton("Register");
		registerbutton.setBackground(Color.CYAN);
		registerbutton.setForeground(new Color(139, 0, 0));
		registerbutton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 {
					if(e.getSource()== registerbutton) {
					try {
						String mailstr=txeMAIL.getText();
						String namestr=txNAME.getText();
						String ageestr=txAGE.getText();
						String mobistr=txMOBILE.getText();
						String addrstr=txADDRESS.getText();
						String fnamstr=txFNAME.getText();
						String dobbstr=txDOB.getText();
						String occustr=txOCCUPATION.getText();
						String annustr=txAnnual.getText();
						String qualstr=txQUALIFICATION.getText();
						
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:2777/onlinehouserental","root","Deepa9111");
						PreparedStatement Pstatement=connection.prepareStatement("insert into persons values(?,?,?,?,?,?,?,?,?,?,?)");
		                //Specifying the values of it's parameter
		                Pstatement.setString(1,txNAME.getText());
		                Pstatement.setString(2,comboBox.getSelectedItem().toString());
		                Pstatement.setString(3,txAGE.getText());
		                Pstatement.setString(4,txMOBILE.getText());
		                Pstatement.setString(5,txeMAIL.getText());
		                Pstatement.setString(6,txADDRESS.getText());
		                Pstatement.setString(7,txFNAME.getText());
		                Pstatement.setString(8,txDOB.getText());
		                Pstatement.setString(9,txOCCUPATION.getText());
		                Pstatement.setString(10,txAnnual.getText());
		                Pstatement.setString(11,txQUALIFICATION.getText());
		                String str3=txDOB.getText();
		                String str2=txMOBILE.getText();
	                    String str1=txeMAIL.getText();
	                    if(!(namestr.isEmpty() || mailstr.isEmpty() || ageestr.isEmpty() || mobistr.isEmpty() || addrstr.isEmpty() || fnamstr.isEmpty() ||dobbstr.isEmpty() || occustr.isEmpty() || annustr.isEmpty() || qualstr.isEmpty() ))
	                    {
	                    if (str2.length()==10) 
	                    {
	                        if(str1.contains("@gmail.com"))
	                        {
	                          if(str3.contains("01-11-2002"))
	                          {	
	                        	  Pstatement.executeUpdate();
	                              JOptionPane.showMessageDialog(null,"REGISTERED SUCCESSFULL");
	                              clearField();
	                          }
	                          else
	                          {
	                        	  JOptionPane.showMessageDialog(null,"Date of birth is Invalid","Failed",JOptionPane.ERROR_MESSAGE);
	                          }
	                        }
	                        else
	                        {
	                            JOptionPane.showMessageDialog(null,"ENTER A VALID EMAIL ID","Failed",JOptionPane.ERROR_MESSAGE);
	                        }
	                   
	                    }   
	                    else
	                    {
	                        JOptionPane.showMessageDialog(null,"ENTER A VALID PHONE NUMBER","Failed",JOptionPane.ERROR_MESSAGE);
	                        
	                    }
	                    }
	                    else
	                    {
	                            JOptionPane.showMessageDialog(null,"ONE OR MORE FIELD IS EMPTY","Failed",JOptionPane.ERROR_MESSAGE);
	                    }
		                //JOptionPane.showMessageDialog(null,"REGISTERED SUCCESSFULL");
					} catch (SQLException e1) {
		                //e1.printStackTrace();
		            }
					 }
				}
				
				
			}

			private void clearField() {
				// TODO Auto-generated method stub
				txNAME.setText(null);
				txAGE.setText(null);
				txMOBILE.setText(null);
				txeMAIL.setText(null);
				txADDRESS.setText(null);
				txFNAME.setText(null);
				txDOB.setText(null);
				txOCCUPATION.setText(null);
				txAnnual.setText(null);
				txQUALIFICATION.setText(null);
				
			}
		});
		registerbutton.setBounds(1047, 574, 233, 58);
		contentPane.add(registerbutton);
		
		JLabel FNAME = new JLabel("FATHER's NAME");
		FNAME.setFont(new Font("Times New Roman", Font.BOLD, 15));
		FNAME.setBounds(588, 118, 168, 38);
		contentPane.add(FNAME);
		
		txFNAME = new JTextField();
		txFNAME.setBounds(836, 119, 347, 38);
		contentPane.add(txFNAME);
		txFNAME.setColumns(10);
		
		JLabel DOB = new JLabel("DATE OF BIRTH"
				+ "(dd-mm-yyyy)");
		DOB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		DOB.setBounds(588, 184, 221, 38);
		contentPane.add(DOB);
		
		txDOB = new JTextField();
		txDOB.setBounds(836, 185, 347, 38);
		contentPane.add(txDOB);
		txDOB.setColumns(10);
		
		JLabel OCCUPATION = new JLabel("OCCUPATION");
		OCCUPATION.setFont(new Font("Times New Roman", Font.BOLD, 15));
		OCCUPATION.setBounds(588, 261, 168, 29);
		contentPane.add(OCCUPATION);
		
		txOCCUPATION = new JTextField();
		txOCCUPATION.setBounds(836, 257, 347, 38);
		contentPane.add(txOCCUPATION);
		txOCCUPATION.setColumns(10);
		
		JLabel AINCOME = new JLabel("ANNUAL INCOME");
		AINCOME.setFont(new Font("Times New Roman", Font.BOLD, 15));
		AINCOME.setBounds(588, 331, 168, 38);
		contentPane.add(AINCOME);
		
		JLabel QUALIFICATION = new JLabel("QUALIFICATION");
		QUALIFICATION.setFont(new Font("Times New Roman", Font.BOLD, 16));
		QUALIFICATION.setBounds(588, 419, 168, 38);
		contentPane.add(QUALIFICATION);
		
		txAnnual = new JTextField();
		txAnnual.setBounds(836, 328, 347, 46);
		contentPane.add(txAnnual);
		txAnnual.setColumns(10);
		
		txQUALIFICATION = new JTextField();
		txQUALIFICATION.setBounds(836, 416, 347, 46);
		contentPane.add(txQUALIFICATION);
		txQUALIFICATION.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1304, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONAL INFORMATION");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel.setBounds(36, 11, 1199, 88);
		panel.add(lblNewLabel);
		
		lbWelcome = new JLabel("");
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbWelcome.setBounds(564, 505, 582, 51);
		contentPane.add(lbWelcome);
		
	}
}
