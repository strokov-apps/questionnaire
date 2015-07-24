package questionnaire.client.config;

import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import questionnaire.client.web.IndexController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {
	IndexController.class
})
public class WebConfig {
	@Bean
	UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
		return new UndertowEmbeddedServletContainerFactory();
	}
}
