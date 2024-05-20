package View;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.UIManager;

import javax.swing.JLabel;
import java.awt.BorderLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;

import Model.Phong;
import Model.Phong.TrangThaiPhong;
import controller.PhongManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class DemoQuanLy extends JFrame {

	private static final long serialVersionUID = 1L;
	private Phong[] phong;
	private void closeWindow() {
		   
	    this.setVisible(false);
	    this.dispose();
	}
	
	JPanel pn_trangchu;
	JPanel pn_sodophong;
	JPanel pn_hoatdong;
    Color colordat = new Color(205, 180, 219);
    Color colorchoxacnhan = new Color(255, 200, 221);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new DemoQuanLy();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemoQuanLy() {
		setTitle("MANAGER-HOTEL");
		getContentPane().setBackground(new Color(204, 255, 255));
		
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
		CardLayout cardhd = new CardLayout();
		pn_hoatdong.setLayout(cardhd);

		JButton bt_trangchu = new JButton("Trang chủ");
		bt_trangchu.setIcon(new ImageIcon(DemoQuanLy.class.getResource("/fileanh/trangchu.png")));
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

		JButton bt_Thongke = new JButton("Thống Kê ");
		bt_Thongke.setIcon(new ImageIcon(DemoQuanLy.class.getResource("/fileanh/pie-chart.png")));
		bt_Thongke.setBackground(new Color(102, 102, 102));
		bt_Thongke.setBounds(2, 71, 207, 67);
		bt_Thongke.setFont(font2);
		pn_menu.add(bt_Thongke);

		JButton bt_thongtinkhachhang = new JButton("<html>Thông Tin<br>Khách Hàng</html>");
		bt_thongtinkhachhang.setIcon(new ImageIcon(DemoQuanLy.class.getResource("/fileanh/report.png")));
		bt_thongtinkhachhang.setBackground(new Color(102, 102, 102));
		bt_thongtinkhachhang.setBounds(2, 140, 207, 67);
		bt_thongtinkhachhang.setFont(font2);
		pn_menu.add(bt_thongtinkhachhang);

		JButton bt_dangxuat = new JButton("Đăng xuất");
		bt_dangxuat.setIcon(new ImageIcon(DemoQuanLy.class.getResource("/fileanh/logout (1).png")));
		bt_dangxuat.setBackground(new Color(102, 102, 102));
		bt_dangxuat.setBounds(2, 277, 207, 67);
	bt_dangxuat.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			closeWindow();
		}
	});
		bt_dangxuat.setFont(font2);
		pn_menu.add(bt_dangxuat);
		
		JButton bt_phanhoi = new JButton("Phản Hồi ");
		bt_phanhoi.setIcon(new ImageIcon(DemoQuanLy.class.getResource("/fileanh/telephone1.png")));
		bt_phanhoi.setFont(new Font("Dialog", Font.BOLD, 18));
		bt_phanhoi.setBackground(new Color(102, 102, 102));
		bt_phanhoi.setBounds(2, 208, 207, 67);
		pn_menu.add(bt_phanhoi);
		
		 

		JPanel pn_trangchu = new JPanel();
		pn_hoatdong.add(pn_trangchu, "anhTrangchu");
		pn_trangchu.setLayout(new BorderLayout(0, 0));
		
		phong = new Phong[]{
				new Phong(101, "Phòng 101", TrangThaiPhong.DANG_HOAT_DONG),
				new Phong(102, "Phòng 102", TrangThaiPhong.CHO_XAC_NHAN),
				new Phong(103, "Phòng 103", TrangThaiPhong.TRONG),
				new Phong(104, "Phòng 104", TrangThaiPhong.TRONG),
				new Phong(201, "Phòng 201", TrangThaiPhong.TRONG),
				new Phong(202, "Phòng 202", TrangThaiPhong.TRONG),
				new Phong(203, "Phòng 203", TrangThaiPhong.TRONG),
				new Phong(204, "Phòng 204", TrangThaiPhong.TRONG),
				new Phong(301, "Phòng 301", TrangThaiPhong.TRONG),
				new Phong(302, "Phòng 302", TrangThaiPhong.TRONG),
				new Phong(303, "Phòng 303", TrangThaiPhong.TRONG),
				new Phong(304, "Phòng 304", TrangThaiPhong.TRONG),
		};
		

		JLabel lbanhtrangchu = new JLabel("");
		lbanhtrangchu.setIcon(new ImageIcon(DemoQuanLy.class.getResource("/fileanh/khachsan.jpeg")));
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
		bt_thongtinkhachhang.addActionListener(new ActionListener() {
			
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

	}
	
}