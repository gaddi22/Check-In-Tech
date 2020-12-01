/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checknscan.checkntech;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Alexander Duncan
 */
public class EventRosterManager extends javax.swing.JFrame {

    private static String selectedEventID = ""; // Stores the event's ID
    private static String selectedEventName = ""; // Stores the event's name.
    
    private String [][] mainRoster; // Initialize
    private String [][] eventRoster;
    private String [] eventAddArray;
    private String [] eventRemoveArray;
    
    
    /** Used for managing a selected events roster.
     * Creates new form EventRosterManager
     */
    public EventRosterManager(String selectedEventID) {
        this.selectedEventID = selectedEventID;
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

        headerEventRoster = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        eventRosterManagTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mainRosterPanel = new javax.swing.JPanel();
        mainRosterHeader = new javax.swing.JPanel();
        mainRosterLabel = new javax.swing.JLabel();
        mainRosterScrollTable = new javax.swing.JScrollPane();

        try {
            mainRoster = EventManager.treeToArray(DBConnector.getAllAttendees());
        } catch (Exception e){
            mainRoster = new String [][] {};
        }

        ArrayList<String[]> temp = new ArrayList<>();
        try {
            temp = DBConnector.getEventRoster(getSelectedEventID());
            eventRoster = temp.toArray(new String[temp.size()][]);
        } catch (Exception e){
            eventRoster = new String [][]{};
        }

        System.out.println(temp.size() + getSelectedEventID());

        Object [][] mainAttendeeRoster = new Object [][] {};

        if(mainRoster.length != 0){
            mainAttendeeRoster = new Object [mainRoster.length][mainRoster[0].length];

            for(int i=0; i < mainAttendeeRoster.length; i++){
                mainAttendeeRoster[i][0] = mainRoster[i][0];
                mainAttendeeRoster[i][1] = mainRoster[i][1];
                mainAttendeeRoster[i][2] = mainRoster[i][2];
            }
        }

        Object[][] eventObjRoster = new Object[][] {};

        if(eventRoster.length != 0){
            eventObjRoster = new Object [eventRoster.length][4];

            for(int i=0; i < eventObjRoster.length; i++){
                eventObjRoster[i][0] = eventRoster[i][0];
                eventObjRoster[i][1] = eventRoster[i][1];
                eventObjRoster[i][2] = eventRoster[i][2];
                if(DBConnector.isFirstCheckNull((String) eventObjRoster[i][0], getSelectedEventID()) == false)
                    eventObjRoster[i][3] = "YES";
                else
                    eventObjRoster[i][3] = "NO";
            }

        }

        mainRosterTable = new javax.swing.JTable();
        eventRosterTable = new javax.swing.JTable();
        eventRosterPanel = new javax.swing.JPanel();
        eventRosterHeader = new javax.swing.JPanel();
        eventRosterTitle = new javax.swing.JLabel();
        eventNameField = new javax.swing.JTextField();
        eventRosterScrollTable = new javax.swing.JScrollPane();
        eventRosterTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        checkInBtn = new javax.swing.JButton();
        checkOutBtn = new javax.swing.JButton();
        navigationBar = new javax.swing.JPanel();
        manageEventsButton = new javax.swing.JButton();
        manageAccountsButton = new javax.swing.JButton();
        manageRosterEvents = new javax.swing.JButton();
        userDashboardButton = new javax.swing.JButton();

        // setEventRosterTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerEventRoster.setBackground(new java.awt.Color(255, 102, 51));
        headerEventRoster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headerEventRoster.setPreferredSize(new java.awt.Dimension(2, 65));

        logoutButton.setText("Logout");
        logoutButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        eventRosterManagTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        eventRosterManagTitle.setForeground(new java.awt.Color(255, 255, 255));
        eventRosterManagTitle.setText("Event Roster Manager");

        javax.swing.GroupLayout headerEventRosterLayout = new javax.swing.GroupLayout(headerEventRoster);
        headerEventRoster.setLayout(headerEventRosterLayout);
        headerEventRosterLayout.setHorizontalGroup(
            headerEventRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerEventRosterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventRosterManagTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerEventRosterLayout.setVerticalGroup(
            headerEventRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerEventRosterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerEventRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eventRosterManagTitle)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainRosterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mainRosterHeader.setBackground(new java.awt.Color(255, 102, 51));
        mainRosterHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mainRosterLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainRosterLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainRosterLabel.setText("Main Roster");

        javax.swing.GroupLayout mainRosterHeaderLayout = new javax.swing.GroupLayout(mainRosterHeader);
        mainRosterHeader.setLayout(mainRosterHeaderLayout);
        mainRosterHeaderLayout.setHorizontalGroup(
            mainRosterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainRosterHeaderLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(mainRosterLabel)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        mainRosterHeaderLayout.setVerticalGroup(
            mainRosterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainRosterHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainRosterLabel)
                .addContainerGap())
        );

        mainRosterTable.setModel(new javax.swing.table.DefaultTableModel(
            mainAttendeeRoster,
            new String [] {
                "ID", "Last", "First"
            }
        ) {
            public boolean isCellEditable(int row, int column) { return false; }
        });

        mainRosterScrollTable.setViewportView(mainRosterTable);

        eventRosterTable.setModel(new javax.swing.table.DefaultTableModel(
                eventObjRoster,
                new String[]{ "ID", "Last", "First", "Attended" } ) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
        });

        eventRosterScrollTable.setViewportView(eventRosterTable);

        javax.swing.GroupLayout mainRosterPanelLayout = new javax.swing.GroupLayout(mainRosterPanel);
        mainRosterPanel.setLayout(mainRosterPanelLayout);
        mainRosterPanelLayout.setHorizontalGroup(
            mainRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainRosterHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainRosterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainRosterScrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainRosterPanelLayout.setVerticalGroup(
            mainRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainRosterPanelLayout.createSequentialGroup()
                .addComponent(mainRosterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainRosterScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        eventRosterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventRosterHeader.setBackground(new java.awt.Color(255, 102, 51));
        eventRosterHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventRosterTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        eventRosterTitle.setForeground(new java.awt.Color(255, 255, 255));
        eventRosterTitle.setText("Roster");

        eventNameField.setBackground(new java.awt.Color(255, 102, 51));
        eventNameField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        eventNameField.setForeground(new java.awt.Color(255, 255, 255));
        eventNameField.setText(getEventName());
        eventNameField.setBorder(null);

        javax.swing.GroupLayout eventRosterHeaderLayout = new javax.swing.GroupLayout(eventRosterHeader);
        eventRosterHeader.setLayout(eventRosterHeaderLayout);
        eventRosterHeaderLayout.setHorizontalGroup(
            eventRosterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventRosterHeaderLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(eventNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventRosterTitle)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        eventRosterHeaderLayout.setVerticalGroup(
            eventRosterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventRosterHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventRosterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventRosterTitle)
                    .addComponent(eventNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout eventRosterPanelLayout = new javax.swing.GroupLayout(eventRosterPanel);
        eventRosterPanel.setLayout(eventRosterPanelLayout);
        eventRosterPanelLayout.setHorizontalGroup(
            eventRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eventRosterHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(eventRosterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventRosterScrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        eventRosterPanelLayout.setVerticalGroup(
            eventRosterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventRosterPanelLayout.createSequentialGroup()
                .addComponent(eventRosterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eventRosterScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        addButton.setText("Add Selected >>");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("<< Remove Selected");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        checkInBtn.setText("Check In");
        checkInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        checkOutBtn.setText("Check Out");
        checkOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainRosterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(checkInBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eventRosterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(eventRosterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mainRosterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeButton)
                                .addGap(34, 34, 34)
                                .addComponent(checkInBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkOutBtn)
                                .addGap(32, 32, 32)
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(headerEventRoster, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
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
                                .addComponent(headerEventRoster, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Displays the ID of the event whose roster is being modified.
    public static String getSelectedEventID(){
        return selectedEventID;
    }
    
    // Displays the name of the event whose roster is being modified.
    public static String getEventName(){
        return selectedEventName;
    }
    
    // Logs the user out. Returns to HomePage.
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed
   
    // Adds the selected member in the mainRosterTable to the eventRosterTable.
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Adds only one selected row at a time.
        int index = mainRosterTable.getSelectedRow();
        String [] addSelected = new String [3];
        addSelected[0] = mainRosterTable.getValueAt(index, 0).toString();
        addSelected[1] = mainRosterTable.getValueAt(index, 1).toString();
        addSelected[2] = mainRosterTable.getValueAt(index, 2).toString();
        DefaultTableModel model = (DefaultTableModel)eventRosterTable.getModel();
        model.addRow(addSelected);
        eventAddArray = new String[] {mainRosterTable.getValueAt(index, 0).toString()};
    }//GEN-LAST:event_addButtonActionPerformed
    
    // Opens Event Manager.
    private void manageEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEventsButtonActionPerformed
        new EventManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageEventsButtonActionPerformed

    // Opens Account Manager.
    private void manageAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsButtonActionPerformed
        new UserAccounts().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageAccountsButtonActionPerformed

    // Displays the Roster Manager.
    private void manageRosterEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRosterEventsActionPerformed
        new RosterManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageRosterEventsActionPerformed
    
    // Displays the Dashboard.
    private void userDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDashboardButtonActionPerformed
        new AdminDashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_userDashboardButtonActionPerformed

    // Removes selected row from the eventRosterTable.
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int index = eventRosterTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)eventRosterTable.getModel();
        model.removeRow(index);
    }//GEN-LAST:event_removeButtonActionPerformed

    // Saves the updated eventRosterTable to the database.
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // javax.swing.JOptionPane.showConfirmDialog(null, "Confirm save?");
        for(int i=0; eventAddArray != null && i < eventAddArray.length; i++) {
            DBConnector.addAttendeeToEvent(eventAddArray[i], getSelectedEventID());
        }
        for(int i=0; eventRemoveArray != null && i < eventRemoveArray.length; i++) {
            DBConnector.deleteAttendee(eventRemoveArray[i]);
        }
        new EventRosterManager(getSelectedEventID()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    // Reloads to last saved eventRosterTable in the database.
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        new EventRosterManager(getSelectedEventID()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void checkInBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int index = eventRosterTable.getSelectedRow();
        DBConnector.checkIn(eventRosterTable.getValueAt(index, 0).toString(), getSelectedEventID(), null, null);
        new EventRosterManager(getSelectedEventID()).setVisible(true);
        this.setVisible(false);
    }

    private void checkOutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int index = eventRosterTable.getSelectedRow();
        DBConnector.checkOut(eventRosterTable.getValueAt(index, 0).toString(), getSelectedEventID());
        new EventRosterManager(getSelectedEventID()).setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(EventRosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventRosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventRosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventRosterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventRosterManager(getSelectedEventID()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkInBtn;
    private javax.swing.JButton checkOutBtn;
    private javax.swing.JTextField eventNameField;
    private javax.swing.JPanel eventRosterHeader;
    private javax.swing.JLabel eventRosterManagTitle;
    private javax.swing.JPanel eventRosterPanel;
    private javax.swing.JScrollPane eventRosterScrollTable;
    private javax.swing.JTable eventRosterTable;
    private javax.swing.JLabel eventRosterTitle;
    private javax.swing.JPanel headerEventRoster;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel mainRosterHeader;
    private javax.swing.JLabel mainRosterLabel;
    private javax.swing.JPanel mainRosterPanel;
    private javax.swing.JScrollPane mainRosterScrollTable;
    private javax.swing.JTable mainRosterTable;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JButton manageEventsButton;
    private javax.swing.JButton manageRosterEvents;
    protected javax.swing.JPanel navigationBar;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton userDashboardButton;
    // End of variables declaration//GEN-END:variables
}
