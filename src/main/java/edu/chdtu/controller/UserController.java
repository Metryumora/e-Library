package edu.chdtu.controller;

import edu.chdtu.model.User;
import edu.chdtu.service.BookService;
import edu.chdtu.service.DownloadService;
import edu.chdtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Metr_yumora on 06.12.2016.
 */

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    DownloadService downloadService;

    private static User activeUser;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView showMainPage(ModelMap modelMap) {
        if (activeUser != null) {
            modelMap.addAttribute("username", activeUser.getName());
            modelMap.addAttribute("loggedin", true);
        } else {
            modelMap.addAttribute("loggedin", false);
            modelMap.addAttribute("message", "This website is an e-book library.");
        }
        return new ModelAndView("main");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelMap modelMap, @RequestParam("login") String login, @RequestParam(name = "password") char password[]) {
        User user = userService.getByLogin(login);
        if (user.verifyPassword(password)) {
            activeUser = user;
            modelMap.addAttribute("username", activeUser.getName());
            modelMap.addAttribute("loggedin", true);
            modelMap.addAttribute("loginSuccessful",true);
            modelMap.addAttribute("message", "You have successfully logged in!");
        } else {
            modelMap.addAttribute("loginSuccessful",true);
            modelMap.addAttribute("loggedin", false);
            modelMap.addAttribute("message", "Invalid login or password!");
        }
        return new ModelAndView("main");
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public String logout(ModelMap modelMap) {
        activeUser = null;
        return "redirect:";
    }

    public static User getActiveUser() {
        return activeUser;
    }

    @RequestMapping(value = "/downloads", method = {RequestMethod.GET})
    public ModelAndView showDownloads(ModelMap modelMap) {
        if (UserController.getActiveUser() != null) {
            modelMap.addAttribute("loggedin", true);
            modelMap.addAttribute("username", UserController.getActiveUser().getName());
        } else modelMap.addAttribute("loggedin", false);
        modelMap.addAttribute("downloads", downloadService.getForUser(activeUser));
        return new ModelAndView("downloads");
    }

    @RequestMapping(value = "/deactivate_downloads", method = {RequestMethod.POST})
    public String deactivateDownloads(ModelMap modelMap) {
        downloadService.deactivateDownloadsForUser(activeUser);
        return "redirect:/downloads";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ModelAndView register(
            ModelMap modelMap,
            @RequestParam String name,
            @RequestParam String login,
            @RequestParam String mail,
            @RequestParam char[] password) {
        User newUser = new User(name, login, password, mail);
        try {
            userService.add(newUser);
            modelMap.addAttribute("message", "Registration successful. You can now log in");
            modelMap.addAttribute("registrationSuccessful", true);
        } catch (Exception exception) {
            modelMap.addAttribute("registrationSuccessful", false);
            modelMap.addAttribute("message", "Error during registration. Please change values and try again");
        }
        modelMap.addAttribute("loggedin", false);
        return new ModelAndView("main");
    }

    @RequestMapping(value = "/sign_up", method = {RequestMethod.GET})
    public ModelAndView showRegister(ModelMap modelMap) {
        if (activeUser != null) {
            modelMap.addAttribute("loggedin", true);
            return new ModelAndView("main");
        } else {
            modelMap.addAttribute("loggedin", false);
            modelMap.addAttribute("message", "Please, fill the fields carefully!");
        }
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/about", method = {RequestMethod.GET})
    public ModelAndView showAbout(ModelMap modelMap) {
        if (activeUser != null) {
            modelMap.addAttribute("loggedin", true);
        } else {
            modelMap.addAttribute("loggedin", false);
        }
        return new ModelAndView("about");
    }
}
