package dao;

import static dao.XuLyCSDL.connection;
import static dao.XuLyCSDL.ketNoi;
import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import pojo.ChucVu;
import pojo.DanhSach;
import pojo.NhanVien;
import pojo.Luong;
import pojo.Thuong;

public class XuLyNhanVien {
    public static NhanVien tim(int maNV)
    {
        for (NhanVien nv : DanhSach.getDanhSachNV())
        {
            if (nv.getMaNV() == maNV)
            {
                return nv;
            }
        }
        
        return null;
    }
    
    public static List<NhanVien> tim(String tk)
    {
        List<NhanVien> dsNhanVien = new ArrayList<>();
        try
        {
            String sql = "select * from NhanVien where TenNV like ? "
                + "or GioiTinh like ? or CMND_CCCD like ? "
                + "or SDT like ? or NoiSinh like ? or DiaChi like ? "
                + "or CONVERT (VARCHAR(100), HeSoLuong, 2) like ? "
                + "or CAST(NgaySinh as VARCHAR(100)) like ? "
                + "or CAST(ThoiGianNhanViec as VARCHAR(100)) like ? "
                + "or CAST(ThoiGianThoiViec as VARCHAR(100)) like ? "
                + "or CAST(ChucVu as VARCHAR(100)) like ? or CAST(MaNV as VARCHAR(100)) like ?";
            
            ketNoi();

            PreparedStatement ps = connection.prepareStatement(sql);

            for (int i = 1; i <= 12; i++)
            {
                ps.setNString(i, "%" + tk + "%");
            }
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next())
            {
                NhanVien nv = new NhanVien();
                nv.setMaNV(resultSet.getInt("MaNV"));
                nv.setTenNV(resultSet.getNString("TenNV"));
                nv.setCccd(resultSet.getString("CMND_CCCD"));
                nv.setGioiTinh(resultSet.getNString("GioiTInh"));
                nv.setDiaChi(resultSet.getNString("DiaChi"));
                nv.setNoiSinh(resultSet.getNString("NoiSinh"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setThoiGianNhanVien(resultSet.getDate("ThoiGianNhanViec"));
                nv.setThoiGianThoiViec(resultSet.getDate("ThoiGianThoiViec"));
                nv.setSdt(resultSet.getString("SDT"));
                nv.setHeSoLuong(resultSet.getFloat("HeSoLuong"));
                ChucVu cv = XuLyChucVu.tim(resultSet.getInt("ChucVu"));
                
                cv.getDanhSachNV().add(nv);
                nv.setChucVu(cv);
                
                dsNhanVien.add(nv);
            }
            
            ngatKetNoi();
            
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return dsNhanVien;
    }
    
    public static boolean kiemTra(int ma, float hsl, Date ngs, String cccd, String sdt)
    {
        if (hsl < 1)
        {
            thongBao = "Hệ số lương phải từ 1 trở lên";
            return false;
        }

        LocalDate today = LocalDate.now();
        LocalDate birthday = ngs.toLocalDate();

        Period p = Period.between(birthday, today);
        System.out.println(p.getYears());

        if (p.getYears() < 18)
        {
            thongBao = "Nhân viên phải đủ 18 tuổi";
            return false;
        }

        for (NhanVien nv : DanhSach.getDanhSachNV())
        {
            if (nv.getMaNV() == ma)
            {
                continue;
            }
            
            if (nv.getCccd().equals(cccd))
            {
                thongBao = "Căn cước công dân không được trùng";
                return false;
            }
            else if (nv.getSdt().equals(sdt))
            {
                thongBao = "Số điện thoại không được trùng";
                return false;
            }
        }

        return true;
    }
    
    public static boolean them(String ten, String gt, String cccd, String ns, 
            String dc, String sdt, float hsl, Date ngs, Date tgnv, ChucVu cv)
    {
        try {
            if (!kiemTra(-1, hsl, ngs, cccd, sdt))
            {
                return false;
            }
            
            int maNV = 1;

            for (NhanVien nv : DanhSach.getDanhSachNV())
            {
                if (maNV == nv.getMaNV())
                {
                    maNV++;
                }
                else
                {
                    break;
                }
            }
            
            String sql = "insert into NhanVien values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?)";
            
            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maNV);
            ps.setNString(2, ten);
            ps.setInt(3, cv.getMaCV());
            ps.setNString(4, gt);
            ps.setNString(5, cccd);
            ps.setNString(6, sdt);
            ps.setDate(7, ngs);
            ps.setNString(8, ns);
            ps.setNString(9, dc);
            ps.setDate(10, tgnv);
            ps.setFloat(11, hsl);
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                NhanVien nv = new NhanVien(maNV, ten, gt, 
                        cccd, sdt, ngs, ns, dc, 
                        tgnv, hsl);
                DanhSach.getDanhSachNV().add(nv);
                
                cv.getDanhSachNV().add(nv);
                nv.setChucVu(cv);
                
                thongBao = "Thêm nhân viên thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Thêm nhân viên thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean sua(int ma, String ten, String gt, String cccd, String ns, 
            String dc, String sdt, float hsl, Date ngs, Date tgnv, Date tgtv, ChucVu cv)
    {
        try {
            if (!kiemTra(ma, hsl, ngs, cccd, sdt))
            {
                return false;
            }
            
            String sql = "update NhanVien set TenNV=?, GioiTinh=?, CMND_CCCD=?,"
                    + " SDT=?, NoiSinh=?, DiaChi=?, HeSoLuong=?, NgaySinh=?, "
                    + "ThoiGianNhanViec=?, ThoiGianThoiViec=?, ChucVu=? where MaNV=?";
            
            ketNoi();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(12, ma);
            ps.setNString(1, ten);
            ps.setInt(11, cv.getMaCV());
            ps.setNString(2, gt);
            ps.setNString(3, cccd);
            ps.setNString(4, sdt);
            ps.setDate(8, ngs);
            ps.setNString(5, ns);
            ps.setNString(6, dc);
            ps.setDate(9, tgnv);
            ps.setDate(10, tgtv);
            ps.setFloat(7, hsl);
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                NhanVien nv = tim(ma);
                nv.setCccd(cccd);
                nv.setChucVu(cv);
                nv.setDiaChi(dc);
                nv.setGioiTinh(gt);
                nv.setHeSoLuong(hsl);
                nv.setNgaySinh(ngs);
                nv.setNoiSinh(ns);
                nv.setSdt(sdt);
                nv.setTenNV(ten);
                nv.setThoiGianNhanVien(tgnv);
                nv.setThoiGianThoiViec(tgtv);
                thongBao = "Cập nhật nhân viên thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Cập nhật nhân viên thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean xoa(int maNV)
    {
        NhanVien nv = tim(maNV);
        
        if (!nv.getLichSuNhapKho().isEmpty())
        {
            thongBao = "Không thể xóa nhân viên do nhân viên đang được ghi nhận trong lịch sử nhập kho";
            return false;
        }
        
        thucThi("delete from TaiKhoan where MaNV='" + maNV + "'");
        thucThi("delete from Luong where MaNV='" + maNV + "'");
        thucThi("delete from Thuong where MaNV='" + maNV + "'");
        boolean kq = thucThi("delete from NhanVien where MaNV='" + maNV + "'");
        
        if (kq)
        {
            DanhSach.getDanhSachTK().remove(nv.getTaiKhoan());
            
            for (Luong l : nv.getLichSuLuong())
            {
                DanhSach.getLichSuLuong().remove(l);
            }
            
            for (Thuong t : nv.getLichSuThuong())
            {
                DanhSach.getLichSuThuong().remove(t);
            }
            
            DanhSach.getDanhSachNV().remove(nv);
            thongBao = "Xóa nhân viên thành công";
            return true;
        }
        
        thongBao = "Xóa nhân viên thất bại";
        return kq;
    }
    
    public static boolean thoiViec(int maNV)
    {
        NhanVien nv = tim(maNV);
        
        Date tgtv = new Date(new java.util.Date().getTime());

        boolean kq = XuLyCSDL.thucThi("update NhanVien set ThoiGianThoiViec='" + tgtv + "' where MaNV='" + maNV + "'");
        
        if (kq)
        {
            nv.setThoiGianThoiViec(tgtv);
            thongBao = "Thôi việc nhân viên thành công";
            return true;
        }
        
        thongBao = "Thôi việc nhân viên thất bại";
        return kq;
    }
    
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("NhanVien");
            
            while (resultSet.next())
            {
                NhanVien nv = new NhanVien();
                nv.setMaNV(resultSet.getInt("MaNV"));
                nv.setTenNV(resultSet.getNString("TenNV"));
                nv.setCccd(resultSet.getString("CMND_CCCD"));
                nv.setGioiTinh(resultSet.getNString("GioiTInh"));
                nv.setDiaChi(resultSet.getNString("DiaChi"));
                nv.setNoiSinh(resultSet.getNString("NoiSinh"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setThoiGianNhanVien(resultSet.getDate("ThoiGianNhanViec"));
                nv.setThoiGianThoiViec(resultSet.getDate("ThoiGianThoiViec"));
                nv.setSdt(resultSet.getString("SDT"));
                nv.setHeSoLuong(resultSet.getFloat("HeSoLuong"));
                ChucVu cv = XuLyChucVu.tim(resultSet.getInt("ChucVu"));
                
                cv.getDanhSachNV().add(nv);
                nv.setChucVu(cv);
                
                DanhSach.getDanhSachNV().add(nv);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
