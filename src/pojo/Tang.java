package pojo;

import java.util.ArrayList;
import java.util.List;

public class Tang {
    private int soTang;
    private List<Phong> danhSachPhong;

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public List<Phong> getDanhSachPhong() {
        return danhSachPhong;
    }

    public void setDanhSachPhong(List<Phong> danhSachPhong) {
        this.danhSachPhong = danhSachPhong;
    }
    
    public Tang() {}
    
    public Tang(int soTang)
    {
        this.soTang = soTang;
        this.danhSachPhong = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(soTang);
    }
}
