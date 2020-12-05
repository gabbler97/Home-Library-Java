package controller;

import view.*;
import model.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

public class Controller extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTabbedPane MenuTabbedPane;
	private AddingBookPanel addingBookPanel1;
	private SearchingBookPanel searchingBookPanel1;
	private DeletingBookPanel deletingBookPanel1;
	private EditingBookPanel editingBookPanel1;
	private Shelf library;
	private static final String[] attributes = {"Title","Author","Theme","Year","Borrowed","Pages","Resultnum"};
	public Controller(){
		setTitle("Home Library 1.0");
		setSize(500,400);
		setLayout(new BorderLayout());
		library = new Shelf();
		MenuTabbedPane = new JTabbedPane();
		AddingBookPanel1create();
		SearchingBookPanel1create();
		DeletingBookPanel1create();
		EditingBookPanel1create();
		add(MenuTabbedPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			library.load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	public DeletingBookPanel getDeletingBookPanel1() {
		return deletingBookPanel1;
	}
	public void setDeletingBookPanel1(DeletingBookPanel deletingBookPanel1) {
		this.deletingBookPanel1 = deletingBookPanel1;
	}
	public EditingBookPanel getEditingBookPanel1() {
		return editingBookPanel1;
	}
	public void setEditingBookPanel1(EditingBookPanel editingBookPanel1) {
		this.editingBookPanel1 = editingBookPanel1;
	}
	public AddingBookPanel getAddingBookPanel1() {
		return addingBookPanel1;
	}
	public void setAddingBookPanel1(AddingBookPanel addingBookPanel1) {
		this.addingBookPanel1 = addingBookPanel1;
	}
	public SearchingBookPanel getSearchingBookPanel1() {
		return searchingBookPanel1;
	}
	public void setSearchingBookPanel1(SearchingBookPanel searchingBookPanel1) {
		this.searchingBookPanel1 = searchingBookPanel1;
	}
	public Shelf getLibrary() {
		return library;
	}

	public void setLibrary(Shelf library) {
		this.library = library;
	}
	//PopUpMenu Listener
	final class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e) {
	        PopUpMenu menu = new PopUpMenu(library);
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
	//Adding Book Panel part

	public void AddingBookPanel1create() {
		addingBookPanel1 = new AddingBookPanel(attributes);
		MenuTabbedPane.add(addingBookPanel1);
		addingBookPanel1.addMouseListener(new PopClickListener());
		addingBookPanel1.getAddBookButton().addActionListener(new AddBookButtonActionListener());
		addingBookPanel1.getSaveFileButton().addActionListener(new SaveFileButtonActionListener());
	}
	
	public Shelf saveBook(Book b, AddingBookPanel panel) {
		b.setTitle(panel.getFields().get(0).getText());
		b.setAuthor(panel.getFields().get(1).getText());
		b.setTheme(panel.getFields().get(2).getText());
		b.setYear(Integer.parseInt(panel.getFields().get(3).getText()));
		b.setNumofpages(Integer.parseInt(panel.getFields().get(4).getText()));
		String borrowed = panel.getBorrowedComboBox().getSelectedItem().toString();
		if(borrowed.equals("No")) b.setborrowed(false);
		else b.setborrowed(true);
		for(int i = 0; i < panel.getFields().size() ; i ++)
			panel.getFields().get(i).setText(null);
		library.addBooks(b);
		return library;
	}
	
	final class AddBookButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Book b = new Book();
			saveBook(b, addingBookPanel1);
		}
	}
	final class SaveFileButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				library.save();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	//Searching Book Panel part
	public void SearchingBookPanel1create(){
		searchingBookPanel1 = new SearchingBookPanel();
		MenuTabbedPane.add(searchingBookPanel1);
		searchingBookPanel1.addMouseListener(new PopClickListener());
		searchingBookPanel1.getSearchButton().addActionListener(new SearchButtonActionListener());
	}
	public ArrayList<Book> searchBook(SearchingBookPanel panel) {
		Arguments arg = (Arguments) panel.getSearchingBookBaseComboBox().getSelectedItem();
		String what = panel.getSearchingBaseTextField().getText();
		ArrayList<Book> results = new ArrayList<Book>(library.searchBooks(arg, what));
		return results;
	}
	
	final class SearchButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Book> results = searchBook(searchingBookPanel1);
			updateShowBooksTable(results);
		}
	}
	// Delete Book Panel part
	public void DeletingBookPanel1create() {
		deletingBookPanel1 = new DeletingBookPanel();
		MenuTabbedPane.add(deletingBookPanel1);
		deletingBookPanel1.addMouseListener(new PopClickListener());
		deletingBookPanel1.getDeletingBookButton().addActionListener(new DeleteBookButtonActionListener());
	}
	public ArrayList<Book> deleteBook() {
		int idx = Integer.parseInt(deletingBookPanel1.getDeletingBookField().getText()) - 1;
		ArrayList<Book> results =searchBook(searchingBookPanel1);
		results = library.deleteBook(results, idx);
		return results;
	}
	final class DeleteBookButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			updateShowBooksTable(deleteBook());
		}
	}
	
	//Edit Book Panel part
	public void EditingBookPanel1create(){
		editingBookPanel1 = new EditingBookPanel();
		MenuTabbedPane.add(editingBookPanel1);
		editingBookPanel1.addMouseListener(new PopClickListener());
		editingBookPanel1.getEditingBookButton().addActionListener(new EditBookButtonActionListener());
	}
	
	public ArrayList<Book> editBooks() {
		Arguments arg = (Arguments) editingBookPanel1.getEditingBookBaseComboBox().getSelectedItem();
		int idx = Integer.parseInt(editingBookPanel1.getEditingBookField1().getText()) - 1;
		String what = editingBookPanel1.getEditingBookField2().getText();
		ArrayList <Book> results = searchBook(searchingBookPanel1);
		results = library.editBooks(results, idx, what,arg);
		return results;
	}
	
	final class EditBookButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Book> results = editBooks();
			updateShowBooksTable(results);
		}
	}
	//Update the ShowBooksTable part
	public void updateShowBooksTable(ArrayList<Book> results) {
		DefaultTableModel tableModel = new DefaultTableModel(attributes,0);
		for(int i = 0; i < results.size(); i++) {
			String title = results.get(i).getTitle();
			String author = results.get(i).getAuthor();
			String theme = results.get(i).getTheme();
			int year = results.get(i).getYear();
			String borrowed;
			if(results.get(i).isborrowed()) borrowed = "Yes";
			else borrowed = "No";
			int numofpages = results.get(i).getNumofpages();
			int resultNum = i+1;
			results.get(i).setResultNum(i+1);
			Object[] data = {title,author,theme,year,borrowed,numofpages,resultNum};
			tableModel.addRow(data);
		}
		deletingBookPanel1.getShowBooksTable().setModel(tableModel);
		searchingBookPanel1.getShowBooksTable().setModel(tableModel);
		editingBookPanel1.getShowBooksTable().setModel(tableModel);
	}
	
}