/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tech.romashov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.romashov.configuration.Environment;

import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.event.WindowEvent;

public class App implements AutoCloseable {
    private Logger logger = LoggerFactory.getLogger(App.class);
    private Frame mainFrame;

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        App app = new App();
        app.start(Environment.Production);
    }

    public void start(Environment environment) {
        logger.info("Start application");
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame = new ContentPaneReplace(environment);
    }

    @Override
    public void close() {
        logger.info("Close application");
        mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
    }
}
