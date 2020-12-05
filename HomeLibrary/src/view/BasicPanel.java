package view;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class BasicPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable showBooksTable;
	private JScrollPane spanel;
	private static final String[] attributes = {"Title","Author","Theme","Year","Borrowed","Pages","Resultnum"};
	
	public BasicPanel() {
	//Set Panel
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	//Creating options
	createShowBooksTable();
	}
	public JTable getShowBooksTable() {
		return showBooksTable;
	}
	public void setShowBooksTable(JTable showBooksTable) {
		this.showBooksTable = showBooksTable;
	}
	public void createShowBooksTable() {
		setShowBooksTable(new JTable(new DefaultTableModel(attributes,0)));
		getShowBooksTable().setAutoCreateRowSorter(true);
		spanel = new JScrollPane(getShowBooksTable());
		spanel.setPreferredSize(new Dimension(300,400));
		add(spanel);
	}
}
