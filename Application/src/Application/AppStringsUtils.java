/**
 * AppStringsUtils.java
 * Created on Feb 25, 2016, 2:43:24 PM
 * Copyright(c) Frobas doo
 */
package Application;

import java.util.Calendar;

/**
 * Application info
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class AppStringsUtils {

    public static String CurrentYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
    public static String ApplicationName = "Application";
    public static String CompanyName = "Frobas " + CurrentYear;
    public static String DepartmentName = "Frobas IT Department " + CurrentYear;
    public static String ApplicationAboutInfo = "Frobas, www.frobas.com";
    public static String ApplicationHelpInfo = "Help Topics";
    public static String LOG_LIN = "/data/vm";
    public static String LOG_WIN = "Z:\\vm\\";
}
