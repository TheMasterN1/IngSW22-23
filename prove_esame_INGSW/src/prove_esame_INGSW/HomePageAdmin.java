package prove_esame_INGSW;

import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.Image;
import java.util.*;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePageAdmin extends JFrame {
	
	private JPanel contentPane;
	private controllore thecontroller;
	private static Timer tt;
	
	
	public HomePageAdmin(controllore c) {
		thecontroller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
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
		 }catch (Exception ex) {
		   System.out.println(ex);
		}
		contentPane.add(casella_notifiche);
		
		
		
		JButton btn_inserisci_dipendente = new JButton();
		btn_inserisci_dipendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				inserimentoDipendenti inserimentoDip= new inserimentoDipendenti(c);
				inserimentoDip.setVisible(true);
				
			}
		});
		btn_inserisci_dipendente.setBounds(350, 300, 230,130);
		btn_inserisci_dipendente.setEnabled(true);
		btn_inserisci_dipendente.setHorizontalAlignment(JLabel.CENTER);
		btn_inserisci_dipendente.setVerticalAlignment(JLabel.CENTER);
		btn_inserisci_dipendente.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_inserisci_dipendente.setText("INSERISCI NUOVO DIPENDENTE");
		contentPane.add(btn_inserisci_dipendente);
		
		JButton btn_invia_messaggio = new JButton();
		btn_invia_messaggio.setBounds(650, 300, 230,130);
		btn_invia_messaggio.setEnabled(true);
		btn_invia_messaggio.setHorizontalAlignment(JLabel.CENTER);
		btn_invia_messaggio.setVerticalAlignment(JLabel.CENTER);
		btn_invia_messaggio.setFont(new Font("Tahoma", Font.PLAIN,20));
		btn_invia_messaggio.setText("INVIA MESSAGGIO ");
		contentPane.add(btn_invia_messaggio);
		
		
		
		
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
					if(HomePage.lingua!=1) {
						HomePage.lingua=1;
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
						
						btn_inserisci_dipendente.setText("INSERISCI DIPENDENTE");
						btn_invia_messaggio.setText("INVIA MESSAGGIO");
					}
				}
			});
			menu.add("INGLESE").addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(HomePage.lingua!=0) {
						HomePage.lingua=0;
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
						
						btn_inserisci_dipendente.setText("INSERT EMPLOYEE");
						btn_invia_messaggio.setText("SEND MESSAGE");
					}
				}
			});
      btn_lingue.addActionListener( new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
              menu.show(btn_lingue, btn_lingue.getWidth()/2, btn_lingue.getHeight()/2);
          }
      } );
      
      if(HomePage.lingua==1) {
	
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
			
			btn_inserisci_dipendente.setText("INSERISCI DIPENDENTE");
			btn_invia_messaggio.setText("INVIA MESSAGGIO");
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
			
			btn_inserisci_dipendente.setText("INSERT EMPLOYEE");
			btn_invia_messaggio.setText("SEND MESSAGE");
      }
      
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
		contentPane.revalidate();
		contentPane.repaint();
	}
	
}

