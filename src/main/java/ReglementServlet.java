

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet (name = "ReglementServlet", urlPatterns = {"/ReglementServlet"})

public class ReglementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReglementServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Book> booksTotal = (ArrayList<Book>) session.getAttribute("booksPanierKey");
		int totalCalcul = 0; 
		for (int i = 0; i<booksTotal.size(); i++) {
			totalCalcul = booksTotal.get(i).getPrice() + totalCalcul;
		}
		request.setAttribute("totalCalcul", totalCalcul);
		request.getRequestDispatcher("/pageDeReglement.jsp").forward(request,  response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
