package fractal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The InformationPanel class creates the information panel that allows users
 * to enter input for how they want the fractal to look.
 * 
 * @author Daniel Santillan
 * @version 1.0
 */
public class InformationPanel extends JPanel {
	
	/** Version */
	private static final long serialVersionUID = 1L;
	/** The JTextfield that holds input for the number of sides */
	private JTextField numSidesInput;
	/** The JTextfield that holds input for the minimum fractal size */
	private JTextField minEdgeSizeInput;
	/** The JTextfield that holds input for the base shape edge length */
	private JTextField maxEdgeSizeInput;
	/** The JTextfield that holds input for the timer pause */
	private JTextField timerPauseInput;
	/** The JCheckBox that checks if the user wants the shape drawn */
	private JCheckBox drawShape;
	/** The JCheckBox that checks if the user wants the fractal drawn */
	private JCheckBox drawFractal;
	

	/**
	 * The InformationPanel constructor creates all the JLabels, JTextFields,
	 * and JCheckboxes necessary for this program. It also adds the JButtons,
	 * whose action listeners are in the RunMyFractal class. The components are
	 * aligned using a box layout.
	 * 
	 * @param draw the JButton to draw the fractal
	 * @param clear the JButton to clear the drawing panel
	 */
	public InformationPanel(JButton draw, JButton clear) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Color bgColor = new Color(220, 220, 220);
		setBackground(bgColor);
		
		Font helveticaBold = new Font("Helvetica", Font.BOLD, 17);
		Font helveticaPlain = new Font("Helvetica", Font.PLAIN, 17);
		Dimension textFieldDimension = new Dimension(100, 35);
		
		JLabel numSides = new JLabel("Number of Edges (Range 3-6)");
		numSides.setFont(helveticaBold);
		numSidesInput = new JTextField();
		numSidesInput.setText("4");
		numSidesInput.setFont(helveticaPlain);
		numSidesInput.setMinimumSize(numSidesInput.getPreferredSize());
		numSidesInput.setPreferredSize(textFieldDimension);
		numSidesInput.setMaximumSize(numSidesInput.getPreferredSize());
		
		JLabel minEdgeSize = new JLabel("Minimum Edge Size");
		minEdgeSize.setFont(helveticaBold);
		minEdgeSizeInput = new JTextField();
		minEdgeSizeInput.setText("10");
		minEdgeSizeInput.setFont(helveticaPlain);
		minEdgeSizeInput.setMinimumSize(minEdgeSizeInput.getPreferredSize());
		minEdgeSizeInput.setPreferredSize(textFieldDimension);
		minEdgeSizeInput.setMaximumSize(minEdgeSizeInput.getPreferredSize());
		
		JLabel maxEdgeSize = new JLabel("Base Edge Size");
		maxEdgeSize.setFont(helveticaBold);
		maxEdgeSizeInput = new JTextField();
		maxEdgeSizeInput.setText("200");
		maxEdgeSizeInput.setFont(helveticaPlain);
		maxEdgeSizeInput.setMinimumSize(maxEdgeSizeInput.getPreferredSize());
		maxEdgeSizeInput.setPreferredSize(textFieldDimension);
		maxEdgeSizeInput.setMaximumSize(maxEdgeSizeInput.getPreferredSize());
		
		JLabel timerPause = new JLabel("Timer Pause Time");
		timerPause.setFont(helveticaBold);
		timerPauseInput = new JTextField();
		timerPauseInput.setText("100");
		timerPauseInput.setFont(helveticaPlain);
		timerPauseInput.setMinimumSize(timerPauseInput.getPreferredSize());
		timerPauseInput.setPreferredSize(textFieldDimension);
		timerPauseInput.setMaximumSize(timerPauseInput.getPreferredSize());
		
		drawShape = new JCheckBox("Draw Shape");
		drawShape.setSelected(true);
		drawShape.setFont(helveticaBold);
		drawShape.setBackground(bgColor);
		
		drawFractal = new JCheckBox("Draw Fractal");
		drawFractal.setFont(helveticaBold);
		drawFractal.setBackground(bgColor);
		
		draw.setFont(helveticaBold);
		clear.setFont(helveticaBold);
		
		add(numSides);
		add(numSidesInput);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(minEdgeSize);
		add(minEdgeSizeInput);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(maxEdgeSize);
		add(maxEdgeSizeInput);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(timerPause);
		add(timerPauseInput);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(drawShape);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(drawFractal);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(draw);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(clear);
		
	}
	
	
	/**
	 * Returns the input of the number of sides. Exceptions are handled.
	 * 
	 * @return The input of the number of sides
	 */
	public int getNumSides() {
		try {
			return Integer.parseInt(numSidesInput.getText());
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	/**
	 * Returns the input of the minimum fractal size. Exceptions are handled.
	 * 
	 * @return The input of the minimum fractal size
	 */
	public int getMinEdgeSize() {
		try {
			return Integer.parseInt(minEdgeSizeInput.getText());
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	/**
	 * Returns the input of the polygon edge size. Exceptions are handled.
	 * 
	 * @return The input of the polygon edge size
	 */
	public int getMaxEdgeSize() {
		try {
			return Integer.parseInt(maxEdgeSizeInput.getText());
		} catch (Exception e) {
			return -1;
		}
	}

	
	/**
	 * Returns the input of the timer pause. Exceptions are handled.
	 * 
	 * @return The input of the timer pause
	 */
	public int getTimerPause() {
		try {
			return Integer.parseInt(timerPauseInput.getText());
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	/**
	 * Returns whether the user wants the shape drawn.
	 * 
	 * @return whether the shape is drawn
	 */
	public boolean isShapeDrawn() {
		return drawShape.isSelected();
	}
	
	
	/**
	 * Returns whether the user wants the fractal drawn.
	 * 
	 * @return whether the fractal is drawn
	 */
	public boolean isFractalDrawn() {
		return drawFractal.isSelected();
	}


	/**
	 * This is a simple toString that returns the field values for this class.
	 * 
	 * @return the field values for this class
	 */
	@Override
	public String toString() {
		return "InformationPanel [numSidesInput=" + numSidesInput + ", minEdgeSizeInput=" + minEdgeSizeInput
				+ ", maxEdgeSizeInput=" + maxEdgeSizeInput + ", timerPauseInput=" + timerPauseInput + ", drawShape="
				+ drawShape + ", drawFractal=" + drawFractal + "]";
	}
	
}
