/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class VatTu {
    private int maVT;
    private String tenVT;
    private String nguonGoc;
    private String donViTinh;
    private float soLuong;
    private int donGia;
    private List<CheBien> danhSachCheBien;
    private List<NhapKho> lichSuNhapKho;

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public List<CheBien> getDanhSachCheBien() {
        return danhSachCheBien;
    }

    public void setDanhSachCheBien(List<CheBien> danhSachCheBien) {
        this.danhSachCheBien = danhSachCheBien;
    }

    public List<NhapKho> getLichSuNhapKho() {
        return lichSuNhapKho;
    }

    public void setLichSuNhapKho(List<NhapKho> lichSuNhapKho) {
        this.lichSuNhapKho = lichSuNhapKho;
    }

    @Override
    public String toString() {
        return tenVT;
    }
    
    public VatTu()
    {
        this.danhSachCheBien = new ArrayList<>();
        this.lichSuNhapKho = new ArrayList<>();
    }

    public VatTu(int maVT, String tenVT, String nguonGoc, String donViTinh, float soLuong, int donGia) {
        this.maVT = maVT;
        this.tenVT = tenVT;
        this.nguonGoc = nguonGoc;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.danhSachCheBien = new ArrayList<>();
        this.lichSuNhapKho = new ArrayList<>();
    }
}
