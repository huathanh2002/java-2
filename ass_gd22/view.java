/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ass_gd22;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author An Dong PC
 */
public class view extends javax.swing.JFrame implements Runnable {

    //private List<NhanVien> list = new ArrayList<>();
    private NhanVienService service = new NhanVienService();
    private DefaultTableModel tblModel = new DefaultTableModel();
    private int index = -1;

    /**
     * Creates new form view
     */
    public view() {
        initComponents();
        this.setLocationRelativeTo(null);

        this.fillTable(service.getAll());
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
    }
//    void chuChay(){
//        Thread thread=new Thread();
//        
//    }

    void showNV(int index) {
        NhanVien nv = service.getAll().get(index);
        txtMaNV.setText(nv.getMaNV());
        txtHoTenNV.setText(nv.getHoTenNV());
        txtTuoiNV.setText(Double.toString(nv.getTuoi()));
        txtEmailNV.setText(nv.getEmailNV());
        txtLuongNV.setText(Double.toString(nv.getLuong()));

    }

    NhanVien readForm() {
        List<NhanVien> list = new ArrayList<>();
        String maNV, hoTenNV;
        double tuoi;
        String email;
        double luong;
        maNV = txtMaNV.getText();
        if (maNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhân viên !");
            return null;
        } else {
            index=service.timNV(maNV);
            if (index>=0) {
                JOptionPane.showMessageDialog(this, "mã nhân viên đã tồn tại trong danh sách vui lòng nhập mã mới !");
                return null;
            }
        }
        hoTenNV = txtHoTenNV.getText();
        if (hoTenNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ và tên nhân viên !");
            return null;
        } else {
            if (!hoTenNV.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng họ và tên nhân viên !");
                return null;
            }
        }

        if (txtTuoiNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tuổi nhân viên !");
            return null;
        } else {
            try {
                tuoi = Double.parseDouble(txtTuoiNV.getText());
                if (tuoi < 16 || tuoi > 55) {
                    JOptionPane.showMessageDialog(this, "Tuổi nhân viên phải từ 16-55");
                    return null;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng tuổi !");
                return null;
            }
        }
        email = txtEmailNV.getText();
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập email nhân viên !");
            return null;
        } else {
            if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
                JOptionPane.showMessageDialog(this, "Email phải có ' @ và . ' ");
                return null;
            }
        }

        if (txtLuongNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập lương nhân viên !");
            return null;
        } else {
            try {
                luong = Double.parseDouble(txtLuongNV.getText());
                if (luong < 5000000) {
                    JOptionPane.showMessageDialog(this, "Lương nhân viên phải trên 5 triệu !");
                    return null;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng lương nhân viên !");
                return null;
            }
        }
        return new NhanVien(maNV, hoTenNV, tuoi, email, luong);
    }
    
    NhanVien readForm1() {
        List<NhanVien> list = new ArrayList<>();
        String maNV, hoTenNV;
        double tuoi;
        String email;
        double luong;
        maNV = txtMaNV.getText();
        if (maNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhân viên !");
            return null;
        } 
        hoTenNV = txtHoTenNV.getText();
        if (hoTenNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ và tên nhân viên !");
            return null;
        } else {
            if (!hoTenNV.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng họ và tên nhân viên !");
                return null;
            }
        }

        if (txtTuoiNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tuổi nhân viên !");
            return null;
        } else {
            try {
                tuoi = Double.parseDouble(txtTuoiNV.getText());
                if (tuoi < 16 || tuoi > 55) {
                    JOptionPane.showMessageDialog(this, "Tuổi nhân viên phải từ 16-55");
                    return null;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng tuổi !");
                return null;
            }
        }
        email = txtEmailNV.getText();
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập email nhân viên !");
            return null;
        } else {
            if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
                JOptionPane.showMessageDialog(this, "Email phải có ' @ và . ' ");
                return null;
            }
        }

        if (txtLuongNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập lương nhân viên !");
            return null;
        } else {
            try {
                luong = Double.parseDouble(txtLuongNV.getText());
                if (luong < 5000000) {
                    JOptionPane.showMessageDialog(this, "Lương nhân viên phải trên 5 triệu !");
                    return null;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng lương nhân viên !");
                return null;
            }
        }
        return new NhanVien(maNV, hoTenNV, tuoi, email, luong);
    }

    void fillTable(List<NhanVien> list) {
        tblModel = (DefaultTableModel) tblList.getModel();
        tblModel.setRowCount(0);
        for (NhanVien nv : list) {
            tblModel.addRow(nv.toDataRow());
        }
    }

    void pre() {
        index = 0;
        this.showNV(index);
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
    }

    void last() {

        index = service.dem() - 1;
        this.showNV(index);
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
    }

    void next() {
        index=-1;
        if (index == service.dem() - 1) {
            index = 0;
            this.showNV(index);
        } else {
            index++;
            this.showNV(index);
        }
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
    }

    void back() {
        index=0;
        if (index == 0) {
            index = service.dem() - 1;
            this.showNV(index);
        } else {
            index--;
            this.showNV(index);
        }
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
        
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
        lblQLNV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTuoiNV = new javax.swing.JTextField();
        txtLuongNV = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblRecord = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblQLNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQLNV.setForeground(new java.awt.Color(0, 0, 255));
        lblQLNV.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Họ và Tên");

        jLabel4.setText("Tuổi");

        jLabel5.setText("Email");

        jLabel6.setText("Lương");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(btnOpen)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnPre.setText("|<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblRecord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 0, 51));
        lblRecord.setText("Record: 1 of 10");

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 51));
        lblTime.setText("10:22 AM");

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ và Tên", "Tuổi", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTenNV)
                            .addComponent(txtEmailNV)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTuoiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblQLNV))
                                .addGap(0, 68, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecord)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTime)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQLNV)
                    .addComponent(lblTime))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTuoiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecord))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Clock clock = new Clock(lblTime);
        Thread t1 = new Thread(clock);
        t1.start();
    }//GEN-LAST:event_formWindowOpened

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        index = tblList.getSelectedRow();
        this.showNV(index);
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
    }//GEN-LAST:event_tblListMouseClicked

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.back();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        this.pre();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        JFileChooser jc = new JFileChooser();
        int chon = jc.showSaveDialog(null);

        if (chon == 0) {
            String path = jc.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(this, service.WriteFile(path));
            tblModel.setRowCount(0);

        } else {
            JOptionPane.showMessageDialog(this, "ban khong luu file");
        }
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        JFileChooser jc = new JFileChooser();
        int chon = jc.showOpenDialog(null);
        if (chon == 0) {
            String path = jc.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(this, service.ReadFile(path));
            if (service.ReadFile(path).contains("thanh cong")) {
                this.fillTable(service.getAll());
            }
            
            
            this.showNV(0);
            index=-1;
            lblRecord.setText("Record: " + (index + 2) + " of " + service.dem());
        } else {
            JOptionPane.showMessageDialog(this, "ban khong chon file doc");
        }

    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String ma;
        ma = JOptionPane.showInputDialog(this, "Mời nhập mã nhân viên cần tìm:");
        index = service.timNV(ma);
        if (index >= 0) {
            this.showNV(index);
            lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên " + ma + " !");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(this, service.deleteNV(index));
        this.fillTable(service.getAll());
        btnNewActionPerformed(evt);
        lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (index == -1) {
            JOptionPane.showMessageDialog(this, service.addNV(readForm()));
            lblRecord.setText("Record: " + (index + 1) + " of " + service.dem());

        } else {
            JOptionPane.showMessageDialog(this, service.updateNV(index, readForm1()));
        }
        this.fillTable(service.getAll());
        btnNewActionPerformed(evt);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtHoTenNV.setText("");
        txtTuoiNV.setText("");
        txtEmailNV.setText("");
        txtLuongNV.setText("");
        index = -1;
        fillTable(service.getAll());
        lblRecord.setText("Record: " + (index+1 ) + " of " + service.dem());
    }//GEN-LAST:event_btnNewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Linux".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new view().setVisible(true);
//                
//            }
//        });
    view test=new view();
    test.setVisible(true);
    Thread th=new Thread(test);
    th.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQLNV;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtLuongNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTuoiNV;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {            
            String ch=lblQLNV.getText();
            
            String c=ch.substring(0, 1);
            ch=ch.substring(1, ch.length());
            ch=ch+c;
            lblQLNV.setText(ch);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
