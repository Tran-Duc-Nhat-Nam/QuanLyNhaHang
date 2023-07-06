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
public class NhapKho {
    private int maNK;
    private VatTu vatTu;
    private NhanVien nhanVien;
    private Timestamp thoiGianNhap;
    private float soLuongNhap;
    private int donGiaNhap;

    public int getMaNK() {
        return maNK;
    }

    public void setMaNK(int maNK) {
        this.maNK = maNK;
    }

    public VatTu getVatTu() {
        return vatTu;
    }

    public void setVatTu(VatTu vatTu) {
        this.vatTu = vatTu;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Timestamp getThoiGianNhap() {
        return thoiGianNhap;
    }

    public void setThoiGianNhap(Timestamp thoiGianNhap) {
        this.thoiGianNhap = thoiGianNhap;
    }

    public float getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(float soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(int donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public NhapKho() {}

    public NhapKho(int maNK, VatTu vatTu, NhanVien nhanVien, Timestamp thoiGianNhap, float soLuongNhap, int donGiaNhap) {
        this.maNK = maNK;
        this.vatTu = vatTu;
        this.nhanVien = nhanVien;
        this.thoiGianNhap = thoiGianNhap;
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
    }
}
