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

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO<Category, Integer> categoryDAO = new DAO<>(Category.class);
        List<Category> categories = categoryDAO.selectAll();
        req.getSession().setAttribute("categories", categories);

        String stringId = req.getParameter("id");
        if (stringId != null) {
            List<Book> books = categoryDAO.select(Integer.parseInt(stringId)).getBookList();
            req.setAttribute("books", books);
        }

        req.getRequestDispatcher("/views/catalog.jsp").forward(req, resp);
    }

}
