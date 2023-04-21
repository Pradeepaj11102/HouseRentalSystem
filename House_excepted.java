package HouseRental;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class House_excepted extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					House_excepted frame9 = new House_excepted();
					frame9.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public House_excepted() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahul\\Pictures\\beautiful-house.jpg"));
		setTitle("EXCEPTED HOUSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1367, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COST");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(762, 104, 166, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(991, 105, 336, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NUMBER OF ROOMS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(18, 502, 166, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SQUARE FEET OF EACH ROOM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(762, 371, 186, 37);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 503, 258, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(991, 372, 336, 37);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PARKING (CAR/BIKE)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(18, 558, 186, 37);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PARK AREA FOR BIKE", "PARK AREA FOR CAR", "PARK AREA FOR BOTH"}));
		comboBox.setBounds(205, 561, 258, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("GARDENING");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(18, 616, 186, 37);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"GARDENING IN FRONT", "GARDENING IN SIDEWAYS", "GARDENING IN BACK", "NOT NEEDED"}));
		comboBox_1.setBounds(205, 619, 258, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("NUMBER OF HOUSES NEARBY");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(762, 173, 212, 37);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "NO HOUSES"}));
		comboBox_2.setBounds(991, 173, 336, 37);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_6 = new JLabel("EDUCATIONAL INSTITUTIONS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(762, 243, 212, 37);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"SCHOOLS", "COLLEGES", "UNIVERSITIES", "ALL"}));
		comboBox_3.setBounds(991, 243, 336, 37);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("PUBLIC PLACES NEARBY");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_7.setBounds(762, 313, 212, 37);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"PARK", "PLAY GROUND", "MALL", "HOTEL", "ALL"}));
		comboBox_4.setBounds(991, 313, 336, 37);
		contentPane.add(comboBox_4);
		
		JLabel lblNewLabel_8 = new JLabel("CATEGORY");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_8.setBounds(772, 435, 212, 37);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("SQUARE FEET OF HOUSE");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_9.setBounds(772, 502, 176, 37);
		contentPane.add(lblNewLabel_9);
		
		textField_3 = new JTextField();
		textField_3.setBounds(991, 503, 336, 37);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"FAMILY", "SINGLE (GIRLS)", "SINGLE (BOYS)"}));
		comboBox_5.setBounds(991, 435, 336, 37);
		contentPane.add(comboBox_5);
		
		JLabel lblNewLabel_10 = new JLabel("BUS FACILITIES");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_10.setBounds(769, 558, 212, 37);
		contentPane.add(lblNewLabel_10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(991, 558, 336, 37);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("ELECTRICITY");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_11.setBounds(769, 616, 212, 37);
		contentPane.add(lblNewLabel_11);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Current with UPS", "Current without UPS"}));
		comboBox_6.setBounds(991, 610, 336, 48);
		contentPane.add(comboBox_6);
		
		JButton btnNewButton = new JButton("Fill Feedback");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FeedbackForm frame6 = new FeedbackForm();
				frame6.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(777, 674, 212, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnNewButton_1) {
					try{
						String mailstr=textField.getText();
						String namestr=textField_1.getText();
						String ageestr=textField_2.getText();
						String mobistr=textField_3.getText();
						String addrstr=textField_4.getText();
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:2777/houserental","root","Deepa9111");
						PreparedStatement Pstatement=connection.prepareStatement("insert into exceptedhouse values(?,?,?,?,?,?,?,?,?,?,?,?)");
						Pstatement.setString(1,textField.getText());
		                Pstatement.setString(2,textField_1.getText());
		                Pstatement.setString(3,textField_2.getText());
		                Pstatement.setString(4,comboBox.getSelectedItem().toString());
		                Pstatement.setString(5,comboBox_1.getSelectedItem().toString());
		                Pstatement.setString(6,comboBox_2.getSelectedItem().toString());
		                Pstatement.setString(7,comboBox_3.getSelectedItem().toString());
		                Pstatement.setString(8,comboBox_4.getSelectedItem().toString());
		                Pstatement.setString(9,textField_3.getText());
		                Pstatement.setString(10,comboBox_5.getSelectedItem().toString());
		                Pstatement.setString(11,textField_4.getText());
		                Pstatement.setString(12,comboBox_6.getSelectedItem().toString());
		                //Pstatement.executeUpdate();
		                if(!(mailstr.isEmpty() || namestr.isEmpty() || ageestr.isEmpty() || mobistr.isEmpty() || addrstr.isEmpty()))
		                {
		                	Pstatement.executeUpdate();
		                }
		                else
		                {
		                	JOptionPane.showMessageDialog(null,"ONE OR MORE FIELD IS EMPTY","Failed",JOptionPane.ERROR_MESSAGE);
		                }
					}catch (SQLException e1) {
		                e1.printStackTrace();
		            }
				}
				
				
			}
		});
		btnNewButton_1.setBounds(205, 674, 176, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Rahul\\Pictures\\Buy-or-Rent-2-Houses-KCM.jpg"));
		lblNewLabel_12.setBounds(0, 127, 610, 330);
		contentPane.add(lblNewLabel_12);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1351, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("EXPECTED HOUSE AND AMENITIES");
		lblNewLabel_13.setForeground(new Color(139, 0, 0));
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 65));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(44, 11, 1256, 63);
		panel.add(lblNewLabel_13);
	}
}
