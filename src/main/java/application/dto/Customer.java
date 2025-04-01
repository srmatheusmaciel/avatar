package application.dto;

import java.util.List;

import domain.models.ProfilePhoto;

public record Customer(String customerId, List<String> photos) {
    public static Customer fromDomain(domain.models.Customer domain) {
        return new Customer(domain.id(),
        domain.profilePhotos().stream().map(ProfilePhoto::generatedPhoto).toList()
        );
    }
}