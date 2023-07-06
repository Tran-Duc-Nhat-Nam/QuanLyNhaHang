package pojo;

import java.util.ArrayList;
import java.util.List;

public class Phong {
    private String maPhong;
    private Tang tang;
    private int giaDatTruoc;
    private List<Ban> danhSachBan;
    private List<ChiTietHoaDon_Phong> lichSuHoaDon;
    
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Tang getTang() {
        return tang;
    }

    public void setTang(Tang tang) {
        this.tang = tang;
    }
    
    public int getGiaDatTruoc() {
        return giaDatTruoc;
    }

    public void setGiaDatTruoc(int giaDatTruoc) {
        this.giaDatTruoc = giaDatTruoc;
    }

    public List<Ban> getDanhSachBan() {
        return danhSachBan;
    }

    public void setDanhSachBan(List<Ban> danhSachBan) {
        this.danhSachBan = danhSachBan;
    }

    public List<ChiTietHoaDon_Phong> getLichSuHoaDon() {
        return lichSuHoaDon;
    }

    public void setLichSuHoaDon(List<ChiTietHoaDon_Phong> lichSuHoaDon) {
        this.lichSuHoaDon = lichSuHoaDon;
    }
    
    public Phong() {
        this.danhSachBan = new ArrayList<>();
        this.lichSuHoaDon = new ArrayList<>();
    }

    public Phong(String maPhong, Tang tang, int giaDatTruoc) {
        this.maPhong = maPhong;
        this.tang = tang;
        this.giaDatTruoc = giaDatTruoc;
        this.danhSachBan = new ArrayList<>();
        this.lichSuHoaDon = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return maPhong;
    }
}
