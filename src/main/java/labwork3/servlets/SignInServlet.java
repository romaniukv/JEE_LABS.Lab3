package labwork3.servlets;

import labwork3.dao.UserDAO;
import labwork3.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findUser(username, password);
        if(user == null) {
            String errorMessage = "Invalid username or password";
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
        }
        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/userInfo");
    }
}
