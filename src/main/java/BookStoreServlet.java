

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

@WebServlet (name = "BookStoreServlet", urlPatterns = {"/BookStoreServlet"})

public class BookStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookStoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		String searchtext = (String) request.getParameter("searchBooks");
		Books tableBooks = new Books();
		List<Book> books = tableBooks.recupBooks();
		List<Book> booksSearch = new ArrayList<Book>();
	
		if (searchtext == null || searchtext.isEmpty()) {
			request.setAttribute("books", books);
		}
		else {
			for(int i=0; i<books.size();i++) {
				if (books.get(i).getTitle().toLowerCase().contains(searchtext.toLowerCase())) {
					booksSearch.add(books.get(i));
				}
			} request.setAttribute("books", booksSearch );
		}

		this.getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
