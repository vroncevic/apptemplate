/**
 * ApplicationSession.java
 * Created on Feb 25, 2016, 2:17:52 PM
 * Copyright(c) Frobas doo
 */
package Application;

import com.Utilities.AppConfig.Session;


/**
 * Global session for tool Application
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class ApplicationSession extends Session  {

    public ApplicationSession(String CfgDir, String CfgFile) {
        super(CfgDir, CfgFile);
    }
}
