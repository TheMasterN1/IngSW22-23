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

public class dispensa extends JFrame {

	private JPanel contentPane;
	private controllore thecontroller;
	
	public dispensa(controllore c) {
		thecontroller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 909);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		
		JLabel lbl_nome_elem = new JLabel("NOME ELEM");
		lbl_nome_elem.setBounds(50, 0, 200, 90);
		lbl_nome_elem.setHorizontalAlignment(JLabel.CENTER);
		lbl_nome_elem.setVerticalAlignment(JLabel.CENTER);
		lbl_nome_elem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl_nome_elem);
		
		JTextField text_nome = new JTextField();
		text_nome.setBounds(60,80, 188, 30);
		text_nome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_nome.setColumns(10);
		text_nome.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_nome);
		
		
		JLabel lbl_qta = new JLabel("QTA");
		lbl_qta.setBounds(300, 0, 200, 90);
		lbl_qta.setHorizontalAlignment(JLabel.CENTER);
		lbl_qta.setVerticalAlignment(JLabel.CENTER);
		lbl_qta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl_qta);
		
		JTextField text_qta = new JTextField();
		text_qta.setBounds(310,80, 188, 30);
		text_qta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text_qta.setColumns(10);
		text_qta.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(text_qta);
		
		
		JLabel lbl_disponibile = new JLabel("DISPONIBILE");
		lbl_disponibile.setBounds(550, 0, 200, 90);
		lbl_disponibile.setHorizontalAlignment(JLabel.CENTER);
		lbl_disponibile.setVerticalAlignment(JLabel.CENTER);
		lbl_disponibile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl_disponibile);
		
		JComboBox comboBoxDisp = new JComboBox();
		comboBoxDisp.setBounds(550, 80, 188, 22);
		comboBoxDisp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxDisp.addItem("NO");
		comboBoxDisp.addItem("SI");
		contentPane.add(comboBoxDisp);
		
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
			lbl_nome_elem.setText("NOME ELEM");
			lbl_qta.setText("QTA");
			lbl_disponibile.setText("DISPONIBILE");
			btn_filtra.setText("FILTRA");
		}
		else {
			lbl_nome_elem.setText("ELEM NAME");
			lbl_qta.setText("QTA");
			lbl_disponibile.setText("DISPONIBILITY");
			btn_filtra.setText("SEARCH");
		}
		contentPane.add(btn_indietro);
		
		contentPane.revalidate();
		contentPane.validate();
	}
}
