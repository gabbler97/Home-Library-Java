package controller;

import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import model.Arguments;
import model.Book;

public class ControllerTest {
	
	Controller cont;
	Book a;
	Book b;
	Book c;
	
	@Before
	public void SetUp() {
		cont = new Controller();
		setBasicBooks();
		//testSaveBook
		cont.getSearchingBookPanel1().getSearchingBookBaseComboBox().setSelectedItem(Arguments.Pages);
		cont.getSearchingBookPanel1().getSearchingBaseTextField().setText("0");
		//testSaveBook
		cont.getAddingBookPanel1().getFields().get(0).setText("a");
		cont.getAddingBookPanel1().getFields().get(1).setText("a");
		cont.getAddingBookPanel1().getFields().get(2).setText("a");
		cont.getAddingBookPanel1().getFields().get(3).setText("1");
		cont.getAddingBookPanel1().getFields().get(4).setText("1");
		cont.getAddingBookPanel1().getBorrowedComboBox().setSelectedItem("Yes");
		//testEditbook
		cont.getEditingBookPanel1().getEditingBookBaseComboBox().setSelectedItem(Arguments.Pages);
		cont.getEditingBookPanel1().getEditingBookField1().setText("1");
		cont.getEditingBookPanel1().getEditingBookField2().setText("0");
		//testDeleBook
		cont.getDeletingBookPanel1().getDeletingBookField().setText("1");
	}
	public void setBasicBooks() {
		cont.getLibrary().getBooks().clear();
		a = new Book("aa","aa","aa",0,true,0);
		b = new Book("bb","bb","bb",1,false,1);
		cont.getLibrary().addBooks(a);
		cont.getLibrary().addBooks(b);
	}
	@Test
	public void testSearchBook() {
		ArrayList<Book> k = new ArrayList<Book>();
		k = cont.searchBook(cont.getSearchingBookPanel1());
		double kapott =(double) k.get(0).getNumofpages();
		double elvart = 0.0;
		Assert.assertEquals(elvart,kapott,0);
	}
	@Test
	public void testSaveBook() {
		Book b = new Book();
		cont.saveBook(b, cont.getAddingBookPanel1());
		int lastidx = cont.getLibrary().getBooks().size();
		Book r = cont.getLibrary().getBooks().get(lastidx - 1);
		double result = r.getNumofpages();
		double expected = 1.0;
		Assert.assertEquals(expected, result,0);
	}
	@Test
	public void testEditBook() {
		double expected = 0.0;
		cont.editBooks();
		double result = cont.getLibrary().getBooks().get(0).getNumofpages();
		Assert.assertEquals(expected,result,0);
	}
	@Test
	public void testDeleteBooks() {
		double expected = 1;
		cont.deleteBook();
		double result = cont.getLibrary().getBooks().get(0).getNumofpages();
		Assert.assertEquals(expected, result,0);
	}
}
