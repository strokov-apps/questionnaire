package questionnaire.client.config;

import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import questionnaire.client.web.IndexController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {
	IndexController.class
})
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
		return new UndertowEmbeddedServletContainerFactory();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/static/");
	}
}
