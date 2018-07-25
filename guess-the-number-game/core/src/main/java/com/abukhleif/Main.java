package com.abukhleif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // Create Context (Container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // Use bean
        log.info("randomNumber => {}", numberGenerator.next());
        log.info("maxNumber => {}", numberGenerator.getMaxNumber());


        Game game = context.getBean(Game.class);
        game.reset();

        // Close Context (Container)
        context.close();
    }
}
