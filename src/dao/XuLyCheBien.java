package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.CheBien;
import pojo.DanhSach;
import pojo.MonAn;
import pojo.VatTu;

public class XuLyCheBien {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("CheBien");
            
            while (resultSet.next())
            {
                CheBien cb = new CheBien();
                
                VatTu vt = XuLyVatTu.tim(resultSet.getInt("MaVT"));
                vt.getDanhSachCheBien().add(cb);
                cb.setVatTu(vt);
                
                MonAn ma = XuLyMonAn.tim(resultSet.getInt("MaMA"));
                ma.getDanhSachCB().add(cb);
                cb.setMonAn(ma);
                
                cb.setSoLuongTieuThu(resultSet.getFloat("SoLuongTieuThu"));
                DanhSach.getDanhSachCB().add(cb);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(MonAn ma, VatTu vt, float soLuong)
    {
        if (soLuong <= 0)
        {
            thongBao = "Số lượng tiêu thụ phải lớn hơn 0";
            return false;
        }
        boolean kq = thucThi("insert into CheBien values "
                + "(" + ma.getMaMA() + ", " + vt.getMaVT() + ", " + soLuong + ")");
        if (kq)
        {
            CheBien cb = new CheBien(ma, vt, soLuong);
            DanhSach.getDanhSachCB().add(cb);
            
            vt.getDanhSachCheBien().add(cb);
            cb.setVatTu(vt);
            
            ma.getDanhSachCB().add(cb);
            cb.setMonAn(ma);
            
            thongBao = "Thêm thông tin chế biến thành công";
        }
        else
        {
            thongBao = "Thêm thông tin chế biến thất bại";
        }
        return kq;
    }
    
    public static boolean sua(MonAn ma, VatTu vt, float soLuong)
    {
        if (soLuong <= 0)
        {
            thongBao = "Số lượng tiêu thụ phải lớn hơn 0";
            return false;
        }
        boolean kq = thucThi("update MonAn set SoLuongTieuThu="
                + soLuong + " where MaMA='" + ma.getMaMA()
                + "' and MaVT='" + vt.getMaVT() + "'");
        if (kq)
        {
            CheBien cb = tim(ma.getMaMA(), vt.getMaVT());
            cb.setSoLuongTieuThu(soLuong);
            thongBao = "Cập nhật thông tin chế biến thành công";
        }
        else
        {
            thongBao = "Cập nhật thông tin chế biến thất bại";
        }
        return kq;
    }
    
    public static boolean xoa(MonAn ma, VatTu vt)
    {
        boolean kq = thucThi("delete from CheBien where MaMA='" + ma.getMaMA()
                + "' and MaVT='" + vt.getMaVT() + "'");
        if (kq)
        {
            CheBien cb = tim(ma.getMaMA(), vt.getMaVT());
            cb.getMonAn().getDanhSachCB().remove(cb);
            cb.getVatTu().getDanhSachCheBien().remove(cb);
            DanhSach.getDanhSachCB().remove(cb);
            thongBao = "Xóa thông tin chế biến thành công";
        }
        else
        {
            thongBao = "Xóa thông tin chế biến thất bại";
        }
        
        return kq;
    }
    
    public static CheBien tim(int maMA, int maVT)
    {
        for (CheBien cb : DanhSach.getDanhSachCB())
        {
            if (cb.getMonAn().getMaMA() == maMA && cb.getVatTu().getMaVT() == maVT)
            {
                return cb;
            }
        }
        
        return null;
    }
}
