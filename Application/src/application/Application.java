/**
 * Application.java
 * Created on Feb 25, 2016, 2:17:52 PM
 * Copyright(c) Frobas d.o.o.
 */
package application;

import com.Utilities.AboutContainer;
import com.Utilities.HelpContainer;
import com.Utilities.SplashScreen.SplashScreen;
import com.Utilities.Version;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main entry point
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class Application {

    private static AboutContainer about;
    private static HelpContainer help;
    private static AppContainer cont;
    private static Version ver;

    public static void main(String[] args) {
        if (args.length == 0) {
            SplashScreen splashScreen = new SplashScreen(3000, Application.class);
            ver = new Version();
            about = new AboutContainer(Application.class);
            about.setTitle("About " + AppStringsUtils.ApplicationName);
            about.setAppName(AppStringsUtils.ApplicationName + " ver." + ver.fullAppVersion());
            about.setCompanyName(AppStringsUtils.DepartmentName);
            about.setAppInfo(" " + AppStringsUtils.ApplicationAboutInfo);
            help = new HelpContainer(Application.class);
            help.setTitle(AppStringsUtils.ApplicationHelpInfo);
            help.setAppName(AppStringsUtils.ApplicationName + " ver." + ver.fullAppVersion());
            help.setCompanyName(AppStringsUtils.CompanyName);
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            }
            cont = new AppContainer(about, help);            
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ApplicationGUI(cont).setVisible(true);
                }
            });
        } else if (args.length == 1) {
            // TODO entry CLI code 
        }
    }
}
