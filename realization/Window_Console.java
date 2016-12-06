package realization;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import realization.Window_Paint.RectCanvas;

public class Window_Console extends JFrame implements ActionListener {

	private static final long serialVersionUID = 233;

	public Window_Paint WD_Paint;
	
	JButton BT_Run;
	JLabel LB_Algorithm, LB_Map,LB_Sleep;
	JTextField TF_SleepTime;
	JComboBox CB_Algorithm;
	JComboBox CB_Map;
	//JCheckBox CB_Diagonal;

	Window_Console() {

		// Configuration of Window
		setTitle("Configuration of PathFinding ASlgorithm");
		setBounds(0, 0, 300, 500);
		setLayout(null);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Configuration of Button
		BT_Run = new JButton("Run");
		BT_Run.setBounds(getWidth() / 2 - 75, getHeight() - 100, 150, 50);
		BT_Run.addActionListener(this);
		add(BT_Run);

		// Configuration of Labels
		LB_Algorithm = new JLabel("Algorithm:");
		LB_Algorithm.setBounds(5, 0, 80, 50);
		add(LB_Algorithm);
		
		LB_Map = new JLabel("Map:");
		LB_Map.setBounds(5, 50, 80, 50);
		add(LB_Map);
		
		LB_Sleep = new JLabel("Sleep Time :");
		LB_Sleep.setBounds(5, 100, 110, 50);
		add(LB_Sleep);
		
		// Configuration of TextFields
		TF_SleepTime = new JTextField("0");
		TF_SleepTime.setBounds(80, 109, 165, 30);
		add(TF_SleepTime);

		// Configuration of ComboBox
		CB_Algorithm = new JComboBox();
		CB_Algorithm.addItem("Breadth-first Search");
		CB_Algorithm.addItem("Greedy Algorithm1");
		CB_Algorithm.addItem("Greedy Algorithm2");
		CB_Algorithm.addItem("A* Search Algorithm");
		CB_Algorithm.setSelectedItem("A* Search Algorithm");
		CB_Algorithm.setBounds(80, 9, 165, 30);
		add(CB_Algorithm);
		
		CB_Map = new JComboBox();
		CB_Map.addItem("Map 1");
		CB_Map.addItem("Map 2");
		CB_Map.addItem("Map 3");
		CB_Map.addItem("Map 4");
		CB_Map.addItem("Map 5");
		CB_Map.addItem("Map 6");
		CB_Map.addItem("Map 7");
		CB_Map.setSelectedItem("Map 1");
		CB_Map.setBounds(80, 59, 165, 30);
		add(CB_Map);
		
		// Configuration of CheckBox
		/*CB_Diagonal = new JCheckBox("Allow Diagonal");
		CB_Diagonal.setSelected(false);
		CB_Diagonal.setBounds(5, 149, 120, 30);
		add(CB_Diagonal);*/
		
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String algoChosen = CB_Algorithm.getSelectedItem().toString();
		switch(CB_Map.getSelectedIndex()) {
		case 0:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst1);
			break;
		case 1:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst2);
			break;
		case 2:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst3);
			break;
		case 3:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst4);
			break;
		case 4:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst5);
			break;
		case 5:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst6);
			break;
		case 6:
			WD_Paint = new Window_Paint(algoChosen, Entrance.Obst7);
			break;
		default:
			System.out.println("Debug>> Error code: 233.");
			break;
		}
		
		switch (CB_Algorithm.getSelectedIndex()) {
		case 0:
			WD_Paint.obst.AlgoBFS(WD_Paint.canvas);
			break;
		case 1:
			WD_Paint.obst.AlgoGreedy1(WD_Paint.canvas);
			break;
		case 2:
			WD_Paint.obst.AlgoGreedy2(WD_Paint.canvas);
			break;
		case 3:
			WD_Paint.obst.AlgoAStar(WD_Paint.canvas);
			break;
		default:
			System.out.println("Debug>> Error code: 233.");
			break;
		}
	}
}
