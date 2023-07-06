package dao;

import static dao.XuLyCSDL.ngatKetNoi;
import static dao.XuLyCSDL.resultSet;
import java.sql.SQLException;
import pojo.DanhSach;
import pojo.Tang;

public class XuLyTang {
    public static Tang tim(int soTang)
    {
        for (Tang t : DanhSach.getDanhSachTang())
        {
            if (t.getSoTang() == soTang)
            {
                return t;
            }
        }
        
        return null;
    }
    
    public static boolean capNhat(int soLuongTang)
    {
        return true;
    }
    
    public static boolean doc()
    {
        try {
            XuLyCSDL.doc("Tang");
            
            while (resultSet.next())
            {
                Tang t = new Tang(resultSet.getInt("SoTang"));
                DanhSach.getDanhSachTang().add(t);
            }
            
            ngatKetNoi();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}

