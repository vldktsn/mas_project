package edu.pja.mas.s19183.mas;

import edu.pja.mas.s19183.mas.gui.controllers.MainWindowController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class MasApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MasApplication.class).headless(false)
                .run(args);

        SwingUtilities.invokeLater(() -> {
            ctx.getBean(MainWindowController.class).showGUI();
        });
    }

}
