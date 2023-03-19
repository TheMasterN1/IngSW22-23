package prove_esame_INGSW;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;


public class controllore {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String str="com.jtattoo.plaf.hifi.HiFiLookAndFeel";
		UIManager.setLookAndFeel(str);
        controllore c =new controllore();
        
	}
	
	public controllore()
	{
		Login login=new Login(this);
		login.setVisible(true);
	
		
	}

public static String getTime() {
	SimpleDateFormat sdf= new SimpleDateFormat("EEEE d MMMM yyyy HH:mm:ss", Locale.ITALIAN);
	Date now = new Date();
	String strDate= sdf.format(now);
	return strDate;
}

public static String getTimeEng() {
	SimpleDateFormat sdf= new SimpleDateFormat("EEEE d MMMM yyyy HH:mm:ss", Locale.ENGLISH);
	Date now = new Date();
	String strDate= sdf.format(now);
	return strDate;
}
}