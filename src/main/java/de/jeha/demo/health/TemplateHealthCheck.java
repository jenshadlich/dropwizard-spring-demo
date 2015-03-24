package de.jeha.demo.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author jenshadlich@googlemail.com
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "CHECK");
        if (!saying.contains("CHECK")) {
            return Result.unhealthy("template doesn't include a name placeholder");
        }
        return HealthCheck.Result.healthy();
    }
}
