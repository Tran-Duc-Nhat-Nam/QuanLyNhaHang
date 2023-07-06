package dao;

import static dao.XuLyCSDL.connection;
import static dao.XuLyCSDL.ketNoi;
import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.DanhSach;
import pojo.NhanVien;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import pojo.Luong;

public class XuLyLuong {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("Luong");
            
            while (resultSet.next())
            {
                Luong luong = new Luong();
                NhanVien nv = XuLyNhanVien.tim(resultSet.getInt("MaNV"));
                luong.setMaLuong(resultSet.getInt("MaLuong"));
                luong.setNhanVien(nv);
                luong.setThoiGian(resultSet.getTimestamp("ThoiGian"));
                luong.setTienLuong(resultSet.getLong("TienLuong"));

                nv.getLichSuLuong().add(luong);
                luong.setNhanVien(nv);
                
                DanhSach.getLichSuLuong().add(luong);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(NhanVien nv, Timestamp tg)
    {
        try {     
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(tg.getTime());
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            
            for (Luong t : nv.getLichSuLuong())
            {
                cal.setTimeInMillis(t.getThoiGian().getTime());
                if (cal.get(Calendar.MONTH) == month &&
                        cal.get(Calendar.YEAR) == year)
                {
                    thongBao = "Tháng này đã trả lương rồi";
                    return false;
                }
            }
                   
            int maLuong = 1;
            
            for (Luong t : DanhSach.getLichSuLuong())
            {
                if (maLuong == t.getMaLuong())
                {
                    maLuong++;
                }
                else
                {
                    break;
                }
            }
            
            String sql = "insert into Luong values (?, ?, ?, ?)";
            
            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maLuong);
            ps.setInt(2, nv.getMaNV());
            ps.setTimestamp(3, tg);
            
            int luong = (int) (nv.getHeSoLuong() * 1700000);
            
            ps.setInt(4, luong);
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                Luong t = new Luong(maLuong, nv, tg, luong);
                DanhSach.getLichSuLuong().add(t);
                nv.getLichSuLuong().add(t);
                t.setNhanVien(nv);
                
                thongBao = "Thêm thông tin tiền lương thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Thêm thông tin tiền lương thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean sua(int maLuong, NhanVien nv, Timestamp tg, int tt)
    {
        try {
            
            String sql = "update Luong set MaNV=?, ThoiGian=?, TienLuong=? where MaLuong=?";
            
            ketNoi();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(5, maLuong);
            ps.setInt(1, nv.getMaNV());
            ps.setTimestamp(2, tg);
            ps.setInt(4, tt);
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                Luong t = tim(maLuong);
                t.setNhanVien(nv);
                t.setThoiGian(tg);
                t.setTienLuong(tt);
                thongBao = "Cập nhật thông tin tiền lương thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Cập nhật thông tin tiền lương thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean xoa(int maLuong)
    {
        Luong t = tim(maLuong);
        
        boolean kq = thucThi("delete from Luong where MaLuong='" + maLuong + "'");
        
        if (kq)
        {
            t.getNhanVien().getLichSuLuong().remove(t);
            DanhSach.getLichSuLuong().remove(t);
            thongBao = "Xóa thông tin tiền lương thành công";
            return true;
        }
        
        thongBao = "Xóa thông tin tiền lương thất bại";
        return kq;
    }
    
    public static Luong tim(int maLuong)
    {
        for (Luong t : DanhSach.getLichSuLuong())
        {
            if (t.getMaLuong() == maLuong)
            {
                return t;
            }
        }
        
        return null;
    }
    
    public static boolean traLuong()
    {
        boolean check = false;
        
        for (NhanVien nv : DanhSach.getDanhSachNV())
        {
            if (them(nv, Timestamp.valueOf(LocalDateTime.now())))
            {
                check = true;
            }
        }
        
        return check;
    }
}
