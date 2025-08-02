package com.skyscanner.hoen;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

public class SearchConfiguration extends Configuration {
  @NotEmpty
  private String hotelsFilePath;

  @NotEmpty
  private String carsFilePath;

  @JsonProperty public String getHotelsFilePath() { return hotelsFilePath; }
  @JsonProperty public String getCarsFilePath() { return carsFilePath; }
}
