

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet (name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] tabShopBooks = request.getParameter("buttonDeleteBooks").split(",");
		Book formBook = new Book(tabShopBooks[0], tabShopBooks[1], Integer.parseInt(tabShopBooks[2]), tabShopBooks[3], Integer.parseInt(tabShopBooks[4]),tabShopBooks[5]);
		HttpSession session = request.getSession();
		
		ArrayList<Book> bookShop= (ArrayList<Book>) session.getAttribute("booksPanierKey");
		for (int i = 0; i < bookShop.size(); i++) {
			if (formBook.equals(bookShop.get(i))) {
				bookShop.remove(formBook);
			}
		}
		session.setAttribute("booksPanierKey", bookShop);
		request.getRequestDispatcher("/panier.jsp").forward(request,  response);
	}

}
