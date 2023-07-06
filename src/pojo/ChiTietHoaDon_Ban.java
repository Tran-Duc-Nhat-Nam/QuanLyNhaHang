/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author Nam
 */
public class ChiTietHoaDon_Ban {
    private Ban ban;
    private HoaDon hoaDon;

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    
    public ChiTietHoaDon_Ban() {}

    public ChiTietHoaDon_Ban(Ban ban, HoaDon hoaDon) {
        this.ban = ban;
        this.hoaDon = hoaDon;
    }
}
