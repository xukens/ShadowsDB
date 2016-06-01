package pl.balif.shadows.tl.bootstrap.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import pl.balif.shadows.core.bootstrap.DevData;
import pl.balif.shadows.tl.controller.ControllersModule;
import pl.balif.shadows.core.converter.ConvertersModule;
import pl.balif.shadows.core.repositorie.RepoModule;
import pl.balif.shadows.core.service.ServicesModule;

@SpringBootApplication
@Import(RepoModule.class)
@ComponentScan(basePackageClasses = {ConvertersModule.class, RepoModule.class, ServicesModule.class, ControllersModule.class, DevData.class})
public class ShadowsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadowsApplication.class, args);
    }


}
