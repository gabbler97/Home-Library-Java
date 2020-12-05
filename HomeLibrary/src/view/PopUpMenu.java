package view;

import model.Shelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	private JMenuItem exitItem;
	private JMenuItem exitandSaveItem;
	private Shelf shelf;
	public PopUpMenu(Shelf s) {
		shelf = s;
		exitItem = new JMenuItem("Exit and no save");
		exitandSaveItem = new JMenuItem("Exit and save");
		exitItem.addActionListener(new MenuSelectActionListener());
		exitandSaveItem.addActionListener(new MenuSelectActionListener());
		add(exitandSaveItem);
		addSeparator();
		add(exitItem);
	}
	final class MenuSelectActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == exitItem)
				System.exit(0);
			else if(e.getSource() == exitandSaveItem) {
				try {
					shelf.save();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}
	}
}
