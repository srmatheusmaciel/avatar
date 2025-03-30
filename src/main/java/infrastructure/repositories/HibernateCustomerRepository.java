package infrastructure.repositories;

import java.util.List;

import domain.models.Customer;
import domain.models.ProfilePhoto;
import domain.repositories.CustomerQuery;
import domain.repositories.CustomerRepository;

public class HibernateCustomerRepository implements CustomerRepository {

  @Override
  public List<Customer> find(CustomerQuery query) {
    return List.of(new Customer("customerId", List.of(new ProfilePhoto(
            "profilePhotoId","originalPhoto", "generatedPhoto"))));
  }
}
