package com.skyscanner.hoen.api;
public class Hotel {
  private int id;
  private String city;
  private String name;
  public Hotel() {}
  public Hotel(int id, String city, String name) {
    this.id = id; this.city = city; this.name = name;
  }
  public int getId() { return id; }
  public String getCity() { return city; }
  public String getName() { return name; }
}
