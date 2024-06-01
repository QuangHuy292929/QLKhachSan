package View;

import java.awt.Dimension;       

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Model.Phong;
import Model.Phong.TrangThaiPhong;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;


public class pn_Choxacnhan extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btquaylai;
	public JButton btxacnhandat;
	public JButton btHuy;
	public Color colordat = new Color(205, 180, 219);
	public JTextField THovaten;
	public JTextField TCCCD;
	public JTextField TSdth;
	public JTextField TMadatphong;
	public double bill;
	protected DefaultTableModel db;
	protected JTextField TMaKH;
	protected JLabel lbMaPhong;
	
	/**
	 * Create the panel.
	 */
	public pn_Choxacnhan(Phong phong, pn_Danghoatdong hoatdong, UserUI view) {

		setPreferredSize(new Dimension(947, 742));
		setLayout(null);

		JLabel lbanh = new JLabel();
		lbanh.setIcon(new ImageIcon(pn_Choxacnhan.class.getResource("/FileAnh/resort.jpg")));
		lbanh.setSize(947, 742);

		JPanel pnthongtinchoxacnhan = new JPanel();
		pnthongtinchoxacnhan.setBackground(new Color(255, 255, 255));
		pnthongtinchoxacnhan
				.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), null),
						"   THÔNG TIN KHÁCH HÀNG   ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnthongtinchoxacnhan.setBounds(20, 10, 910, 553);
		add(pnthongtinchoxacnhan);
		pnthongtinchoxacnhan.setLayout(null);

		JPanel pn_buttonchoxacnhan = new JPanel();
		pn_buttonchoxacnhan.setBackground(new Color(255, 255, 255));
		pn_buttonchoxacnhan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pn_buttonchoxacnhan.setBounds(20, 573, 910, 67);
		add(pn_buttonchoxacnhan);

		JLabel lblNewLabel = new JLabel("ĐANG CHỜ XÁC NHẬN");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblNewLabel.setBounds(320, 23, 231, 30);
		pnthongtinchoxacnhan.add(lblNewLabel);

		Object dt[][] = {};
		String s[] = { "Tên dịch vụ", "Giá" };
		db = new DefaultTableModel(dt, s);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(128, 255, 255), new Color(128, 255, 255),
						new Color(128, 255, 255), null),
				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(10, 84, 466, 459);
		pnthongtinchoxacnhan.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Họ và Tên:  ");
		lblNewLabel_1.setBounds(10, 193, 134, 30);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNewLabel_4 = new JLabel("CCCD:");
		lblNewLabel_4.setBounds(10, 233, 134, 30);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNewLabel_3 = new JLabel("Số điện thoại :");
		lblNewLabel_3.setBounds(10, 273, 134, 30);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNewLabel_2 = new JLabel("Mã đặt phòng:");
		lblNewLabel_2.setBounds(10, 155, 134, 30);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNewLabel_5 = new JLabel("Mã khách hàng:");
		lblNewLabel_5.setBounds(10, 115, 134, 30);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));

		THovaten = new JTextField();
		THovaten.setBounds(168, 193, 288, 30);
		panel_1.add(THovaten);
		THovaten.setFont(new Font("Monospaced", Font.BOLD, 14));
		THovaten.setEditable(false);
		THovaten.setColumns(10);

		TCCCD = new JTextField();
		TCCCD.setBounds(168, 233, 288, 30);
		panel_1.add(TCCCD);
		TCCCD.setFont(new Font("Monospaced", Font.BOLD, 14));
		TCCCD.setEditable(false);
		TCCCD.setColumns(10);

		TSdth = new JTextField();
		TSdth.setBounds(168, 273, 288, 30);
		panel_1.add(TSdth);
		TSdth.setFont(new Font("Monospaced", Font.BOLD, 14));
		TSdth.setEditable(false);
		TSdth.setColumns(10);

		TMadatphong = new JTextField();
		TMadatphong.setBounds(168, 155, 288, 30);
		panel_1.add(TMadatphong);
		TMadatphong.setFont(new Font("Monospaced", Font.BOLD, 14));
		TMadatphong.setEditable(false);
		TMadatphong.setColumns(10);

		TMaKH = new JTextField();
		TMaKH.setFont(new Font("Monospaced", Font.BOLD, 14));
		TMaKH.setEditable(false);
		TMaKH.setColumns(10);
		TMaKH.setBounds(168, 115, 288, 30);
		panel_1.add(TMaKH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(128, 255, 255), null, new Color(128, 255, 255), null),
				"D\u1ECBch v\u1EE5 \u0111\u1EB7t tr\u01B0\u1EDBc", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_2.setBounds(486, 84, 414, 459);
		pnthongtinchoxacnhan.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 86, 394, 180);
		panel_2.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JTable tb = new JTable();
		tb.setFont(new Font("Arial", Font.PLAIN, 12));
		tb.setModel(db);
		JScrollPane scrollPane = new JScrollPane(tb);
		panel.add(scrollPane, BorderLayout.CENTER);

		JLabel lblNewLabel_6 = new JLabel("Các dịch vụ đã chọn:");
		lblNewLabel_6.setBounds(10, 46, 189, 30);
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblNewLabel_7 = new JLabel("Mã phòng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(583, 47, 80, 27);
		pnthongtinchoxacnhan.add(lblNewLabel_7);

		lbMaPhong = new JLabel("");
		lbMaPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbMaPhong.setBounds(673, 47, 87, 27);
		pnthongtinchoxacnhan.add(lbMaPhong);
		pn_buttonchoxacnhan.setLayout(null);

		btquaylai = new JButton("Quay lại ");
		btquaylai.setBounds(10, 10, 148, 50);
		btquaylai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_buttonchoxacnhan.add(btquaylai);
		btquaylai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
			}
		});

		btHuy = new JButton("Hủy phòng");
		btHuy.setBounds(601, 9, 141, 53);
		btHuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_buttonchoxacnhan.add(btHuy);
		btHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int luachon = JOptionPane.showConfirmDialog(view, "Xác nhận hủy phòng");
				huyphong(luachon, phong, view);
			}
		});

		btxacnhandat = new JButton("Xác nhận đặt ");
		btxacnhandat.setBounds(752, 10, 148, 50);
		btxacnhandat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_buttonchoxacnhan.add(btxacnhandat);
		btxacnhandat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
				String formattedDateTime = now.format(formatter);
				datphong(hoatdong, phong, formattedDateTime);
				int maphong = Integer.parseInt(lbMaPhong.getText());
				view.xacnhan(maphong , formattedDateTime);
				db.setRowCount(0);
			}
		});
		JLabel lblNewLabel_61 = new JLabel();
		lblNewLabel_61.setIcon(new ImageIcon(pn_Datphong.class.getResource("/FileAnh/resort.jpg")));
		lblNewLabel_61.setSize(947, 742);
		add(lblNewLabel_61);

	
	}
	
	public void huyphong(int luachon, Phong phong, UserUI view ) {
		if(luachon == JOptionPane.OK_OPTION) {
			phong.setTrangThai(TrangThaiPhong.TRONG);
			view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
			view.Cancel(phong.getId()+"");
			db.setRowCount(0);
		}
	}
	
	public void datphong(pn_Danghoatdong hoatdong, Phong phong, String tgian) {
		phong.setTrangThai(TrangThaiPhong.DANG_HOAT_DONG);
		// phương thức chuyển thông tin sang panel đặt phòng
		hoatdong.THovaten.setText(THovaten.getText());
		hoatdong.TCCCD.setText(TCCCD.getText());				
		hoatdong.TSDTH.setText(TSdth.getText());
		hoatdong.TNgayGioNHanPhong.setText(tgian);
		hoatdong.TMadatphong.setText(TMadatphong.getText());
		hoatdong.TMaKH.setText(TMaKH.getText());
		hoatdong.lbMaPhong.setText(phong.getId()+"");
		for (int row = 0; row < db.getRowCount(); row++) {
			Object[] rowData = new Object[db.getColumnCount()];
			for (int col = 0; col < db.getColumnCount(); col++) {
				rowData[col] = db.getValueAt(row, col);
			}
			hoatdong.db.addRow(rowData);
		}
	}
	
	
	
}