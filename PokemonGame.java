import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

import javafx.scene.control.cell.ComboBoxTableCell;

public class PokemonGame extends JFrame{

	private JLabel nameLabel;
	private JLabel specieLabel;
	private JLabel weightLabel;
	private JLabel soundLabel;
	private JComboBox pokemonListBox;
	private JTextField typeInput;
	private JTextField nameinput;
	private PokemonFarm pokemonFarm;
	private ArrayList<String> pokemonNameList;
	private JComboBox pokemonYed;
	private Egg egg;
	private int size;

	public PokemonGame(PokemonFarm pokemonFarm){
		super("Pokemon Game");

		size = 1 ;
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
		Icon imagePokemon = new ImageIcon(getClass().getResource("/image/pokemon.png"));
		Icon imageLizardon = new ImageIcon(getClass().getResource("/image/lizardon.png"));
		Icon imagePidgey = new ImageIcon(getClass().getResource("/image/pidgey.png"));
		Icon imagePigeon = new ImageIcon(getClass().getResource("/image/pigeon.png"));
		Icon imageMew = new ImageIcon(getClass().getResource("/image/mew.png"));
		Icon imageEgg =new ImageIcon(getClass().getResource("/image/egg.jpg"));

		
		JLabel imageChooser = new JLabel("");
		imageChooser.setIcon(imagePokemon);
		leftPanel.add(imageChooser);
		JLabel eggChooser = new JLabel("");
		leftPanel.add(eggChooser);

		nameLabel = new JLabel("What your Choices?");
		leftPanel.add(nameLabel);
		specieLabel = new JLabel("");
		leftPanel.add(specieLabel);
		weightLabel = new JLabel("");
		leftPanel.add(weightLabel);
		soundLabel = new JLabel("");
		leftPanel.add(soundLabel);
		

		pokemonNameList = new ArrayList<String>();
		pokemonListBox = new JComboBox(pokemonNameList.toArray());
		leftPanel.add(pokemonListBox);
		//----- finish left panel -------

		//------ right panel --------
		JLabel inputYourType = new JLabel("input your type(lizardon , mew , pidgey ,pigeon)");
		rightPanel.add(inputYourType);
		typeInput = new JTextField(1);
		rightPanel.add(typeInput);
		JLabel inputYourName = new JLabel("input your pokemon name");
		rightPanel.add(inputYourName); 
		nameinput = new JTextField(8);
		rightPanel.add(nameinput);

		JButton addButton = new JButton("Add Pokemon");
		rightPanel.add(addButton);
		JButton feedButton = new JButton("Feed Pokemon");
		rightPanel.add(feedButton);
		JButton yedButton = new JButton("Pokemon Yed");
		rightPanel.add(yedButton);
		JLabel chooseToYed = new JLabel("Choose other Pokemon To Yed");
		rightPanel.add(chooseToYed);
		pokemonYed = new JComboBox(pokemonNameList.toArray());
		rightPanel.add(pokemonYed);
		JButton hatchYourEgg = new JButton("Hatch your egg");
		rightPanel.add(hatchYourEgg);
	
		
		//--------finish right panel---------

		//----Add Action /Item Listener------
		addButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {

				if(isNotDuplicate(nameinput.getText())){
					pokemonFarm.add(typeInput.getText() , nameinput.getText() , null);
					// System.out.println(typeInput.getText() + " " + nameinput.getText());
					pokemonNameList.add(nameinput.getText());
					pokemonListBox.addItem(nameinput.getText());
					pokemonYed.addItem(nameinput.getText());
					JOptionPane.showMessageDialog(null, "Add Successful!");
				}
				else 
					JOptionPane.showMessageDialog(null, "Can't add pokemon with a same name");
			}
		});

		feedButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				pokemonFarm.feed(pokemonListBox.getSelectedIndex());
				weightLabel.setText("Weight : " + pokemonFarm.getPokemonWeight(pokemonListBox.getSelectedIndex()));
			}
		});	
		
		pokemonListBox.addItemListener(new ItemListener(){
		
			public void itemStateChanged(ItemEvent e) {
				
				nameLabel.setText("Name : " + pokemonFarm.getPokemonName(pokemonListBox.getSelectedIndex()));
				specieLabel.setText("Specie : " +pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()));
				weightLabel.setText("Weight : " + pokemonFarm.getPokemonWeight(pokemonListBox.getSelectedIndex()));
				soundLabel.setText(pokemonFarm.getPokemonSound(pokemonListBox.getSelectedIndex()));

				System.out.println(pokemonListBox.getSelectedIndex());

				if(pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()).equalsIgnoreCase("lizardon"))
					imageChooser.setIcon(imageLizardon);
				else if(pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()).equalsIgnoreCase("mew"))
					imageChooser.setIcon(imageMew);
				else if(pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()).equalsIgnoreCase("pidgey"))
					imageChooser.setIcon(imagePidgey);
				else if(pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()).equalsIgnoreCase("pigeon"))
					imageChooser.setIcon(imagePigeon);
			}
		});
	
		yedButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				if(pokemonListBox.getSelectedIndex() == pokemonYed.getSelectedIndex())
					JOptionPane.showMessageDialog(null , "Can't yed it's self");
				else if(pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()).equals(pokemonFarm.getPokemonSpecie(pokemonYed.getSelectedIndex()))){
					egg = new Egg(pokemonFarm.getPokemonSpecie(pokemonListBox.getSelectedIndex()));
					eggChooser.setIcon(imageEgg);
					JOptionPane.showMessageDialog(null, "Yed successful!");
				}
				else 
					JOptionPane.showMessageDialog(null, "Can't Yed other Species");
					
			}
		});

		hatchYourEgg.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				pokemonFarm.add(egg.getEgg() , "egg pokemon " + size, null);
				pokemonListBox.addItem("egg pokemon" + size);
				pokemonYed.addItem("egg pokemon" + size);
				JOptionPane.showMessageDialog(null, "hatch Successful!");
				eggChooser.setIcon(null);
				size++;
			}
		});

		//---------- end Add Action -------

		setVisible(true);
		pack();
	
	}

	//--------- Action ------------
	public Boolean isNotDuplicate(String nameCheck){

		for(String name : pokemonNameList){
			if(name.equals(nameCheck))
				return false;
		}
		return true;

	}


	//--------- end Action--------
	


	public static void main(String[] args) {
		

		Bag bag = new Bag();
		PokemonFarm pokemonFarm = new PokemonFarm();
		Brush brush = new Brush();
		CommandParser commandParser = new CommandParser(pokemonFarm ,bag , brush);

		new PokemonGame(pokemonFarm);

		commandParser.run();

	}
}