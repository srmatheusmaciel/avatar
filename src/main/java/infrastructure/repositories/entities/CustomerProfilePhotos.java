package infrastructure.repositories.entities;

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

}
