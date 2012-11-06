/**
 * 
 */
package fr.imag.erods.robair.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.apache.felix.ipojo.annotations.Bind;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Unbind;
import org.apache.felix.ipojo.annotations.Validate;

import fr.imag.erods.robair.IRobotController;

/**
 * 
 * @author Thomas Calmant
 */
@Component(name = "robair-ui-factory", publicFactory = false)
@Instantiate(name = "robair-ui")
public class RobotUI {

	/** The robot controller dependency ID */
	private static final String IPOJO_DEP_CONTROLLER = "robot-controller";

	/** The robot controller */
	@Requires(id = IPOJO_DEP_CONTROLLER, optional = true)
	private IRobotController pController;

	/** Controller presence */
	private boolean pControlPresent = false;

	private JLabel pLblLeft;

	private JLabel pLblRight;

	/** The main frame */
	private JFrame pMainFrame;

	/** Motor X point */
	private int pMotorLeft;

	/** Motor Y point */
	private int pMotorRight;

	/** List of pad buttons */
	private final List<JButton> pPadButtons = new LinkedList<JButton>();

	/**
	 * Called by iPOJO when a robot controller is bound
	 * 
	 * @param aController
	 *            A robot controller
	 */
	@Bind(id = IPOJO_DEP_CONTROLLER)
	protected void bindController(final IRobotController aController) {
		// Activate buttons
		pControlPresent = true;
		updateButtons();
	}

	/**
	 * Component invalidated
	 */
	@Invalidate
	public void invalidate() {

		pMainFrame.setVisible(false);
		pMainFrame = null;

		pPadButtons.clear();
		pLblLeft = null;
		pLblRight = null;
	}

	/**
	 * Sets up the UI
	 */
	private void makeUI() {

		// Create the frame
		pMainFrame = new JFrame("RobAIR UI");
		pMainFrame
				.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		pMainFrame.setLayout(new BorderLayout());

		// Create the pad panel
		final JPanel padPanel = new JPanel();
		padPanel.setLayout(new GridBagLayout());
		pMainFrame.add(padPanel, BorderLayout.CENTER);

		// Create the buttons
		int maxX = 0;
		int maxY = 0;
		int minimumButtonSizeX = 0;
		int minimumButtonSizeY = 0;
		for (final EPadButton padButton : EPadButton.values()) {

			final JButton button = new JButton(padButton.toString());
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent aEvent) {

					onPadButtonEvent(aEvent, padButton);
				}
			});
			button.setMnemonic(padButton.getMnemonic());

			final Dimension btnSize = padButton.getSize();
			button.setMinimumSize(btnSize);
			button.setPreferredSize(btnSize);

			// Add the button to the panel
			final Point buttonPos = padButton.getPoint();
			final GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = (int) buttonPos.getX();
			constraints.gridy = (int) buttonPos.getY();
			padPanel.add(button, constraints);

			// ... to the list
			pPadButtons.add(button);

			// Minimum size...
			if (maxX < buttonPos.getX()) {
				maxX = (int) buttonPos.getX();
			}

			if (maxY < buttonPos.getY()) {
				maxY = (int) buttonPos.getY();
			}

			if (minimumButtonSizeX < btnSize.getWidth()) {
				minimumButtonSizeX = (int) btnSize.getWidth();
			}

			if (minimumButtonSizeY < btnSize.getHeight()) {
				minimumButtonSizeY = (int) btnSize.getHeight();
			}
		}

		final Dimension panelSize = new Dimension((maxX + 1)
				* minimumButtonSizeX + 10, (maxY + 1) * minimumButtonSizeY + 30);
		padPanel.setMinimumSize(panelSize);
		padPanel.setPreferredSize(panelSize);

		// Create the motors speed information
		final JPanel speedsPanel = new JPanel();
		speedsPanel.setLayout(new GridLayout(1, 2));
		pMainFrame.add(speedsPanel, BorderLayout.SOUTH);

		pLblLeft = new JLabel();
		speedsPanel.add(pLblLeft);

		pLblRight = new JLabel();
		speedsPanel.add(pLblRight);

		// Show all
		pMainFrame.pack();
		pMainFrame.setVisible(true);
	}

	/**
	 * Returns a speed between -60 and +60
	 * 
	 * @param aMotorLeft
	 * @return
	 */
	private int normalizeSpeed(final int aSpeed) {

		if (aSpeed < -60) {
			return -60;
		} else if (aSpeed > 60) {
			return 60;
		}

		return aSpeed;
	}

	/**
	 * Pad buttons event handler
	 * 
	 * @param aEvent
	 *            The swing event
	 * @param aPad
	 *            The clicked button
	 */
	private void onPadButtonEvent(final ActionEvent aEvent,
			final EPadButton aPad) {

		switch (aPad) {
		case RESET:
			pController.reset();
			pMotorLeft = 0;
			pMotorRight = 0;
			updateLabels();
			return;

		case FORWARD:
			pMotorLeft += 20;
			pMotorRight += 20;
			break;

		case BACKWARD:
			pMotorLeft -= 20;
			pMotorRight -= 20;
			break;

		case LEFT:
			pMotorLeft -= 10;
			pMotorRight += 10;
			break;

		case RIGHT:
			pMotorLeft += 10;
			pMotorRight -= 10;
			break;
		}

		pMotorLeft = normalizeSpeed(pMotorLeft);
		pMotorRight = normalizeSpeed(pMotorRight);

		pController.setMotors(pMotorLeft, pMotorRight);
		updateLabels();
	}

	/**
	 * Called by iPOJO when a robot controller is gone
	 * 
	 * @param aController
	 *            A robot controller
	 */
	@Unbind(id = IPOJO_DEP_CONTROLLER)
	protected void unbindController(final IRobotController aController) {
		// Deactivate buttons
		pControlPresent = false;
		updateButtons();
	}

	/**
	 * Updates pad buttons state
	 */
	private void updateButtons() {

		for (final JButton button : pPadButtons) {
			button.setEnabled(pControlPresent);
		}
	}

	/**
	 * Updates the speed labels
	 */
	private void updateLabels() {

		pLblLeft.setText(String.valueOf(pMotorLeft));
		pLblRight.setText(String.valueOf(pMotorRight));
	}

	/**
	 * Component validated
	 */
	@Validate
	public void validate() {

		pMotorLeft = 0;
		pMotorRight = 0;

		// Show the UI
		makeUI();

		updateButtons();
		updateLabels();
	}
}
