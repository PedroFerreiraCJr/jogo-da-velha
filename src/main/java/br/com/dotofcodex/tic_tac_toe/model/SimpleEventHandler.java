package br.com.dotofcodex.tic_tac_toe.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface SimpleEventHandler extends ActionListener {
	public default void actionPerformed(ActionEvent e) {
		FieldJButton source = (FieldJButton) e.getSource();
		fieldPosition(source.getLine(), source.getCol());
	}
	
	public void fieldPosition(int line, int col);
}