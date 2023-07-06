package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.CheBien;
import pojo.ChiTietHoaDon;
import pojo.DanhSach;
import pojo.HoaDon;
import pojo.MonAn;
import pojo.VatTu;

public class XuLyCTHD {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("ChiTietHoaDon");
            
            while (resultSet.next())
            {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                
                HoaDon hd = XuLyHoaDon.tim(resultSet.getInt("MaHD"));
                hd.getDanhSachCTHD().add(cthd);
                cthd.setHoaDon(hd);
                
                MonAn ma = XuLyMonAn.tim(resultSet.getInt("MaMA"));
                ma.getDanhSachCTHD().add(cthd);
                cthd.setMonAn(ma);
                
                cthd.setSoLuong(resultSet.getInt("SoLuong"));
                DanhSach.getDanhSachCTHD().add(cthd);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(MonAn ma, HoaDon hd, int soLuong)
    {
        ChiTietHoaDon cthd = new ChiTietHoaDon(hd, ma, soLuong);
        
        for (CheBien cb : cthd.getMonAn().getDanhSachCB())
        {
            VatTu vt = cb.getVatTu();
            
            if (vt.getSoLuong() - cb.getSoLuongTieuThu() * cthd.getSoLuong() < 0)
            {
                thongBao = "Số lượng vật tư không dủ";
                return false;
            }
        }
        
        if (soLuong <= 0)
        {
            thongBao = "Số lượng phải lớn hơn 0";
            return false;
        }
        
        boolean kq = thucThi("insert into ChiTietHoaDon values (" + hd.getMaHD() + ", "
                + ma.getMaMA() + ", " + soLuong + ")");
        
        if (kq)
        {
            DanhSach.getDanhSachCTHD().add(cthd);
            
            hd.getDanhSachCTHD().add(cthd);
            hd.setTongTien(hd.getTongTien() + cthd.getSoLuong() * cthd.getMonAn().getDonGia());
            
            thucThi("update HoaDon set TongTien=" + hd.getTongTien() + " where MaHD=" + hd.getMaHD() + "");
            
            ma.getDanhSachCTHD().add(cthd);
            
            for (CheBien cb : cthd.getMonAn().getDanhSachCB())
            {
                VatTu vt = cb.getVatTu();
                vt.setSoLuong(vt.getSoLuong() - cb.getSoLuongTieuThu() * cthd.getSoLuong());
                thucThi("update VatTu set SoLuong=" + vt.getSoLuong() + " where MaVT=" + vt.getMaVT() + "");
            }
            
            thongBao = "Thêm chi tiết hóa đơn thành công";
        }
        else
        {
            thongBao = "Thêm chi tiết hóa đơn thất bại";
        }
        return kq;
    }
    
    public static boolean sua(MonAn ma, HoaDon hd, int soLuong)
    {
        if (soLuong <= 0)
        {
            thongBao = "Số lượng phải lớn hơn 0";
            return false;
        }
        boolean kq = thucThi("update ChiTietHoaDon set SoLuong="
                + soLuong + " where MaMA='" + ma.getMaMA()
                + "' and MaHD='" + hd.getMaHD() + "'");
        if (kq)
        {
            ChiTietHoaDon cthd = XuLyCTHD.tim(ma.getMaMA(), hd.getMaHD());
            
            for (CheBien cb : cthd.getMonAn().getDanhSachCB())
            {
                VatTu vt = cb.getVatTu();
                vt.setSoLuong(vt.getSoLuong() + cb.getSoLuongTieuThu() * cthd.getSoLuong());
            }
            
            hd.setTongTien(hd.getTongTien() - cthd.getSoLuong() * cthd.getMonAn().getDonGia());
            cthd.setSoLuong(soLuong);
            hd.setTongTien(hd.getTongTien() + cthd.getSoLuong() * cthd.getMonAn().getDonGia());
            
            for (CheBien cb : cthd.getMonAn().getDanhSachCB())
            {
                VatTu vt = cb.getVatTu();
                vt.setSoLuong(vt.getSoLuong() - cb.getSoLuongTieuThu() * cthd.getSoLuong());
                thucThi("update VatTu set SoLuong=" + vt.getSoLuong() + " where MaVT=" + vt.getMaVT() + "");
            }
            
            thucThi("update HoaDon set TongTien=" + hd.getTongTien() + " where MaHD=" + hd.getMaHD() + "");
            
            thongBao = "Cập nhật chi tiết hóa đơn thành công";
        }
        else
        {
            thongBao = "Cập nhật chi tiết hóa đơn thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(MonAn ma, HoaDon hd)
    {
        boolean kq =  thucThi("delete from ChiTietHoaDon where MaMA='" + ma.getMaMA()
                + "' and MaHD='" + hd.getMaHD() + "'");
        if (kq)
        {
            ChiTietHoaDon cthd = tim(ma.getMaMA(), hd.getMaHD());
            ma.getDanhSachCTHD().remove(cthd);
            hd.getDanhSachCTHD().remove(cthd);
            
            hd.setTongTien(hd.getTongTien() - cthd.getSoLuong() * cthd.getMonAn().getDonGia());
            
            for (CheBien cb : cthd.getMonAn().getDanhSachCB())
            {
                VatTu vt = cb.getVatTu();
                vt.setSoLuong(vt.getSoLuong() + cb.getSoLuongTieuThu() * cthd.getSoLuong());
                thucThi("update VatTu set SoLuong=" + vt.getSoLuong() + " where MaVT=" + vt.getMaVT() + "");
            }
            
            thucThi("update HoaDon set TongTien=" + hd.getTongTien() + " where MaHD=" + hd.getMaHD() + "");
            
            DanhSach.getDanhSachCTHD().remove(cthd);
            thongBao = "Xóa chi tiết hóa đơn thành công";
        }
        else
        {
            thongBao = "Xóa chi tiết hóa đơn thất bại";
        }
        return kq;
    }
    
    public static ChiTietHoaDon tim(int maMA, int maHD)
    {
        for (ChiTietHoaDon cthd : DanhSach.getDanhSachCTHD())
        {
            if (cthd.getMonAn().getMaMA() == maMA && cthd.getHoaDon().getMaHD() == maHD)
            {
                return cthd;
            }
        }
        
        return null;
    }
}
