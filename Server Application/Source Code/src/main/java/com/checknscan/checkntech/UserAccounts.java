/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checknscan.checkntech;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Alexander Duncan
 */
public class UserAccounts extends javax.swing.JFrame {

    protected javax.swing.JPanel navigationBar;
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel accountDetailsLabel;
    private javax.swing.JPanel accountDetailsPanel;
    private javax.swing.JPanel accountsDetailsHeader;
    private javax.swing.JScrollPane accountsScrollTable;
    private javax.swing.JTable accountsTable;
    private javax.swing.JButton addUpdateButton;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JPanel headerEditUserAccounts;
    private javax.swing.JTextField idNumberField;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JButton manageEventsButton;
    private javax.swing.JButton manageRosterEvents;
    private javax.swing.JLabel registeredAccountsLabel;
    private javax.swing.JPanel registeredAccountsPanel;
    private javax.swing.JPanel registeredAccountsTitlePanel;
    private javax.swing.JLabel tempPassLabel;
    private javax.swing.JPasswordField tempPasswordField;
    private javax.swing.JLabel userAccountsTitle;
    private javax.swing.JButton userDashboardButton;
    /**
     * Creates new form UserAccounts
     */
    public UserAccounts() {
        initComponents();
    }

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
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccounts().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerEditUserAccounts = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        userAccountsTitle = new javax.swing.JLabel();
        registeredAccountsPanel = new javax.swing.JPanel();
        registeredAccountsTitlePanel = new javax.swing.JPanel();
        registeredAccountsLabel = new javax.swing.JLabel();
        accountsScrollTable = new javax.swing.JScrollPane();
        Object[][] accountTable = new Object[][]{};
        String[][] accounts = EventManager.treeToArray(DBConnector.getAllEventOwners());

        if (accounts.length != 0) {
            accountTable = new Object[accounts.length][accounts[0].length]; // Initialize

            for (int i = 0; i < accountTable.length; i++) {
                for (int j = 0; j < accountTable[0].length; j++) {
                    if (j < accounts[0].length)
                        accountTable[i][j] = accounts[i][j];
                }
            }
        }
        accountsTable = new javax.swing.JTable();
        accountDetailsPanel = new javax.swing.JPanel();
        accountsDetailsHeader = new javax.swing.JPanel();
        accountDetailsLabel = new javax.swing.JLabel();
        idNumberLabel = new javax.swing.JLabel();
        idNumberField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        tempPassLabel = new javax.swing.JLabel();
        tempPasswordField = new javax.swing.JPasswordField();
        addUpdateButton = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        navigationBar = new javax.swing.JPanel();
        manageEventsButton = new javax.swing.JButton();
        manageAccountsButton = new javax.swing.JButton();
        manageRosterEvents = new javax.swing.JButton();
        userDashboardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Check N Tech");
        headerEditUserAccounts.setBackground(new java.awt.Color(255, 102, 51));
        headerEditUserAccounts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headerEditUserAccounts.setPreferredSize(new java.awt.Dimension(2, 65));

        logoutButton.setText("Logout");
        logoutButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        userAccountsTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userAccountsTitle.setForeground(new java.awt.Color(255, 255, 255));
        userAccountsTitle.setText("Create / Update Registered Accounts");

        javax.swing.GroupLayout headerEditUserAccountsLayout = new javax.swing.GroupLayout(headerEditUserAccounts);
        headerEditUserAccounts.setLayout(headerEditUserAccountsLayout);
        headerEditUserAccountsLayout.setHorizontalGroup(
                headerEditUserAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerEditUserAccountsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(userAccountsTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        headerEditUserAccountsLayout.setVerticalGroup(
                headerEditUserAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerEditUserAccountsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headerEditUserAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userAccountsTitle)
                                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registeredAccountsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        registeredAccountsTitlePanel.setBackground(new java.awt.Color(255, 102, 51));
        registeredAccountsTitlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        registeredAccountsTitlePanel.setPreferredSize(new java.awt.Dimension(339, 50));

        registeredAccountsLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        registeredAccountsLabel.setForeground(new java.awt.Color(255, 255, 255));
        registeredAccountsLabel.setText("Registered Accounts");

        javax.swing.GroupLayout registeredAccountsTitlePanelLayout = new javax.swing.GroupLayout(registeredAccountsTitlePanel);
        registeredAccountsTitlePanel.setLayout(registeredAccountsTitlePanelLayout);
        registeredAccountsTitlePanelLayout.setHorizontalGroup(
                registeredAccountsTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registeredAccountsTitlePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(registeredAccountsLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registeredAccountsTitlePanelLayout.setVerticalGroup(
                registeredAccountsTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registeredAccountsTitlePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(registeredAccountsLabel)
                                .addContainerGap())
        );

        accountsScrollTable.setBackground(new java.awt.Color(255, 255, 255));

        accountsTable.setAutoCreateRowSorter(true);
        accountsTable.setModel(new javax.swing.table.DefaultTableModel(
                accountTable,
                new String[]{
                        "User ID", "Last Name", "First Name"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        accountsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountsTableMouseClicked(evt);
            }
        });
        accountsScrollTable.setViewportView(accountsTable);

        accountDetailsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        accountDetailsPanel.setPreferredSize(new java.awt.Dimension(267, 274));
        accountDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountsDetailsHeader.setBackground(new java.awt.Color(255, 102, 51));
        accountsDetailsHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accountDetailsLabel.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        accountDetailsLabel.setForeground(new java.awt.Color(255, 255, 255));
        accountDetailsLabel.setText("New / Modify User");

        javax.swing.GroupLayout accountsDetailsHeaderLayout = new javax.swing.GroupLayout(accountsDetailsHeader);
        accountsDetailsHeader.setLayout(accountsDetailsHeaderLayout);
        accountsDetailsHeaderLayout.setHorizontalGroup(
                accountsDetailsHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountsDetailsHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accountDetailsLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accountsDetailsHeaderLayout.setVerticalGroup(
                accountsDetailsHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(accountsDetailsHeaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(accountDetailsLabel)
                                .addContainerGap())
        );

        accountDetailsPanel.add(accountsDetailsHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 265, -1));

        idNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idNumberLabel.setText("ID Number: ");
        idNumberField.setFocusable(false);
        idNumberField.setBackground(new java.awt.Color(213, 216, 222));
        // idNumberField.setClickable(false);
        accountDetailsPanel.add(idNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 74, -1, -1));
        accountDetailsPanel.add(idNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 72, 152, -1));

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameLabel.setText("Last Name:");
        accountDetailsPanel.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 150, -1, -1));
        accountDetailsPanel.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 148, 152, -1));

        firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name:");
        accountDetailsPanel.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 112, -1, -1));
        accountDetailsPanel.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 110, 152, -1));

        tempPassLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tempPassLabel.setText("Temporary Password:");
        accountDetailsPanel.add(tempPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 190, -1, -1));
        accountDetailsPanel.add(tempPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 186, 107, -1));

        addUpdateButton.setLabel("Add/Update");
        addUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateButtonActionPerformed(evt);
            }
        });
        accountDetailsPanel.add(addUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 242, 120, 40));

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        accountDetailsPanel.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 242, 120, 40));

        deleteAccountButton.setText("Delete");
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountButtonActionPerformed(evt);
            }
        });
        accountDetailsPanel.add(deleteAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 293, 246, 40));

        javax.swing.GroupLayout registeredAccountsPanelLayout = new javax.swing.GroupLayout(registeredAccountsPanel);
        registeredAccountsPanel.setLayout(registeredAccountsPanelLayout);
        registeredAccountsPanelLayout.setHorizontalGroup(
                registeredAccountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(registeredAccountsTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                        .addGroup(registeredAccountsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(accountsScrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        registeredAccountsPanelLayout.setVerticalGroup(
                registeredAccountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registeredAccountsPanelLayout.createSequentialGroup()
                                .addComponent(registeredAccountsTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registeredAccountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(accountsScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                        .addGroup(registeredAccountsPanelLayout.createSequentialGroup()
                                                .addComponent(accountDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
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

        manageAccountsButton.setText("Manage Accounts");
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

        userDashboardButton.setText("User Dashboard");
        userDashboardButton.setToolTipText("Return to dashboard.");
        userDashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDashboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigationBarLayout = new javax.swing.GroupLayout(navigationBar);
        navigationBar.setLayout(navigationBarLayout);
        navigationBarLayout.setHorizontalGroup(
                navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navigationBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(manageEventsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(manageRosterEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(manageAccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userDashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        navigationBarLayout.setVerticalGroup(
                navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navigationBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(userDashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manageAccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manageEventsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manageRosterEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerEditUserAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registeredAccountsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerEditUserAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(registeredAccountsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Logs the user out. Returns to HomePage.
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Adds new users to accountsTable.
    private void addUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateButtonActionPerformed
        int index = accountsTable.getSelectedRow();

        if (index == -1) {
            DBConnector.createEventOwner(firstNameField.getText(), lastNameField.getText(), tempPasswordField.getText());

        } else
            DBConnector.updateEventOwnerInfo(accountsTable.getValueAt(index, 0).toString(), firstNameField.getText(), lastNameField.getText(), tempPasswordField.getText());

        new UserAccounts().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addUpdateButtonActionPerformed

    // Opens the Event Manager.
    private void manageEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEventsButtonActionPerformed
        new EventManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageEventsButtonActionPerformed

    // Opens the Account Manager.
    private void manageAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsButtonActionPerformed
        new UserAccounts().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageAccountsButtonActionPerformed

    // Opens the Roster Manager.
    private void manageRosterEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRosterEventsActionPerformed
        new RosterManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageRosterEventsActionPerformed

    // Opens the User Dashboard.
    private void userDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDashboardButtonActionPerformed
        new AdminDashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_userDashboardButtonActionPerformed

    // Displays the selected row in the accountsTable to the accountDetailsPanel.
    private void accountsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountsTableMouseClicked
        TableModel model = (DefaultTableModel) accountsTable.getModel();
        int[] indexs = accountsTable.getSelectedRows();
        Object[] selectedRow = new Object[3];
        for (int i = 0; i < indexs.length; i++) {
            selectedRow[0] = model.getValueAt(indexs[i], 0);
            selectedRow[1] = model.getValueAt(indexs[i], 1);
            selectedRow[2] = model.getValueAt(indexs[i], 2);
        }

        idNumberField.setText(selectedRow[0].toString());
        lastNameField.setText(selectedRow[1].toString());
        firstNameField.setText(selectedRow[2].toString());
    }//GEN-LAST:event_accountsTableMouseClicked

    // Clears accountDetailsPanel.
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        if(accountsTable.getSelectedRow() != -1)
            accountsTable.removeRowSelectionInterval(0,accountsTable.getRowCount()-1); // Needs to be tested.
        idNumberField.setText("");
        lastNameField.setText("");
        firstNameField.setText("");
        tempPasswordField.setText("");
    }//GEN-LAST:event_CancelActionPerformed

    // Deletes a selected account.
    private void deleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountButtonActionPerformed
        int index = accountsTable.getSelectedRow();
        if (index != -1) {
            javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected account?");
            DBConnector.deleteEventOwner(accountsTable.getValueAt(index, 0).toString());
            new UserAccounts().setVisible(true);
            this.setVisible(false);
        } else
            javax.swing.JOptionPane.showMessageDialog(null, "An account must be selected.");

    }//GEN-LAST:event_deleteAccountButtonActionPerformed
    // End of variables declaration//GEN-END:variables
}