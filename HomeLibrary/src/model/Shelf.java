package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Shelf {
	private ArrayList<Book> books;
	public Shelf() {
		books = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Book> addBooks(Book b) {
		books.add(b);
		return books;
	}
	
	public ArrayList<Book> searchBooks(Arguments argument, String what) {
		ArrayList<Book> results = new ArrayList<Book>();
	    switch (argument){
	      case Title:
	    	  for(Book b : books) {
	    		  if(b.getTitle().equals(what))
	    			  results.add(b);
	    	  }break;
	      case Author:
	    	  for(Book b : books) {
	    		  if(b.getAuthor().equals(what))
	    			  results.add(b);
	    	  }break;
	      case Theme:
	    	  for(Book b : books) {
	    		  if(b.getTheme().equals(what))
	    			  results.add(b);
	    	  }break;
	      case Year:
	    	  int i = Integer.parseInt(what);
	    	  for(Book b : books) {
	    		  if(b.getYear() == i)
	    			  results.add(b);
	    	  }break;
	      case Borrowed:
	    	  boolean borrowed = false;
	    	  if(what.equals("Yes")) borrowed = true;
	    	  for(Book b : books) {
	    		  if(b.isborrowed() == borrowed)
	    			  results.add(b);
	    	  }break;
	      case Pages:
	    	  int j = Integer.parseInt(what);
	    	  for(Book b : books) {
	    		  if(b.getNumofpages() == j)
	    			  results.add(b);
	    	  }break;
	      default:
	    	  break;
	    }
		return results;
	}

	public ArrayList<Book> deleteBook(ArrayList<Book> results,int idx) {
		Book del = results.get(idx);
		books.remove(del);
		results.remove(del);
		return results;
	}
	
	public ArrayList<Book> editBooks(ArrayList<Book> results, int idx,String what, Arguments argument) {
		Book temp = results.get(idx);
	    switch (argument){
	      case Title:
	    	  temp.setTitle(what);
	    	  break;
	      case Author:
	    	  temp.setAuthor(what);
	    	  break;
	      case Theme:
	    	  temp.setTheme(what);
	    	  break;
	      case Year:
	    	  int i = Integer.parseInt(what);
	    	  temp.setYear(i);
	    	  break;
	      case Borrowed:
	    	  boolean borrowed = false;
	    	  if(what.equals("Yes")) borrowed = true;
	    	  temp.setborrowed(borrowed);
	    	  break;
	      case Pages:
	    	  int j = Integer.parseInt(what);
	    	  temp.setNumofpages(j);
	    	  break;
	      default:
	    	  break;
	    }
	    return results;
	}

	
	public ArrayList<Book> load() throws IOException, ClassNotFoundException {
		String wd = System.getProperty("user.dir");
		File f = new File(wd,"mentesek");
		if(f.exists()) {
			FileInputStream fs = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fs);
			@SuppressWarnings("unchecked")
			ArrayList<Book> temp = (ArrayList<Book>) in.readObject();
			books = temp;
			in.close();
		}
		return books;
	}
	
	public void save() throws IOException {
		String wd = System.getProperty("user.dir");
		File f = new File (wd,"mentesek");
		if(!f.exists())
			f.createNewFile();
		if (f.exists()) {
			FileOutputStream fs = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream (fs);
			out.writeObject(books);
			out.close();
		}
	}
}
