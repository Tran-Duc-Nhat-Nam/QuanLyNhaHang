package pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HoaDon {
    private int maHD;
    private NhanVien nhanVien;
    private Timestamp thoiGianLap;
    private long tongTien;
    private boolean TinhTrangThanhToan; 
    private List<ChiTietHoaDon> danhSachCTHD;
    private DonDatTruoc donDatTruoc;
    private List<ChiTietHoaDon_Ban> danhSachCTHD_Ban;
    private List<ChiTietHoaDon_Phong> danhSachCTHD_Phong;

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Timestamp getThoiGianLap() {
        return thoiGianLap;
    }

    public void setThoiGianLap(Timestamp thoiGianLap) {
        this.thoiGianLap = thoiGianLap;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTinhTrangThanhToan() {
        return TinhTrangThanhToan;
    }

    public void setTinhTrangThanhToan(boolean TinhTrangThanhToan) {
        this.TinhTrangThanhToan = TinhTrangThanhToan;
    }

    public List<ChiTietHoaDon> getDanhSachCTHD() {
        return danhSachCTHD;
    }

    public void setDanhSachCTHD(List<ChiTietHoaDon> danhSachCTHD) {
        this.danhSachCTHD = danhSachCTHD;
    }

    public DonDatTruoc getDonDatTruoc() {
        return donDatTruoc;
    }

    public void setDonDatTruoc(DonDatTruoc donDatTruoc) {
        this.donDatTruoc = donDatTruoc;
    }

    public List<ChiTietHoaDon_Ban> getDanhSachCTHD_Ban() {
        return danhSachCTHD_Ban;
    }

    public void setDanhSachCTHD_Ban(List<ChiTietHoaDon_Ban> danhSachCTHD_Ban) {
        this.danhSachCTHD_Ban = danhSachCTHD_Ban;
    }

    public List<ChiTietHoaDon_Phong> getDanhSachCTHD_Phong() {
        return danhSachCTHD_Phong;
    }

    public void setDanhSachCTHD_Phong(List<ChiTietHoaDon_Phong> danhSachCTHD_Phong) {
        this.danhSachCTHD_Phong = danhSachCTHD_Phong;
    }
    
    public HoaDon() 
    {
        this.danhSachCTHD = new ArrayList<>();
        this.tongTien = 0;
        this.TinhTrangThanhToan = false;
        this.danhSachCTHD_Ban = new ArrayList<>();
        this.danhSachCTHD_Phong = new ArrayList<>();
    }

    public HoaDon(int maHD, NhanVien nv, Timestamp thoiGianLap) {
        this.maHD = maHD;
        this.nhanVien = nv;
        this.thoiGianLap = thoiGianLap;
        this.tongTien = 0;
        this.TinhTrangThanhToan = false;
        this.danhSachCTHD = new ArrayList<>(); 
        this.danhSachCTHD_Ban = new ArrayList<>();
        this.danhSachCTHD_Phong = new ArrayList<>();
    } 
}
