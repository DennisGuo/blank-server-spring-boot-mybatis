package cn.geobeans.web.blank_mybatis.config;

import com.github.miemiedev.mybatis.paginator.jackson2.PageListJsonMapper;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.*;

/**
 * Created by ghx on 2016/12/15.
 */
@Configuration
@EnableSwagger
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Bean
    public SwaggerSpringMvcPlugin swaggerSpringMvcPlugin(){
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .apiInfo(getApiInfo());
    }

    @Bean
    public HttpMessageConverters converters(){
        // API分页对象转换
        MappingJackson2HttpMessageConverter jmc = new MappingJackson2HttpMessageConverter(new PageListJsonMapper());
        return new HttpMessageConverters(jmc);
    }

    public ApiInfo getApiInfo() {
        return new ApiInfo(
                "Geobeans API",//"Title",
                "欢迎使用Geobeans API",//"Description",
                "",//"termsOfServiceUrl",
                "guohengxi.dennis@gmail.com",//"contact",
                "",//"license",
                ""//"license url"
        );
    }
}
