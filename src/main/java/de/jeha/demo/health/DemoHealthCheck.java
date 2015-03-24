package de.jeha.demo.health;

import com.codahale.metrics.health.HealthCheck;
import org.springframework.stereotype.Service;

/**
 * @author jenshadlich@googlemail.com
 */
@Service
public class DemoHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return HealthCheck.Result.healthy();
    }
}
