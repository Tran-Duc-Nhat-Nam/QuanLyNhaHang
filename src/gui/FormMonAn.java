package gui;

import static dao.XuLyCSDL.getThongBao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import pojo.CheBien;
import static pojo.DanhSach.getDanhSachMA;
import pojo.MonAn;
import static dao.XuLyMonAn.them;
import static dao.XuLyMonAn.sua;
import static dao.XuLyMonAn.xoa;
import javax.swing.ListSelectionModel;

public class FormMonAn extends ParentForm {
    NonEditableTableModel dtmCB = new NonEditableTableModel();

    public FormMonAn() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setVisible(true);
        
        tbMonAn.setModel(dtm);
        tbMonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbCheBien.setModel(dtmCB);
        tbCheBien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hienThi();
    }
    
    private void hienThi()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã món ăn");
        tieuDe.add("Tên món ăn");
        tieuDe.add("Đơn vị tính");
        tieuDe.add("Đơn giá");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (MonAn ma : getDanhSachMA())
        {
            Vector<Object> v = new Vector<>();
            v.add(ma.getMaMA());
            v.add(ma.getTenMA());
            v.add(ma.getDonViTinh());
            v.add(ma.getDonGia());
            dtm.addRow(v);
        }
        
        if (dtm.getRowCount() > 0)
        {
            tbMonAn.setRowSelectionInterval(0, 0);
            tbMonAnMouseClicked(null);
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
        tieuDe.add("Tên vật tư");
        tieuDe.add("Tên món ăn");
        tieuDe.add("Số lượng tiêu thụ");
        dtmCB.setColumnIdentifiers(tieuDe);
        
        for (CheBien cb : danhSachCB)
        {
            Vector<Object> v = new Vector<>();
            v.add(cb.getVatTu().getTenVT());
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
        tbMonAn = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCheBien = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenMonAn = new javax.swing.JTextField();
        txtDonVi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách món ăn"));

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
        tbMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMonAn);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vật tư cần thiết\n"));

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin món ăn"));

        jLabel1.setText("Tên món ăn");

        jLabel2.setText("Đơn vị");

        txtTenMonAn.setEditable(false);

        txtDonVi.setEditable(false);

        btnThem.setBackground(new java.awt.Color(204, 255, 204));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(204, 255, 204));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 255, 204));
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel3.setText("Đơn giá");

        txtDonGia.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(26, 26, 26)
                        .addComponent(btnCapNhat)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDonVi)
                                .addComponent(txtTenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEmpty()
    {
        return txtTenMonAn.getText().isEmpty() ||
            txtDonGia.getText().isEmpty() || txtDonVi.getText().isEmpty();
    }
    
    private boolean isValidValues()
    {
        try {
            int f = Integer.parseInt(txtDonGia.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtTenMonAn.setEditable(value);
        txtDonGia.setEditable(value);
        txtDonVi.setEditable(value);
        
        btnCapNhat.setEnabled(!value);
        btnThem.setEnabled(!value);
        btnXoa.setEnabled(!value);
    }
    
    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked
        int position = tbMonAn.getSelectedRow();
        MonAn ma = getDanhSachMA().get(position);
        hienThiCheBien(ma.getDanhSachCB());
        
        txtTenMonAn.setText(ma.getTenMA());
        txtDonVi.setText(ma.getDonViTinh());
        txtDonGia.setText(String.valueOf(ma.getDonGia()));
        
        btnThem.setText("Thêm");
        btnCapNhat.setText("Cập nhật");
        setButtonEditable(false);
    }//GEN-LAST:event_tbMonAnMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm"))
        {
            tbMonAn.clearSelection();
            hienThiCheBien(new ArrayList<>());
            txtTenMonAn.setText("");
            txtDonGia.setText("");
            txtDonVi.setText("");
            btnThem.setText("Lưu");
            setButtonEditable(true);
            btnThem.setEnabled(true);
        }
        else if (!isEmpty() && isValidValues())
        {
            String tenMA = txtTenMonAn.getText();
            int donGia = Integer.parseInt(txtDonGia.getText());
            String donViTinh = txtDonVi.getText();
            
            if (them(tenMA, donGia, donViTinh))
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
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Đơn giá phải là số");
            }
            
            btnThem.setText("Thêm");
            setButtonEditable(false);
            
            if (dtm.getRowCount() >= 0)
            {
                tbMonAn.setRowSelectionInterval(0, 0);
                tbMonAnMouseClicked(null);
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
        else if (!isEmpty() && isValidValues())
        {
            int maMA = getDanhSachMA().get(tbMonAn.getSelectedRow()).getMaMA();
            String tenMA = txtTenMonAn.getText();
            int donGia = Integer.parseInt(txtDonGia.getText());
            String donViTinh = txtDonVi.getText();
            
            if (sua(maMA, tenMA, donGia, donViTinh))
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
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Đơn giá phải là số");
            }
            
            btnCapNhat.setText("Cập nhật");
            setButtonEditable(false);
            
            if (dtm.getRowCount() >= 0)
            {
                tbMonAn.setRowSelectionInterval(0, 0);
                tbMonAnMouseClicked(null);
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbMonAn.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa món ăn này và những thông tin chế biến liên quan?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maMA = getDanhSachMA().get(
                        tbMonAn.getSelectedRow()).getMaMA();
                if (xoa(maMA)) 
                {
                    hienThi();
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin món ăn cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCheBien;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtTenMonAn;
    // End of variables declaration//GEN-END:variables
}
