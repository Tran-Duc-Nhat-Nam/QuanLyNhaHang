package gui;

import dao.XuLyBan;
import static dao.XuLyCSDL.getThongBao;
import dao.XuLyPhong;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import pojo.Ban;
import pojo.DanhSach;
import pojo.Phong;
import pojo.Tang;

public class FormPhongBan extends ParentForm {
    DefaultComboBoxModel<Tang> dcmTang = new DefaultComboBoxModel<>();
    NonEditableTableModel netmBan = new NonEditableTableModel();
    NonEditableTableModel netmPhong = new NonEditableTableModel();
    public FormPhongBan() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        cbxTang.setModel(dcmTang);
        tbBan.setModel(netmBan);
        tbPhong.setModel(netmPhong);
        hienThi();
    }
    
    private void hienThi()
    {
        hienThiTang();
        hienThiBan(DanhSach.getDanhSachBan());
        hienThiPhong(DanhSach.getDanhSachPhong());
        
        if (dcmTang.getSize() > 0)
        {
            cbxTang.setSelectedIndex(0);
            cbxTangActionPerformed(null);
        }
    }
    
    private void hienThiTang()
    {
        dcmTang.removeAllElements();
        
        for (Tang t : DanhSach.getDanhSachTang())
        {
            dcmTang.addElement(t);
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
    
    private boolean isValidBan()
    {
        try {
            int f = Integer.parseInt(txtGiaBan.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    private boolean isValidPhong()
    {
        try {
            float f = Float.parseFloat(txtGiaPhong.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtGiaBan.setEditable(value);
        txtGiaPhong.setEditable(value);
        cbxTang.setEnabled(value);
        
        btnSuaBan.setEnabled(!value);
        btnThemBan.setEnabled(!value);
        btnXoaBan.setEnabled(!value);
        btnSuaPhong.setEnabled(!value);
        btnThemPhong.setEnabled(!value);
        btnXoaPhong.setEnabled(!value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        cbxTang = new javax.swing.JComboBox<>();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaPhong = new javax.swing.JTextField();
        btnThemBan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSuaBan = new javax.swing.JButton();
        btnXoaBan = new javax.swing.JButton();
        btnSuaPhong = new javax.swing.JButton();
        btnThemPhong = new javax.swing.JButton();
        btnXoaPhong = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(tbBan);

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
        jScrollPane3.setViewportView(tbPhong);

        cbxTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTangActionPerformed(evt);
            }
        });

        txtGiaBan.setEditable(false);

        txtGiaPhong.setEditable(false);

        btnThemBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemBan.setText("Thêm bàn");
        btnThemBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Số tầng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Giá đặt phòng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Giá đặt bàn");

        btnSuaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaBan.setText("Cập nhật bàn");
        btnSuaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBanActionPerformed(evt);
            }
        });

        btnXoaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaBan.setText("Xóa bàn");
        btnXoaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBanActionPerformed(evt);
            }
        });

        btnSuaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaPhong.setText("Cập nhật phòng");
        btnSuaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPhongActionPerformed(evt);
            }
        });

        btnThemPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemPhong.setText("Thêm phòng");
        btnThemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhongActionPerformed(evt);
            }
        });

        btnXoaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaPhong.setText("Xóa phòng");
        btnXoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(txtGiaBan))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(cbxTang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaPhong))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSuaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemBan)
                    .addComponent(btnSuaBan)
                    .addComponent(btnXoaBan)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnThemPhong)
                    .addComponent(btnSuaPhong)
                    .addComponent(btnXoaPhong))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTangActionPerformed
        Tang t = (Tang) dcmTang.getSelectedItem();
        if (t != null)
        {
            hienThiPhong(t.getDanhSachPhong());
        
            if (!t.getDanhSachPhong().isEmpty())
            {
                tbPhong.setRowSelectionInterval(0, 0);
                tbPhongMouseClicked(null);
            }
            else
            {
                netmBan.setRowCount(0);
            }
        }
    }//GEN-LAST:event_cbxTangActionPerformed

    private void tbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongMouseClicked
        Phong p = XuLyPhong.tim(netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString());
        
        if (p != null)
        {
            hienThiBan(p.getDanhSachBan());
            txtGiaPhong.setText(String.valueOf(p.getGiaDatTruoc()));

            if (!p.getDanhSachBan().isEmpty())
            {
                tbBan.setRowSelectionInterval(0, 0);
                tbBanMouseClicked(null);
            }
        }
    }//GEN-LAST:event_tbPhongMouseClicked

    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
        int maBan = Integer.parseInt(netmBan.getValueAt(tbBan.getSelectedRow(), 0).toString());
        Ban b = XuLyBan.tim(maPhong, maBan);
        txtGiaBan.setText(String.valueOf(b.getGiaDatTruoc()));
    }//GEN-LAST:event_tbBanMouseClicked

    private void btnThemBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBanActionPerformed
        if(btnThemBan.getText().equals("Thêm bàn"))
        {
            tbBan.clearSelection();
            txtGiaBan.setText("");
            setButtonEditable(true);
            btnThemBan.setEnabled(true);
            btnThemBan.setText("Lưu");
        }
        else if (!txtGiaBan.getText().isEmpty() && isValidBan())
        {
            Phong p = XuLyPhong.tim(netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString());          
            int giaDatTruoc = Integer.parseInt(txtGiaBan.getText());
            
            if (XuLyBan.them(p, giaDatTruoc))
            {
                hienThiBan(p.getDanhSachBan());
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnThemBan.setText("Thêm bàn");
            setButtonEditable(false);
        }
        else
        {
            if (txtGiaBan.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền giá đặt trước");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Giá đặt trước phải là số");
            }
            
            if (netmBan.getRowCount() >= 0)
            {
                tbBan.setRowSelectionInterval(0, 0);
                tbBanMouseClicked(null);
            }
        }
    }//GEN-LAST:event_btnThemBanActionPerformed

    private void btnThemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhongActionPerformed
        if(btnThemPhong.getText().equals("Thêm phòng"))
        {
            tbBan.clearSelection();
            txtGiaPhong.setText("");
            setButtonEditable(true);
            cbxTang.setEnabled(true);
            btnThemPhong.setEnabled(true);
            btnThemPhong.setText("Lưu");
        }
        else if (!txtGiaPhong.getText().isEmpty() && isValidPhong())
        {
            Tang t = (Tang) dcmTang.getSelectedItem();       
            int giaDatTruoc = Integer.parseInt(txtGiaPhong.getText());
            
            if (XuLyPhong.them(t, giaDatTruoc))
            {
                hienThiPhong(t.getDanhSachPhong());
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnThemPhong.setText("Thêm phòng");
            setButtonEditable(false);
        }
        else
        {
            if (txtGiaPhong.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền giá đặt trước");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Giá đặt trước phải là số");
            }
            
            if (netmPhong.getRowCount() >= 0)
            {
                tbPhong.setRowSelectionInterval(0, 0);
                tbPhongMouseClicked(null);
            }
        }
    }//GEN-LAST:event_btnThemPhongActionPerformed

    private void btnSuaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBanActionPerformed
        if(btnSuaBan.getText().equals("Cập nhật bàn"))
        {
            btnSuaBan.setText("Lưu");
            setButtonEditable(true);
            btnSuaBan.setEnabled(true);
        }
        else if (tbBan.getSelectedRow() >= 0)
        {
            if (!txtGiaBan.getText().isEmpty())
            {
                try
                {
                    int giaDatTruoc = Integer.parseInt(txtGiaBan.getText());
                    String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
                    int maBan = Integer.parseInt(netmBan.getValueAt(tbBan.getSelectedRow(), 0).toString());
                    Ban b = XuLyBan.tim(maPhong, maBan);

                    if (XuLyBan.sua(b.getMaBan(), giaDatTruoc))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật giá bàn thành công");
                        hienThi();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật giá bàn thất bại");
                    }

                    btnSuaBan.setText("Cập nhật bàn");
                    setButtonEditable(false);
                }
                catch (HeadlessException | NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Giá bàn phải là số nguyên");
                }    
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn bàn cần cập nhật");
        }
    }//GEN-LAST:event_btnSuaBanActionPerformed

    private void btnSuaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPhongActionPerformed
        if(btnSuaPhong.getText().equals("Cập nhật phòng"))
        {
            btnSuaPhong.setText("Lưu");
            setButtonEditable(true);
            btnSuaPhong.setEnabled(true);
        }
        else if (tbPhong.getSelectedRow() >= 0)
        {
            if (!txtGiaPhong.getText().isEmpty())
            {
                try
                {
                    int giaDatTruoc = Integer.parseInt(txtGiaPhong.getText());
                    String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();

                    if (XuLyPhong.sua(maPhong, giaDatTruoc))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật giá phòng thành công");
                        hienThi();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật giá phòng thất bại");
                    }

                    btnSuaPhong.setText("Cập nhật phòng");
                    setButtonEditable(false);
                }
                catch (HeadlessException | NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(rootPane, "Giá phòng phải là số nguyên");
                }    
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phòng cần cập nhật");
        }
    }//GEN-LAST:event_btnSuaPhongActionPerformed

    private void btnXoaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBanActionPerformed
        if (tbBan.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa bàn này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                String maPhong = netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString();
                int maBan = Integer.parseInt(netmBan.getValueAt(tbBan.getSelectedRow(), 0).toString());
                Ban b = XuLyBan.tim(maPhong, maBan);
                
                if (XuLyBan.xoa(b.getMaBan())) 
                {
                    hienThiBan(XuLyPhong.tim(maPhong).getDanhSachBan());
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin bàn cần xóa");
        }
    }//GEN-LAST:event_btnXoaBanActionPerformed

    private void btnXoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhongActionPerformed
        if (tbPhong.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa phòng này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                Phong p = XuLyPhong.tim(netmPhong.getValueAt(tbPhong.getSelectedRow(), 0).toString());
                
                if (XuLyPhong.xoa(p.getMaPhong())) 
                {
                    Tang t = (Tang) dcmTang.getSelectedItem();
                    hienThiPhong(t.getDanhSachPhong());
                    hienThiBan(new ArrayList<>());
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin phòng cần xóa");
        }
    }//GEN-LAST:event_btnXoaPhongActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaBan;
    private javax.swing.JButton btnSuaPhong;
    private javax.swing.JButton btnThemBan;
    private javax.swing.JButton btnThemPhong;
    private javax.swing.JButton btnXoaBan;
    private javax.swing.JButton btnXoaPhong;
    private javax.swing.JComboBox<Tang> cbxTang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbBan;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaPhong;
    // End of variables declaration//GEN-END:variables
}
