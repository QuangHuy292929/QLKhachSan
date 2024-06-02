package View;

import java.awt.Dimension;             

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;

import Model.Phong;

import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JComboBox;



public class pn_DanghoatdongQL extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnTrPhng;
	private JButton btquaylai;
	public JTextField THovaten;
	public JTextField TCCCD;
	public JTextField TNgayGioNHanPhong;
	public JTextField TSDTH;
	public JTextField TMadatphong;
	private JTextField Tsoluong;
	
	public Object datadattrc[][] = {};
	public Object datadatsau[][] = {};
	private JTable table_1;
	private JComboBox<String> cbDv;
	String column[] = {
			"Tên dịch vụ", "Đơn giá", "Số lượng", "Thành tiền"
	};
	String coltruoc[] = {
			"Tên dịch vụ", "Đơn giá/Ngày"
	};
	protected DefaultTableModel dbsau;
	protected DefaultTableModel db;
	protected JTextField TMaKH;
	protected JLabel lbMaPhong;


	/**
	 * Create the panel.
	 */
	public pn_DanghoatdongQL(Phong phong, ManagerUI view) {
		
		
		
		setBackground(new Color(240, 240, 240));
		setPreferredSize(new Dimension(947, 742));
		setLayout(null);
		JPanel pnthongtinhoatdong = new JPanel();
		pnthongtinhoatdong.setBounds(20, 23, 910, 576);
		pnthongtinhoatdong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(pnthongtinhoatdong);
		pnthongtinhoatdong.setLayout(null);

		
		
		JPanel pnOrderDv = new JPanel();
		pnOrderDv.setBackground(new Color(255, 255, 255));
		pnOrderDv.setBounds(454, 10, 451, 556);
		pnOrderDv.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnthongtinhoatdong.add(pnOrderDv);
		pnOrderDv.setLayout(null);
				
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), null), "  D\u1ECACH V\u1EE4 TH\u00CAM   ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(10, 10, 431, 224);
		pnOrderDv.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Arial", Font.BOLD, 14));
		lblSLng.setBounds(10, 104, 76, 26);
		panel_5.add(lblSLng);
		
		Tsoluong = new JTextField("1");
		Tsoluong.setEditable(false);
		Tsoluong.setHorizontalAlignment(JTextField.CENTER);
		Tsoluong.setFont(new Font("Monospaced", Font.BOLD, 14));
		Tsoluong.setColumns(10);
		Tsoluong.setBounds(131, 104, 110, 26);
		panel_5.add(Tsoluong);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soluong = Integer.parseInt(Tsoluong.getText());
				if(soluong>1) {
					soluong--;
					Tsoluong.setText(soluong+"");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(82, 104, 39, 26);
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("+");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soluong = Integer.parseInt(Tsoluong.getText());
				soluong++;
				Tsoluong.setText(soluong+"");
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(251, 105, 39, 26);
		panel_5.add(btnNewButton_1_1);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(10, 244, 431, 302);
		pnOrderDv.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Dịch vụ đặt thêm:");
		lblNewLabel_3_1_1.setBounds(25, 48, 124, 17);
		panel_6.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		JTable table2 = new JTable();
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(25, 75, 400, 180);
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		dbsau = new DefaultTableModel(datadatsau, column);
		table2.setModel(dbsau);
		JScrollPane sc = new JScrollPane(table2);
		panel_7.add(sc, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 435, 556);
		pnthongtinhoatdong.add(panel);
		panel.setLayout(null);

		JLabel lblThngTinKhch_1 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThngTinKhch_1.setBounds(10, 10, 278, 22);
		lblThngTinKhch_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		panel.add(lblThngTinKhch_1);

		JLabel lblNewLabel = new JLabel("Họ và tên:");
		lblNewLabel.setBounds(33, 148, 174, 26);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã đặt phòng:");
		lblNewLabel_1.setBounds(33, 112, 174, 26);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("CCCD:");
		lblNewLabel_3.setBounds(33, 184, 174, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Số điện thoại:");
		lblNewLabel_4.setBounds(33, 220, 174, 26);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ngày giờ nhận phòng:");
		lblNewLabel_5.setBounds(33, 256, 174, 26);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_5);
		
		THovaten = new JTextField();
		THovaten.setEditable(false);
		THovaten.setFont(new Font("Monospaced", Font.BOLD, 14));
		THovaten.setBounds(217, 148, 208, 26);
		panel.add(THovaten);
		THovaten.setColumns(10);
		
		TCCCD = new JTextField();
		TCCCD.setEditable(false);
		TCCCD.setFont(new Font("Monospaced", Font.BOLD, 14));
		TCCCD.setColumns(10);
		TCCCD.setBounds(217, 184, 208, 26);
		panel.add(TCCCD);
		
		TNgayGioNHanPhong = new JTextField();
		TNgayGioNHanPhong.setEditable(false);
		TNgayGioNHanPhong.setFont(new Font("Monospaced", Font.BOLD, 14));
		TNgayGioNHanPhong.setColumns(10);
		TNgayGioNHanPhong.setBounds(217, 256, 208, 26);
		panel.add(TNgayGioNHanPhong);
		
		TSDTH = new JTextField();
		TSDTH.setEditable(false);
		TSDTH.setFont(new Font("Monospaced", Font.BOLD, 14));
		TSDTH.setColumns(10);
		TSDTH.setBounds(217, 220, 208, 26);
		panel.add(TSDTH);
		
		TMadatphong = new JTextField();
		TMadatphong.setEditable(false);
		TMadatphong.setFont(new Font("Monospaced", Font.BOLD, 14));
		TMadatphong.setColumns(10);
		TMadatphong.setBounds(217, 112, 208, 26);
		panel.add(TMadatphong);
		
		JLabel lblNewLabel_3_1 = new JLabel("Dịch vụ đặt trước:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(33, 292, 174, 26);
		panel.add(lblNewLabel_3_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(33, 328, 392, 166);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		table_1 = new JTable();
		db = new DefaultTableModel(datadattrc, coltruoc);
		table_1.setModel(db);
		JScrollPane sc1 = new JScrollPane(table_1);
		table_1.setBounds(33, 380, 392, 166);
		panel_2.add(sc1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_7 = new JLabel("Mã phòng");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(267, 44, 74, 22);
		panel.add(lblNewLabel_7);
		
		lbMaPhong = new JLabel("");
		lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbMaPhong.setBounds(351, 44, 74, 22);
		panel.add(lbMaPhong);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
		lblMKhchHng.setFont(new Font("Arial", Font.BOLD, 14));
		lblMKhchHng.setBounds(33, 76, 174, 26);
		panel.add(lblMKhchHng);
		
		TMaKH = new JTextField();
		TMaKH.setFont(new Font("Monospaced", Font.BOLD, 14));
		TMaKH.setEditable(false);
		TMaKH.setColumns(10);
		TMaKH.setBounds(217, 76, 208, 26);
		panel.add(TMaKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 615, 910, 68);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel_1);
		panel_1.setLayout(null);

		btquaylai = new JButton("Quay lại");
		btquaylai.setBounds(10, 10, 132, 49);
		panel_1.add(btquaylai);
		btquaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
			}
		});
		btquaylai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnTrPhng = new JButton("Trả phòng");
		btnTrPhng.setBounds(751, 10, 149, 49);
		panel_1.add(btnTrPhng);
		btnTrPhng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(new ImageIcon(pn_Danghoatdong.class.getResource("/FileAnh/resort.jpg")));
		lblNewLabel_6.setSize(947, 742);
		add(lblNewLabel_6);
		
		
		String dv [] = new String[] {
				"Nước lọc - 15.000VND",
				"Snack khoai tây - 20.000VND",
				"Coca/Pepsi - 20.000VND",
				"Rượu Vodka SMIRNOFF 700ML - 400.000VND",
				"Bánh KitKat - 25.000VND",
				"Nước Smartwater 500ML - 60.000VND",
				"Bia Heineken 250ML - 20.000VND",
				"Vang Ý Mango Tropical 750ML - 500.000VND",
				"Chivas Regal 18 Gold Signature 700ML - 1.400.000VND"
				
		};
		cbDv = new JComboBox<String>(dv);
		cbDv.setFont(new Font("Arial", Font.BOLD, 10));
		cbDv.setBounds(118, 50, 303, 26);
		panel_5.add(cbDv);
		
		JButton btorder = new JButton("Đặt");
		btorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lc = cbDv.getSelectedIndex();
				int soluong = Integer.parseInt(Tsoluong.getText());
				switch (lc) {
				case 0:
					dbsau.addRow(new Object[] { view.danhsachDV[0].getTenDichvu(), phantichgia(view.danhsachDV[0].getGiaca()),
							soluong, phantichgia(view.danhsachDV[0].getGiaca() * soluong) });
					break;
				case 1:
					dbsau.addRow(new Object[] { view.danhsachDV[1].getTenDichvu(), phantichgia(view.danhsachDV[1].getGiaca()),
							soluong, phantichgia(view.danhsachDV[1].getGiaca() * soluong) });
					break;
				case 2:
					dbsau.addRow(new Object[] { view.danhsachDV[2].getTenDichvu(), phantichgia(view.danhsachDV[2].getGiaca()),
							soluong, phantichgia(view.danhsachDV[2].getGiaca() * soluong) });
					break;
				case 3:
					dbsau.addRow(new Object[] { view.danhsachDV[3].getTenDichvu(), phantichgia(view.danhsachDV[3].getGiaca()),
							soluong, phantichgia(view.danhsachDV[3].getGiaca() * soluong) });
					break;
				case 4:
					dbsau.addRow(new Object[] { view.danhsachDV[4].getTenDichvu(), phantichgia(view.danhsachDV[4].getGiaca()),
							soluong, phantichgia(view.danhsachDV[4].getGiaca() * soluong) });
					break;
				case 5:
					dbsau.addRow(new Object[] { view.danhsachDV[5].getTenDichvu(), phantichgia(view.danhsachDV[5].getGiaca()),
							soluong, phantichgia(view.danhsachDV[5].getGiaca() * soluong) });
					break;
				case 6:
					dbsau.addRow(new Object[] { view.danhsachDV[6].getTenDichvu(), phantichgia(view.danhsachDV[6].getGiaca()),
							soluong, phantichgia(view.danhsachDV[6].getGiaca() * soluong) });
					break;
				case 7:
					dbsau.addRow(new Object[] { view.danhsachDV[7].getTenDichvu(), phantichgia(view.danhsachDV[7].getGiaca()),
							soluong, phantichgia(view.danhsachDV[7].getGiaca() * soluong) });
					break;
				case 8:
					dbsau.addRow(new Object[] { view.danhsachDV[8].getTenDichvu(), phantichgia(view.danhsachDV[8].getGiaca()),
							soluong, phantichgia(view.danhsachDV[8].getGiaca() * soluong) });
					break;
				}
				Tsoluong.setText("1");
				
			}
		});
		btorder.setBackground(new Color(255, 255, 255));
		btorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btorder.setBounds(10, 163, 129, 51);
		panel_5.add(btorder);
		
		JLabel lblChnDchV = new JLabel("Chọn dịch vụ:");
		lblChnDchV.setFont(new Font("Arial", Font.BOLD, 14));
		lblChnDchV.setBounds(10, 50, 98, 26);
		panel_5.add(lblChnDchV);
		
		btnTrPhng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Bill bill = new Bill(phong, view);
				int tongtien = 0;
				bill.lbMaPhong.setText(phong.getId()+"");
				bill.TMadp.setText(TMadatphong.getText());
				bill.TMakH.setText(TMaKH.getText()+"");
				bill.TTenKH.setText(THovaten.getText());
				bill.TNgayvao.setText(TNgayGioNHanPhong.getText());
				LocalDateTime now = LocalDateTime.now();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
	            String formattedDateTime = now.format(formatter);
	            bill.TNgayRa.setText(formattedDateTime);
	            int tgian = Tinhgio(TNgayGioNHanPhong.getText(), formattedDateTime);
	            int ngayo = tgian/12 + 1;
	            int tienphong = phong.getGiaphong()*ngayo;
	            bill.TTienPhong.setText(phantichgia(phong.getGiaphong()*ngayo)+"");
	            for (int row = 0; row < db.getRowCount(); row++) {
	            	Object col1Value = db.getValueAt(row, 0);
	                String col2Value = db.getValueAt(row, 1)+"";
	                int gia = convert(col2Value);
	                tongtien += gia*tgian;
	                bill.db.addRow(new Object[] {
	                	col1Value, col2Value, 1, phantichgia(gia*tgian)	
	                });
				}
	            for (int row = 0; row < dbsau.getRowCount(); row++) {
	            	Object col1Value = dbsau.getValueAt(row, 0);
	                String col2Value = dbsau.getValueAt(row, 1)+"";
	                Object col3value = dbsau.getValueAt(row, 2);
	                String col4val = dbsau.getValueAt(row, 3)+"";
	                int tien = convert(col4val);
	                tongtien+=tien;
	                
	                bill.dbsau.addRow(new Object[] {
	                	col1Value, col2Value, col3value, col4val 	
	                });
				}
	            
	            double thuedb = (Math.abs(tongtien)*20)/100;
	            int thue = (int) thuedb;
	            bill.TThue.setText(phantichgia(thue));
	            bill.TTongTien.setText(phantichgia(tongtien+thue+tienphong));
				
//				phong.setTrangThai(TrangThaiPhong.TRONG);
				xoaform();
//				view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
				
			}
		});
		
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
	
	public void xoaform() {
		THovaten.setText(null);
		TMadatphong.setText(null);
		TCCCD.setText(null);
		TSDTH.setText(null);
		
		TNgayGioNHanPhong.setText(null);
		TMaKH.setText(null);
		lbMaPhong.setText(null);
		db.setRowCount(0);
		dbsau.setRowCount(0);
	}
	public static int convert(String input) {
	    // Loại bỏ ký tự "VND" và dấu chấm phẩy
	    String cleanedInput = input.replaceAll("[^0-9]", "");
	    
	    // Chuyển đổi chuỗi thành số nguyên kiểu int
	    int value = Integer.parseInt(cleanedInput);
	    
	    return value;
	}
	
	public static int Tinhgio(String time1, String time2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        
        try {
            Date date1 = dateFormat.parse(time1);
            Date date2 = dateFormat.parse(time2);
            
            long diffInMillies = Math.abs(date1.getTime() - date2.getTime());
            int diffInSeconds = (int) TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            
            return diffInSeconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; // Trả về -1 nếu có lỗi xảy ra
        }
    }

}