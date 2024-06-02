package View;

import java.io.BufferedReader;          
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonArray;

import Model.ModelDVSau;
import Model.ModelDVTruoc;
import Model.Modelthongtinphong;
import Model.Phong.TrangThaiPhong;
import controller.PhongManagerQL;


public class ClientThread extends Thread {
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

	private void handleClientData(String data) throws SQLException, IOException {
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
		case "ORDER":
			order(remainingData);
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
		case "TAOMAKH":
			taomakh(remainingData);
			break;
		case "CANCEL":
			cancel(remainingData);
			break;
		case "TRUYENDULIEU":
			truyendulieu(remainingData);
			break;
		case "XACNHANPHONG":
			xacnhan(remainingData);
			break;
		case "DONGBOHOA":
			dongbo();
			break;
		default:
			out.println("Yêu cầu không hợp lệ");
			break;
		}
	}

	public void CheckOut(String yeucau) {

	}

	public void cancel(String thongtin) {
		int maphong = Integer.parseInt(thongtin);
		QuanLy.cancel(maphong);
	}

	public void Booking(String thongtin) {
		int madp = QuanLy.booking(thongtin);
		out.println(madp);
	}

	public void xacnhan(String thongtin) {
		String[] parts = thongtin.split("#", 2);
		int maphong = Integer.parseInt(parts[0]);
		String tgian = parts[1];
		QuanLy.xacnhan(maphong, tgian);
	}

	public void order(String thongtin) {
		String[] parts = thongtin.split("#", 3);
		int maphong = Integer.parseInt(parts[0]);
		int madv = Integer.parseInt(parts[1]);
		int soluong = Integer.parseInt(parts[2]);
		QuanLy.Order(maphong, madv, soluong);
	}

	public void taomakh(String thongtin) {
		String ma = QuanLy.TaoMaKH(thongtin);
		out.println(ma);
	}

	public void truyendulieu(String username) {
		String thongtin = QuanLy.truyenthongtin(username);
		out.println(thongtin);
	}

	public void CheckDP(String thongtin) {
		String[] parts = thongtin.split("#", 2);
		String madp = parts[0];
		int maphong = Integer.parseInt(parts[1]);
		// cần trả về 0 hay 1
		if (QuanLy.CheckDPKH(madp, maphong) == true) {
			out.println("1");// thông báo về việc có mã đặt phòng như vậy
		} else
			out.println("0");
	}

	public void CheckIn(String thongtin) throws SQLException {
		String[] parts = thongtin.split("#", 2);
		String Username = parts[0];
		String MK = parts[1];
		// cần trả về 0 hay 1
		if (QuanLy.CheckIn(Username, MK) == true) {
			String a = QuanLy.laymakh(Username);
			QuanLy.dulieukhach.put(this, a);
			out.println("1");// thông báo về đăng nhập là có class->cho đăng nhập
		} else
			out.println("0");// thông báo về đăng nhập là không có ->yêu cầu nhập lại
	}

	public void Dangky(String thongtin) {
		String[] parts = thongtin.split("#");
		// String Username, String CCCD, String Sdth, String email, String mk
		String name = parts[0];
		String CCCD = parts[1];
		String Sdth = parts[2];
		String email = parts[3];
		String mk = parts[4];
		String username = parts[5];
		if (QuanLy.KiemTraTonTai(username, CCCD) == false) {
			QuanLy.DangKy(name, CCCD, Sdth, email, mk, username);
			out.println("1");// thông báo về ng dùng là đăng ký thành công
		} else
			out.println("0");// thông báo về ng dùng là đky không thành công do name hay cccd đã tồn tại
	}

	public void ChangePass(String thongtin) throws SQLException {
		String[] parts = thongtin.split("#");
		String username = parts[0];
		String newpass = parts[1];
		if (QuanLy.capNhatMatKhau(username, newpass) == true) {
			out.println("1");
		} else
			out.println("0");
	}

	public void Checkxacthuc(String thongtin) throws SQLException {
		String[] parts = thongtin.split("#");
		String username = parts[0];
		String email = parts[1];
		if (QuanLy.kiemtraxacthuc(username, email) == true) {
			out.println("1");
		} else
			out.println("0");
	}

	public void Checktontai(String thongtin) {
		String[] parts = thongtin.split("#");
		String username = parts[0];
		String cccd = parts[1];
		if (QuanLy.KiemTraTonTai(username, cccd) == true) {
			out.println("1");
		} else
			out.println("0");
	}
	
	

	public void dongbo() {
		Gson gson = new Gson();
		Modelthongtinphong []thongtinnnnn = new Modelthongtinphong[12];
		int i = 0;
		for (PhongManagerQL phongql : QuanLy.quanLyPhong) {
			if (phongql.phong.getTrangThai() == TrangThaiPhong.TRONG) {
				Modelthongtinphong thongtin = new Modelthongtinphong(TrangThaiPhong.TRONG, null, null, null, null, null,
						null, null, null);
				thongtinnnnn[i] = thongtin;
				i++;
			} else if (phongql.phong.getTrangThai() == TrangThaiPhong.CHO_XAC_NHAN) {
				Modelthongtinphong thongtin = new Modelthongtinphong();
				thongtin.setTrangthai(TrangThaiPhong.CHO_XAC_NHAN);
				thongtin.setCccd(phongql.xacnhan.TCCCD.getText());
				thongtin.setHoten(phongql.xacnhan.THovaten.getText());
				int madp = Integer.parseInt(phongql.xacnhan.TMadatphong.getText());
				thongtin.setSdth(phongql.xacnhan.TSdth.getText());
				thongtin.setNgayvao(null);
				thongtin.setMadp(madp);
				thongtin.setMakh(phongql.xacnhan.TMaKH.getText());
				ArrayList<ModelDVTruoc> dichvutrc = new ArrayList<ModelDVTruoc>();
				for (int row = 0; row < phongql.xacnhan.db.getRowCount(); row++) {
					ModelDVTruoc dvtrc = new ModelDVTruoc();
					dvtrc.setTendv(phongql.xacnhan.db.getValueAt(row, 0) + "");
					int giatien = ManagerUI.convert(phongql.xacnhan.db.getValueAt(row, 1) + "");
					dvtrc.setGia(giatien);
					dichvutrc.add(dvtrc);
				}
				thongtin.setDvtruoc(dichvutrc);
				thongtin.setDvsau(null);
				thongtinnnnn[i] = thongtin;
				i++;
			} else {
				Modelthongtinphong thongtin = new Modelthongtinphong();
				thongtin.setTrangthai(TrangThaiPhong.DANG_HOAT_DONG);
				thongtin.setCccd(phongql.hoatdong.TCCCD.getText());
				thongtin.setHoten(phongql.hoatdong.THovaten.getText());
				int madp = Integer.parseInt(phongql.hoatdong.TMadatphong.getText());
				thongtin.setMadp(madp);
				thongtin.setSdth(phongql.hoatdong.TSDTH.getText());
				thongtin.setNgayvao(phongql.hoatdong.TNgayGioNHanPhong.getText());
				thongtin.setMakh(phongql.hoatdong.TMaKH.getText());
				ArrayList<ModelDVTruoc> dichvutrc = new ArrayList<ModelDVTruoc>();
				for (int row = 0; row < phongql.hoatdong.db.getRowCount(); row++) {
					ModelDVTruoc dvtrc = new ModelDVTruoc();
					dvtrc.setTendv(phongql.hoatdong.db.getValueAt(row, 0) + "");
					int giatien = ManagerUI.convert(phongql.hoatdong.db.getValueAt(row, 1) + "");
					dvtrc.setGia(giatien);
					dichvutrc.add(dvtrc);

				}
				thongtin.setDvtruoc(dichvutrc);
				ArrayList<ModelDVSau> dichvusau = new ArrayList<ModelDVSau>();
				for (int row = 0; row < phongql.hoatdong.dbsau.getRowCount(); row++) {
					ModelDVSau dvsau = new ModelDVSau();
					dvsau.setTendv(phongql.hoatdong.dbsau.getValueAt(row, 0) + "");
					int giatien = ManagerUI.convert(phongql.hoatdong.dbsau.getValueAt(row, 1) + "");
					dvsau.setDongia(giatien);
					int soluong = Integer.parseInt(phongql.hoatdong.dbsau.getValueAt(row, 2) + "");
					dvsau.setSoluong(soluong);
					int thanhtien = ManagerUI.convert(phongql.hoatdong.dbsau.getValueAt(row, 3) + "");
					dvsau.setThanhtien(thanhtien);
					dichvusau.add(dvsau);
				}
				thongtin.setDvsau(dichvusau);
				thongtinnnnn[i] = thongtin;
				i++;
			}
		}
		String jsonString = gson.toJson(thongtinnnnn);
		System.out.println(jsonString);
		out.println(jsonString);
	}

}
