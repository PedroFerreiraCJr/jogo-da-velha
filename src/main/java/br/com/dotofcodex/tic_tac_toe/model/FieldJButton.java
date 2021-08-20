package br.com.dotofcodex.tic_tac_toe.model;

import javax.swing.JButton;

public class FieldJButton extends JButton {

	private final int line;
	private final int col;

	public FieldJButton(String text, int line, int col) {
		super(text);
		this.line = line;
		this.col = col;
	}

	public int getLine() {
		return line;
	}

	public int getCol() {
		return col;
	}
}
