package site.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller Login
 *
 * @author gandrieu
 * @version 1.0
 */

@Controller
public class login {

    /**
     * Login Page
     *
     * @param error
     * @param logout
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout){

        ModelAndView model = new ModelAndView();
        model.addObject("error", error);
        model.addObject("msg", logout);

        model.setViewName("auth/login");

        return model;
    }

}
