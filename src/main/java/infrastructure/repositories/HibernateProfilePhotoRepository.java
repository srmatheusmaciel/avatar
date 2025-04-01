package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HibernateProfilePhotoRepository implements ProfilePhotoRepository {
  public void save(String customerId, ProfilePhoto profilePhoto) {
    
  }

}
