/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author tasos
 */
public class home extends javax.swing.JFrame {
dbConnect con=null;
    /**
     * Creates new form home
     */
    public home() {
         this.con=new dbConnect();
        initComponents();
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
        search_btn = new javax.swing.JButton();
        search_txt = new javax.swing.JTextField();
        class_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        students_btn = new javax.swing.JButton();
        inner = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        search_btn.setText("Aναζήτηση");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        search_txt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        search_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_txtActionPerformed(evt);
            }
        });
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_txtKeyPressed(evt);
            }
        });

        class_btn.setText("Τα Tμήματά μου");
        class_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_btnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        students_btn.setText("Οι Μαθητές μου");
        students_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                students_btnActionPerformed(evt);
            }
        });

        inner.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout innerLayout = new javax.swing.GroupLayout(inner);
        inner.setLayout(innerLayout);
        innerLayout.setHorizontalGroup(
            innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        innerLayout.setVerticalGroup(
            innerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(search_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(class_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(students_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(class_btn)
                            .addGap(43, 43, 43)
                            .addComponent(students_btn)))
                    .addComponent(inner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jMenu1.setText("Εφαρμογή");

        jMenuItem2.setText("Επαναφορά");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
       System.out.println("mpika");
            Students st=new Students("",true,search_txt.getText());
            st.show();
    }//GEN-LAST:event_search_btnActionPerformed

    private void class_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_btnActionPerformed
    try {
         inner.removeAll();
        Vector<String>class_names =con.getAllClass();
        if(!class_names.isEmpty()){
            int i=0;
           
           while(class_names.size()>i){
                JButton btn=new JButton(class_names.get(i));
                btn.setSize(80, 70);
                btn.setLocation(i*90, 10);
                i++;
                btn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       classShow st=new classShow(btn.getText(),class_btn);
                       st.show();
                       
                    }
                    
                });
                
                
                inner.add(btn);
           }
       }
    } catch (SQLException ex) {
        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }
       
      
        JButton add=new JButton("Προσθήκη");
        add.setLocation(600,400);
         add.setSize(150, 50);
         add.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
               String class_name=JOptionPane.showInputDialog(rootPane, "Εισάγετε το όνομα του τμήματος");
               if(class_name!=null){
               if(class_name.equals("") ){
                   JOptionPane.showMessageDialog(null,"Το όνομα δε μπορεί να είναι κενό!");
               }else try {
                   if(con.class_exists(class_name)){
                        JOptionPane.showMessageDialog(null, "Το τμήμα αυτό υπάρχει ήδη");
                   }else{
                       con.create_class(class_name);
                        JOptionPane.showMessageDialog(null, "Το τμήμα καταχωρήθηκε");
                        class_btn.doClick();
      
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
               }
                   
               }
             }

           
         });
         
         
         
     
        inner.add(add);
        inner.revalidate();
        inner.repaint();
       
    }//GEN-LAST:event_class_btnActionPerformed

    private void students_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_students_btnActionPerformed
            Students st=new Students("all",false,"");
            st.show();
    }//GEN-LAST:event_students_btnActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jPanel1FocusGained

    private void search_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10){
              Students st=new Students("all",false,"");
            st.show();
         }
    }//GEN-LAST:event_search_txtKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    try {
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(
    null,
    "Επαναφορά ρυθμίσεων στις αρχικές;;",
    "Επαναφορά Εφαρμογής",
    JOptionPane.YES_NO_OPTION);
      if(n==0){
        new dbConnect().emptyDatabase();
        JOptionPane.showMessageDialog(null, "Ολοκληρώθηκε");
       System.exit(0);
      }
        
    } catch (SQLException ex) {
        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton class_btn;
    private javax.swing.JPanel inner;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_txt;
    private javax.swing.JButton students_btn;
    // End of variables declaration//GEN-END:variables
}
