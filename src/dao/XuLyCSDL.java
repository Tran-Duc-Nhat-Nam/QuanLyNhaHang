package dao;

import java.sql.*;
import java.util.List;
import pojo.DanhSach;
import pojo.DonDatTruoc;
import pojo.HoaDon;
import pojo.NhanVien;

public final class XuLyCSDL {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static NhanVien nhanVien;
    static String thongBao;
    static String maKhanCap;
    
    public static void khoiTao()
    {
        ketNoi();
        docMaKhanCap();
        XuLyTang.doc();
        XuLyPhong.doc();
        XuLyBan.doc();
        XuLyChucVu.doc();
        XuLyNhanVien.doc();
        XuLyTaiKhoan.doc();
        XuLyHoaDon.doc();
        XuLyMonAn.doc();
        XuLyVatTu.doc();
        XuLyNhapKho.doc();
        XuLyCheBien.doc();
        XuLyCTHD.doc();
        XuLyLuong.doc();
        XuLyThuong.doc();
        XuLyDatTruoc.doc();   
        List<HoaDon> tempHD = DanhSach.getDanhSachHD();
        List<DonDatTruoc> tempDTT = DanhSach.getDanhSachDDT();
        XuLyCTHD_Ban.doc();
        tempDTT = DanhSach.getDanhSachDDT();
        XuLyCTHD_Phong.doc();
        tempDTT = DanhSach.getDanhSachDDT();
        
        
        thongBao = "Kết nối CSDL thành công";
        ngatKetNoi();
    }

    public static void ketNoi()
    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://" +
                    "NHATNAM\\NAM:1433;" +
                    "databaseName=QuanLyNhaHang;" +
                    "encrypt=true;" +
                    "trustServerCertificate=true;" +
                    "user=sa;" +
                    "password=123");
            statement = connection.createStatement();
  
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void ngatKetNoi()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private static void docMaKhanCap()
    {
        try {
            ketNoi();
            resultSet = statement.executeQuery("select GiaTri from ThongTin where TenThongTin=N'Mã khẩn cấp'");
            
            if (resultSet.next())
            {
                maKhanCap = resultSet.getString("GiaTri");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static String getMaKhanCap() {
        return maKhanCap;
    }

    public static void setMaKhanCap(String maKhanCap) {
        XuLyCSDL.maKhanCap = maKhanCap;
    }

    public static NhanVien getNhanVien() {
        return nhanVien;
    }

    public static void setNhanVien(NhanVien nhanVien) {
        XuLyCSDL.nhanVien = nhanVien;
    }

    public static String getThongBao() {
        return thongBao;
    }

    public static void setThongBao(String thongBao) {
        XuLyCSDL.thongBao = thongBao;
    }

    public static boolean doc(String tenBang)
    {
        try {
            ketNoi();
            resultSet = statement.executeQuery("select * from " + tenBang);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean doc(String tenBang, String tenCot)
    {
        try {
            ketNoi();
            resultSet = statement.executeQuery("select " + tenCot + " from " + tenBang);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean thucThi(String sql)
    {
        try {
            ketNoi();
            int kq = statement.executeUpdate(sql);
            ngatKetNoi();
            return kq > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean thucThi(PreparedStatement preparedStatement)
    {
        try {
            int kq = preparedStatement.executeUpdate();
            ngatKetNoi();
            return kq > 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    

    


    
   
    

    

}
