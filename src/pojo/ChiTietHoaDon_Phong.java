package pojo;

public class ChiTietHoaDon_Phong {
    private Phong phong;
    private HoaDon hoaDon;

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    
    public ChiTietHoaDon_Phong() {}

    public ChiTietHoaDon_Phong(Phong phong, HoaDon hoaDon) {
        this.phong = phong;
        this.hoaDon = hoaDon;
    }
}
