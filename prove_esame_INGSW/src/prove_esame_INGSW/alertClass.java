package prove_esame_INGSW;

import javax.naming.Context;
import javax.swing.JOptionPane;

public class alertClass  {
	private Login login;
	
	public void alert() {
		JOptionPane.showMessageDialog( login,"password errata");
	}

}
