package de.jeha.demo;

import de.jeha.demo.health.TemplateHealthCheck;
import de.jeha.demo.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author jenshadlich@googlemail.com
 */
public class DemoApplication extends Application<DemoConfiguration> {

    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "demo";
    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
    }

    @Override
    public void run(DemoConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource =
                new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}