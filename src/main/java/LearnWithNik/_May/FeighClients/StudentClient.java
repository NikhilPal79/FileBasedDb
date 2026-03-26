package LearnWithNik._May.FeighClients;

import LearnWithNik._May.Entity.GitHubUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "studentClient", url = " https://api.github.com/users"  )
public interface StudentClient {

    @GetMapping("/{login}")
    ResponseEntity<GitHubUser> getGitUser(@PathVariable("login") String login);
}
