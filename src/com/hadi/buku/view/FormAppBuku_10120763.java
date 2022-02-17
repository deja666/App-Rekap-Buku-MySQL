/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hadi.buku.view;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;





/** 
 * 
 *
 * @author JATINET
 */
public final class FormAppBuku_10120763 extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = com.hadi.buku.Connection_10120763.Koneksi();
   
public class JTextFieldLimit extends PlainDocument {
  private int limit;

  JTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }

  @Override
  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}
  
    public FormAppBuku_10120763() {
        initComponents(); 
        judul();
        tampilData("");
        setLocationRelativeTo(null);
        this.setTitle("App Rekap Buku");
        setVisible(true);
        btnhapus.setEnabled(false);
        btnsave.setEnabled(false);
        kodetxt.setDocument(new JTextFieldLimit(3));
        thnterbittxt.setDocument(new JTextFieldLimit(4));
        /////
        kodetxt.addKeyListener(new KeyAdapter(){
           @Override
           public void keyTyped(KeyEvent e) {
             char c = e.getKeyChar();
             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                  e.consume(); 
             }
         } 
        });
        ////
        thnterbittxt.addKeyListener(new KeyAdapter(){
           @Override
           public void keyTyped(KeyEvent e) {
             char c = e.getKeyChar();
             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                  e.consume(); 
             }
         } 
        });
    }
    
    public void judul() {
  Object[] judul = {
    "Kode Buku", "Judul", "Penulis", "Tahun Terbit", "Genre"
  };
  tabModel = new DefaultTableModel(null, judul);
  tbAppBuku.setModel(tabModel);
}

    private void tampilData(String where) {
         try {
    st = cn.createStatement();
    tabModel.getDataVector().removeAllElements();
    tabModel.fireTableDataChanged();
    rs = st.executeQuery("SELECT * FROM buku " + where);
    kodetxt.setEditable(true);
    while (rs.next()) {
      Object[] data = {
        rs.getString("Kode_Buku"),
        rs.getString("Judul_Buku"),
        rs.getString("Penulis"),
        rs.getString("Tahun_Terbit"),
        rs.getString("Genre"),
      };
        
        tabModel.addRow(data);
    }
  } catch(SQLException e) {
}
    }
private void cariData(String key){
        try{
            Object[] judul = {
    "Kode Buku", "Judul", "Penulis", "Tahun Terbit", "Genre"
  };
            tabModel=new DefaultTableModel(null,judul);
              tbAppBuku.setModel(tabModel);
            
            st=cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            
            rs=st.executeQuery("SELECT * from buku WHERE Kode_Buku LIKE '%"+key+
                    "%' OR Judul_Buku LIKE '%"+key+
                    "%' OR Penulis LIKE '%"+key+
                    "%' OR Tahun_Terbit LIKE '%"+key+
                    "%' OR Genre LIKE '%"+key+"%'");  
            while(rs.next()){
                Object[] data = {
        rs.getString("Kode_Buku"),
        rs.getString("Judul_Buku"),
        rs.getString("Penulis"),
        rs.getString("Tahun_Terbit"),
        rs.getString("Genre"),
      };
               tabModel.addRow(data);
            }                
        } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        }
    }
    public void clear(){
        kodetxt.setText("");
        judultxt.setText("");
        penulistxt.setText("");
        thnterbittxt.setText("");
        genretxt.setSelectedItem("");
        caritxt.setText("");
        
    }
    public void UpdateFile(){
        try {
    st = cn.createStatement();
    st.executeUpdate("UPDATE buku set " 
        + "Judul_Buku='"      + judultxt.getText() + "', "
        + "Penulis='"   + penulistxt.getText() + "', "
        + "Tahun_Terbit='"        + thnterbittxt.getText() + "', "
        + "Genre='"    + genretxt.getSelectedItem()+ "'"
        + "WHERE Kode_Buku='"+ kodetxt.getText()+ "'");
    tampilData("");
    JOptionPane.showMessageDialog(null, "Update Berhasil");
    clear();
  } catch (HeadlessException | SQLException e) {  
  }       
    }
    public void saveOrUpdate(){
        if (btnsimpan.getText().equals("SAVE")) {    
           try {
    st = cn.createStatement();
    st.executeUpdate("INSERT INTO buku VALUES('" + kodetxt.getText() + "','"+ judultxt.getText() + "','"+ penulistxt.getText() + "','"+ thnterbittxt.getText() + "','"+ genretxt.getSelectedItem()+ "')");
    tampilData("");
    JOptionPane.showMessageDialog(null, "Simpan Berhasil");
    kodetxt.setText("");
    judultxt.setText("");
    penulistxt.setText("");
    thnterbittxt.setText("");
    genretxt.setSelectedItem("");
  } catch (HeadlessException | SQLException e) {
  }     
        }
        else {
                    try{
                    UpdateFile();
                    tampilData("");
                    clear();
                    }catch (Exception e) {
                   }
                }
            }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        kodetxt = new javax.swing.JTextField();
        judultxt = new javax.swing.JTextField();
        penulistxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        btnrefresh = new javax.swing.JLabel();
        btndelete = new keeptoo.KGradientPanel();
        btnhapus = new javax.swing.JLabel();
        btnsave = new keeptoo.KGradientPanel();
        btnsimpan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAppBuku = new javax.swing.JTable();
        thnterbittxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        caritxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        genretxt = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setEndColor(new java.awt.Color(209, 107, 165));
        kGradientPanel1.setGradientFocus(600);
        kGradientPanel1.setStartColor(new java.awt.Color(95, 251, 241));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        kodetxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kodetxt.setForeground(new java.awt.Color(102, 102, 102));
        kodetxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        kodetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        judultxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        judultxt.setForeground(new java.awt.Color(102, 102, 102));
        judultxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        judultxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judultxtActionPerformed(evt);
            }
        });

        penulistxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        penulistxt.setForeground(new java.awt.Color(102, 102, 102));
        penulistxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        penulistxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penulistxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("KODE BUKU");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("JUDUL BUKU");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("PENULIS");

        kGradientPanel2.setEndColor(new java.awt.Color(185, 19, 98));
        kGradientPanel2.setGradientFocus(200);
        kGradientPanel2.setStartColor(new java.awt.Color(90, 17, 157));

        btnrefresh.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnrefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnrefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnrefresh.setText("REFRESH");
        btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrefreshMouseClicked(evt);
            }
        });
        kGradientPanel2.add(btnrefresh);
        btnrefresh.setBounds(0, 0, 260, 40);

        btndelete.setEndColor(new java.awt.Color(51, 147, 209));
        btndelete.setGradientFocus(200);
        btndelete.setStartColor(new java.awt.Color(235, 42, 42));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });

        btnhapus.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnhapus.setText("DELETE");
        btnhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapusMouseClicked(evt);
            }
        });
        btndelete.add(btnhapus);
        btnhapus.setBounds(0, 0, 250, 40);

        btnsave.setEndColor(new java.awt.Color(12, 91, 160));
        btnsave.setGradientFocus(200);
        btnsave.setStartColor(new java.awt.Color(153, 0, 153));
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsaveMouseClicked(evt);
            }
        });

        btnsimpan.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnsimpan.setText("SAVE");
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpanMouseClicked(evt);
            }
        });
        btnsave.add(btnsimpan);
        btnsimpan.setBounds(0, 0, 250, 40);

        tbAppBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul", "Penulis", "Tahun Terbit", "Genre"
            }
        ));
        tbAppBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAppBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAppBuku);

        thnterbittxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thnterbittxt.setForeground(new java.awt.Color(102, 102, 102));
        thnterbittxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        thnterbittxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thnterbittxtActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("TAHUN TERBIT");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("DAFTAR BUKU");

        caritxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        caritxt.setForeground(new java.awt.Color(102, 102, 102));
        caritxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        caritxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caritxtActionPerformed(evt);
            }
        });
        caritxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caritxtKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("SEARCH");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("GENRE");

        genretxt.setBackground(new java.awt.Color(0, 204, 204));
        genretxt.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        genretxt.setForeground(new java.awt.Color(0, 153, 153));
        genretxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendidikan", "Sejarah", "Novel", "Fiksi", "Komik" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(penulistxt, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(judultxt)
                                    .addComponent(kodetxt)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(thnterbittxt, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(genretxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(caritxt, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel4)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(kodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(judultxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penulistxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thnterbittxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(caritxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(genretxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        kGradientPanel1.add(jPanel1);
        jPanel1.setBounds(410, 90, 840, 510);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(47, 157, 175));
        jLabel8.setText("by.Hadi Pranata Jati");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kGradientPanel1.add(jLabel8);
        jLabel8.setBounds(120, 200, 180, 40);

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(209, 107, 165));
        jLabel11.setText("APP BUKU");
        kGradientPanel1.add(jLabel11);
        jLabel11.setBounds(120, 170, 200, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hadi/buku/lp.png"))); // NOI18N
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(-30, 140, 650, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caritxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caritxtKeyReleased

        String text = caritxt.getText();

        if (text!="") {
            cariData(text);
        } else {
            tampilData("(?i)");
            clear();
        }
    }//GEN-LAST:event_caritxtKeyReleased

    private void caritxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caritxtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_caritxtActionPerformed

    private void thnterbittxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thnterbittxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thnterbittxtActionPerformed

    private void tbAppBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAppBukuMouseClicked
        int click = tbAppBuku.rowAtPoint(evt.getPoint());
        kodetxt.setText(tbAppBuku.getModel().getValueAt(click, 0).toString());
        kodetxt.setEditable(false);
        judultxt.setText((String) tbAppBuku.getModel().getValueAt(click, 1));
        penulistxt.setText((String) tbAppBuku.getModel().getValueAt(click, 2));
        thnterbittxt.setText(tbAppBuku.getModel().getValueAt(click, 3).toString());
        genretxt.setSelectedItem((String)tbAppBuku.getModel().getValueAt(click, 4).toString());
        btnsimpan.setText("UPDATE");
        btnhapus.setEnabled(true);
    }//GEN-LAST:event_tbAppBukuMouseClicked

    private void btnsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsaveMouseClicked

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked
        if (kodetxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Kode Buku mohon diisi");
            kodetxt.requestFocus();
        }else if (judultxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Judul Buku mohon diisi");
            judultxt.requestFocus();
        }else if (penulistxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama Penulis mohon diisi");
            penulistxt.requestFocus();
        }else if (thnterbittxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Tahun Terbit mohon diisi");
            thnterbittxt.requestFocus();
        }else if (genretxt.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null,"Tahun Terbit mohon diisi");
            thnterbittxt.requestFocus();
        }else{
            saveOrUpdate();
        }
    }//GEN-LAST:event_btnsimpanMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked

    }//GEN-LAST:event_btndeleteMouseClicked

    private void btnhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseClicked

        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM buku WHERE Kode_Buku='"
                    + tabModel.getValueAt(tbAppBuku.getSelectedRow(), 0) + "'");
                tampilData("");
                btnhapus.setEnabled(false);
                btnsimpan.setText("SAVE");
                clear();
            }
        } catch (HeadlessException | SQLException e) {
    }//GEN-LAST:event_btnhapusMouseClicked
    }
    private void btnrefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrefreshMouseClicked

        clear();
        btnhapus.setEnabled(false);
        btnsimpan.setText("SAVE");
        tampilData("");

    }//GEN-LAST:event_btnrefreshMouseClicked

    private void penulistxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penulistxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penulistxtActionPerformed

    private void judultxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judultxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judultxtActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed


  
    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAppBuku_10120763.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormAppBuku_10120763().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel btndelete;
    private javax.swing.JLabel btnhapus;
    private javax.swing.JLabel btnrefresh;
    private keeptoo.KGradientPanel btnsave;
    private javax.swing.JLabel btnsimpan;
    private javax.swing.JTextField caritxt;
    private javax.swing.JComboBox<String> genretxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judultxt;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField kodetxt;
    private javax.swing.JTextField penulistxt;
    public javax.swing.JTable tbAppBuku;
    private javax.swing.JTextField thnterbittxt;
    // End of variables declaration//GEN-END:variables


  
}