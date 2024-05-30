package View;

import java.awt.Dimension; 

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Model.Phong;
import Model.Phong.TrangThaiPhong;
import jakarta.mail.Session;

import javax.swing.border.EtchedBorder;

import java.awt.Color;
import javax.swing.ImageIcon;

public class pn_DatphongQL extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfhovaten;
	public JTextField tfcccd;
	private JTextField tfsdt;
	private JCheckBox cbtuantrangmat;
	private JCheckBox cbduadonsanbay;
	private JCheckBox cbdungdiemtam;
	private JCheckBox cbtrongtre;
	private JButton btquaylai;
	private JButton btxacnhan;
	private JButton btchoxacnhan;
	private JSpinner spinnerngaysinh;
	public Color colordat = new Color(205, 180, 219);
	public Color colorchoxacnhan = new Color(255, 200, 221);
	SimpleDateFormat formatNgayGio = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
	private JCheckBox cbchothuexe;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public double bill = 1;
	private JCheckBox cbGiatui;
	private JCheckBox cbSPA;
	private JCheckBox cbFitness;
	private Calendar calendar;
	private JTextField TMaKH;
	

	public pn_DatphongQL(Phong phong, pn_ChoxacnhanQL xacnhan, pn_DanghoatdongQL hoatdong, ManagerUI view) {
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
		lblNewLabel_1.setBounds(32, 123, 120, 17);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));

		tfhovaten = new JTextField();
		tfhovaten.setBackground(new Color(255, 255, 255));
		tfhovaten.setBounds(224, 120, 246, 23);
		panel.add(tfhovaten);
		tfhovaten.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tfhovaten.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CCCD:");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(32, 153, 120, 17);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));

		tfcccd = new JTextField();
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
		tfsdt.setBackground(new Color(255, 255, 255));
		tfsdt.setBounds(224, 182, 246, 23);
		panel.add(tfsdt);
		tfsdt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		tfsdt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(32, 93, 120, 17);
		panel.add(lblNewLabel_1_1);
		
		TMaKH = new JTextField();
		TMaKH.setFont(new Font("Monospaced", Font.PLAIN, 14));
		TMaKH.setColumns(10);
		TMaKH.setBackground(Color.WHITE);
		TMaKH.setBounds(224, 90, 246, 23);
		panel.add(TMaKH);

		JPanel panel_1 = new JPanel();
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
		
		JLabel lbmaphong = new JLabel("");
		lbmaphong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbmaphong.setBounds(731, 40, 64, 23);
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
		            String formattedDateTime = now.format(formatter);
		            
		            hoatdong.THovaten.setText(tfhovaten.getText());
					hoatdong.TCCCD.setText(tfcccd.getText());
					
		            hoatdong.TNgayGioNHanPhong.setText(formattedDateTime);
		            hoatdong.lbMaPhong.setText(phong.getId()+"");
		            hoatdong.TSDTH.setText(tfsdt.getText());
		            

		            if(cbchothuexe.isSelected()) {
		            	hoatdong.db.addRow(new Object[] {
							"Cho thuê xe tự lái",  phantichgia(view.danhsachDV[9].getGiaca()) 
						});					
					}
					if(cbduadonsanbay.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Đưa đón sân bay", phantichgia(view.danhsachDV[11].getGiaca())	
						});		
					}
					if(cbdungdiemtam.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Dùng điểm tâm", phantichgia(view.danhsachDV[10].getGiaca())	
						});	
					}
					if(cbtrongtre.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Trông trẻ", phantichgia(view.danhsachDV[12].getGiaca())	
						});
					}
					if(cbtuantrangmat.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Tuần trăng mật", phantichgia(view.danhsachDV[13].getGiaca())	
						});
					}
					if(cbGiatui.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Giặt ủi", phantichgia(view.danhsachDV[14].getGiaca())	
						});
					}
					if(cbSPA.isSelected()) {
						hoatdong.db.addRow(new Object[] {
								"Spa", phantichgia(view.danhsachDV[15].getGiaca())	
						});
					}
					if(cbFitness.isSelected()){
						hoatdong.db.addRow(new Object[] {
								"Fitness", phantichgia(view.danhsachDV[16].getGiaca())
						});
					}
					
//					dmql.addRow(new Object[] { u.getHoTen() + "", u.getCccd() + "", u.getPassword(),
//							u.getSdthlienhe() + "", u.getDoituong() + "", ngay, u.getLoaighe() + "",
//							u.getKhuHoi() + "", u.getNoiDi() + "", u.getNoiDen() + "", u.getGiaVe(),
//							u.getMasove() });
					int ma = taomaKH();
					hoatdong.maKH = ma;
					hoatdong.TMaKH.setText(ma+"");
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
					xacnhan.THovaten.setText(tfhovaten.getText());
					xacnhan.TCCCD.setText(tfcccd.getText());
					
					int ma = taomaKH();
					xacnhan.maKH = ma;
					xacnhan.TMaKH.setText(ma+"");
					xacnhan.lbMaPhong.setText(phong.getId()+"");
					if(cbchothuexe.isSelected()) {
		            	xacnhan.db.addRow(new Object[] {
							"Cho thuê xe tự lái",  phantichgia(view.danhsachDV[9].getGiaca()) 
						});					
					}
					if(cbduadonsanbay.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Đưa đón sân bay", phantichgia(view.danhsachDV[11].getGiaca())	
						});		
					}
					if(cbdungdiemtam.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Dùng điểm tâm", phantichgia(view.danhsachDV[10].getGiaca())	
						});	
					}
					if(cbtrongtre.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Trông trẻ", phantichgia(view.danhsachDV[12].getGiaca())	
						});
					}
					if(cbtuantrangmat.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Tuần trăng mật", phantichgia(view.danhsachDV[13].getGiaca())	
						});
					}
					if(cbGiatui.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Giặt ủi", phantichgia(view.danhsachDV[14].getGiaca())	
						});
					}
					if(cbSPA.isSelected()) {
						xacnhan.db.addRow(new Object[] {
								"Spa", phantichgia(view.danhsachDV[15].getGiaca())	
						});
					}
					if(cbFitness.isSelected()){
						xacnhan.db.addRow(new Object[] {
								"Fitness", phantichgia(view.danhsachDV[16].getGiaca())
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
	private int taomaKH() { 
        Random random = new Random();
        int randomNumber = random.nextInt(8999) + 1000;
        return randomNumber;
    }
	
	public void xoaform() {
		tfhovaten.setText(null);
	        calendar.set(2024, 0, 1); // Năm 2024, tháng 0 (tháng 1), ngày 1
	        Date date = calendar.getTime();
	        spinnerngaysinh.setValue(date);

		
		tfcccd.setText(null);
		tfsdt.setText(null);
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
		if (dinhdang(tfcccd.getText())==true || dinhdangsdth(tfsdt.getText()) == true || tfhovaten.getText() != null ) {
			return true;
		} else return false;
	}
	private static class UpdateReceiver extends Thread {
        private BufferedReader reader;

        public UpdateReceiver(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            try {
                String update;
                while ((update = reader.readLine()) != null) {
                    System.out.println("Received update from server: " + update);
                    // Xử lý cập nhật ở đây
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}