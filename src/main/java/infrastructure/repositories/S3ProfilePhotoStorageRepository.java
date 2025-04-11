package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoStorageRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class S3ProfilePhotoStorageRepository implements ProfilePhotoStorageRepository {
    @Override
    @Transactional
    public Uni<String> store(String customerId, ProfilePhoto profilePhoto) {
        return null;
    }
}
