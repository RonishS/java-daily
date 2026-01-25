package day4;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuTest extends JFrame {
	public MenuTest() {
		setSize(600,500);
		setTitle("MenuTest Form");

		/*
		 * ----steps to create menu in swing
		 * 1.create JMenuBar
		 * 2.create JMenu
		 * 3.create JMenuItem/JCheckBoxMenuItem/JRadioMenuItem
		 * 4.add JMenuItem in JMenu
		 * 5.add JMenu in JMenuBar
		 * 6.set JMenu in JFrame
		 *
		 */

		//add textArea in JFrame

		JTextArea textArea = new JTextArea();
		add(textArea,BorderLayout.CENTER);

		//-------create JMenuBar-----
		JMenuBar menuBar = new JMenuBar();

		//-----create file menu-------
		JMenu fileMenu = new JMenu("File");

		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		//....................create  Edit menu...................
		JMenu editMenu = new JMenu("Edit");

		//menu items
		JMenuItem cutItem = new JMenuItem("Cut");
		JMenuItem copyItem = new JMenuItem("Copy");
		JMenuItem pasteItem = new JMenuItem("Paste");

		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);

		//.......................View Menu..................
		JMenu viewMenu = new JMenu("View");

		//items
		JCheckBoxMenuItem wordWrap = new JCheckBoxMenuItem("Word Wrap");
		viewMenu.add(wordWrap);

		//................subMenu............
		JMenu fontMenu = new JMenu("Font Size");
		JRadioButtonMenuItem small = new JRadioButtonMenuItem("small");
		JRadioButtonMenuItem medium = new JRadioButtonMenuItem("medium",true);
		JRadioButtonMenuItem large = new JRadioButtonMenuItem("large");


		//add radio buttons in group
		ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);


		//shortcut keys
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));//ctrl+p
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));


		fontMenu.add(small);
		fontMenu.add(medium);
		fontMenu.add(large);
		fileMenu.addSeparator();

		viewMenu.add(fontMenu);



		//add fileMenu in MenuBar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);

		//set JMenuBar to JFrame
		setJMenuBar(menuBar);

		//----Add Action in JItems

		newItem.addActionListener(new ActionListener() {// has a short cut

			@Override
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
			}
		});
		exitItem.addActionListener(e->System.exit(0));
		cutItem.addActionListener(e->textArea.cut());
		copyItem.addActionListener(e-> textArea.copy());
		pasteItem.addActionListener(e->textArea.paste());
		
		small.addActionListener(e->textArea.setFont(new Font("Arial",Font.PLAIN,12)));
		medium.addActionListener(e->textArea.setFont(new Font("Arial",Font.ITALIC,18)));
		large.addActionListener(e->textArea.setFont(new Font("Arial",Font.BOLD,30)));

		
		
	}
	
	public static void main(String[] args) {
		new MenuTest().setVisible(true);
	}
}