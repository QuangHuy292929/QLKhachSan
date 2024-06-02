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

import Model.Phong;
import Model.Phong.TrangThaiPhong;
import controller.connectdatabase;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.awt.event.ActionEvent;


public class Bill extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	protected JTextField TTongTien;
	protected JTextField TMakH;
	protected JTextField TTenKH;
	protected JTextField TNgayvao;
	protected JTextField TNgayRa;
	public DefaultTableModel db;
	protected DefaultTableModel dbsau;
	protected JLabel lbMaPhong;
	protected JTextField TThue;
	protected String CCCD;
	protected String Ngaysinh;
	protected JTextField TMadp;
	protected JTextField TTienPhong;
	private DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");


	/**
	 * Create the panel.
	 */
	public Bill(Phong phong, ManagerUI view) {

		getContentPane().setLayout(null);
		setSize(564, 800);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("<html><center>HÓA ĐƠN KHÁCH HÀNG</center></html>");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(10, 10, 315, 42);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 73, 123, 20);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(31, 127, 123, 20);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_4 = new JLabel("Ngày & Giờ vào:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(31, 154, 123, 20);
		getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_2 = new JLabel("Dịch vụ đặt trước:");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 259, 429, 35);
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
				int madp = Integer.parseInt(TMadp.getText());
				thongtintraphong(madp, view);
				//insertdatabase 
				dispose();
				phong.setTrangThai(TrangThaiPhong.TRONG);
				view.cardhd.show(view.pn_hoatdong, "sơ đồ phòng");
			}
		});
		NutXacnhan.setBounds(10, 707, 530, 46);
		getContentPane().add(NutXacnhan);

		JLabel lblNewLabel_4 = new JLabel("Ngày&Giờ ra:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(31, 181, 123, 20);
		getContentPane().add(lblNewLabel_4);

		TMakH = new JTextField();
		TMakH.setEditable(false);
		TMakH.setBounds(164, 73, 287, 20);
		getContentPane().add(TMakH);
		TMakH.setColumns(10);

		TTenKH = new JTextField();
		TTenKH.setEditable(false);
		TTenKH.setColumns(10);
		TTenKH.setBounds(164, 127, 287, 20);
		getContentPane().add(TTenKH);

		TNgayvao = new JTextField();
		TNgayvao.setEditable(false);
		TNgayvao.setColumns(10);
		TNgayvao.setBounds(164, 154, 287, 20);
		getContentPane().add(TNgayvao);

		TNgayRa = new JTextField();
		TNgayRa.setEditable(false);
		TNgayRa.setColumns(10);
		TNgayRa.setBounds(164, 181, 287, 20);
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã đặt phòng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(31, 100, 123, 20);
		getContentPane().add(lblNewLabel_1_2);
		
		TMadp = new JTextField();
		TMadp.setEditable(false);
		TMadp.setColumns(10);
		TMadp.setBounds(164, 100, 287, 20);
		getContentPane().add(TMadp);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tiền phòng:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(10, 227, 142, 39);
		getContentPane().add(lblNewLabel_4_1);
		
		TTienPhong = new JTextField();
		TTienPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		TTienPhong.setEditable(false);
		TTienPhong.setColumns(10);
		TTienPhong.setBounds(164, 227, 376, 39);
		getContentPane().add(TTienPhong);
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
        	in.write("   Mã đặt phòng: " + TMadp.getText() + "\n");
        	in.write("   Tên khách hàng: " + TTenKH.getText() + "\n");
        	in.write("   Mã phòng: "+lbMaPhong.getText()+"\n");	
        	in.write("   Ngày & Giờ vào phòng: "+TNgayvao.getText()+"\n");
        	in.write("   Ngay & Giờ ra phòng: "+TNgayRa.getText()+"\n");
        	in.write("   Tiền phòng: "+TTienPhong.getText()+"\n");
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
	// tạo mã
	 public  String taomasudungdv() {
		 String madp = TMadp.getText();
		 Random random = new Random();
	     int randomNumber = random.nextInt(899) + 100;
	     return madp+ randomNumber;
	    }
	 public String taomathanhtoan() {
		 String masddv= taomasudungdv();
			LocalDateTime now = LocalDateTime.now();
		    String dateTimeString = now.format(DATE_TIME_FORMATTER);
			return  masddv + dateTimeString;
		}
	 // xử lí bảng lên dtb
	public void luuDichVuTruoc(Connection connect, String maKhachHang, int maDP, ManagerUI view) {
	    PreparedStatement preparedStatement = null;

	    try {
	        // Lấy dữ liệu từ bảng JTable "db"
	        for (int row = 0; row < db.getRowCount(); row++) {
	            String tenDichVu = db.getValueAt(row, 0)+"";
	            int madv = 0;
	            for(int i = 9; i<17; i++) {
	            	if (view.danhsachDV[i].getTenDichvu().equals(tenDichVu)) {
						madv = i;
					}
	            }
	            
	            String donGias = db.getValueAt(row, 1)+"";
	            int donGia = ManagerUI.convert(donGias);
	            String soluongs = db.getValueAt(row, 2)+"";
	            int soLuong = ManagerUI.convert(soluongs);
	            String thanhTiens = db.getValueAt(row, 3)+"";
	            int thanhTien = ManagerUI.convert(thanhTiens);

	            // Tạo mã sử dụng dịch vụ
	            String maSuDungDichVu = taomasudungdv();

	            // Tạo câu lệnh SQL INSERT
	            String sql = "INSERT INTO sudungthemdichvu (MASDDV, MADP, MADV, SLDV, CHIPHI) VALUES (?, ?, ?, ?, ?)";
	            preparedStatement = connect.prepareStatement(sql);

	            // Gán giá trị cho các tham số
	            preparedStatement.setString(1, maSuDungDichVu);
	            preparedStatement.setInt(2, maDP);
	            preparedStatement.setInt(3, madv); // Lấy mã dịch vụ từ tên dịch vụ
	            preparedStatement.setInt(4, soLuong);
	            preparedStatement.setInt(5, thanhTien);

	            // Thực thi câu lệnh SQL
	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng tài nguyên PreparedStatement
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void luuDichVuSau(Connection connect, String maKhachHang, int maDP, ManagerUI view ) {
	    PreparedStatement preparedStatement = null;
	    try {
	        // Lấy dữ liệu từ bảng JTable "dbsau"
	        for (int row = 0; row < dbsau.getRowCount(); row++) {
	            String tenDichVu = dbsau.getValueAt(row, 0)+"";
	            int madv = 0;
	            for(int i = 0; i<9; i++) {
	            	if (view.danhsachDV[i].getTenDichvu().equals(tenDichVu)) {
						madv = i;
					}
	            }
	            String donGias = dbsau.getValueAt(row, 1)+"";
	            int donGia = ManagerUI.convert(donGias);
	            String soluongs = dbsau.getValueAt(row, 2)+"";
	            int soLuong = ManagerUI.convert(soluongs);
	            String thanhTiens = dbsau.getValueAt(row, 3)+"";
	            int thanhTien = ManagerUI.convert(thanhTiens);

	            // Tạo mã sử dụng dịch vụ
	            String maSuDungDichVu = taomasudungdv();

	            // Tạo câu lệnh SQL INSERT
	            String sql = "INSERT INTO sudungthemdichvu (MASDDV, MADP, MADV, SLDV, CHIPHI) VALUES (?, ?, ?, ?, ?)";
	            preparedStatement = connect.prepareStatement(sql);

	            // Gán giá trị cho các tham số
	            preparedStatement.setString(1, maSuDungDichVu);
	            preparedStatement.setInt(2, maDP);
	            preparedStatement.setInt(3, madv); // Lấy mã dịch vụ từ tên dịch vụ
	            preparedStatement.setInt(4, soLuong);
	            preparedStatement.setDouble(5, thanhTien);

	            // Thực thi câu lệnh SQL
	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng tài nguyên PreparedStatement
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public boolean thongtintraphong(int maDp, ManagerUI view) {
	    Connection connect = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        // Kết nối đến database
	        connect = connectdatabase.getConnection();

	        // Bắt đầu Transaction
	        connect.setAutoCommit(false);

	        // Lấy thông tin từ các JTextField
	        String maKhachHang = TMakH.getText();
	        String madatphong = TMadp.getText();
	        String tenKhachHang = TTenKH.getText();
	        String maPhong = lbMaPhong.getText();
	        String ngayVao = TNgayvao.getText();
	        String ngayRa = TNgayRa.getText();
	        int tienphong = ManagerUI.convert(TTienPhong.getText());
	        int thue = ManagerUI.convert(TThue.getText());
	        int tongtien = ManagerUI.convert(TTongTien.getText());
	        LocalDateTime now = LocalDateTime.now();
		    String ngaygiott = now.format(DATE_TIME_FORMATTER);


	        // Tạo câu lệnh SQL INSERT cho bảng datphong
	        String sql1 = "INSERT INTO datphong (MADP, MAKH, MAPHONG, NGAYGIOVP, NGAYGIOTP, CHIPHI) VALUES (?, ?, ?, ?, ?, ?)";
	        preparedStatement = connect.prepareStatement(sql1);
	        preparedStatement.setString(1, madatphong); // Tạo mã đặt phòng
	        preparedStatement.setString(2, maKhachHang);
	        preparedStatement.setString(3, maPhong);
	        preparedStatement.setString(4, ngayVao);
	        preparedStatement.setString(5, ngayRa);
	        preparedStatement.setInt(6, tienphong); // Giả sử chi phí đặt phòng là tổng tiền
	        preparedStatement.executeUpdate();

	        // Tạo câu lệnh SQL INSERT cho bảng thanhtoan
	        String sql2 = "INSERT INTO thanhtoan (MATHANHTOAN, MADP, NGAYGIOTT, THUE, TONGCHIPHI) VALUES (?, ?, ?, ?, ?)";
	        preparedStatement = connect.prepareStatement(sql2);
	        preparedStatement.setString(1, taomathanhtoan()); // Tạo mã thanh toán
	        preparedStatement.setString(2, madatphong); // Sử dụng mã đặt phòng từ bước trước
	        preparedStatement.setString(3, ngaygiott); // Ngày giờ thanh toán là ngày giờ trả phòng
	        preparedStatement.setInt(4, thue);
	        preparedStatement.setInt(5, tongtien);
	        preparedStatement.executeUpdate();

	        // Lưu dữ liệu từ bảng JTable "db" vào bảng sudungdichvu
	        luuDichVuTruoc(connect, maKhachHang, maDp, view);

	        // Lưu dữ liệu từ bảng JTable "dbsau" vào bảng sudungdichvu
	        luuDichVuSau(connect, maKhachHang, maDp, view);

	        // Commit Transaction
	        connect.commit();
	        return true; // Lưu thông tin thành công

	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	        try {
	            // Rollback Transaction nếu có lỗi
	            if (connect != null) {
	                connect.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        
	    } finally {
	        // Đóng các tài nguyên
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return false; // Lưu thông tin thất bại
	}
}
