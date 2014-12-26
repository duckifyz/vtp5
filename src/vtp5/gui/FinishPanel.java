package vtp5.gui;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import vtp5.logic.TestFile;

public class FinishPanel extends JPanel {

	private String[] columnNames = { "Word", "Translation" };
	private JLabel completedLabel;
	private JLabel showListLabel;
	private CustomFont cf;
	private JTable table;
	private TestFile test;
	private String completedMessage;
	private JList<Object> statsList;
	private DefaultListModel<Object> statsListModel;
	private JScrollPane statsScrollPane;

	public FinishPanel(VTP5 parent) {
		cf = new CustomFont();
		test = parent.getTest();
		setLayout(new MigLayout("fillx"));

		completedMessage = "You made it! You got " + test.getSuccessRate()
				+ "%.";

		if (test.getSuccessRate() > 90) {
			completedMessage = completedMessage + " That's amazing!";
		} else if (test.getSuccessRate() > 75) {
			completedMessage = completedMessage + " Well done!";
		} else if (test.getSuccessRate() > 50) {
			completedMessage = completedMessage + " Needs some work!";
		} else {
			completedMessage = completedMessage + " Ouch!";
		}

		statsListModel = new DefaultListModel<>();
		statsListModel.addElement("<html><u>Statistics:</u></html>");
		statsListModel.addElement("Answered correctly: ");
		statsListModel.addElement("Answered incorrectly: ");
		statsListModel.addElement("Total number of guesses: ");
		statsList = new JList<>(statsListModel);
		statsList.setVisibleRowCount(4);
		statsList.setForeground(parent.getTColour());// changes text colour
		statsScrollPane = new JScrollPane(statsList);
		Object[] stats = test.getStats();
		statsListModel.removeAllElements();
		statsListModel.addElement("<html><u>Statistics:</u></html>");
		statsListModel.addElement("Answered correctly: "
				+ ((int) stats[0] - test.getCards().size()));
		statsListModel.addElement("Answered incorrectly: " + stats[1]);
		statsListModel.addElement("Total number of guesses: " + stats[2]);

		showListLabel = new JLabel(
				"Here's a list of the words you got wrong the first time.");
		completedLabel = new JLabel(completedMessage);
		cf.setFont(completedLabel, 75);
		cf.setFont(showListLabel, 60);
		cf.setFont(statsList, 40);
		// add(completedLabel, "left, grow");
		// add(statsScrollPane, "right, grow, wrap");
		// add(showListLabel, "left, grow, wrap");
		add(completedLabel, "grow");
		add(statsScrollPane, "grow, spany 2, wrap");
		add(showListLabel, "grow");
	}
}
