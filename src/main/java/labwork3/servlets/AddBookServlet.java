package labwork3.servlets;



import labwork3.dao.DAO;
import labwork3.entities.Book;
import labwork3.entities.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO<Category, Integer> categoryDAO = new DAO<>(Category.class);
        List<Category> categories = categoryDAO.selectAll();
        req.getSession().setAttribute("categories", categories);
        req.getRequestDispatcher("/views/addBook.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        DAO<Category, Integer> categoryDAO = new DAO<>(Category.class);
        Category category = categoryDAO.select(categoryId);
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        int year = Integer.parseInt(req.getParameter("year"));
        int numOfPages = Integer.parseInt(req.getParameter("numOfPages"));
        float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        boolean availability = Boolean.parseBoolean(req.getParameter("availability"));
        String image = req.getParameter("image");
        DAO<Book, Integer> bookDAO = new DAO<>(Book.class);
        bookDAO.create(new Book(category, name, author, year, numOfPages, price, description, availability, image));
        req.getRequestDispatcher("/views/catalog.jsp").forward(req, resp);
    }
}
