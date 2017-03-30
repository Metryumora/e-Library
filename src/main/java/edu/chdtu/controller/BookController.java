package edu.chdtu.controller;

import edu.chdtu.dao.BookDaoImpl;
import edu.chdtu.model.Book;
import edu.chdtu.model.ThisMonthPopular;
import edu.chdtu.model.ThisYearPopular;
import edu.chdtu.service.BookService;
import edu.chdtu.service.ThisMonthPopularService;
import edu.chdtu.service.ThisYearPopularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supreme on 09.12.2016.
 */

@Controller
@EnableAutoConfiguration
public class BookController {

    private static final int SORT_BY_NAME_ASC = 0;

    private static final int SORT_BY_NAME_DESC = 1;

    private static final int SORT_BY_PUBLISHING_ASC = 2;

    private static final int SORT_BY_PUBLISHING_DESC = 3;

    @Autowired
    BookService bookService;

    @Autowired
    ThisMonthPopularService thisMonthPopularService;

    @Autowired
    ThisYearPopularService thisYearPopularService;

    @RequestMapping(value = "/books", method = {RequestMethod.GET})
    public ModelAndView showAllBooks(ModelMap modelMap) {
        if (UserController.getActiveUser() != null) {
            modelMap.addAttribute("loggedin", true);
            modelMap.addAttribute("username", UserController.getActiveUser().getName());
        } else modelMap.addAttribute("loggedin", false);
        modelMap.addAttribute("books", bookService.getAll(BookDaoImpl.SORT_BY_NAME, BookDaoImpl.ORDER_DESC));
        return new ModelAndView("books");
    }

    @RequestMapping(value = "/search", method = {RequestMethod.POST})
    public ModelAndView showSearchResults(ModelMap modelMap,
                                          @RequestParam(name = "search_type") String searchEntity,
                                          @RequestParam(name = "search_query") String searchQuery,
                                          @RequestParam(name = "order_and_sort") String orderAndSort) {
        if (UserController.getActiveUser() != null) {
            modelMap.addAttribute("loggedin", true);
            modelMap.addAttribute("username", UserController.getActiveUser().getName());
        } else modelMap.addAttribute("loggedin", false);
        int searchType = Integer.parseInt(searchEntity);
        int orderAndSortType = Integer.parseInt(orderAndSort);
        List<Book> books = getMatchingBooks(searchQuery, searchType, orderAndSortType);
        modelMap.addAttribute("books", books);
        return new ModelAndView("books");
    }

    private List<Book> getMatchingBooks(@RequestParam(name = "search_query") String searchQuery, int searchType, int orderAndSortType) {
        List<Book> books = new ArrayList<Book>();
        switch (orderAndSortType) {
            case SORT_BY_NAME_ASC: {
                switch (searchType) {
                    case BookDaoImpl.SEARCH_BY_NAME: {
                        books = bookService.searchByName(searchQuery, BookDaoImpl.SORT_BY_NAME, BookDaoImpl.ORDER_ASC);
                        break;
                    }
                    case BookDaoImpl.SEARCH_BY_AUTHOR: {
                        books = bookService.searchByAuthor(searchQuery, BookDaoImpl.SORT_BY_NAME, BookDaoImpl.ORDER_ASC);
                        break;
                    }
                }
                break;
            }
            case SORT_BY_NAME_DESC: {
                switch (searchType) {
                    case BookDaoImpl.SEARCH_BY_NAME: {
                        books = bookService.searchByName(searchQuery, BookDaoImpl.SORT_BY_NAME, BookDaoImpl.ORDER_DESC);
                        break;
                    }
                    case BookDaoImpl.SEARCH_BY_AUTHOR: {
                        books = bookService.searchByAuthor(searchQuery, BookDaoImpl.SORT_BY_NAME, BookDaoImpl.ORDER_DESC);
                        break;
                    }
                }
                break;
            }
            case SORT_BY_PUBLISHING_ASC: {
                switch (searchType) {
                    case BookDaoImpl.SEARCH_BY_NAME: {
                        books = bookService.searchByName(searchQuery, BookDaoImpl.SORT_BY_PUBLISHING, BookDaoImpl.ORDER_ASC);
                        break;
                    }
                    case BookDaoImpl.SEARCH_BY_AUTHOR: {
                        books = bookService.searchByAuthor(searchQuery, BookDaoImpl.SORT_BY_PUBLISHING, BookDaoImpl.ORDER_ASC);
                        break;
                    }
                }
                break;
            }
            case SORT_BY_PUBLISHING_DESC: {
                switch (searchType) {
                    case BookDaoImpl.SEARCH_BY_NAME: {
                        books = bookService.searchByName(searchQuery, BookDaoImpl.SORT_BY_PUBLISHING, BookDaoImpl.ORDER_DESC);
                        break;
                    }
                    case BookDaoImpl.SEARCH_BY_AUTHOR: {
                        books = bookService.searchByAuthor(searchQuery, BookDaoImpl.SORT_BY_PUBLISHING, BookDaoImpl.ORDER_DESC);
                        break;
                    }
                }
                break;
            }
            default: {
                books = bookService.getAll();
            }
        }
        return books;
    }

    @RequestMapping(value = "/month_popular_books", method = {RequestMethod.GET})
    public ModelAndView showThisMonthPopularBooks(ModelMap modelMap) {
        List<Book> books = new ArrayList<>();
        List<Integer> downloads = new ArrayList<>();
        List<ThisMonthPopular> popularBooks = new ArrayList<>();
        popularBooks = thisMonthPopularService.getAll();
        if (!popularBooks.isEmpty()) {
            for (ThisMonthPopular book :
                    popularBooks) {
                books.add(bookService.get(book.getId()));
                downloads.add(book.getDownloads());
            }
        }
        if (UserController.getActiveUser() != null) {
            modelMap.addAttribute("loggedin", true);
            modelMap.addAttribute("username", UserController.getActiveUser().getName());
        } else modelMap.addAttribute("loggedin", false);
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("downloads", downloads);
        return new ModelAndView("month_popular_books");
    }

    @RequestMapping(value = "/year_popular_books", method = {RequestMethod.GET})
    public ModelAndView showThisYearPopularBooks(ModelMap modelMap) {
        List<Book> books = new ArrayList<>();
        List<Integer> downloads = new ArrayList<>();
        List<ThisYearPopular> popularBooks = new ArrayList<>();
        popularBooks = thisYearPopularService.getAll();
        if (!popularBooks.isEmpty()) {
            for (ThisYearPopular book :
                    popularBooks) {
                books.add(bookService.get(book.getId()));
                downloads.add(book.getDownloads());
            }
        }
        if (UserController.getActiveUser() != null) {
            modelMap.addAttribute("loggedin", true);
            modelMap.addAttribute("username", UserController.getActiveUser().getName());
        } else modelMap.addAttribute("loggedin", false);
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("downloads", downloads);
        return new ModelAndView("year_popular_books");
    }

}
