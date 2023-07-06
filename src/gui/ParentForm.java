package gui;

import static dao.XuLyCSDL.getNhanVien;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;

public class ParentForm extends JFrame{
    JMenuBar mb;
    JMenu menu;
    JMenu menuChucNang;
    JMenuItem itemHoSo;
    JMenuItem itemDangXuat;
    JMenuItem itemThoat;
    JMenuItem itemGoiMon;
    JMenuItem itemChucVu;
    JMenuItem itemNhanVien;
    JMenuItem itemHoaDon;
    JMenuItem itemVatTu;
    JMenuItem itemNhapKho;
    JMenuItem itemMonAn;
    JMenuItem itemCheBien;
    JMenuItem itemLuongThuong;
    JMenuItem itemTaiKhoan;
    JMenuItem itemPhongBan;
    FormHoSo jFormHoSo;
    NonEditableTableModel dtm = new NonEditableTableModel();
    Calendar cal = Calendar.getInstance(); 

    public ParentForm() throws HeadlessException {
        getContentPane().setBackground(new Color(255, 255, 255));
        mb = new JMenuBar();  
        mb.setBorder(BorderFactory.createEmptyBorder());
        menu = new JMenu("Menu");  
        
        if (getNhanVien().getMaNV() != 0)
        {
            itemHoSo = new JMenuItem("Hồ sơ");  
            menu.add(itemHoSo); 
            
            itemHoSo.addActionListener((ActionEvent e) -> {
            jFormHoSo = new FormHoSo(getNhanVien());
        });
        }
        
        itemDangXuat = new JMenuItem("Đăng xuất");  
        itemThoat = new JMenuItem("Thoát");     
        menu.add(itemDangXuat); 
        menu.add(itemThoat);
        
        menuChucNang = new JMenu("Chức năng");
        itemGoiMon = new JMenuItem("Gọi món");  
        menuChucNang.add(itemGoiMon);   
        
        mb.add(menu);
        mb.add(menuChucNang);

        itemDangXuat.addActionListener((ActionEvent e) -> {
            if (jFormHoSo != null)
            {
                jFormHoSo.setVisible(false);
                jFormHoSo.dispose();
            }
            
            new FormDangNhap();
            setVisible(false);
            dispose();
        });
        
        itemThoat.addActionListener((ActionEvent e) -> {
            System.exit(0);
        }); 
        
        itemGoiMon.addActionListener((ActionEvent e) -> {
            new FormGoiMon();
            setVisible(false);
            dispose();
        }); 
        
        if (getNhanVien().getChucVu().getMaCV() == 1)
        {
            setupQuanLy();
        }
        
        setJMenuBar(mb);
    }  
    
    private void setupQuanLy()
    {
        itemChucVu = new JMenuItem("Chức vụ"); 
        itemNhanVien = new JMenuItem("Nhân viên"); 
        itemHoaDon = new JMenuItem("Hóa đơn"); 
        itemVatTu = new JMenuItem("Vật tư"); 
        itemNhapKho = new JMenuItem("Nhập kho"); 
        itemMonAn = new JMenuItem("Món ăn"); 
        itemCheBien = new JMenuItem("Chế biến"); 
        itemLuongThuong = new JMenuItem("Lương thưởng");   
        itemTaiKhoan = new JMenuItem("Tài khoản");
        itemPhongBan = new JMenuItem("Phòng bàn");
        
        menuChucNang.add(itemPhongBan);
        menuChucNang.add(itemHoaDon);
        menuChucNang.add(itemVatTu);
        menuChucNang.add(itemNhapKho);
        menuChucNang.add(itemMonAn);
        menuChucNang.add(itemCheBien);
        menuChucNang.add(itemChucVu);
        menuChucNang.add(itemNhanVien);
        menuChucNang.add(itemLuongThuong);
        menuChucNang.add(itemTaiKhoan);
        
        itemChucVu.addActionListener((ActionEvent e) -> {
            new FormChucVu();
            setVisible(false);
            dispose();
        }); 

        itemNhanVien.addActionListener((ActionEvent e) -> {
            new FormNhanVien();
            setVisible(false);
            dispose();
        }); 

        itemHoaDon.addActionListener((ActionEvent e) -> {
            new FormHoaDon();
            setVisible(false);
            dispose();
        }); 

        itemVatTu.addActionListener((ActionEvent e) -> {
            new FormVatTu();
            setVisible(false);
            dispose();
        }); 

        itemNhapKho.addActionListener((ActionEvent e) -> {
            new FormNhapKho();
            setVisible(false);
            dispose();
        }); 

        itemMonAn.addActionListener((ActionEvent e) -> {
            new FormMonAn();
            setVisible(false);
            dispose();
        }); 

        itemCheBien.addActionListener((ActionEvent e) -> {
            new FormCheBien();
            setVisible(false);
            dispose();
        }); 

        itemLuongThuong.addActionListener((ActionEvent e) -> {
            new FormLuongThuong();
            setVisible(false);
            dispose();
        }); 

        itemTaiKhoan.addActionListener((ActionEvent e) -> {
            new FormTaiKhoan();
            setVisible(false);
            dispose();
        });
        
        itemPhongBan.addActionListener((ActionEvent e) -> {
            new FormPhongBan();
            setVisible(false);
            dispose();
        });
    }
}
