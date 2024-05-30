package controller;
import java.awt.CardLayout;    
import java.awt.Color;   

import javax.swing.JPanel;

import Model.Phong;
import View.pn_ChoxacnhanQL;
import View.pn_DanghoatdongQL;
import View.pn_DatphongQL;

public class PhongManagerQL extends Thread {
    public Phong phong;
    public JPanel panelPhong;
    public pn_DatphongQL datphong;
    public pn_ChoxacnhanQL xacnhan;
    public pn_DanghoatdongQL hoatdong;
    private JPanel panelhienthi;
    private CardLayout layout;
   

    public PhongManagerQL(Phong phong, JPanel panelPhong, CardLayout layout, pn_DatphongQL datphong, pn_ChoxacnhanQL xacnhan,
			pn_DanghoatdongQL hoatdong, JPanel panelhienthi) {
		this.phong = phong;
		this.panelPhong = panelPhong;
		this.layout = layout;
		this.datphong = datphong;
		this.xacnhan = xacnhan;
		this.hoatdong = hoatdong;
		
	}
        

	public Color colordat = new Color(205, 180, 219);
    public Color colorchoxacnhan = new Color(255, 200, 221);

    @Override
    public void run() {
        while (!isInterrupted()) {
            // Mô phỏng trạng thái phòng thay đổi
            switch (phong.getTrangThai()) {
                case TRONG:
                	panelPhong.setBackground(Color.getHSBColor(0, 0, (float) 0.94));
                	datphong.setVisible(true);
                	xacnhan.setVisible(false);
                	hoatdong.setVisible(false);
                	break;
                case DANG_HOAT_DONG:
                	panelPhong.setBackground(colordat);
                	datphong.setVisible(false);
                	xacnhan.setVisible(false);
                	hoatdong.setVisible(true);
                	break;
                case CHO_XAC_NHAN:
                	panelPhong.setBackground(colorchoxacnhan);
                	datphong.setVisible(false);
                	xacnhan.setVisible(true);
                	hoatdong.setVisible(false);
                	break;
            }

            try {
            	
                Thread.sleep(1000);
                
                // Mô phỏng thời gian xử lý
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}