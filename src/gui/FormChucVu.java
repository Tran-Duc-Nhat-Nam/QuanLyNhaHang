package gui;

import static dao.XuLyCSDL.getThongBao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import pojo.ChucVu;
import static pojo.DanhSach.getDanhSachCV;
import pojo.NhanVien;
import static dao.XuLyChucVu.them;
import static dao.XuLyChucVu.sua;
import static dao.XuLyChucVu.xoa;
import javax.swing.ListSelectionModel;

public class FormChucVu extends ParentForm {
    NonEditableTableModel dtmNV = new NonEditableTableModel();
    
    public FormChucVu() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        tbChucVu.setModel(dtm);
        tbChucVu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbNhanVien.setModel(dtmNV);
        tbNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hienThi();
    }
    
    private void hienThi()
    {
        dtm.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã chức vụ");
        tieuDe.add("Tên chức vụ");
        tieuDe.add("Hệ số lương cơ bản");
        dtm.setColumnIdentifiers(tieuDe);
        
        for (ChucVu cv : getDanhSachCV())
        {
            Vector<Object> v = new Vector<>();
            v.add(cv.getMaCV());
            v.add(cv.getTenChucVu());
            v.add(cv.getHeSoLuongCoBan());
            dtm.addRow(v);
        }   
        
        if (tbChucVu.getSelectedRow() >= 0)
        {
            tbChucVuMouseClicked(null);
        }
        else
        {
            hienThiNhanVien(new ArrayList<>());
        }
    }
    
    private void hienThiNhanVien(List<NhanVien> danhSachNV)
    {
        dtmNV.setRowCount(0);
        
        Vector<Object> tieuDe = new Vector<>();
        tieuDe.add("Mã nhân viên");
        tieuDe.add("Họ tên");
        tieuDe.add("SDT");
        tieuDe.add("Địa chỉ");
        dtmNV.setColumnIdentifiers(tieuDe);
        
        for (NhanVien nv : danhSachNV)
        {
            Vector<Object> v = new Vector<>();
            v.add(nv.getMaNV());
            v.add(nv.getTenNV());
            v.add(nv.getSdt());
            v.add(nv.getDiaChi());
            dtmNV.addRow(v);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChucVu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaChucVu = new javax.swing.JTextField();
        txtTenChucVu = new javax.swing.JTextField();
        txtHeSoLuong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách chức vụ"));

        tbChucVu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChucVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChucVu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách nhân viên giữ chức vụ \n"));

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
        jScrollPane2.setViewportView(tbNhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin chức vụ \n"));

        jLabel1.setText("Mã chức vụ");

        jLabel2.setText("Tên chức vụ");

        jLabel3.setText("Hệ số lương khởi đầu");

        txtMaChucVu.setEditable(false);

        txtTenChucVu.setEditable(false);

        txtHeSoLuong.setEditable(false);

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnThem)
                        .addGap(59, 59, 59)
                        .addComponent(btnCapNhat)
                        .addGap(60, 60, 60)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(5, 5, 5)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenChucVu)
                            .addComponent(txtMaChucVu)
                            .addComponent(txtHeSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(59, 59, 59))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEmpty()
    {
        return txtTenChucVu.getText().isEmpty() ||
            txtHeSoLuong.getText().isEmpty();
    }
    
    private boolean isValidValues()
    {
        try {
            float f = Float.parseFloat(txtHeSoLuong.getText());
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public void setButtonEditable(boolean value)
    {
        txtTenChucVu.setEditable(value);
        txtHeSoLuong.setEditable(value);
        
        btnCapNhat.setEnabled(!value);
        btnThem.setEnabled(!value);
        btnXoa.setEnabled(!value);
    }
    
    private void tbChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChucVuMouseClicked
        ChucVu cv = getDanhSachCV().get(tbChucVu.getSelectedRow());
        txtMaChucVu.setText(String.valueOf(cv.getMaCV()));
        txtTenChucVu.setText(cv.getTenChucVu());
        txtHeSoLuong.setText(String.valueOf(cv.getHeSoLuongCoBan()));
        
        btnThem.setText("Thêm");
        btnCapNhat.setText("Cập nhật");
        setButtonEditable(false);
        
        hienThiNhanVien(cv.getDanhSachNV());
    }//GEN-LAST:event_tbChucVuMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm"))
        {
            tbChucVu.clearSelection();
            hienThiNhanVien(new ArrayList<>());
            txtMaChucVu.setText("");
            txtTenChucVu.setText("");
            txtHeSoLuong.setText("");
            btnThem.setText("Lưu");
            setButtonEditable(true);
            btnThem.setEnabled(true);
        }
        else if (!isEmpty() && isValidValues())
        {
            String tenCV = txtTenChucVu.getText();
            float HSLCB = Float.parseFloat(txtHeSoLuong.getText());
            
            if (them(tenCV, HSLCB))
            {
                hienThi();
            }
                
            JOptionPane.showMessageDialog(rootPane, getThongBao()); 
            
            btnThem.setText("Thêm");
            setButtonEditable(false);
            
            if (dtm.getRowCount() >= 0)
            {
                tbChucVu.setRowSelectionInterval(0, 0);
                tbChucVuMouseClicked(null);
            }     
        }
        else
        {
            if (isEmpty())
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin chức vụ");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Hệ số lương cơ bản phải là số");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (btnCapNhat.getText().equals("Cập nhật"))
        {
            btnCapNhat.setText("Lưu");
            setButtonEditable(true);
            btnCapNhat.setEnabled(true);
        }
        else if (tbChucVu.getSelectedRow() >= 0)
        {
            if (!isEmpty() && isValidValues())
            {
                int maCV = Integer.parseInt(txtMaChucVu.getText());
                String tenCV = txtTenChucVu.getText();
                float HSLCB = Float.parseFloat(txtHeSoLuong.getText());

                if (sua(maCV, tenCV, HSLCB))
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật chức vụ thành công");
                    hienThi();
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật chức vụ thất bại");
                }

                btnCapNhat.setText("Cập nhật");
                setButtonEditable(false);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn chức vụ cần cập nhật");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbChucVu.getSelectedRow() >= 0)
        {
            int kq = JOptionPane.showConfirmDialog(
                rootPane, 
                "Bạn có muốn xóa chức vụ này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        
            if (kq == JOptionPane.YES_OPTION)
            {
                if (xoa(Integer.parseInt(txtMaChucVu.getText()))) 
                {
                    hienThi();
                }
                
                JOptionPane.showMessageDialog(rootPane, getThongBao());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn thông tin chức vụ cần xóa");
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
    private javax.swing.JTable tbChucVu;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JTextField txtMaChucVu;
    private javax.swing.JTextField txtTenChucVu;
    // End of variables declaration//GEN-END:variables
}
