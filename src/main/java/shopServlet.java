

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "shopServlet", urlPatterns = {"/shopServlet"})

public class shopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public shopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.getAttribute("booksPanierKey");
			request.getRequestDispatcher("panier.jsp").forward(request,  response);

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
			String[] tabBouttonaddBooks = request.getParameter("bouttonAddBooks").split(",");
			Book formBook = new Book(tabBouttonaddBooks[0], tabBouttonaddBooks[1], Integer.parseInt(tabBouttonaddBooks[2]), tabBouttonaddBooks[3], Integer.parseInt(tabBouttonaddBooks[4]),tabBouttonaddBooks[5]);
			HttpSession session = request.getSession();
			ArrayList<Book> booksPanier = new ArrayList<Book>();
			
			if (session.getAttribute("booksPanierKey") == null) {
				session.setAttribute("booksPanierKey", booksPanier);
				booksPanier.add(formBook);
			} else {
				ArrayList<Book> bookShopNotEmpty = (ArrayList<Book>) session.getAttribute("booksPanierKey");
				bookShopNotEmpty.add(formBook);
				
			}
			request.getRequestDispatcher("/BookStoreServlet").forward(request,  response);
		
	}

}
