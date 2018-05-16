package com.jiangzhuolin;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.lenovo.*"})
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * 配置 FastJSON 解析 json 对象
     */
    @Override  
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {  
    	super.configureMessageConverters(converters);  
    	FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();  
       
        FastJsonConfig fastJsonConfig = new FastJsonConfig();  
        fastJsonConfig.setSerializerFeatures(  
        		SerializerFeature.PrettyFormat
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);  
        
        converters.add(fastConverter);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动完成!");
    }
}
