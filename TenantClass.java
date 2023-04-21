package HouseRental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TenantClass extends JFrame {

	private JPanel contentPane;
	private JTextField txTENANT;
	private JLabel lbWELCOME;
	private JPasswordField passwordField;
	private JTextField txCADDRESS;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenantClass frame2 = new TenantClass();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TenantClass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahul\\Pictures\\beautiful-house.jpg"));
		setTitle("TenantClass");
		setForeground(Color.RED);
		setFont(new Font("Arial Narrow", Font.BOLD, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1311, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TENANT = new JLabel("TENANT:");
		TENANT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TENANT.setForeground(Color.BLACK);
		TENANT.setBounds(683, 211, 161, 64);
		contentPane.add(TENANT);
		
		txTENANT = new JTextField();
		txTENANT.setForeground(Color.MAGENTA);
		txTENANT.setBounds(911, 221, 325, 47);
		contentPane.add(txTENANT);
		txTENANT.setColumns(10);
		
		JLabel TPASSWORD = new JLabel("TPASSWORD:");
		TPASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TPASSWORD.setForeground(Color.BLACK);
		TPASSWORD.setBounds(683, 321, 133, 64);
		contentPane.add(TPASSWORD);
		
		JButton btnButton = new JButton("VIEW HOUSES");
		btnButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userstr=txTENANT.getText();
				String addrstr=txCADDRESS.getText();
				if(!(userstr.isEmpty() || addrstr.isEmpty()))
				{
					ViewHouse frame1 = new ViewHouse();
					//frame1.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"YOUR USERNAME AND PASSWORD CAN'T BE EMPTY !!!","Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnButton.setForeground(new Color(0, 0, 0));
		btnButton.setBackground(Color.CYAN);
		btnButton.setBounds(997, 647, 216, 61);
		contentPane.add(btnButton);
		
		lbWELCOME = new JLabel("");
		lbWELCOME.setBounds(68, 282, 292, 35);
		contentPane.add(lbWELCOME);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(911, 333, 325, 42);
		contentPane.add(passwordField);
		
		JButton regbutton = new JButton("REGISTER");
		regbutton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		regbutton.setBackground(Color.CYAN);
		regbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== regbutton) {
					try {
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:2777/houserental","root","Deepa9111");
						PreparedStatement Pstatement=connection.prepareStatement("insert into tenant values(?,?,?)");
						Pstatement.setString(1,txTENANT.getText());
		                Pstatement.setString(2,passwordField.getText());
		                Pstatement.setString(3, txCADDRESS.getText());
		                String userstr=txTENANT.getText();
		                String caddstr=txCADDRESS.getText();
		               // Pstatement.executeUpdate();
		                if(!(userstr.isEmpty() || caddstr.isEmpty()))
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
		regbutton.setBounds(760, 647, 140, 61);
		contentPane.add(regbutton);
		
		JButton btnNewButton = new JButton("Click to enter the house that you expect");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userstr=txTENANT.getText();
				String addrstr=txCADDRESS.getText();
				if(!(userstr.isEmpty() || addrstr.isEmpty()))
				{
					House_excepted frame9 = new House_excepted();
					frame9.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"YOUR USERNAME AND PASSWORD CAN'T BE EMPTY !!!","Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(258, 660, 401, 35);
		contentPane.add(btnNewButton);
		
		JLabel CADDRESS = new JLabel("CURRENT ADDRESS");
		CADDRESS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		CADDRESS.setBounds(683, 498, 161, 35);
		contentPane.add(CADDRESS);
		
		txCADDRESS = new JTextField();
		txCADDRESS.setBounds(911, 454, 325, 148);
		contentPane.add(txCADDRESS);
		txCADDRESS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rahul\\Pictures\\images.png"));
		lblNewLabel.setBounds(24, 120, 582, 482);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1295, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TENANT  LOGIN");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(178, 5, 807, 71);
		panel.add(lblNewLabel_1);
	}
}
