package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.DanhSach;
import pojo.VatTu;

public class XuLyVatTu {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("VatTu");
            
            while (resultSet.next())
            {
                VatTu vt = new VatTu();
                vt.setMaVT(resultSet.getInt("MaVT"));
                vt.setTenVT(resultSet.getNString("TenVT"));
                vt.setNguonGoc(resultSet.getNString("NguonGoc"));
                vt.setDonGia(resultSet.getInt("DonGia"));
                vt.setDonViTinh(resultSet.getNString("DonViTinh"));
                vt.setSoLuong(resultSet.getFloat("SoLuong"));
                DanhSach.getDanhSachVT().add(vt);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(String ten, String ng, int dg, String dvt)
    {
        if (dg < 0)
        {
            thongBao = "Đơn giá phải là sô nguyên dương";
            return false;
        }
        
        for (VatTu vt : DanhSach.getDanhSachVT())
        {
            if (vt.getTenVT().equals(ten))
            {
                thongBao = "Tên vật tư không được trùng";
                return false;
            }
        }
        
        int maVT = 1;
        
        for (VatTu vt : DanhSach.getDanhSachVT())
        {
            if (maVT == vt.getMaVT())
            {
                maVT++;
            }
            else
            {
                break;
            }
        }
        
        boolean kq = thucThi("insert into VatTu values "
                + "(" + maVT + ", N'" + ten + "', N'" + ng
                + "', N'" + dvt + "', " + 0 +  ", " + dg + ")");
        
        if (kq)
        {
            DanhSach.getDanhSachVT().add(new VatTu(maVT, ten, ng, dvt, 0, dg));
            thongBao = "Thêm vật tư thành công";
        }
        else
        {
            thongBao = "Thêm vật tư thất bại";
        }
        
        return kq;
    }
    
    public static boolean sua(int ma, String ten, String ng, float sl, int dg, String dvt)
    {
        if (dg < 0)
        {
            thongBao = "Đơn giá phải là sô nguyên dương";
            return false;
        }
        
        for (VatTu vt : DanhSach.getDanhSachVT())
        {
            if (vt.getTenVT().equals(ten))
            {
                thongBao = "Tên vật tư không được trùng";
                return false;
            }
        }
        
        boolean kq = thucThi("update VatTu set TenVT=N'"
                + ten + "', DonGia=" + dg + ", DonViTinh=N'"
                + dvt + "', NguonGoc=N" + ng + ", SoLuong=" + sl
                + " where MaVT='" + ma + "'");
        
        if (kq)
        {
            VatTu vt = tim(ma);
            vt.setNguonGoc(ng);
            vt.setDonViTinh(dvt);
            vt.setTenVT(ten);
            vt.setSoLuong(sl);
            vt.setDonGia(dg);
            thongBao = "Cập nhật vật tư thành công";
        }
        else
        {
            thongBao = "Cập nhật vật tư thất bại";
        }
        
        return kq;
    }
    
    public static boolean xoa(int ma)
    {
        VatTu vt = tim(ma);
        
        if (!vt.getDanhSachCheBien().isEmpty())
        {
            thongBao = "Không thể xóa vật tư do vật tư đang được sử dụng trong công thức chế biến";
            return false;
        }
        
        if (!vt.getLichSuNhapKho().isEmpty())
        {
            thongBao = "Không thể xóa vật tư do vật tư đang được ghi nhận trpng lịch sử nhập kho";
            return false;
        }
        
        boolean kq = thucThi("delete from VatTu where MaVT='" + ma + "'");
        
        if (kq)
        {
            DanhSach.getDanhSachVT().remove(vt);
            thongBao = "Xóa vật tư thành công";
        }
        else
        {
            thongBao = "Xóa vật tư thất bại";
        }
        
        return kq;
    }
    
    public static VatTu tim(int maVT)
    {
        for (VatTu vt : DanhSach.getDanhSachVT())
        {
            if (vt.getMaVT() == maVT)
            {
                return vt;
            }
        }
        
        return null;
    }
}
