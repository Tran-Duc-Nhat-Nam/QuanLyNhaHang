package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import java.util.Collections;
import pojo.Ban;
import pojo.DanhSach;
import pojo.Phong;

public class XuLyBan {
    public static Ban tim(int maBan)
    {
        for (Ban b : DanhSach.getDanhSachBan())
        {
            if (b.getMaBan()== maBan)
            {
                return b;
            }
        }
        
        return null;
    }
    
    public static Ban tim(String maPhong, int soBan)
    {
        for (Phong p : DanhSach.getDanhSachPhong())
        {
            if (p.getMaPhong().equals(maPhong))
            {
                for (Ban b : p.getDanhSachBan())
                {
                    if (b.getSoBan() == soBan)
                    {
                        return b;
                    }
                }
            }
        }
        
        return null;
    }
    
    public static boolean them(Phong phong, int giaDatTruoc)
    {
        int maBan = 1;
        
        if (giaDatTruoc < 0)
        {
            thongBao = "Giá đặt trước phải là số nguyên dương";
            return false;
        }
        
        for (Ban b : DanhSach.getDanhSachBan())
        {
            if (maBan == b.getMaBan())
            {
                maBan++;
            }
            else
            {
                break;
            }
        }
        
        int soBan = 1;
        
        for (Ban b : phong.getDanhSachBan())
        {
            if (soBan == b.getSoBan())
            {
                soBan++;
            }
            else
            {
                break;
            }
        }
        
        boolean kq = thucThi("insert into Ban values (" + maBan +", " 
                + soBan + ", '" + phong.getMaPhong() + "', " + giaDatTruoc + ")");
        
        if (kq)
        {
            Ban b = new Ban();
            b.setMaBan(maBan);
            b.setSoBan(soBan);
            b.setPhong(phong);
            b.setGiaDatTruoc(giaDatTruoc);
            b.getPhong().getDanhSachBan().add(b);
            DanhSach.getDanhSachBan().add(b);
            thongBao = "Thêm bàn thành công";
        }
        else
        {
            thongBao = "Thêm bàn thất bại";
        }
        
        return kq;
    }
    
    public static boolean themSoBan(int soBan, Phong phong, int giaDatTruoc)
    {
        for (int i = 0; i < soBan; i++)
        {
            if (!them(phong, giaDatTruoc))
            {
                thongBao = "Cập nhật số lượng bàn thất bại";
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean sua(int maBan, int giaDatTruoc)
    {
        if (giaDatTruoc < 0)
        {
            thongBao = "Giá đặt trước phải lớn hơn 0";
            return false;
        }
        
        boolean kq = thucThi("update Ban set GiaDatTruoc=" + giaDatTruoc
                + " where MaBan='" + maBan + "'");
        
        if (kq)
        {
            Ban b = tim(maBan);
            b.setGiaDatTruoc(giaDatTruoc);
            thongBao = "Cập nhật bàn thành công";
        }
        else
        {
            thongBao = "Cập nhật bàn thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(int ma)
    {
        Ban b = tim(ma);
        
        if (!b.getLichSuHoaDon().isEmpty())
        {
            thongBao = "Không thể xóa bàn do bàn đang được ghi nhận trong danh sách hóa đơn";
            return false;
        }
        
        boolean kq = thucThi("delete from Ban where MaBan='" + ma + "'");
        
        if (kq)
        {
            b.getPhong().getDanhSachBan().remove(b);
            DanhSach.getDanhSachBan().remove(b);
            thongBao = "Xóa bàn thành công";
        }
        else
        {
            thongBao = "Xóa bàn thất bại";
        }
        
        return kq;
    }
    
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("Ban");
            
            while (resultSet.next())
            {
                Ban b = new Ban();
                b.setMaBan(resultSet.getInt("MaBan"));
                b.setSoBan(resultSet.getInt("SoBan"));
                b.setPhong(XuLyPhong.tim(resultSet.getString("MaPhong")));
                b.getPhong().getDanhSachBan().add(b);
                b.setGiaDatTruoc(resultSet.getInt("GiaDatTruoc"));
                DanhSach.getDanhSachBan().add(b);
            }
            
            Collections.sort(DanhSach.getDanhSachBan(), (Ban b1, Ban b2) -> 
                    b1.getPhong().getMaPhong()
                            .compareTo(b2.getPhong().getMaPhong())
            );
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
