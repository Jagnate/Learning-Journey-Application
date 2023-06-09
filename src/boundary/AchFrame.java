/**
 *  Title      : AchFrame.java
 *  Description: A class that provides the achievement interface for users.
 * 
 *  @author  Zhang Dan
 *  @author Liu yu xuan
 *  @version 1.0
 */

package boundary;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
import control.AchControl;

public class AchFrame extends JFrame{
	
	private static final long 			serialVersionUID = 1L;
	private 			JTable 			accquiredAch;
	private 			JTable 			suggestedAch;
	private 			JPanel 			mainPanel 		 = new MyDrawPanel();
	private 			JLabel 			title 			 = new JLabel("Achievements");
	private 			JScrollPane  	onePanel;
	private 			JScrollPane  	secondPanel;
	private 			AchControl 		control;
	
	/**
      * This is the constructor of the class.
	  * @param ID the student's ID
      */
	public AchFrame(String ID) {
		control = new AchControl(ID);
		this.setTable();
		this.setLayout();
		this.setFrame();
	}
	
	/**
      * This method sets the performance of the frame.
      */
	private void setFrame() {
		this.setSize(400,470);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
      * This method sets the layout and size of the main content panel.
      */
	private void setLayout() {
		mainPanel.setLayout(null);
		this.add(mainPanel);
		title.setBounds(100, 10, 250, 50);
		title.setFont(new Font("Arial",Font.BOLD,30));
		mainPanel.add(title);
		onePanel.setBounds(15,80,370,150);
		mainPanel.add(onePanel);
		secondPanel.setBounds(15,260,370,150);
		mainPanel.add(secondPanel);
	}
	
	/**
      * This method sets the table of achievements.
      */
	private void setTable() {
		String[][] accdate = new String[control.ach_list.size()][1];
		String[] accheader = {"Accquired Achievement"};
		for(int i=0;i<control.getAchlist.size();i++) {
			accdate[i][0] = control.getAchlist.get(i);
		}
		
		String[][] sugdate = new String[control.suggestedList.size()][1];
		String[] sugheader = {"Suggested Achievement"};
		for(int i=0;i<control.suggestedList.size();i++) {
			sugdate[i][0] = control.suggestedList.get(i);
		}
		
		accquiredAch = new JTable(accdate,accheader);
		accquiredAch.getTableHeader().setFont(new Font("Arial",Font.BOLD,15));
		suggestedAch = new JTable(sugdate,sugheader);
		suggestedAch.getTableHeader().setFont(new Font("Arial",Font.BOLD,15));
		accquiredAch.setGridColor(Color.BLACK);
		accquiredAch.setShowGrid(true);
		suggestedAch.setGridColor(Color.BLACK);
		suggestedAch.setShowGrid(true);
		TableColumn column1 = accquiredAch.getColumnModel().getColumn(0);
        column1.setPreferredWidth(200);
        TableColumn column2 = suggestedAch.getColumnModel().getColumn(0);
        column2.setPreferredWidth(200);
		onePanel 	 = new JScrollPane(accquiredAch);
		secondPanel  = new JScrollPane(suggestedAch);
	}
	
}
