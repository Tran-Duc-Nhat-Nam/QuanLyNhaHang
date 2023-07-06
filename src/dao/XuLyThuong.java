package dao;

import static dao.XuLyCSDL.connection;
import static dao.XuLyCSDL.ketNoi;
import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import java.sql.SQLException;
import pojo.DanhSach;
import pojo.NhanVien;
import pojo.Thuong;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class XuLyThuong {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("Thuong");
            
            while (resultSet.next())
            {
                Thuong thuong = new Thuong();
                NhanVien nv = XuLyNhanVien.tim(resultSet.getInt("MaNV"));
                thuong.setMaThuong(resultSet.getInt("MaThuong"));
                thuong.setNhanVien(nv);
                thuong.setThoiGian(resultSet.getTimestamp("ThoiGian"));
                thuong.setLyDo(resultSet.getNString("LyDo"));
                thuong.setTienThuong(resultSet.getLong("TienThuong"));
                
                nv.getLichSuThuong().add(thuong);
                thuong.setNhanVien(nv);
                
                DanhSach.getLichSuThuong().add(thuong);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(NhanVien nv, Timestamp tg, String ld, int tt)
    {
        try {     
            int maThuong = 1;
            
            for (Thuong t : DanhSach.getLichSuThuong())
            {
                if (maThuong == t.getMaThuong())
                {
                    maThuong++;
                }
                else
                {
                    break;
                }
            }
            
            String sql = "insert into Thuong values (?, ?, ?, ?, ?)";
            
            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maThuong);
            ps.setInt(2, nv.getMaNV());
            ps.setTimestamp(3, tg);
            ps.setNString(4, ld);
            ps.setInt(5, tt);
            
            boolean kq = XuLyCSDL.thucThi(ps);
            
            if (kq)
            {
                Thuong t = new Thuong(maThuong, nv, tg, ld, tt);
                DanhSach.getLichSuThuong().add(t);
                nv.getLichSuThuong().add(t);
                t.setNhanVien(nv);
                
                thongBao = "Thêm thông tin tiền thưởng thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Thêm thông tin tiền thưởng thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean sua(int maThuong, NhanVien nv, Timestamp tg, String ld, int tt)
    {
        try {
            
            String sql = "update Thuong set MaNV=?, ThoiGian=?, LyDo=?, TienThuong=? where MaThuong=?";
            
            ketNoi();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(5, maThuong);
            ps.setInt(1, nv.getMaNV());
            ps.setTimestamp(2, tg);
            ps.setNString(3, ld);
            ps.setInt(4, tt);
            
            boolean kq = XuLyCSDL.thucThi(ps);
            
            if (kq)
            {
                Thuong t = tim(maThuong);
                t.setLyDo(ld);
                t.setNhanVien(nv);
                t.setThoiGian(tg);
                t.setTienThuong(tt);
                thongBao = "Cập nhật thông tin tiền thưởng thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Cập nhật thông tin tiền thưởng thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean xoa(int maThuong)
    {
        Thuong t = tim(maThuong);
        
        boolean kq = XuLyCSDL.thucThi("delete from Thuong where MaThuong='" + maThuong + "'");
        
        if (kq)
        {
            t.getNhanVien().getLichSuThuong().remove(t);
            DanhSach.getLichSuThuong().remove(t);
            thongBao = "Xóa thông tin tiền thưởng thành công";
            return true;
        }
        
        thongBao = "Xóa thông tin tiền thưởng thất bại";
        return kq;
    }
    
    public static Thuong tim(int maThuong)
    {
        for (Thuong t : DanhSach.getLichSuThuong())
        {
            if (t.getMaThuong() == maThuong)
            {
                return t;
            }
        }
        
        return null;
    }
}
