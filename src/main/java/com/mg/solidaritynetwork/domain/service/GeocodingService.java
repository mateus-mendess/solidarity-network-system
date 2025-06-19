package com.mg.solidaritynetwork.domain.service;

import com.mg.solidaritynetwork.dto.request.AddressRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Service
public class GeocodingService {

    @Value("${google.api.key}")
    private String apiKey;
    private static  final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    public List<Double> getCoordinates(AddressRequest addressRequest) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl(GEOCODING_API_URL).queryParam("address", addressRequest.getAddress()).queryParam("key", this.apiKey).build().encode().toUri();

        Map response = restTemplate.getForObject(uri, Map.class);

        Map location = (Map) ((Map) ((Map) ((List<?>) response.get("results")).get(0)).get("geometry")).get("location");

        Double lat = (Double) location.get("lat");
        Double lng = (Double) location.get("lng");

        return List.of(lat, lng);
    }
}
