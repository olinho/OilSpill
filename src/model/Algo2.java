package model;

import GUI.mainGui;

public class Algo2 {
    private static mainGui mg;
    Wind wind;
    static double windRatio = mg.getWindRatio();
    static double[][] table2 = mg.getTable2();
    static double[] sasiedztwoMoooreaPrady = new double[10];
    public Algo2(mainGui mg) {
        this.mg = mg;
    }

    public void dolewanie() {
        for (int i = 345; i < 355; i++) {
            for (int j = 285; j < 290; j++) {
               table2[i][j] = table2[i][j] + 5;
            }
        }

    }

    public void parowanie() {
        for (int wiersz = 0; wiersz < table2.length; wiersz++) {
            for (int kolumna = 0; kolumna < table2[wiersz].length; kolumna++) {
                if (table2[wiersz][kolumna] > 0.3) table2[wiersz][kolumna] = table2[wiersz][kolumna] - 0.3;
                else if (table2[wiersz][kolumna] <= 0.3) table2[wiersz][kolumna] = -1;
                //tu trzeba dobrac ile odejmujemy, pewnie bedzie zalezalo od gestosci ropy
            }
        }
    }

    public void pradMorskiMaska(double xPradu, double yPradu,double szybkosc){
        //robienie masek mozna dac przed petla algorytmu bo w rzeciwym razie obliczmamy 3000 jedna i ta sama maske

       //  123/456/789   gdzie 5 to punk centralny


        double Pitagoras = Math.sqrt(Math.pow(xPradu,2)+Math.pow(yPradu, 2));

        double naroznik = (Math.abs(yPradu)+Math.abs(yPradu)) /Pitagoras;
        double skladowaX=Math.abs(xPradu)/Pitagoras;
        double skladowaY=Math.abs(yPradu)/Pitagoras;
        for(int i=0; i< sasiedztwoMoooreaPrady.length;i++) sasiedztwoMoooreaPrady[i]=0.0;

        if (xPradu > 0 && yPradu> 0)    // Prawo Dol
        {
            sasiedztwoMoooreaPrady[1] = naroznik;
            sasiedztwoMoooreaPrady[2] = skladowaY;
            sasiedztwoMoooreaPrady[4] = skladowaX;
        }else if (xPradu> 0 && yPradu == 0)    // w Prawo
        {
            System.out.println("tu");
            sasiedztwoMoooreaPrady[4] = 1;
        }else if (xPradu > 0 && yPradu < 0)    // w prawo gore
        {
            sasiedztwoMoooreaPrady[7] = naroznik;
            sasiedztwoMoooreaPrady[8] = skladowaY;
            sasiedztwoMoooreaPrady[4] = skladowaX;
        } else if (xPradu < 0 && yPradu  > 0)    // lewo dol
        {
            sasiedztwoMoooreaPrady[3] = naroznik;
            sasiedztwoMoooreaPrady[2] = skladowaY;
            sasiedztwoMoooreaPrady[6] = skladowaX;
        } else if (xPradu < 0 && yPradu == 0)    // w lewo
        {
            sasiedztwoMoooreaPrady[6] = 1;
        } else if (xPradu < 0 && yPradu < 0)    // w gore lewo
        {
            sasiedztwoMoooreaPrady[9] = naroznik;
            sasiedztwoMoooreaPrady[8] = skladowaY;
            sasiedztwoMoooreaPrady[6] = skladowaX;
        } else if (xPradu == 0 && yPradu < 0)    // w gore
        {
            sasiedztwoMoooreaPrady[8] = 1;
        }  else if (xPradu == 0 && yPradu > 0)    // w dol
        {
            sasiedztwoMoooreaPrady[2] = 1;
        }
        sasiedztwoMoooreaPrady[5] = 100/szybkosc;
        double normalizacja  = sumOfArray(sasiedztwoMoooreaPrady);
        for(int i=0; i< sasiedztwoMoooreaPrady.length;i++) sasiedztwoMoooreaPrady[i] /= normalizacja;
        System.out.println("xpradu:"+xPradu+"   yprdu:"+yPradu+"   szybkosc:"+szybkosc);
        System.out.println(sasiedztwoMoooreaPrady[1] + " " + sasiedztwoMoooreaPrady[2] + " " +sasiedztwoMoooreaPrady[3]);
       System.out.println(sasiedztwoMoooreaPrady[4] + " " + sasiedztwoMoooreaPrady[5] + " " +sasiedztwoMoooreaPrady[6]);
       System.out.println(sasiedztwoMoooreaPrady[7] + " " + sasiedztwoMoooreaPrady[8] + " " +sasiedztwoMoooreaPrady[9]);


    }



    public void pradyMorskie(){
        double[][] temp = new double[700][570];
        for (int wiersz = 0; wiersz < 700; wiersz++) {
            for (int kolumna = 0; kolumna < 570; kolumna++) {
                temp[wiersz][kolumna] = table2[wiersz][kolumna];
            }}

        for (int wiersz = 350; wiersz < 699; wiersz++) {
            for (int kolumna = 350; kolumna < 400; kolumna++) {
                temp[wiersz][kolumna] = (table2[wiersz - 1][kolumna-1]*sasiedztwoMoooreaPrady[1] +
                        table2[wiersz - 1][kolumna]*sasiedztwoMoooreaPrady[2] +
                        table2[wiersz - 1][kolumna+1]*sasiedztwoMoooreaPrady[3] +
                        table2[wiersz][kolumna-1]*sasiedztwoMoooreaPrady[4] +
                        table2[wiersz ][kolumna]*sasiedztwoMoooreaPrady[5] +
                        table2[wiersz ][kolumna+1]*sasiedztwoMoooreaPrady[6] +
                        table2[wiersz + 1][kolumna-1]*sasiedztwoMoooreaPrady[7] +
                        table2[wiersz + 1][kolumna]*sasiedztwoMoooreaPrady[8] +
                        table2[wiersz + 1][kolumna+1]*sasiedztwoMoooreaPrady[9] );

            }
        }

        //table2= temp;
        for (int wiersz = 0; wiersz < 700; wiersz++) {
           for (int kolumna = 0; kolumna < 570; kolumna++) {
               table2[wiersz][kolumna] = temp[wiersz][kolumna];
           }}

    }


    public void randomtable2() {
        wind = mg.getWind();
        double xWind, yWind;
        double xDirection, yDirection;
        double sumOfWindRatios;
        int windPower;
        double pitagorasRatio;
        double[][] temp = new double[700][570];
        double[] r = new double[10];            //współczynniki w otoczeniu piksela r[5], którego wartoć wyliczamy, a pozostałe układajš się zgodnie z numeracjš klawiatruy na komórce

        xDirection = wind.getX();
        yDirection = wind.getY();
        windPower = wind.getPower();
        pitagorasRatio = Math.sqrt(Math.pow(xDirection, 2) + Math.pow(yDirection, 2));
        xWind = countWindPower(xDirection, pitagorasRatio, windPower);
        yWind = countWindPower(yDirection, pitagorasRatio, windPower);

        if (windPower == 0) {
            setDefaultRatios(r);
        } else {
            setWindRatios(r, xWind, yWind);
        }
        /*System.out.println(r[1] + " " + r[2] + " " +r[3]);
		System.out.println(r[4] + " " + r[5] + " " +r[6]);
		System.out.println(r[7] + " " + r[8] + " " +r[9]);
		System.out.println(yDirection + " " + xDirection + " " + windPower);
		System.out.println("xWind: " + xWind + " yWind: " + yWind);
		*/

        sumOfWindRatios = sumOfArray(r);
        //	System.out.println("suma: " + sumOfWindRatios);
        //	System.out.println("windRatio: " + windRatio);

//		showRatios(pitagorasRatio, xWind, yWind, r, xDirection, yDirection, windPower);


        for (int i = 1; i < 699; i++) {
            for (int j = 1; j < 569; j++) {
                temp[i][j] = (2 * (table2[i - 1][j] + table2[i + 1][j] + table2[i][j - 1] + table2[i][j + 1]) + 4 * table2[i][j]
                        + (table2[i - 1][j - 1] + table2[i + 1][j + 1] + table2[i - 1][j + 1] + table2[i + 1][j - 1])) / 16;

            }
        }
	/* OPCJA 1	 
		 for(int i=345; i<355; i++){
			 for(int j=285; j<290; j++){
				 temp[i][j] = temp[i][j]+1;
			 }
		 }	 
	*/
        // OPCJA 	2



        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 570; j++) {
                table2[i][j] = temp[i][j];
            }
        }

        for (int i = 1; i < 699; i++) {
            for (int j = 1; j < 569; j++) {
                temp[i][j] = (r[2] * table2[i - 1][j] + r[8] * table2[i + 1][j] + r[4] * table2[i][j - 1] + r[6] * table2[i][j + 1] + r[5] * table2[i][j] + r[1] * table2[i - 1][j - 1] + r[9] * table2[i + 1][j + 1] + r[3] * table2[i - 1][j + 1] + r[7] * table2[i + 1][j - 1]) / sumOfWindRatios;
//				 temp[i][j] = (2*(mg.table2[i-1][j]+mg.table2[i+1][j]+mg.table2[i][j-1]+mg.table2[i][j+1]) + 4*mg.table2[i][j] + (mg.table2[i-1][j-1] + mg.table2[i+1][j+1] + mg.table2[i-1][j+1] + mg.table2[i+1][j-1]))/16;
            }
        }
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 570; j++) {
                table2[i][j] = temp[i][j];
            }
        }

    }

    /**
     * Do zsumowania parametrów wiatru
     *
     * @param r tablica
     * @return
     */
    public double sumOfArray(double[] r) {
        double sum = 0;
        for (int i = 1; i < r.length; i++)
            sum += r[i];
        return sum;
    }

    /**
     * Ustalamy wartoci tablicy r, na podstawie kierunku, wartocii współczynnika wiatru
     *
     * @param r
     * @param xWind
     * @param yWind
     */
    public void setWindRatios(double[] r, double xWind, double yWind) {
        resetTab(r);
        double windXInfluence = windRatio * Math.abs(xWind);
        double windYInfluence = windRatio * Math.abs(yWind);
        r[5] = 1;
        if (xWind > 0 && yWind > 0)    // SE wind
        {
            r[1] = windXInfluence + windYInfluence;
            r[2] = windYInfluence;
            r[4] = windXInfluence;
        } else if (xWind > 0 && yWind == 0)    // E
        {
            r[4] = windXInfluence;
        } else if (xWind == 0 && yWind > 0)    // S
        {
            r[2] = windYInfluence;
        } else if (xWind < 0 && yWind > 0)    // SW wind
        {
            r[3] = windXInfluence + windYInfluence;
            r[2] = windYInfluence;
            r[6] = windXInfluence;
        } else if (xWind < 0 && yWind == 0)    // W
        {
            r[6] = windXInfluence;
        } else if (xWind < 0 && yWind < 0)    // NW wind
        {
            r[9] = windXInfluence + windYInfluence;
            r[8] = windYInfluence;
            r[6] = windXInfluence;
        } else if (xWind == 0 && yWind < 0)    // N
        {
            r[8] = windYInfluence;
        } else if (xWind > 0 && yWind < 0)    // NE wind
        {
            r[7] = windXInfluence + windYInfluence;
            r[8] = windYInfluence;
            r[4] = windXInfluence;
        }
        for (int i = 1; i < r.length; i++) {
            if (r[i] > 1)
                r[i] = 1;
        }
    }

    /*
     * Wywietla info o współczynnikach i kończy program
     */
    public void showRatios(double pitagorasRatio, double xWind, double yWind, double[] r, double xDir, double yDir, double windPower) {
        System.out.println("xDirection= " + xDir + "\t yDirection= " + yDir);
        System.out.println("WindPower = " + windPower);
        System.out.println("PitagorasRatio= " + pitagorasRatio + "\t windRatio = " + windRatio);
        System.out.println("xWind= " + xWind + "\t yWind= " + yWind);
        for (int i = 1; i <= 1; i++)
            System.out.println("r[" + i + "]= " + r[i]);
    }


    /**
     * @param directionalValue kierunek wiatru i jego wartosc , czyli wind.getX() lub wind.getY()
     * @param pitagoras        to, pitagorasRatio czyli sqrt(wind.getX()^2 + wind.getY()^2)
     * @param windPower
     * @return power of the wind in the certain direction
     */
    public double countWindPower(double directionalValue, double pitagoras, int windPower) {
        return directionalValue / pitagoras * windPower;
    }

    public void resetTab(double[] r) {
        for (int i = 1; i < r.length; i++)
            r[i] = 0;
    }

    /*
     * tworzy standardowš maskę współczynników, nr 5 jest indeksem rozpatrywanego w danym momencie piksela, a pozostałe sš jego otoczeniem
     */
    public void setDefaultRatios(double[] r) {
        int r1, r2, r3;
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
