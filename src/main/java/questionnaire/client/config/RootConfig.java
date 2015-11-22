package questionnaire.client.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import questionnaire.client.actor.ActorSystemHolder;
import questionnaire.client.service.HelloService;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {
	WebConfig.class,
	ActorSystemHolder.class,
	HelloService.class
})
public class RootConfig {
}
