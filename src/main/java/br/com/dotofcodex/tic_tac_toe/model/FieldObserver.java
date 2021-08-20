package br.com.dotofcodex.tic_tac_toe.model;

public interface FieldObserver {
	void update(Player player, int line, int col);
}
