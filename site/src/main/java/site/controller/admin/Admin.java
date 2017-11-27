package site.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller home
 *
 * @author gandrieu
 * @version 1.0
 */

@Controller
public class Admin {

    /**
     * Admin
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(){

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/admin");

        return model;
    }
}
