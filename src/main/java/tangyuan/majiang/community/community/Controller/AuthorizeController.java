package tangyuan.majiang.community.community.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tangyuan.majiang.community.community.DTO.AccessTokenDTO;
import tangyuan.majiang.community.community.DTO.GithubUser;
import tangyuan.majiang.community.community.Provider.GithubProvider;

/*
 * @author:ty
 * @create:2019-07-13 16:24
 * */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.gitAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.gitUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
