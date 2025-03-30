package domain.repositories;

import java.util.List;
import java.util.Optional;

import domain.models.Customer;

public interface CustomerRepository {
  List<Customer> find(CustomerQuery query);

  default List<Customer> findAll() {
    return find(new CustomerQuery.Builder().build());
  }

  default Optional<Customer> findById(String id) {
    return find(new CustomerQuery.Builder().withId(id).build()).stream().findFirst();
  }
}
