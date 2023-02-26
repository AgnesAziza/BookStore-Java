import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Books {
	public List<Book> recupBooks() throws IOException {
		List<Book> books = new ArrayList<Book>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connexion = null; 
		Statement statement = null;
		ResultSet result = null;
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/books", "root", "root");
			
			statement = connexion.createStatement();	
			
			result = statement.executeQuery("SELECT title, author, numberOfPages, category, price, imageBook FROM books;");
			
			while(result.next()) {
				String title = result.getString("title");
				String author = result.getString("author");
				int numberOfPages = result.getInt("numberOfPages");
				String category = result.getString("category");
				int price = result.getInt("price");
				Blob blob = result.getBlob("imageBook");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				
				byte[] imageBythes = outputStream.toByteArray();
				String imageBook = Base64.getEncoder().encodeToString(imageBythes);		
				
				inputStream.close();
				outputStream.close();
				
				Book book = new Book( title, author, numberOfPages, category, price, imageBook);
				book.setTitle(title);
				book.setAuthor(author);
				book.setNumberOfPages(numberOfPages);
				book.setCategory(category);
				book.setPrice(price);
				book.setImageBook(imageBook);
				
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) 
					result.close();
				if (statement !=null) 
					statement.close();
				if (connexion !=null) 
					connexion.close();
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}
		
		return books;
	}
	
}
