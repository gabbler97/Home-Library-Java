package view;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddingBookPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> labels;
	private ArrayList<JTextField> fields;
	private JComboBox<String> borrowedComboBox;
	private JButton addBookButton;
	private JButton saveFileButton;
	
	public AddingBookPanel(String[] attributes) {
		setName("Add new Book");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		labels = new ArrayList<JLabel>();
		setFields(new ArrayList<JTextField>());
		setAddBookButton(new JButton("Add Book"));
		setSaveFileButton(new JButton("Save to file"));
		FieldsandLabelscreate(attributes);
		add(getAddBookButton());
		add(getSaveFileButton());
	}
	public JComboBox<String> getBorrowedComboBox() {
		return borrowedComboBox;
	}
	public void setBorrowedComboBox(JComboBox<String> borrowedComboBox) {
		this.borrowedComboBox = borrowedComboBox;
	}
	public ArrayList<JTextField> getFields() {
		return fields;
	}
	public void setFields(ArrayList<JTextField> fields) {
		this.fields = fields;
	}
	public JButton getSaveFileButton() {
		return saveFileButton;
	}
	public void setSaveFileButton(JButton saveFileButton) {
		this.saveFileButton = saveFileButton;
	}
	public void FieldsandLabelscreate(String[] attributes) {
		for(int i = 0; i < attributes.length-1; i++) {
			labels.add(new JLabel(attributes[i]));
		}
		setBorrowedComboBox(new JComboBox<String>());
		getBorrowedComboBox().addItem("Yes");
		getBorrowedComboBox().addItem("No");
		getBorrowedComboBox().setMaximumSize(new Dimension(300,20));
		for(int i = 0; i < getFields().size(); i++) {
			JTextField field = new JTextField();
			field.setMaximumSize(new Dimension(300,20));
			getFields().add(field);	
		}
		for(int i = 0; i < labels.size();i++) {
			if(i == 4) {
				add(labels.get(i));
				add(getBorrowedComboBox());
			}
			else {
				add(labels.get(i));
				JTextField field = new JTextField();
				field.setMaximumSize(new Dimension(300,20));
				getFields().add(field);
				add(field);
			}
		}
	}
	public JButton getAddBookButton() {
		return addBookButton;
	}
	public void setAddBookButton(JButton addBookButton) {
		this.addBookButton = addBookButton;
	}
}
