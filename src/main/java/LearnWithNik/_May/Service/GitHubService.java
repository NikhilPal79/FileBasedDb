package LearnWithNik._May.Service;

import LearnWithNik._May.Entity.GitHubUser;
import LearnWithNik._May.FeighClients.StudentClient;
import LearnWithNik._May.Repo.GitUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class GitHubService {

    @Autowired
    private GitUserRepo githubUserRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;


    @Autowired
    private StudentClient studentClient;

    ///  Rest Template
    /*public GitHubUser fetchAndPersist (String login){

        ResponseEntity<GitHubUser> gitHubUserResponseEntity = restTemplate.getForEntity("https://api.github.com/users/" + login, GitHubUser.class);
        if (Objects.nonNull(gitHubUserResponseEntity.getBody().getId())
                && Objects.nonNull(gitHubUserResponseEntity.getBody().getId())) {
            githubUserRepo.save(gitHubUserResponseEntity.getBody());
            return gitHubUserResponseEntity.getBody();
        }
        return  new GitHubUser();
    }*/

    /*
    * Summary
RestTemplate acts as a simple HTTP client in your service, allowing you to:

Call external APIs (GitHub)

Map JSON responses to your Java objects automatically

Handle responses as ResponseEntity for full HTTP metadata*/

/*
    public GitHubUser fetchAndPersist(String login) {

        /// check in database first
        Optional<GitHubUser> byLogin = githubUserRepo.findByLogin(login);

        if (byLogin.isPresent()) {
            return byLogin.get();
        }
        ; /// return form the cache(db)

        /// not in DB - fetch from github api


        try {
            ResponseEntity<GitHubUser> response = restTemplate.getForEntity("https://api.github.com/users/" + login, GitHubUser.class);

            GitHubUser user = response.getBody();

            /// validate response

            if (user != null && user.getId() != null) {

                githubUserRepo.save(user);
                return user;
            } else {
                throw new RuntimeException("User not found");
            }

        } catch (RuntimeException e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }*/

        /*
        * . Complete flow
First request for a user:

DB check → not found

Call GitHub API → success

Save to DB

Return user

Subsequent requests for the same user:

DB check → found

Return user directly → no API call*/





    /// web client
    /*private ResponseEntity<GitHubUser> consumeWithWebClient(String login){
        Mono<ResponseEntity<GitHubUser>> gitHubUserMonoResponseEntityMono = webClient
                .get()
                .uri("https://api.github.com/users/" + login)
                .header("authId", "asd234")
                .retrieve()
                .toEntity(GitHubUser.class);

        ResponseEntity<GitHubUser> gitHubUserResponseEntity = gitHubUserMonoResponseEntityMono.block();
        return gitHubUserResponseEntity;
    }

    public GitHubUser fetchAndPersist(String login){

        ResponseEntity<GitHubUser> gitHubUserResponseEntity = consumeWithWebClient(login);
        if (Objects.nonNull(gitHubUserResponseEntity.getBody()) &&
        Objects.nonNull(gitHubUserResponseEntity.getBody().getId())) {
            githubUserRepo.save(gitHubUserResponseEntity.getBody());
            return gitHubUserResponseEntity.getBody();
        }
        return new GitHubUser();
    }*/


    /// feigh client

    public GitHubUser fetchAndPersist(String login) {

        ResponseEntity<GitHubUser> studentClientGitUser = studentClient.getGitUser(login);

        if (Objects.nonNull(studentClientGitUser.getBody()) &&
        Objects.nonNull(studentClientGitUser.getBody().getId())) {
            githubUserRepo.save(studentClientGitUser.getBody());
            return studentClientGitUser.getBody();

        }
        return new GitHubUser();




    }
}
