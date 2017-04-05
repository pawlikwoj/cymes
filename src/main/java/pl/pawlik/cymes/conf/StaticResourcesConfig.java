package pl.pawlik.cymes.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pawlik on 17.03.2017.
 */
@Configuration
@EnableWebMvc
public class StaticResourcesConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/static/");

        registry.addResourceHandler("/resources/clean/**")
                .addResourceLocations("/resources/themes/clean/static/");
        registry.addResourceHandler("/resources/dark/**")
                .addResourceLocations("/resources/themes/clean/static/");
    }
}
