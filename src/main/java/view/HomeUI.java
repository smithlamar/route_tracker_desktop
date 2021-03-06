/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import model.Route;

/**
 *
 * @author Lamar
 */
public class HomeUI extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public HomeUI() {
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

        pnlMain = new javax.swing.JPanel();
        pnlRoutes = new javax.swing.JPanel();
        lblRoutes = new javax.swing.JLabel();
        scrlpanRoutes = new javax.swing.JScrollPane();
        lstRoutes = new javax.swing.JList<>();
        pnlTimes = new javax.swing.JPanel();
        scrlpanTimes = new javax.swing.JScrollPane();
        lstTimes = new javax.swing.JList<>();
        lblTimes = new javax.swing.JLabel();
        btnAddRoute = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileNewRoute = new javax.swing.JMenuItem();
        menuFileSaveRoute = new javax.swing.JMenuItem();
        MenuFileExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Route Tracker");
        setBackground(java.awt.SystemColor.windowBorder);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setMinimumSize(pnlMain.getPreferredSize());
        setName("mainFrm"); // NOI18N

        pnlMain.setMinimumSize(new java.awt.Dimension(600, 480));
        pnlMain.setName(""); // NOI18N
        pnlMain.setOpaque(false);
        pnlMain.setPreferredSize(new java.awt.Dimension(600, 500));

        pnlRoutes.setBackground(new java.awt.Color(235, 235, 235));

        lblRoutes.setText("My Routes");

        lstRoutes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrlpanRoutes.setViewportView(lstRoutes);

        javax.swing.GroupLayout pnlRoutesLayout = new javax.swing.GroupLayout(pnlRoutes);
        pnlRoutes.setLayout(pnlRoutesLayout);
        pnlRoutesLayout.setHorizontalGroup(
            pnlRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoutesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRoutes)
                    .addComponent(scrlpanRoutes, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        pnlRoutesLayout.setVerticalGroup(
            pnlRoutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoutesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRoutes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlpanRoutes, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTimes.setBackground(javax.swing.UIManager.getDefaults().getColor("TextArea.selectionBackground"));

        scrlpanTimes.setViewportView(lstTimes);

        javax.swing.GroupLayout pnlTimesLayout = new javax.swing.GroupLayout(pnlTimes);
        pnlTimes.setLayout(pnlTimesLayout);
        pnlTimesLayout.setHorizontalGroup(
            pnlTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(scrlpanTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnlTimesLayout.setVerticalGroup(
            pnlTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(scrlpanTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        lblTimes.setText("Times");

        btnAddRoute.setText("Add Route");
        btnAddRoute.setToolTipText("Create a new group of stops and stations.");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlRoutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimes)))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnAddRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTimes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlRoutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        mainMenuBar.setToolTipText("");

        menuFile.setText("File");

        menuFileNewRoute.setText("New Route");
        menuFileNewRoute.setName(""); // NOI18N
        menuFile.add(menuFileNewRoute);

        menuFileSaveRoute.setText("Save Route");
        menuFile.add(menuFileSaveRoute);

        MenuFileExit.setText("Exit");
        menuFile.add(MenuFileExit);

        mainMenuBar.add(menuFile);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuFileExit;
    private javax.swing.JButton btnAddRoute;
    private javax.swing.JLabel lblRoutes;
    private javax.swing.JLabel lblTimes;
    private javax.swing.JList<Route> lstRoutes;
    private javax.swing.JList<String> lstTimes;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileNewRoute;
    private javax.swing.JMenuItem menuFileSaveRoute;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRoutes;
    private javax.swing.JPanel pnlTimes;
    private javax.swing.JScrollPane scrlpanRoutes;
    private javax.swing.JScrollPane scrlpanTimes;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param listener
     */
    public void addLstRoutesListener(ListSelectionListener listener) {
        getLstRoutes().addListSelectionListener(listener);
    }

    /**
     *
     * @param listener
     */
    public void addLstTimesListener(ListSelectionListener listener) {
        getLstTimes().addListSelectionListener(listener);
    }

    /**
     *
     * @param listener
     */
    public void addBtnAddRouteListener(ActionListener listener) {
        btnAddRoute.addActionListener(listener);
    }

    /**
     * @return the lstRoutes
     */
    public JList<Route> getLstRoutes() {
        return lstRoutes;
    }

    /**
     * @return the lstTimes
     */
    public javax.swing.JList<String> getLstTimes() {
        return lstTimes;
    }
    
    
}
