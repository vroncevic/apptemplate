/**
 * AppContainer.java
 * Created on Feb 25, 2016, 7:03:13 PM
 * Copyright(c) Frobas d.o.o.
 */
package application;

import com.Utilities.AboutContainer;
import com.Utilities.HelpContainer;

/**
 * Application container
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class AppContainer {

    private AboutContainer about;
    private HelpContainer help;

    public AppContainer(AboutContainer about, HelpContainer help) {
        this.about = about;
        this.help = help;
    }

    public AboutContainer getAbout() {
        return about;
    }

    public void setAbout(AboutContainer about) {
        this.about = about;
    }

    public HelpContainer getHelp() {
        return help;
    }

    public void setHelp(HelpContainer help) {
        this.help = help;
    }
}
