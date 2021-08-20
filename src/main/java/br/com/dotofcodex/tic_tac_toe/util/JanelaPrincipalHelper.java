package br.com.dotofcodex.tic_tac_toe.util;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.dotofcodex.tic_tac_toe.model.SimpleEventHandler;

public class JanelaPrincipalHelper {
	public static void buildJPanelGripLayout(JPanel panel, SimpleEventHandler handler) {
		JButton button = null;
		for (int line = 0; line < 3; line++) {
			for (int col = 0; col < 3; col++) {
				button = SwingComponentsFactory.getFieldJButtonInstance("", line, col);
				SwingComponentsFactory.applyCenterAlignmentToJButton(button);
				button.addActionListener(handler);
				panel.add(button);
			}
		}
	}
}
