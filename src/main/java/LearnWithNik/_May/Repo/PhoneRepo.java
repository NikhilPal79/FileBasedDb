package LearnWithNik._May.Repo;

import LearnWithNik._May.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends JpaRepository<Phone,Integer> {

}
