package View;

       

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import view.BanVeTauView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import java.util.Properties;
import java.util.Random;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import com.google.gson.Gson;

import Model.ModelKhachHang;

import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.net.Socket;

import java.awt.event.ActionEvent;


public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jttenDangnhap;
	private JTextField tfemail;
	private JTextField jtotp;
	private JPasswordField jpassword;
	public Color colordat = new Color(188, 254, 254);
	private JTextField tftendangnhap;
	private JPasswordField jpassmoi;
	private JCheckBox cbShowPassword2;
	private String body;
	private JTextField jthoten;
	private JTextField jtcccd;
	private JTextField jtemail;
	private JTextField jtsdt;
	private JTextField jtusername;
	private JPanel pn_dangky;
	private JPasswordField jpcreatepass;
	private JTextField jtotpcreate;
	private static Client client;
	// Truy vấn dữ liệu để đăng nhập
	

	
	public LoginUI(Client client) {
		this.client = client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginUI.class.getResource("/fileanh/hotel.png")));

		dongvangatkenoi();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		CardLayout cardinfo = new CardLayout();
		contentPane.setLayout(cardinfo);
		
		JPanel panel_DangnhapQL = new JPanel();
		contentPane.add(panel_DangnhapQL, "name_12224048742800");
		panel_DangnhapQL.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(363, 151, 450, 450);
		panel_DangnhapQL.add(panel_3);
		CardLayout cardtt = new CardLayout();
		panel_3.setLayout(cardtt);
		
		JPanel pn_nhapthongtin = new JPanel();
		pn_nhapthongtin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "......", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_nhapthongtin.setBackground(colordat);
		panel_3.add(pn_nhapthongtin, "thông tin");
		pn_nhapthongtin.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
		lblNewLabel_4.setBounds(32, 10, 372, 84);
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 25));
		pn_nhapthongtin.add(lblNewLabel_4);
		
		jttenDangnhap = new JTextField();
		jttenDangnhap.setBounds(20, 130, 412, 48);
		jttenDangnhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jttenDangnhap.setToolTipText("Nhập tên đăng nhập");
		pn_nhapthongtin.add(jttenDangnhap);
		jttenDangnhap.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nhập Tên Đăng Nhập:");
		lblNewLabel_5.setBounds(20, 86, 171, 48);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(SystemColor.desktop);
		pn_nhapthongtin.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nhập Mật Khẩu:");
		lblNewLabel_6.setBounds(20, 188, 155, 48);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(SystemColor.desktop);
		pn_nhapthongtin.add(lblNewLabel_6);
		
		JButton btdangnhap = new JButton("ĐĂNG NHẬP");
		btdangnhap.setBounds(175, 300, 258, 50);
		btdangnhap.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		

		pn_nhapthongtin.add(btdangnhap);
		
		JButton btnNewButton_2 = new JButton("Quên mật khẩu?");
		btnNewButton_2.setBounds(10, 370, 155, 50);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(pn_nhapthongtin);
				cardtt.show(panel_3, "quên");
				
			}
		});
		btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		pn_nhapthongtin.add(btnNewButton_2);
		
		jpassword = new JPasswordField();
		jpassword.setBounds(20, 228, 412, 48);
		jpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pn_nhapthongtin.add(jpassword);
		
		JCheckBox cbShowPassword = new JCheckBox("Hiển thị mật khẩu");
		cbShowPassword.setBounds(20, 280, 150, 20);
		cbShowPassword.setBackground(colordat);
        cbShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pn_nhapthongtin.add(cbShowPassword);
        
        JButton btdangky = new JButton("ĐĂNG KÝ");
        btdangky.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
        btdangky.setBounds(174, 370, 258, 50);
        btdangky.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
             cardtt.show(panel_3, "dangky");				
			}
		});
        pn_nhapthongtin.add(btdangky);
        
        JLabel lblNewLabel_2 = new JLabel("<html>Nếu bạn đã quên Mật khẩu <br> xin hãy chọn Quên mật khẩu<br> để đặt lại Mật khẩu<br> Nếu bạn chưa có tài khoản <br> xin hãy chọn Đăng ký</html>");
        lblNewLabel_2.setEnabled(false);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 9));
        lblNewLabel_2.setBounds(20, 300, 220, 70);
        pn_nhapthongtin.add(lblNewLabel_2);
        btdangnhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = jttenDangnhap.getText();
                String pass = new String(jpassword.getPassword());
                String data = username+"#"+pass;
				boolean result = CheckIn(data);
				if (result == true) {
				    // Đăng nhập thành công
					
				    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
				    
				    jttenDangnhap.setText("");
				    jpassword.setText("");
				    String khs = null;
				    try {
						khs = receiKH(username);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    Gson gs = new Gson();
				    ModelKhachHang kh = gs.fromJson(khs, ModelKhachHang.class);
				    dispose();
				    UserUI view = new UserUI(kh, client);
				    
				    
				    view.setVisible(true);
				    // Thực hiện các hành động tiếp theo sau khi đăng nhập thành công
				} else {
				    // Đăng nhập thất bại
				    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
				    jttenDangnhap.setText("");
				    jpassword.setText("");
				}
            }
        });
        

        cbShowPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cbShowPassword.isSelected()) {
                	jpassword.setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                	jpassword.setEchoChar('•'); // Ẩn mật khẩu
                }
            }
        });
		
		JPanel pn_NhapOTP = new JPanel();
		pn_NhapOTP.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), null, new Color(0, 255, 255), null), "......", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_NhapOTP.setBackground(colordat);
		panel_3.add(pn_NhapOTP, "quên");
		pn_NhapOTP.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_7.setBackground(SystemColor.activeCaption);
		lblNewLabel_7.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_7.setForeground(SystemColor.desktop);
		lblNewLabel_7.setBounds(10, 28, 238, 50);
		pn_NhapOTP.add(lblNewLabel_7);
		
		tfemail = new JTextField();
		tfemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfemail.setBounds(10, 266, 430, 44);
		pn_NhapOTP.add(tfemail);
		tfemail.setColumns(10);
		
		JButton btMinhDanh = new JButton("XÁC MINH DANH TÍNH");
		btMinhDanh.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		btMinhDanh.setBounds(119, 362, 210, 50);
		pn_NhapOTP.add(btMinhDanh);
		
		JLabel lblNewLabel_9 = new JLabel("Nhập Email Của Bạn");
		lblNewLabel_9.setForeground(SystemColor.desktop);
		lblNewLabel_9.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblNewLabel_9.setBounds(10, 224, 400, 44);
		pn_NhapOTP.add(lblNewLabel_9);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Nhập email để chúng tôi gửi mã OTP<br> để bảo vệ thông tin của bạn </html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(10, 67, 305, 64);
		pn_NhapOTP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Nhập Tên Đăng Nhập");
		lblNewLabel_9_1.setForeground(SystemColor.desktop);
		lblNewLabel_9_1.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblNewLabel_9_1.setBounds(10, 128, 400, 44);
		pn_NhapOTP.add(lblNewLabel_9_1);
		
		tftendangnhap = new JTextField();
		tftendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tftendangnhap.setColumns(10);
		tftendangnhap.setBounds(10, 168, 430, 44);
		pn_NhapOTP.add(tftendangnhap);
		
		JLabel lblNewLabel_14 = new JLabel("@gmail.com");
		lblNewLabel_14.setEnabled(false);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(364, 312, 100, 20);
		pn_NhapOTP.add(lblNewLabel_14);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(UserUI.class.getResource("/FileAnh/arrow-left.png")));
		btnNewButton_1.setBounds(10, 362, 50, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardtt.show(panel_3, "thông tin");
				
			}
		});
		pn_NhapOTP.add(btnNewButton_1);
		
		btMinhDanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tendangnhap = tftendangnhap.getText();
                String email = tfemail.getText();
                if (tendangnhap == null || tendangnhap.isEmpty() || email == null || email.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				    return;
				}

				if (!isValidEmail(email)) {
				    JOptionPane.showMessageDialog(null, "Email không hợp lệ!\n"+" Email phải có định dạng @gmail.com.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				    return;
				}

				if (checkXacthuc(tendangnhap, email)) {
				    mailxacthuc(email, "MAIL XÁC THỰC", "Xin chào bạn\n"+"Đây là mã dùng để đổi mật khẩu\n"+"TUYỆT ĐỐI KHÔNG CHIA SẺ MÃ NÀY VỚI AI!\n"+"Mã của bạn là:");
				    cardtt.show(panel_3,"changepass");
				} else {
				    JOptionPane.showMessageDialog(null, "Thông tin Tên Đăng Nhập hoặc email không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
			
		
		
		JPanel pn_Changepass = new JPanel();
		pn_Changepass.setBorder(new TitledBorder(null, "....", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pn_Changepass.setForeground(new Color(255, 255, 255));
		pn_Changepass.setBackground(colordat);
		panel_3.add(pn_Changepass, "changepass");
		pn_Changepass.setLayout(null);
		
		JLabel lblNewLabel_7_1 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_7_1.setForeground(Color.BLACK);
		lblNewLabel_7_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_7_1.setBounds(10, 23, 430, 64);
		pn_Changepass.add(lblNewLabel_7_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 112, 430, 228);
		pn_Changepass.add(panel_4);
		CardLayout cardchange = new CardLayout();
		panel_4.setLayout(cardchange);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255, 100));
		panel_4.add(panel_5, "name_18580681152400");
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Nhập mã OTP để đặt mật khẩu");
		lblNewLabel_10.setEnabled(false);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 21, 246, 33);
		panel_5.add(lblNewLabel_10);
		
		jtotp = new JTextField();
		jtotp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtotp.setBounds(10, 50, 410, 43);
		panel_5.add(jtotp);
		jtotp.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(UserUI.class.getResource("/FileAnh/right.png")));

		btnNewButton_3.setBounds(190, 168, 50, 50);
		panel_5.add(btnNewButton_3);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255, 100));
		panel_4.add(panel_6, "panelchangepass");
		panel_6.setLayout(null);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			     String otp= jtotp.getText();
			     if(otp.equals(body) ) {
			    	 cardchange.show(panel_4, "panelchangepass");
			     }
			}
		});
		
		JLabel lblNewLabel_11 = new JLabel("Nhập Mật Khẩu Mới ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setEnabled(false);
		lblNewLabel_11.setBounds(10, 20, 410, 31);
		panel_6.add(lblNewLabel_11);
		
		JButton btnNewButton_4 = new JButton("Xác Nhận ");
		btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setBounds(144, 177, 161, 41);
		panel_6.add(btnNewButton_4);
		
		jpassmoi = new JPasswordField();
		jpassmoi.setBounds(10, 50, 410, 40);
		panel_6.add(jpassmoi);
	
		btnNewButton_4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String newpass = new String(jpassmoi.getPassword());
		        try {
		            if (newpass.equals("")) {
		                JOptionPane.showMessageDialog(null, "Bạn cần phải nhập mật khẩu cần đổi", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            } else {
		                // Cập nhật mật khẩu mới vào cơ sở dữ liệu
		                String tendangnhap = tftendangnhap.getText();
		                if(ChangePass(tendangnhap, newpass)==true) {
		                	JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công!");
		                } else JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);

		                cardtt.show(panel_3, "thông tin");

		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		cbShowPassword2 = new JCheckBox("Hiển thị mật khẩu");
		cbShowPassword2.setBackground(new Color(250, 250, 210));
        cbShowPassword2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cbShowPassword2.setBounds(10, 94, 150, 20);
        panel_6.add(cbShowPassword2);
        
        pn_dangky = new JPanel();
        pn_dangky.setBackground(colordat);
        pn_dangky.setBorder(new TitledBorder(null, ".....", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.add(pn_dangky, "dangky");
        pn_dangky.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Đăng Ký Tài Khoản ");
        lblNewLabel_3.setBounds(119, 10, 245, 30);
        lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
        pn_dangky.add(lblNewLabel_3);
        
        JLabel lblNewLabel_8 = new JLabel("Họ và Tên:");
        lblNewLabel_8.setBounds(10, 60, 100, 30);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pn_dangky.add(lblNewLabel_8);
        
        JLabel lblNewLabel_8_1 = new JLabel("CCCD:");
        lblNewLabel_8_1.setBounds(10, 120, 100, 30);
        lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pn_dangky.add(lblNewLabel_8_1);
        
        JLabel lblNewLabel_8_2 = new JLabel("Email:");
        lblNewLabel_8_2.setBounds(10, 180, 100, 30);
        lblNewLabel_8_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pn_dangky.add(lblNewLabel_8_2);
        
        JLabel lblNewLabel_8_3 = new JLabel("SĐT:");
        lblNewLabel_8_3.setBounds(10, 240, 100, 30);
        lblNewLabel_8_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pn_dangky.add(lblNewLabel_8_3);
        
        JLabel lblNewLabel_8_4 = new JLabel("Tên đăng nhập:");
        lblNewLabel_8_4.setBounds(10, 300, 140, 30);
        lblNewLabel_8_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pn_dangky.add(lblNewLabel_8_4);
        JCheckBox cbShowPassword3 = new JCheckBox("Hiển thị mật khẩu");
		cbShowPassword3.setBounds(313, 306, 125, 20);
		cbShowPassword3.setBackground(colordat);
        cbShowPassword3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pn_dangky.add(cbShowPassword3);
        cbShowPassword3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cbShowPassword3.isSelected()) {
                	jpcreatepass.setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                	jpcreatepass.setEchoChar('•'); // Ẩn mật khẩu
                }
            }
        });
        
        jthoten = new JTextField();
        jthoten.setBounds(10, 89, 430, 30);
        jthoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pn_dangky.add(jthoten);
        jthoten.setColumns(10);
        
        jtcccd = new JTextField();
        jtcccd.setBounds(10, 148, 430, 30);
        jtcccd.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtcccd.setColumns(10);
        pn_dangky.add(jtcccd);
        
        jtemail = new JTextField();
        jtemail.setBounds(10, 209, 430, 30);
        jtemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtemail.setColumns(10);
        pn_dangky.add(jtemail);
        
        jtsdt = new JTextField();
        jtsdt.setBounds(10, 265, 430, 30);
        jtsdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtsdt.setColumns(10);
        pn_dangky.add(jtsdt);
        
        jtusername = new JTextField();
        jtusername.setBounds(10, 326, 200, 30);
        jtusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtusername.setColumns(10);
        pn_dangky.add(jtusername);
        
        JButton btxacnhanthong= new JButton("Xác Nhận Thông Tin");
        btxacnhanthong.setBounds(113, 407, 220, 35);
        btxacnhanthong.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 12));
        
        pn_dangky.add(btxacnhanthong);
        
        jpcreatepass = new JPasswordField();
        jpcreatepass.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jpcreatepass.setBounds(220, 326, 220, 30);
        pn_dangky.add(jpcreatepass);
        
        JLabel lblNewLabel_8_4_1 = new JLabel("Mật khẩu:");
        lblNewLabel_8_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_8_4_1.setBounds(220, 300, 100, 30);
        pn_dangky.add(lblNewLabel_8_4_1);
        
        JLabel lblNewLabel_8_4_1_1 = new JLabel("Nhập OTP :");
        lblNewLabel_8_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_8_4_1_1.setBounds(220, 367, 83, 30);
        pn_dangky.add(lblNewLabel_8_4_1_1);
        
        JLabel lblNewLabel_12 = new JLabel("<html>Lưu ý phải nhập OTP gửi về mail<br> mới đăng kí tài khoản được</html>");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblNewLabel_12.setEnabled(false);
        lblNewLabel_12.setBounds(280, 50, 160, 30);
        pn_dangky.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("@gmail.com");
        lblNewLabel_13.setEnabled(false);
        lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_13.setBounds(380, 190, 90, 15);
        pn_dangky.add(lblNewLabel_13);
        
        jtotpcreate = new JTextField();
        jtotpcreate.setEditable(false);
        jtotpcreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtotpcreate.setColumns(10);
        jtotpcreate.setBounds(313, 368, 127, 30);
        pn_dangky.add(jtotpcreate);
        
        JButton btotp = new JButton("Gửi mã OTP");
        btotp.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 12));
        btotp.setBounds(10, 366, 187, 35);
        btotp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username = jtusername.getText();
                String cccd= jtcccd.getText();
                if(checktontai(username, cccd)==false) {
                String email = jtemail.getText();
                jtotpcreate.setEditable(true);
                mailxacthuc(email, "Mã đăng ký", "Xin chào bạn.\n"+"Đây là mã kích hoạt tài khoản của bạn");				
                }else {
                	JOptionPane.showMessageDialog(null, "TÊN ĐĂNG NHẬP HOẶC CCCD ĐÃ TỒN TẠI");
                }
			}
                
		});
        pn_dangky.add(btotp);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(UserUI.class.getResource("/FileAnh/arrow-left.png")));
        btnNewButton.setBounds(10, 19, 40, 40);
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardtt.show(panel_3, "thông tin");
			}
		});
        
        pn_dangky.add(btnNewButton);
        btxacnhanthong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoten = jthoten.getText();
                String cccd = jtcccd.getText();
                String sdt = jtsdt.getText();
                String email = jtemail.getText();
                String username = jtusername.getText();
                String otp = jtotpcreate.getText();
                String pass = new String(jpcreatepass.getPassword());

                // Kiểm tra OTP
                if (otp.equals(body)) {
                    // OTP đúng, đăng ký tài khoản mới
                	//chèn thêm mã khách hàng
                	boolean check = checkDky(hoten, cccd, sdt, email, pass, username);
                	if(check == true) {
                		JOptionPane.showMessageDialog(null, "CHÚC MỪNG BẠN ĐÃ TẠO TÀI KHOẢN THÀNH CÔNG.");
                        cardtt.show(panel_3, "thông tin");
                	} else 
                		JOptionPane.showMessageDialog(null, "ĐÃ CÓ LỖI Ở KHI ĐĂNG KÝ.");
                } else {
                    // OTP không đúng
                    JOptionPane.showMessageDialog(null, "Mã OTP không đúng, vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        cbShowPassword2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cbShowPassword2.isSelected()) {
                	jpassmoi.setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                	jpassmoi.setEchoChar('•'); // Ẩn mật khẩu
                }
            }
        });
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pn_Danghoatdong.class.getResource("/FileAnh/anhks (1).jpg")));

		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(0, 0, 1176, 753);
		panel_DangnhapQL.add(lblNewLabel);
		this.setVisible(true );
	}


	
	public boolean CheckIn(String data){
		client.sendMessage("CHECKIN#"+data);
			String result = client.receiveMessage();
			if(result.equals("1")) return true;
			else return false;
	}
	
	public boolean checkDky(String hoten, String CCCD, String Sdth, String email, String mk, String Username) {
		client.sendMessage("CHECKDKY#"+hoten+"#"+CCCD+"#"+Sdth+"#"+email+"#"+mk+"#"+Username);
			String result = client.receiveMessage();
			if(result.equals("1")) return false;
			else return true;		
	}
	
	

	private boolean isValidEmail(String email) {
		// Kiểm tra xem email có chứa "@gmail.com" hay không
		return email != null && email.endsWith("@gmail.com");
		
	}
	
	
	public boolean ChangePass(String username, String newpass) {
		client.sendMessage("CHANGEPASS"+"#"+username+"#"+newpass);
		String result = client.receiveMessage();
		if(result.equals("1")) return false;
		else return true;	
	}
	
	public boolean checkXacthuc(String username, String email) {
		client.sendMessage("CHECKXACTHUC"+"#"+username+"#"+email);
		String result = client.receiveMessage();
		if(result.equals("1")) return true;
		else return false;	
	}
	
	public boolean checktontai(String username, String cccd) {
		client.sendMessage("CHECKTONTAI"+"#"+username+"#"+cccd);
		String result = client.receiveMessage();
		if(result.equals("1")) return true;
		else return false;	
	}
	
	
	private int taomaOTP() {
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000; // Corrected range
		return randomNumber;
	}
	
	

	public void mailxacthuc(String email, String tieude, String noidung) {
		String host = "smtp.gmail.com";
		final String user = "kimnganlele2015@gmail.com";
		final String password = "cduf yyef bpnj kuma"; // Replace with your actual password

		String to = email;
		String subject = tieude;
		body = String.valueOf(taomaOTP()); // Convert int to String
		client.sendMessage(noidung+"\n"+body);
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

			JOptionPane.showMessageDialog(null, "Đã gửi mail\n" + "Vui lòng kiểm tra mail của bạn");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public String receiKH(String username) throws IOException {
		client.sendMessage("TRUYENDULIEU"+"#"+username);
		return client.receiveMessage();
	}
	
	public void dongvangatkenoi() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				client.closeConnection();
				System.exit(0);
			}
		});
	}
}
	

	
	
	
	
	

	 
