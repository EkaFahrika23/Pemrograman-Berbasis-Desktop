/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import Koneksi.KoneksiHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import form.FormTransaksi;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.FormTransaksi2;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fahrika
 */
public class FormTransaksi extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form DataTransaksi
     */
    public FormTransaksi() {
        initComponents();
        updateCombo();
        fetchData();
        setLocationRelativeTo(this);

    }

    //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void fetchData() {
        ArrayList<FormTransaksi2> list = transaksi();
        DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId_transaksi();
            row[1] = list.get(i).getNama_karyawan();
            row[2] = list.get(i).getTanggal();
            row[3] = list.get(i).getNama_barang();
            row[4] = list.get(i).getJumlah();
            row[5] = list.get(i).getHarga();
            row[6] = list.get(i).getTotal_harga();

            model.addRow(row);
        }
    }

    //perintah untuk memasukkan data ke dalam tabel dan select data
    public ArrayList<FormTransaksi2> transaksi() {
        ArrayList<FormTransaksi2> transaksi = new ArrayList<>();
        try {
            Connection con = KoneksiHelper.getConnection();
            String sql = "SELECT id_transaksi, nama_karyawan, tanggal,nama_barang, jumlah, harga, total_harga FROM transaksi";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            FormTransaksi2 FormTransaksi;
            while (rs.next()) {
                FormTransaksi = new FormTransaksi2(rs.getInt("id_transaksi"), rs.getString("nama_karyawan"), rs.getString("tanggal"), rs.getString("nama_barang"), rs.getInt("jumlah"), rs.getInt("harga"), rs.getInt("total_harga"));
                transaksi.add(FormTransaksi);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return transaksi;
    }
    // memanggil data dari data karyawan untuk dimasukkan ke combo box
    private void updateCombo() {
        String sql = "Select * from karyawan";
        try {
            Connection con = KoneksiHelper.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
//                comboBoxProfesi.addItem(rs.getString("id_kategori"));
                txt_nama_karyawan.addItem( rs.getString("nama"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
    // menghitung jumlah harga total
    private void getTotal() {
        try {
            int harga = Integer.parseInt(txt_harga.getText());
            int jumlah = Integer.parseInt(txt_jumlah.getText());
            double total = (harga * jumlah);
            txt_total_harga.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e);
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
        jLabel7 = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_transaksi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nama_barang = new javax.swing.JTextField();
        txt_total_harga = new javax.swing.JLabel();
        btn_hitung = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_tanggal = new javax.swing.JTextField();
        txt_nama_karyawan = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_tambah = new javax.swing.JButton();
        txt_cetak_laporan = new javax.swing.JButton();
        txt_keyword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Baru = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANAJEMEN DATA TRANSAKSI PENJUALAN");

        btn_kembali.setBackground(new java.awt.Color(255, 255, 255));
        btn_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_back_to_25px.png"))); // NOI18N
        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_kembali)
                .addGap(139, 139, 139)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btn_kembali))
                .addGap(13, 13, 13))
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_identification_documents_25px.png"))); // NOI18N
        jLabel2.setText("ID Transaksi");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_product_25px.png"))); // NOI18N
        jLabel4.setText("Nama Barang");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_account_25px.png"))); // NOI18N
        jLabel5.setText("Jumlah");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_male_user_25px.png"))); // NOI18N
        jLabel3.setText("Nama Karyawan");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("TOTAL BAYAR : Rp.");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_price_25px.png"))); // NOI18N
        jLabel6.setText("Harga");

        txt_total_harga.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        btn_hitung.setText("Hitung");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_age_25px.png"))); // NOI18N
        jLabel8.setText("Tanggal Transaksi");

        txt_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalActionPerformed(evt);
            }
        });

        txt_nama_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_karyawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(78, 78, 78))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(73, 73, 73)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nama_barang)
                            .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tanggal)
                            .addComponent(txt_nama_karyawan, 0, 225, Short.MAX_VALUE)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_hitung, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(txt_harga)
                            .addComponent(txt_jumlah)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hitung)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txt_total_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_transaksi.setAutoCreateRowSorter(true);
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Nama Karyawan", "Tanggal", "Nama Barang", "Jumlah", "Harga", "Total Harga"
            }
        ));
        tbl_transaksi.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setRowHeight(25);
        tbl_transaksi.setRowMargin(5);
        tbl_transaksi.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        txt_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_25px.png"))); // NOI18N
        txt_ubah.setText("Ubah");
        txt_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_delete_25px.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        txt_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_25px.png"))); // NOI18N
        txt_tambah.setText("Tambah");
        txt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tambahActionPerformed(evt);
            }
        });

        txt_cetak_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_print_25px.png"))); // NOI18N
        txt_cetak_laporan.setText("Cetak Laporan");
        txt_cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cetak_laporanActionPerformed(evt);
            }
        });

        txt_keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_keywordKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_25px.png"))); // NOI18N
        jLabel9.setText("Cari Data");

        txt_Baru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_restart_25px.png"))); // NOI18N
        txt_Baru.setText("Baru");
        txt_Baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BaruActionPerformed(evt);
            }
        });

        jButton1.setText("Nota");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cetak_laporan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_ubah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Baru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cetak_laporan)
                            .addComponent(txt_tambah)
                            .addComponent(txt_ubah)
                            .addComponent(btn_hapus)
                            .addComponent(txt_Baru))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // memfungsikan button kembali
        new FormKaryawan().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        // TODO add your handling code here:
        getTotal();
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void txt_keywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_keywordKeyReleased
        // memfungsikan texfield cari 
        DefaultTableModel table = (DefaultTableModel) tbl_transaksi.getModel();
        String search = txt_keyword.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tbl_transaksi.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_txt_keywordKeyReleased

    private void txt_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalActionPerformed

    private void txt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tambahActionPerformed
        // memfungsikan button tambah
        String karyawanItem = txt_nama_karyawan.getSelectedItem().toString();
        String karyawan = karyawanItem.split("\\)", 2)[0];
        //bagian masukkan data ke dalam database
        try {
            Connection con = KoneksiHelper.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO transaksi (id_transaksi, nama_karyawan, tanggal, nama_barang, jumlah, harga, total_harga) VALUES(?,?,?,?,?,?,?)");
            //validasi ketika textField kosong

            if (txt_id_transaksi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Id tidak boleh kosong");
            } else if (txt_tanggal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tanggal tidak boleh kosong");
            } else if (txt_nama_barang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Barang tidak boleh kosong");
            } else if (txt_jumlah.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            } else if (txt_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga tidak boleh kosong");
            } else if (txt_total_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Total tidak boleh kosong");
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield

                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, txt_id_transaksi.getText());
                pst.setString(2, txt_nama_karyawan.getSelectedItem().toString());
                pst.setString(3, txt_tanggal.getText());
                pst.setString(4, txt_nama_barang.getText());
                pst.setString(5, txt_jumlah.getText());
                pst.setString(6, txt_harga.getText());
                pst.setString(7, txt_total_harga.getText());
                pst.executeUpdate();

                //setelah nginput data kasih ini biar textfieldnya kosong lagi
                txt_id_transaksi.setText("");
                txt_nama_karyawan.setSelectedItem("");
                txt_tanggal.setText("");
                txt_nama_barang.setText("");
                txt_jumlah.setText("");
                txt_harga.setText("");
                txt_total_harga.setText("");

                //setelah berhasil
                JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
            }

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_tambahActionPerformed

    private void txt_BaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BaruActionPerformed
        // memfungsikan button baru
        DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
        model.setRowCount(0);
        fetchData();
    }//GEN-LAST:event_txt_BaruActionPerformed

    private void txt_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ubahActionPerformed
        // memfungsikan button ubah atau edit
        String karyawanItem = txt_nama_karyawan.getSelectedItem().toString();
        String karyawan = karyawanItem.split("\\)", 2)[0];
        try {

            Connection con = KoneksiHelper.getConnection();
            int row = tbl_transaksi.getSelectedRow();
            String value = (tbl_transaksi.getModel().getValueAt(row, 0).toString());
            String sql = "UPDATE transaksi SET id_transaksi=?,nama_karyawan=?,tanggal=?,nama_barang=?,jumlah=?,harga=?,total_harga=? WHERE id_transaksi = " + value;
            if (txt_id_transaksi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Id tidak boleh kosong");
            } else if (txt_tanggal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tanggal tidak boleh kosong");
            } else if (txt_nama_barang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Barang tidak boleh kosong");
            } else if (txt_jumlah.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            } else if (txt_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga tidak boleh kosong");
            } else if (txt_total_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Total tidak boleh kosong");
            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, txt_id_transaksi.getText());
                pst.setString(2, txt_nama_karyawan.getSelectedItem().toString());
                pst.setString(3, txt_tanggal.getText());
                pst.setString(4, txt_nama_barang.getText());
                pst.setString(5, txt_jumlah.getText());
                pst.setString(6, txt_harga.getText());
                pst.setString(7, txt_total_harga.getText());
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
                model.setRowCount(0);
                fetchData();
                txt_id_transaksi.setText("");
                txt_nama_karyawan.setSelectedItem("");
                txt_tanggal.setText("");
                txt_nama_barang.setText("");
                txt_jumlah.setText("");
                txt_harga.setText("");
                txt_total_harga.setText("");
                JOptionPane.showMessageDialog(null, "Update Selesai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_txt_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // memfungsikan button hapus

        try {

            int row = tbl_transaksi.getSelectedRow();
            Connection con = KoneksiHelper.getConnection();
            String value = (tbl_transaksi.getModel().getValueAt(row, 0).toString());
            String sql = "DELETE FROM transaksi WHERE id_transaksi = '" + value + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tbl_transaksi.getModel();
            model.setRowCount(0);
            fetchData();
            JOptionPane.showMessageDialog(null, "Data terhapus");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // memfungsikan click mouse pada tabel transaksi

        int i = tbl_transaksi.getSelectedRow();
        TableModel model = tbl_transaksi.getModel();
        txt_id_transaksi.setText(model.getValueAt(i, 0).toString());

        txt_tanggal.setText(model.getValueAt(i, 2).toString());
        txt_nama_barang.setText(model.getValueAt(i, 3).toString());
        txt_jumlah.setText(model.getValueAt(i, 4).toString());
        txt_harga.setText(model.getValueAt(i, 5).toString());
        txt_total_harga.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void txt_cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cetak_laporanActionPerformed
        // memfungsikan button cetak laporan
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("..\\ireport\\ReportTransaksi.jasper"), null, KoneksiHelper.getConnection());
        JasperViewer.viewReport(jp, false);
        } catch(SQLException | JRException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txt_cetak_laporanActionPerformed

    private void txt_nama_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_karyawanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // buuton cetak nota
        new CetakNota().show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormTransaksi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JButton txt_Baru;
    private javax.swing.JButton txt_cetak_laporan;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id_transaksi;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_keyword;
    private javax.swing.JTextField txt_nama_barang;
    private javax.swing.JComboBox<String> txt_nama_karyawan;
    private javax.swing.JButton txt_tambah;
    private javax.swing.JTextField txt_tanggal;
    private javax.swing.JLabel txt_total_harga;
    private javax.swing.JButton txt_ubah;
    // End of variables declaration//GEN-END:variables
}