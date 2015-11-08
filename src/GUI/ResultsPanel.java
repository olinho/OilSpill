package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ResultsPanel extends JPanel {
	
	public ResultsPanel(){
		super();
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(200, 100, 30, 100);
    }

}
