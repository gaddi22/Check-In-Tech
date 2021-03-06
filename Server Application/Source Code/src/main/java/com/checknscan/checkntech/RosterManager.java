/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checknscan.checkntech;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;

/**
 * @author Alexander Duncan
 */
public class RosterManager extends javax.swing.JFrame {

    private static javax.swing.JScrollPane rosterScrollPane1;
    private static javax.swing.JTable rosterMainTable;
    private String[][] roster = new String[][]{};
    private javax.swing.JPanel addUpdateMemberPanel;
    private javax.swing.JButton addUpdateUserButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JPanel headerRosterManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JButton manageEventsButton;
    private javax.swing.JButton manageRosterEvents;
    private javax.swing.JTextField memberFirstNameField;
    private javax.swing.JTextField memberLastNameField;
    private javax.swing.JLabel memberLastNameLabel;
    private javax.swing.JLabel memberfirstNameLabel;
    private javax.swing.JPanel navigationBar;
    private javax.swing.JLabel rosterManageTitle;
    private javax.swing.JLabel rosterMemberLabel;
    private javax.swing.JPanel rosterMemberTitle;
    private javax.swing.JPanel rosterUpdaterHeader;
    private javax.swing.JLabel rosterUpdaterLabel;
    private javax.swing.JButton userDashboardButton;
    /**
     * Creates new form RosterManager
     */
    public RosterManager() {
        initComponents();
    }

    private static void loadRosterTable() {
        Object[][] rosTable = new String[][]{};
        try {
            String[][] roster = EventManager.treeToArray(DBConnector.getAllAttendees());
            rosTable = new Object[roster.length][roster[0].length];
            for (int i = 0; i < rosTable.length; i++) {
                rosTable[i][0] = roster[i][0];
                rosTable[i][1] = roster[i][1];
                rosTable[i][2] = roster[i][2];
            }
        } catch (Exception e) {
        }
        ;

        rosterMainTable = new javax.swing.JTable();
        rosterMainTable.setAutoCreateRowSorter(true);
        rosterMainTable.setModel(new javax.swing.table.DefaultTableModel(
                rosTable, new String[]{"ID", "Last Name", "First Name"}
        ) {
            Class[] types = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        rosterMainTable.setToolTipText("Roster members.");
        rosterMainTable.setAutoscrolls(false);
        rosterMainTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rosterMainTable.setShowGrid(true);
        rosterScrollPane1.setViewportView(rosterMainTable);
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
            java.util.logging.Logger.getLogger(RosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RosterManager().setVisible(true);
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

        headerRosterManager = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        rosterManageTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rosterMemberTitle = new javax.swing.JPanel();
        rosterMemberLabel = new javax.swing.JLabel();
        rosterScrollPane1 = new javax.swing.JScrollPane();

        try {
            roster = EventManager.treeToArray(DBConnector.getAllAttendees());
            /*for(Map.Entry row : DBConnector.getAllAttendees().entrySet())
            {
                System.out.println((String)row.getKey() + Arrays.toString((String[])row.getValue()));
            }*/
        } catch (Exception e) {
            roster = new String[][]{};
        }
       /* Object [][] rosterTable = new String [][]{};

        System.out.print(roster.length);

        if(roster.length != 0) {
            rosterTable = new String [roster.length][roster[0].length];
            for (int i = 0; i < rosterTable.length; i++) {
                for (int j = 0; j < rosterTable[0].length; j++) {
                    if (j < roster[0].length)
                        rosterTable[i][j] = roster[i][j];
                    System.out.println("hola");
                }
            }
        }
        System.out.print(roster.length);*/
        loadRosterTable();

        addUpdateMemberPanel = new javax.swing.JPanel();
        rosterUpdaterHeader = new javax.swing.JPanel();
        rosterUpdaterLabel = new javax.swing.JLabel();
        memberLastNameLabel = new javax.swing.JLabel();
        memberLastNameField = new javax.swing.JTextField();
        memberfirstNameLabel = new javax.swing.JLabel();
        memberFirstNameField = new javax.swing.JTextField();
        addUpdateUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        navigationBar = new javax.swing.JPanel();
        manageEventsButton = new javax.swing.JButton();
        manageAccountsButton = new javax.swing.JButton();
        manageRosterEvents = new javax.swing.JButton();
        userDashboardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        setTitle("Check N Tech");
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 640, Short.MAX_VALUE)
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
                                .addContainerGap(260, Short.MAX_VALUE)
                                .addComponent(rosterMemberLabel)
                                .addContainerGap(260, Short.MAX_VALUE))
        );
        rosterMemberTitleLayout.setVerticalGroup(
                rosterMemberTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rosterMemberTitleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rosterMemberLabel)
                                .addContainerGap())
        );

        rosterMainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rosterTableMouseClicked(evt);
            }
        });

        /*javax.swing.JTable rosterMainTable = new JTable();
        rosterMainTable.setModel(new javax.swing.table.DefaultTableModel(
                rosterTable,
                new String[]{ "ID", "Last Name", "First Name" }
        ) {
            Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });*/
        rosterScrollPane1.setViewportView(rosterMainTable);

        addUpdateMemberPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rosterUpdaterHeader.setBackground(new java.awt.Color(255, 102, 51));
        rosterUpdaterHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rosterUpdaterHeader.setPreferredSize(new java.awt.Dimension(350, 45));

        rosterUpdaterLabel.setFont(rosterUpdaterLabel.getFont().deriveFont(rosterUpdaterLabel.getFont().getStyle() | java.awt.Font.BOLD, rosterUpdaterLabel.getFont().getSize() + 8));
        rosterUpdaterLabel.setForeground(new java.awt.Color(255, 255, 255));
        rosterUpdaterLabel.setText("Add / Update Member");

        javax.swing.GroupLayout rosterUpdaterHeaderLayout = new javax.swing.GroupLayout(rosterUpdaterHeader);
        rosterUpdaterHeader.setLayout(rosterUpdaterHeaderLayout);
        rosterUpdaterHeaderLayout.setHorizontalGroup(
                rosterUpdaterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rosterUpdaterHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rosterUpdaterLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rosterUpdaterHeaderLayout.setVerticalGroup(
                rosterUpdaterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rosterUpdaterHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rosterUpdaterLabel)
                                .addContainerGap())
        );

        // First name and last name variables switched. Last = first and vise versa.
        memberfirstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        memberfirstNameLabel.setText("Last Name:");

        memberFirstNameField.setToolTipText("Member's last name.");

        memberLastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        memberLastNameLabel.setText("First Name:");

        memberFirstNameField.setToolTipText("Member's first name.");

        addUpdateUserButton.setText("Add / Update");
        addUpdateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setText("Delete");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUpdateMemberPanelLayout = new javax.swing.GroupLayout(addUpdateMemberPanel);
        addUpdateMemberPanel.setLayout(addUpdateMemberPanelLayout);
        addUpdateMemberPanelLayout.setHorizontalGroup(
                addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rosterUpdaterHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addGroup(addUpdateMemberPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addUpdateMemberPanelLayout.createSequentialGroup()
                                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(memberfirstNameLabel)
                                                        .addComponent(memberLastNameLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(memberFirstNameField)
                                                        .addComponent(memberLastNameField))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUpdateMemberPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(deleteUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(addUpdateMemberPanelLayout.createSequentialGroup()
                                                                .addComponent(addUpdateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(9, 9, 9))))
        );
        addUpdateMemberPanelLayout.setVerticalGroup(
                addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addUpdateMemberPanelLayout.createSequentialGroup()
                                .addComponent(rosterUpdaterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(memberLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(memberLastNameLabel))
                                .addGap(21, 21, 21)
                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(memberfirstNameLabel)
                                        .addComponent(memberFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(addUpdateMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addUpdateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rosterMemberTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rosterScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addUpdateMemberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rosterMemberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rosterScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(addUpdateMemberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addContainerGap(363, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerRosterManager, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
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
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Logs the user out. Returns to the HomePage.
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Opens the Event Manager.
    private void manageEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEventsButtonActionPerformed
        new EventManager().setVisible(true);
        this.setVisible(false);
    }

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

    // Opens the user Dashboard.
    private void userDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDashboardButtonActionPerformed
        new AdminDashboard().setVisible(true);
        this.setVisible(false);
    }

    // Add / updates the selected member.
    private void addUpdateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateUserButtonActionPerformed
        int index = rosterMainTable.getSelectedRow();
        if (index == -1)
            DBConnector.createAttendee(memberFirstNameField.getText(), memberLastNameField.getText());
        else {
            DBConnector.updateAttendeeInfo(rosterMainTable.getValueAt(index, 0).toString(), memberFirstNameField.getText(), memberLastNameField.getText());
        }
        new RosterManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addUpdateUserButtonActionPerformed

    // Clear the current addUpdateMemberPane.
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(rosterMainTable.getSelectedRow() != -1)
            rosterMainTable.removeRowSelectionInterval(0,rosterMainTable.getRowCount()-1); // Needs to be tested.
        memberLastNameField.setText("");
        memberFirstNameField.setText("");
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Delete the selected member.
    private void deleteUserButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        int index = rosterMainTable.getSelectedRow();
        if (index != -1) {
            // javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected member?");
            DBConnector.deleteAttendee(roster[index][0]);
            new RosterManager().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void rosterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountsTableMouseClicked
        TableModel model = (DefaultTableModel) rosterMainTable.getModel();
        int index = rosterMainTable.getSelectedRow();
        Object[] selectedRow = new Object[3];
        //for (int i = 0; i < index.length; i++) {
            selectedRow[0] = model.getValueAt(index, 0);
            selectedRow[1] = model.getValueAt(index, 1);
            selectedRow[2] = model.getValueAt(index, 2);
        //}

        memberLastNameField.setText(selectedRow[2].toString());
        memberFirstNameField.setText(selectedRow[1].toString());
    }//GEN-LAST:event_accountsTableMouseClicked
}
