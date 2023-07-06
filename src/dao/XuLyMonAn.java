package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.CheBien;
import pojo.DanhSach;
import pojo.MonAn;

public class XuLyMonAn {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("MonAn");
            
            while (resultSet.next())
            {
                MonAn ma = new MonAn();
                ma.setMaMA(resultSet.getInt("MaMA"));
                ma.setTenMA(resultSet.getNString("TenMA"));
                ma.setDonGia(resultSet.getInt("DonGia"));
                ma.setDonViTinh(resultSet.getNString("DonViTinh"));
                DanhSach.getDanhSachMA().add(ma);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
 
    public static boolean them(String ten, int dg, String dvt)
    {
        if (dg < 0)
        {
            thongBao = "Đơn giá phải là sô nguyên dương";
            return false;
        }
        
        for (MonAn ma : DanhSach.getDanhSachMA())
        {
            if (ma.getTenMA().equals(ten))
            {
                thongBao = "Tên món ăn không được trùng";
                return false;
            }
        }
        
        int maMA = 1;
        
        for (MonAn ma : DanhSach.getDanhSachMA())
        {
            if (maMA == ma.getMaMA())
            {
                maMA++;
            }
            else
            {
                break;
            }
        }
        
        boolean kq = thucThi("insert into MonAn values "
                + "(" + maMA + ", N'" + ten + "', " + dg
                + ", N'" + dvt + "')");
        
        if (kq)
        {
            DanhSach.getDanhSachMA().add(new MonAn(maMA, ten, dvt, dg));
            thongBao = "Thêm món ăn thành công";
        }
        else
        {
            thongBao = "Thêm món ăn thất bại";
        }
        
        return kq;
    }
    
    public static boolean sua(int maMA, String ten, int dg, String dvt)
    {
        if (dg < 0)
        {
            thongBao = "Đơn giá phải là sô nguyên dương";
            return false;
        }
        
        for (MonAn ma : DanhSach.getDanhSachMA())
        {
            if (maMA != ma.getMaMA() && ma.getTenMA().equals(ten))
            {
                thongBao = "Tên món ăn không được trùng";
                return false;
            }
        }
        
        boolean kq = thucThi("update MonAn set TenMA=N'"
                + ten + "', DonGia=" + dg + ", DonViTinh=N'"
                + dvt + "' where MaMA='" + maMA + "'");
        
        if (kq)
        {
            tim(maMA).setTenMA(ten);
            tim(maMA).setDonGia(dg);
            tim(maMA).setDonViTinh(dvt);
            thongBao = "Cập nhật món ăn thành công";
        }
        else
        {
            thongBao = "Cập nhật món ăn thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(int maMA)
    {
        MonAn ma = tim(maMA);
        if (!ma.getDanhSachCTHD().isEmpty())
        {
            thongBao = "Không thể xóa món ăn do món ăn đang được sử dụng trong chi tiết hóa đơn";
            return false;
        }
        
        thucThi("delete from CheBien where MaMA='" + maMA + "'");
        boolean kq = thucThi("delete from MonAn where MaMA='" + maMA + "'");
        
        if (kq)
        {
            for (CheBien cb : ma.getDanhSachCB())
            {
                DanhSach.getDanhSachCB().remove(cb);
            }
            
            DanhSach.getDanhSachMA().remove(ma);
            thongBao = "Xóa món ăn thành công";
        }
        else
        {
            thongBao = "Xóa món ăn thất bại";
        }
        
        return kq;
    }
    
    public static MonAn tim(int maMA)
    {
        for (MonAn ma : DanhSach.getDanhSachMA())
        {
            if (ma.getMaMA() == maMA)
            {
                return ma;
            }
        }
        
        return null;
    }
}
