package gui;

import static dao.XuLyCSDL.getThongBao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import pojo.CheBien;
import static pojo.DanhSach.getDanhSachVT;
import pojo.VatTu;
import static dao.XuLyVatTu.them;
import static dao.XuLyVatTu.sua;
import static dao.XuLyVatTu.xoa;
import javax.swing.ListSelectionModel;

public class FormVatTu extends ParentForm {
    NonEditableTableModel dtmCB = new NonEditableTableModel();
    
    public FormVatTu() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        tbVatTu.setModel(dtm);
        tbVatTu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbCheBien.setModel(dtmCB);
        tbVatTu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hienThi();
    }
    
    private void hienThi()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên vật tư");
        tieuDe.add("Nguồn gốc");
        tieuDe.add("Số lượng");
        tieuDe.add("Đơn vị tính");
        tieuDe.add("Đơn giá");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (VatTu vt : getDanhSachVT())
        {
            Vector<Object> v = new Vector<>();
            v.add(vt.getTenVT());
            v.add(vt.getNguonGoc());
            v.add(vt.getSoLuong());
            v.add(vt.getDonViTinh());
            v.add(vt.getDonGia());
            dtm.addRow(v);
        }
        
        if (tbVatTu.getSelectedRow() >= 0)
        {
            tbVatTuMouseClicked(null);
        }
        else
        {
            hienThiCheBien(new ArrayList<>());
        }
        
    }
    
    private void hienThiCheBien(List<CheBien> danhSachCB)
    {
        dtmCB.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên món ăn");
        tieuDe.add("Số lượng tiêu thụ");
        dtmCB.setColumnIdentifiers(tieuDe);
        
        for (CheBien cb : danhSachCB)
        {
            Vector<Object> v = new Vector<>();
            v.add(cb.getMonAn().getTenMA());
            v.add(cb.getSoLuongTieuThu());
            dtmCB.addRow(v);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVatTu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCheBien = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenVT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        l = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNguonGoc = new javax.swing.JTextField();
        txtDonViTinh = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JFormattedTextField();
        txtDonGia = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách vật tư"));

        tbVatTu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbVatTu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVatTuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVatTu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin tiêu thụ vật tư"));

        tbCheBien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbCheBien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin vật tư"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên vật tư");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng");

        txtTenVT.setEditable(false);

        btnThem.setBackground(new java.awt.Color(204, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(204, 255, 204));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 255, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Đơn giá");
        jLabel3.setToolTipText("");

        l.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        l.setText("Nguồn gốc");
        l.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Đơn vị tính");

        txtNguonGoc.setEditable(false);
        txtNguonGoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNguonGocActionPerformed(evt);
            }
        });

        txtDonViTinh.setEditable(false);

        txtSoLuong.setEditable(false);

        txtDonGia.setEditable(false);
        txtDonGia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnThem)
                        .addGap(19, 19, 19)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(l, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenVT)
                            .addComponent(txtNguonGoc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonViTinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l)
                    .addComponent(txtNguonGoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEmpty()
    {
        return txtTenVT.getText().isEmpty() || txtNguonGoc.getText().isEmpty()
            || txtDonGia.getText().isEmpty() || txtDonViTinh.getText().isEmpty() 
                || txtSoLuong .getText().isEmpty();
    }
    
    private boolean isValidDG()
    {
        try {
            int f = Integer.parseInt(txtDonGia.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    private boolean isValidSL()
    {
        try {
            float f = Float.parseFloat(txtSoLuong.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtTenVT.setEditable(value);
        txtDonGia.setEditable(value);
        txtDonViTinh.setEditable(value);
        txtNguonGoc.setEditable(value);
        txtSoLuong.setEditable(value);
        
        btnCapNhat.setEnabled(!value);
        btnThem.setEnabled(!value);
        btnXoa.setEnabled(!value);
    }
    
    private void tbVatTuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVatTuMouseClicked
        VatTu vt = getDanhSachVT().get(tbVatTu.getSelectedRow());
        hienThiCheBien(vt.getDanhSachCheBien());
        txtTenVT.setText(vt.getTenVT());
        txtSoLuong.setText(String.valueOf(vt.getSoLuong()));
        txtNguonGoc.setText(vt.getNguonGoc());
        txtDonGia.setText(String.valueOf(vt.getDonGia()));
        txtDonViTinh.setText(vt.getDonViTinh());
        btnThem.setText("Thêm");
        btnCapNhat.setText("Cập nhật");
        setButtonEditable(false);
    }//GEN-LAST:event_tbVatTuMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm"))
        {
            tbVatTu.clearSelection();
            hienThiCheBien(new ArrayList<>());
            txtTenVT.setText("");
            txtSoLuong.setText("0");
            txtNguonGoc.setText("");
            txtDonGia.setText("");
            txtDonViTinh.setText("");
            btnThem.setText("Lưu");
            setButtonEditable(true);  
            btnThem.setEnabled(true);
            txtSoLuong.setEditable(false);
        }
        else if (!isEmpty() && isValidDG())
        {
            int donGia = Integer.parseInt(txtDonGia.getText());
            String tenVT = txtTenVT.getText();
            String nguonGoc = txtNguonGoc.getText();
            String donViTinh = txtDonViTinh.getText();
            
            if (them(tenVT, nguonGoc, donGia, donViTinh))
            {
                hienThi();
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnThem.setText("Thêm");
            setButtonEditable(false);
        }
        else
        {
            if (isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin món ăn");
            }
            else if (!isValidDG())
            {
                JOptionPane.showMessageDialog(rootPane, "Đơn giá phải là số nguyên dương");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(btnCapNhat.getText().equals("Cập nhật"))
        {
            btnCapNhat.setText("Lưu");
            setButtonEditable(true);
            btnCapNhat.setEnabled(true);
        }
        else if (!isEmpty() && isValidDG() && isValidSL())
        {
            int maVT = getDanhSachVT().get(tbVatTu.getSelectedRow()).getMaVT();
            int donGia = Integer.parseInt(txtDonGia.getText());
            float soLuong = Float.parseFloat(txtSoLuong.getText());
            String tenVT = txtTenVT.getText();
            String nguonGoc = txtDonViTinh.getText();
            String donViTinh = txtDonViTinh.getText();
            
            if (sua(maVT, tenVT, nguonGoc, soLuong, donGia, donViTinh))
            {
                hienThi();
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnCapNhat.setText("Cập nhật");
            setButtonEditable(false);
        }
        else
        {
            if (isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin món ăn");
            }
            else if (!isValidDG())
            {
                JOptionPane.showMessageDialog(rootPane, "Đơn giá phải là số nguyên dương");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số");
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbVatTu.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa vật tư này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maVT = getDanhSachVT().get(
                        tbVatTu.getSelectedRow()).getMaVT();
                if (xoa(maVT)) 
                {
                    hienThi();
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn vật tư cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtNguonGocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNguonGocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNguonGocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l;
    private javax.swing.JTable tbCheBien;
    private javax.swing.JTable tbVatTu;
    private javax.swing.JFormattedTextField txtDonGia;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtNguonGoc;
    private javax.swing.JFormattedTextField txtSoLuong;
    private javax.swing.JTextField txtTenVT;
    // End of variables declaration//GEN-END:variables
}
