package uhk.fim.toolsrental.configurations;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path productImagesDir = Paths.get("./product-files");
        String productPath = productImagesDir.toFile().getAbsolutePath();
        registry
                .addResourceHandler("/product-files/**")
                .addResourceLocations("file:/" + productPath + "/");
    }
}
