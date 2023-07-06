package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.DanhSach;
import pojo.NhanVien;
import pojo.TaiKhoan;

public class XuLyTaiKhoan {
        public static TaiKhoan tim(int maNV)
    {
        for (TaiKhoan tk : DanhSach.getDanhSachTK())
        {
            if (tk.getNhanVien().getMaNV() == maNV)
            {
                return tk;
            }
        }
        
        return null;
    }

    public static boolean them(int maNV, String matKhau)
    {
        NhanVien nv = XuLyNhanVien.tim(maNV);
        
        boolean kq = thucThi("insert into taikhoan values ('"
                + maNV +"', '" + matKhau + "')");
        
        if (kq)
        {
            nv.setTaiKhoan(new TaiKhoan(nv, matKhau));
            DanhSach.getDanhSachTK().add(nv.getTaiKhoan());
            thongBao = "Thêm tài khoàn thành công";
        }
        else
        {
            thongBao = "Thêm tài khoàn thất bại";
        }
        
        return kq;
    }

    public static boolean sua(int maNV, String matKhau)
    {
        NhanVien nv = XuLyNhanVien.tim(maNV);
        
        boolean kq = thucThi("update taikhoan set matKhau='"
                + matKhau + "' where maNV='" + maNV + "'");
        
        if (kq)
        {
            nv.getTaiKhoan().setMatKhau(matKhau);
            thongBao = "Cập nhật tài khoàn thành công";
        }
        else
        {
            thongBao = "Cập nhật tài khoàn thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(int maNV)
    {
        NhanVien nv = XuLyNhanVien.tim(maNV);
        
        boolean kq = thucThi("delete from taikhoan where maNV='" + maNV + "'");
        
        if (kq)
        {
            DanhSach.getDanhSachTK().remove(nv.getTaiKhoan());
            nv.setTaiKhoan(null);
            thongBao = "Xóa tài khoàn thành công";
        }
        else
        {
            thongBao = "Xóa tài khoàn thất bại";
        }
        
        return kq;
    }
    
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("TaiKhoan");
            DanhSach.setDanhSachTK(new ArrayList<>());
            
            while (resultSet.next())
            {
                NhanVien nv = XuLyNhanVien.tim(resultSet.getInt("MaNV"));
                if (nv != null)
                {
                    nv.setTaiKhoan(new TaiKhoan(nv, resultSet.getString("MatKhau")));
                    DanhSach.getDanhSachTK().add(nv.getTaiKhoan());
                }
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean kiemTra(int maNV, String matKhau)
    {
        for (TaiKhoan tk : DanhSach.getDanhSachTK())
        {
            if (tk.getNhanVien().getMaNV() == maNV)
            {
                if (tk.getMatKhau().equals(matKhau))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
