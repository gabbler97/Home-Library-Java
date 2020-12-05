package view;

import model.Arguments;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditingBookPanel extends BasicPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel editingBookLabel1;
	private JComboBox<Arguments> editingBookBaseComboBox;
	private JTextField editingBookField1;
	private JLabel editingBookLabel2;
	private JTextField editingBookField2;
	private JButton editingBookButton;
	
	public EditingBookPanel() {
	setName("Editing Books");
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	editingBookscreate();
	}

	public JTextField getEditingBookField2() {
		return editingBookField2;
	}

	public void setEditingBookField2(JTextField editingBookField2) {
		this.editingBookField2 = editingBookField2;
	}

	public JTextField getEditingBookField1() {
		return editingBookField1;
	}

	public void setEditingBookField1(JTextField editingBookField1) {
		this.editingBookField1 = editingBookField1;
	}

	public JComboBox<Arguments> getEditingBookBaseComboBox() {
		return editingBookBaseComboBox;
	}

	public void setEditingBookBaseComboBox(JComboBox<Arguments> editingBookBaseComboBox) {
		this.editingBookBaseComboBox = editingBookBaseComboBox;
	}

	public JButton getEditingBookButton() {
		return editingBookButton;
	}

	public void setEditingBookButton(JButton editingBookButton) {
		this.editingBookButton = editingBookButton;
	}

	public void editingBookscreate() {
		editingBookLabel1 = new JLabel("EditingBooks by Resultnum");
		editingBookLabel1.setMaximumSize(new Dimension(300,20));
		add(editingBookLabel1);
		setEditingBookField1(new JTextField());
		getEditingBookField1().setMaximumSize(new Dimension(300,20));
		add(getEditingBookField1());
		setEditingBookBaseComboBox(new JComboBox<Arguments>());
		getEditingBookBaseComboBox().setModel(new DefaultComboBoxModel<Arguments>(Arguments.values()));
		getEditingBookBaseComboBox().setMaximumSize(new Dimension(300,5));
		add(getEditingBookBaseComboBox());
		editingBookLabel2 = new JLabel("Edit attribute to:");
		add(editingBookLabel2);
		setEditingBookField2(new JTextField());
		getEditingBookField2().setMaximumSize(new Dimension(300,20));
		add(getEditingBookField2());
		setEditingBookButton(new JButton("Edit Book"));
		add(getEditingBookButton());
	}
}
