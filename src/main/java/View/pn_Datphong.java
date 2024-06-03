package View;

import java.awt.Dimension;    

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.google.gson.Gson;

import Model.ModelKhachHang;
import Model.Modelchuoi;
import Model.Phong;
import Model.Phong.TrangThaiPhong;


import javax.swing.border.EtchedBorder;

import java.awt.Color;
import javax.swing.ImageIcon;

public class pn_Datphong extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField tfhovaten;
	public JTextField tfmaKhachHang;
	public JTextField tfcccd;
	public JTextField tfsdt;
	private JCheckBox cbtuantrangmat;
	private JCheckBox cbduadonsanbay;
	private JCheckBox cbdungdiemtam;
	private JCheckBox cbtrongtre;
	private JButton btquaylai;
	private JButton btxacnhan;
	private JButton btchoxacnhan;
	public Color colordat = new Color(205, 180, 219);
	public Color colorchoxacnhan = new Color(255, 200, 221);
	SimpleDateFormat formatNgayGio = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
	private JCheckBox cbchothuexe;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public double bill = 1;
	private JCheckBox cbGiatui;
	private JCheckBox cbSPA;
	private JCheckBox cbFitness;
	private String ngaygionhan;
	private JLabel lbmaphong;

	
	

	public pn_Datphong(Phong phong, pn_Choxacnhan xacnhan, pn_Danghoatdong hoatdong, UserUI view) {
		setPreferredSize(new Dimension(947, 742));
		setLayout(null);
		
		JPanel pnthongtin = new JPanel();
		pnthongtin.setBounds(27, 22, 910, 452);
		add(pnthongtin);
		pnthongtin.setBackground(new Color(255, 255, 255));
		pnthongtin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnthongtin.setLayout(null);

		JLabel lblNewLabel = new JLabel("CHÀO MỪNG QUÝ KHÁCH ĐÃ ĐẾN VỚI CHÚNG TÔI");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(115, 22, 544, 30);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
		pnthongtin.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(192, 192, 192)),
				"   NHẬP THÔNG TIN   ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 80, 510, 362);
		pnthongtin.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Họ và Tên:  ");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(32, 124, 120, 17);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));

		tfhovaten = new JTextField();
		tfhovaten.setEditable(false);
		tfhovaten.setBackground(new Color(255, 255, 255));
		tfhovaten.setBounds(224, 120, 246, 23);
		panel.add(tfhovaten);
		tfhovaten.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tfhovaten.setColumns(10);

		


		JLabel lblNewLabel_2 = new JLabel("Mã khách hàng");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(32, 93, 171, 17);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));

		tfmaKhachHang = new JTextField();
		tfmaKhachHang.setEditable(false);
		tfmaKhachHang.setBackground(new Color(255, 255, 255));
		tfmaKhachHang.setBounds(224, 87, 246, 23);
		panel.add(tfmaKhachHang);
		tfmaKhachHang.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tfmaKhachHang.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CCCD:");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(32, 153, 120, 17);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));

		tfcccd = new JTextField();
		tfcccd.setEditable(false);
		tfcccd.setBackground(new Color(255, 255, 255));
		tfcccd.setBounds(224, 149, 246, 23);
		panel.add(tfcccd);
		tfcccd.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tfcccd.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Số điện thoại :");
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(32, 184, 120, 20);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));

		tfsdt = new JTextField();
		tfsdt.setEditable(false);
		tfsdt.setBackground(new Color(255, 255, 255));
		tfsdt.setBounds(224, 182, 246, 23);
		panel.add(tfsdt);
		tfsdt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tfsdt.setColumns(10);

		JPanel panel_1 =  new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(192, 192, 192)), "CH\u1ECCN D\u1ECACH V\u1EE4 TR\u01AF\u1EDAC KHI NH\u1EACN PH\u00D2NG", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(536, 80, 350, 362);
		pnthongtin.add(panel_1);
		panel_1.setLayout(null);

		cbdungdiemtam = new JCheckBox("Dùng điểm tâm");
		cbdungdiemtam.setBackground(new Color(255, 255, 255));
		cbdungdiemtam.setBounds(24, 106, 158, 23);
		panel_1.add(cbdungdiemtam);
		cbdungdiemtam.setFont(new Font("Arial", Font.BOLD, 14));

		cbduadonsanbay = new JCheckBox("Đưa đón sân bay");
		cbduadonsanbay.setBackground(new Color(255, 255, 255));
		cbduadonsanbay.setBounds(24, 131, 158, 23);
		panel_1.add(cbduadonsanbay);
		cbduadonsanbay.setFont(new Font("Arial", Font.BOLD, 14));

		cbtuantrangmat = new JCheckBox("Tuần trăng mật");
		cbtuantrangmat.setBackground(new Color(255, 255, 255));
		cbtuantrangmat.setBounds(24, 181, 158, 23);
		panel_1.add(cbtuantrangmat);
		cbtuantrangmat.setFont(new Font("Arial", Font.BOLD, 14));

		cbtrongtre = new JCheckBox("Trông trẻ");
		cbtrongtre.setBackground(new Color(255, 255, 255));
		cbtrongtre.setBounds(24, 156, 158, 23);
		panel_1.add(cbtrongtre);
		cbtrongtre.setFont(new Font("Arial", Font.BOLD, 14));

		cbchothuexe = new JCheckBox("Cho thuê xe tự lái ");
		cbchothuexe.setBackground(new Color(255, 255, 255));
		cbchothuexe.setFont(new Font("Arial", Font.BOLD, 14));
		cbchothuexe.setBounds(24, 78, 158, 23);
		panel_1.add(cbchothuexe);
		
		cbGiatui = new JCheckBox("Giặt ủi");
		cbGiatui.setFont(new Font("Arial", Font.BOLD, 14));
		cbGiatui.setBackground(Color.WHITE);
		cbGiatui.setBounds(24, 206, 158, 23);
		panel_1.add(cbGiatui);
		
		cbSPA = new JCheckBox("Spa");
		cbSPA.setFont(new Font("Arial", Font.BOLD, 14));
		cbSPA.setBackground(Color.WHITE);
		cbSPA.setBounds(24, 231, 158, 23);
		panel_1.add(cbSPA);
		
		cbFitness = new JCheckBox("Fitness");
		cbFitness.setFont(new Font("Arial", Font.BOLD, 14));
		cbFitness.setBackground(Color.WHITE);
		cbFitness.setBounds(24, 256, 158, 23);
		panel_1.add(cbFitness);
		
		JLabel lblNewLabel_7 = new JLabel("-700.000 VND/ngày");
		lblNewLabel_7.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7.setBounds(199, 78, 141, 23);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("-500.000 VND/ngày");
		lblNewLabel_7_1.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_1.setBounds(199, 106, 141, 23);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("-200.000 VND/ngày");
		lblNewLabel_7_2.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_2.setBounds(199, 131, 141, 23);
		panel_1.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("-300.000 VND/ngày");
		lblNewLabel_7_2_1.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_2_1.setBounds(199, 156, 141, 23);
		panel_1.add(lblNewLabel_7_2_1);
		
		JLabel lblNewLabel_7_2_2 = new JLabel("-3.000.000 VND/ngày");
		lblNewLabel_7_2_2.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_2_2.setBounds(199, 181, 141, 23);
		panel_1.add(lblNewLabel_7_2_2);
		
		JLabel lblNewLabel_7_2_3 = new JLabel("-100.000 VND/ngày");
		lblNewLabel_7_2_3.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_2_3.setBounds(199, 206, 141, 23);
		panel_1.add(lblNewLabel_7_2_3);
		
		JLabel lblNewLabel_7_2_4 = new JLabel("-1.500.000 VND/ngày");
		lblNewLabel_7_2_4.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_2_4.setBounds(199, 231, 141, 23);
		panel_1.add(lblNewLabel_7_2_4);
		
		JLabel lblNewLabel_7_2_5 = new JLabel("-200.000 VND/ngày");
		lblNewLabel_7_2_5.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_7_2_5.setBounds(199, 256, 141, 23);
		panel_1.add(lblNewLabel_7_2_5);
		
		JLabel lblNewLabel_8 = new JLabel("Mã phòng:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(660, 40, 64, 23);
		pnthongtin.add(lblNewLabel_8);
		
		lbmaphong = new JLabel(phong.getId()+"");
		lbmaphong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbmaphong.setBounds(731, 40, 147, 23);
		pnthongtin.add(lbmaphong);

		JPanel pn_button = new JPanel();
		pn_button.setBounds(27, 484, 910, 57);
		add(pn_button);
		pn_button.setBackground(new Color(255, 255, 255));
		pn_button.setForeground(Color.WHITE);
		pn_button.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pn_button.setLayout(null);

		btquaylai = new JButton("Quay Lại");
		btquaylai.setBackground(new Color(255, 255, 255));
		btquaylai.setBounds(10, 10, 123, 37);
		btquaylai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_button.add(btquaylai);
		btquaylai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
				
			}
		});

		btxacnhan = new JButton("Đặt Phòng");
		btxacnhan.setBackground(new Color(255, 255, 255));
		btxacnhan.setBounds(783, 10, 117, 37);
		btxacnhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_button.add(btxacnhan);
		btxacnhan.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkdata() == true) {
					phong.setTrangThai(TrangThaiPhong.DANG_HOAT_DONG);
					
		            LocalDateTime now = LocalDateTime.now();
		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		            ngaygionhan = now.format(formatter);
		            String thongtindp = chuoithongtindp(phong);
		            int madp = view.booking(thongtindp);
		            view.sendmail(view.khachHang.getEmail(), "MÃ ĐẶT PHÒNG CỦA BẠN", madp, view.khachHang.getHoten(), phong);
		            hoatdong.TMadatphong.setText(madp+"");
		            hoatdong.THovaten.setText(tfhovaten.getText());
					hoatdong.TCCCD.setText(tfcccd.getText());
		            hoatdong.TNgayGioNHanPhong.setText(ngaygionhan);
		            hoatdong.lbMaPhong.setText(phong.getId()+"");
		            hoatdong.TSDTH.setText(tfsdt.getText());
		            hoatdong.TMaKH.setText(tfmaKhachHang.getText());

		            if(cbchothuexe.isSelected()) {
		            	hoatdong.db.addRow(new Object[] {
							"Cho thuê xe tự lái",  phantichgia(hoatdong.danhsachDV[9].getGiaca()) 
						});					
					}
					if(cbduadonsanbay.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Đưa đón sân bay", phantichgia(hoatdong.danhsachDV[11].getGiaca())	
						});		
					}
					if(cbdungdiemtam.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Dùng điểm tâm", phantichgia(hoatdong.danhsachDV[10].getGiaca())	
						});	
					}
					if(cbtrongtre.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Trông trẻ", phantichgia(hoatdong.danhsachDV[12].getGiaca())	
						});
					}
					if(cbtuantrangmat.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Tuần trăng mật", phantichgia(hoatdong.danhsachDV[13].getGiaca())	
						});
					}
					if(cbGiatui.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Giặt ủi", phantichgia(hoatdong.danhsachDV[14].getGiaca())	
						});
					}
					if(cbSPA.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Spa", phantichgia(hoatdong.danhsachDV[15].getGiaca())	
						});
					}
					if(cbFitness.isSelected()){
						hoatdong.db.addRow(new Object[] {
								"Fitness", phantichgia(hoatdong.danhsachDV[16].getGiaca())
						});
					}
					
//					dmql.addRow(new Object[] { u.getHoTen() + "", u.getCccd() + "", u.getPassword(),
//							u.getSdthlienhe() + "", u.getDoituong() + "", ngay, u.getLoaighe() + "",
//							u.getKhuHoi() + "", u.getNoiDi() + "", u.getNoiDen() + "", u.getGiaVe(),
//							u.getMasove() });
				
					xoaform();		
				} else JOptionPane.showMessageDialog(null, "Nhập sai định dạng\n Vui lòng nhập lại!");
			}
		});
		

		btchoxacnhan = new JButton("Chuyển Vào Chế Độ Chờ");
		btchoxacnhan.setBackground(new Color(255, 255, 255));
		btchoxacnhan.setBounds(576, 10, 197, 37);
		btchoxacnhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_button.add(btchoxacnhan);
		btchoxacnhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkdata() == true) {
					phong.setTrangThai(TrangThaiPhong.CHO_XAC_NHAN);
					ngaygionhan = "";
					String tt  = chuoithongtindp(phong);
					int madp = view.booking(tt);
					view.sendmail(view.khachHang.getEmail(), "MÃ ĐẶT PHÒNG CỦA BẠN", madp, view.khachHang.getHoten(), phong);
					xacnhan.TMadatphong.setText(madp+"");
					xacnhan.THovaten.setText(tfhovaten.getText());
					xacnhan.TCCCD.setText(tfcccd.getText());
					xacnhan.TMaKH.setText(tfmaKhachHang.getText());
					xacnhan.TSdth.setText(tfsdt.getText());
					xacnhan.lbMaPhong.setText(phong.getId()+"");
					if(cbchothuexe.isSelected()) {
		            	xacnhan.db.addRow(new Object[] {
							"Cho thuê xe tự lái",  phantichgia(hoatdong.danhsachDV[9].getGiaca()) 
						});					
					}
					if(cbduadonsanbay.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Đưa đón sân bay", phantichgia(hoatdong.danhsachDV[11].getGiaca())	
						});		
					}
					if(cbdungdiemtam.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Dùng điểm tâm", phantichgia(hoatdong.danhsachDV[10].getGiaca())	
						});	
					}
					if(cbtrongtre.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Trông trẻ", phantichgia(hoatdong.danhsachDV[12].getGiaca())	
						});
					}
					if(cbtuantrangmat.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Tuần trăng mật", phantichgia(hoatdong.danhsachDV[13].getGiaca())	
						});
					}
					if(cbGiatui.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Giặt ủi", phantichgia(hoatdong.danhsachDV[14].getGiaca())	
						});
					}
					if(cbSPA.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Spa", phantichgia(hoatdong.danhsachDV[15].getGiaca())	
						});
					}
					if(cbFitness.isSelected()){
						xacnhan.db.addRow(new Object[] {
								"Fitness", phantichgia(hoatdong.danhsachDV[16].getGiaca())
						});
					}
					
					xoaform();
				} else {
					JOptionPane.showMessageDialog(null, "Nhập sai định dang\n"
													+ "Vui lòng nhập lại");
				}
				
			}
		});
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(new ImageIcon(pn_Datphong.class.getResource("/FileAnh/resort.jpg")));
		lblNewLabel_6.setSize(947, 742);
		add(lblNewLabel_6);

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
	
	
	
	public void xoaform() {
		
		cbdungdiemtam.setSelected(false);
		cbduadonsanbay.setSelected(false);
		cbtrongtre.setSelected(false);
		cbtuantrangmat.setSelected(false);
		cbchothuexe.setSelected(false);
		cbGiatui.setSelected(false);
		cbSPA.setSelected(false);
		cbFitness.setSelected(false);
	}
	public static boolean dinhdangsdth(String sdth) {
        String regex = "0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sdth);
        return matcher.matches();
	}
	public static boolean dinhdang(String cccd) {
        String regex = "0\\d{11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cccd);
        return matcher.matches();
	}
	public boolean checkdata() {
		if (dinhdang(tfcccd.getText())==true || dinhdangsdth(tfsdt.getText()) == true || tfhovaten.getText() != null || tfmaKhachHang.getText()!=null) {
			return true;
		} else return false;
	}
	public String chuoithongtindp(Phong phong) {
		Modelchuoi data = new Modelchuoi();
		data.setTrangthai(phong.getTrangThai());
		data.setMaKhachHang(tfmaKhachHang.getText());
		data.setHoVaTen(tfhovaten.getText());
		data.setCccd(tfcccd.getText());
		data.setSdt(tfsdt.getText());
		data.setTuanTrangMat(cbtuantrangmat.isSelected());
		data.setDuaDonSanBay(cbduadonsanbay.isSelected());
		data.setDungDiemTam(cbdungdiemtam.isSelected());
		data.setTrongTre(cbtrongtre.isSelected());
		data.setChoThueXe(cbchothuexe.isSelected());
		data.setSpa(cbSPA.isSelected());
		data.setFitness(cbFitness.isSelected());
		data.setngaygiovaophong(ngaygionhan);
		data.setGiatui(cbGiatui.isSelected());
		data.setMaphong(phong.getId());
		Gson gson= new Gson();
		String jsonData = gson.toJson(data);
		return jsonData;
	}
	
}