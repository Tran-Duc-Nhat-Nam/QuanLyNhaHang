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
public class MonAn {
    private int maMA;
    private String tenMA;
    private String donViTinh;
    private int donGia;
    private List<CheBien> danhSachCB;
    private List<ChiTietHoaDon> danhSachCTHD;

    public int getMaMA() {
        return maMA;
    }

    public void setMaMA(int maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public List<CheBien> getDanhSachCB() {
        return danhSachCB;
    }

    public void setDanhSachCB(List<CheBien> danhSachCB) {
        this.danhSachCB = danhSachCB;
    }

    public List<ChiTietHoaDon> getDanhSachCTHD() {
        return danhSachCTHD;
    }

    public void setDanhSachCTHD(List<ChiTietHoaDon> danhSachCTHD) {
        this.danhSachCTHD = danhSachCTHD;
    }
    
    public MonAn() {
        this.danhSachCB = new ArrayList<>();
        this.danhSachCTHD = new ArrayList<>();
    }

    public MonAn(int maMA, String tenMA, String donViTinh, int donGia) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.danhSachCB = new ArrayList<>();
        this.danhSachCTHD = new ArrayList<>();
    }
}
