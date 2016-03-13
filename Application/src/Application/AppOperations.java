/**
 * AppClose.java
 * Created on Feb 25, 2016, 6:34:11 PM
 * Copyright(c) Frobas doo
 */
package Application;

import com.Utilities.Dialog;
import com.Utilities.Logging;
import com.Utilities.OSValidator;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Application operations
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class AppOperations {

    private Dialog dialog;

    public AppOperations(Component parentComponent) {
        this.dialog = new Dialog(parentComponent);
    }

    public void AppClose(ApplicationSession config, Settings setting) {
        int status = dialog.ShowDialog("Exit " + AppStringsUtils.ApplicationName + 
                " ?", "Confirm Exit!", JOptionPane.YES_NO_OPTION);
        if (status == JOptionPane.YES_OPTION) {
            config.write(setting);
            System.exit(0);
        }
    }
    
    public void AppStart(AppContainer cont) {
        String Path = System.getProperty("user.dir");
        if (OSValidator.isUnix()) {
            Path = AppStringsUtils.LOG_LIN;
        } else if (OSValidator.isWindows()) {
            Path = AppStringsUtils.LOG_WIN;
        } 
        Logging.logging("Info", "Started " + cont.getAbout().getAppName(),
        Path, AppStringsUtils.ApplicationName);
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}
