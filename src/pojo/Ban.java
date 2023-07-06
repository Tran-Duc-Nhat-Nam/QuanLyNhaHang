package pojo;

import java.util.ArrayList;
import java.util.List;

public class Ban {
    private int maBan;
    private int soBan;
    private Phong phong;
    private int giaDatTruoc;
    private List<ChiTietHoaDon_Ban> lichSuHoaDon;

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public int getGiaDatTruoc() {
        return giaDatTruoc;
    }

    public void setGiaDatTruoc(int giaDatTruoc) {
        this.giaDatTruoc = giaDatTruoc;
    }

    public List<ChiTietHoaDon_Ban> getLichSuHoaDon() {
        return lichSuHoaDon;
    }

    public void setLichSuHoaDon(List<ChiTietHoaDon_Ban> lichSuHoaDon) {
        this.lichSuHoaDon = lichSuHoaDon;
    }
    
    public Ban() {this.lichSuHoaDon = new ArrayList<>();}

    public Ban(int maBan, int soBan, Phong phong, int giaDatTruoc) {
        this.maBan = maBan;
        this.soBan = soBan;
        this.phong = phong;
        this.giaDatTruoc = giaDatTruoc;
        this.lichSuHoaDon = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(soBan);
    }
}
