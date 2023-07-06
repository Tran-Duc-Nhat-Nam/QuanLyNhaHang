package gui;

import static dao.XuLyCSDL.getThongBao;
import dao.XuLyNhanVien;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import pojo.ChucVu;
import static pojo.DanhSach.getDanhSachCV;
import static pojo.DanhSach.getDanhSachNV;
import pojo.NhanVien;
import static dao.XuLyNhanVien.*;
import java.awt.HeadlessException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.ListSelectionModel;
import pojo.DanhSach;

public class FormNhanVien extends ParentForm {
    DefaultComboBoxModel<ChucVu> dcmCV = new DefaultComboBoxModel<>();

    public FormNhanVien() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        tbNhanVien.setModel(dtm);
        tbNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cbxChucVu.setModel(dcmCV);
        
        hienThi();   
    }
    
    private void hienThi()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã nhân viên");
        tieuDe.add("Họ tên");
        tieuDe.add("Giới tính");
        tieuDe.add("Chức vụ");
        tieuDe.add("CCCD");
        tieuDe.add("SDT");
        tieuDe.add("Địa chỉ");
        tieuDe.add("Ngày sinh");
        tieuDe.add("Nơi sinh");
        tieuDe.add("Thời gian nhận việc");
        tieuDe.add("Thời gian thôi việc");
        tieuDe.add("Hệ số lương");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (NhanVien nv : getDanhSachNV())
        {
            Vector<Object> v = new Vector<>();
            v.add(nv.getMaNV());
            v.add(nv.getTenNV());
            v.add(nv.getGioiTinh());
            v.add(nv.getChucVu().getTenChucVu());
            v.add(nv.getCccd());
            v.add(nv.getSdt());
            v.add(nv.getDiaChi());
            v.add(nv.getNgaySinh());
            v.add(nv.getNoiSinh());
            v.add(nv.getThoiGianNhanVien());
            v.add(nv.getThoiGianThoiViec());
            v.add(nv.getHeSoLuong());
            dtm.addRow(v);
        }
        
        dcmCV.removeAllElements();
        
        for (ChucVu cv : getDanhSachCV())
        {    
            dcmCV.addElement(cv);
        }
        
        if (tbNhanVien.getSelectedRow() >= 0)
        {
            tbNhanVienMouseClicked(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnThoiViec = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNoiSinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        txtSDT = new javax.swing.JFormattedTextField();
        txtCCCD = new javax.swing.JFormattedTextField();
        txtHeSoLuong = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        cbxChucVu = new javax.swing.JComboBox<>();
        txtNgaySinh = new org.jdatepicker.JDatePicker();
        txtThoiGianNhanViec = new org.jdatepicker.JDatePicker();
        txtThoiGianThoiViec = new org.jdatepicker.JDatePicker();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách nhân viên"));

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNhanVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(295, 396));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnThoiViec.setText("Thôi việc ");
        btnThoiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiViecActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nhập từ khóa cần tìm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoiViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnThoiViec)
                .addGap(47, 47, 47)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem)
                .addGap(28, 28, 28))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Họ Tên");

        txtHoTen.setEditable(false);

        jLabel3.setText("Giới tính");

        jLabel4.setText("CCCD");

        jLabel5.setText("SDT");

        txtDiaChi.setEditable(false);

        jLabel7.setText("Ngày Sinh");

        jLabel8.setText("Nơi sinh");
        jLabel8.setToolTipText("");

        txtNoiSinh.setEditable(false);

        jLabel9.setText("Địa chỉ");

        jLabel10.setText("Thời gian nhận");

        jLabel11.setText("Thời gian thôi việc");

        jLabel12.setText("Hệ số lương");

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtSDT.setEditable(false);
        txtSDT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtCCCD.setEditable(false);
        txtCCCD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtHeSoLuong.setEditable(false);

        jLabel1.setText("Chức vụ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen)
                    .addComponent(cbxGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCCCD)
                    .addComponent(txtSDT)
                    .addComponent(txtDiaChi)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(txtNoiSinh)
                    .addComponent(txtThoiGianNhanViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtThoiGianThoiViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHeSoLuong)
                    .addComponent(cbxChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtThoiGianNhanViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtThoiGianThoiViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEmpty()
    {
        return txtHoTen.getText().isEmpty() || txtCCCD.getText().isEmpty()
            || txtDiaChi.getText().isEmpty() || txtHeSoLuong.getText().isEmpty() 
                || txtNoiSinh.getText().isEmpty() || txtSDT.getText().isEmpty();
    }
    
    
    private boolean isValidValues()
    {
        try {
            float hsl = Float.parseFloat(txtHeSoLuong.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtHoTen.setEditable(value);
        txtCCCD.setEditable(value);
        txtDiaChi.setEditable(value);
        txtHeSoLuong.setEditable(value);
        txtNoiSinh.setEditable(value);
        txtSDT.setEditable(value);
        cbxChucVu.setEnabled(value);
        cbxGioiTinh.setEnabled(value);
        txtNgaySinh.setEnabled(value);
        txtThoiGianNhanViec.setEnabled(value);
        txtThoiGianThoiViec.setEnabled(value);
        
        btnThem.setEnabled(!value);
        btnCapNhat.setEnabled(!value);
        btnXoa.setEnabled(!value);
        btnThoiViec.setEnabled(!value);
        btnTimKiem.setEnabled(!value);
    }
    
    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        int position = tbNhanVien.getSelectedRow();
        NhanVien nv = getDanhSachNV().get(position);
        cbxChucVu.setSelectedItem(nv.getChucVu());
        cbxGioiTinh.setSelectedItem(nv.getGioiTinh());
        txtHoTen.setText(nv.getTenNV());
        txtDiaChi.setText(nv.getDiaChi());
        txtNoiSinh.setText(nv.getNoiSinh());
        txtCCCD.setText(nv.getCccd());
        txtSDT.setText(nv.getSdt());
        txtHeSoLuong.setText(String.valueOf(nv.getHeSoLuong()));

        
        Calendar cal = Calendar.getInstance();
        
        cal.setTimeInMillis(nv.getNgaySinh().getTime());        
        txtNgaySinh.getModel().setDate(
                cal.get(Calendar.YEAR), 
                cal.get(Calendar.MONTH), 
                cal.get(Calendar.DATE));
        txtNgaySinh.getModel().setSelected(true);
        
        cal.setTimeInMillis(nv.getThoiGianNhanVien().getTime());   
        txtThoiGianNhanViec.getModel().setDate(
                cal.get(Calendar.YEAR), 
                cal.get(Calendar.MONTH), 
                cal.get(Calendar.DATE));
        txtThoiGianNhanViec.getModel().setSelected(true);
        
        if (nv.getThoiGianThoiViec() != null)
        {
            cal.setTimeInMillis(nv.getThoiGianNhanVien().getTime());   
            txtThoiGianThoiViec.getModel().setDate(
                cal.get(Calendar.YEAR), 
                cal.get(Calendar.MONTH), 
                cal.get(Calendar.DATE));
            txtThoiGianThoiViec.getModel().setSelected(true);
        }
        
        btnThem.setText("Thêm");
        btnCapNhat.setText("Cập nhật");
        setButtonEditable(false);
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        List<NhanVien> dsNhanVien = XuLyNhanVien.tim(txtTimKiem.getText());

        dtm.setRowCount(0);

        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã nhân viên");
        tieuDe.add("Họ tên");
        tieuDe.add("Giới tính");
        tieuDe.add("Chức vụ");
        tieuDe.add("CCCD");
        tieuDe.add("SDT");
        tieuDe.add("Địa chỉ");
        tieuDe.add("Ngày sinh");
        tieuDe.add("Nơi sinh");
        tieuDe.add("Thời gian nhận việc");
        tieuDe.add("Thời gian thôi việc");
        tieuDe.add("Hệ số lương");
        dtm.setColumnIdentifiers(tieuDe);

        for (NhanVien nv : dsNhanVien)
        {
            Vector<Object> v = new Vector<>();
            v.add(nv.getMaNV());
            v.add(nv.getTenNV());
            v.add(nv.getGioiTinh());
            v.add(nv.getChucVu().getTenChucVu());
            v.add(nv.getCccd());
            v.add(nv.getSdt());
            v.add(nv.getDiaChi());
            v.add(nv.getNgaySinh());
            v.add(nv.getNoiSinh());
            v.add(nv.getThoiGianNhanVien());
            v.add(nv.getThoiGianThoiViec());
            v.add(nv.getHeSoLuong());
            dtm.addRow(v);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbNhanVien.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có muốn xóa nhân viên này và những thông tin liên quan?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

            if (kq == JOptionPane.YES_OPTION)
            {
                int maNV = getDanhSachNV().get(
                    tbNhanVien.getSelectedRow()).getMaNV();
                if (xoa(maNV))
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin nhân viên cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiViecActionPerformed
        if (tbNhanVien.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có muốn cho thôi việc nhân viên này hay không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

            if (kq == JOptionPane.YES_OPTION)
            {
                int maNV = getDanhSachNV().get(
                    tbNhanVien.getSelectedRow()).getMaNV();
                if (thoiViec(maNV))
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin nhân viên cần cho thôi việc");
        }
    }//GEN-LAST:event_btnThoiViecActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(btnCapNhat.getText().equals("Cập nhật"))
        {
            btnCapNhat.setText("Lưu");
            setButtonEditable(true);
            btnCapNhat.setEnabled(true);
        }
        else if (!isEmpty() && isValidValues())
        {
            try {
                int ma = DanhSach.getDanhSachNV().get(tbNhanVien.getSelectedRow()).getMaNV();
                String ten = txtHoTen.getText();
                String cccd = txtCCCD.getText();
                String dc = txtDiaChi.getText();
                String ns = txtNoiSinh.getText();
                String sdt = txtSDT.getText();
                ChucVu cv = (ChucVu) cbxChucVu.getSelectedItem();
                String gt = (String) cbxGioiTinh.getSelectedItem();
                java.sql.Date ngs = new java.sql.Date(
                    txtNgaySinh.getModel().getYear() - 1900,
                    txtNgaySinh.getModel().getMonth() - 1,
                    txtNgaySinh.getModel().getDay() - 1);
                java.sql.Date tgnv = new java.sql.Date(
                    txtThoiGianNhanViec.getModel().getYear() - 1900,
                    txtThoiGianNhanViec.getModel().getMonth() - 1,
                    txtThoiGianNhanViec.getModel().getDay() - 1);

                java.sql.Date tgtv = null;

                if (txtThoiGianThoiViec.getModel().isSelected())
                {
                    tgtv = new java.sql.Date(
                        txtThoiGianThoiViec.getModel().getYear() - 1900,
                        txtThoiGianThoiViec.getModel().getMonth() - 1,
                        txtThoiGianThoiViec.getModel().getDay() - 1);
                }

                float hsl = NumberFormat.getInstance(Locale.getDefault())
                .parse(txtHeSoLuong.getText()).floatValue();

                if (sua(ma, ten, gt, cccd, ns, dc, sdt, hsl, ngs, tgnv, tgtv, cv))
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
                btnCapNhat.setText("Cập nhật");
                setButtonEditable(false);
            } catch (HeadlessException | NumberFormatException | ParseException ex) {
                System.out.println(ex);
            }
        }
        else
        {
            if (isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin món ăn");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Hệ số lương phải là số");
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm"))
        {
            tbNhanVien.clearSelection();
            txtHoTen.setText("");
            txtCCCD.setText("");
            txtDiaChi.setText("");
            txtHeSoLuong.setText("");
            txtNoiSinh.setText("");
            txtSDT.setText("");

            setButtonEditable(true);
            btnThem.setText("Lưu");
            btnThem.setEnabled(true);
        }
        else if (!isEmpty() && isValidValues())
        {
            try {

                String ten = txtHoTen.getText();
                String cccd = txtCCCD.getText();
                String dc = txtDiaChi.getText();
                String ns = txtNoiSinh.getText();
                String sdt = txtSDT.getText();
                ChucVu cv = (ChucVu) cbxChucVu.getSelectedItem();
                String gt = (String) cbxGioiTinh.getSelectedItem();

                java.sql.Date ngs = new java.sql.Date(
                    txtNgaySinh.getModel().getYear() - 1900,
                    txtNgaySinh.getModel().getMonth() - 1,
                    txtNgaySinh.getModel().getDay() - 1);
                java.sql.Date tgnv = new java.sql.Date(
                    txtThoiGianNhanViec.getModel().getYear() - 1900,
                    txtThoiGianNhanViec.getModel().getMonth() - 1,
                    txtThoiGianNhanViec.getModel().getDay() - 1);

                float hsl = Float.parseFloat(txtHeSoLuong.getText());

                if (them(ten, gt, cccd, ns, dc, sdt, hsl, ngs, tgnv, cv))
                {
                    hienThi();
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
                btnThem.setText("Thêm");
                setButtonEditable(false);
            } catch (HeadlessException | NumberFormatException ex) {
                System.out.println(ex);
            }
        }
        else
        {
            if (isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin món ăn");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Hệ số lương phải là số");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoiViec;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<ChucVu> cbxChucVu;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JFormattedTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JFormattedTextField txtHeSoLuong;
    private javax.swing.JTextField txtHoTen;
    private org.jdatepicker.JDatePicker txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JFormattedTextField txtSDT;
    private org.jdatepicker.JDatePicker txtThoiGianNhanViec;
    private org.jdatepicker.JDatePicker txtThoiGianThoiViec;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
