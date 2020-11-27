/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checknscan.checkntech;

/**
 *
 * @author Veteran
 */
public class rosterManager extends javax.swing.JFrame {

    /**
     * Creates new form RosterManager
     */
    public rosterManager() {
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

        headerRosterManager = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        rosterManageTitle = new javax.swing.JLabel();
        navigationBar = new javax.swing.JPanel();
        manageEventsButton = new javax.swing.JButton();
        manageAccountsButton = new javax.swing.JButton();
        manageRosterEvents = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rosterMemberTitle = new javax.swing.JPanel();
        rosterMemberLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerRosterManager.setBackground(new java.awt.Color(255, 102, 51));
        headerRosterManager.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headerRosterManager.setPreferredSize(new java.awt.Dimension(2, 65));

        logoutButton.setText("Logout");
        logoutButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        rosterManageTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        rosterManageTitle.setForeground(new java.awt.Color(255, 255, 255));
        rosterManageTitle.setText("Roster Manager");

        javax.swing.GroupLayout headerRosterManagerLayout = new javax.swing.GroupLayout(headerRosterManager);
        headerRosterManager.setLayout(headerRosterManagerLayout);
        headerRosterManagerLayout.setHorizontalGroup(
            headerRosterManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerRosterManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rosterManageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerRosterManagerLayout.setVerticalGroup(
            headerRosterManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerRosterManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerRosterManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rosterManageTitle)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        navigationBar.setBackground(new java.awt.Color(255, 255, 204));
        navigationBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        manageEventsButton.setText("Manage Events");
        manageEventsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEventsButtonActionPerformed(evt);
            }
        });

        manageAccountsButton.setText("User Dashboard");
        manageAccountsButton.setActionCommand("");
        manageAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountsButtonActionPerformed(evt);
            }
        });

        manageRosterEvents.setText("Manage Roster");
        manageRosterEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRosterEventsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigationBarLayout = new javax.swing.GroupLayout(navigationBar);
        navigationBar.setLayout(navigationBarLayout);
        navigationBarLayout.setHorizontalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageEventsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageAccountsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageRosterEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        navigationBarLayout.setVerticalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageEventsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageAccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageRosterEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rosterMemberTitle.setBackground(new java.awt.Color(255, 102, 51));
        rosterMemberTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rosterMemberLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        rosterMemberLabel.setForeground(new java.awt.Color(255, 255, 255));
        rosterMemberLabel.setText("All Roster Members");

        javax.swing.GroupLayout rosterMemberTitleLayout = new javax.swing.GroupLayout(rosterMemberTitle);
        rosterMemberTitle.setLayout(rosterMemberTitleLayout);
        rosterMemberTitleLayout.setHorizontalGroup(
            rosterMemberTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rosterMemberTitleLayout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(rosterMemberLabel)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        rosterMemberTitleLayout.setVerticalGroup(
            rosterMemberTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rosterMemberTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rosterMemberLabel)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Last Name", "First Name", "Email", "Phone Number", "Save", "Delete"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rosterMemberTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rosterMemberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerRosterManager, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerRosterManager, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        new homePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void manageAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsButtonActionPerformed
        // Opens Account Manager
        new userAccounts().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageAccountsButtonActionPerformed

    private void manageEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEventsButtonActionPerformed
        // Opens Event Manager Panel
        new eventManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageEventsButtonActionPerformed

    private void manageRosterEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRosterEventsActionPerformed
        // Opens Roster Manager
        new rosterManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageRosterEventsActionPerformed

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
            java.util.logging.Logger.getLogger(rosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rosterManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel headerRosterManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JButton manageEventsButton;
    private javax.swing.JButton manageRosterEvents;
    private javax.swing.JPanel navigationBar;
    private javax.swing.JLabel rosterManageTitle;
    private javax.swing.JLabel rosterMemberLabel;
    private javax.swing.JPanel rosterMemberTitle;
    // End of variables declaration//GEN-END:variables
}