package GUI;
 
import model.Agent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
 
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
        
        
        
        
 //    for(int a=0; a<agentList.size(); a++) {
   //         g.drawRect(agentList.get(a).getX(),agentList.get(a).getY(),1,1);
     //      
       // }
        
   
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
						if(x>17)
							c = new Color(0,0,0);
						else if (x>13)
							c = new Color(40,40,40);
						else if (x>10)
							c = new Color(80,80,80);
						else if (x>7)
							c = new Color(100,100,100);
						else if (x>5)
							c = new Color(120,120,120);
						else if (x>3)
							c = new Color(140,140,140);
						else if (x>2)
							c = new Color(150,150,150);
						else if (x>1)
							c = new Color(160,160,160);
						else if (x>0.1)
							c = new Color(170,170,170);
						//c = new Color((int)(255-(127*x/10)),(int)(255-(127*x/10)),(int)(255-(127*x/10)));
						else c = new Color(0,0,255);
						g.setColor(c);
        			if (x>0.1) g.drawRect(j,i,1,1);
        	//		System.out.println((int) (mainGui.table2[i][j]*16));
					}
        		
        		
        		 
        }
        revalidate();	
        
    }
    	
}




/*
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
        
        
        
        
   //     for(int a=0; a<agentList.size(); a++) {
    //        g.drawRect(agentList.get(a).getX(),agentList.get(a).getY(),1,1);
           
        }
        
   
        revalidate();
        //repaint();

    }
    double x;

    
    public void draw(){
        Graphics g  = getGraphics();
        int t = 0;
      //  g.clearRect(2,8,707,573);// //TODO dac tu rozmiary tego pola w oknieG
        g.clearRect(0,0,700,570);
        for(int i=0; i<700; i++) {
        	for(int j=0; j<570; j++){
        	  		
        		x = mainGui1.getTable2()[i][j];
					if (x != 0){
						c = new Color((int)(255-(255/mainGui1.thickness*x)),(int)(255-(255/mainGui1.thickness*x)),(int)(255-(255/mainGui1.thickness*x)));
        	  			g.setColor(c);
        			g.drawRect(i,j,1,1);
        	//		System.out.println((int) (mainGui.table2[i][j]*16));
					}
        		
        		
        		 
        }
        }
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        revalidate();	
        
    }
    	
}*/
