package model;
 
import GUI.ResultsPanel;
 
import java.util.ArrayList;
 
public class Algo {
    boolean stopSimulation = false;
    private ArrayList<Agent> agentList;
 
    public void initialize(int agentNumber) {
        agentList = new ArrayList<Agent>();
        for (int i = 0; i < agentNumber; i++) {
            Agent ag = new Agent();
            ag.setId(i);
            ag.setX(3 + (i % 30));
            ag.setY(9);
            agentList.add(ag);
        }
    }
 
   
    public void simulate(ResultsPanel panel, double xWind, double yWind) {
        int t = 0;
        while (t<1000) {
            t++;
            for (int a = 0; a < agentList.size(); a++) {
                computePosition(agentList.get(a), xWind, yWind);
            }
            panel.drawAgents(agentList);
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        System.out.println("koniec simulate");
    }
 
    public void setStopSimulation(boolean stopSimulation) {
        this.stopSimulation = stopSimulation;
    }
 
    private void computePosition(Agent ag, double xWind, double yWind) {
        double K = 50000.0; //TODO ten paramter powinien isc z gui
        double xDeltaWind = 0.035 * yWind;
        double yDeltaWind = 0.035 * xWind;
        
        double randomXDelta = 0;
        double randomYDelta = 0;
       // double randomXDelta = Math.random() * 2 - 1 + Math.sqrt(K * 2 * 1);
      //  double randomYDelta = Math.random() * 2 - 1 + Math.sqrt(K * 2 * 1);
 
        int seterY = (int) ((double) ag.getY() + yDeltaWind + randomXDelta);
        int seterX = (int) ((double) ag.getX() + xDeltaWind + randomYDelta);
        
        if(seterY > 578) seterY = 578;
        if(seterX > 707) seterX = 707;
        ag.setY(seterY);
        ag.setX(seterX);
        System.out.println(ag.getX() + " " + ag.getY());
        
 
    }
}
