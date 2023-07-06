/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Nam
 */
public class Luong {
    private int maLuong;
    private NhanVien nhanVien;
    private Timestamp thoiGian;
    private long tienLuong;

    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
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

    public long getTienLuong() {
        return tienLuong;
    }

    public void setTienLuong(long tienLuong) {
        this.tienLuong = tienLuong;
    }
    
    public Luong() {}

    public Luong(int maLuong, NhanVien nhanVien, Timestamp thoiGian, long tienLuong) {
        this.maLuong = maLuong;
        this.nhanVien = nhanVien;
        this.thoiGian = thoiGian;
        this.tienLuong = tienLuong;
    }
}
