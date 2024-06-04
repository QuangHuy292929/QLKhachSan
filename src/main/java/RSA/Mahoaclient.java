package RSA;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Mahoaclient {
    private static final Gson thongtin = new Gson();

    public static String maHoaDuLieu(String dulieugoc) throws Exception {
        // Tạo khóa bí mật ngẫu nhiên
        KeyGenerator khoaTao = KeyGenerator.getInstance("AES");
        SecureRandom ngauNhien = new SecureRandom();
        khoaTao.init(256, ngauNhien);
        SecretKey khoaBiMat = khoaTao.generateKey();

        // Mã hóa dữ liệu bằng AES
        Cipher maHoa = Cipher.getInstance("AES");
        maHoa.init(Cipher.ENCRYPT_MODE, khoaBiMat);
        byte[] duLieuDaMaHoa = maHoa.doFinal(dulieugoc.getBytes());

        // Chuyển đổi dữ liệu đã mã hóa và khóa bí mật thành chuỗi Base64
        String duLieuDaMaHoaBase64 = Base64.getEncoder().encodeToString(duLieuDaMaHoa);
        String khoaBiMatBase64 = Base64.getEncoder().encodeToString(khoaBiMat.getEncoded());

        // Tạo JSON object chứa dữ liệu đã mã hóa và khóa bí mật
        JsonObject jsonDoiTuong = new JsonObject();
        jsonDoiTuong.addProperty("dulieudamahoa", duLieuDaMaHoaBase64);
        jsonDoiTuong.addProperty("khoabimat", khoaBiMatBase64);

        // Chuyển đổi JSON object thành chuỗi
        return thongtin.toJson(jsonDoiTuong);
    }
}
