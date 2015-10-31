class Algo {
    boolean stopSimulation=false;
    private List<Agent> agentList;
 
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
        //K=50000
    public void simulate(Graphics g,double  xWind,double yWind) {
        int t=0;
        while(!stopSimulation){
           for(int a=0;a<agentList.size();a++){
               computePosition(agentList.get(a),xWind, yWind);
           }
            g.clearRect();// //TODO dac tu rozmiary tego pola w oknie
            for(int a=0;a<agentList.size();a++) {
                g.drawRect(agentList.get(a).getX(),agentList.get(a).getX(),1,1);
            }
        }
    }
 
    public void setStopSimulation(boolean stopSimulation) {
        this.stopSimulation = stopSimulation;
    }
 
    private void computePosition(Agent ag,double xWind,double yWind){
        double K=50000.0; //TODO ten paramter powinien isc z gui
        double xDeltaWind = 0.035*yWind;
        double yDeltaWind = 0.035*xWind;
        double randomXDelta = Math.random()*2-1+Math.sqrt(K*2*1);
        double randomYDelta = Math.random()*2-1+Math.sqrt(K*2*1);
 
        ag.setY((int) ((double)ag.getY()+yDeltaWind +randomXDelta));
        ag.setX((int) ((double) ag.getX() + xDeltaWind + randomYDelta));
 
    }
}
