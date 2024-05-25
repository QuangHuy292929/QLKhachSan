package View;

import java.io.BufferedReader;   
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

public class ClientThread  extends Thread{
	 private Socket socket;
	 private BufferedReader in;
	 private PrintWriter out;
	 private ManagerUI QuanLy;
	 
	 
	 
	 public ClientThread(Socket socket, ManagerUI quanLy) {
		
		this.socket = socket;
		QuanLy = quanLy;
	}

	public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					// Xử lý yêu cầu từ client
					handleClientData(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
	 private void handleClientData(String data) throws SQLException {
	        // Tách yêu cầu và dữ liệu
	        String[] parts = data.split("#", 2);
	        String request = parts[0];
	        String remainingData = data.substring(data.indexOf("#") + 1); // "data1#data2"

	        // Xử lý yêu cầu dựa trên giá trị request
	        switch (request) {
	            case "CHECKIN":
	                CheckIn(remainingData);
	                break;
	            case "CHECKOUT":
	                CheckOut(remainingData);
	                break;
	            case "BOOKING":
	                Booking(remainingData);
	                break;
	            case "CHECKDP":
	            	CheckDP(remainingData);
	            	break;
	            case "CHECKDKY":
	            	Dangky(remainingData);
	            	break;
	            case "CHANGEPASS":
	            	ChangePass(remainingData);
	            	break;
	            case "CHECKXACTHUC":
	            	Checkxacthuc(remainingData);
	            	break;
	            case "CHECKTONTAI":
	            	Checktontai(remainingData);
	            	break;
	            default:
	                out.println("Yêu cầu không hợp lệ");
	                break;
	        }
	   }
	 
	 public void CheckOut(String yeucau) {
		 
	 }
	 
	 public void Booking(String thongtin) {
		 
	 }
	 
	 public void CheckDP(String thongtin) {
		 String[] parts = thongtin.split("#", 2);
		 String madp = parts[0];
		 int phong = Integer.parseInt(parts[1]);
		 //cần trả về 0 hay 1
		 if(QuanLy.CheckDPKH(madp, phong) == true) {
			 out.println("1");//thông báo về việc có mã đặt phòng như vậy
		 } else out.println("0");
	 }
	 
	 public void CheckIn(String thongtin) throws SQLException {
		 String[] parts = thongtin.split("#", 2);
		 String Username = parts[0];
		 String MK = parts[1];
		 //cần trả về 0 hay 1
		 if(QuanLy.CheckIn(Username, MK) == true) {
			 out.println("1");//thông báo về đăng nhập là có class->cho đăng nhập
		 } else out.println("0");//thông báo về đăng nhập là không có ->yêu cầu nhập lại
	 }
	 
	 public void Dangky(String thongtin) {
		 String[] parts = thongtin.split("#");
		 //String Username, String CCCD, String Sdth, String email, String mk
		 String name = parts[0];
		 String CCCD = parts[1];
		 String Sdth = parts[2];
		 String email = parts[3];
		 String mk = parts[4];
		 String username = parts[5];
		 if(QuanLy.KiemTraTonTai(username, CCCD)==false) {
			 QuanLy.DangKy(name, CCCD, Sdth, email, mk, username);
			 out.println("1");//thông báo về ng dùng là đăng ký thành công
		 } else out.println("0");//thông báo về ng dùng là đky không thành công do name hay cccd đã tồn tại
	 }
	 
	 public void ChangePass(String thongtin) throws SQLException {
		 String[] parts = thongtin.split("#");
		 String username = parts[0];
		 String newpass = parts[1];
		 if (QuanLy.capNhatMatKhau(username, newpass) == true) {
			 out.println("1");
		} else out.println("0");
	 }
	 
	 public void Checkxacthuc(String thongtin) throws SQLException {
		 String[] parts = thongtin.split("#");
		 String username = parts[0];
		 String email = parts[1];
		 if (QuanLy.kiemtraxacthuc(username, email) == true) {
			 out.println("1");
		} else out.println("0");
	 }
	 
	 public void Checktontai(String thongtin) {
		 String[] parts = thongtin.split("#");
		 String username = parts[0];
		 String cccd = parts[1];
		 if (QuanLy.KiemTraTonTai(username, cccd) == true) {
			 out.println("1");
		} else out.println("0");
	 }
	 
	 public void order(String thongtin) {
		 String[] part = thongtin.split("#");
		 String madp = part[0];
		 String tendv  = part[1];
		 String dongia = part[2];
		 String soluong = part[3];
		 String Thanhtien = part[4];
		 
	 }
	 
	 
	 
	 
}
