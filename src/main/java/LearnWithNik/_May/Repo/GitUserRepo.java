package LearnWithNik._May.Repo;

import LearnWithNik._May.Entity.GitHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitUserRepo extends JpaRepository<GitHubUser,Integer> {
}
