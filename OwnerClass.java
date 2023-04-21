package HouseRental;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.callback.UsernameCallback;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class OwnerClass extends JFrame {

	private JPanel contentPane;
	private JTextField txUSERNAME;
	private JButton regbutton;
	private JPasswordField txPASSWORD;
	private JTextField txADDRESS;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerClass frame15 = new OwnerClass();
					frame15.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OwnerClass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahul\\Pictures\\beautiful-house.jpg"));
		setTitle("OwnerClass");
		setForeground(Color.RED);
		setFont(new Font("Arial Narrow", Font.BOLD, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1364, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel USERNAME = new JLabel("USERNAME:");
		USERNAME.setFont(new Font("Times New Roman", Font.BOLD, 16));
		USERNAME.setForeground(Color.BLACK);
		USERNAME.setBounds(825, 135, 161, 64);
		contentPane.add(USERNAME);
		
		txUSERNAME = new JTextField();
		txUSERNAME.setForeground(Color.MAGENTA);
		txUSERNAME.setBounds(1024, 145, 309, 47);
		contentPane.add(txUSERNAME);
		txUSERNAME.setColumns(10);
		
		JLabel PASSWORD = new JLabel("PASSWORD:");
		PASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		PASSWORD.setForeground(Color.BLACK);
		PASSWORD.setBounds(825, 249, 133, 64);
		contentPane.add(PASSWORD);
		
		JButton btnButton = new JButton("\"CLICK HERE\" to enter your house details...");
		btnButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userstr=txUSERNAME.getText();
				String addrstr=txADDRESS.getText();
				if(!(userstr.isEmpty() || addrstr.isEmpty()))
				{
				  AddHouse frame3 = new AddHouse();
				  frame3.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"YOUR USERNAME AND PASSWORD CAN'T BE EMPTY !!!","Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnButton.setForeground(new Color(128, 0, 0));
		btnButton.setBackground(Color.CYAN);
		btnButton.setBounds(199, 590, 517, 61);
		contentPane.add(btnButton);
		
		regbutton = new JButton("Register");
		regbutton.setBackground(Color.CYAN);
		regbutton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		regbutton.setForeground(new Color(128, 0, 0));
		regbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()== regbutton) {
					try {
						String userstr=txUSERNAME.getText();
						String addrstr=txADDRESS.getText();
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:2777/houserental","root","Deepa9111");
						PreparedStatement Pstatement=connection.prepareStatement("insert into owner values(?,?,?)");
						 Pstatement.setString(1,txUSERNAME.getText());
			                Pstatement.setString(2,txPASSWORD.getText());
			                Pstatement.setString(3, txADDRESS.getText());
			                //Pstatement.executeUpdate();
			                if(!(userstr.isEmpty() || addrstr.isEmpty()))
			                {
			                	Pstatement.executeUpdate();
			                }
			                else
			                {
			                	JOptionPane.showMessageDialog(null,"ONE OR MORE FIELD IS EMPTY","Failed",JOptionPane.ERROR_MESSAGE);
			                }
			                
					}catch (SQLException e1) {
		                //e1.printStackTrace();
		            }
				}
			}
		});
		regbutton.setBounds(814, 590, 144, 61);
		contentPane.add(regbutton);
		
		txPASSWORD = new JPasswordField();
		txPASSWORD.setBounds(1024, 249, 309, 51);
		contentPane.add(txPASSWORD);
		
		JLabel ADDRESS = new JLabel("ADDRESS");
		ADDRESS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ADDRESS.setBounds(825, 423, 133, 35);
		contentPane.add(ADDRESS);
		
		txADDRESS = new JTextField();
		txADDRESS.setBounds(1024, 359, 309, 164);
		contentPane.add(txADDRESS);
		txADDRESS.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rahul\\Pictures\\IMG_20211222_221815.jpg"));
		lblNewLabel.setBounds(59, 112, 694, 418);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1348, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("OWNER  LOGIN");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_1.setBounds(147, 0, 978, 90);
		panel.add(lblNewLabel_1);
	}
}
