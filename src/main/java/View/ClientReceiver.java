package View;


public class ClientReceiver extends Thread{
	private UserUI user;
	public static Client client;
	public ClientReceiver(Client client, UserUI user) {
		ClientReceiver.client = client;
		this.user = user;
	}
	
	@Override
	public void run() {
		String Answer;
		while((Answer = client.receiveMessage()) !=null) {
			handleMessage(Answer);
		}
	}
	
	private void handleMessage(String message) {
		String []part = message.split("#");
		String answer = part[0];
		String thongtin = part[1];
		if(answer.equals("DONGBOHOA")) {
			user.xulydongbo(thongtin);
		}
	}
	
	
}
