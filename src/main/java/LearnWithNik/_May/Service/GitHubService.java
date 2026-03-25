package LearnWithNik._May.Service;

import LearnWithNik._May.Entity.GitHubUser;
import LearnWithNik._May.Repo.GitUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class GitHubService {

    @Autowired
    private GitUserRepo githubUserRepo;

    @Autowired
    RestTemplate restTemplate;

    ///  Rest Template
    public GitHubUser fetchAndPersist (String login){

        ResponseEntity<GitHubUser> gitHubUserResponseEntity = restTemplate.getForEntity("https://api.github.com/users/" + login, GitHubUser.class);
        if (Objects.nonNull(gitHubUserResponseEntity.getBody().getId())
                && Objects.nonNull(gitHubUserResponseEntity.getBody().getId())) {
            githubUserRepo.save(gitHubUserResponseEntity.getBody());
            return gitHubUserResponseEntity.getBody();
        }
        return  new GitHubUser();
    }
}
