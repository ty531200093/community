package tangyuan.majiang.community.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author:ty
 * @create:2019-07-12 16:52
 * */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index()
    {
        return "index";
    }
}
