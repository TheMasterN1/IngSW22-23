package prove_esame_INGSW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class inserimentoDipendenti extends JFrame {
	private JPanel contentPane;
	private controllore thecontroller;
	
	public inserimentoDipendenti(controllore c) {
		thecontroller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		JLabel lbl_nome= new JLabel("Nome");
		lbl_nome.setBounds(250, 0, 100, 90);
		lbl_nome.setHorizontalAlignment(JLabel.CENTER);
		lbl_nome.setVerticalAlignment(JLabel.CENTER);
		lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_nome);
		
		JTextField text_nome = new JTextField();
		text_nome.setBounds(500, 30, 188, 30);
		text_nome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_nome.setColumns(10);
		text_nome.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_nome);
		
		JLabel lbl_cognome = new JLabel("Cognome");
		lbl_cognome.setBounds(200, 100, 200, 90);
		lbl_cognome.setHorizontalAlignment(JLabel.CENTER);
		lbl_cognome.setVerticalAlignment(JLabel.CENTER);
		lbl_cognome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_cognome);
		
		JTextField text_cognome = new JTextField();
		text_cognome.setBounds(500, 130, 188, 30);
		text_cognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_cognome.setColumns(10);
		text_cognome.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_cognome);
		
		
		JLabel lbl_impegno = new JLabel("Impegno");
		lbl_impegno.setBounds(200, 200, 200, 90);
		lbl_impegno.setHorizontalAlignment(JLabel.CENTER);
		lbl_impegno.setVerticalAlignment(JLabel.CENTER);
		lbl_impegno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_impegno);
		
		
		JTextField text_impegno = new JTextField();
		text_impegno.setBounds(500, 230, 188, 30);
		text_impegno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_impegno.setColumns(10);
		text_impegno.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_impegno);
		
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(200, 300, 200, 90);
		lbl_username.setHorizontalAlignment(JLabel.CENTER);
		lbl_username.setVerticalAlignment(JLabel.CENTER);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_username);
		
		
		JTextField text_username = new JTextField();
		text_username.setBounds(500, 330, 188, 30);
		text_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_username.setColumns(10);
		text_username.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setBounds(200, 400, 200, 90);
		lbl_password.setHorizontalAlignment(JLabel.CENTER);
		lbl_password.setVerticalAlignment(JLabel.CENTER);
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_password);
		
		
		JTextField text_password = new JTextField();
		text_password.setBounds(500, 430, 188, 30);
		text_password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_password.setColumns(10);
		text_password.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_password);
		
		
		JButton btn_salva = new JButton("SALVA");
		btn_salva.setBounds(450, 520, 150, 50);
		btn_salva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_salva.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(btn_salva);
		
		JButton btn_indietro = new JButton("BACK");
		btn_indietro.setBounds(900,0,100,50);
		btn_indietro.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_indietro.setHorizontalAlignment(JLabel.CENTER);
		btn_indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePageAdmin homePageAdmin = new HomePageAdmin(c);
				homePageAdmin.setVisible(true);
			}
		});
		
		if(HomePage.lingua==1) {
			lbl_nome.setText("NOME");
			lbl_cognome.setText("COGNOME");
			lbl_impegno.setText("IMPEGNO");
			btn_salva.setText("SALVA");
		}
		else {
			lbl_nome.setText("NAME");
			lbl_cognome.setText("SURNAME");
			lbl_impegno.setText("DUTY");
			btn_salva.setText("SAVE");
		}
		
		contentPane.add(btn_indietro);
		
		
		contentPane.revalidate();
		contentPane.repaint();
		
		
		
		
		
		
		
	}

}
