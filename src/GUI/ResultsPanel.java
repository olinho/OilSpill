package GUI;
 
import model.Agent;
 
import java.awt.Graphics;
import java.util.ArrayList;
 
import javax.swing.JPanel;
 
public class ResultsPanel extends JPanel {
       
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
        for(int a=0; a<agentList.size(); a++) {
            g.drawRect(agentList.get(a).getX(),agentList.get(a).getY(),1,1);
           
        }
        revalidate();
        //repaint();

    }
}
