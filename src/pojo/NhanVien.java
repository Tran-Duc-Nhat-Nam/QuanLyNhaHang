package pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVien {
    private int maNV;
    private String tenNV;
    private String gioiTinh;
    private String cccd;
    private String sdt;
    private Date ngaySinh;
    private String noiSinh;
    private String diaChi;
    private Date thoiGianNhanVien;
    private Date thoiGianThoiViec;
    private float heSoLuong;
    private ChucVu chucVu;
    private TaiKhoan taiKhoan;
    private List<Luong> lichSuTienLuong; 
    private List<Thuong> lichSuTienThuong; 
    private List<NhapKho> lichSuNhapKho;

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getThoiGianNhanVien() {
        return thoiGianNhanVien;
    }

    public void setThoiGianNhanVien(Date thoiGianNhanVien) {
        this.thoiGianNhanVien = thoiGianNhanVien;
    }

    public Date getThoiGianThoiViec() {
        return thoiGianThoiViec;
    }

    public void setThoiGianThoiViec(Date thoiGianThoiViec) {
        this.thoiGianThoiViec = thoiGianThoiViec;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public List<Luong> getLichSuLuong() {
        return lichSuTienLuong;
    }

    public void setLichSuTienLuong(List<Luong> lichSuTienLuong) {
        this.lichSuTienLuong = lichSuTienLuong;
    }

    public List<Thuong> getLichSuThuong() {
        return lichSuTienThuong;
    }

    public void setLichSuTienThuong(List<Thuong> lichSuTienThuong) {
        this.lichSuTienThuong = lichSuTienThuong;
    }

    public List<NhapKho> getLichSuNhapKho() {
        return lichSuNhapKho;
    }

    public void setLichSuNhapKho(List<NhapKho> lichSuNhapKho) {
        this.lichSuNhapKho = lichSuNhapKho;
    }
    
    public NhanVien() {
        this.lichSuTienLuong = new ArrayList<>();
        this.lichSuTienThuong = new ArrayList<>();
        this.lichSuNhapKho = new ArrayList<>();
    }

    public NhanVien(int maCV, String tenNV, String gioiTinh, String cccd, String sdt, Date ngaySinh, String noiSinh, String diaChi, Date thoiGianNhanVien, float luong) {
        this.maNV = maCV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.diaChi = diaChi;
        this.thoiGianNhanVien = thoiGianNhanVien;
        this.heSoLuong = luong;
        this.lichSuTienLuong = new ArrayList<>();
        this.lichSuTienThuong = new ArrayList<>();
        this.lichSuNhapKho = new ArrayList<>();
    }

    @Override
    public String toString() {
        return tenNV;
    }
}
