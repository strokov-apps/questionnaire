package questionnaire.client.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import questionnaire.client.web.CalculatorEndpoint;

import javax.validation.constraints.NotNull;

@Configuration
@ComponentScan(basePackageClasses = {
    CalculatorEndpoint.class
})
public class WebConfig {

    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory(@NotNull @Value("${server.port}") Integer serverPort) {
        return new UndertowEmbeddedServletContainerFactory(serverPort);
    }

    /**
     * All Endpoints must be registered here before they can be accessed
     * */
    @Bean
    ResourceConfig jerseyConfig(@NotNull @Value("${static.content.path.regex}") String staticContentPathRegex) {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.property(ServletProperties.FILTER_STATIC_CONTENT_REGEX, staticContentPathRegex);

        // Endpoint registration
        resourceConfig.register(CalculatorEndpoint.class);
        return resourceConfig;
    }
}
