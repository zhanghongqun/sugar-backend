package com.sugar;

import com.sugar.infrastructure.client.EDBClient;
import com.sugar.infrastructure.edb.Invocation;
import com.sugar.infrastructure.task.TokenTask;
import com.sugar.service.WXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 *
 *
 * */
@SpringBootApplication
@EnableFeignClients
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Autowired
    EDBClient edbClient;
    @Autowired
    WXService wxService;
    @Autowired
    TokenTask tokenTask;


    @Bean
    public CommandLineRunner bootstrap() {
        return strings -> {
            tokenTask.updateToken();
            //wxService.getUserInfo("oEFWFw94hgmwZs1edg7qXoGiGMkU");
            //wxService.createMenu();
            //edbClient.get(new Invocation().getRequestMap());
        };
    }


}
