/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author Nam
 */
public class CheBien {
    private MonAn monAn;
    private VatTu vatTu;
    private float soLuongTieuThu;

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public VatTu getVatTu() {
        return vatTu;
    }

    public void setVatTu(VatTu vatTu) {
        this.vatTu = vatTu;
    }

    public float getSoLuongTieuThu() {
        return soLuongTieuThu;
    }

    public void setSoLuongTieuThu(float soLuongTieuThu) {
        this.soLuongTieuThu = soLuongTieuThu;
    }
    public CheBien() {}
    
    public CheBien(MonAn monAn, VatTu vatTu, float soLuongTieuThu) {
        this.monAn = monAn;
        this.vatTu = vatTu;
        this.soLuongTieuThu = soLuongTieuThu;
    }  
}
