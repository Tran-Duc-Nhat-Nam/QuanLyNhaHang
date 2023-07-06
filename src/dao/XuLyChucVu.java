package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.ChucVu;
import pojo.DanhSach;

public class XuLyChucVu {
    public static ChucVu tim(int maCV)
    {
        for (ChucVu cv : DanhSach.getDanhSachCV())
        {
            if (cv.getMaCV() == maCV)
            {
                return cv;
            }
        }
        
        return null;
    }
    
    public static boolean them(String tenCV, float HSLCB)
    {
        if (HSLCB < 1)
        {
            thongBao = "Hệ số lương phải từ 1 trở lên";
            return false;
        }
        for (ChucVu cv : DanhSach.getDanhSachCV())
        {
            if (cv.getTenChucVu().equals(tenCV))
            {
                thongBao = "Tên chức vụ không được trùng";
                return false;
            }
        }
        
        int maCV = 1;
        
        for (ChucVu cv : DanhSach.getDanhSachCV())
        {
            if (maCV == cv.getMaCV())
            {
                maCV++;
            }
            else
            {
                break;
            }
        }
        
        boolean kq = thucThi("insert into DanhSach_ChucVu values "
                        + "('" + maCV + "', N'" + tenCV + "', " + HSLCB + ")");
        
        if (kq)
        {
            DanhSach.getDanhSachCV().add(new ChucVu(maCV, tenCV, HSLCB));
            thongBao = "Thêm chức vụ thành công";
        }
        else
        {
            thongBao = "Thêm chức vụ thất bại";
        }
            
        return kq;
    }
    
    public static boolean sua(int maCV, String tenCV, float HSLCB)
    {
        if (HSLCB < 1)
        {
            thongBao = "Hệ số lương phải từ 1 trở lên";
            return false;
        }
        
        for (ChucVu cv : DanhSach.getDanhSachCV())
        {
            if (cv.getMaCV() != maCV && cv.getTenChucVu().equals(tenCV))
            {
                thongBao = "Tên chức vụ không được trùng";
                return false;
            }
        }
        
        boolean kq = thucThi("update DanhSach_ChucVu set "
                + "TenChucVu=N'" + tenCV + "', HeSoLuongCoBan=" + HSLCB
                + " where MaCV='" + maCV + "'");
        
        if (kq)
        {
            ChucVu cv = tim(maCV);
            cv.setTenChucVu(tenCV);
            cv.setHeSoLuongCoBan(HSLCB);
            thongBao = "Cập nhật chức vụ thành công";
        }
        else
        {
            thongBao = "Cập nhật chức vụ thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(int maCV)
    {
        ChucVu cv = tim(maCV);
        if (!cv.getDanhSachNV().isEmpty())
        {
            thongBao = "Không thể xóa chức vụ do có người giữ chức vụ";
            return false;
        }
        boolean kq = thucThi("delete from DanhSach_ChucVu where MaCV='" + maCV + "'");
        if (kq)
        {
            DanhSach.getDanhSachCV().remove(cv);
            thongBao = "Xóa chức vụ thành công";
        }
        else
        {
            thongBao = "Xóa chức vụ thất bại";
        }
        
        return kq;
    }
    
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("DanhSach_ChucVu");
            DanhSach.setDanhSachCV(new ArrayList<>());
            
            while (resultSet.next())
            {
                ChucVu cv = new ChucVu();
                cv.setMaCV(resultSet.getInt("MaCV"));
                cv.setTenChucVu(resultSet.getNString("TenChucVu"));
                cv.setHeSoLuongCoBan(resultSet.getFloat("HeSoLuongCoBan"));
                DanhSach.getDanhSachCV().add(cv);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
