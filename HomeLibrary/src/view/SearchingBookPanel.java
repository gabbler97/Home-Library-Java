package view;

import model.Arguments;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchingBookPanel extends BasicPanel {
	private static final long serialVersionUID = 1L;
	private JLabel searchBaseLabel;
	private JComboBox<Arguments> searchingBookBaseComboBox;
	private JTextField searchingBaseTextField;
	private JButton searchButton;
	
	public SearchingBookPanel() {
	setName("Searchng Books");
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	searchingBookscreate();
	}
	
	public JTextField getSearchingBaseTextField() {
		return searchingBaseTextField;
	}

	public void setSearchingBaseTextField(JTextField searchingBaseTextField) {
		this.searchingBaseTextField = searchingBaseTextField;
	}

	public JComboBox<Arguments> getSearchingBookBaseComboBox() {
		return searchingBookBaseComboBox;
	}

	public void setSearchingBookBaseComboBox(JComboBox<Arguments> searchingBookBaseComboBox) {
		this.searchingBookBaseComboBox = searchingBookBaseComboBox;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public void searchingBookscreate() {
		setSearchingBookBaseComboBox(new JComboBox<Arguments>());
		searchBaseLabel = new JLabel("Base of search");
		add(searchBaseLabel);
		getSearchingBookBaseComboBox().setModel(new DefaultComboBoxModel<Arguments>(Arguments.values()));
		getSearchingBookBaseComboBox().setMaximumSize(new Dimension(300,5));
		add(getSearchingBookBaseComboBox());
		setSearchingBaseTextField(new JTextField());
		getSearchingBaseTextField().setMaximumSize(new Dimension(300,20));
		add(getSearchingBaseTextField());
		setSearchButton(new JButton("Search"));
		add(getSearchButton());
	}
}
