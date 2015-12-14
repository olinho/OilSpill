package GUI;

import model.Algo;
import model.Algo2;
import model.Wind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dawid
 */
public class mainGui extends JFrame {

	Algo2 algo2;
	private static double windRatio; 	//współczynnik poziomy i pionowy wiatru
	String xDir;
	String yDir;
	String windPow;
	static double thickness=2;

	double [][] temp = new double[700][570];
	static double[][] table2 = new double[700][570];
    static double[][] poprzednia = new double[700][570];
	static byte[][] table;
	private Algo a;
	private int ileAgentow;
	private Wind wind;
	private JPanel buttonPanel;
	private JPanel windPanel;
	private JButton okButton;
	private JEditorPane jEditorPane1;
	private JLabel windLabel;
	private JLabel wspLabel;
	private JLabel powerLabel;
	private JPanel jmainGui;
	private JScrollPane jScrollPane2;
	private JTextField powerTextField;
	private JPanel titlePanel;
	private JButton enythingButton;
	private JLabel title;
	private ResultsPanel resultsPanel;
	private JButton startButton;
	private JLabel xLabel;
	private JLabel yLabel;
	private JTextField wspXTextField;
	private JTextField wspYTextField;
	private JLabel ileAgentowLabel;
	private JTextField ileAgentowField;

	private JTextField powerTextFieldPrad;
	private JTextField wspXTextFieldPrad;
	private JTextField wspYTextFieldPrad;
	private JLabel powerLabelPrad;
	private JLabel windLabelPrad;
	private JLabel xLabelPrad;
	private JLabel yLabelPrad;
	private JButton okButtonPrad;
	private JLabel wspLabelPrad;
	private JPanel pradPanel;



	Random generator = new Random();
	//          private org.jdesktop.beansbinding.BindingGroup bindingGroup;
	// End of variables declaration              

	/**
	 * Creates new form mainGui
	 */
	public mainGui() {
		initRatios();
		initComponents();
	}

	/**
	 * Inicjalizacja współczynników, i danych do modelu matematycznego
	 */
	public void initRatios() {
		xDir = "2";
		yDir = "3";
		windPow = "10";
		setWindRatio(0.03);
	}


	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		table = new byte[700][570];
		jmainGui = new JPanel();
		titlePanel = new JPanel();
		title = new JLabel();
		buttonPanel = new JPanel();
		enythingButton = new JButton();
		startButton = new JButton();
		windPanel = new JPanel();
		windLabel = new JLabel();
		wspLabel = new JLabel();
		powerLabel = new JLabel();
		powerTextField = new JTextField();
		okButton = new JButton();
		resultsPanel = new ResultsPanel();
		jScrollPane2 = new JScrollPane();
		jEditorPane1 = new JEditorPane();
		xLabel = new JLabel();
		yLabel = new JLabel();
		wspXTextField = new JTextField();
		wspYTextField = new JTextField();
		ileAgentowLabel = new JLabel();
		ileAgentowField = new JTextField();

		pradPanel = new JPanel();
		powerTextFieldPrad = new JTextField();
		wspXTextFieldPrad = new JTextField();;
		wspYTextFieldPrad = new JTextField();;
		powerLabelPrad = new JLabel();;
		windLabelPrad = new JLabel();
		xLabelPrad = new JLabel();
		yLabelPrad = new JLabel();
		okButtonPrad = new JButton();
		wspLabelPrad = new JLabel();


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Rozprzestrzenianie sie zanieczyszczen");
		setAutoRequestFocus(false);
		setBackground(new java.awt.Color(92, 117, 223));
		setBounds(new java.awt.Rectangle(10, 10, 10, 10));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setForeground(new java.awt.Color(222, 74, 74));

		jmainGui.setBackground(new java.awt.Color(166, 230, 239));

		titlePanel.setBackground(new java.awt.Color(95, 155, 228));
		titlePanel.setBorder(BorderFactory.createMatteBorder(10, 2, 10, 2, new java.awt.Color(1, 7, 110)));
		titlePanel.setForeground(new java.awt.Color(20, 18, 84));
		titlePanel.setToolTipText("");

		title.setFont(new java.awt.Font("LM Mono Caps 10", 1, 24)); // NOI18N
		title.setForeground(new java.awt.Color(11, 11, 67));
		title.setText("Symulacja rozprzestrzeniania się ropy naftowej na wodzie");

		GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
		titlePanel.setLayout(titlePanelLayout);
		titlePanelLayout.setHorizontalGroup(
				titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(titlePanelLayout.createSequentialGroup()
						.addGap(34, 34, 34)
						.addComponent(title)
						.addContainerGap(59, Short.MAX_VALUE))
				);
		titlePanelLayout.setVerticalGroup(
				titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		buttonPanel.setBackground(new java.awt.Color(95, 155, 228));
		buttonPanel.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new java.awt.Color(1, 7, 110)));
		buttonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		enythingButton.setBackground(new java.awt.Color(237, 254, 201));
		enythingButton.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
		enythingButton.setForeground(new java.awt.Color(2, 9, 126));
		enythingButton.setText("");
		enythingButton.setActionCommand("");
		enythingButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, new java.awt.Color(1, 7, 110)));
		enythingButton.setMaximumSize(new java.awt.Dimension(170, 34));
		enythingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				enythingButtonActionPerformed(evt);
			}
		});

		startButton.setBackground(new java.awt.Color(237, 254, 201));
		startButton.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
		startButton.setForeground(new java.awt.Color(2, 9, 126));
		startButton.setText("Start");
		startButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, new java.awt.Color(1, 7, 110)));
		startButton.setMaximumSize(new java.awt.Dimension(170, 34));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startButtonActionPerformed(evt);
			}
		});

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		windPanel.setBackground(new java.awt.Color(95, 155, 228));
		windPanel.setBorder(BorderFactory.createMatteBorder(4, 1, 4, 1, new java.awt.Color(3, 6, 176)));
		windPanel.setForeground(new java.awt.Color(3, 6, 176));
		windPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		windLabel.setBackground(new java.awt.Color(214, 114, 14));
		windLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		windLabel.setForeground(new java.awt.Color(2, 9, 126));
		windLabel.setHorizontalAlignment(SwingConstants.CENTER);
		windLabel.setText("  WIATR");

		//   org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titlePanel, org.jdesktop.beansbinding.ObjectProperty.create(), windLabel, org.jdesktop.beansbinding.BeanProperty.create("border"));
		//     bindingGroup.addBinding(binding);

		wspLabel.setForeground(new java.awt.Color(2, 9, 126));
		wspLabel.setText("   Podaj współrzędne");

		wspYTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
		wspXTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

		powerLabel.setForeground(new java.awt.Color(2, 9, 126));
		powerLabel.setText(" Podaj siłę");

		powerTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));


		okButton.setForeground(new java.awt.Color(2, 9, 126));
		okButton.setText("OK");

		xLabel.setForeground(new java.awt.Color(2, 9, 126));
		xLabel.setText("X:");

		yLabel.setForeground(new java.awt.Color(2, 9, 126));
		yLabel.setText("Y:");

		wspYTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
		wspYTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});


		GroupLayout windPanelLayout = new GroupLayout(windPanel);
		windPanel.setLayout(windPanelLayout);
		windPanelLayout.setHorizontalGroup(
				windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(windPanelLayout.createSequentialGroup()
						.addGap(4, 4, 4)
						.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(wspLabel)
								.addGroup(windPanelLayout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addComponent(windLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
										.addGroup(windPanelLayout.createSequentialGroup()
												.addGap(25, 25, 25)
												.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addComponent(powerTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
														.addGroup(windPanelLayout.createSequentialGroup()
																.addContainerGap()
																.addComponent(xLabel)
																.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addGroup(windPanelLayout.createSequentialGroup()
																				.addGap(24, 24, 24)
																				.addComponent(powerLabel)
																				.addGap(0, 0, Short.MAX_VALUE))
																				.addGroup(windPanelLayout.createSequentialGroup()
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(wspXTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																						.addGap(38, 38, 38)
																						.addComponent(yLabel)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(wspYTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																						.addContainerGap())))
				);
		windPanelLayout.setVerticalGroup(
				windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(windPanelLayout.createSequentialGroup()
						.addComponent(windLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(wspLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(wspXTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(xLabel)
								.addComponent(yLabel)
								.addComponent(wspYTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(powerLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(powerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(26, 26, 26))
				);
		
		
		pradPanel.setBackground(new java.awt.Color(95, 155, 228));
		pradPanel.setBorder(BorderFactory.createMatteBorder(4, 1, 4, 1, new java.awt.Color(3, 6, 176)));
		pradPanel.setForeground(new java.awt.Color(3, 6, 176));
		pradPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		windLabelPrad.setBackground(new java.awt.Color(214, 114, 14));
		windLabelPrad.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		windLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		windLabelPrad.setHorizontalAlignment(SwingConstants.CENTER);
		windLabelPrad.setText("   PRĄD");

		//   org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titlePanel, org.jdesktop.beansbinding.ObjectProperty.create(), windLabel, org.jdesktop.beansbinding.BeanProperty.create("border"));
		//     bindingGroup.addBinding(binding);

		wspLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		wspLabelPrad.setText("   Podaj współrzędne");

		wspYTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
		wspXTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

		powerLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		powerLabelPrad.setText(" Podaj siłę");

		powerTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));


		okButtonPrad.setForeground(new java.awt.Color(2, 9, 126));
		okButtonPrad.setText("OK");

		xLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		xLabelPrad.setText("X:");

		yLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		yLabelPrad.setText("Y:");

		wspYTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
		wspYTextFieldPrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});


		GroupLayout pradPanelLayout = new GroupLayout(pradPanel);
		pradPanel.setLayout(pradPanelLayout);
		pradPanelLayout.setHorizontalGroup(
				pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pradPanelLayout.createSequentialGroup()
						.addGap(4, 4, 4)
						.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(wspLabelPrad)
								.addGroup(pradPanelLayout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addComponent(windLabelPrad, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
										.addGroup(pradPanelLayout.createSequentialGroup()
												.addGap(25, 25, 25)
												.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(okButtonPrad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addComponent(powerTextFieldPrad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
														.addGroup(pradPanelLayout.createSequentialGroup()
																.addContainerGap()
																.addComponent(xLabelPrad)
																.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addGroup(pradPanelLayout.createSequentialGroup()
																				.addGap(24, 24, 24)
																				.addComponent(powerLabelPrad)
																				.addGap(0, 0, Short.MAX_VALUE))
																				.addGroup(pradPanelLayout.createSequentialGroup()
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(wspXTextFieldPrad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																						.addGap(38, 38, 38)
																						.addComponent(yLabelPrad)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(wspYTextFieldPrad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																						.addContainerGap())))
				);
		pradPanelLayout.setVerticalGroup(
				pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pradPanelLayout.createSequentialGroup()
						.addComponent(windLabelPrad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(wspLabelPrad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(wspXTextFieldPrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(xLabelPrad)
								.addComponent(yLabelPrad)
								.addComponent(wspYTextFieldPrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(powerLabelPrad)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(powerTextFieldPrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(okButtonPrad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(26, 26, 26))
				);


		ileAgentowLabel.setForeground(new java.awt.Color(2, 9, 126));
		ileAgentowLabel.setText("Ilość agentów:");

		ileAgentowField.setText("10");

		GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(
				buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(enythingButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(windPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pradPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								
								.addGroup(buttonPanelLayout.createSequentialGroup()
										.addComponent(ileAgentowLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(ileAgentowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
										.addContainerGap())
				);
		buttonPanelLayout.setVerticalGroup(
				buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(windPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGap(2, 2, 2)
						.addComponent(pradPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32)
						.addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ileAgentowLabel)
								.addComponent(ileAgentowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)

								.addComponent(enythingButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29))
				);

		resultsPanel.setBackground(new java.awt.Color(95, 155, 228));
		resultsPanel.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new java.awt.Color(1, 7, 110)));

		jScrollPane2.setViewportView(jEditorPane1);

		GroupLayout resultsPanelLayout = new GroupLayout(resultsPanel);
		resultsPanel.setLayout(resultsPanelLayout);
		/*   resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
		 */
		GroupLayout jmainGuiLayout = new GroupLayout(jmainGui);
		jmainGui.setLayout(jmainGuiLayout);
		jmainGuiLayout.setHorizontalGroup(
				jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jmainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jmainGuiLayout.createSequentialGroup()
										.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(resultsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addContainerGap())
				);
		jmainGuiLayout.setVerticalGroup(
				jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jmainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(resultsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 470))
								.addContainerGap())
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jmainGui, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jmainGui, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		//      bindingGroup.bind();

		pack();
	}// </editor-fold>                        



	private void startButtonActionPerformed(ActionEvent evt) {                                              
		a = new Algo();
		algo2 = new Algo2(this);
		//ileAgentow = Integer.parseInt(ileAgentowField.getText());
		int t = 0;

		for(int i=0; i<700; i++){
			for(int j=0; j<570; j++){
				table2[i][j] = 0;
			}
		}

		//rozlana ropa, grubosc to 20
		/* for(int i=330; i<370; i++){
			 for(int j=270; j<310; j++){
				 table2[i][j] = 20;
			 }
		 }	 
		 */
		//wersja Olka z iloscia agentow
		/*for(int i=330; i<330+ileAgentow; i++){
			 for(int j=270; j<270+ileAgentow; j++){
				 getTable2()[i][j] = thickness;
			 }
		 }	
		 */
		resultsPanel.draw();

		algo2.pradMorskiMaska(Double.parseDouble(wspXTextFieldPrad.getText()),Double.parseDouble(wspYTextFieldPrad.getText()),Double.parseDouble(powerTextFieldPrad.getText()));
		while(t<5000){
			if(t<300) algo2.dolewanie();
			if(t % 100==0)System.out.println("time "+t);

			algo2.randomtable2();
			//algo2.parowanie();
			algo2.pradyMorskie();
           // System.arraycopy(table2, 0, poprzednia, 0, table.length);
			resultsPanel.draw();
			t++;











			/*	 try {
	           //     Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }*/
		}
		//	 a.initialize(ileAgentow);
		//	 System.out.println("windx"+wind.getX());
		//	 a.simulate(resultsPanel, wind.getX(), wind.getY());
		resultsPanel.draw();
	}    

	private void okButtonActionPerformed(ActionEvent evt) {                                              
		wind = new Wind(Double.parseDouble(wspXTextField.getText()), Double.parseDouble(wspYTextField.getText()), Integer.parseInt(powerTextField.getText()));
	}  

	private void enythingButtonActionPerformed(ActionEvent evt) {                                            

	}                                          


	public void randomTable(){
		for(int i=0; i<700; i++){
			for(int j=0; j<570; j++){
				table[i][j] = (byte) (generator.nextInt(2)-1);
			}
		}
	}



	public void randomTable2(){


		/* for(int i=1; i<699; i++){
			 for(int j=1; j<569; j++){
				 temp[i][j] = (2*(table2[i-1][j]+table2[i+1][j]+table2[i][j-1]+table2[i][j+1]) + 4*table2[i][j] 
						      + (table2[i-1][j-1] + table2[i+1][j+1] + table2[i-1][j+1] + table2[i+1][j-1]))/16;

			 }
		 }

		 for(int i=345; i<355; i++){
			 for(int j=285; j<290; j++){
				 temp[i][j] = temp[i][j]+0.5;
			 }
		 }	 

		 for(int i=0; i<700; i++){
			 for(int j=0; j<570; j++){
				 table2[i][j] = temp[i][j];
			 }
		 }
		 */


	}



	public static double[][] getTable2() {
		return table2;
	}

	public static void setTable2(double[][] table2) {
		mainGui.table2 = table2;
	}

	public static double getWindRatio() {
		return windRatio;
	}

	public static void setWindRatio(double windRatio) {
		mainGui.windRatio = windRatio;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}



	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {


		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new mainGui().setVisible(true);
			}
		});
	}

}
