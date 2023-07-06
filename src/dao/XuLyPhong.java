package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.Ban;
import pojo.DanhSach;
import pojo.Phong;
import pojo.Tang;

public class XuLyPhong {
    public static Phong tim(String maPhong)
    {
        for (Phong p : DanhSach.getDanhSachPhong())
        {
            if (p.getMaPhong().equals(maPhong))
            {
                return p;
            }
        }
        
        return null;
    }
    
    public static boolean them(Tang tang, int giaDatTruoc)
    {
        int soPhong = 1;
        String maPhong = tang.getSoTang() + "01";
        
        for (Phong p : tang.getDanhSachPhong())
        {   
            if (maPhong.equals(p.getMaPhong()))
            {
                soPhong++;
            }
            else
            {
                break;
            }
            
            if (soPhong < 10)
            {
                maPhong = tang.getSoTang() + "0" + soPhong;
            }
            else
            {
                maPhong = tang.getSoTang() + "" + soPhong;
            }
        }
        
        boolean kq = thucThi("insert into Phong values ('" + maPhong + "', " 
                + tang.getSoTang() + ", " + giaDatTruoc + ")");
        
        if (kq)
        {
            Phong p = new Phong(maPhong, tang, giaDatTruoc);
            tang.getDanhSachPhong().add(p);
            DanhSach.getDanhSachPhong().add(p);
            thongBao = "Thêm phòng thành công";
        }
        else
        {
            thongBao = "Thêm phòng thất bại";
        }
        
        return kq;
    }
    
    public static boolean themSoPhong(int soLuong, Tang tang, int gia)
    {
        for (int i = 0; i < soLuong; i++)
        {
            if (!them(tang, gia))
            {
                thongBao = "Cập nhật số lượng phòng thất bại";
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean sua(String maPhong, int giaDatTruoc)
    {
        if (giaDatTruoc < 0)
        {
            thongBao = "Giá đặt trước phải lớn hơn 0";
            return false;
        }
        
        boolean kq = thucThi("update Phong set GiaDatTruoc=" + giaDatTruoc
                + " where MaPhong='" + maPhong + "'");
        
        if (kq)
        {
            Phong p = tim(maPhong);
            p.setGiaDatTruoc(giaDatTruoc);
            thongBao = "Cập nhật phòng thành công";
        }
        else
        {
            thongBao = "Cập nhật phòng thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(String ma)
    {
        Phong p = tim(ma);
        
        if (!p.getLichSuHoaDon().isEmpty())
        {
            thongBao = "Không thể xóa phòng do phòng đang được ghi nhận trong danh sách hóa đơn";
            return false;
        }
        
        for (Ban b : p.getDanhSachBan())
        {
            if (!b.getLichSuHoaDon().isEmpty())
            {
                thongBao = "Không thể xóa phòng do phòng có bàn đang được ghi nhận trong danh sách hóa đơn";
                return false;
            }
        }
        
        if (thucThi("delete from Ban where MaPhong='" + ma + "'"))
        {
            for (Ban b : p.getDanhSachBan())
            {
                DanhSach.getDanhSachBan().remove(b);
            } 
        }
        else
        {
            thongBao = "Không thể xóa phòng do xử lý xóa bàn thất bại";
            return false;
        }
        
        
        
        boolean kq = thucThi("delete from Phong where MaPhong='" + ma + "'");
        
        if (kq)
        {
            for (Ban b : p.getDanhSachBan())
            {
                DanhSach.getDanhSachBan().remove(b);
            }
            
            p.getTang().getDanhSachPhong().remove(p);
            DanhSach.getDanhSachPhong().remove(p);
            thongBao = "Xóa phòng thành công";
        }
        else
        {
            thongBao = "Xóa phòng thất bại";
        }
        
        return kq;
    }
    
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("Phong");
            
            while (resultSet.next())
            {
                Phong p = new Phong();
                p.setMaPhong(resultSet.getString("MaPhong"));
                p.setGiaDatTruoc(resultSet.getInt("GiaDatTruoc"));
                p.setTang(XuLyTang.tim(resultSet.getInt("SoTang")));
                p.getTang().getDanhSachPhong().add(p);
                DanhSach.getDanhSachPhong().add(p);        
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
