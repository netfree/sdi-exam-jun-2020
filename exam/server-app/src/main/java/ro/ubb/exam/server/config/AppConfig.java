package ro.ubb.exam.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ubb.exam.common.SensorService;
import ro.ubb.exam.server.repository.SensorRepository;
import ro.ubb.exam.server.repository.SensorRepositoryImpl;
import ro.ubb.exam.server.service.SensorServiceImpl;

import java.util.concurrent.Executors;

@Configuration
public class AppConfig {
    @Bean
    SensorRepository sensorRepository() {
        return new SensorRepositoryImpl();
    }

    @Bean
    SensorService sensorService() {
        return new SensorServiceImpl(Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        ));
    }

}
