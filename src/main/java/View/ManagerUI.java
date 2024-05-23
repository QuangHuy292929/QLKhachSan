package View;

import java.awt.EventQueue;       

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.UIManager;

import javax.swing.JLabel;
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
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import Model.Phong;
import Model.Phong.TrangThaiPhong;
import controller.PhongManager;
import controller.connectdatabase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Phong[] phong;
	private UserUI ngdung;
	JPanel pn_trangchu;
	JPanel pn_sodophong;
	JPanel pn_hoatdong;
    Color colordat = new Color(205, 180, 219);
    Color colorchoxacnhan = new Color(255, 200, 221);
	public CardLayout cardhd;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new ManagerUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
  
		ArrayList<PhongManager> quanLyPhong = new ArrayList<PhongManager>();
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
		
		phong = new Phong[]{
				new Phong(101, "Phòng 101", TrangThaiPhong.TRONG),
				new Phong(102, "Phòng 102", TrangThaiPhong.CHO_XAC_NHAN),
				new Phong(103, "Phòng 103", TrangThaiPhong.DANG_HOAT_DONG),
				new Phong(104, "Phòng 104", TrangThaiPhong.TRONG),
				new Phong(201, "Phòng 201", TrangThaiPhong.TRONG),
				new Phong(202, "Phòng 202", TrangThaiPhong.TRONG),
				new Phong(203, "Phòng 203", TrangThaiPhong.TRONG),
				new Phong(204, "Phòng 204", TrangThaiPhong.DANG_HOAT_DONG),
				new Phong(301, "Phòng 301", TrangThaiPhong.TRONG),
				new Phong(302, "Phòng 302", TrangThaiPhong.TRONG),
				new Phong(303, "Phòng 303", TrangThaiPhong.TRONG),
				new Phong(304, "Phòng 304", TrangThaiPhong.TRONG),
		};

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
		pn_Danghoatdong hoatdong101 = new pn_Danghoatdong(phong[0], ngdung);
		pn_Choxacnhan xacnhan101 = new pn_Choxacnhan(phong[0], hoatdong101,  ngdung);
		pn_Datphong datphong101 = new pn_Datphong(phong[0], xacnhan101, hoatdong101, ngdung);
		CardLayout cardP1 = new CardLayout();
		pn_p101.setLayout(cardP1);
		pn_p101.add(datphong101, "datohong101");
		pn_p101.add(xacnhan101, "xacnhan101");
		pn_p101.add(hoatdong101, "hoatdong101");
		PhongManager manager1 = new PhongManager(phong[0], panel_phong1, cardP1, datphong101, xacnhan101, hoatdong101, pn_p101);
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
		pn_Danghoatdong hoatdong102 = new pn_Danghoatdong(phong[1], ngdung);
		pn_Choxacnhan xacnhan102 = new pn_Choxacnhan(phong[1], hoatdong102,  ngdung);
		pn_Datphong datphong102 = new pn_Datphong(phong[1], xacnhan102, hoatdong102, ngdung);
		CardLayout cardP2 = new CardLayout();
		pn_p102.setLayout(cardP2);
		pn_p102.add(datphong102, "datohong102");
		pn_p102.add(xacnhan102, "xacnhan102");
		pn_p102.add(hoatdong102, "hoatdong102");
		PhongManager manager2 = new PhongManager(phong[1], panel_phong2, cardP2, datphong102, xacnhan102, hoatdong102, pn_p102);
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
		pn_Danghoatdong hoatdong103 = new pn_Danghoatdong(phong[2], ngdung);
		pn_Choxacnhan xacnhan103 = new pn_Choxacnhan(phong[2], hoatdong103,  ngdung);
		pn_Datphong datphong103 = new pn_Datphong(phong[2], xacnhan103, hoatdong103, ngdung);
		CardLayout cardP3 = new CardLayout();
		pn_p103.setLayout(cardP3);
		pn_p103.add(datphong103, "datohong103");
		pn_p103.add(xacnhan103, "xacnhan103");
		pn_p103.add(hoatdong103, "hoatdong103");
		PhongManager manager3 = new PhongManager(phong[2], panel_phong3, cardP3, datphong103, xacnhan103, hoatdong103, pn_p103);
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
		pn_Danghoatdong hoatdong104 = new pn_Danghoatdong(phong[3], ngdung);
		pn_Choxacnhan xacnhan104 = new pn_Choxacnhan(phong[3], hoatdong104,  ngdung);
		pn_Datphong datphong104 = new pn_Datphong(phong[3], xacnhan104, hoatdong104, ngdung);
		CardLayout cardP4 = new CardLayout();
		pn_p104.setLayout(cardP4);
		pn_p104.add(datphong104, "datohong104");
		pn_p104.add(xacnhan104, "xacnhan104");
		pn_p104.add(hoatdong104, "hoatdong104");
		PhongManager manager4 = new PhongManager(phong[3], panel_phong4, cardP4, datphong104, xacnhan104, hoatdong104, pn_p104);
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
		pn_Danghoatdong hoatdong201 = new pn_Danghoatdong(phong[4], ngdung);
		pn_Choxacnhan xacnhan201 = new pn_Choxacnhan(phong[4], hoatdong201,  ngdung);
		pn_Datphong datphong201 = new pn_Datphong(phong[4], xacnhan201, hoatdong201, ngdung);
		CardLayout cardP5 = new CardLayout();
		pn_p201.setLayout(cardP5);
		pn_p201.add(datphong201, "datohong201");
		pn_p201.add(xacnhan201, "xacnhan201");
		pn_p201.add(hoatdong201, "hoatdong201");
		PhongManager manager5 = new PhongManager(phong[4], panel_phong5, cardP5, datphong201, xacnhan201, hoatdong201, pn_p201);
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
		pn_Danghoatdong hoatdong202 = new pn_Danghoatdong(phong[5], ngdung);
		pn_Choxacnhan xacnhan202 = new pn_Choxacnhan(phong[5], hoatdong202,  ngdung);
		pn_Datphong datphong202 = new pn_Datphong(phong[5], xacnhan202, hoatdong202, ngdung);
		CardLayout cardP6 = new CardLayout();
		pn_p202.setLayout(cardP6);
		pn_p202.add(datphong202, "datohong202");
		pn_p202.add(xacnhan202, "xacnhan202");
		pn_p202.add(hoatdong202, "hoatdong202");
		PhongManager manager6 = new PhongManager(phong[5], panel_phong6, cardP6, datphong202, xacnhan202, hoatdong202, pn_p202);
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
		pn_Danghoatdong hoatdong203 = new pn_Danghoatdong(phong[6], ngdung);
		pn_Choxacnhan xacnhan203 = new pn_Choxacnhan(phong[6], hoatdong203,  ngdung);
		pn_Datphong datphong203 = new pn_Datphong(phong[6], xacnhan203, hoatdong203, ngdung);
		
		CardLayout cardP7 = new CardLayout();
		pn_p203.setLayout(cardP7);
		pn_p203.add(datphong203, "datohong203");
		pn_p203.add(xacnhan203, "xacnhan203");
		pn_p203.add(hoatdong203, "hoatdong203");
		PhongManager manager7 = new PhongManager(phong[6], panel_phong7, cardP7, datphong203, xacnhan203, hoatdong203, pn_p203);
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
		pn_Danghoatdong hoatdong204 = new pn_Danghoatdong(phong[7], ngdung);
		pn_Choxacnhan xacnhan204 = new pn_Choxacnhan(phong[7], hoatdong204,  ngdung);
		pn_Datphong datphong204 = new pn_Datphong(phong[7], xacnhan204, hoatdong204, ngdung);
		CardLayout cardP8 = new CardLayout();
		pn_p204.setLayout(cardP8);
		pn_p204.add(datphong204, "datohong204");
		pn_p204.add(xacnhan204, "xacnhan204");
		pn_p204.add(hoatdong204, "hoatdong204");
		PhongManager manager8 = new PhongManager(phong[7], panel_phong8, cardP8, datphong204, xacnhan204, hoatdong204, pn_p204);
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
		pn_Danghoatdong hoatdong301 = new pn_Danghoatdong(phong[8], ngdung);
		pn_Choxacnhan xacnhan301 = new pn_Choxacnhan(phong[8], hoatdong301,  ngdung);
		pn_Datphong datphong301 = new pn_Datphong(phong[8], xacnhan301, hoatdong301, ngdung);
		CardLayout cardP9 = new CardLayout();
		pn_p301.setLayout(cardP9);
		pn_p301.add(datphong301, "datohong301");
		pn_p301.add(xacnhan301, "xacnhan301");
		pn_p301.add(hoatdong301, "hoatdong301");
		PhongManager manager9 = new PhongManager(phong[8], panel_phong9, cardP9, datphong301, xacnhan301, hoatdong301, pn_p301);
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
		pn_Danghoatdong hoatdong302 = new pn_Danghoatdong(phong[9], ngdung);
		pn_Choxacnhan xacnhan302 = new pn_Choxacnhan(phong[9], hoatdong302,  ngdung);
		pn_Datphong datphong302 = new pn_Datphong(phong[9], xacnhan302, hoatdong302, ngdung);
		CardLayout cardP10 =new  CardLayout();
		pn_p302.setLayout(cardP10);
		pn_p302.add(datphong302, "datohong302");
		pn_p302.add(xacnhan302, "xacnhan302");
		pn_p302.add(hoatdong302, "hoatdong302");
		PhongManager manager10 = new PhongManager(phong[9], panel_phong10, cardP10, datphong302, xacnhan302, hoatdong302, pn_p302);
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
		pn_Danghoatdong hoatdong303 = new pn_Danghoatdong(phong[10], ngdung);
		pn_Choxacnhan xacnhan303 = new pn_Choxacnhan(phong[10], hoatdong303,  ngdung);
		pn_Datphong datphong303 = new pn_Datphong(phong[10], xacnhan303, hoatdong303, ngdung);
		CardLayout cardP11 = new CardLayout();
		pn_p303.setLayout(cardP11);
		pn_p303.add(datphong303, "datohong303");
		pn_p303.add(xacnhan303, "xacnhan303");
		pn_p303.add(hoatdong303, "hoatdong303");
		PhongManager manager11 = new PhongManager(phong[10], panel_phong11, cardP11, datphong303, xacnhan303, hoatdong303, pn_p303);
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
		pn_Danghoatdong hoatdong304 = new pn_Danghoatdong(phong[11], ngdung);
		pn_Choxacnhan xacnhan304 = new pn_Choxacnhan(phong[11], hoatdong304,  ngdung);
		pn_Datphong datphong304 = new pn_Datphong(phong[11], xacnhan304, hoatdong304, ngdung);
		CardLayout cardP12 = new CardLayout();
		pn_p304.setLayout(cardP12);
		pn_p304.add(datphong304, "datohong304");
		pn_p304.add(xacnhan304, "xacnhan304");
		pn_p304.add(hoatdong304, "hoatdong304");
		PhongManager manager12 = new PhongManager(phong[11], panel_phong12, cardP12, datphong304, xacnhan304, hoatdong304, pn_p304);
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
		//if()
		return true;
		//else return false;
	}
	
	
	public boolean CheckIn(String username, String pass) throws SQLException {
		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

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
					// Login successful
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
	
	public void DangKy(String Username, String CCCD, String Sdth, String email, String mk) {
		//hàm insert một đối tượng tài khoản
	}
	
	public boolean KiemTraTonTai(String Username, String CCCD) {
		//hàm kiểm tra database đã có(CCCD và Username) nếu chưa thì cho đky
		return true;
	}
	
	public void Order() {
		
	}
	
	
}