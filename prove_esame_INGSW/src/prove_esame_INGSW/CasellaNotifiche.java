package prove_esame_INGSW;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CasellaNotifiche extends JFrame {

	private JPanel contentPane;
	private controllore thecontroller;
	
	public CasellaNotifiche(controllore c) {
		thecontroller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 909);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		
		JLabel lbl_nome_mittente = new JLabel("NOME MITTENTE");
		lbl_nome_mittente.setBounds(50, 0, 200, 90);
		lbl_nome_mittente.setHorizontalAlignment(JLabel.CENTER);
		lbl_nome_mittente.setVerticalAlignment(JLabel.CENTER);
		lbl_nome_mittente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl_nome_mittente);
		
		JTextField txt_nome_mittente = new JTextField();
		txt_nome_mittente.setBounds(60,80, 188, 30);
		txt_nome_mittente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_nome_mittente.setColumns(10);
		txt_nome_mittente.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(txt_nome_mittente);
		
		
		JLabel lbl_data_inizio = new JLabel("DATA INIZIO");
		lbl_data_inizio.setBounds(300, 0, 200, 90);
		lbl_data_inizio.setHorizontalAlignment(JLabel.CENTER);
		lbl_data_inizio.setVerticalAlignment(JLabel.CENTER);
		lbl_data_inizio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl_data_inizio);
		
		JTextField text_data_inizio = new JTextField();
		text_data_inizio.setBounds(310,80, 188, 30);
		text_data_inizio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_data_inizio.setColumns(10);
		text_data_inizio.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_data_inizio);
		
		
		JLabel lbl_data_fine = new JLabel("DATA FINE");
		lbl_data_fine.setBounds(550, 0, 200, 90);
		lbl_data_fine.setHorizontalAlignment(JLabel.CENTER);
		lbl_data_fine.setVerticalAlignment(JLabel.CENTER);
		lbl_data_fine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl_data_fine);
		
		JTextField text_data_fine = new JTextField();
		text_data_fine.setBounds(560,80, 188, 30);
		text_data_fine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_data_fine.setColumns(10);
		text_data_fine.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_data_fine);
		
		JButton btn_filtra = new JButton("FILTRA");	
		btn_filtra.setBounds(800,70, 188, 30);
		btn_filtra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_filtra.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(btn_filtra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 200, 800, 600);
		
		contentPane.add(scrollPane);
		
		
		JButton btn_indietro = new JButton("BACK");
		btn_indietro.setBounds(900,800,100,50);
		btn_indietro.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_indietro.setHorizontalAlignment(JLabel.CENTER);
		btn_indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage homePage = new HomePage(c);
				homePage.setVisible(true);
			}
		});
		
		if(HomePage.lingua==1) {
			lbl_nome_mittente.setText("NOME MITTENTE");
			lbl_data_inizio.setText("DATA INIZIO");
			lbl_data_fine.setText("DATA FINE");
			btn_filtra.setText("FILTRA");
		}
		else {
			lbl_nome_mittente.setText("SENDER NAME");
			lbl_data_inizio.setText("START DATE");
			lbl_data_fine.setText("END DATE");
			btn_filtra.setText("SEARCH");
		}
		contentPane.add(btn_indietro);
		
		contentPane.revalidate();
		contentPane.validate();
	}
}
