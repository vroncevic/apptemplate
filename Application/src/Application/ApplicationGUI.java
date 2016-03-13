/**
 * ApplicationGUI.java
 * Created on Feb 25, 2016, 2:17:52 PM
 * Copyright(c) Frobas doo
 */
package Application;

import com.Utilities.About.About;
import com.Utilities.Help.Help;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * Main Application Frame
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class ApplicationGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = -6414724641777161657L;
    private final About aboutui;
    private final Help helpui;
    private ApplicationSession config;
    private Settings setting;
    private AppOperations appoperations;

    public ApplicationGUI(AppContainer cont) {
        initComponents();
        this.aboutui = new About(cont.getAbout());
        this.helpui = new Help(cont.getHelp());
        this.setting = new Settings(cont.getAbout().getAppName());
        this.config = 
                new ApplicationSession("." + AppStringsUtils.ApplicationName, 
                        AppStringsUtils.ApplicationName + ".cfg");
        this.setting = (Settings) config.read(setting);
        this.appoperations = new AppOperations(this);
        this.appoperations.AppStart(cont);
        if (setting != null) {
            // TODO Check settings
        } else {
            setting.setVersion("1.0.b");
        }
        super.setIconImage(cont.getAbout().getAppIcon().getImage());
        super.setTitle(setting.getVersion());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(dim.width / 4 - super.getSize().width / 4, dim.height / 4 - super.getSize().height / 4);
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                appoperations.AppClose(config, setting);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AppMenuBar = new javax.swing.JMenuBar();
        AppFile = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        AppEdit = new javax.swing.JMenu();
        AppOption = new javax.swing.JMenu();
        AppHelp = new javax.swing.JMenu();
        HelpContents = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AppFile.setText("File");

        Exit.setText("Close and Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        AppFile.add(Exit);

        AppMenuBar.add(AppFile);

        AppEdit.setText("Edit");
        AppMenuBar.add(AppEdit);

        AppOption.setText("Option");
        AppMenuBar.add(AppOption);

        AppHelp.setText("Help");

        HelpContents.setText("HelpContents");
        HelpContents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpContentsActionPerformed(evt);
            }
        });
        AppHelp.add(HelpContents);

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        AppHelp.add(About);

        AppMenuBar.add(AppHelp);

        setJMenuBar(AppMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        appoperations.AppClose(config, setting);
    }//GEN-LAST:event_ExitActionPerformed

    private void HelpContentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpContentsActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                helpui.setVisible(true);
            }
        });
    }//GEN-LAST:event_HelpContentsActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                aboutui.setVisible(true);
            }
        });
    }//GEN-LAST:event_AboutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenu AppEdit;
    private javax.swing.JMenu AppFile;
    private javax.swing.JMenu AppHelp;
    private javax.swing.JMenuBar AppMenuBar;
    private javax.swing.JMenu AppOption;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem HelpContents;
    // End of variables declaration//GEN-END:variables
}
