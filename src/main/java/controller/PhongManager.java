package controller;
import java.awt.CardLayout;   
import java.awt.Color;   

import javax.swing.JPanel;

import Model.Phong;
import View.pn_Choxacnhan;
import View.pn_Danghoatdong;
import View.pn_Datphong;

public class PhongManager extends Thread {
	public Phong phong;
	public JPanel panelPhong;
	public pn_Datphong datphong;
	public pn_Choxacnhan xacnhan;
	public pn_Danghoatdong hoatdong;
	public JPanel panelhienthi;
	public CardLayout layout;
   

    public PhongManager(Phong phong, JPanel panelPhong, CardLayout layout, pn_Datphong datphong, pn_Choxacnhan xacnhan,
			pn_Danghoatdong hoatdong, JPanel panelhienthi) {
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