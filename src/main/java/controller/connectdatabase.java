package controller;

import java.sql.Connection;     
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectdatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private connectdatabase() {
        // Không cho phép khởi tạo đối tượng từ lớp này
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Đăng ký trình điều khiển JDBC cho MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Tạo kết nối đến cơ sở dữ liệu
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.out.println("Không tìm thấy trình điều khiển JDBC cho MySQL");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Lỗi khi đóng kết nối đến cơ sở dữ liệu");
                e.printStackTrace();
            }
        }
    }
}
