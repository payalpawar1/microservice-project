package com.skyscanner.hoen.api;
public class RentalCarService {
  private int id;
  private String city;
  private String provider;
  public RentalCarService() {}
  public RentalCarService(int id, String city, String provider) {
    this.id = id; this.city = city; this.provider = provider;
  }
  public int getId() { return id; }
  public String getCity() { return city; }
  public String getProvider() { return provider; }
}
