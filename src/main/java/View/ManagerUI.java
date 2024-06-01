package View;
 

import javax.swing.JFrame;    
import javax.swing.JPanel;

import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Model.ModelDVSau;
import Model.ModelDVTruoc;
import Model.ModelDichVu;
import Model.ModelKhachHang;
import Model.Modelchuoi;
import Model.Modelthongtinphong;
import Model.Phong;
import Model.Phong.LoaiPhong;
import Model.Phong.TrangThaiPhong;
import controller.PhongManagerQL;
import controller.connectdatabase;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public Phong[] phong;
	JPanel pn_trangchu;
	JPanel pn_sodophong;
	JPanel pn_hoatdong;
	private static List<ClientThread> clients = new ArrayList<>();
    Color colordat = new Color(205, 180, 219);
    Color colorchoxacnhan = new Color(255, 200, 221);
	public CardLayout cardhd;
	public HashMap<Integer, String> key_room = new HashMap<Integer, String>();
	public HashMap<ClientThread, String> dulieukhach = new HashMap<ClientThread, String>();
	public HashMap<String, Integer> dulieudp = new HashMap<String, Integer>();
	private DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	public ArrayList<PhongManagerQL> quanLyPhong;
	ModelDichVu[] danhsachDV = new ModelDichVu[17];




	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ManagerUI manager = new ManagerUI();
			try {
	            ServerSocket serverSocket = new ServerSocket(8000);
	            System.out.println("Server đang lắng nghe trên cổng " + 8000);

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("Đã kết nối với Client: " + clientSocket.getInetAddress().getHostAddress());

	                ClientThread clientThread = new ClientThread(clientSocket, manager);
	                clients.add(clientThread);
	                clientThread.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		
	}
	

	/**
	 * Create the frame.
	 */
	public ManagerUI() {
		setTitle("Hệ thống quản lý Khách Sạn");
		getContentPane().setBackground(new Color(204, 255, 255));
		Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        border = BorderFactory.createCompoundBorder(new RoundedBorder(20, 20, Color.GRAY), border);
        Font font = new Font("Roboto", Font.BOLD, 22);
        Font font2 = new Font("Roboto",Font.CENTER_BASELINE, 18);
        
		quanLyPhong = new ArrayList<PhongManagerQL>();
		phong = new Phong[]{
				new Phong(101, "Phòng 101", TrangThaiPhong.TRONG, 400000, LoaiPhong.THUONG),
				new Phong(102, "Phòng 102", TrangThaiPhong.TRONG, 400000, LoaiPhong.THUONG),
				new Phong(103, "Phòng 103", TrangThaiPhong.TRONG, 400000, LoaiPhong.THUONG),
				new Phong(104, "Phòng 104", TrangThaiPhong.TRONG, 400000, LoaiPhong.THUONG),
				new Phong(201, "Phòng 201", TrangThaiPhong.TRONG, 600000, LoaiPhong.TRUNG),
				new Phong(202, "Phòng 202", TrangThaiPhong.TRONG, 600000, LoaiPhong.TRUNG),
				new Phong(203, "Phòng 203", TrangThaiPhong.TRONG, 600000, LoaiPhong.TRUNG),
				new Phong(204, "Phòng 204", TrangThaiPhong.TRONG, 600000, LoaiPhong.TRUNG),
				new Phong(301, "Phòng 301", TrangThaiPhong.TRONG, 800000, LoaiPhong.VIP),
				new Phong(302, "Phòng 302", TrangThaiPhong.TRONG, 800000, LoaiPhong.VIP),
				new Phong(303, "Phòng 303", TrangThaiPhong.TRONG, 800000, LoaiPhong.VIP),
				new Phong(304, "Phòng 304", TrangThaiPhong.TRONG, 800000, LoaiPhong.VIP),
		};
		danhsachDV[0] = new ModelDichVu(0, "Nước lọc", 15000);
		danhsachDV[1] = new ModelDichVu(1, "Snack khoai tây", 20000);
		danhsachDV[2] = new ModelDichVu(2, "Coca/Pepsi", 20000);
		danhsachDV[3] = new ModelDichVu(3, "Rượu Vodka SMIRNOFF 700ML", 400000);
		danhsachDV[4] = new ModelDichVu(4, "Bánh KitKat", 25000);
		danhsachDV[5] = new ModelDichVu(5, "Nước Smartwater 500ML", 60000);
		danhsachDV[6] = new ModelDichVu(6, "Bia Heineken 250ML", 20000);
		danhsachDV[7] = new ModelDichVu(7, "Vang Ý Mango Tropical 750ML", 500000);
		danhsachDV[8] = new ModelDichVu(8, "Chivas Regal 18 Gold Signature 700ML", 1400000);
		danhsachDV[9] = new ModelDichVu(9, "Cho thuê xe tự lái", 700000);
		danhsachDV[10] = new ModelDichVu(10, "Dùng điểm tâm", 500000);
		danhsachDV[11] = new ModelDichVu(11, "Đưa đón sân bay", 200000);
		danhsachDV[12] = new ModelDichVu(12, "Trông trẻ", 300000);
		danhsachDV[13] = new ModelDichVu(13, "Tuần trăng mật", 3000000);
		danhsachDV[14] = new ModelDichVu(14, "Giặt ủi", 100000);
		danhsachDV[15] = new ModelDichVu(15, "Spa", 1500000);
		danhsachDV[16] = new ModelDichVu(16, "Fitness", 200000);
		
		key_room.put(101, "");
		key_room.put(102, "");
		key_room.put(103, "");
		key_room.put(104, "");
		key_room.put(201, "");
		key_room.put(202, "");
		key_room.put(203, "");
		key_room.put(204, "");
		key_room.put(301, "");
		key_room.put(302, "");
		key_room.put(303, "");
		key_room.put(304, "");
		

		this.setVisible(true);
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel pn_menu = new JPanel();
		pn_menu.setBackground(new Color(255, 255, 255));
		pn_menu.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), null, null, null));
		pn_menu.setBounds(10, 10, 211, 742);
		getContentPane().add(pn_menu);
		
		pn_hoatdong = new JPanel();
		pn_hoatdong.setBounds(231, 10, 947, 742);
		getContentPane().add(pn_hoatdong);
		cardhd = new CardLayout();
		pn_hoatdong.setLayout(cardhd);

		JButton bt_trangchu = new JButton("Trang chủ");
		bt_trangchu.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/trangchu.png")));
		bt_trangchu.setBackground(new Color(153, 153, 153));
		bt_trangchu.setBounds(2, 2, 207, 67);
		bt_trangchu.setFont(font2);
		bt_trangchu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardhd.show(pn_hoatdong, "anhTrangchu");
			}
		});
		pn_menu.setLayout(null);
		pn_menu.add(bt_trangchu);
		
		JButton bt_sodophong = new JButton("Sơ đồ phòng");
		bt_sodophong.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/diagram.png")));
		bt_sodophong.setBackground(new Color(153, 153, 153));
		bt_sodophong.setBounds(2, 74, 207, 67);
		bt_sodophong.setFont(font2);
		pn_menu.add(bt_sodophong);

		JButton bt_Thongke = new JButton("Thống kê");
		bt_Thongke.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/pie-chart.png")));
		bt_Thongke.setBackground(new Color(102, 102, 102));
		bt_Thongke.setBounds(2, 146, 207, 67);
		bt_Thongke.setFont(font2);
		pn_menu.add(bt_Thongke);

		JButton bt_baocao = new JButton("Báo Cáo");
		bt_baocao.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/report.png")));
		bt_baocao.setBackground(new Color(102, 102, 102));
		bt_baocao.setBounds(2, 218, 207, 67);
		bt_baocao.setFont(font2);
		pn_menu.add(bt_baocao);

		JButton bt_dangxuat = new JButton("Đăng xuất");
		bt_dangxuat.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/logout (1).png")));
		bt_dangxuat.setBackground(new Color(102, 102, 102));
		bt_dangxuat.setBounds(2, 290, 207, 67);
		bt_dangxuat.setFont(font2);
		pn_menu.add(bt_dangxuat);
		 

		JPanel pn_trangchu = new JPanel();
		pn_hoatdong.add(pn_trangchu, "anhTrangchu");
		pn_trangchu.setLayout(new BorderLayout(0, 0));

		JPanel pn_sodophong = new JPanel();
		pn_sodophong.setBackground(new Color(255, 255, 255));
		pn_hoatdong.add(pn_sodophong, "sơ đồ phòng");
		pn_sodophong.setLayout(null);
		bt_sodophong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardhd.show(pn_hoatdong, "sơ đồ phòng");
			}
		});
		
		

		JPanel pn_bar = new JPanel();
		pn_bar.setBounds(10, 10, 927, 40);
		pn_sodophong.add(pn_bar);
		pn_bar.setLayout(new GridLayout(1, 0, 10, 10));

		JPanel pn_luachon = new JPanel();
		pn_luachon.setBackground(new Color(255, 255, 255));
		pn_bar.add(pn_luachon);
		pn_luachon.setLayout(new GridLayout(1, 5, 10, 10));

		JPanel panel_7 = new JPanel();
	    panel_7.setBackground(Color.getHSBColor(0, 0, (float) 0.94));
		pn_luachon.add(panel_7);
		JLabel lblNewLabel = new JLabel("Trống");
		lblNewLabel.setFont(font);
		panel_7.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(colordat);
		pn_luachon.add(panel);
		JLabel lblNewLabel_1 = new JLabel("Đã Đặt");
		lblNewLabel_1.setFont(font);
		panel.add(lblNewLabel_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(colorchoxacnhan);
		pn_luachon.add(panel_8);
		JLabel lblNewLabel_2 = new JLabel("Chờ Xác Nhận ");
		lblNewLabel_2.setFont(font);
		panel_8.add(lblNewLabel_2);
		

		// Tạo các panel để cho thấy thông tin phòng
		JPanel pn_p101 = new JPanel();
		JPanel pn_p102 = new JPanel();
		JPanel pn_p103 = new JPanel();
		JPanel pn_p104 = new JPanel();
		JPanel pn_p201 = new JPanel();
		JPanel pn_p202 = new JPanel();
		JPanel pn_p203 = new JPanel();
		JPanel pn_p204 = new JPanel();
		JPanel pn_p301 = new JPanel();
		JPanel pn_p302 = new JPanel();
		JPanel pn_p303 = new JPanel();
		JPanel pn_p304 = new JPanel();
		
		JPanel panel_phong1 = new JPanel();
		panel_phong1.setBorder(border);
		panel_phong1.setBounds(10, 79, 200, 200);
		pn_sodophong.add(panel_phong1);
		panel_phong1.setLayout(null);
		JLabel lblNewLabel_3 = new JLabel("P_101");
		lblNewLabel_3.setBounds(10, 10, 70, 30);
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setFont(font);
		panel_phong1.add(lblNewLabel_3);
		JLabel photo1 = new JLabel("");
		photo1.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo1.setBounds(36, 50, 128, 128);
		panel_phong1.add(photo1);
		pn_DanghoatdongQL hoatdong101 = new pn_DanghoatdongQL(phong[0], this);
		pn_ChoxacnhanQL xacnhan101 = new pn_ChoxacnhanQL(phong[0], hoatdong101,  this);
		pn_DatphongQL datphong101 = new pn_DatphongQL(phong[0], xacnhan101, hoatdong101, this);
		CardLayout cardP1 = new CardLayout();
		pn_p101.setLayout(cardP1);
		pn_p101.add(datphong101, "datohong101");
		pn_p101.add(xacnhan101, "xacnhan101");
		pn_p101.add(hoatdong101, "hoatdong101");
		PhongManagerQL manager1 = new PhongManagerQL(phong[0], panel_phong1, cardP1, datphong101, xacnhan101, hoatdong101, pn_p101);
		manager1.start();
		quanLyPhong.add(manager1);
		panel_phong1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 101");
			}
		});
		
		

		JPanel panel_phong2 = new JPanel();
		panel_phong2.setBorder(border);
		panel_phong2.setBounds(252, 79, 200, 200);
		pn_sodophong.add(panel_phong2);
		panel_phong2.setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("P_102");
		lblNewLabel_4.setBounds(10, 10, 70, 30);
		lblNewLabel_4.setFont(font);
		panel_phong2.add(lblNewLabel_4);
		JLabel photo2 = new JLabel("");
		photo2.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo2.setBounds(36, 50, 128, 128);
		panel_phong2.add(photo2);
		pn_DanghoatdongQL hoatdong102 = new pn_DanghoatdongQL(phong[1], this);
		pn_ChoxacnhanQL xacnhan102 = new pn_ChoxacnhanQL(phong[1], hoatdong102,  this);
		pn_DatphongQL datphong102 = new pn_DatphongQL(phong[1], xacnhan102, hoatdong102, this);
		CardLayout cardP2 = new CardLayout();
		pn_p102.setLayout(cardP2);
		pn_p102.add(datphong102, "datohong102");
		pn_p102.add(xacnhan102, "xacnhan102");
		pn_p102.add(hoatdong102, "hoatdong102");
		PhongManagerQL manager2 = new PhongManagerQL(phong[1], panel_phong2, cardP2, datphong102, xacnhan102, hoatdong102, pn_p102);
		manager2.start();
		quanLyPhong.add(manager2);
		panel_phong2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 102");
			}
		});
		
		

		JPanel panel_phong3 = new JPanel();
		panel_phong3.setBorder(border);
		panel_phong3.setBounds(498, 79, 200, 200);
		pn_sodophong.add(panel_phong3);
		panel_phong3.setLayout(null);
		JLabel lblNewLabel_5 = new JLabel("P_103");
		lblNewLabel_5.setBounds(10, 10, 70, 30);
		lblNewLabel_5.setFont(font);
		panel_phong3.add(lblNewLabel_5);
		JLabel photo3 = new JLabel("");
		photo3.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo3.setBounds(36, 50, 128, 128);
		panel_phong3.add(photo3);
		pn_DanghoatdongQL hoatdong103 = new pn_DanghoatdongQL(phong[2], this);
		pn_ChoxacnhanQL xacnhan103 = new pn_ChoxacnhanQL(phong[2], hoatdong103,  this);
		pn_DatphongQL datphong103 = new pn_DatphongQL(phong[2], xacnhan103, hoatdong103, this);
		CardLayout cardP3 = new CardLayout();
		pn_p103.setLayout(cardP3);
		pn_p103.add(datphong103, "datohong103");
		pn_p103.add(xacnhan103, "xacnhan103");
		pn_p103.add(hoatdong103, "hoatdong103");
		PhongManagerQL manager3 = new PhongManagerQL(phong[2], panel_phong3, cardP3, datphong103, xacnhan103, hoatdong103, pn_p103);
		manager3.start();
		quanLyPhong.add(manager3);
		panel_phong3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 103");
			}
		});
		
		

		JPanel panel_phong4 = new JPanel();
		panel_phong4.setBorder(border);
		panel_phong4.setBounds(737, 79, 200, 200);
		pn_sodophong.add(panel_phong4);
		panel_phong4.setLayout(null);
		JLabel lblNewLabel_6 = new JLabel("P_102");
		lblNewLabel_6.setBounds(10, 10, 70, 30);
		lblNewLabel_6.setFont(font);
		panel_phong4.add(lblNewLabel_6);
		JLabel photo4 = new JLabel("");
		photo4.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo4.setBounds(36, 50, 128, 128);
		panel_phong4.add(photo4);
		pn_DanghoatdongQL hoatdong104 = new pn_DanghoatdongQL(phong[3], this);
		pn_ChoxacnhanQL xacnhan104 = new pn_ChoxacnhanQL(phong[3], hoatdong104,  this);
		pn_DatphongQL datphong104 = new pn_DatphongQL(phong[3], xacnhan104, hoatdong104, this);
		CardLayout cardP4 = new CardLayout();
		pn_p104.setLayout(cardP4);
		pn_p104.add(datphong104, "datohong104");
		pn_p104.add(xacnhan104, "xacnhan104");
		pn_p104.add(hoatdong104, "hoatdong104");
		PhongManagerQL manager4 = new PhongManagerQL(phong[3], panel_phong4, cardP4, datphong104, xacnhan104, hoatdong104, pn_p104);
		manager4.start();
		quanLyPhong.add(manager4);
		panel_phong4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 104");
			}
		});
		

		JPanel panel_phong5 = new JPanel();
		panel_phong5.setBorder(border);
		panel_phong5.setBounds(10, 306, 200, 200);
		pn_sodophong.add(panel_phong5);
		panel_phong5.setLayout(null);
		JLabel lblNewLabel_7 = new JLabel("P_201");
		lblNewLabel_7.setBounds(10, 10, 70, 30);
		lblNewLabel_7.setFont(font);
		panel_phong5.add(lblNewLabel_7);
		JLabel photo5 = new JLabel("");
		photo5.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo5.setBounds(36, 50, 128, 128);
		panel_phong5.add(photo5);
		pn_DanghoatdongQL hoatdong201 = new pn_DanghoatdongQL(phong[4], this);
		pn_ChoxacnhanQL xacnhan201 = new pn_ChoxacnhanQL(phong[4], hoatdong201,  this);
		pn_DatphongQL datphong201 = new pn_DatphongQL(phong[4], xacnhan201, hoatdong201, this);
		CardLayout cardP5 = new CardLayout();
		pn_p201.setLayout(cardP5);
		pn_p201.add(datphong201, "datohong201");
		pn_p201.add(xacnhan201, "xacnhan201");
		pn_p201.add(hoatdong201, "hoatdong201");
		PhongManagerQL manager5 = new PhongManagerQL(phong[4], panel_phong5, cardP5, datphong201, xacnhan201, hoatdong201, pn_p201);
		manager5.start();
		quanLyPhong.add(manager5);
		panel_phong5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 201");
			}
		});
		
		
		
		JPanel panel_phong6 = new JPanel();
		panel_phong6.setBorder(border);
		panel_phong6.setBounds(10, 532, 200, 200);
		pn_sodophong.add(panel_phong6);
		panel_phong6.setLayout(null);
		JLabel lblNewLabel_11 = new JLabel("P_301");
		lblNewLabel_11.setBounds(10, 10, 70, 30);
		lblNewLabel_11.setFont(font);
		panel_phong6.add(lblNewLabel_11);
		JLabel photo6 = new JLabel("");
		photo6.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo6.setBounds(36, 50, 128, 128);
		panel_phong6.add(photo6);
		pn_DanghoatdongQL hoatdong202 = new pn_DanghoatdongQL(phong[5], this);
		pn_ChoxacnhanQL xacnhan202 = new pn_ChoxacnhanQL(phong[5], hoatdong202,  this);
		pn_DatphongQL datphong202 = new pn_DatphongQL(phong[5], xacnhan202, hoatdong202, this);
		CardLayout cardP6 = new CardLayout();
		pn_p202.setLayout(cardP6);
		pn_p202.add(datphong202, "datohong202");
		pn_p202.add(xacnhan202, "xacnhan202");
		pn_p202.add(hoatdong202, "hoatdong202");
		PhongManagerQL manager6 = new PhongManagerQL(phong[5], panel_phong6, cardP6, datphong202, xacnhan202, hoatdong202, pn_p202);
		manager6.start();
		quanLyPhong.add(manager6);
		panel_phong6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 202");
			}
		});
				

		JPanel panel_phong7 = new JPanel();
		panel_phong7.setBorder(border);
		panel_phong7.setBounds(252, 532, 200, 200);
		pn_sodophong.add(panel_phong7);
		panel_phong7.setLayout(null);
		JLabel lblNewLabel_12 = new JLabel("P_302");
		lblNewLabel_12.setBounds(10, 10, 70, 30);
		lblNewLabel_12.setFont(font);
		panel_phong7.add(lblNewLabel_12);
		JLabel photo7 = new JLabel("");
		photo7.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo7.setBounds(36, 50, 128, 128);
		panel_phong7.add(photo7);
		pn_DanghoatdongQL hoatdong203 = new pn_DanghoatdongQL(phong[6], this);
		pn_ChoxacnhanQL xacnhan203 = new pn_ChoxacnhanQL(phong[6], hoatdong203,  this);
		pn_DatphongQL datphong203 = new pn_DatphongQL(phong[6], xacnhan203, hoatdong203, this);
		
		CardLayout cardP7 = new CardLayout();
		pn_p203.setLayout(cardP7);
		pn_p203.add(datphong203, "datohong203");
		pn_p203.add(xacnhan203, "xacnhan203");
		pn_p203.add(hoatdong203, "hoatdong203");
		PhongManagerQL manager7 = new PhongManagerQL(phong[6], panel_phong7, cardP7, datphong203, xacnhan203, hoatdong203, pn_p203);
		manager7.start();
		quanLyPhong.add(manager7);
		panel_phong7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 203");
			}
		});
		
		
		JPanel panel_phong8 = new JPanel();
		panel_phong8.setBorder(border);
		panel_phong8.setBounds(498, 532, 200, 200);
		pn_sodophong.add(panel_phong8);
		panel_phong8.setLayout(null);
		JLabel lblNewLabel_13 = new JLabel("P_303");
		lblNewLabel_13.setBounds(10, 10, 70, 30);
		lblNewLabel_13.setFont(font);
		panel_phong8.add(lblNewLabel_13);
		JLabel photo8 = new JLabel("");
		photo8.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo8.setBounds(36, 50, 128, 128);
		panel_phong8.add(photo8);
		pn_DanghoatdongQL hoatdong204 = new pn_DanghoatdongQL(phong[7], this);
		pn_ChoxacnhanQL xacnhan204 = new pn_ChoxacnhanQL(phong[7], hoatdong204,  this);
		pn_DatphongQL datphong204 = new pn_DatphongQL(phong[7], xacnhan204, hoatdong204, this);
		CardLayout cardP8 = new CardLayout();
		pn_p204.setLayout(cardP8);
		pn_p204.add(datphong204, "datohong204");
		pn_p204.add(xacnhan204, "xacnhan204");
		pn_p204.add(hoatdong204, "hoatdong204");
		PhongManagerQL manager8 = new PhongManagerQL(phong[7], panel_phong8, cardP8, datphong204, xacnhan204, hoatdong204, pn_p204);
		manager8.start();
		quanLyPhong.add(manager8);
		panel_phong8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 204");
			}
		});

		

		JPanel panel_phong9 = new JPanel();
		panel_phong9.setBorder(border);
		panel_phong9.setBounds(737, 532, 200, 200);
		pn_sodophong.add(panel_phong9);
		panel_phong9.setLayout(null);
		JLabel lblNewLabel_14 = new JLabel("P_304");
		lblNewLabel_14.setBounds(10, 10, 70, 30);
		lblNewLabel_14.setFont(font);
		panel_phong9.add(lblNewLabel_14);
		JLabel photo9 = new JLabel("");
		photo9.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo9.setBounds(36, 50, 128, 128);
		panel_phong9.add(photo9);
		pn_DanghoatdongQL hoatdong301 = new pn_DanghoatdongQL(phong[8], this);
		pn_ChoxacnhanQL xacnhan301 = new pn_ChoxacnhanQL(phong[8], hoatdong301,  this);
		pn_DatphongQL datphong301 = new pn_DatphongQL(phong[8], xacnhan301, hoatdong301, this);
		CardLayout cardP9 = new CardLayout();
		pn_p301.setLayout(cardP9);
		pn_p301.add(datphong301, "datohong301");
		pn_p301.add(xacnhan301, "xacnhan301");
		pn_p301.add(hoatdong301, "hoatdong301");
		PhongManagerQL manager9 = new PhongManagerQL(phong[8], panel_phong9, cardP9, datphong301, xacnhan301, hoatdong301, pn_p301);
		manager9.start();
		quanLyPhong.add(manager9);
		panel_phong9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 301");
			}
		});

		

		JPanel panel_phong10 = new JPanel();
		panel_phong10.setBorder(border);
		panel_phong10.setBounds(737, 306, 200, 200);
		pn_sodophong.add(panel_phong10);
		panel_phong10.setLayout(null);
		JLabel lblNewLabel_10 = new JLabel("P_204");
		lblNewLabel_10.setBounds(10, 10, 70, 30);
		lblNewLabel_10.setFont(font);
		panel_phong10.add(lblNewLabel_10);
		JLabel photo10 = new JLabel("");
		photo10.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo10.setBounds(36, 50, 128, 128);
		panel_phong10.add(photo10);
		pn_DanghoatdongQL hoatdong302 = new pn_DanghoatdongQL(phong[9], this);
		pn_ChoxacnhanQL xacnhan302 = new pn_ChoxacnhanQL(phong[9], hoatdong302,  this);
		pn_DatphongQL datphong302 = new pn_DatphongQL(phong[9], xacnhan302, hoatdong302, this);
		CardLayout cardP10 =new  CardLayout();
		pn_p302.setLayout(cardP10);
		pn_p302.add(datphong302, "datohong302");
		pn_p302.add(xacnhan302, "xacnhan302");
		pn_p302.add(hoatdong302, "hoatdong302");
		PhongManagerQL manager10 = new PhongManagerQL(phong[9], panel_phong10, cardP10, datphong302, xacnhan302, hoatdong302, pn_p302);
		manager10.start();
		quanLyPhong.add(manager10);
		panel_phong10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 302");
			}
		});
		
		
		JPanel panel_phong11 = new JPanel();
		panel_phong11.setBorder(border);
		panel_phong11.setBounds(252, 306, 200, 200);
		pn_sodophong.add(panel_phong11);
		panel_phong11.setLayout(null);
		JLabel lblNewLabel_8 = new JLabel("P_202");
		lblNewLabel_8.setBounds(10, 10, 70, 30);
		lblNewLabel_8.setFont(font);
		panel_phong11.add(lblNewLabel_8);
		JLabel photo11 = new JLabel("");
		photo11.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo11.setBounds(36, 50, 128, 128);
		panel_phong11.add(photo11);
		pn_DanghoatdongQL hoatdong303 = new pn_DanghoatdongQL(phong[10], this);
		pn_ChoxacnhanQL xacnhan303 = new pn_ChoxacnhanQL(phong[10], hoatdong303,  this);
		pn_DatphongQL datphong303 = new pn_DatphongQL(phong[10], xacnhan303, hoatdong303, this);
		CardLayout cardP11 = new CardLayout();
		pn_p303.setLayout(cardP11);
		pn_p303.add(datphong303, "datohong303");
		pn_p303.add(xacnhan303, "xacnhan303");
		pn_p303.add(hoatdong303, "hoatdong303");
		PhongManagerQL manager11 = new PhongManagerQL(phong[10], panel_phong11, cardP11, datphong303, xacnhan303, hoatdong303, pn_p303);
		manager11.start();
		quanLyPhong.add(manager11);
		panel_phong11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 303");
			}
		});
		
		
		JPanel panel_phong12 = new JPanel();
		panel_phong12.setBorder(border);
		panel_phong12.setBounds(498, 306, 200, 200);
		pn_sodophong.add(panel_phong12);
		panel_phong12.setLayout(null);
		JLabel lblNewLabel_9 = new JLabel("P_203");
		lblNewLabel_9.setBounds(10, 10, 70, 30);
		lblNewLabel_9.setFont(font);
		panel_phong12.add(lblNewLabel_9);
		JLabel photo12 = new JLabel("");
		photo12.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/website.png")));
		photo12.setBounds(36, 50, 128, 128);
		panel_phong12.add(photo12);
		pn_DanghoatdongQL hoatdong304 = new pn_DanghoatdongQL(phong[11], this);
		pn_ChoxacnhanQL xacnhan304 = new pn_ChoxacnhanQL(phong[11], hoatdong304,  this);
		pn_DatphongQL datphong304 = new pn_DatphongQL(phong[11], xacnhan304, hoatdong304, this);
		CardLayout cardP12 = new CardLayout();
		pn_p304.setLayout(cardP12);
		pn_p304.add(datphong304, "datohong304");
		pn_p304.add(xacnhan304, "xacnhan304");
		pn_p304.add(hoatdong304, "hoatdong304");
		PhongManagerQL manager12 = new PhongManagerQL(phong[11], panel_phong12, cardP12, datphong304, xacnhan304, hoatdong304, pn_p304);
		manager12.start();
		quanLyPhong.add(manager12);
		panel_phong12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardhd.show(pn_hoatdong, "phong 304");
			}
		});
		
		
		JLabel lbanhtrangchu = new JLabel("");
		lbanhtrangchu.setIcon(new ImageIcon(ManagerUI.class.getResource("/FileAnh/anhksan.png")));
		JPanel pn_thongke = new JPanel();
		pn_hoatdong.add(pn_thongke, "thống kê");
		pn_thongke.setLayout(null);
		bt_Thongke.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardhd.show(pn_hoatdong, "thống kê");
			}
		});

		JPanel pn_tkdoanhthu = new JPanel();
		pn_tkdoanhthu.setBounds(80, 400, 380, 280);
		pn_thongke.add(pn_tkdoanhthu);
		JPanel pn_tkusedevice = new JPanel();
		pn_tkusedevice.setBounds(500, 400, 380, 280);
		pn_thongke.add(pn_tkusedevice);

		JPanel pn_tktyle = new JPanel();
		pn_tktyle.setBounds(500, 80, 380, 280);
		pn_thongke.add(pn_tktyle);

		JPanel pn_tsoluong = new JPanel();
		pn_tsoluong.setBounds(80, 80, 380, 280);
		pn_thongke.add(pn_tsoluong);
		pn_trangchu.add(lbanhtrangchu);

		JPanel pn_tbaydt = new JPanel();
		pn_hoatdong.add(pn_tbaydt, "name_637252375900");

		JPanel pn_tbaylosuong = new JPanel();
		pn_hoatdong.add(pn_tbaylosuong, "name_705300740500");

		JPanel pn_tbaydichvu = new JPanel();
		pn_hoatdong.add(pn_tbaydichvu, "name_707917130400");

		JPanel pn_tbaytyle = new JPanel();
		pn_hoatdong.add(pn_tbaytyle, "name_710042359100");

		JPanel pn_baocao = new JPanel();
		pn_hoatdong.add(pn_baocao, "báo cáo");
		bt_baocao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardhd.show(pn_hoatdong, "báo cáo");
			}
		});
		pn_baocao.setLayout(null);

		JPanel pn_xuatbaocao = new JPanel();
		pn_xuatbaocao.setBounds(29, 23, 231, 209);
		pn_baocao.add(pn_xuatbaocao);

		JPanel pn_ghichu = new JPanel();
		pn_ghichu.setBounds(308, 23, 231, 209);
		pn_baocao.add(pn_ghichu);

		
		
		//add vào panel hoạt động và đặt tên
		pn_hoatdong.add(pn_p101, "phong 101");
		pn_hoatdong.add(pn_p102, "phong 102");
		pn_hoatdong.add(pn_p103, "phong 103");
		pn_hoatdong.add(pn_p104, "phong 104");
		pn_hoatdong.add(pn_p201, "phong 201");
		pn_hoatdong.add(pn_p202, "phong 202");
		pn_hoatdong.add(pn_p203, "phong 203");
		pn_hoatdong.add(pn_p204, "phong 204");
		pn_hoatdong.add(pn_p301, "phong 301");
		pn_hoatdong.add(pn_p302, "phong 302");
		pn_hoatdong.add(pn_p303, "phong 303");
		pn_hoatdong.add(pn_p304, "phong 304");

	}
	
	
    public JPanel getPn_sodophong() {
		return pn_sodophong;
	}

	public void setPn_sodophong(JPanel pn_sodophong) {
		this.pn_sodophong = pn_sodophong;
	}


	private static class RoundedBorder implements Border {
        private final int arcWidth;
        private final int arcHeight;
        private final Color color;

        public RoundedBorder(int arcWidth, int arcHeight, Color color) {
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            this.color = color;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcWidth, arcHeight));
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(arcHeight / 2, arcWidth / 2, arcHeight / 2, arcWidth / 2);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }
	//phương thức kết nối database
	
	public boolean CheckDPKH(String MaDP, int maphong) {
		if(MaDP.equals(key_room.get(maphong))) {
			return true;
		} else return false;
	}
	
	public String laymakh(String username) throws SQLException {
		String makh = null;
		try (Connection connection = connectdatabase.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT MAKH FROM customer WHERE USERNAME = ?");) {

			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				makh = resultSet.getString("MAKH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return makh;

	}

	public boolean CheckIn(String username, String pass) throws SQLException {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet rs = null;

		try {
			// Get a connection to the database
			connection = connectdatabase.getConnection();

			// SQL query to get the encoded password from the database
			String sql = "SELECT PASS FROM customer WHERE USERNAME = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);

			// Execute the query
			resultSet = preparedStatement.executeQuery();

			// Check if the result set has any rows
			if (resultSet.next()) {
				// Get the encoded password from the database
				String passwordFromDB = resultSet.getString("PASS");
				
				// Encode the input password with the same salt
				String salt = "asdfghjkl";
				String str = pass + salt;
				String encodedPass = Base64.getEncoder().encodeToString(str.getBytes());
				System.out.println(encodedPass);
				// Check if the encoded password matches the password from the database
				if (encodedPass.equals(passwordFromDB)) {
					
					result = true;
				} else {
					// Login failed
					
					result = false;
				}
			} else {
				// Login failed
				result = false;
			}
		} finally {
			// Close resources in the reverse order of their creation to avoid resource
			// leaks
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return result;
	}
	
	public void DangKy(String hoten, String cccd, String email, String sdt, String username, String pass) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        // Mã hóa mật khẩu
	        String salt = "asdfghjkl";
	        String str = pass + salt;
	        String encodedPass = Base64.getEncoder().encodeToString(str.getBytes());
	        System.out.println(encodedPass);

	        // Tạo kết nối đến cơ sở dữ liệu
	        connection = connectdatabase.getConnection();
	        String lastThreeDigits = sdt.substring(sdt.length() - 3);
	        String makh = TaoMaKH(lastThreeDigits);
	        // Chuẩn bị câu lệnh SQL để thêm người dùng mới
//insert ma khách hàng
	        String sql = "INSERT INTO customer (MAKH,HOTEN, CCCD, SDT, EMAIL, PASS, USERNAME) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        preparedStatement = connection.prepareStatement(sql);

	        // Gán giá trị cho các tham số
	        preparedStatement.setString(1, makh);
	        preparedStatement.setString(2, hoten);
	        preparedStatement.setString(3, cccd);
	        preparedStatement.setString(4, sdt);
	        preparedStatement.setString(5, email);
	        preparedStatement.setString(6, encodedPass);
	        preparedStatement.setString(7, username);

	        // Thực thi câu lệnh SQL
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	        } else {
	            JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi đăng ký tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        // Đóng các tài nguyên
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public boolean KiemTraTonTai(String username, String cccd) {
		   Connection connection = null;
		   PreparedStatement preparedStatement = null;
		   ResultSet resultSet = null;
		   boolean isDuplicated = false;

		   try {
		       // Tạo kết nối đến cơ sở dữ liệu
		       connection = connectdatabase.getConnection();

		       // Chuẩn bị câu lệnh SQL để kiểm tra username và CCCD
		       String sql = "SELECT COUNT(*) FROM customer WHERE USERNAME = ? OR CCCD = ?";
		       preparedStatement = connection.prepareStatement(sql);
		       preparedStatement.setString(1, username);
		       preparedStatement.setString(2, cccd);

		       // Thực thi câu lệnh SQL
		       resultSet = preparedStatement.executeQuery();

		       // Kiểm tra kết quả
		       if (resultSet.next()) {
		           int count = resultSet.getInt(1);
		           isDuplicated = count > 0;
		       }
		   } catch (SQLException e) {
		       e.printStackTrace();
		   } finally {
		       // Đóng các tài nguyên
		       try {
		           if (resultSet != null) {
		               resultSet.close();
		           }
		           if (preparedStatement != null) {
		               preparedStatement.close();
		           }
		           if (connection != null) {
		               connection.close();
		           }
		       } catch (SQLException e) {
		           e.printStackTrace();
		       }
		   }

		   return isDuplicated;
	}

	// Truy vấn dữ liệu để đăng nhập
	public boolean kiemtraxacthuc(String tendangnhap, String email) throws SQLException {
		boolean isValid = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// Get a connection to the database
			connection = connectdatabase.getConnection();

			// SQL query to check if the information is valid
			String sql = "SELECT * FROM customer WHERE USERNAME = ? AND EMAIL = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tendangnhap);
			preparedStatement.setString(2, email);

			// Execute the query
			resultSet = preparedStatement.executeQuery();

			// Check if the result set has any rows
			isValid = resultSet.next();
		} finally {
			// Close resources in the reverse order of their creation
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return isValid;

	}

	public boolean capNhatMatKhau(String tendangnhap, String newpass) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Get a connection to the database
			connection = connectdatabase.getConnection();

			// Encode the new password with salt
			String salt = "asdfghjkl";
			String str = newpass + salt;
			String passnew = Base64.getEncoder().encodeToString(str.getBytes());

			// SQL query to update the password
			String sql = "UPDATE customer SET PASS = ? WHERE USERNAME = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, passnew);
			preparedStatement.setString(2, tendangnhap);

			// Execute the update query
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {

				return true;
			} else {

				return false;
			}
		} finally {
			// Close resources in the reverse order of their creation
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public String phantichgia(int gia) {
		String s = new String();
		int dong = 0, trieu = 0, nghin = 0, copy = gia;
		String dongs = null, trieus = null, nghins = null;
		if(copy>0) {
			dong = copy%1000;
			copy/=1000;
			if(copy>0) {
				nghin = copy%1000;
				copy/=1000;
				if(copy>0) {
					trieu = copy%1000;
				}
			}
		}
		if(trieu>0&&trieu<=99) {
			trieus =  "0"+dong;
		} else if(trieu == 0){
			trieus = "000";
		} else if(trieu>99) {
			trieus = dong+"";
		}
		if(dong>0&&dong<=99) {
			dongs =  "0"+dong;
		} else if(dong == 0){
			dongs = "000";
		} else if(dong>99) {
			dongs = dong+"";
		}
		
		if(nghin>0&&nghin<=99) {
			nghins =  "0"+nghin;
		} else if(nghin == 0){
			nghins = "000";
		} else if(nghin>99) {
			nghins = nghin+"";
		}
		
		if(gia>=1000000) {
			s = trieu+"."+nghins+"."+dongs+" VND";
		} else s = nghin+"."+dongs+" VND";
		return s;
	}
	
	//phương thức tạo mã khách hàng khi tạo tài khoản
	public String TaoMaKH(String soduoi) {
		LocalDateTime now = LocalDateTime.now();
	    String dateTimeString = now.format(DATE_TIME_FORMATTER);
		return  soduoi + dateTimeString;
	}
	
	private int taomaDatphong() { 
        Random random = new Random();
        int randomNumber = random.nextInt(89999) + 10000;
        return randomNumber;
    }


	public void Order(int maphong, int madv, int soluong) {
		for (PhongManagerQL phongql : quanLyPhong) {
			if(phongql.phong.getId() == maphong) {
				phongql.hoatdong.dbsau.addRow(new Object[] { danhsachDV[madv].getTenDichvu(), phantichgia(danhsachDV[madv].getGiaca()),
						soluong, phantichgia(danhsachDV[madv].getGiaca() * soluong) });
			}
		}
	}
	

	
//	public String truyendulieu() {
//		JsonArray mangthongtin = new JsonArray();
//		Gson gson = new Gson();
//		
//		for (PhongManagerQL phongql : quanLyPhong) {
//			if(phongql.phong.getTrangThai()==TrangThaiPhong.TRONG) {
//				Modelthongtinphong thongtin = new Modelthongtinphong(TrangThaiPhong.TRONG, null, null, null, null, null, null, null, null);
//				String json = gson.toJson(thongtin);
//				mangthongtin.add(json);
//			} else if (phongql.phong.getTrangThai()==TrangThaiPhong.CHO_XAC_NHAN) {
//				Modelthongtinphong thongtin = new Modelthongtinphong();
//				thongtin.setTrangthai(TrangThaiPhong.CHO_XAC_NHAN);
//				thongtin.setCccd(phongql.xacnhan.TCCCD.getText());
//				thongtin.setHoten(phongql.xacnhan.THovaten.getText());
//				int madp = Integer.parseInt(phongql.xacnhan.TMadatphong.getText());
//				thongtin.setSdth(phongql.xacnhan.TSdth.getText());
//				thongtin.setNgayvao(null);
//				thongtin.setMadp(madp);
//				thongtin.setMakh(phongql.xacnhan.TMaKH.getText());
//				ArrayList<ModelDVTruoc> dichvutrc = new ArrayList<ModelDVTruoc>();
//				for (int row = 0; row < phongql.xacnhan.db.getRowCount(); row++) {
//					ModelDVTruoc dvtrc = new ModelDVTruoc();
//					dvtrc.setTendv(phongql.xacnhan.db.getValueAt(row, 0)+"");
//					int giatien = convert(phongql.xacnhan.db.getValueAt(row, 1)+"");
//					dvtrc.setGia(giatien);
//					dichvutrc.add(dvtrc);
//					
//				}
//				thongtin.setDvtruoc(dichvutrc);
//				thongtin.setDvsau(null);
//				String json = gson.toJson(thongtin);
//				mangthongtin.add(json);
//			} else {
//				Modelthongtinphong thongtin = new Modelthongtinphong();
//				thongtin.setTrangthai(TrangThaiPhong.DANG_HOAT_DONG);
//				thongtin.setCccd(phongql.hoatdong.TCCCD.getText());
//				thongtin.setHoten(phongql.hoatdong.THovaten.getText());
//				int madp = Integer.parseInt(phongql.hoatdong.TMadatphong.getText());
//				thongtin.setMadp(madp);
//				thongtin.setSdth(phongql.hoatdong.TSDTH.getText());
//				thongtin.setNgayvao(phongql.hoatdong.TNgayGioNHanPhong.getText());
//				thongtin.setMakh(phongql.hoatdong.TMaKH.getText());
//				ArrayList<ModelDVTruoc> dichvutrc = new ArrayList<ModelDVTruoc>();
//				for (int row = 0; row < phongql.hoatdong.db.getRowCount(); row++) {
//					ModelDVTruoc dvtrc = new ModelDVTruoc();
//					dvtrc.setTendv(phongql.hoatdong.db.getValueAt(row, 0)+"");
//					int giatien = convert(phongql.hoatdong.db.getValueAt(row, 1)+"");
//					dvtrc.setGia(giatien);
//					dichvutrc.add(dvtrc);
//					
//				}
//				thongtin.setDvtruoc(dichvutrc);
//				ArrayList<ModelDVSau> dichvusau = new ArrayList<ModelDVSau>();
//				for (int row = 0; row < phongql.hoatdong.dbsau.getRowCount(); row++) {
//					ModelDVSau dvsau = new ModelDVSau();
//					dvsau.setTendv(phongql.hoatdong.dbsau.getValueAt(row, 0)+"");
//					int giatien = convert(phongql.hoatdong.dbsau.getValueAt(row, 1)+"");
//					dvsau.setDongia(giatien);
//					int soluong = Integer.parseInt(phongql.hoatdong.dbsau.getValueAt(row, 2)+"");
//					dvsau.setSoluong(soluong);
//					int thanhtien = convert(phongql.hoatdong.dbsau.getValueAt(row, 3)+"");
//					dvsau.setThanhtien(thanhtien);
//					dichvusau.add(dvsau);
//				}
//				thongtin.setDvsau(dichvusau);
//				String json = gson.toJson(thongtin);
//				mangthongtin.add(json);
//			}
//		}
//
//		return mangthongtin.toString();
//	}
	
	public int booking(String chuoithongtin) {
		Gson tt = new Gson();
		Modelchuoi chuoi = tt.fromJson(chuoithongtin, Modelchuoi.class);
		//Xử lý đặt phòng
		int madp = taomaDatphong();
		key_room.put(chuoi.getMaphong(), madp+"");
		dulieudp.put(chuoi.getMaKhachHang(), madp);
		if(chuoi.getTrangthai() == TrangThaiPhong.CHO_XAC_NHAN) {
			for (PhongManagerQL phongql : quanLyPhong) {
				if(phongql.phong.getId() == chuoi.getMaphong()) {
					phongql.phong.setTrangThai(TrangThaiPhong.CHO_XAC_NHAN);
					phongql.xacnhan.TMadatphong.setText(madp+"");
					phongql.xacnhan.TMaKH.setText(chuoi.getMaKhachHang());
					phongql.xacnhan.THovaten.setText(chuoi.getHoVaTen());
					phongql.xacnhan.TCCCD.setText(chuoi.getCccd());
					phongql.xacnhan.TSdth.setText(chuoi.getSdt());
					if(chuoi.isChoThueXe()) phongql.xacnhan.db.addRow(new Object[] {
						"Cho thuê xe tự lái",  phantichgia(danhsachDV[9].getGiaca())});				
					if(chuoi.isDuaDonSanBay()) phongql.xacnhan.db.addRow(new Object[] {
							"Đưa đón sân bay", phantichgia(danhsachDV[11].getGiaca())});
					if(chuoi.isDungDiemTam()) phongql.xacnhan.db.addRow(new Object[] {
							"Dùng điểm tâm", phantichgia(danhsachDV[10].getGiaca())});
					if(chuoi.isTrongTre()) phongql.xacnhan.db.addRow(new Object[] {
							"Trông trẻ", phantichgia(danhsachDV[12].getGiaca())});
					if(chuoi.isTuanTrangMat()) phongql.xacnhan.db.addRow(new Object[] {
							"Tuần trăng mật", phantichgia(danhsachDV[13].getGiaca())});
					if(chuoi.isGiatui()) phongql.xacnhan.db.addRow(new Object[] {
							"Giặt ủi", phantichgia(danhsachDV[14].getGiaca())});
					if(chuoi.isSpa()) phongql.xacnhan.db.addRow(new Object[] {
							"Spa", phantichgia(danhsachDV[15].getGiaca())});
					if(chuoi.isFitness()) phongql.xacnhan.db.addRow(new Object[] {
							"Fitness", phantichgia(danhsachDV[16].getGiaca())});
				}
			}
		} else if(chuoi.getTrangthai() == TrangThaiPhong.DANG_HOAT_DONG) {
			for (PhongManagerQL phongql : quanLyPhong) {
				if(phongql.phong.getId() == chuoi.getMaphong()) {
					phongql.phong.setTrangThai(TrangThaiPhong.DANG_HOAT_DONG);
					phongql.hoatdong.TMadatphong.setText(madp+"");
					phongql.hoatdong.TMaKH.setText(chuoi.getMaKhachHang());
					phongql.hoatdong.THovaten.setText(chuoi.getHoVaTen());
					phongql.hoatdong.TCCCD.setText(chuoi.getCccd());
					phongql.hoatdong.TNgayGioNHanPhong.setText(chuoi.getngaygiovaophong());
					if(chuoi.isChoThueXe()) phongql.hoatdong.db.addRow(new Object[] {
						"Cho thuê xe tự lái",  phantichgia(danhsachDV[9].getGiaca())});				
					if(chuoi.isDuaDonSanBay()) phongql.hoatdong.db.addRow(new Object[] {
							"Đưa đón sân bay", phantichgia(danhsachDV[11].getGiaca())});
					if(chuoi.isDungDiemTam()) phongql.hoatdong.db.addRow(new Object[] {
							"Dùng điểm tâm", phantichgia(danhsachDV[10].getGiaca())});
					if(chuoi.isTrongTre()) phongql.hoatdong.db.addRow(new Object[] {
							"Trông trẻ", phantichgia(danhsachDV[12].getGiaca())});
					if(chuoi.isTuanTrangMat()) phongql.hoatdong.db.addRow(new Object[] {
							"Tuần trăng mật", phantichgia(danhsachDV[13].getGiaca())});
					if(chuoi.isGiatui()) phongql.hoatdong.db.addRow(new Object[] {
							"Giặt ủi", phantichgia(danhsachDV[14].getGiaca())});
					if(chuoi.isSpa()) phongql.hoatdong.db.addRow(new Object[] {
							"Spa", phantichgia(danhsachDV[15].getGiaca())});
					if(chuoi.isFitness()) phongql.hoatdong.db.addRow(new Object[] {
							"Fitness", phantichgia(danhsachDV[16].getGiaca())});
				}
			}
		}
		
		for (ClientThread clientThread : clients) {
			clientThread.dongbohoa();
		}
		return madp;
	}
	
	public void xacnhan(int maphong, String tgian) {
		for (PhongManagerQL phongql : quanLyPhong) {
			if(phongql.phong.getId() == maphong) {
				phongql.xacnhan.datphong(phongql.hoatdong, phongql.phong, tgian);
			}
		}
	}
	
	public void cancel(int maphong) {
		for (PhongManagerQL phongql : quanLyPhong) {
			if(phongql.phong.getId() == maphong) {
				phongql.xacnhan.huyphong(phongql.phong, this);
			}
		}
	}
	


	//tao modelchuoi để lưu
	
	public static int convert(String input) {
	    // Loại bỏ ký tự "VND" và dấu chấm phẩy
	    String cleanedInput = input.replaceAll("[^0-9]", "");
	    
	    // Chuyển đổi chuỗi thành số nguyên kiểu int
	    int value = Integer.parseInt(cleanedInput);
	    
	    return value;
	}

	public String truyenthongtin(String username) {
	    try (
	    	Connection connection = connectdatabase.getConnection();
	         PreparedStatement statement = connection.prepareStatement("SELECT MAKH, HOTEN, CCCD, SDT, EMAIL FROM customer WHERE USERNAME = ?");) {

	        statement.setString(1, username);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String makh = resultSet.getString("MAKH");
	            String hoten = resultSet.getString("HOTEN");
	            String cccd = resultSet.getString("CCCD");
	            String sdt = resultSet.getString("SDT");
	            String email = resultSet.getString("EMAIL");

	            // Tạo đối tượng ModelKhachHang và đặt các thuộc tính
	            ModelKhachHang khachHang = new ModelKhachHang();
	            khachHang.setMakhachhang(makh);
	            khachHang.setHoten(hoten);
	            khachHang.setCccd(cccd);
	            khachHang.setSdt(sdt);
	            khachHang.setEmail(email);
	            

	            // Sử dụng Gson để chuyển đối tượng thành chuỗi JSON
	            Gson gson = new Gson();
	            String thongtin = gson.toJson(khachHang);

	            // In chuỗi JSON ra console hoặc xử lý theo yêu cầu

	            return thongtin;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
	
	
}