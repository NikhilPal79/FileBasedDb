package LearnWithNik._May.Api;

import LearnWithNik._May.Entity.GitHubUser;
import LearnWithNik._May.Service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gituser")
public class GitUserController {

    @Autowired
    GitHubService gitHubService;

    @GetMapping("/fetch")
    public GitHubUser fetchUser(@RequestParam String username){
        return gitHubService.fetchAndPersist(username);
    }



}
