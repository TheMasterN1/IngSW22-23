package prove_esame_INGSW;

import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;

public class HomePage extends JFrame {
	
	private JPanel contentPane;
	private controllore thecontroller;
	private static Timer tt;
	public static int lingua=1 ;
	
	
	public HomePage(controllore c) {
		thecontroller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		JLabel lbl_benvenuto=new JLabel("BENVENUTO TIZIO X ");
		lbl_benvenuto.setBounds(450, 0, 300, 90);
		lbl_benvenuto.setHorizontalAlignment(JLabel.CENTER);
		lbl_benvenuto.setVerticalAlignment(JLabel.CENTER);
		lbl_benvenuto.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_benvenuto);
		
		JLabel lbl_orario = new JLabel("");
		lbl_orario.setBounds(10,0,350,90);
		lbl_orario.setHorizontalAlignment(JLabel.CENTER);
		lbl_orario.setVerticalAlignment(JLabel.CENTER);
		lbl_orario.setFont(new Font("Tahoma", Font.PLAIN,20));
		contentPane.add(lbl_orario);
		
	       
		
		 JButton casella_notifiche = new JButton();
		 casella_notifiche.setBounds(1200,0,70,70);
		 casella_notifiche.setEnabled(true);
		  try {
		    Image img = ImageIO.read(getClass().getResource("/resources/email.png"));
		    Image image=img.getScaledInstance(casella_notifiche.getWidth(), casella_notifiche.getHeight(), Image.SCALE_DEFAULT);
	        ImageIcon icon=new ImageIcon(image);
	        casella_notifiche.setIcon(icon);
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		 contentPane.add(casella_notifiche);
		
		JButton btn_inserisci_ordine = new JButton();
		btn_inserisci_ordine.setBounds(150, 300, 230,130);
		btn_inserisci_ordine.setEnabled(true);
		btn_inserisci_ordine.setHorizontalAlignment(JLabel.CENTER);
		btn_inserisci_ordine.setVerticalAlignment(JLabel.CENTER);
		btn_inserisci_ordine.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_inserisci_ordine.setText("INSERISCI ORDINE");
		contentPane.add(btn_inserisci_ordine);
		
		JButton btn_dispensa = new JButton();
		btn_dispensa.setBounds(500, 300, 230,130);
		btn_dispensa.setEnabled(true);
		btn_dispensa.setHorizontalAlignment(JLabel.CENTER);
		btn_dispensa.setVerticalAlignment(JLabel.CENTER);
		btn_dispensa.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_dispensa.setText("VISUALIZZA DISPENSA");
		btn_dispensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dispensa disp = new dispensa(c);
				disp.setVisible(true);
			}
		});
		contentPane.add(btn_dispensa);
		
		JButton btn_crea_menu = new JButton();
		btn_crea_menu.setBounds(850, 300, 230,130);
		btn_crea_menu.setEnabled(true);
		btn_crea_menu.setHorizontalAlignment(JLabel.CENTER);
		btn_crea_menu.setVerticalAlignment(JLabel.CENTER);
		btn_crea_menu.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_crea_menu.setText("CREA MENU");
		contentPane.add(btn_crea_menu);
		
		
		
		JButton btn_logo = new JButton();
		btn_logo.setBounds(0, 600, 100, 100);
		btn_logo.setEnabled(true);
		btn_logo.setHorizontalAlignment(JLabel.CENTER);
		btn_logo.setVerticalAlignment(JLabel.CENTER);
		  try {
			    Image img = ImageIO.read(getClass().getResource("/resources/email.png"));
			    Image image=img.getScaledInstance(btn_logo.getWidth(), btn_logo.getHeight(), Image.SCALE_DEFAULT);
		        ImageIcon icon=new ImageIcon(image);
		        btn_logo.setIcon(icon);
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		contentPane.add(btn_logo);
		
		
		JButton btn_lingue = new JButton();
		btn_lingue.setBounds(550, 600, 100, 100);
		btn_lingue.setHorizontalAlignment(JLabel.CENTER);
		btn_lingue.setVerticalAlignment(JLabel.CENTER);
		btn_lingue.setEnabled(true);
		try {
			    Image img = ImageIO.read(getClass().getResource("/resources/email.png"));
			    Image image = img.getScaledInstance(btn_lingue.getWidth(), btn_lingue.getHeight(), Image.SCALE_DEFAULT);
		        ImageIcon icon = new ImageIcon(image);
		        btn_lingue.setIcon(icon);
		} catch (Exception e) {
			System.out.println(e);
		}
		 final JPopupMenu menu = new JPopupMenu("Menu");
			menu.add("ITALIANO").addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(lingua!=1) {
						lingua=1;
						lbl_benvenuto.setText("BENVENUTO TIZIO X");
						if(tt!=null) {
							tt.cancel();
						}
						
						tt = new Timer();
						tt.scheduleAtFixedRate(new TimerTask() {
							public void run() {
							lbl_orario.setText(c.getTime());
							}
						},0,500);
						
						btn_inserisci_ordine.setText("INSERISCI ORDINE");
						btn_dispensa.setText("VISUALIZZA DISPENSA");
						btn_crea_menu.setText("CREA MENU");
					}
				}
			});
			menu.add("INGLESE").addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(lingua!=0) {
						lingua=0;
						lbl_benvenuto.setText("WELCOME MR.X");
						if(tt!=null) {
							tt.cancel();
						}
						
						tt = new Timer();
						tt.scheduleAtFixedRate(new TimerTask() {
							public void run() {
							lbl_orario.setText(c.getTimeEng());
							}
						},0,500);
						
						btn_inserisci_ordine.setText("INSERT ORDER");
						btn_dispensa.setText("VISUALIZE DEPOSIT");
						btn_crea_menu.setText("CREATE MENU");
					}
				}
			});
         btn_lingue.addActionListener( new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 menu.show(btn_lingue, btn_lingue.getWidth()/2, btn_lingue.getHeight()/2);
             }
         } );
		contentPane.add(btn_lingue);
		
		JButton btn_log_out = new JButton("LOGOUT");
		btn_log_out.setBounds(1170, 600, 100,100);
		btn_log_out.setHorizontalAlignment(JLabel.CENTER);
		btn_log_out.setVerticalAlignment(JLabel.CENTER);
		btn_log_out.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_log_out.setEnabled(true);
		btn_log_out.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               dispose();
               Login login = new Login(c);
               login.setVisible(true);
            }
        } );
		contentPane.add(btn_log_out);
		
		
		tt = new Timer();
		tt.scheduleAtFixedRate(new TimerTask() {
			public void run() {
			lbl_orario.setText(c.getTime());
			}
		},0,500);
		
		
		if(lingua==1) {
			lbl_benvenuto.setText("BENVENUTO TIZIO X");
			if(tt!=null) {
				tt.cancel();
			}
			
			tt = new Timer();
			tt.scheduleAtFixedRate(new TimerTask() {
				public void run() {
				lbl_orario.setText(c.getTime());
				}
			},0,500);
			
			btn_inserisci_ordine.setText("INSERISCI ORDINE");
			btn_dispensa.setText("VISUALIZZA DISPENSA");
			btn_crea_menu.setText("CREA MENU");
		}
		else {
			lbl_benvenuto.setText("WELCOME MR.X");
			if(tt!=null) {
				tt.cancel();
			}
			
			tt = new Timer();
			tt.scheduleAtFixedRate(new TimerTask() {
				public void run() {
				lbl_orario.setText(c.getTimeEng());
				}
			},0,500);
			
			btn_inserisci_ordine.setText("INSERT ORDER");
			btn_dispensa.setText("VISUALIZE DEPOSIT");
			btn_crea_menu.setText("CREATE MENU");
		}
	
		contentPane.revalidate();
		contentPane.repaint();
	}
	
}

