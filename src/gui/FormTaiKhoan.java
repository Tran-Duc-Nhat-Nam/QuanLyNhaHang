/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import static dao.XuLyCSDL.getThongBao;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import pojo.ChucVu;
import static pojo.DanhSach.getDanhSachCV;
import static pojo.DanhSach.getDanhSachNV;
import static pojo.DanhSach.getDanhSachTK;
import pojo.NhanVien;
import pojo.TaiKhoan;
import static dao.XuLyTaiKhoan.them;
import static dao.XuLyTaiKhoan.sua;
import static dao.XuLyTaiKhoan.xoa;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Admin
 */
public class FormTaiKhoan extends ParentForm {
    DefaultComboBoxModel<NhanVien> dcmNV = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<ChucVu> dcmCV = new DefaultComboBoxModel<>();
    /**
     * Creates new form TaiKhoan
     */
    public FormTaiKhoan() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        tbTaiKhoan.setModel(dtm);
        tbTaiKhoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cbChucVu.setModel(dcmCV);
        cbNhanVien.setModel(dcmNV);
        hienThi();
    }
    
    private void hienThi()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã nhân viên");
        tieuDe.add("Mật khẩu");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (TaiKhoan tk : getDanhSachTK())
        {
            Vector<Object> v = new Vector<>();
            v.add(tk.getNhanVien().getMaNV());
            v.add(tk.getMatKhau());
            dtm.addRow(v);
        }
        
        for (ChucVu cv : getDanhSachCV())
        {
            dcmCV.addElement(cv);
        }
        
        for (NhanVien nv : getDanhSachNV())
        {
            dcmNV.addElement(nv);
        }
        
        if (tbTaiKhoan.getSelectedRow() >= 0)
        {
            tbTaiKhoanMouseClicked(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTaiKhoan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbNhanVien = new javax.swing.JComboBox<>();
        cbChucVu = new javax.swing.JComboBox<>();
        txtMatKhau = new javax.swing.JPasswordField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách tài khoản"));

        tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTaiKhoan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Tên nhân viên");

        jLabel2.setText("Chức vụ");

        jLabel3.setText("Mật khẩu");
        jLabel3.setToolTipText("");

        cbChucVu.setEnabled(false);

        txtMatKhau.setEditable(false);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbNhanVien, 0, 247, Short.MAX_VALUE)
                            .addComponent(cbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMatKhau))))
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEmpty()
    {
        return txtMatKhau.getText().isEmpty();
    }
    
    public void setButtonEditable(boolean value)
    {
        cbNhanVien.setEnabled(value);
        txtMatKhau.setEditable(value);
        
        btnCapNhat.setEnabled(!value);
        btnThem.setEnabled(!value);
        btnXoa.setEnabled(!value);
    }                                                                            
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm"))
        {
            tbTaiKhoan.clearSelection();
            txtMatKhau.setText("");
            btnThem.setText("Lưu");
            setButtonEditable(true);
            btnThem.setEnabled(true);
        }
        else if (!isEmpty())
        {
            NhanVien nv = (NhanVien) cbNhanVien.getSelectedItem();
            int maNV = nv.getMaNV();
            String mk = txtMatKhau.getText();
            
            if (them(maNV, mk))
            {
                hienThi();
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnThem.setText("Thêm");
            setButtonEditable(false);
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền mật khẩu");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(btnCapNhat.getText().equals("Cập nhật"))
        {
            btnCapNhat.setText("Lưu");
            setButtonEditable(true);
            btnCapNhat.setEnabled(true);
        }
        else if (!isEmpty())
        {
            NhanVien nv = (NhanVien) cbNhanVien.getSelectedItem();
            int maNV = nv.getMaNV();
            String mk = txtMatKhau.getText();
            
            if (sua(maNV, mk))
            {
                hienThi();
            }
            
            JOptionPane.showMessageDialog(rootPane, getThongBao());
            btnCapNhat.setText("Cập nhật");
            setButtonEditable(false);
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền mật khẩu");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbTaiKhoan.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa món ăn này và những thông tin chế biến liên quan?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                int maNV = getDanhSachTK().get(
                        tbTaiKhoan.getSelectedRow()).getNhanVien().getMaNV();
                
                if (xoa(maNV)) 
                {
                    hienThi();
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn tài khoản cần xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoanMouseClicked
        int position = tbTaiKhoan.getSelectedRow();
        NhanVien nv = getDanhSachTK().get(position).getNhanVien();
        cbNhanVien.setSelectedItem(nv);
        cbChucVu.setSelectedItem(nv.getChucVu());
        txtMatKhau.setText(nv.getTaiKhoan().getMatKhau());
        
        btnThem.setText("Thêm");
        btnCapNhat.setText("Cập nhật");
        setButtonEditable(false);
    }//GEN-LAST:event_tbTaiKhoanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<ChucVu> cbChucVu;
    private javax.swing.JComboBox<NhanVien> cbNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTaiKhoan;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
