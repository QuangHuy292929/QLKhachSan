package View;

import javax.swing.JPanel;    
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Model.Phong;
import Model.Phong.TrangThaiPhong;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;


public class Bill extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	protected JTextField TTongTien;
	protected JTextField TMakH;
	protected JTextField TTenKH;
	protected JTextField TSdth;
	protected JTextField TNgayvao;
	protected JTextField TNgayRa;
	public DefaultTableModel db;
	protected DefaultTableModel dbsau;
	protected JLabel lbMaPhong;
	protected JTextField TThue;
	protected String CCCD;
	protected String Ngaysinh;

	/**
	 * Create the panel.
	 */
	public Bill(Phong phong, UserUI view) {

		getContentPane().setLayout(null);
		setSize(564, 800);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("<html><center>HÓA ĐƠN KHÁCH HÀNG</center></html>");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(10, 10, 315, 42);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 96, 123, 20);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(33, 126, 123, 20);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(33, 153, 123, 20);
		getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Ngày & Giờ vào:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(33, 183, 123, 20);
		getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_2 = new JLabel("Dịch vụ đặt trước:");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 243, 429, 42);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Dịch vụ đặt sau:");
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(10, 432, 429, 30);
		getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("Tổng tiền:");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 665, 127, 30);
		getContentPane().add(lblNewLabel_3);

		TTongTien = new JTextField();
		TTongTien.setEditable(false);
		TTongTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		TTongTien.setBounds(147, 667, 393, 30);
		getContentPane().add(TTongTien);
		TTongTien.setColumns(10);

		JButton NutXacnhan = new JButton("XÁC  NHẬN THANH TOÁN");
		NutXacnhan.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		NutXacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuatfile();
				String JSBILL = convertBilltoJson();
				System.out.println(JSBILL);
				//phương thức truyền định dạng dữ liệu lại bằng Json và đưa lên sever thông qua socket
				dispose();
				phong.setTrangThai(TrangThaiPhong.TRONG);
				view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
			}
		});
		NutXacnhan.setBounds(10, 707, 530, 46);
		getContentPane().add(NutXacnhan);

		JLabel lblNewLabel_4 = new JLabel("Ngày&Giờ ra:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(33, 213, 123, 20);
		getContentPane().add(lblNewLabel_4);

		TMakH = new JTextField();
		TMakH.setEditable(false);
		TMakH.setBounds(166, 96, 287, 20);
		getContentPane().add(TMakH);
		TMakH.setColumns(10);

		TTenKH = new JTextField();
		TTenKH.setEditable(false);
		TTenKH.setColumns(10);
		TTenKH.setBounds(166, 126, 287, 20);
		getContentPane().add(TTenKH);

		TSdth = new JTextField();
		TSdth.setEditable(false);
		TSdth.setColumns(10);
		TSdth.setBounds(166, 156, 287, 20);
		getContentPane().add(TSdth);

		TNgayvao = new JTextField();
		TNgayvao.setEditable(false);
		TNgayvao.setColumns(10);
		TNgayvao.setBounds(166, 186, 287, 20);
		getContentPane().add(TNgayvao);

		TNgayRa = new JTextField();
		TNgayRa.setEditable(false);
		TNgayRa.setColumns(10);
		TNgayRa.setBounds(166, 213, 287, 20);
		getContentPane().add(TNgayRa);

		JPanel panel = new JPanel();
		panel.setBounds(10, 295, 530, 141);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable();
		String s[] = { "Tên dịch vụ", "Đơn giá", "số lượng", "Thành tiền" };
		Object datatruoc[][] = {
				
		};
		db = new DefaultTableModel(datatruoc, s);
		table.setModel(db);
		
		JScrollPane sc = new JScrollPane(table);
		
		panel.add(sc);
		table.setBounds(10, 295, 526, 162);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 461, 530, 154);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		table_1 = new JTable();
		Object datasau[][] = {};
		dbsau = new DefaultTableModel(datasau, s);
		table_1.setModel(dbsau);
		JScrollPane sc1 = new JScrollPane(table_1);
		panel_1.add(sc1);
		
		JLabel lblNewLabel_5 = new JLabel("Mã phòng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(335, 36, 54, 20);
		getContentPane().add(lblNewLabel_5);
		
		lbMaPhong = new JLabel("");
		lbMaPhong.setBounds(394, 36, 59, 20);
		getContentPane().add(lbMaPhong);
		
		JLabel lblNewLabel_6 = new JLabel("Thuế 20%:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 625, 85, 30);
		getContentPane().add(lblNewLabel_6);
		
		TThue = new JTextField();
		TThue.setEditable(false);
		TThue.setBounds(107, 625, 155, 30);
		getContentPane().add(TThue);
		TThue.setColumns(10);
		setVisible(true);
	}
	
	public void xuatfile() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);
        
        // Tạo tên file với timestamp và thư mục đích
        String directoryPath = "C:\\Users\\OS\\OneDrive\\Computer\\JAVA_HUY\\Bill_Khach_san";
        File directory = new File(directoryPath);
        
        // Tạo thư mục nếu chưa tồn tại
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Tạo đường dẫn file
        String fileName = directoryPath + File.separator + "Bill_" + timestamp + ".txt";
        
        try(BufferedWriter in = new BufferedWriter(new FileWriter(fileName))) {
        	in.write("=========================== HÓA ĐƠN KHÁCH HÀNG ===========================\n");
        	in.write("   Mã khách hàng: " + TMakH.getText() + "\n");
        	in.write("   Tên khách hàng: " + TTenKH.getText() + "\n");
        	in.write("   Mã phòng: "+lbMaPhong.getText()+"\n");
        	in.write("   Số điện thoại:"+TSdth.getText()+"\n");
        	in.write("   Ngày & Giờ vào phòng: "+TNgayvao.getText()+"\n");
        	in.write("   Ngay & Giờ ra phòng: "+TNgayRa.getText()+"\n");
        	in.write("--------------Dịch vụ đặt trước--------------\n");
        	in.write("Tên dịch vụ    Đơn giá  Số lượng   Thành tiền\n");
        	for(int row = 0; row < db.getRowCount(); row++) {
        		String col1Value = db.getValueAt(row, 0)+"";
                String col2Value = db.getValueAt(row, 1)+"";
                String col3value = db.getValueAt(row, 2)+"";
                String col4val = db.getValueAt(row, 3)+"";
                in.write(col1Value+"    "+col2Value+"    "+col3value+"    "+col4val+"\n");
        	}
        	in.write("--------------Dịch vụ đặt sau--------------\n");
        	in.write("Tên dịch vụ    Đơn giá  Số lượng   Thành tiền\n");
        	for(int row = 0; row < dbsau.getRowCount(); row++) {
        		String col1Value = dbsau.getValueAt(row, 0)+"";
                String col2Value = dbsau.getValueAt(row, 1)+"";
                String col3value = dbsau.getValueAt(row, 2)+"";
                String col4val = dbsau.getValueAt(row, 3)+"";
                in.write(col1Value+"    "+col2Value+"    "+col3value+"    "+col4val+"\n");
        	}
        	in.write("\n");
        	in.write("Thuế 20%: "+TThue.getText()+"\n");
        	in.write("Tổng hóa đơn: "+TTongTien.getText()+"\n");
        	in.write("==========================================================================\n");
        	in.close();
        	JOptionPane.showMessageDialog(null, "Thanh toán và xuất file thành công");
		} catch (Exception e) {
			System.out.println("Lỗi khi ghi file: " + e.getMessage());
		}
        
        
	}
	
	public String convertBilltoJson() {
		JsonObject jsonbill = new JsonObject();
		jsonbill.addProperty("makhachhang", TMakH.getText());
		jsonbill.addProperty("maphong", lbMaPhong.getText());
		jsonbill.addProperty("CCCD", CCCD);
		jsonbill.addProperty("ngaysinh", Ngaysinh);
		jsonbill.addProperty("tenkhachhang", TTenKH.getText());
		jsonbill.addProperty("Sdth", TSdth.getText());
		jsonbill.addProperty("NgayVao", TNgayvao.getText());
		jsonbill.addProperty("NgayRa", TNgayRa.getText());
		JsonArray JsTruoc = new JsonArray();
		for(int i=0;i<db.getRowCount();i++) {
			JsonObject jsob = new JsonObject();
			jsob.addProperty("tendichvu", db.getValueAt(i, 0)+"");
			jsob.addProperty("dongia", db.getValueAt(i, 1)+"");
			jsob.addProperty("soluong", db.getValueAt(i, 2)+"");
			jsob.addProperty("thanhtien", db.getValueAt(i, 3)+"");
			JsTruoc.add(jsob);
		}
		jsonbill.add("dichvutruoc", JsTruoc);
		JsonArray JsSau = new JsonArray();
		for(int i=0;i<dbsau.getRowCount();i++) {
			JsonObject jsob = new JsonObject();
			jsob.addProperty("tendichvu", dbsau.getValueAt(i, 0)+"");
			jsob.addProperty("dongia", dbsau.getValueAt(i, 1)+"");
			jsob.addProperty("soluong", dbsau.getValueAt(i, 2)+"");
			jsob.addProperty("thanhtien", dbsau.getValueAt(i, 3)+"");
			JsSau.add(jsob);
		}
		jsonbill.add("dichvusau", JsSau);
		jsonbill.addProperty("thue", TThue.getText());
		jsonbill.addProperty("tongtien", TTongTien.getText());
		return jsonbill.toString();
	}
	
	
}
