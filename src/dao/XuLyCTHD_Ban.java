package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import java.util.List;
import pojo.Ban;
import pojo.ChiTietHoaDon_Ban;
import pojo.DanhSach;
import pojo.DonDatTruoc;
import pojo.HoaDon;

public class XuLyCTHD_Ban {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("ChiTietHoaDon_Ban");
            
            while (resultSet.next())
            {
                ChiTietHoaDon_Ban cthd = new ChiTietHoaDon_Ban();
                
                HoaDon hd = XuLyHoaDon.tim(resultSet.getInt("MaHD"));
                hd.getDanhSachCTHD_Ban().add(cthd);
                cthd.setHoaDon(hd);
                
                Ban b = XuLyBan.tim(resultSet.getInt("MaBan"));
                b.getLichSuHoaDon().add(cthd);
                cthd.setBan(b);
                
                List<HoaDon> tempHD = DanhSach.getDanhSachHD();
                List<DonDatTruoc> tempDDT = DanhSach.getDanhSachDDT();
                System.out.println("");
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(HoaDon hd, Ban b)
    {
        boolean kq = thucThi("insert into ChiTietHoaDon_Ban values "
                + "(" + hd.getMaHD() + ", " + b.getMaBan() + ")");
        
        if (kq)
        {
            ChiTietHoaDon_Ban cthd = new ChiTietHoaDon_Ban();
            
            cthd.setHoaDon(hd);
            cthd.getHoaDon().getDanhSachCTHD_Ban().add(cthd);

            cthd.setBan(b);
            cthd.getBan().getLichSuHoaDon().add(cthd);
            
            List<DonDatTruoc> temp = DanhSach.getDanhSachDDT();
            
            thongBao = "Thêm thông tin sử dụng bàn thành công";
        }
        else
        {
            thongBao = "Thêm thông tin sử dụng bàn thành công";
        }
        
        return kq;
    }
    
    public static boolean xoa(HoaDon hd, Ban b)
    {
        boolean kq = thucThi("delete from ChiTietHoaDon_Ban where MaHD='" + hd.getMaHD()
                + "' and MaBan='" + b.getMaBan() + "'");
        if (kq)
        {
            ChiTietHoaDon_Ban cthd = tim(hd.getMaHD(), b.getMaBan());
            cthd.getHoaDon().getDanhSachCTHD_Ban().remove(cthd);
            cthd.getBan().getLichSuHoaDon().remove(cthd);
            thongBao = "Xóa thông tin sử dụng bàn thành công";
        }
        else
        {
            thongBao = "Xóa thông tin sử dụng bàn thất bại";
        }
        
        return kq;
    }
    
    public static boolean chuyenBan(HoaDon hd, Ban b)
    {
        if (hd.getDonDatTruoc() == null)
        {
            Ban temp = hd.getDanhSachCTHD_Ban().get(0).getBan();
        
            if (temp.getMaBan() == b.getMaBan())
            {
                thongBao = "Vui lòng không chọn trùng";
                return false;
            }
            
            if (!xoa(hd, temp))
            {
                thongBao = "Chuyển bàn thất bại";
                return false;
            }

            if (!them(hd, b))
            {
                thongBao = "Chuyển bàn thất bại";
                return false;
            }

            return true;
        }
        else
        {
            thongBao = "Chỉ chuyển bàn cho hóa đơn không đặt trước";
            return false;
        }
    }
    
    public static boolean gopBan(HoaDon hda, HoaDon hdb)
    {
        if (hda.getDonDatTruoc() == null && hdb.getDonDatTruoc() == null)
        {
            Ban b = hdb.getDanhSachCTHD_Ban().get(0).getBan();
        
            if (!xoa(hdb, b))
            {
                thongBao = "Gộp bàn thất bại";
                return false;
            }

            if (!them(hda, b))
            {
                thongBao = "Gộp bàn thất bại";
                return false;
            }

            return true;
        }
        else
        {
            thongBao = "Chỉ gộp bàn cho hóa đơn không đặt trước";
            return false;
        }
    }
    
    public static ChiTietHoaDon_Ban tim(int maHD, int maBan)
    {
        HoaDon hd = XuLyHoaDon.tim(maHD);
        
        for (ChiTietHoaDon_Ban cthd : hd.getDanhSachCTHD_Ban())
        {
            if (cthd.getBan().getMaBan() == maBan)
            {
                return cthd;
            }
        }
        
        return null;
    }
}
