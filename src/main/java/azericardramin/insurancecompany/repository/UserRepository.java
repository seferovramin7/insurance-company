package azericardramin.insurancecompany.repository;

import azericardramin.insurancecompany.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findFirstByCompany(Long id);

}
