package view;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeletingBookPanel extends BasicPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel deletingBookLabel;
	private JTextField deletingBookField;
	private JButton deletingBookButton;
	
	public DeletingBookPanel() {
	setName("Deleting Books");
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	deletingBookscreate();
	}
	
	public JTextField getDeletingBookField() {
		return deletingBookField;
	}

	public void setDeletingBookField(JTextField deletingBookField) {
		this.deletingBookField = deletingBookField;
	}

	public JButton getDeletingBookButton() {
		return deletingBookButton;
	}

	public void setDeletingBookButton(JButton deletingBookButton) {
		this.deletingBookButton = deletingBookButton;
	}

	public void deletingBookscreate() {
		deletingBookLabel = new JLabel("Delete Book by Resultnum");
		add(deletingBookLabel);
		setDeletingBookField(new JTextField());
		getDeletingBookField().setMaximumSize(new Dimension(300,20));
		add(getDeletingBookField());
		setDeletingBookButton(new JButton("Delete Book"));
		add(getDeletingBookButton());
	}

}
