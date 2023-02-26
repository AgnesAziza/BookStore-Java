import java.util.Objects;

public class Book {
	private String title;
	private String author;
	private int numberOfPages;
	private String category;
	private int price;
	private String imageBook;

	Book(String title, String author, int numberOfPages, String category, int price, String imageBook) {
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.category = category;
		this.price = price;
		this.imageBook = imageBook;
	}

	public String getImageBook() {
		return imageBook;
	}

	public void setImageBook(String imageBook) {
		this.imageBook = imageBook;
	}

	@Override
	public String toString() {
		return "title " + title + "author " + author + "nombre de pages " + numberOfPages + "category " + category + "price " + price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, category, imageBook, numberOfPages, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(category, other.category)
				&& Objects.equals(imageBook, other.imageBook) && numberOfPages == other.numberOfPages
				&& price == other.price && Objects.equals(title, other.title);
	}
	




}

