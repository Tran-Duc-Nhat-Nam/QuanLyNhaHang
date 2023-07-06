package gui;

import dao.XuLyBan;
import dao.XuLyCSDL;
import static dao.XuLyCSDL.getThongBao;
import dao.XuLyCTHD_Ban;
import dao.XuLyDatTruoc;
import dao.XuLyHoaDon;
import dao.XuLyPhong;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import pojo.Ban;
import pojo.ChiTietHoaDon_Ban;
import pojo.ChiTietHoaDon_Phong;
import pojo.DanhSach;
import pojo.DonDatTruoc;
import pojo.HoaDon;
import pojo.Phong;

public class FormDatTruoc extends ParentForm {
    NonEditableTableModel netmPhong = new NonEditableTableModel();
    NonEditableTableModel netmBan = new NonEditableTableModel();
    NonEditableTableModel netmDatTruoc = new NonEditableTableModel();
    NonEditableTableModel netmCTDT = new NonEditableTableModel();

    public FormDatTruoc() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        tbPhong.setModel(netmPhong);
        tbBan.setModel(netmBan);
        tbDatTruoc.setModel(netmDatTruoc);
        tbCTDT.setModel(netmCTDT);
        tbHoaDon.setModel(dtm);
        
        tbPhong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbBan.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        hienThi();
    }
    
    private  void hienThi()
    {
        hienThiHoaDon();
        hienThiPhong(DanhSach.getDanhSachPhong());
        hienThiBan(new ArrayList<>());
        hienThiDatTruoc();
        dpBatDau.getModel().setSelected(true);
    }
    
    private void hienThiCTDB(List<ChiTietHoaDon_Ban> danhSachCTHD)
    {
        netmCTDT.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã hóa đơn");
        tieuDe.add("Số bàn");
        tieuDe.add("Mã phòng");
        netmCTDT.setColumnIdentifiers(tieuDe);
        
        for (ChiTietHoaDon_Ban cv : danhSachCTHD)
        {
            Vector<Object> v = new Vector<>();
            v.add(cv.getHoaDon().getMaHD());
            v.add(cv.getBan().getSoBan());
            v.add(cv.getBan().getPhong().getMaPhong());
            netmCTDT.addRow(v);
        }
    }
    
    private void hienThiCTDP(List<ChiTietHoaDon_Phong> danhSachCTHD)
    {
        netmCTDT.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã hóa đơn");
        tieuDe.add("Mã phòng");
        tieuDe.add("Tầng");
        netmCTDT.setColumnIdentifiers(tieuDe);
        
        for (ChiTietHoaDon_Phong cv : danhSachCTHD)
        {
            Vector<Object> v = new Vector<>();
            v.add(cv.getHoaDon().getMaHD());
            v.add(cv.getPhong().getMaPhong());
            v.add(cv.getPhong().getTang());
            netmCTDT.addRow(v);
        }
    }
    
    private void hienThiPhong(List<Phong> dsPhong)
    {
        netmPhong.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã phòng");
        tieuDe.add("Số tầng");
        netmPhong.setColumnIdentifiers(tieuDe);
        
        for (Phong p : dsPhong)
        {
            Vector<Object> v = new Vector<>();
            v.add(p.getMaPhong());
            v.add(p.getTang().getSoTang());
            netmPhong.addRow(v);
        }
    }
    
    private void hienThiBan(List<Ban> dsBan)
    {
        netmBan.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Số bàn");
        tieuDe.add("Mã phòng");
        netmBan.setColumnIdentifiers(tieuDe);
        
        for (Ban b : dsBan)
        {
            Vector<Object> v = new Vector<>();
            v.add(b.getSoBan());
            v.add(b.getPhong().getMaPhong());
            netmBan.addRow(v);
        }
    }
    
    private void hienThiDatTruoc()
    {
        netmDatTruoc.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã hóa đơn");
        tieuDe.add("Thời gian bắt đầu");
        tieuDe.add("Thời gian kết thúc");
        netmDatTruoc.setColumnIdentifiers(tieuDe);
        
        for (DonDatTruoc ddb : DanhSach.getDanhSachDDT())
        {
            Vector<Object> v = new Vector<>();
            v.add(ddb.getHoaDon().getMaHD());
            v.add(ddb.getThoiGianBatDau());
            v.add(ddb.getThoiGianKetThuc());
            netmDatTruoc.addRow(v);
        }
    }
    
    private void hienThiHoaDon()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã hóa đơn");
        tieuDe.add("Thời gian lập");
        tieuDe.add("Tổng tiền (VND)");
        tieuDe.add("Tình trạng");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (HoaDon cv : DanhSach.getDanhSachHD())
        {
            if (cv.getDonDatTruoc() == null)
            {
                Vector<Object> v = new Vector<>();
                v.add(cv.getMaHD());
                v.add(cv.getThoiGianLap());
                v.add(cv.getTongTien());
                v.add( cv.isTinhTrangThanhToan()? "Đã thanh toán" : "Chưa thanh toán");
                dtm.addRow(v);
            }
        }
    }
    
    private boolean isEmpty()
    {
        return txtGioBatDau.getText().isEmpty() ||
            txtGioKetThuc.getText().isEmpty();
    }
    
    private boolean isValidValues()
    {
        try {
            int f = Integer.parseInt(txtGioBatDau.getText());
            int a = Integer.parseInt(txtGioKetThuc.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtGioBatDau.setEditable(value);
        txtGioKetThuc.setEditable(value);
        
        btnDatTruoc.setEnabled(!value);
        btnXoa.setEnabled(!value);
        btnBan.setEnabled(!value);
        btnPhong.setEnabled(!value);
        btnThoiGian.setEnabled(!value);
        btnChuyen.setEnabled(!value);
        btnGop.setEnabled(!value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        btnBan = new javax.swing.JButton();
        btnThoiGian = new javax.swing.JButton();
        btnDatTruoc = new javax.swing.JButton();
        btnPhong = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbDatTruoc = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbCTDT = new javax.swing.JTable();
        btnGop = new javax.swing.JButton();
        btnChuyen = new javax.swing.JButton();
        dpBatDau = new org.jdatepicker.JDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGioBatDau = new javax.swing.JTextField();
        txtGioKetThuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGiaDatTruoc = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);

        btnBan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnBan.setText("Cập nhật số bàn");
        btnBan.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanActionPerformed(evt);
            }
        });

        btnThoiGian.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThoiGian.setText("Cập nhật thời gian");
        btnThoiGian.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianActionPerformed(evt);
            }
        });

        btnDatTruoc.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDatTruoc.setText("Đặt trước");
        btnDatTruoc.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnDatTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatTruocActionPerformed(evt);
            }
        });

        btnPhong.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnPhong.setText("Cập nhật số phòng");
        btnPhong.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhongActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnXoa.setText("Xóa đơn đặt trước");
        btnXoa.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tbPhong.setBackground(new java.awt.Color(255, 255, 255));
        tbPhong.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tbBan.setBackground(new java.awt.Color(255, 255, 255));
        tbBan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbBan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đơn đặt trước", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tbDatTruoc.setBackground(new java.awt.Color(255, 255, 255));
        tbDatTruoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbDatTruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDatTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatTruocMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbDatTruoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết đơn đặt trước", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tbCTDT.setBackground(new java.awt.Color(255, 255, 255));
        tbCTDT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbCTDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCTDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTDTMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbCTDT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnGop.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnGop.setText("Gộp bàn");
        btnGop.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnGop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGopActionPerformed(evt);
            }
        });

        btnChuyen.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnChuyen.setText("Chuyển bàn");
        btnChuyen.setMargin(new java.awt.Insets(6, 12, 6, 12));
        btnChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenActionPerformed(evt);
            }
        });

        jLabel1.setText("Giờ kết thúc");

        jLabel2.setText("Giờ bắt đầu");

        jLabel5.setText("Ngày đặt");

        jLabel3.setText("Giá đặt trước");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tbHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        tbHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(btnDatTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGioKetThuc)
                                    .addComponent(txtGioBatDau)
                                    .addComponent(dpBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGiaDatTruoc)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDatTruoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPhong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoiGian)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dpBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGioBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGioKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaDatTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(8, 8, 8)
                .addComponent(btnGop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChuyen)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongMouseClicked
        Phong p = XuLyPhong.tim(netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString());
        hienThiBan(p.getDanhSachBan());
        txtGiaDatTruoc.setText(String.valueOf(p.getGiaDatTruoc()));
        
        tbBan.clearSelection();
    }//GEN-LAST:event_tbPhongMouseClicked

    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
        int maBan = Integer.parseInt(netmBan.getValueAt(tbBan.getSelectedRow(), 0).toString());
        Ban b = XuLyBan.tim(maPhong, maBan);
        txtGiaDatTruoc.setText(String.valueOf(b.getGiaDatTruoc()));
    }//GEN-LAST:event_tbBanMouseClicked

    private void btnDatTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatTruocActionPerformed
        if (tbBan.getSelectedRows().length > 0)
        {
            if (btnDatTruoc.getText().equals("Đặt trước"))
            {
                tbBan.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                setButtonEditable(true);
                btnDatTruoc.setText("Tạo đơn đặt bàn");
                btnDatTruoc.setEnabled(true);
            }
            else if (!isEmpty() && isValidValues() && tbBan.getSelectedRows().length > 0)
            {
                java.sql.Date ngay = new java.sql.Date(
                    dpBatDau.getModel().getYear() - 1900,
                    dpBatDau.getModel().getMonth() - 1,
                    dpBatDau.getModel().getDay() - 1);

                cal.setTime(ngay);               
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(txtGioBatDau.getText()));
                Timestamp bd = new Timestamp(cal.getTime().getTime());  

                cal.setTime(ngay);               
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(txtGioKetThuc.getText()));
                Timestamp kt = new Timestamp(cal.getTime().getTime());
                
                String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
                
                List<Ban> dsBan = new ArrayList<>();
                
                for (int i : tbBan.getSelectedRows())
                {
                    int maBan = Integer.parseInt(netmBan.getValueAt(i, 0).toString());
                    Ban b = XuLyBan.tim(maPhong, maBan);
                    List<HoaDon> temp = DanhSach.getDanhSachHD();
                    dsBan.add(b);
                }

                if (XuLyDatTruoc.themBan(dsBan, XuLyCSDL.getNhanVien(), bd, kt))
                {
                    hienThiDatTruoc();
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
                tbBan.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                btnDatTruoc.setText("Đặt trước");
                setButtonEditable(false);
            }
            else
            {
                if (isEmpty())
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
                }
                else if (tbBan.getSelectedRows().length <= 0) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ít nhất 1 bàn");
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Giờ phải là số nguyên dương");
                }

                if (netmBan.getRowCount() >= 0)
                {
                    tbBan.setRowSelectionInterval(0, 0);
                    tbBanMouseClicked(null);
                }
            }            
        }
        else
        {
            if (btnDatTruoc.getText().equals("Đặt trước"))
            {
                tbPhong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                setButtonEditable(true);
                btnDatTruoc.setText("Tạo đơn đặt phòng");
                btnDatTruoc.setEnabled(true);
            }
            else if (!isEmpty() && isValidValues() && tbPhong.getSelectedRows().length > 0)
            {
                java.sql.Date ngay = new java.sql.Date(
                    dpBatDau.getModel().getYear() - 1900,
                    dpBatDau.getModel().getMonth() - 1,
                    dpBatDau.getModel().getDay() - 1);

                
                cal.setTime(ngay);               
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(txtGioBatDau.getText()));
                Timestamp bd = new Timestamp(cal.getTime().getTime());  

                cal.setTime(ngay);               
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(txtGioKetThuc.getText()));
                Timestamp kt = new Timestamp(cal.getTime().getTime());
                
                List<Phong> dsPhong = new ArrayList<>();
                
                for (int i : tbPhong.getSelectedRows())
                {
                    Phong p = XuLyPhong.tim(netmPhong.getValueAt(i, 0).toString());
                    dsPhong.add(p);
                }

                if (XuLyDatTruoc.themPhong(dsPhong, XuLyCSDL.getNhanVien(), bd, kt))
                {
                    hienThiDatTruoc();
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
                tbBan.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                btnDatTruoc.setText("Đặt trước");
                setButtonEditable(false);
            }
            else
            {
                if (isEmpty())
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
                }
                else if (tbPhong.getSelectedRows().length <= 0) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ít nhất 1 phòng");
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Giờ phải là số nguyên dương");
                }

                if (netmBan.getRowCount() >= 0)
                {
                    tbBan.setRowSelectionInterval(0, 0);
                    tbBanMouseClicked(null);
                }
            }
        }

    }//GEN-LAST:event_btnDatTruocActionPerformed

    private void tbDatTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatTruocMouseClicked
        int maHD = Integer.parseInt(netmDatTruoc.getValueAt(tbDatTruoc.getSelectedRow(), 0).toString());
        HoaDon hd = XuLyHoaDon.tim(maHD);
        DonDatTruoc ddt = XuLyDatTruoc.tim(maHD);
        
        cal.setTime(ddt.getThoiGianBatDau());               
        txtGioBatDau.setText(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
        
        cal.setTime(ddt.getThoiGianKetThuc());               
        txtGioKetThuc.setText(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
        
        txtGiaDatTruoc.setText(String.valueOf(ddt.getTienCoc()));
        
        dpBatDau.getModel().setDate(
                cal.get(Calendar.YEAR), 
                cal.get(Calendar.MONTH), 
                cal.get(Calendar.DATE));
        dpBatDau.getModel().setSelected(true);
        
        if (hd.getDanhSachCTHD_Ban().isEmpty())
        {
            hienThiCTDP(hd.getDanhSachCTHD_Phong());
            for (ChiTietHoaDon_Phong cthd : hd.getDanhSachCTHD_Phong())
            {
                for (Phong p : DanhSach.getDanhSachPhong())
                {
                    if (p.getMaPhong().equals(cthd.getPhong().getMaPhong()))
                    {
                        int pos = DanhSach.getDanhSachPhong().indexOf(p);
                        tbPhong.setRowSelectionInterval(pos, pos);
                        hienThiBan(new ArrayList<>());

                        if (hd.getDanhSachCTHD_Phong().size() == 1)
                        {
                            tbPhongMouseClicked(null);
                        }
                    }
                }
            }
        }
        else
        {
            hienThiCTDB(hd.getDanhSachCTHD_Ban());
            
            Phong temp = hd.getDanhSachCTHD_Ban().get(0).getBan().getPhong();
            int posi = DanhSach.getDanhSachPhong().indexOf(temp);
            tbPhong.setRowSelectionInterval(posi, posi);
            hienThiBan(new ArrayList<>());
            tbPhongMouseClicked(null);

            
            for (ChiTietHoaDon_Ban cthd : hd.getDanhSachCTHD_Ban())
            {
                for (Ban p : temp.getDanhSachBan())
                {
                    if (p.getMaBan() == cthd.getBan().getMaBan())
                    {
                        int pos = temp.getDanhSachBan().indexOf(p);
                        
                        tbBan.addRowSelectionInterval(pos, pos);

                        if (hd.getDanhSachCTHD_Ban().size() == 1)
                        {
                            tbBanMouseClicked(null);
                        }
                    }
                }
            }            
        }   
    }//GEN-LAST:event_tbDatTruocMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbDatTruoc.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa đơn đặt trước này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maHD = Integer.parseInt(netmDatTruoc.getValueAt(tbDatTruoc.getSelectedRow(), 0).toString());
                
                if (XuLyDatTruoc.xoa(maHD)) 
                {
                    hienThi();
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn đơn đặt trước cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbCTDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTDTMouseClicked
        if (netmDatTruoc.getColumnCount() == 3)
        {
            String maPhong = netmCTDT.getValueAt(tbCTDT.getSelectedRow(), 2).toString();
            int maBan = Integer.parseInt(netmCTDT.getValueAt(tbCTDT.getSelectedRow(), 1).toString());
            Ban b = XuLyBan.tim(maPhong, maBan);

            txtGiaDatTruoc.setText(String.valueOf(b.getGiaDatTruoc()));
        }
        else
        {
            String maPhong = netmCTDT.getValueAt(tbCTDT.getSelectedRow(), 1).toString();
            Phong b = XuLyPhong.tim(maPhong);

            txtGiaDatTruoc.setText(String.valueOf(b.getGiaDatTruoc()));
        }
    }//GEN-LAST:event_tbCTDTMouseClicked

    private void btnGopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGopActionPerformed
        List<HoaDon> dsHoaDon = new ArrayList<>();
                
        int pos = tbHoaDon.getSelectedRows()[0];
        
        for (int i : tbHoaDon.getSelectedRows())
        {
            int maHoaDon = Integer.parseInt(dtm.getValueAt(i, 0).toString());
            HoaDon b = XuLyHoaDon.tim(maHoaDon);
            List<HoaDon> temp = DanhSach.getDanhSachHD();
            dsHoaDon.add(b);
        }
        
        for (int i = 1; i < dsHoaDon.size(); i++)
        {
            XuLyCTHD_Ban.gopBan(dsHoaDon.get(0), dsHoaDon.get(i));
        }
        
        tbHoaDon.setRowSelectionInterval(pos, pos);
        tbHoaDonMouseClicked(null);
    }//GEN-LAST:event_btnGopActionPerformed

    private void btnChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenActionPerformed
        if (btnChuyen.getText().equals("Chuyển bàn") && tbHoaDon.getSelectedRow() >= 0)
        {
            btnChuyen.setText("Lưu");
            setButtonEditable(true);
            btnChuyen.setEnabled(true);
            tbHoaDon.setEnabled(false);
        }
        else if (tbBan.getSelectedRow() >= 0)
        {
            int maHD = Integer.parseInt(dtm.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
            String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
            int maBan = Integer.parseInt(netmBan.getValueAt(tbBan.getSelectedRow(), 0).toString());
            Ban b = XuLyBan.tim(maPhong, maBan);
            
            if (XuLyCTHD_Ban.chuyenBan(XuLyHoaDon.tim(maHD), b))
            {
                JOptionPane.showMessageDialog(rootPane, "Chuyển bàn thành công");
                hienThi();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Chuyển bàn thất bại");
            }

            btnChuyen.setText("Cập nhật");
            setButtonEditable(false);
            tbHoaDon.setEnabled(true);
        }
        else if (tbHoaDon.getSelectedRow() < 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hóa đơn cần chuyển");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn bàn cần chuyển");
        }
    }//GEN-LAST:event_btnChuyenActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int maHD = Integer.parseInt(dtm.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
        HoaDon hd = XuLyHoaDon.tim(maHD);
        hienThiCTDB(hd.getDanhSachCTHD_Ban());
        
        Phong temp = hd.getDanhSachCTHD_Ban().get(0).getBan().getPhong();
        int posi = DanhSach.getDanhSachPhong().indexOf(temp);
        tbPhong.setRowSelectionInterval(posi, posi);
        hienThiBan(new ArrayList<>());
        tbPhongMouseClicked(null);


        for (ChiTietHoaDon_Ban cthd : hd.getDanhSachCTHD_Ban())
        {
            for (Ban p : temp.getDanhSachBan())
            {
                if (p.getMaBan() == cthd.getBan().getMaBan())
                {
                    int pos = temp.getDanhSachBan().indexOf(p);

                    tbBan.addRowSelectionInterval(pos, pos);

                    if (hd.getDanhSachCTHD_Ban().size() == 1)
                    {
                        tbBanMouseClicked(null);
                    }
                }
            }
        }  
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiGianActionPerformed
        if(btnThoiGian.getText().equals("Cập nhật thời gian"))
        {
            btnThoiGian.setText("Lưu");
            setButtonEditable(true);
            btnThoiGian.setEnabled(true);
        }
        else if (tbDatTruoc.getSelectedRow() >= 0)
        {
            if (!isEmpty() && isValidValues())
            {
                int maHD = Integer.parseInt(netmDatTruoc.getValueAt(tbDatTruoc.getSelectedRow(), 0).toString());
                
                java.sql.Date ngay = new java.sql.Date(
                    dpBatDau.getModel().getYear() - 1900,
                    dpBatDau.getModel().getMonth() - 1,
                    dpBatDau.getModel().getDay() - 1);
                
                cal.setTime(ngay);               
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(txtGioBatDau.getText()));
                Timestamp bd = new Timestamp(cal.getTime().getTime());  

                cal.setTime(ngay);               
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(txtGioKetThuc.getText()));
                Timestamp kt = new Timestamp(cal.getTime().getTime());

                if (XuLyDatTruoc.suaGio(XuLyHoaDon.tim(maHD), bd, kt))
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thời gian thành công");
                    hienThi();
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thời gian thất bại");
                }

                btnThoiGian.setText("Cập nhật thời gian");
                setButtonEditable(false);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn đơn cần cập nhật");
        }
    }//GEN-LAST:event_btnThoiGianActionPerformed

    private void btnBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanActionPerformed
        if (btnBan.getText().equals("Cập nhật bàn"))
        {
            btnBan.setText("Lưu");
            setButtonEditable(true);
            btnBan.setEnabled(true);
        }
        else if (tbDatTruoc.getSelectedRow() >= 0 && tbBan.getSelectedRow() >= 0)
        {
            if (!isEmpty() && isValidValues())
            {
                int maHD = Integer.parseInt(netmDatTruoc.getValueAt(tbDatTruoc.getSelectedRow(), 0).toString());

                String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
                
                List<Ban> dsBan = new ArrayList<>();
                
                for (int i : tbBan.getSelectedRows())
                {
                    int maBan = Integer.parseInt(netmBan.getValueAt(i, 0).toString());
                    Ban b = XuLyBan.tim(maPhong, maBan);
                    dsBan.add(b);
                }
                
                if (XuLyDatTruoc.suaBan(XuLyHoaDon.tim(maHD), dsBan))
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật bàn thành công");
                    hienThi();
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật bàn thất bại");
                }

                btnBan.setText("Cập nhật bàn");
                setButtonEditable(false);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
            }
        }
        else
        {
            if (tbDatTruoc.getSelectedRow() >= 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn đơn cần cập nhật");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ít nhất 1 bàn");
            }
        }
    }//GEN-LAST:event_btnBanActionPerformed

    private void btnPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhongActionPerformed
        if (btnPhong.getText().equals("Cập nhật phòng"))
        {
            btnPhong.setText("Lưu");
            setButtonEditable(true);
            btnPhong.setEnabled(true);
        }
        else if (tbDatTruoc.getSelectedRow() >= 0 && tbBan.getSelectedRow() >= 0)
        {
            if (!isEmpty() && isValidValues())
            {
                int maHD = Integer.parseInt(netmDatTruoc.getValueAt(tbDatTruoc.getSelectedRow(), 0).toString());

                List<Phong> dsPhong = new ArrayList<>();
                
                for (int i : tbPhong.getSelectedRows())
                {
                    Phong p = XuLyPhong.tim(netmPhong.getValueAt(i, 0).toString());
                    dsPhong.add(p);
                }
                
                if (XuLyDatTruoc.suaPhong(XuLyHoaDon.tim(maHD), dsPhong))
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật phòng thành công");
                    hienThi();
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật phòng thất bại");
                }

                btnPhong.setText("Cập nhật phòng");
                setButtonEditable(false);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
            }
        }
        else
        {
            if (tbDatTruoc.getSelectedRow() >= 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn đơn cần cập nhật");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ít nhất 1 phòng");
            }
        }
    }//GEN-LAST:event_btnPhongActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBan;
    private javax.swing.JButton btnChuyen;
    private javax.swing.JButton btnDatTruoc;
    private javax.swing.JButton btnGop;
    private javax.swing.JButton btnPhong;
    private javax.swing.JButton btnThoiGian;
    private javax.swing.JButton btnXoa;
    private org.jdatepicker.JDatePicker dpBatDau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private java.awt.List list1;
    private javax.swing.JTable tbBan;
    private javax.swing.JTable tbCTDT;
    private javax.swing.JTable tbDatTruoc;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtGiaDatTruoc;
    private javax.swing.JTextField txtGioBatDau;
    private javax.swing.JTextField txtGioKetThuc;
    // End of variables declaration//GEN-END:variables
}
