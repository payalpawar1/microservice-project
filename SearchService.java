package com.skyscanner.hoen.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.skyscanner.hoen.api.Hotel;
import com.skyscanner.hoen.api.RentalCarService;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class SearchService {
  private final List<Hotel> hotels;
  private final List<RentalCarService> cars;

  public SearchService(String hotelsPath, String carsPath) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    try (InputStream h = getClass().getClassLoader().getResourceAsStream(hotelsPath);
         InputStream c = getClass().getClassLoader().getResourceAsStream(carsPath)) {
      if (h == null || c == null) {
        throw new IllegalStateException("Missing data files");
      }
      hotels = mapper.readValue(h, new TypeReference<List<Hotel>>() {});
      cars   = mapper.readValue(c, new TypeReference<List<RentalCarService>>() {});
    }
  }

  public List<Object> searchByCity(String city) {
    String norm = city.trim().toLowerCase();
    List<Object> result = new ArrayList<>();
    hotels.stream()
      .filter(h -> norm.equals(h.getCity().toLowerCase()))
      .forEach(result::add);
    cars.stream()
      .filter(c -> norm.equals(c.getCity().toLowerCase()))
      .forEach(result::add);
    return result;
  }
}
