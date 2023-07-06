/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.sql.Timestamp;

/**
 *
 * @author Nam
 */
public class Thuong {
    private int maThuong;
    private NhanVien nhanVien;
    private Timestamp thoiGian;
    private String lyDo;
    private long tienThuong;

    public int getMaThuong() {
        return maThuong;
    }

    public void setMaThuong(int maThuong) {
        this.maThuong = maThuong;
    }
    
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public long getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(long tienThuong) {
        this.tienThuong = tienThuong;
    }
    
    public Thuong() {}

    public Thuong(int maThuong, NhanVien nhanVien, Timestamp thoiGian, String lyDo, long tienLuong) {
        this.maThuong = maThuong;
        this.nhanVien = nhanVien;
        this.thoiGian = thoiGian;
        this.lyDo = lyDo;
        this.tienThuong = tienLuong;
    }
}
