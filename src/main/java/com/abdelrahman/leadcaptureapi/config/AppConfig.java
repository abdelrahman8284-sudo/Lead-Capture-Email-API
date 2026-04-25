package com.abdelrahman.leadcaptureapi.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableJpaAuditing
@EnableAsync
public class AppConfig {
	
	 @Bean(name = "taskExecutor")
	    public Executor taskExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(2);
	        executor.setMaxPoolSize(5);
	        executor.setQueueCapacity(100);
	        executor.setThreadNamePrefix("EmailThread-");
	        executor.initialize();
	        return executor;
	    }
}
