package site.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Servlet Initializer
 *
 * @author gandrieu
 * @version 1.0
 */

public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Spring Application Builder
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(SiteApplication.class);
    }
}
