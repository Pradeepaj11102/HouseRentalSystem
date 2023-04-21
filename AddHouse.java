package HouseRental;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AddHouse extends JFrame {

	private JPanel contentPane;
	private JTextField txRENT;
	private JTextField txDIRECTION;
	private JTextField txCATEGORY;
	private JTextField txBUSFacilities;
	private JTextField txWaterFacilities;
	private JTextField txElectricity;
	private JTextField txNumRooms;
	private JTextField txParkArea;
	private JTextField txLocation;
	private JTextField txGardening;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHouse frame3 = new AddHouse();
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddHouse() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rahul\\Pictures\\beautiful-house.jpg"));
		setTitle("ADD HOUSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1357, 765);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel COST = new JLabel("COST");
		COST.setFont(new Font("Times New Roman", Font.BOLD, 16));
		COST.setBounds(5, 118, 175, 50);
		contentPane.add(COST);
		
		txRENT = new JTextField();
		txRENT.setBounds(247, 132, 400, 25);
		contentPane.add(txRENT);
		txRENT.setColumns(10);
		
		JLabel DIRECTION = new JLabel("DIRECTION:");
		DIRECTION.setFont(new Font("Times New Roman", Font.BOLD, 16));
		DIRECTION.setBounds(5, 190, 175, 50);
		contentPane.add(DIRECTION);
		
		txDIRECTION = new JTextField();
		txDIRECTION.setBounds(247, 204, 400, 25);
		contentPane.add(txDIRECTION);
		txDIRECTION.setColumns(10);
		
		JLabel CATEGORY = new JLabel("CATEGORY:");
		CATEGORY.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CATEGORY.setBounds(5, 255, 175, 50);
		contentPane.add(CATEGORY);
		
		txCATEGORY = new JTextField();
		txCATEGORY.setBounds(247, 269, 400, 25);
		contentPane.add(txCATEGORY);
		txCATEGORY.setColumns(10);
		
		JLabel BUSFacilities = new JLabel("BUSFACILITIES:");
		BUSFacilities.setFont(new Font("Times New Roman", Font.BOLD, 15));
		BUSFacilities.setBounds(5, 314, 175, 50);
		contentPane.add(BUSFacilities);
		
		txBUSFacilities = new JTextField();
		txBUSFacilities.setBounds(247, 328, 400, 25);
		contentPane.add(txBUSFacilities);
		txBUSFacilities.setColumns(10);
		
		JLabel WaterFacilities = new JLabel("WATER FACILITIES:");
		WaterFacilities.setFont(new Font("Times New Roman", Font.BOLD, 15));
		WaterFacilities.setBounds(0, 376, 175, 50);
		contentPane.add(WaterFacilities);
		
		txWaterFacilities = new JTextField();
		txWaterFacilities.setBounds(247, 390, 400, 25);
		contentPane.add(txWaterFacilities);
		txWaterFacilities.setColumns(10);
		
		JLabel Electricity = new JLabel("ELECTRICITY:");
		Electricity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Electricity.setBounds(0, 437, 175, 50);
		contentPane.add(Electricity);
		
		txElectricity = new JTextField();
		txElectricity.setBounds(247, 451, 400, 25);
		contentPane.add(txElectricity);
		txElectricity.setColumns(10);
		
		JLabel NumRooms = new JLabel("NUMBEROF ROOMS:");
		NumRooms.setFont(new Font("Times New Roman", Font.BOLD, 15));
		NumRooms.setBounds(0, 500, 175, 50);
		contentPane.add(NumRooms);
		
		txNumRooms = new JTextField();
		txNumRooms.setBounds(247, 514, 400, 25);
		contentPane.add(txNumRooms);
		txNumRooms.setColumns(10);
		
		JLabel ParkArea = new JLabel("PARKING AREA:");
		ParkArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ParkArea.setBounds(5, 555, 175, 50);
		contentPane.add(ParkArea);
		
		txParkArea = new JTextField();
		txParkArea.setBounds(247, 569, 400, 25);
		contentPane.add(txParkArea);
		txParkArea.setColumns(10);
		
		JLabel Gardening = new JLabel("GARDENING:");
		Gardening.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Gardening.setBounds(5, 616, 175, 50);
		contentPane.add(Gardening);
		
		txLocation = new JTextField();
		txLocation.setBounds(247, 690, 400, 25);
		contentPane.add(txLocation);
		txLocation.setColumns(10);
		
		JButton registerButton  = new JButton("ADD MY HOUSE");
		registerButton.setBackground(Color.CYAN);
		registerButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== registerButton) {
					try {
						
						String mailstr=txRENT.getText();
						String namestr=txLocation.getText();
						String ageestr=txDIRECTION.getText();
						String mobistr=txCATEGORY.getText();
						String addrstr=txBUSFacilities.getText();
						String fnamstr=txWaterFacilities.getText();
						String dobbstr=txElectricity.getText();
						String occustr=txNumRooms.getText();
						String annustr=txParkArea.getText();
						String qualstr=txGardening.getText();
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:2777/houserental","root","Deepa9111");
						PreparedStatement Pstatement=connection.prepareStatement("insert into house values(?,?,?,?,?,?,?,?,?,?)");
						Pstatement.setString(1,txRENT.getText());
						Pstatement.setString(2,txLocation.getText());
		                Pstatement.setString(3,txDIRECTION.getText());
		                Pstatement.setString(4,txCATEGORY.getText());
		                Pstatement.setString(5,txBUSFacilities.getText());
		                Pstatement.setString(6,txWaterFacilities.getText());
		                Pstatement.setString(7,txElectricity.getText());
		                Pstatement.setString(8,txNumRooms.getText());
						Pstatement.setString(9,txParkArea.getText());
		                Pstatement.setString(10,txGardening.getText());
		                if(!(namestr.isEmpty() || mailstr.isEmpty() || ageestr.isEmpty() || mobistr.isEmpty() || addrstr.isEmpty() || fnamstr.isEmpty() ||dobbstr.isEmpty() || occustr.isEmpty() || annustr.isEmpty() || qualstr.isEmpty() ))
		                {
		                	Pstatement.executeUpdate();
		                }
		                else
		                {
		                	JOptionPane.showMessageDialog(null,"ONE OR MORE FIELD IS EMPTY","Failed",JOptionPane.ERROR_MESSAGE);
		                }
					} catch (SQLException e1) {
		                //e1.printStackTrace();
		            }
				}
			}
		});
		
		registerButton.setBounds(812, 651, 308, 44);
		contentPane.add(registerButton);
		
		txGardening = new JTextField();
		txGardening.setColumns(10);
		txGardening.setBounds(247, 630, 400, 25);
		contentPane.add(txGardening);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLocation.setBounds(5, 665, 165, 50);
		contentPane.add(lblLocation);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1341, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("ADD HOUSE AND ITS AMENITIES");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 65));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(77, 11, 1155, 85);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rahul\\Pictures\\home-for-rent-icon-beautiful-design-and-fully-editable-vector-for-commercial-print-media-web-or-any-type-of-design-projects-2C6W2T7.jpg"));
		lblNewLabel_1.setBounds(696, 170, 635, 439);
		contentPane.add(lblNewLabel_1);
	}
}