package edu.chdtu.controller;

import edu.chdtu.model.Book;
import edu.chdtu.model.Download;
import edu.chdtu.service.BookService;
import edu.chdtu.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 * Created by Supreme on 09.12.2016.
 */

@Controller
@EnableAutoConfiguration
public class DownloadController {

    @Autowired
    public DownloadService downloadService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/download", method = {RequestMethod.POST})
    public String showBooks(ModelMap modelMap, @RequestParam(name = "bookId") String id) {
        Book requestedBook = bookService.get(Integer.parseInt(id));
        downloadService.add(new Download(UserController.getActiveUser(), requestedBook));
        return "redirect:" + requestedBook.getUrl();
    }

    //Debug
    @RequestMapping(value = "/randomDownloads", method = {RequestMethod.GET})
    public ModelAndView fillRandom() {
        addRandomAnonymousDownloads(1000);
        return new ModelAndView("main");
    }

    private void addRandomAnonymousDownloads(int n) {
        for (int i = 0; i < n; i++) {
            downloadService.add(new Download(bookService.get(1 + new Random().nextInt(bookService.getAll().size()))));
        }
    }
    //Debug

}
