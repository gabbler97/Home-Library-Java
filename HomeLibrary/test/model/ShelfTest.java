package model;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShelfTest {
	Shelf f;
	Book a;
	Book b;
	@Before
	public void SetUp() {
		f = new Shelf();
		setBasicBooks();
	}
	public void setBasicBooks() {
		a = new Book("aa","aa","aa",0,true,0);
		b = new Book("bb","bb","bb",1,false,1);
		f.addBooks(a);
		f.addBooks(b);
	}
	@Test
	public void testSearchBooks() {
		Arguments arg = Arguments.Pages;
		String what = "0";
		ArrayList<Book> r = f.searchBooks(arg, what);
		double expected = 0;
		double result = r.get(0).getNumofpages();
		Assert.assertEquals(expected, result, 0);
	}
	@Test
	public void testEdtBooks() {
		ArrayList<Book> res = f.getBooks();
		int idx = 0;
		String what = "10";
		Arguments arg = Arguments.Pages;
		double expected = 10;
		ArrayList<Book> resu = f.editBooks(res, idx, what, arg);
		double result = resu.get(0).getNumofpages();
		Assert.assertEquals(expected,result,0);
	}
	@Test
	public void testAddBooks() {
		Book c = new Book ("cc","cc","cc",2,false,2);
		f.addBooks(c);
		double expected = 2;
		int idx = f.getBooks().size() - 1;
		double result = f.getBooks().get(idx).getNumofpages();
		Assert.assertEquals(expected,result,0);
	}
	@Test
	public void testDeleteBook() {
		ArrayList<Book> res = f.getBooks();
		int idx = 0;
		f.deleteBook(res, idx);
		double expected = 1;
		double result = f.getBooks().get(0).getNumofpages();
		Assert.assertEquals(expected, result, 0);
	}
	@Test
	public void testLoad() {
		double expected = f.getBooks().size();
		try {
			f.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			f.load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double result = f.getBooks().size();
		f.getBooks().clear();
		setBasicBooks();
		Assert.assertEquals(expected, result, 0);
		
	}
}
