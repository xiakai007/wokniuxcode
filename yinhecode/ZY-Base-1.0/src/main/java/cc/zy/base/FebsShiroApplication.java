package cc.zy.base;

import cc.zy.base.common.annotation.FebsShiro;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author MrBird
 */
@FebsShiro
@EnableScheduling
public class FebsShiroApplication  extends SpringBootServletInitializer {

    @Override

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FebsShiroApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(FebsShiroApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
