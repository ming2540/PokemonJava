import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;



public class PokemonGame extends JFrame{

	private JLabel statusLabel;
	JComboBox pokemonListBox;
	private ArrayList<Icon> images;
	private JTextField typeInput;
	private JTextField nameinput;
	private PokemonFarm pokemonFarm;
	private String pokemonNames[];
	private int comboBoxSize;

	public PokemonGame(PokemonFarm pokemonFarm){
		super("Pokemon Game");

		this.pokemonFarm = pokemonFarm;

		Container c = getContentPane();


		// ---- set layout ------
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		JLabel jLabel = new JLabel("Welcome to Pokemon Game");

		c.add(jLabel);

		JPanel windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.X_AXIS));
		c.add(windowPanel);

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel , BoxLayout.Y_AXIS));
		windowPanel.add(leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		windowPanel.add(rightPanel);

		//----- finish set layout -------


		//----- left panel ---------
		images = new ArrayList<Icon>();
		Icon imageLizardon = new ImageIcon(getClass().getResource("/image/lizardon.png"));
		
		JLabel imageChooser = new JLabel("");
		imageChooser.setIcon(imageLizardon);
		leftPanel.add(imageChooser);

		statusLabel = new JLabel("What your Choices?");
		leftPanel.add(statusLabel);

		pokemonNames = new String[10];
		pokemonListBox = new JComboBox(pokemonNames);
		//pokemonListBox.setMaximumRowCount(3);
		leftPanel.add(pokemonListBox);

		//----- finish left panel -------

		//------ right panel --------
		typeInput = new JTextField(8);
		rightPanel.add(typeInput);
		nameinput = new JTextField(8);
		rightPanel.add(nameinput);

		JButton addButton = new JButton("Add Pokemon");
		rightPanel.add(addButton);
		JButton feedButton = new JButton("Feed Pokemon");
		rightPanel.add(feedButton);
		JButton deleteButton = new JButton("Kill Pokemon");
		rightPanel.add(deleteButton);
		JButton findButton = new JButton("Find new Pokemon");
		rightPanel.add(findButton);
		JButton renameButton = new JButton("rename Pokemon");
		rightPanel.add(renameButton);
		JButton exerciseButton = new JButton("Exercise Pokemon");
		rightPanel.add(exerciseButton);
		//--------finish right panel---------

		//----Add Action Listener------
		addButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				pokemonFarm.add(typeInput.getText() , nameinput.getText() , null);
				pokemonNames[comboBoxSize] = nameinput.getText();
				comboBoxSize++;

				if(typeInput.getText().equalsIgnoreCase("lizardon")){
					images.add( new ImageIcon(getClass().getResource("/image/lizardon.png")) );
				}
				else if(typeInput.getText().equalsIgnoreCase("mew")){
					images.add( new ImageIcon(getClass().getResource("/image/mew.png")) );
				} 
				else if(typeInput.getText().equalsIgnoreCase("pidgey")){
					images.add( new ImageIcon(getClass().getResource("/image/pidgey.png")) );
				}
				else if(typeInput.getText().equalsIgnoreCase("pigeon")){
					images.add( new ImageIcon(getClass().getResource("/image/pigeon.png")) );
				}
			}
		});

		pokemonListBox.addItemListener(new ItemListener(){
		
			@Override
			public void itemStateChanged(ItemEvent e) {
				imageChooser.setIcon(images.get(pokemonListBox.getSelectedIndex()));
			}
		});












		setVisible(true);
		pack();
	}

	//--------- Action ------------
	public void addPokemon(){


	}







	public static void main(String[] args) {
		

		Bag bag = new Bag();
		PokemonFarm pokemonFarm = new PokemonFarm();
		Brush brush = new Brush();
		CommandParser commandParser = new CommandParser(pokemonFarm ,bag , brush);

		new PokemonGame(pokemonFarm);

		commandParser.run();

	}
}