package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoRepository;
import jakarta.enterprise.context.RequestScoped;

import java.util.Map;
import org.jboss.logging.Logger;

@RequestScoped
public class UnityOfWorkProfilePhotoRepository implements ProfilePhotoRepository {

    private final HibernateProfilePhotoPersistenceRepository persistenceRepository;
    private final S3ProfilePhotoStorageRepository storageRepository;
    private Map<String, ProfilePhoto> entities;

    public UnityOfWorkProfilePhotoRepository(HibernateProfilePhotoPersistenceRepository persistenceRepository,
                                             S3ProfilePhotoStorageRepository storageRepository) {
        this.persistenceRepository = persistenceRepository;
        this.storageRepository = storageRepository;
        this.entities = Map.of();
    }

    @Override
    public void registerEntities(Map<String, ProfilePhoto> entities) {

    }

    @Override
    public void commit() {
        entities.forEach((customerId, profilePhoto) -> {
            try{
                persistenceRepository.save(customerId, profilePhoto);

                var url = storageRepository.store(customerId, profilePhoto).await().indefinitely();
                var updated = new ProfilePhoto(profilePhoto.id(), url, profilePhoto.generatedPhoto());

                persistenceRepository.save(customerId, updated);
            }
            catch (Exception exception){
                Logger.getLogger(getClass()).error(exception);
            }
        });

    }

    @Override
    public void rollback() {

    }
}
