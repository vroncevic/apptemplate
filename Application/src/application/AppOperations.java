/**
 * AppClose.java
 * Created on Feb 25, 2016, 6:34:11 PM
 * Copyright(c) Frobas d.o.o.
 */
package application;

import com.Utilities.Dialog;
import com.Utilities.Logging;
import com.Utilities.OSValidator;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Closing Application
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class AppOperations {

    private Dialog dialog;

    public AppOperations(Component parentComponent) {
        this.dialog = new Dialog(parentComponent);
    }

    public void AppClose(ApplicationSession config, Settings setting) {
        int status = dialog.ShowDialog("Exit " + AppStringsUtils.ApplicationName + " ?", "Confirm Exit!", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            config.write(setting);
            System.exit(0);
        }
    }
    
    public void AppStart(AppContainer cont) {
        if (OSValidator.isUnix()) {
            Logging.logging("Info", "Started " + AppStringsUtils.ApplicationName + " " + cont.getAbout().getAppName(),
                    "/data/apps/logs/" + AppStringsUtils.ApplicationName + "/", AppStringsUtils.ApplicationName);
        } else if (OSValidator.isWindows()) {
            Logging.logging("Info", "Started " + AppStringsUtils.ApplicationName + " " + cont.getAbout().getAppName(),
                    System.getProperty("user.home") + "/", AppStringsUtils.ApplicationName);
        } else {
            Logging.logging("Error", "Unsupported OS" + " " + cont.getAbout().getAppName(),
                    System.getProperty("user.home") + "/", AppStringsUtils.ApplicationName);
        }
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}
