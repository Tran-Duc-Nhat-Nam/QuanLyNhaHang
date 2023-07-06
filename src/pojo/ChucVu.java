package pojo;

import java.util.ArrayList;
import java.util.List;

public class ChucVu {
    private int maCV;
    private String tenChucVu;
    private float heSoLuongCoBan;
    private List<NhanVien> danhSachNV;

    public int getMaCV() {
        return maCV;
    }

    public void setMaCV(int maCV) {
        this.maCV = maCV;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public float getHeSoLuongCoBan() {
        return heSoLuongCoBan;
    }

    public void setHeSoLuongCoBan(float heSoLuongCoBan) {
        this.heSoLuongCoBan = heSoLuongCoBan;
    }
    
    

    public List<NhanVien> getDanhSachNV() {
        return danhSachNV;
    }

    public void setDanhSachNV(List<NhanVien> danhSachNV) {
        this.danhSachNV = danhSachNV;
    }
    
    public ChucVu() {
        this.maCV = -1;
        this.tenChucVu = "Trống";
        this.heSoLuongCoBan = 0;
        this.danhSachNV = new ArrayList<>();
    }

    public ChucVu(int maCV, String tenChucVu, float heSoLuongCoBan) {
        this.maCV = maCV;
        this.tenChucVu = tenChucVu;
        this.heSoLuongCoBan = 0;
        this.danhSachNV = new ArrayList<>();
    }

    @Override
    public String toString() {
        return tenChucVu;
    }
}
