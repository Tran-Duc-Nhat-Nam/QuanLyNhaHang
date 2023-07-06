package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.ChiTietHoaDon_Phong;
import pojo.HoaDon;
import pojo.Phong;

public class XuLyCTHD_Phong {
        public static boolean doc()
    {
        try {
            XuLyCSDL.doc("ChiTietHoaDon_Phong");
            
            while (resultSet.next())
            {
                ChiTietHoaDon_Phong cthd = new ChiTietHoaDon_Phong();
                
                HoaDon hd = XuLyHoaDon.tim(resultSet.getInt("MaHD"));
                hd.getDanhSachCTHD_Phong().add(cthd);
                cthd.setHoaDon(hd);
                
                Phong b = XuLyPhong.tim(resultSet.getString("MaPhong"));
                b.getLichSuHoaDon().add(cthd);
                cthd.setPhong(b);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(HoaDon hd, Phong p)
    {
        boolean kq = thucThi("insert into ChiTietHoaDon_Phong values "
                + "(" + hd.getMaHD() + ", " + p.getMaPhong() + ")");
        
        if (kq)
        {
            ChiTietHoaDon_Phong cthd = new ChiTietHoaDon_Phong();
            
            hd.getDanhSachCTHD_Phong().add(cthd);
            cthd.setHoaDon(hd);

            p.getLichSuHoaDon().add(cthd);
            cthd.setPhong(p);
            
            thongBao = "Thêm thông tin sử dụng phòng thành công";
        }
        else
        {
            thongBao = "Thêm thông tin sử dụng phòng thành công";
        }
        
        return kq;
    }
    
    public static boolean xoa(HoaDon hd, Phong p)
    {
        boolean kq = thucThi("delete from ChiTietHoaDon_Phong where MaHD='" + hd.getMaHD()
                + "' and MaPhong='" + p.getMaPhong() + "'");
        if (kq)
        {
            ChiTietHoaDon_Phong cthd = tim(hd.getMaHD(), p.getMaPhong());
            cthd.getHoaDon().getDanhSachCTHD_Phong().remove(cthd);
            cthd.getPhong().getLichSuHoaDon().remove(cthd);
            thongBao = "Xóa thông tin sử dụng phòng thành công";
        }
        else
        {
            thongBao = "Xóa thông tin sử dụng phòng thất bại";
        }
        
        return kq;
    }
    
    public static ChiTietHoaDon_Phong tim(int maHD, String maPhong)
    {
        HoaDon hd = XuLyHoaDon.tim(maHD);
        
        for (ChiTietHoaDon_Phong cthd : hd.getDanhSachCTHD_Phong())
        {
            if (cthd.getPhong().getMaPhong().equals(maPhong))
            {
                return cthd;
            }
        }
        
        return null;
    }
}
