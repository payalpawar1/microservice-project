package com.skyscanner.hoen.health;
import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
  @Override
  protected Result check() {
    return Result.healthy();
  }
}
