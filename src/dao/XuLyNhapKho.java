package dao;

import static dao.XuLyCSDL.connection;
import static dao.XuLyCSDL.ketNoi;
import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.SQLException;
import pojo.DanhSach;
import pojo.NhapKho;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import pojo.NhanVien;
import pojo.VatTu;

public class XuLyNhapKho {
     public static boolean doc()
    {
        try {
            XuLyCSDL.doc("NhapKho");
            
            while (resultSet.next())
            {
                NhapKho nk = new NhapKho();
                
                nk.setMaNK(resultSet.getInt("MaNK"));
                
                VatTu vt = XuLyVatTu.tim(resultSet.getInt("MaVT"));
                vt.getLichSuNhapKho().add(nk);
                nk.setVatTu(vt);
                
                NhanVien nv = XuLyNhanVien.tim(resultSet.getInt("MaNV"));
                nv.getLichSuNhapKho().add(nk);
                nk.setNhanVien(nv);
                
                nk.setThoiGianNhap(resultSet.getTimestamp("ThoiGianNhap"));
                nk.setDonGiaNhap(resultSet.getInt("DonGiaNhap"));
                nk.setSoLuongNhap(resultSet.getFloat("SoLuongNhap"));
                DanhSach.getLichSuNK().add(nk);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
     
    public static boolean them(VatTu vt, NhanVien nv, Timestamp tgn, int dgn, float sln)
    {
        try {    
            int maNK = 1;

            for (NhapKho nk : DanhSach.getLichSuNK())
            {
                if (maNK == nk.getMaNK())
                {
                    maNK++;
                }
                else
                {
                    break;
                }
            }
            
            String sql = "insert into NhapKho values (?, ?, ?, ?, ?, ?)";
            
            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maNK);
            ps.setInt(2, vt.getMaVT());
            ps.setInt(3, nv.getMaNV());
            ps.setTimestamp(4, tgn);
            ps.setFloat(5, sln);
            ps.setInt(6, dgn);
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                NhapKho nk = new NhapKho(maNK, vt, nv, 
                        tgn, sln, dgn);
                DanhSach.getLichSuNK().add(nk);
                
                vt.getLichSuNhapKho().add(nk);
                nk.setVatTu(vt);
                vt.setSoLuong(vt.getSoLuong() + sln);
                
                thucThi("update VatTu set SoLuong= " + vt.getSoLuong()
                        + "where MaVT=" + vt.getMaVT() + "");
                
                nv.getLichSuNhapKho().add(nk);
                nk.setNhanVien(nv);
                
                thongBao = "Thêm thông tin nhập kho thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Thêm thông tin nhập kho thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean sua(int maNK, VatTu vt, NhanVien nv, Timestamp tgn, int dgn, float sln)
    {
        try {
            
            String sql = "update NhapKho set MaVT=?, MaNV=?, ThoiGianNhap=?,"
                    + " DonGiaNhap=?, SoLuongNhap=? where MaNK=?";
            
            ketNoi();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(6, maNK);
            ps.setInt(1, vt.getMaVT());
            ps.setInt(2, nv.getMaNV());
            ps.setTimestamp(3, tgn);
            ps.setInt(4, dgn);
            ps.setFloat(5, sln);
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                NhapKho nk = tim(maNK);
                
                vt.setSoLuong(vt.getSoLuong() - nk.getSoLuongNhap());
                
                nk.setNhanVien(nv);
                nk.setVatTu(vt);
                nk.setThoiGianNhap(tgn);
                nk.setSoLuongNhap(sln);
                nk.setDonGiaNhap(dgn);
                
                vt.setSoLuong(vt.getSoLuong() + nk.getSoLuongNhap());

                thucThi("update VatTu set SoLuong= " + vt.getSoLuong()
                        + "where MaVT=" + vt.getMaVT() + "");
                
                thongBao = "Cập nhật thông tin nhập kho thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Cập nhật thông tin nhập kho thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean xoa(int maNK)
    {
        NhapKho nk = tim(maNK);
        
        boolean kq = thucThi("delete from NhapKho where MaNK='" + maNK + "'");
        
        if (kq)
        {
            VatTu vt = nk.getVatTu();
            vt.setSoLuong(vt.getSoLuong() - nk.getSoLuongNhap());
            vt.getLichSuNhapKho().remove(nk);

            thucThi("update VatTu set SoLuong= " + vt.getSoLuong()
                    + "where MaVT=" + vt.getMaVT() + "");
            
            DanhSach.getLichSuNK().remove(nk);
            thongBao = "Xóa thông tin nhập kho thành công";
            return true;
        }
        
        thongBao = "Xóa thông tin nhập kho thất bại";
        return kq;
    }
    
    public static NhapKho tim(int maNK)
    {
        for (NhapKho nk : DanhSach.getLichSuNK())
        {
            if (nk.getMaNK() == maNK)
            {
                return nk;
            }
        }
        
        return null;
    }
}
