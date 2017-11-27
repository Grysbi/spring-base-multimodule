package site.controller.home;

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
public class Home {

    /**
     * Home
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){

        ModelAndView model = new ModelAndView();
        model.setViewName("home/index");

        return model;
    }

}
