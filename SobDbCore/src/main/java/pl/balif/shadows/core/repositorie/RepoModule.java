package pl.balif.shadows.core.repositorie;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.balif.shadows.core.domain.BaseEntity;

/**
 * Created by RudyKot on 2016-05-27.
 */
@Configuration
@EnableJpaAuditing
@EntityScan(basePackageClasses = {BaseEntity.class})
@EnableJpaRepositories(basePackageClasses = HeroRepository.class)
public interface RepoModule {
}
