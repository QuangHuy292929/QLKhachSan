package RSA;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Giaimaserver {
    private static final Gson thongtin = new Gson();

    public static String giaiMaDuLieu(String duLieuDaMaHoaJson) throws Exception {
        // Chuyển đổi chuỗi JSON thành JSON object
        JsonObject jsonDoiTuong = thongtin.fromJson(duLieuDaMaHoaJson, JsonObject.class);

        // Lấy dữ liệu đã mã hóa và khóa bí mật từ JSON object
        String duLieuDaMaHoaBase64 = jsonDoiTuong.get("dulieudamahoa").getAsString();
        String khoaBiMatBase64 = jsonDoiTuong.get("khoabimat").getAsString();

        // Giải mã dữ liệu
        byte[] duLieuDaMaHoa = Base64.getDecoder().decode(duLieuDaMaHoaBase64);
        byte[] khoaBiMatBytes = Base64.getDecoder().decode(khoaBiMatBase64);
        SecretKey khoaBiMat = new SecretKeySpec(khoaBiMatBytes, "AES");

        Cipher giaiMa = Cipher.getInstance("AES");
        giaiMa.init(Cipher.DECRYPT_MODE, khoaBiMat);
        byte[] duLieuDaGiaiMa = giaiMa.doFinal(duLieuDaMaHoa);

        // Trả về dữ liệu đã giải mã dưới dạng chuỗi
        return new String(duLieuDaGiaiMa);
    }
}
