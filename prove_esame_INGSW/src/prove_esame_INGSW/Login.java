package prove_esame_INGSW;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.Alert;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private alertClass alertClass = new alertClass();
	private JTextField textField;
	private controllore thecontroller;

	
	
	
	public Login(controllore c) {
		thecontroller=c;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 779);
		contentPane = new JPanel();
	
	
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(452, 130, 100, 16);
		lblUsername.setHorizontalAlignment(JLabel.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		contentPane.add(lblUsername);
		JLabel BENVENUTO = new JLabel("BENVENUTO");
		BENVENUTO.setBounds(500, 0, 300, 90);
		BENVENUTO.setHorizontalAlignment(JLabel.CENTER);
		BENVENUTO.setVerticalAlignment(JLabel.CENTER);
		BENVENUTO.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(BENVENUTO);
		
		JTextField text_username = new JTextField();
		text_username.setBounds(600, 127, 188, 30);
		text_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_username.setColumns(10);
		text_username.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_username);
		
		
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setBounds(452, 250, 100, 16);
		lbl_password.setHorizontalAlignment(JLabel.CENTER);
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lbl_password);
		
		JTextField text_password = new JTextField();
		text_password.setBounds(600, 247, 188, 30);
		text_password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_password.setColumns(10);
		text_password.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_password);

		
		
		JButton btn_accedi = new JButton("ACCEDI");
		btn_accedi.setBounds(550, 420, 150, 50);
		btn_accedi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_accedi.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(btn_accedi);
		btn_accedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_username.getText().equals("dio") && text_password.getText().equals("3333")) {
					dispose();
					HomePage homePage= new HomePage(c);
					homePage.setVisible(true);
				}
				else if(text_username.getText().equals("admin")&& text_password.getText().equals("admin")) {
					dispose();
					HomePageAdmin homePageAdmin = new HomePageAdmin(c);
					homePageAdmin.setVisible(true);
				}
				else {
					alertClass.alert();
				}
			}
		});
	contentPane.revalidate();
	contentPane.repaint();
	}


}
