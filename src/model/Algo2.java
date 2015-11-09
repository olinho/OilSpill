package model;

import GUI.mainGui;

public class Algo2 {
	private static mainGui mg;
	Wind wind;
	static double windRatio = mg.getWindRatio();
	static double[][] table2 = mg.getTable2();
	public Algo2(mainGui mg) {
		this.mg = mg;
	}
	
	public void randomtable2(){
		wind = mg.getWind();
		double xWind, yWind;
		double xDirection, yDirection;
		double sumOfWindRatios;
		int windPower;
		double pitagorasRatio;
		double [][] temp = new double[700][570];
		double [] r = new double[10];			//wsp�czynniki w otoczeniu piksela r[5], kt�rego warto�� wyliczamy, a pozosta�e uk�adaj� si� zgodnie z numeracj� klawiatruy na kom�rce

		xDirection = wind.getX();
		yDirection = wind.getY();
		windPower = wind.getPower();
		pitagorasRatio = Math.sqrt(Math.pow(xDirection, 2) + Math.pow(yDirection, 2));
		xWind = countWindPower(xDirection, pitagorasRatio, windPower);
		yWind = countWindPower(yDirection, pitagorasRatio, windPower);
		
		if (windPower == 0){
			setDefaultRatios(r);
		}
		else {
			setWindRatios(r, xWind, yWind);
		}
		sumOfWindRatios = sumOfArray(r);
//		showRatios(pitagorasRatio, xWind, yWind, r, xDirection, yDirection, windPower);
		 for(int i=1; i<699; i++){
			 for(int j=1; j<569; j++){
				 temp[i][j] = (r[2]*table2[i-1][j] + r[8]*table2[i+1][j] + r[4]*table2[i][j-1] + r[6]*table2[i][j+1] + r[5]*table2[i][j] + r[1]*table2[i-1][j-1] + r[9]*table2[i+1][j+1] + r[3]*table2[i-1][j+1] + r[7]*table2[i+1][j-1])/sumOfWindRatios;
//				 temp[i][j] = (2*(mg.table2[i-1][j]+mg.table2[i+1][j]+mg.table2[i][j-1]+mg.table2[i][j+1]) + 4*mg.table2[i][j] + (mg.table2[i-1][j-1] + mg.table2[i+1][j+1] + mg.table2[i-1][j+1] + mg.table2[i+1][j-1]))/16;
			 }
		 }
		 for(int i=0; i<700; i++){
			 for(int j=0; j<570; j++){
				 table2[i][j] = temp[i][j];
			 }
		 }
		 
	 }
	 
	 /**
	  * Do zsumowania parametr�w wiatru
	  * @param r tablica
	  * @return
	  */
	 public double sumOfArray(double [] r) {
		 double sum = 0;
		 for (int i=1; i<r.length; i++) 
			 sum += r[i];
		 return sum;
	 }
	 
	 /**
	  * Ustalamy warto�ci tablicy r, na podstawie kierunku, warto�cii wsp�czynnika wiatru
	  * @param r
	  * @param xWind
	  * @param yWind
	  */
	 public void setWindRatios(double [] r, double xWind, double yWind) {
		 resetTab(r);
		 double windXInfluence = windRatio * Math.abs(xWind);
		 double windYInfluence = windRatio * Math.abs(yWind);
		 r[5] = 1;
		 if (xWind > 0 && yWind > 0) 	// SE wind
		 {
		 	r[1] = windXInfluence + windYInfluence;
			r[2] = windYInfluence;
			r[4] = windXInfluence;  
		 }
		 else if (xWind > 0 && yWind == 0)	// E
		 {
		 	r[4] = windXInfluence;
		 }
		 else if (xWind == 0 && yWind > 0)	// S
		 {
		 	r[2] = windYInfluence;
		 }
		 else if (xWind < 0 && yWind > 0) 	// SW wind
		 {
		 	r[3] = windXInfluence + windYInfluence;
			r[2] = windYInfluence;
			r[6] = windXInfluence;  
		 }
		 else if (xWind < 0 && yWind == 0)	// W
		 {
		 	r[6] = windXInfluence;
		 }
		 else if (xWind < 0 && yWind < 0) 	// NW wind
		 {
		 	r[9] = windXInfluence + windYInfluence;
			r[8] = windYInfluence;
			r[6] = windXInfluence;  
		 }
		 else if (xWind == 0 && yWind < 0)	// N
		 {
		 	r[8] = windYInfluence;
		 }
		 else if (xWind > 0 && yWind < 0) 	// NE wind
		 {
		 	r[7] = windXInfluence + windYInfluence;
			r[8] = windYInfluence;
			r[4] = windXInfluence;  
		 }
		 for (int i=1; i<r.length; i++) {
			 if (r[i] > 1) 
				 r[i] = 1;
		 }
	 }
	 
	 /*
	  * Wy�wietla info o wsp�czynnikach i ko�czy program
	  */
	 public void showRatios(double pitagorasRatio, double xWind, double yWind, double [] r, double xDir, double yDir, double windPower) {
		 System.out.println("xDirection= " + xDir + "\t yDirection= " + yDir);
		 System.out.println("WindPower = " + windPower);
		 System.out.println("PitagorasRatio= " + pitagorasRatio + "\t windRatio = " + windRatio);
		 System.out.println("xWind= " + xWind + "\t yWind= " + yWind );
		 for (int i=1; i<=1; i++)
			 System.out.println("r[" + i + "]= " + r[i]);
		 
		 System.exit(0);
	 }
	 

	 /**
	  * 
	  * @param directionalValue kierunek wiatru i jego wartosc , czyli wind.getX() lub wind.getY()
	  * @param pitagoras to, pitagorasRatio czyli sqrt(wind.getX()^2 + wind.getY()^2)
	  * @param windPower
	  * @return power of the wind in the certain direction
	  */
	 public double countWindPower(double directionalValue, double pitagoras, int windPower) {
		 return directionalValue / pitagoras * windPower;
	 }
	 
	 public void resetTab(double [] r) {
		 for (int i=1; i< r.length; i++)
			 r[i] = 0;
	 }
	 
	 /*
	  * tworzy standardow� mask� wsp�czynnik�w, nr 5 jest indeksem rozpatrywanego w danym momencie piksela, a pozosta�e s� jego otoczeniem
	  */
	 public void setDefaultRatios(double[] r) {
	 	int r1,r2,r3;
	 	r1 = 1;
	 	r2 = 2;
	 	r3 = 4;
		 r[1] = r1;
		 r[3] = r1;
		 r[7] = r1;
		 r[9] = r1;
		 r[2] = r2;
		 r[4] = r2;
		 r[6] = r2;
		 r[8] = r2;
		 r[5] = r3;
	 }
}
