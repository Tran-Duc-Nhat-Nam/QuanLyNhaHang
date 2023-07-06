package dao;

import static dao.XuLyCSDL.connection;
import static dao.XuLyCSDL.ketNoi;
import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import pojo.Ban;
import pojo.CheBien;
import pojo.ChiTietHoaDon;
import pojo.DanhSach;
import pojo.HoaDon;
import pojo.NhanVien;
import pojo.VatTu;

public class XuLyHoaDon {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("HoaDon");
            
            while (resultSet.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHD(resultSet.getInt("MaHD"));
                hd.setNhanVien(XuLyNhanVien.tim(resultSet.getInt("MaNV")));
                hd.setThoiGianLap(resultSet.getTimestamp("ThoiGianLap"));
                hd.setTongTien(resultSet.getLong("TongTien"));
                hd.setTinhTrangThanhToan(resultSet.getBoolean("TinhTrangThanhToan"));
                DanhSach.getDanhSachHD().add(hd);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(NhanVien nhanVien, Timestamp tgl)
    {
        try {                
            int maHD = 1;
            
            for (HoaDon hd : DanhSach.getDanhSachHD())
            {
                if (maHD == hd.getMaHD())
                {
                    maHD++;
                }
                else
                {
                    break;
                }
            }
            
            String sql = "insert into HoaDon values (?, ?, ?, 0, 0)";
            
            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maHD);
            ps.setInt(2, nhanVien.getMaNV());
            ps.setTimestamp(3, tgl);
            
            boolean kq = XuLyCSDL.thucThi(ps);
            
            if (kq)
            {
                DanhSach.getDanhSachHD().add(new HoaDon(maHD, nhanVien, tgl));
                thongBao = "Thêm hóa đơn thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Thêm hóa đơn thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean them(NhanVien nhanVien, Timestamp tgl, Ban b)
    {
        them(nhanVien, tgl);
        HoaDon hd = DanhSach.getDanhSachHD().get(DanhSach.getDanhSachHD().size() - 1);
        return XuLyCTHD_Ban.them(hd, b);
    }
    
    public static boolean thanhToan(int maHD)
    {
        try {                
            HoaDon hd = tim(maHD);  
            
            String sql = "update HoaDon set TinhTrangThanhToan=? where MaHD=?";
            
            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, maHD);
            
            boolean kq = XuLyCSDL.thucThi(ps);
            
            if (kq)
            {
                hd.setTinhTrangThanhToan(true);
                thongBao = "Thanh toán thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Thanh toán thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean xoa(int maHD)
    {
        thucThi("delete from ChiTietHoaDon where MaHD='" + maHD + "'");
        
        thucThi("delete from ChiTietHoaDon_Ban where MaHD='" + maHD + "'");
        
        thucThi("delete from ChiTietHoaDon_Phong where MaHD='" + maHD + "'");
        
        boolean kq = thucThi("delete from HoaDon where MaHD='" + maHD + "'");
        
        if (kq)
        {
            HoaDon hd = tim(maHD);
            
            for (ChiTietHoaDon cthd : hd.getDanhSachCTHD())
            {
                DanhSach.getDanhSachCTHD().remove(cthd);   
                
                for (CheBien cb : cthd.getMonAn().getDanhSachCB())
                {
                    VatTu vt = cb.getVatTu();
                    vt.setSoLuong(vt.getSoLuong() + cb.getSoLuongTieuThu() * cthd.getSoLuong());
                }
            }
            
            DanhSach.getDanhSachHD().remove(hd);
            thongBao = "Xóa hóa đơn thành công";
        }
        else
        {
            thongBao = "Xóa hóa đơn thất bại";
        }
        
        return kq;
    }
    
    public static HoaDon tim(int maHD)
    {
        List<HoaDon> temp = DanhSach.getDanhSachHD();
        for (HoaDon hd : DanhSach.getDanhSachHD())
        {
            if (hd.getMaHD() == maHD)
            {
                return hd;
            }
        }
        
        return null;
    }
}
