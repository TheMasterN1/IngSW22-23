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

public class InviaMessaggio extends JFrame {
	private JPanel contentPane;
	private controllore thecontroller;
	
	public InviaMessaggio(controllore c) {
		thecontroller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(200, 0, 200, 90);
		lbl_username.setHorizontalAlignment(JLabel.CENTER);
		lbl_username.setVerticalAlignment(JLabel.CENTER);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_username);
		
		
		JTextField text_username = new JTextField();
		text_username.setBounds(500, 30, 188, 30);
		text_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_username.setColumns(10);
		text_username.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_username);
		
		JLabel lbl_messaggio = new JLabel("MESSAGGIO");
		lbl_messaggio.setBounds(400, 100, 200, 90);
		lbl_messaggio.setHorizontalAlignment(JLabel.CENTER);
		lbl_messaggio.setVerticalAlignment(JLabel.CENTER);
		lbl_messaggio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_messaggio);
		
		
		JTextField text_messaggio = new JTextField();
		text_messaggio.setBounds(150, 180, 688, 300);
		text_messaggio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_messaggio.setColumns(10);
		text_messaggio.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_messaggio);
		
		
		JButton btn_salva = new JButton("INVIA");
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
			lbl_messaggio.setText("MESSAGGIO");
			btn_salva.setText("SALVA");
		}
		else {
			lbl_messaggio.setText("MESSAGE");
			btn_salva.setText("SAVE");
		}
		contentPane.add(btn_indietro);
		
		
		contentPane.revalidate();
		contentPane.repaint();
		
		
		
		
		
		
		
	}

}
