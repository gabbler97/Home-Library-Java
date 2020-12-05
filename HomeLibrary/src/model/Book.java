package model;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String theme;
	private int year;
	private boolean borrowed;
	private int numofpages;
	private volatile int resultNum;
	
	public Book(String t, String a, String th, int y, boolean b, int n) {
		title = t;
		author = a;
		theme = th;
		year = y;
		borrowed = b;
		numofpages = n;
	}
	
	public Book() {
		title = " ";
		author = " ";
		theme = " ";
		year = 0;
		borrowed = false;
		numofpages = 0;
	}
	public int getresultNum() {
		return resultNum;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	public String getTheme() {
		return theme;
	}

	public int getYear() {
		return year;
	}

	public boolean isborrowed() {
		return borrowed;
	}

	public int getNumofpages() {
		return numofpages;
	}
	
	public void setResultNum(int resultNum) {
		this.resultNum = resultNum;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setborrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public void setNumofpages(int numofpages) {
		this.numofpages = numofpages;
	}
	// Books can be equal without resultNum
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book other = (Book) o;
        Boolean thisone = this.borrowed;
        Boolean otherone = other.borrowed;
        return Objects.equals(title, other.title) &&
        		Objects.equals(author, other.author) &&
        		Objects.equals(theme, other.theme) &&
        		year == other.year &&
        		numofpages == other.numofpages &&
        		Objects.equals(thisone, otherone);
        		
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, theme, year, borrowed, numofpages);
    }

}
