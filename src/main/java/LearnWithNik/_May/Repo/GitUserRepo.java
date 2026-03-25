package LearnWithNik._May.Repo;

import LearnWithNik._May.Entity.GitHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GitUserRepo extends JpaRepository<GitHubUser,Integer> {


    Optional<GitHubUser> findByLogin(String login);
}
