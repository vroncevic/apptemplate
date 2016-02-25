/**
 * Settings.java
 * Created on Feb 25, 2016, 2:17:52 PM
 * Copyright(c) Frobas d.o.o.
 */
package application;

/**
 * Global settings for tool Application
 *
 * @author Vladimir Roncevic <vladimir.roncevic@frobas.com>
 */
public class Settings {

    private String Version;

    public Settings(String version) {
        this.Version = version;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }
}
