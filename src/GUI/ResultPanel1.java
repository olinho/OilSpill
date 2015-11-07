package GUI;
 
import model.Agent;
 
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
 
import javax.swing.JPanel;
 
public class ResultsPanel extends JPanel {
       
	Color c = new Color(0,0,0,0);
	
        public ResultsPanel(){
                super();
        }
       
    @Override
    public void paintComponent(Graphics g) {
  	      super.paintComponent(g);
       // g.fillRect(200, 100, 30, 100);
    }
    
    public void drawAgents(ArrayList<Agent> agentList){
        System.out.println("drawagents");
        Graphics g  = getGraphics();

      //  g.clearRect(2,8,707,573);// //TODO dac tu rozmiary tego pola w oknieG
        
        for(int i=0; i<700; i++)
        	for(int j=0; j<570; j++){
        		if (mainGui.table[i][j] > 0)
        			g.drawRect(i,j,1,1);
        	}
        
        
        
        
   /*     for(int a=0; a<agentList.size(); a++) {
            g.drawRect(agentList.get(a).getX(),agentList.get(a).getY(),1,1);
           
        }
        
   */
        revalidate();
        //repaint();

    }
    double x;

    
    public void draw(){
        Graphics g  = getGraphics();
        int t = 0;
      //  g.clearRect(2,8,707,573);// //TODO dac tu rozmiary tego pola w oknieG
        g.clearRect(0,0,700,570);
        for(int i=0; i<700; i++)
        	for(int j=0; j<570; j++){
        	  		
        		x = mainGui.table2[i][j];
					if (x != 0){
						c = new Color((int)(255-(127*x)),(int)(255-(127*x)),(int)(255-(127*x)));
        	  			g.setColor(c);
        			g.drawRect(i,j,1,1);
        	//		System.out.println((int) (mainGui.table2[i][j]*16));
					}
        		
        		
        		 
        }
        revalidate();	
        
    }
    	
}
