package gui;

import dao.XuLyCSDL;
import dao.XuLyCTHD;
import dao.XuLyHoaDon;
import java.awt.HeadlessException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import pojo.Ban;
import pojo.ChiTietHoaDon;
import pojo.DanhSach;
import pojo.DonDatTruoc;
import pojo.HoaDon;
import pojo.MonAn;
import pojo.Phong;
import pojo.Tang;

public class FormGoiMon extends ParentForm {
    NonEditableTableModel dtmMA = new NonEditableTableModel();
    NonEditableTableModel dtmCTHD = new NonEditableTableModel();
    DefaultComboBoxModel<Ban> dcmBan = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<Phong> dcmPhong = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<Tang> dcmTang = new DefaultComboBoxModel<>();

    public FormGoiMon() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        tbHoaDon.setModel(dtm);
        tbHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbCTHD.setModel(dtmCTHD);
        tbCTHD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMonAn.setModel(dtmMA);
        tbMonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cbxBan.setModel(dcmBan);
        cbxPhong.setModel(dcmPhong);
        cbxTang.setModel(dcmTang);
        
        hienThi();
        hienThiMonAn();
    }
    
    private void hienThi()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã hóa đơn");
        tieuDe.add("Nhân viên lập");
        tieuDe.add("Thời gian lập");
        tieuDe.add("Tổng tiền (VND)");
        tieuDe.add("Tình trạng");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (HoaDon cv : DanhSach.getDanhSachHD())
        {
            if (!cv.isTinhTrangThanhToan() && cv.getDonDatTruoc() == null)
            {
                Vector<Object> v = new Vector<>();
                v.add(cv.getMaHD());
                v.add(cv.getNhanVien().getTenNV());
                v.add(cv.getThoiGianLap());
                v.add(cv.getTongTien());
                v.add( cv.isTinhTrangThanhToan()? "Đã thanh toán" : "Chưa thanh toán");
                dtm.addRow(v);
            }
        }          
        
        if (dtm.getRowCount() > 0)
        {
            tbHoaDon.setRowSelectionInterval(0, 0);
            tbHoaDonMouseClicked(null);
        }
        else
        {
            hienThiCTHD(new ArrayList<>());         
        }
        
        hienThiTang();
    }
    
    private void hienThiTang()
    {
        for (Tang b : DanhSach.getDanhSachTang())
        {
            dcmTang.addElement(b);
        }
        
        if (dcmTang.getSize() > 1)
        {
            cbxTang.setSelectedIndex(0);
        }
    }
    
    private void hienThiCTHD(List<ChiTietHoaDon> danhSachCTHD)
    {
        dtmCTHD.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên món ăn");
        tieuDe.add("Số lượng");
        dtmCTHD.setColumnIdentifiers(tieuDe);
        
        for (ChiTietHoaDon cthd : danhSachCTHD)
        {
            Vector<Object> v = new Vector<>();
            v.add(cthd.getMonAn().getTenMA());
            v.add(cthd.getSoLuong());
            dtmCTHD.addRow(v);
        }
    }
    
    private void hienThiMonAn()
    {
        dtmMA.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên món ăn");
        tieuDe.add("Đơn vị tính");
        tieuDe.add("Đơn giá");
        dtmMA.setColumnIdentifiers(tieuDe);
        
        for (MonAn ma : DanhSach.getDanhSachMA())
        {
            Vector<Object> v = new Vector<>();
            v.add(ma.getTenMA());
            v.add(ma.getDonViTinh());
            v.add(ma.getDonGia());
            dtmMA.addRow(v);
        }
    }
    
    private boolean isEmpty()
    {
        return txtSoLuong.getText().isEmpty();
    }
    
    private boolean isValidValues()
    {
        try {
            int f = Integer.parseInt(txtSoLuong.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtSoLuong.setEditable(value);
        
        btnCapNhatSoBan.setEnabled(!value);
        btnCapNhatSoLuong.setEnabled(!value);
        btnGoiMon.setEnabled(!value);
        btnTaoHoaDon.setEnabled(!value);
        btnThanhToan.setEnabled(!value);
        btnXemHoaDon.setEnabled(!value);
        btnXoaHoaDon.setEnabled(!value);
        btnXoaMon.setEnabled(!value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JFormattedTextField();
        txtMaHoaDon = new javax.swing.JFormattedTextField();
        txtThanhTien = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnXoaHoaDon = new javax.swing.JButton();
        btnXemHoaDon = new javax.swing.JButton();
        btnCapNhatSoLuong = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxBan = new javax.swing.JComboBox<>();
        btnGoiMon = new javax.swing.JButton();
        btnXoaMon = new javax.swing.JButton();
        cbxPhong = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxTang = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnCapNhatSoBan = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách hoá đơn"));
        jPanel1.setPreferredSize(new java.awt.Dimension(424, 300));

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
        jScrollPane2.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách món đã gọi"));
        jPanel2.setPreferredSize(new java.awt.Dimension(424, 300));

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCTHD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách món ăn"));
        jPanel3.setPreferredSize(new java.awt.Dimension(424, 300));

        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbMonAn);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hoá đơn hiện tại"));
        jPanel4.setPreferredSize(new java.awt.Dimension(424, 300));

        jLabel1.setText("Mã hoá đơn");

        jLabel4.setText("Thành tiền");

        jLabel2.setText("Thời gian lập");

        txtThoiGian.setEditable(false);
        txtThoiGian.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss"))));

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        txtThanhTien.setEditable(false);
        txtThanhTien.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtThoiGian)
                    .addComponent(txtMaHoaDon)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(394, 70));

        btnTaoHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setPreferredSize(new java.awt.Dimension(97, 35));
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnXoaHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btnXoaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaHoaDon.setText("Xoá hoá đơn");
        btnXoaHoaDon.setToolTipText("");
        btnXoaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHoaDonActionPerformed(evt);
            }
        });

        btnXemHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btnXemHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXemHoaDon.setText("Xem toàn bộ hóa đơn");
        btnXemHoaDon.setPreferredSize(new java.awt.Dimension(76, 35));
        btnXemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemHoaDonActionPerformed(evt);
            }
        });

        btnCapNhatSoLuong.setBackground(new java.awt.Color(204, 255, 204));
        btnCapNhatSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhatSoLuong.setText("Cập nhật sô lượng món");
        btnCapNhatSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSoLuongActionPerformed(evt);
            }
        });

        jLabel3.setText("Số lượng ");

        btnThanhToan.setBackground(new java.awt.Color(204, 255, 204));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel5.setText("Bàn");

        btnGoiMon.setBackground(new java.awt.Color(204, 255, 204));
        btnGoiMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGoiMon.setText("Gọi món");
        btnGoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoiMonActionPerformed(evt);
            }
        });

        btnXoaMon.setBackground(new java.awt.Color(204, 255, 204));
        btnXoaMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaMon.setText("Xóa món");
        btnXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonActionPerformed(evt);
            }
        });

        cbxPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPhongItemStateChanged(evt);
            }
        });
        cbxPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPhongActionPerformed(evt);
            }
        });

        jLabel6.setText("Phòng");

        cbxTang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTangItemStateChanged(evt);
            }
        });
        cbxTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTangActionPerformed(evt);
            }
        });

        jLabel7.setText("Tầng");

        btnCapNhatSoBan.setBackground(new java.awt.Color(204, 255, 204));
        btnCapNhatSoBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhatSoBan.setText("Quản lý hóa đơn");
        btnCapNhatSoBan.setPreferredSize(new java.awt.Dimension(76, 35));
        btnCapNhatSoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSoBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnXemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(33, 33, 33)
                            .addComponent(cbxBan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnCapNhatSoBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(cbxTang, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbxPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong))
                    .addComponent(btnGoiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCapNhatSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhatSoBan, btnXemHoaDon});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnXoaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnGoiMon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCapNhatSoLuong))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaMon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(btnCapNhatSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        HoaDon hd = DanhSach.getDanhSachHD().get(tbHoaDon.getSelectedRow());
        hienThiCTHD(hd.getDanhSachCTHD());
        txtMaHoaDon.setText(String.valueOf(hd.getMaHD()));
        txtThanhTien.setText(String.valueOf(hd.getTongTien()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        txtThoiGian.setText(sdf.format(hd.getThoiGianLap()));
        txtSoLuong.setText("");
        
        Ban b = hd.getDanhSachCTHD_Ban().get(0).getBan();
        
        cbxTang.setSelectedItem(b.getPhong().getTang());
        cbxPhong.setSelectedItem(b.getPhong());
        cbxBan.setSelectedItem(b);
        
        btnGoiMon.setText("Gọi món");
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        if (btnTaoHoaDon.getText().equals("Tạo hóa đơn"))
        {
            btnTaoHoaDon.setText("Thêm"); 
            setButtonEditable(true);
            btnTaoHoaDon.setEnabled(true);
        }
        else if (cbxBan.getSelectedItem() != null)
        {
            try {
            tbHoaDon.clearSelection();
            tbCTHD.clearSelection();
            tbMonAn.clearSelection();
            
            Ban b = (Ban) cbxBan.getSelectedItem();
            
            if (XuLyHoaDon.them(XuLyCSDL.getNhanVien(), 
                    Timestamp.valueOf(LocalDateTime.now()), b))
            {
                hienThi();
            }

            JOptionPane.showMessageDialog(rootPane, XuLyCSDL.getThongBao());
            
            } catch (HeadlessException | NumberFormatException ex) {
                System.out.println(ex);
            }
            
            btnTaoHoaDon.setText("Tạo hóa đơn");
            setButtonEditable(false);
        }
        else
        {
            setButtonEditable(false);
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn số bàn");
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnXoaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHoaDonActionPerformed
        if (tbHoaDon.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa hóa đơn này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maHD = Integer.parseInt(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
                
                if (XuLyHoaDon.xoa(maHD)) 
                {
                    hienThi();
                }
                
                JOptionPane.showMessageDialog(rootPane, XuLyCSDL.getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hóa đơn cần xóa");
        }
    }//GEN-LAST:event_btnXoaHoaDonActionPerformed

    private void btnCapNhatSoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSoBanActionPerformed
        new FormDatTruoc();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCapNhatSoBanActionPerformed

    private void btnXemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemHoaDonActionPerformed
        new FormHoaDon();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnXemHoaDonActionPerformed

    private void btnCapNhatSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSoLuongActionPerformed
        if (tbCTHD.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn thay đổi số lượng gọi món này không?",
                "Xác nhận thay đổi",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                if (!isEmpty() && isValidValues())
                {
                    int maHD = Integer.parseInt(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
                    HoaDon hd = XuLyHoaDon.tim(maHD);                
                    ChiTietHoaDon cthd = hd.getDanhSachCTHD().get(tbCTHD.getSelectedRow());
                    int sl = Integer.parseInt(txtSoLuong.getText());

                    if (XuLyCTHD.sua(cthd.getMonAn(), hd, sl)) 
                    {
                        hienThi();
                    }

                    JOptionPane.showMessageDialog(rootPane, XuLyCSDL.getThongBao());
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số lượng");
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin gọi món cần cập nhật");
        }
    }//GEN-LAST:event_btnCapNhatSoLuongActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (tbHoaDon.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn thanh toán hóa đơn này không?",
                "Xác nhận thanh toán",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maHD = Integer.parseInt(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
                HoaDon hd = XuLyHoaDon.tim(maHD);              

                if (XuLyHoaDon.thanhToan(hd.getMaHD())) 
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, XuLyCSDL.getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin gọi món cần xóa");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnGoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoiMonActionPerformed
        if (tbHoaDon.getSelectedRow() >= 0 && tbMonAn.getSelectedRow() >= 0)
        {
            if (!isEmpty() && isValidValues())
            {
                int maHD = Integer.parseInt(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
                HoaDon hd = XuLyHoaDon.tim(maHD); 
                MonAn ma = DanhSach.getDanhSachMA().get(tbMonAn.getSelectedRow());
                int soLuong = Integer.parseInt(txtSoLuong.getText());

                if (XuLyCTHD.them(ma, hd, soLuong)) 
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, XuLyCSDL.getThongBao());
            }
            else 
            {
                if (isEmpty())
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng điền số lượng");
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số nguyên");
                }
            }
        }
        else 
        {
            if (tbHoaDon.getSelectedRow() < 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hóa dơn");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn món ăn");
            }
        }
    }//GEN-LAST:event_btnGoiMonActionPerformed

    private void tbCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTHDMouseClicked
        int maHD = Integer.parseInt(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
        HoaDon hd = XuLyHoaDon.tim(maHD);                 
        ChiTietHoaDon cthd = hd.getDanhSachCTHD().get(tbCTHD.getSelectedRow());
        
        txtSoLuong.setText(String.valueOf(cthd.getSoLuong()));
    }//GEN-LAST:event_tbCTHDMouseClicked

    private void btnXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonActionPerformed
        if (tbCTHD.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa thông tin gọi món này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maHD = Integer.parseInt(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
                HoaDon hd = XuLyHoaDon.tim(maHD);               
                ChiTietHoaDon cthd = hd.getDanhSachCTHD().get(tbCTHD.getSelectedRow());

                if (XuLyCTHD.xoa(cthd.getMonAn(), hd)) 
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, XuLyCSDL.getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin gọi món cần xóa");
        }
    }//GEN-LAST:event_btnXoaMonActionPerformed

    private void cbxTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTangActionPerformed
        
    }//GEN-LAST:event_cbxTangActionPerformed

    private void cbxPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPhongActionPerformed
        
    }//GEN-LAST:event_cbxPhongActionPerformed

    private void cbxTangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTangItemStateChanged
        Tang t = (Tang) dcmTang.getSelectedItem();
        
        if (t != null)
        {
            System.out.println(evt.getItem().toString());
        
            dcmPhong.removeAllElements();
            dcmBan.removeAllElements();

            for (Phong p : t.getDanhSachPhong())
            {
                dcmPhong.addElement(p);
            }

            if (dcmPhong.getSize() > 0)
            {
                cbxPhong.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_cbxTangItemStateChanged

    private void cbxPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPhongItemStateChanged
        Phong p = (Phong) dcmPhong.getSelectedItem();
        
        if (p != null)
        {
            dcmBan.removeAllElements();
        
            for (Ban b : p.getDanhSachBan())
            {
                dcmBan.addElement(b);
            }
        }
    }//GEN-LAST:event_cbxPhongItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatSoBan;
    private javax.swing.JButton btnCapNhatSoLuong;
    private javax.swing.JButton btnGoiMon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXemHoaDon;
    private javax.swing.JButton btnXoaHoaDon;
    private javax.swing.JButton btnXoaMon;
    private javax.swing.JComboBox<Ban> cbxBan;
    private javax.swing.JComboBox<Phong> cbxPhong;
    private javax.swing.JComboBox<Tang> cbxTang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JFormattedTextField txtMaHoaDon;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JFormattedTextField txtThanhTien;
    private javax.swing.JFormattedTextField txtThoiGian;
    // End of variables declaration//GEN-END:variables

    
}
