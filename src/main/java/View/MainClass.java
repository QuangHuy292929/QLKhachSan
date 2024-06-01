package View;

import javax.swing.UIManager;


public class MainClass {
	
	private static Client client;
	public static void main(String[] args) {
		client = new Client();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginUI(client);
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		
	}

}
