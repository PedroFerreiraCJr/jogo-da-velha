package br.com.dotofcodex.tic_tac_toe.util;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import br.com.dotofcodex.tic_tac_toe.model.FieldJButton;

public class SwingComponentsFactory {
	private SwingComponentsFactory() {
		super();
	}

	public static JLabel getJLabelInstance(String text) {
		return new JLabel(text);
	}

	public static JButton getJButtonInstance(String text) {
		JButton button = new JButton(text);
		button.setFont(new Font("Arial", Font.PLAIN, 50));
		return button;
	}

	public static JButton getFieldJButtonInstance(String text, int line, int col) {
		FieldJButton button = new FieldJButton(text, line, col);
		button.setFont(new Font("Arial", Font.PLAIN, 50));
		return button;
	}
	
	public static void applyCenterAlignmentToJLabel(JLabel label) {
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
	}

	public static void applyCenterAlignmentToJButton(JButton button) {
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
	}
}
