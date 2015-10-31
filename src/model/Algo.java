package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Algo {
    boolean stopSimulation=false;
    private List<Agent> agentList;
 
    public void Algo() {
    	initialize(50);
    }
    public void initialize(int agentNumber) {
        agentList =  new ArrayList<Agent>();
        for (int i = 0; i < agentNumber; i++) {
            Agent ag =  new Agent();
            ag.setId(i);
            ag.setX(0);
            ag.setY(0);
            agentList.add(ag);
        }
    }
 
    public void simulate(Graphics g,int xWind,int yWind) {
        int t=0;
        while(!stopSimulation){
           for(int a=0;a<agentList.size();a++){
               agentList.get(a).setY(0);//policzona wartosc);
               agentList.get(a).setX(0);//policzona wartosc);
           }
//            g.clearRect();//czyszczenie poprzednich punktow
            for(int a=0;a<agentList.size();a++) {//rysoanie aktualnych punktow
                g.drawRect(agentList.get(a).getX(),agentList.get(a).getX(),1,1);
            }
        }
    }
 
    public void setStopSimulation(boolean stopSimulation) {
        this.stopSimulation = stopSimulation;//jak klinknemy gdzies przycisk "Stop" to to sie ustawi na true i zatrzyma petle
    }
}
