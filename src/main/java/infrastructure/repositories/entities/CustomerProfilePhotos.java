package infrastructure.repositories.entities;

import java.util.List;

import domain.models.Customer;
import domain.models.ProfilePhoto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name="profile_photo")
public class CustomerProfilePhotos {

    @EmbeddedId
    CompositeKey compositeKey;

    @Column(name = "original_photo")
    String originalPhoto;

    @Column(name = "generated_photo")
    String generatedPhoto;



    @Embeddable
    static class CompositeKey{

        @Column(name = "customer_id")
        String customerId;
        @Column(name = "id")
        String Id;
    }

    public Customer toDomain(){
        return new Customer(compositeKey.customerId,
         List.of(new ProfilePhoto(compositeKey.Id,
                                 originalPhoto,
                                 generatedPhoto)));
    }

    public static CustomerProfilePhotos fromDomain(String customerId, ProfilePhoto profilePhoto){
        var entity = new CustomerProfilePhotos();

        entity.compositeKey = new CompositeKey();
        entity.compositeKey.customerId = customerId;
        entity.compositeKey.Id = profilePhoto.id();

        entity.originalPhoto = profilePhoto.originalPhoto();
        entity.generatedPhoto = profilePhoto.generatedPhoto();

        return entity;
    }

}
