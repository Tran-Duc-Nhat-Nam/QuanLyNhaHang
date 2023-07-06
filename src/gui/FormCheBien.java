package gui;

import static dao.XuLyCSDL.getThongBao;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import pojo.CheBien;
import static pojo.DanhSach.getDanhSachCB;
import static pojo.DanhSach.getDanhSachMA;
import static pojo.DanhSach.getDanhSachVT;
import pojo.MonAn;
import pojo.VatTu;
import static dao.XuLyCheBien.them;
import static dao.XuLyCheBien.sua;
import static dao.XuLyCheBien.xoa;
import static dao.XuLyCheBien.tim;
import javax.swing.ListSelectionModel;

public class FormCheBien extends ParentForm {
    NonEditableTableModel dtmVT = new NonEditableTableModel();
    NonEditableTableModel dtmMA = new NonEditableTableModel();
    boolean multiChoose = false;

    public FormCheBien() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        tbCheBien.setModel(dtm);
        tbCheBien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbVatTu.setModel(dtmVT);
        tbVatTu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMonAn.setModel(dtmMA);
        tbMonAn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hienThiVatTu();
        hienThiMonAn();
    }

    private void hienThi(List<CheBien> danhSachCB)
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên vật tư");
        tieuDe.add("Tên món ăn");
        tieuDe.add("Số lượng tiêu thụ");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (CheBien cb : danhSachCB)
        {
            Vector<Object> v = new Vector<>();
            v.add(cb.getVatTu().getTenVT());
            v.add(cb.getMonAn().getTenMA());
            v.add(cb.getSoLuongTieuThu());
            dtm.addRow(v);
        }
        
        if (tbCheBien.getSelectedRow() >= 0)
        {
            tbCheBienMouseClicked(null);
        }
    }
    
    private void hienThi(CheBien cb)
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên vật tư");
        tieuDe.add("Tên món ăn");
        tieuDe.add("Số lượng tiêu thụ");
        dtm.setColumnIdentifiers(tieuDe);
        
        if (cb != null)
        {
            Vector<Object> v = new Vector<>();
            v.add(cb.getVatTu().getTenVT());
            v.add(cb.getMonAn().getTenMA());
            v.add(cb.getSoLuongTieuThu());
            dtm.addRow(v);
        }
        
        if (tbCheBien.getSelectedRow() >= 0)
        {
            tbCheBienMouseClicked(null);
        }
    }
    
    private void hienThiVatTu()
    {
        dtmVT.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Tên vật tư");
        tieuDe.add("Đơn vị tính");
        tieuDe.add("Đơn giá");
        dtmVT.setColumnIdentifiers(tieuDe);
        
        for (VatTu vt : getDanhSachVT())
        {
            Vector<Object> v = new Vector<>();
            v.add(vt.getTenVT());
            v.add(vt.getDonViTinh());
            v.add(vt.getDonGia());
            dtmVT.addRow(v);
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
        
        for (MonAn ma : getDanhSachMA())
        {
            Vector<Object> v = new Vector<>();
            v.add(ma.getTenMA());
            v.add(ma.getDonViTinh());
            v.add(ma.getDonGia());
            dtmMA.addRow(v);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCheBien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVatTu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Công thức chế biến"));
        jPanel1.setPreferredSize(new java.awt.Dimension(486, 370));

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
        tbCheBien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCheBienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCheBien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách vật tư"));
        jPanel2.setPreferredSize(new java.awt.Dimension(356, 185));

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
        jScrollPane3.setViewportView(tbVatTu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách món ăn"));
        jPanel3.setPreferredSize(new java.awt.Dimension(365, 185));

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
        jScrollPane2.setViewportView(tbMonAn);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Số Lượng:");

        txtSoLuong.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(532, 35));

        btnThem.setBackground(new java.awt.Color(204, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(133, 133));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(204, 255, 204));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setPreferredSize(new java.awt.Dimension(133, 23));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 255, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setPreferredSize(new java.awt.Dimension(133, 23));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEmpty()
    {
        return txtSoLuong.getText().isEmpty();
    }
    
    private boolean isValidValues()
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
        txtSoLuong.setEditable(value);
        
        btnThem.setEnabled(!value);
        btnCapNhat.setEnabled(!value);
        btnXoa.setEnabled(!value);
    }
    
    private void tbVatTuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVatTuMouseClicked

        if (multiChoose && tbMonAn.getSelectedRow() >= 0)
        {
            MonAn ma = getDanhSachMA().get(tbMonAn.getSelectedRow());
            VatTu vt = getDanhSachVT().get(tbVatTu.getSelectedRow());
            hienThi(tim(ma.getMaMA(), vt.getMaVT()));
        }
        else
        {
            tbMonAn.clearSelection();
            hienThi(getDanhSachVT().get(tbVatTu.getSelectedRow()).getDanhSachCheBien());
        }
    }//GEN-LAST:event_tbVatTuMouseClicked

    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked

        if (multiChoose && tbVatTu.getSelectedRow() >= 0)
        {
            MonAn ma = getDanhSachMA().get(tbMonAn.getSelectedRow());
            VatTu vt = getDanhSachVT().get(tbVatTu.getSelectedRow());
            hienThi(tim(ma.getMaMA(), vt.getMaVT()));   
        }
        else
        {
            tbVatTu.clearSelection();
            hienThi(getDanhSachMA().get(tbMonAn.getSelectedRow()).getDanhSachCB());
        }
    }//GEN-LAST:event_tbMonAnMouseClicked

    private void tbCheBienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCheBienMouseClicked
        txtSoLuong.setText(String.valueOf(getDanhSachCB()
                .get(tbCheBien.getSelectedRow()).getSoLuongTieuThu()));
        setButtonEditable(false);
    }//GEN-LAST:event_tbCheBienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm"))
        {
            tbCheBien.clearSelection();
            txtSoLuong.setText("");
            btnThem.setText("Lưu");
            setButtonEditable(true);
            btnThem.setEnabled(true);
            multiChoose = true;
        }
        else if (!isEmpty() && isValidValues())
        {
            MonAn ma = getDanhSachMA().get(tbMonAn.getSelectedRow());
            VatTu vt = getDanhSachVT().get(tbVatTu.getSelectedRow());
            float soLuongTieuThu = Float.parseFloat(txtSoLuong.getText());
            
            if (them(ma, vt, soLuongTieuThu))
            {
                hienThi(tim(ma.getMaMA(), vt.getMaVT()));
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnThem.setText("Thêm");
            setButtonEditable(false);
        }
        else
        {
            if (isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin chế biến");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Số lượng tiêu thụ phải lớn hơn 0");
            }
            
            btnThem.setText("Thêm");
            setButtonEditable(false);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(btnCapNhat.getText().equals("Cập nhật"))
        {
            btnCapNhat.setText("Lưu");
            setButtonEditable(true);
            btnCapNhat.setEnabled(true);
            multiChoose = true;
        }
        else if (tbCheBien.getSelectedRow() >= 0)
        {
            if (!isEmpty() && isValidValues())
            {
                MonAn ma = getDanhSachMA().get(tbMonAn.getSelectedRow());
                VatTu vt = getDanhSachVT().get(tbVatTu.getSelectedRow());
                Float soLuongTieuThu = Float.valueOf(txtSoLuong.getText());

                if (sua(ma, vt, soLuongTieuThu))
                {
                    hienThi(tim(ma.getMaMA(), vt.getMaVT()));
                }

                JOptionPane.showMessageDialog(rootPane, getThongBao());
                btnCapNhat.setText("Cập nhật");
                setButtonEditable(false);
            }
            else
            {
                if (isEmpty())
                {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin chế biến");
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Số lượng tiêu thụ phải lớn hơn 0");
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin chế biến cần xóa");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (btnXoa.getText().equals("Xóa"))
        {
            btnXoa.setText("Lưu");
            multiChoose = true;
        }   
        else if (tbCheBien.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa thông tin chế biến này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                MonAn ma = getDanhSachMA().get(tbMonAn.getSelectedRow());
                VatTu vt = getDanhSachVT().get(tbVatTu.getSelectedRow());
                
                if (xoa(ma, vt)) 
                {
                    hienThi(tim(ma.getMaMA(), vt.getMaVT()));
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
            
            btnXoa.setText("Xóa");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin chế biến cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbCheBien;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTable tbVatTu;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
