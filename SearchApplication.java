package com.skyscanner.hoen;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.skyscanner.hoen.resource.SearchResource;
import com.skyscanner.hoen.service.SearchService;
import com.skyscanner.hoen.health.TemplateHealthCheck;

public class SearchApplication extends Application<SearchConfiguration> {
  public static void main(String[] args) throws Exception {
    new SearchApplication().run(args);
  }

  @Override
  public void run(SearchConfiguration config, Environment env) throws Exception {
    SearchService svc = new SearchService(
      config.getHotelsFilePath(), config.getCarsFilePath());
    env.jersey().register(new SearchResource(svc));
    env.healthChecks().register("basic", new TemplateHealthCheck());
  }
}
