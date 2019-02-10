package com.alu.scaffold.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jairy
 * @date 2019/1/15
 */
@Configuration
public class RabbitConfig {

    private static String oneExchange = "";

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

}
