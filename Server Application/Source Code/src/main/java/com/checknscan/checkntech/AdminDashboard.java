/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checknscan.checkntech;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Purpose is to create AdminDashboard for the Check N Tech Application.
 *
 * @author Alexander Duncan
 */
public class AdminDashboard extends javax.swing.JFrame {

    private static String selectedEventName = ""; // Used for the Event Roster Manager
    protected javax.swing.JPanel navigationBar;
    private String[][] events = new String[][]{};
    // Main variables used within the EventManager frame.
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField endTimeField;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JTable eventDashTable;
    private javax.swing.JPanel eventInfoHeader;
    private javax.swing.JLabel eventInfoTitle;
    private javax.swing.JPanel eventPrevPanel;
    private javax.swing.JPanel eventViewerPane;
    private javax.swing.JLabel eventViewerTitle;
    private javax.swing.JPanel headerBanner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JButton manageEventsButton;
    private javax.swing.JButton manageRosterEvents;
    private javax.swing.JButton modifyRosterButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField startTimeField;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JButton userDashboardButton;
    private javax.swing.JTextField username;
    private javax.swing.JPanel viewerPaneHeader;
    /**
     * Creates new form AdminDash
     */
    public AdminDashboard() {
        initComponents();
    }

    /**
     * Builds the GUI for the AdminDashboard.
     *
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
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

        headerBanner = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        eventViewerPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            events = EventManager.treeToArray(DBConnector.getAllEvents());
        } catch (Exception e) {
            events = new String[][]{};
        }
        Object[][] eventDTable = new Object[][]{};

        //String [][] events = new String[5][3];//{{"Name", "Location", "Date", "Start Time", "End Time"}, {"Name", "Location", "Date", "Start Time", "End Time"}}; //Used for testing purposes.
        if (events.length != 0) {
            eventDTable = new Object[events.length][events[0].length]; // Initialize

            for (int i = 0; i < eventDTable.length; i++) {
                //for(int j = 0; j < eventDTable[0].length; j++){

                // eventDTable[i][j] = events[i][j];
                eventDTable[i][0] = events[i][3];
                eventDTable[i][1] = events[i][1].substring(0, 10);
                eventDTable[i][2] = events[i][1].substring(10);
                // }
                // }
            }
        }

        eventDashTable = new javax.swing.JTable();
        viewerPaneHeader = new javax.swing.JPanel();
        eventViewerTitle = new javax.swing.JLabel();
        eventPrevPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        eventInfoHeader = new javax.swing.JPanel();
        eventInfoTitle = new javax.swing.JLabel();
        startTimeField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        endTimeLabel = new javax.swing.JLabel();
        endTimeField = new javax.swing.JTextField();
        modifyRosterButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        navigationBar = new javax.swing.JPanel();
        manageEventsButton = new javax.swing.JButton();
        manageAccountsButton = new javax.swing.JButton();
        manageRosterEvents = new javax.swing.JButton();
        userDashboardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Check N Tech");
        headerBanner.setBackground(new java.awt.Color(255, 102, 51));
        headerBanner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headerBanner.setPreferredSize(new java.awt.Dimension(2, 65));

        logoutButton.setText("Logout");
        logoutButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome");

        username.setEditable(false);
        username.setBackground(new java.awt.Color(255, 102, 51));
        username.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText(getUsername());
        username.setBorder(null);

        javax.swing.GroupLayout headerBannerLayout = new javax.swing.GroupLayout(headerBanner);
        headerBanner.setLayout(headerBannerLayout);
        headerBannerLayout.setHorizontalGroup(
                headerBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerBannerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 574, Short.MAX_VALUE)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        headerBannerLayout.setVerticalGroup(
                headerBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerBannerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headerBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(headerBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        eventViewerPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventDashTable.setAutoCreateRowSorter(true);
        eventDashTable.setModel(new javax.swing.table.DefaultTableModel(
                eventDTable,
                new String[]{
                        "Event Name", "Date", "Time"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        eventDashTable.setRowHeight(20);

        eventDashTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eventDashTableMousePressed(evt);
            }
        });

        jScrollPane1.setViewportView(eventDashTable);

        viewerPaneHeader.setBackground(new java.awt.Color(255, 102, 51));
        viewerPaneHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventViewerTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        eventViewerTitle.setForeground(new java.awt.Color(255, 255, 255));
        eventViewerTitle.setText("Upcoming Events");

        javax.swing.GroupLayout viewerPaneHeaderLayout = new javax.swing.GroupLayout(viewerPaneHeader);
        viewerPaneHeader.setLayout(viewerPaneHeaderLayout);
        viewerPaneHeaderLayout.setHorizontalGroup(
                viewerPaneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewerPaneHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventViewerTitle)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewerPaneHeaderLayout.setVerticalGroup(
                viewerPaneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewerPaneHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventViewerTitle)
                                .addContainerGap())
        );

        eventPrevPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventPrevPanel.setMinimumSize(new java.awt.Dimension(349, 315));
        eventPrevPanel.setPreferredSize(new java.awt.Dimension(267, 274));
        eventPrevPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameField.setToolTipText("Event name displayed here.");
        eventPrevPanel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 64, 195, -1));

        eventInfoHeader.setBackground(new java.awt.Color(255, 102, 51));
        eventInfoHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventInfoTitle.setFont(eventInfoTitle.getFont().deriveFont(eventInfoTitle.getFont().getStyle() | java.awt.Font.BOLD, eventInfoTitle.getFont().getSize() + 8));
        eventInfoTitle.setForeground(new java.awt.Color(255, 255, 255));
        eventInfoTitle.setText("Selected Event Information");

        javax.swing.GroupLayout eventInfoHeaderLayout = new javax.swing.GroupLayout(eventInfoHeader);
        eventInfoHeader.setLayout(eventInfoHeaderLayout);
        eventInfoHeaderLayout.setHorizontalGroup(
                eventInfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventInfoHeaderLayout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addComponent(eventInfoTitle)
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        eventInfoHeaderLayout.setVerticalGroup(
                eventInfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventInfoHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventInfoTitle)
                                .addContainerGap())
        );

        eventPrevPanel.add(eventInfoHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 297, -1));

        startTimeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startTimeField.setToolTipText("Start time displayed.");
        eventPrevPanel.add(startTimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 153, 195, -1));

        nameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLabel.setText("Name:");
        eventPrevPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 68, -1, -1));

        startTimeLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startTimeLabel.setText("Start Time:");
        eventPrevPanel.add(startTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 158, -1, -1));

        endTimeLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        endTimeLabel.setText("End Time:");
        eventPrevPanel.add(endTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 201, -1, -1));

        endTimeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        endTimeField.setToolTipText("End time displayed.");
        eventPrevPanel.add(endTimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 196, 195, -1));

        modifyRosterButton.setText("Manage Roster");
        modifyRosterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRosterButtonActionPerformed(evt);
            }
        });
        eventPrevPanel.add(modifyRosterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 260, 120, 40));

        cancelButton.setText("Clear");
        cancelButton.setToolTipText("Clear selected event preview.");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        eventPrevPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 260, 120, 40));

        dateLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLabel.setText("Date:");
        eventPrevPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 113, -1, -1));

        dateField.setToolTipText("Date displayed here.");
        eventPrevPanel.add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 110, 195, -1));

        javax.swing.GroupLayout eventViewerPaneLayout = new javax.swing.GroupLayout(eventViewerPane);
        eventViewerPane.setLayout(eventViewerPaneLayout);
        eventViewerPaneLayout.setHorizontalGroup(
                eventViewerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventViewerPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eventPrevPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(viewerPaneHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewerPaneHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eventViewerPaneLayout.setVerticalGroup(
                eventViewerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eventViewerPaneLayout.createSequentialGroup()
                                .addComponent(viewerPaneHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eventViewerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                        .addGroup(eventViewerPaneLayout.createSequentialGroup()
                                                .addComponent(eventPrevPanel, 315, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(headerBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eventViewerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eventViewerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Logs the user out. Program returns to homepage.
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Opens the Account Manager
    private void manageAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsButtonActionPerformed
        new UserAccounts().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageAccountsButtonActionPerformed

    // Opens the Event Manager.
    private void manageEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEventsButtonActionPerformed
        new EventManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageEventsButtonActionPerformed

    // Opens the User Dashboard.
    private void userDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDashboardButtonActionPerformed
        new AdminDashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_userDashboardButtonActionPerformed

    // Opens the Event Roster Manager.
    private void manageRosterEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRosterEventsActionPerformed
        new RosterManager().setVisible(true);
        this.setVisible(false);
    } //GEN-LAST:event_manageRosterEventsActionPerformed

    // Action listener to clear the detailed information form.
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(eventDashTable.getSelectedRow() != -1)
            eventDashTable.removeRowSelectionInterval(0,eventDashTable.getRowCount()-1); // Needs to be tested.
        nameField.setText("");
        dateField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");

    }//GEN-LAST:event_cancelButtonActionPerformed

    // Opens the specified Event's Roster Page. Will need to access the database to find the roster.
    private void modifyRosterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRosterButtonActionPerformed
        int index = eventDashTable.getSelectedRow();
        if (!(nameField.getText().equals(""))) {
            new EventRosterManager(events[index][0], events[index][3]).setVisible(true);
            this.setVisible(false);
        } else
            javax.swing.JOptionPane.showMessageDialog(null, "An event must be selected.");
    }//GEN-LAST:event_modifyRosterButtonActionPerformed

    // Displays selected event from the table in the detailed information pane.
    private void eventDashTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventDashTableMousePressed
        TableModel model = (DefaultTableModel) eventDashTable.getModel();
        int[] indexs = eventDashTable.getSelectedRows();
        Object[] selectedRow = new Object[4];
        for (int i = 0; i < indexs.length; i++) {
            selectedRow[0] = model.getValueAt(indexs[i], 0);
            selectedRow[1] = model.getValueAt(indexs[i], 1);
            selectedRow[2] = model.getValueAt(indexs[i], 2);
            selectedRow[3] = events[i][4].substring(10);
        }

        nameField.setText(selectedRow[0].toString());
        dateField.setText(selectedRow[1].toString());
        startTimeField.setText(selectedRow[2].toString());
        endTimeField.setText(selectedRow[3].toString());


        //endTimeField.setText(endTime.toString());

    }//GEN-LAST:event_eventDashTableMousePressed

    // Sets login name next to "Welcome" in the title of the DashboardScreen.
    private String getUsername() {
        return LoginScreen.getUsername();
    }
    // End of variables declaration//GEN-END:variables

}
