package com.skyscanner.hoen.resource;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.skyscanner.hoen.service.SearchService;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
  private final SearchService service;

  public SearchResource(SearchService svc) {
    this.service = svc;
  }

  @GET
  public Response byCity(@QueryParam("city") String city) {
    if (city == null || city.isBlank()) {
      return Response.status(Response.Status.BAD_REQUEST)
                     .entity("'city' query parameter is required").build();
    }
    return Response.ok(service.searchByCity(city)).build();
  }
}
