/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LOAIPHONG;
import BUS.PHONG;
import DTO.DTO_LoaiPhong;
import DTO.DTO_Phong;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static jdk.nashorn.internal.runtime.Context.DEBUG;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.table.DatePickerCellEditor;

/**
 *
 * @author Ngoc Thang
 */
public class PhieuDatPhong extends javax.swing.JFrame {

    /**
     * Creates new form PhieuDatPhong
     */
    DefaultTableModel PhongTrongModel, PhongChonModel, KhachModel;
    JXTable TablePhongTrong, TablePhongChon, TableKhach;
    
    ArrayList<DTO_Phong> dsPhong;
    
    int rowSelected = -1;
    
    public PhieuDatPhong() {
        initComponents();
        PhongChonModel = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 1: case 4:
                        return Integer.class;
                    case 2: case 3: 
                        return Date.class;
                    default:
                        return String.class;
                }
            }
            public boolean isCellEditable(int row, int col) {
                if (col == 0 || col == 4) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        PhongChonModel.addColumn("Phòng");
        PhongChonModel.addColumn("Số Người");
        PhongChonModel.addColumn("Ngày Đến");
        PhongChonModel.addColumn("Ngày Đi");
        PhongChonModel.addColumn("Đơn Giá");
        
        PhongTrongModel = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0: 
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
            public boolean isCellEditable(int row, int col) {
                if (col > 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        
        TablePhongTrong = new JXTable();
        TablePhongTrong.setModel(PhongTrongModel);
        
        TablePhongTrong.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablePhongTrongPropertyChange(evt);
            }

            private void tablePhongTrongPropertyChange(PropertyChangeEvent evt) {
                
                JXTable t = ((JXTable)evt.getSource());
                int row = t.getSelectedRow();
                if(t.getSelectedColumn() == 0 && evt.getPropertyName().equals("tableCellEditor") && evt.getNewValue() == null){
                    if((boolean)TablePhongTrong.getValueAt(row, 0) == true){
                        Vector v = new Vector();
                        v.add(TablePhongTrong.getValueAt(row, 1));
                        v.add("1");
                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        sdf.format(d);
                        v.add(d);
                        v.add(d);
                        DTO_LoaiPhong loaiphong;
                        try {
                            loaiphong = LOAIPHONG.getById(dsPhong.get(row).getLoaiPhong());
                            v.add(String.valueOf(loaiphong.getDonGia()));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Không thể kết nối!" + ex);
                        }
                        PhongChonModel.addRow(v);
                        
                        // Thêm model cho table khách
                        addKhach(TablePhongTrong.getValueAt(row, 1).toString(), 1);
                    }
                    else{
                        for (int i = 0; i < TablePhongChon.getRowCount(); i++) {
                            if((PhongChonModel.getValueAt(i, 0)).toString().equals(TablePhongTrong.getValueAt(row, 1))){
                                PhongChonModel.removeRow(i);
                                removeKhach(TablePhongTrong.getValueAt(row, 1).toString(), -1);
                            }
                        }
                    }
                }
            }
        });
        PhongTrongModel.addColumn("Chọn");
        //PhongTrongModel.addColumn("Mã Phòng");
        PhongTrongModel.addColumn("Tên Phòng");
        PhongTrongModel.addColumn("Loại Phòng");
        PhongTrongModel.addColumn("Tình Trạng");
        LoadData();
        PanePhongTrong.setViewportView(TablePhongTrong);
        
        TablePhongTrong.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                tablePhongTrong_MouseClicked(evt);
            }

            private void tablePhongTrong_MouseClicked(MouseEvent evt) {
                rowSelected = TablePhongTrong.getSelectedRow();
                //int status = Integer.parseInt(PhongModel.getValueAt(row, 3).toString());
                //String maphong = (String) PhongModel.getValueAt(row, 0);
                
            }
        });
        //////////////////////
        TablePhongChon = new JXTable();
        TablePhongChon.setModel(PhongChonModel);
        TableColumn columnSoNguoi = TablePhongChon.getColumnModel().getColumn(1);
        JComboBox cbxSoNguoi = new JComboBox();
        cbxSoNguoi.addItem("1");
        cbxSoNguoi.addItem("2");
        cbxSoNguoi.addItem("3");
        cbxSoNguoi.setSelectedIndex(0);
        columnSoNguoi.setCellEditor(new DefaultCellEditor(cbxSoNguoi));
        TableColumn columnNgayDen = TablePhongChon.getColumnModel().getColumn(2);
        DatePickerCellEditor dce = new DatePickerCellEditor();
        dce.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
        columnNgayDen.setCellEditor(dce);
        
        TableColumn columnNgayDi = TablePhongChon.getColumnModel().getColumn(3);
        DatePickerCellEditor dce1 = new DatePickerCellEditor();
        dce1.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
        columnNgayDi.setCellEditor(dce1);
        TablePhongChon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablePhongTrongPropertyChange(evt);
            }

            private void tablePhongTrongPropertyChange(PropertyChangeEvent evt) {
                JXTable t = ((JXTable)evt.getSource());
                int row = TablePhongChon.getSelectedRow();
                if(t.getSelectedColumn() == 1 && evt.getPropertyName().equals("tableCellEditor") && evt.getNewValue() == null){
                    String phong = TablePhongChon.getValueAt(row, 0).toString();
                    int songuoimoi = Integer.parseInt(TablePhongChon.getValueAt(row, 1).toString());
                    int songuoicu = demKhach(phong);
                    if(songuoimoi < songuoicu){
                        removeKhach(phong, songuoicu - songuoimoi);
                    }
                    else if(songuoimoi > songuoicu){
                        addKhach(phong, songuoimoi - songuoicu);
                    }
                }
            }
        });
        
        PanePhongChon.setViewportView(TablePhongChon);
        
        TablePhongChon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                tablePhongTrong_MouseClicked(evt);
            }

            private void tablePhongTrong_MouseClicked(MouseEvent evt) {
                
                
                int row = TablePhongChon.getSelectedRow();
                if(row >= 0){
                    //TableKhach.setModel(dsKhachModel.get(row));
                }
                
            }
        });
        
        /////////////////////
        KhachModel = new DefaultTableModel();
        KhachModel.addColumn("Phòng");
        KhachModel.addColumn("Họ Tên");
        KhachModel.addColumn("CMND");
        KhachModel.addColumn("Số Điện Thoại");
        KhachModel.addColumn("Quốc Tịch");
        
        
        TableKhach = new JXTable();
        TableKhach.setModel(KhachModel);
        PaneKhach.setViewportView(TableKhach);
        
    }
    
    public void addKhach(String phong, int songuoi){
        for (int i = 0; i < songuoi; i++) {
        Vector v = new Vector();
        v.add(phong);
        v.add("");
        v.add("");
        v.add("");
        v.add("");
        KhachModel.addRow(v);
        }
    }
    
    public void removeKhach(String phong, int songuoi){
        if(songuoi < 0){
            for (int i = KhachModel.getRowCount() - 1; i >= 0; i--) {
            if(KhachModel.getValueAt(i, 0).equals(phong)){
                KhachModel.removeRow(i);
            }
        }
        }
        else{
            for (int i = KhachModel.getRowCount() - 1; i >= 0; i--) {
            if(songuoi > 0 && KhachModel.getValueAt(i, 0).equals(phong)){
                KhachModel.removeRow(i);
                songuoi --;
            }
        }
        }
    }
    
    public int demKhach(String phong){
        int num = 0;
        for (int i = 0; i < KhachModel.getRowCount(); i++) {
            if(KhachModel.getValueAt(i, 0).equals(phong)){
                num++;
            }
        }
        return num;
    }
    public void LoadData(){
        if(dsPhong != null){
            int n = dsPhong.size();
            for (int i = 0; i < n; i++) {
            PhongTrongModel.removeRow(0);
        }
        }
        try{
            dsPhong = PHONG.getAll();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Không thể lấy danh sách phòng!");
            return;
        }
        
        for(int i = 0; i < dsPhong.size(); i++){
            Vector vt = new Vector();
            vt.add(false);
            //vt.add(DanhSachPhong.get(i).getMaPhong());
            vt.add(dsPhong.get(i).getTenPhong());
            try {
                DTO_LoaiPhong loaiphong = LOAIPHONG.getById(dsPhong.get(i).getLoaiPhong());
                vt.add(loaiphong.getTenLoaiPhong());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Không thể kết nối!");
            }
            
            int loai = dsPhong.get(i).getTinhTrang();
            switch(loai){
                case 0:
                    vt.add("Trống");
                    break;
                case 1: 
                    vt.add("Đang đặt");
                    break;
                case 2: 
                    vt.add("Đang thuê");
                    break;
                default:
                    vt.add("Trống");
            }
            
            PhongTrongModel.addRow(vt);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        PanePhongTrong = new javax.swing.JScrollPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PanePhongChon = new javax.swing.JScrollPane();
        btnLuu = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        PaneKhach = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Đặt Phòng"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách đặt phòng"));

        jLabel3.setText("Địa Chỉ");

        jLabel6.setText("CMND");

        jLabel2.setText("Mã Phiếu Đặt");

        jLabel1.setText("Tên Khách Hàng");

        jLabel5.setText("Số Điện Thoại");

        jTextField6.setEditable(false);

        jLabel4.setText("Email");

        jLabel9.setText("Trị Giá");

        jComboBox1.setEditable(true);
        jComboBox1.setToolTipText("");

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        jLabel7.setText("Quốc Tịch");

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam", "Lào", "Campuchia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(66, 66, 66)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(32, 32, 32))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)))
                            .addComponent(jLabel6))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 214, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, 246, Short.MAX_VALUE)
                            .addComponent(jTextField4))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Phòng Trống"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanePhongTrong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanePhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton2)
                        .addGap(49, 49, 49)
                        .addComponent(jButton3)
                        .addGap(48, 48, 48)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Phòng Chọn"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanePhongChon, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanePhongChon, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jButton5.setText("Đóng");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách Theo Phòng"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PaneKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneKhach, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLuu)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLuu, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       
    }//GEN-LAST:event_btnLuuActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuDatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuDatPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PaneKhach;
    private javax.swing.JScrollPane PanePhongChon;
    private javax.swing.JScrollPane PanePhongTrong;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
