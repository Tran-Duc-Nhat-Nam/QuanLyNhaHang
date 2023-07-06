package dao;

import static dao.XuLyCSDL.connection;
import static dao.XuLyCSDL.ketNoi;
import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import static dao.XuLyCSDL.thongBao;
import static dao.XuLyCSDL.thucThi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import pojo.Ban;
import pojo.ChiTietHoaDon_Ban;
import pojo.ChiTietHoaDon_Phong;
import pojo.DanhSach;
import pojo.DonDatTruoc;
import pojo.HoaDon;
import pojo.NhanVien;
import pojo.Phong;

public class XuLyDatTruoc {
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("DonDatTruoc");
            
            while (resultSet.next())
            {
                DonDatTruoc ddt = new DonDatTruoc();
                ddt.setHoaDon(XuLyHoaDon.tim(resultSet.getInt("MaHD")));
                ddt.setThoiGianBatDau(resultSet.getTimestamp("ThoiGianBatDau"));
                ddt.setThoiGianKetThuc(resultSet.getTimestamp("ThoiGianKetThuc"));
                ddt.setTienCoc(resultSet.getInt("TienCoc"));
                ddt.getHoaDon().setDonDatTruoc(ddt);
                DanhSach.getDanhSachDDT().add(ddt);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static boolean them(HoaDon hd, NhanVien nv, Timestamp tgbd, Timestamp tgkt)
    {
        try {
            int tc = 0;
            Calendar cal = Calendar.getInstance();
        
            cal.setTimeInMillis(tgbd.getTime());  
            int gioBatDau = cal.get(Calendar.HOUR_OF_DAY);
            
            if (gioBatDau < 6)
            {
                thongBao = "Nhà hàng chỉ hoạt động từ 6h";
                return false;
            }
            
            cal.setTimeInMillis(tgkt.getTime());  
            int gioKetThuc = cal.get(Calendar.HOUR_OF_DAY);
            
            if (gioKetThuc > 22)
            {
                thongBao = "Nhà hàng chỉ hoạt động đến 22h";
                return false;
            }
            
            if (gioBatDau >= gioKetThuc)
            {
                thongBao = "Giờ bắt đầu phải sớm hơn giờ kết thúc";
                return false;
            }
            
            hd = DanhSach.getDanhSachHD().get(DanhSach.getDanhSachHD().size() - 1);
                
            for (ChiTietHoaDon_Ban cthd : hd.getDanhSachCTHD_Ban())
            {
                tc += cthd.getBan().getGiaDatTruoc() * (gioKetThuc - gioBatDau);
            }

            String sql = "insert into DonDatTruoc values (?, ?, ?, ?)";

            ketNoi();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, hd.getMaHD());
            ps.setTimestamp(2, tgbd);
            ps.setTimestamp(3, tgkt);
            ps.setInt(4, tc);

            boolean kq = XuLyCSDL.thucThi(ps);

            if (kq)
            {
                DonDatTruoc ddt = new DonDatTruoc();
                ddt.setHoaDon(hd);
                ddt.setThoiGianBatDau(tgbd);
                ddt.setThoiGianKetThuc(tgkt);
                ddt.setTienCoc(tc);
                ddt.getHoaDon().setDonDatTruoc(ddt);
                DanhSach.getDanhSachDDT().add(ddt);
                thongBao = "Thêm đơn đặt trước thành công";
            }

            return kq;
            
        } catch (SQLException e) {
            thongBao = "Thêm đơn đặt trước thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean checkThoiGian(Timestamp tgbd)
    {
        Calendar cal = Calendar.getInstance();
        
        cal.setTimeInMillis(tgbd.getTime());  
        int namDB = cal.get(Calendar.YEAR);
        int ngayBD = cal.get(Calendar.DAY_OF_YEAR);

        cal.setTimeInMillis(new java.util.Date().getTime());  
        int namHT = cal.get(Calendar.YEAR);
        int ngayHT = cal.get(Calendar.DAY_OF_YEAR);

        if (namDB == namHT && ngayBD == ngayHT)
        {
            thongBao = "Phải đặt trước ít nhất 1 ngày";
            return false;
        }
        
        return true;
    }
    
    public static boolean checkGio(DonDatTruoc ddt, Timestamp tgbd, Timestamp tgkt)
    {
        if (ddt != null)
        {
            int bda = tgbd.compareTo(ddt.getThoiGianBatDau());
            int bdb = tgbd.compareTo(ddt.getThoiGianKetThuc());
            boolean batDau = bda >= 0 && bdb < 0;
            int kta = tgkt.compareTo(ddt.getThoiGianBatDau());
            int ktb = tgkt.compareTo(ddt.getThoiGianKetThuc());
            boolean ketThuc = kta > 0 && ktb <= 0;
            boolean baoGom = bda <= 0 && ktb >= 0;

            if (batDau || ketThuc || baoGom)
            {      
                thongBao = "Bàn đã được đặt trong khung giờ này";
                return false;
            }
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean themBan(List<Ban> dsBan, NhanVien nv, Timestamp tgbd, Timestamp tgkt)
    {
        List<DonDatTruoc> temp = DanhSach.getDanhSachDDT();
        for (Ban b : dsBan)
        {
            for (ChiTietHoaDon_Ban cthd : b.getLichSuHoaDon())
            {
                if (cthd.getHoaDon().getDonDatTruoc() == null 
                        && !cthd.getHoaDon().isTinhTrangThanhToan())
                {
                    if (!checkThoiGian(tgbd))
                    {
                        return false;
                    }
                }
            }
            
            for (ChiTietHoaDon_Ban cthd : b.getLichSuHoaDon())
            {
                DonDatTruoc ddt = cthd.getHoaDon().getDonDatTruoc();
                
                if (ddt != null)
                {
                    int bda = tgbd.compareTo(ddt.getThoiGianBatDau());
                    int bdb = tgbd.compareTo(ddt.getThoiGianKetThuc());
                    boolean batDau = bda >= 0 && bdb < 0;
                    int kta = tgkt.compareTo(ddt.getThoiGianBatDau());
                    int ktb = tgkt.compareTo(ddt.getThoiGianKetThuc());
                    boolean ketThuc = kta > 0 && ktb <= 0;
                    boolean baoGom = bda <= 0 && ktb >= 0;

                    if (batDau || ketThuc || baoGom)
                    {      
                        thongBao = "Bàn đã được đặt trong khung giờ này";
                        return false;
                    }
                    
                    System.out.println(ddt.getThoiGianBatDau());
                    System.out.println(ddt.getThoiGianKetThuc());
                    System.out.println(bda + " " + bdb + " " + kta + " " + ktb);
                }
            }
        }
        
        HoaDon hd;
        
        if (XuLyHoaDon.them(nv, Timestamp.valueOf(LocalDateTime.now())))
        {
            hd = DanhSach.getDanhSachHD().get(DanhSach.getDanhSachHD().size() - 1);
            
            for (Ban b : dsBan)
            {
                if (!XuLyCTHD_Ban.them(hd, b))
                {
                    XuLyHoaDon.xoa(hd.getMaHD());
                    return false;
                }
            }
            
            return them(hd, nv, tgbd, tgkt);
        }
        else
        {
            return false;
        }
    }
    
    public static boolean themPhong(List<Phong> dsPhong, NhanVien nv, Timestamp tgbd, Timestamp tgkt)
    {
        for (Phong b : dsPhong)
        {
            for (ChiTietHoaDon_Phong cthd : b.getLichSuHoaDon())
            {
                if (cthd.getHoaDon().getDonDatTruoc() == null 
                        && !cthd.getHoaDon().isTinhTrangThanhToan())
                {
                    if (!checkThoiGian(tgbd))
                    {
                        return false;
                    }
                }
            }
            
            for (ChiTietHoaDon_Phong cthd : b.getLichSuHoaDon())
            {
                DonDatTruoc ddt = cthd.getHoaDon().getDonDatTruoc();
                
                if (ddt != null)
                {
                    int bda = tgbd.compareTo(ddt.getThoiGianBatDau());
                    int bdb = tgbd.compareTo(ddt.getThoiGianKetThuc());
                    boolean batDau = bda >= 0 && bdb < 0;
                    int kta = tgkt.compareTo(ddt.getThoiGianBatDau());
                    int ktb = tgkt.compareTo(ddt.getThoiGianKetThuc());
                    boolean ketThuc = kta > 0 && ktb <= 0;
                    boolean baoGom = bda <= 0 && ktb >= 0;

                    if (batDau || ketThuc || baoGom)
                    {      
                        thongBao = "Bàn đã được đặt trong khung giờ này";
                        return false;
                    }
                    
                    System.out.println(ddt.getThoiGianBatDau());
                    System.out.println(ddt.getThoiGianKetThuc());
                    System.out.println(bda + " " + bdb + " " + kta + " " + ktb);
                }
            }
        }
        
        HoaDon hd;
        
        if (XuLyHoaDon.them(nv, Timestamp.valueOf(LocalDateTime.now())))
        {
            hd = DanhSach.getDanhSachHD().get(DanhSach.getDanhSachHD().size() - 1);
            
            for (Phong b : dsPhong)
            {
                if (!XuLyCTHD_Phong.them(hd, b))
                {
                    XuLyHoaDon.xoa(hd.getMaHD());
                    return false;
                }
            }
            
            return them(hd, nv, tgbd, tgkt);
        }
        else
        {
            return false;
        }
    }
    
    public static boolean suaGio(HoaDon hd, Timestamp tgbd, Timestamp tgkt)
    {
        try {
            for (ChiTietHoaDon_Ban temp : hd.getDanhSachCTHD_Ban())
            {
                Ban b = temp.getBan();        
                
                for (ChiTietHoaDon_Ban cthd : b.getLichSuHoaDon())
                {
                    if (cthd.getHoaDon().getDonDatTruoc() == null 
                            && !cthd.getHoaDon().isTinhTrangThanhToan())
                    {
                        if (!checkThoiGian(tgbd))
                        {
                            return false;
                        }
                    }
                }

                for (ChiTietHoaDon_Ban cthd : b.getLichSuHoaDon())
                {
                    if (!checkGio(cthd.getHoaDon().getDonDatTruoc(), tgbd, tgkt))
                    {
                        return false;
                    }
                }
            }
            
            String sql = "update DonDatTruoc set ThoiGianBatDau=?, "
                    + "ThoiGianKetThuc=? where MaHD=?";
            
            ketNoi();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, tgbd);
            ps.setTimestamp(2, tgkt);
            ps.setInt(3, hd.getMaHD());
            
            boolean kq = thucThi(ps);
            
            if (kq)
            {
                DonDatTruoc nv = tim(hd.getMaHD());
                nv.setThoiGianBatDau(tgbd);
                nv.setThoiGianKetThuc(tgkt);
                thongBao = "Cập nhật thời gian đặt trước thành công";
            }
            return kq;
        } catch (SQLException e) {
            thongBao = "Cập nhật thời gian đặt trước thất bại";
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean suaBan(HoaDon hd, List<Ban> dsBan)
    {
        for (Ban b : dsBan)
        {                      
            for (ChiTietHoaDon_Ban cthd : b.getLichSuHoaDon())
            {
                if (cthd.getHoaDon().getDonDatTruoc() == null 
                        && !cthd.getHoaDon().isTinhTrangThanhToan())
                {
                    if (!checkThoiGian(hd.getDonDatTruoc().getThoiGianBatDau()))
                    {
                        return false;
                    }
                }
            }

            for (ChiTietHoaDon_Ban cthd : b.getLichSuHoaDon())
            {
                if (!checkGio(cthd.getHoaDon().getDonDatTruoc(),
                        hd.getDonDatTruoc().getThoiGianBatDau(), 
                        hd.getDonDatTruoc().getThoiGianKetThuc()))
                {
                    return false;
                }
            }
        }
        
        for (ChiTietHoaDon_Ban cthd : hd.getDanhSachCTHD_Ban())
        {
            if (!XuLyCTHD_Ban.xoa(hd, cthd.getBan()))
            {
                return false;
            }
        }
        
        for (Ban b : dsBan)
        {                      
            if (!XuLyCTHD_Ban.them(hd, b))
            {
                return false;
            }
        }
        
        thongBao = "Cập nhật thông tin đặt bàn thành công";
        return true;
    }
    
    public static boolean suaPhong(HoaDon hd, List<Phong> dsPhong)
    {
        for (Phong b : dsPhong)
        {                      
            for (ChiTietHoaDon_Phong cthd : b.getLichSuHoaDon())
            {
                if (cthd.getHoaDon().getDonDatTruoc() == null 
                        && !cthd.getHoaDon().isTinhTrangThanhToan())
                {
                    if (!checkThoiGian(hd.getDonDatTruoc().getThoiGianBatDau()))
                    {
                        return false;
                    }
                }
            }

            for (ChiTietHoaDon_Phong cthd : b.getLichSuHoaDon())
            {
                if (!checkGio(cthd.getHoaDon().getDonDatTruoc(),
                        hd.getDonDatTruoc().getThoiGianBatDau(), 
                        hd.getDonDatTruoc().getThoiGianKetThuc()))
                {
                    return false;
                }
            }
        }
        
        for (ChiTietHoaDon_Phong cthd : hd.getDanhSachCTHD_Phong())
        {
            if (!XuLyCTHD_Phong.xoa(hd, cthd.getPhong()))
            {
                return false;
            }
        }
        
        for (Phong b : dsPhong)
        {                      
            if (!XuLyCTHD_Phong.them(hd, b))
            {
                return false;
            }
        }
        
        thongBao = "Cập nhật thông tin đặt phòng thành công";
        return true;
    }
    
    public static boolean xoa(int maHD)
    {       
        boolean kq = thucThi("delete from DonDatTruoc where MaHD='" + maHD + "'");
        
        if (kq)
        {  
            DanhSach.getDanhSachDDT().remove(tim(maHD));
            XuLyHoaDon.xoa(maHD);
            thongBao = "Xóa đơn đạt trước thành công";
        }
        else
        {
            thongBao = "Xóa đơn đạt trước thất bại";
        }
        
        return kq;
    }
    
    public static DonDatTruoc tim(int maHD)
    {
        for (HoaDon hd : DanhSach.getDanhSachHD())
        {
            if (hd.getMaHD() == maHD)
            {
                return hd.getDonDatTruoc();
            }
        }
        
        return null;
    }
}
