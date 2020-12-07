/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checknscan.checkntech;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Creates the Event Manager display.
 *
 * @author Alexander Duncan
 */
public class EventManager extends javax.swing.JFrame {

    private static String[][] events = new String[][]{};
    private static javax.swing.JTable eventManagerTable;
    private static javax.swing.JScrollPane upcomingEventsScrollPanel;
    protected javax.swing.JPanel navigationBar;
    private javax.swing.JButton addUpdateBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel colonLabel;
    private javax.swing.JLabel colonLabel1;
    private javax.swing.JLabel colonLabel2;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dayField;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField endHrField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JTextField endMinField;
    private javax.swing.JPanel eventInfoHeader;
    private javax.swing.JLabel eventInfoTitle;
    private javax.swing.JLabel eventManagerTitle;
    private javax.swing.JTextField eventNameField;
    private javax.swing.JPanel eventPrevPanel;
    private javax.swing.JPanel headerEventManager;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JButton manageEventsButton;
    private javax.swing.JButton manageRosterEvents;
    private javax.swing.JLabel minDurationLabel;
    private javax.swing.JTextField minHrDurationField;
    private javax.swing.JLabel minHrLabel;
    private javax.swing.JTextField minMinDurationField;
    private javax.swing.JLabel minMinLabel;
    private javax.swing.JTextField monthField;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel registeredAccountsLabel;
    private javax.swing.JButton rosterBtn;
    private javax.swing.JTextField startHrField;
    private javax.swing.JLabel startLabel;
    private javax.swing.JTextField startMinField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel upcomingEventsPanel;
    private javax.swing.JPanel upcomingEventsTitle;
    private javax.swing.JButton userDashboardButton;
    private javax.swing.JTextField dateField;

    // Defaults used for setting ghost strings.
    private String defaultEventName = "Enter event name here.";
    private String hr = "hh";
    private String min = "mm";
    private String defaultDate = "2000-01-01";
    GhostText defaultText;

    /**
     * Creates new form EventManager
     */
    public EventManager() {
        initComponents();
    }

    // Reloads previously saved Event Table.
    private static void loadEventTable() {
        System.out.println(LoginScreen.getUsername());
        Object[][] eventTable = new String[][]{};
        try {
            String[][] events = treeToArray(DBConnector.getAllEvents()); // Get events list from database.
            eventTable = new Object[events.length][events[0].length]; // Initialize
            for (int i = 0; i < eventTable.length; i++) {
                eventTable[i][0] = events[i][0];
                eventTable[i][1] = events[i][3];
                eventTable[i][2] = events[i][1].substring(0, 10);
                eventTable[i][3] = events[i][1].substring(10);
                eventTable[i][4] = events[i][4].substring(10);
            }

        } catch (Exception e) {
        }
        eventManagerTable = new javax.swing.JTable();
        eventManagerTable.setAutoCreateRowSorter(false);
        eventManagerTable.setModel(new javax.swing.table.DefaultTableModel(
                eventTable,
                new String[]{
                        "ID", "Name", "Date", "Start Time", "End Time"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        eventManagerTable.setToolTipText("");
        eventManagerTable.setAutoscrolls(false);
        eventManagerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eventManagerTable.setShowGrid(true);
        upcomingEventsScrollPanel.setViewportView(eventManagerTable);

    }

    // Returns 2D array.
    public static String[][] treeToArray(TreeMap<String, String[]> tree) {
        String[][] eventBuild = null;
        ArrayList<String[]> table = new ArrayList<String[]>();
        TreeMap currEvents = tree;
        String[][] tableArray = new String[][]{};

        while (!currEvents.isEmpty()) {
            ArrayList<String> temp = new ArrayList<String>();

            temp.add((String) tree.lastKey());
            for (String column : (String[]) tree.get(tree.lastKey())) {
                temp.add(column);
            }

            table.add((String[]) temp.toArray(new String[temp.size()]));
            tree.remove(tree.lastKey());
        }
        try {
            tableArray = (String[][]) table.toArray(new String[table.size()][table.get(0).length]);
        } catch (Exception e) {
        }

        return tableArray;
    }

    public static void setEvents() {
        events = treeToArray(DBConnector.getAllEvents());
        loadEventTable();
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
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EventManager().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

        // Header of the page.
        headerEventManager = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        eventManagerTitle = new javax.swing.JLabel();
        upcomingEventsPanel = new javax.swing.JPanel();
        upcomingEventsScrollPanel = new javax.swing.JScrollPane();
        try {
            events = treeToArray(DBConnector.getAllEvents());
        } catch (Exception e) {
            events = new String[][]{};
        }

        Object[][] eventsTable;

        if (events.length != 0) {
            eventsTable = new Object[events.length][events[0].length]; // Initialize

            for (int i = 0; i < eventsTable.length; i++) {
                for (int j = 0; j < eventsTable[0].length; j++) {
                    if (j < events[0].length)
                        eventsTable[i][j] = events[i][j];
                }
            }
        }

        eventManagerTable = new javax.swing.JTable();
        upcomingEventsTitle = new javax.swing.JPanel();
        registeredAccountsLabel = new javax.swing.JLabel();
        eventPrevPanel = new javax.swing.JPanel();
        eventInfoHeader = new javax.swing.JPanel();
        eventInfoTitle = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        eventNameField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        monthField = new javax.swing.JTextField();
        monthLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        startHrField = new javax.swing.JTextField();
        colonLabel1 = new javax.swing.JLabel();
        colonLabel2 = new javax.swing.JLabel();
        startMinField = new javax.swing.JTextField();
        endLabel = new javax.swing.JLabel();
        endHrField = new javax.swing.JTextField();
        colonLabel = new javax.swing.JLabel();
        endMinField = new javax.swing.JTextField();
        minDurationLabel = new javax.swing.JLabel();
        minHrDurationField = new javax.swing.JTextField();
        minHrLabel = new javax.swing.JLabel();
        minMinLabel = new javax.swing.JLabel();
        minMinDurationField = new javax.swing.JTextField();
        addUpdateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        rosterBtn = new javax.swing.JButton();
        navigationBar = new javax.swing.JPanel();
        manageEventsButton = new javax.swing.JButton();
        manageAccountsButton = new javax.swing.JButton();
        manageRosterEvents = new javax.swing.JButton();
        userDashboardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Check N Tech");
        headerEventManager.setBackground(new java.awt.Color(255, 102, 51));
        headerEventManager.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headerEventManager.setPreferredSize(new java.awt.Dimension(2, 65));

        logoutButton.setText("Logout");
        logoutButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        eventManagerTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        eventManagerTitle.setForeground(new java.awt.Color(255, 255, 255));
        eventManagerTitle.setText("Event Manager");

        javax.swing.GroupLayout headerEventManagerLayout = new javax.swing.GroupLayout(headerEventManager);
        headerEventManager.setLayout(headerEventManagerLayout);
        headerEventManagerLayout.setHorizontalGroup(
                headerEventManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerEventManagerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(eventManagerTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        headerEventManagerLayout.setVerticalGroup(
                headerEventManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerEventManagerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headerEventManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(eventManagerTitle)
                                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        upcomingEventsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        upcomingEventsScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        eventManagerTable.setAutoCreateRowSorter(true);
        loadEventTable();
        /*eventManagerTable.setModel(new javax.swing.table.DefaultTableModel(
            eventsTable,
            new String [] {
                "Name", "Date", "Start Time", "End Time", /*"Modifiy Roster", "saveEventButton", "Delete"*/
        //}
        /*) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });*/
        eventManagerTable.setToolTipText("");
        eventManagerTable.setAutoscrolls(false);
        eventManagerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eventManagerTable.setShowGrid(true);
        eventManagerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventManagerTableMouseClicked(evt);
            }
        });
        upcomingEventsScrollPanel.setViewportView(eventManagerTable);

        upcomingEventsTitle.setBackground(new java.awt.Color(255, 102, 51));
        upcomingEventsTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        registeredAccountsLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        registeredAccountsLabel.setForeground(new java.awt.Color(255, 255, 255));
        registeredAccountsLabel.setText("Events");

        javax.swing.GroupLayout upcomingEventsTitleLayout = new javax.swing.GroupLayout(upcomingEventsTitle);
        upcomingEventsTitle.setLayout(upcomingEventsTitleLayout);
        upcomingEventsTitleLayout.setHorizontalGroup(
                upcomingEventsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upcomingEventsTitleLayout.createSequentialGroup()
                                .addContainerGap(330, Short.MAX_VALUE)
                                .addComponent(registeredAccountsLabel)
                                .addContainerGap(330, Short.MAX_VALUE))
        );
        upcomingEventsTitleLayout.setVerticalGroup(
                upcomingEventsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(upcomingEventsTitleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(registeredAccountsLabel)
                                .addContainerGap())
        );

        eventPrevPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventPrevPanel.setMinimumSize(new java.awt.Dimension(349, 315));
        eventPrevPanel.setPreferredSize(new java.awt.Dimension(350, 325));
        eventPrevPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventInfoHeader.setBackground(new java.awt.Color(255, 102, 51));
        eventInfoHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventInfoHeader.setPreferredSize(new java.awt.Dimension(350, 45));

        eventInfoTitle.setFont(eventInfoTitle.getFont().deriveFont(eventInfoTitle.getFont().getStyle() | java.awt.Font.BOLD, eventInfoTitle.getFont().getSize() + 8));
        eventInfoTitle.setForeground(new java.awt.Color(255, 255, 255));
        eventInfoTitle.setText("Add / Edit Event");

        javax.swing.GroupLayout eventInfoHeaderLayout = new javax.swing.GroupLayout(eventInfoHeader);
        eventInfoHeader.setLayout(eventInfoHeaderLayout);
        eventInfoHeaderLayout.setHorizontalGroup(
                eventInfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventInfoHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventInfoTitle)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        eventInfoHeaderLayout.setVerticalGroup(
                eventInfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventInfoHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eventInfoTitle)
                                .addContainerGap())
        );

        eventPrevPanel.add(eventInfoHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 284, -1));

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setText("Event Name:");
        eventPrevPanel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 64, -1, -1));

        eventNameField.setToolTipText("Enter event name.");
        eventPrevPanel.add(eventNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 166, -1));

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel.setText("Date:");
        eventPrevPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 90, -1, -1));

        /*
        //monthField.setToolTipText("Enter 2-digit month.");
        //eventPrevPanel.add(monthField, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 90, 30, -1));

        //monthLabel.setText("/");
        //eventPrevPanel.add(monthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 92, -1, -1));

        //dayLabel.setText("/");
        //eventPrevPanel.add(dayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 92, -1, -1));

        //DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        */

        dateField.setToolTipText("Enter 2-digit month - 2 digit day - 4 digit year.");
        eventPrevPanel.add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 90, 80, -1));

        //dayField.setToolTipText("Enter 4-digit year.");
        //eventPrevPanel.add(dayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 30, -1));
        defaultText = new GhostText(dateField, "2000-01-01");

        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeLabel.setText("Time:");
        eventPrevPanel.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 128, -1, -1));

        //dateTextField = new JFormattedTextField(format);
        // eventPrevPanel.add(dateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 90, 100, -1));

        startLabel.setText("Start:");
        eventPrevPanel.add(startLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 132, 50, -1));
        eventPrevPanel.add(startHrField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 30, -1));

        colonLabel1.setText(":");
        eventPrevPanel.add(colonLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 132, -1, -1));
        eventPrevPanel.add(startMinField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 30, -1));

        endLabel.setText("End:");
        eventPrevPanel.add(endLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 162, 50, -1));
        eventPrevPanel.add(endHrField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 30, -1));

        colonLabel.setText(":");
        eventPrevPanel.add(colonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 162, -1, -1));
        eventPrevPanel.add(endMinField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 30, -1));

        // Center align all inputs.
        startHrField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        startMinField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        endHrField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        endMinField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        minHrDurationField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        minMinDurationField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        // eventNameField.setHorizontalAlignment((int) LEFT_ALIGNMENT);

        // Set default ghost text.
        defaultText = new GhostText(eventNameField, defaultEventName);
        defaultText = new GhostText(startHrField, hr);
        defaultText = new GhostText(startMinField, min);
        defaultText = new GhostText(endHrField, hr);
        defaultText = new GhostText(endMinField, min);
        defaultText = new GhostText(minHrDurationField, hr);
        defaultText = new GhostText(minMinDurationField, min);

        // Duration required labels and fields.
        minDurationLabel.setText("Duration:");
        colonLabel2.setText(":");
        eventPrevPanel.add(minDurationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 192, -1, -1));
        eventPrevPanel.add(colonLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 192, -1, -1));
        minHrDurationField.setToolTipText("Enter minimum time required to be counted as present.");
        eventPrevPanel.add(minHrDurationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 30, -1));
        minMinDurationField.setToolTipText("Enter minimum time required to be counted as present.");
        eventPrevPanel.add(minMinDurationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 30, -1));

        addUpdateBtn.setText("Add / Update");
        addUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateBtnActionPerformed(evt);
            }
        });
        eventPrevPanel.add(addUpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, 40));

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        eventPrevPanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 120, 40));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        eventPrevPanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, 40));

        rosterBtn.setText("Roster");
        rosterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rosterBtnActionPerformed(evt);
            }
        });
        eventPrevPanel.add(rosterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, 40));

        javax.swing.GroupLayout upcomingEventsPanelLayout = new javax.swing.GroupLayout(upcomingEventsPanel);
        upcomingEventsPanel.setLayout(upcomingEventsPanelLayout);
        upcomingEventsPanelLayout.setHorizontalGroup(
                upcomingEventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(upcomingEventsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(upcomingEventsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(upcomingEventsScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eventPrevPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        upcomingEventsPanelLayout.setVerticalGroup(
                upcomingEventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upcomingEventsPanelLayout.createSequentialGroup()
                                .addComponent(upcomingEventsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(upcomingEventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(upcomingEventsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                        .addGroup(upcomingEventsPanelLayout.createSequentialGroup()
                                                .addComponent(eventPrevPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(headerEventManager, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upcomingEventsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerEventManager, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(upcomingEventsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Logs user out. Returns to HomePage.
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Opens Event Manager.
    private void manageEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEventsButtonActionPerformed
        try {
            new EventManager().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_manageEventsButtonActionPerformed

    // Opens Account Manager.
    private void manageAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsButtonActionPerformed
        new UserAccounts().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageAccountsButtonActionPerformed

    // Opens Roster Manager.
    private void manageRosterEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRosterEventsActionPerformed
        new RosterManager().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageRosterEventsActionPerformed

    // Opens User Dashboard.
    private void userDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDashboardButtonActionPerformed
        new AdminDashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_userDashboardButtonActionPerformed

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    // Add / Updating a new event.
    private void addUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateBtnActionPerformed
        boolean validInput = true;
        boolean dateCk = true;
        boolean eventNameInput = true;
        boolean correctTime = true;
        boolean durCk = true;

        int index = eventManagerTable.getSelectedRow();
        String eventName = eventNameField.getText();
        String startTime = dateField.getText() + " " + startHrField.getText() + ":" + startMinField.getText() + ":00";
        String endTime = dateField.getText() + " " + endHrField.getText() + ":" + endMinField.getText() + ":00";
        String durTime = minHrDurationField.getText() + ":" + minMinDurationField.getText() + ":00";
        String username = LoginScreen.getUsername();

        if(dateField.getText().length() != 10 || dateField.getText().equals("2000-01-01") || isValidDate(startTime)){
            dateCk = false;
        }

        System.out.println(dateCk);

        // Verify an event name is specified.
        if (eventNameField.getText().equals("")) {
            eventNameInput = false;
        }

        if(eventNameInput==true && dateCk==true) {
            try {
                int startHr = Integer.parseInt(startHrField.getText().trim());
                int startMin = Integer.parseInt(startMinField.getText().trim());
                int endHr = Integer.parseInt(endHrField.getText().trim());
                int endMin = Integer.parseInt(endMinField.getText().trim());
                int durHr = Integer.parseInt(minHrDurationField.getText().trim());
                int durMin = Integer.parseInt(minMinDurationField.getText().trim());

                int ttlTime = (endHr * 60 + endMin) - (startHr * 60 + startMin);
                int durTtl = (durHr * 60 + durMin);

                if (durTtl > ttlTime)
                    durCk = false;

                // Calculate what happens when Add / Update Button is pressed.
                if (validInput && eventNameInput && dateCk && correctTime && durCk) {
                    if (index == -1) {
                        DBConnector.createEvent(startTime, durTime, eventName, endTime, username);
                    } else {
                        String eventID = eventManagerTable.getValueAt(index, 0).toString();
                        DBConnector.updateEventInfo(eventID, startTime, durTime, eventName, endTime, username);
                    }
                    new EventManager().setVisible(true);
                    this.setVisible(false);
                } else if (correctTime == false) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Hours must be formatted between 0 and 24. Minutes must be between 0 and 60.");
                } else if (durCk == false) {
                    javax.swing.JOptionPane.showMessageDialog(null, "The minimum time cannot be greater than the total time.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "All dates and times must be numerical.");
                }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please check the date, start time, end time, and duration for accuracy.");
            }
        } else if (eventNameInput == false) {
            javax.swing.JOptionPane.showMessageDialog(null, "Event name must be specified.");
        } else if (dateCk == false) {
            javax.swing.JOptionPane.showMessageDialog(null, "Please verify date.");
        }


        }//GEN-LAST:event_addUpdateBtnActionPerformed

    // Clears the Selected Event Information panel.
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        if(eventManagerTable.getSelectedRow() != -1)
            eventManagerTable.removeRowSelectionInterval(0,eventManagerTable.getRowCount()-1); // Needs to be tested.

        eventNameField.setText("");
        dateField.setText("");
        startHrField.setText("");
        startMinField.setText("");
        endHrField.setText("");
        endMinField.setText("");
        minHrDurationField.setText("");
        minMinDurationField.setText("");

        defaultText = new GhostText(eventNameField, defaultEventName);
        defaultText = new GhostText(dateField, defaultDate);
        defaultText = new GhostText(startHrField, hr);
        defaultText = new GhostText(startMinField, min);
        defaultText = new GhostText(endHrField, hr);
        defaultText = new GhostText(endMinField, min);
        defaultText = new GhostText(minHrDurationField, hr);
        defaultText = new GhostText(minMinDurationField, min);

    }//GEN-LAST:event_clearBtnActionPerformed

    // Deletes the selected event.
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected event?");
        int index = eventManagerTable.getSelectedRow();
        Object [][] temp = new Object [eventManagerTable.getRowCount()-1][eventManagerTable.getColumnCount()];
        DBConnector.deleteEvent(eventManagerTable.getValueAt(index,0).toString());
        String [] data = {"ID", "Name", "Date", "Start Time", "End Time"};

        // Fills object to reset eventManagerTable.
        for(int i=0; i < temp.length; i++){
            temp[i][0] = eventManagerTable.getValueAt(i,0);
            temp[i][1] = eventManagerTable.getValueAt(i,1);
            temp[i][2] = eventManagerTable.getValueAt(i,2);
            temp[i][3] = eventManagerTable.getValueAt(i,3);
            temp[i][4] = eventManagerTable.getValueAt(i,4);
        }

        eventManagerTable.setModel(new DefaultTableModel(temp, data));

    }//GEN-LAST:event_deleteBtnActionPerformed

    // Opens the roster for the selected event.
    private void rosterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rosterBtnActionPerformed
        int index = eventManagerTable.getSelectedRow();
        if (!(eventNameField.getText().equals(""))) {
            new EventRosterManager(events[index][0], events[index][3]).setVisible(true);
            this.setVisible(false);
        } else
            javax.swing.JOptionPane.showMessageDialog(null, "An event must be selected.");
    }//GEN-LAST:event_rosterBtnActionPerformed

    // Displays the selected event in the Selected Event Information panel.
    private void eventManagerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventManagerTableMouseClicked
        TableModel model = (DefaultTableModel) eventManagerTable.getModel();
        int index = eventManagerTable.getSelectedRow();
        Object[] selectedRow = new Object[6];

        selectedRow[0] = model.getValueAt(index, 0); // Event ID
        selectedRow[1] = model.getValueAt(index, 1); // Name
        selectedRow[2] = model.getValueAt(index, 2); // Date
        selectedRow[3] = model.getValueAt(index, 3); // Start Time
        selectedRow[4] = model.getValueAt(index, 4); // End Time
        selectedRow[5] = events[index][2]; // Duration Time.


        String year = selectedRow[2].toString();
        //String month = selectedRow[1].toString().substring(5, 7);
        //String day = selectedRow[1].toString().substring(8, 10);
        String startHrTime = selectedRow[3].toString().substring(0, 3);
        String startMinTime = selectedRow[3].toString().substring(4, 6);
        String endHrTime = selectedRow[4].toString().substring(0, 3);
        String endMinTime = selectedRow[4].toString().substring(4, 6);
        String durHr = selectedRow[5].toString().substring(0, 2);
        String durMin = selectedRow[5].toString().substring(3, 5);

        // Set all fields.
        eventNameField.setText(selectedRow[1].toString());
        dateField.setText(year);
        startHrField.setText(startHrTime);
        startMinField.setText(startMinTime);
        endHrField.setText(endHrTime);
        endMinField.setText(endMinTime);
        minHrDurationField.setText(durHr);
        minMinDurationField.setText(durMin);

    }//GEN-LAST:event_eventManagerTableMouseClicked
    // End of variables declaration//GEN-END:variables
}
