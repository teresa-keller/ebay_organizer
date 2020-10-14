package launchcode.org.ebay.organizer.models;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MvcWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {MultiHttpSecurityConfig.class};
    }
}
