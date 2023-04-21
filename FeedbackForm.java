package HouseRental;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FeedbackForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedbackForm frame6 = new FeedbackForm();
					frame6.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FeedbackForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahul\\Pictures\\beautiful-house.jpg"));
		setTitle("FEEDBACK FORM ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1107, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1091, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TENANT's FEEDBACK FORM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 65));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 876, 70);
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(313, 206, 741, 343);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your queries");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(213, 150, 288, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()== btnNewButton) {
					try {
						String areastr=textArea.getText();
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:2777/houserental","root","Deepa9111");
						PreparedStatement Pstatement=connection.prepareStatement("insert into feedback values(?)");
						Pstatement.setString(1,textArea.getText());
		                //Pstatement.executeUpdate();
		                if(!(areastr.isEmpty()))
		                {
		                	Pstatement.executeUpdate();
		                }
		                else
		                {
		                	JOptionPane.showMessageDialog(null,"Your Quries can't be empty !!!","Failed",JOptionPane.ERROR_MESSAGE);
		                }
					}catch (SQLException e1) {
		                //e1.printStackTrace();
		            }
				}
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(509, 583, 169, 47);
		contentPane.add(btnNewButton);
	}
}
