package br.com.dotofcodex.tic_tac_toe.model;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private Player playerX;
	private Player playerO;
	private Player firstPlayer;
	private boolean firstPlay;
	private Player turn;
	private FieldPosition[][] matrix;
	private List<FieldObserver> observers;

	public Field() {
		super();
	}

	public void init() {
		this.playerX = new Player("X");
		this.playerO = new Player("O");
		this.firstPlayer = null;
		this.firstPlay = false;
		this.turn = null;
		this.observers = new ArrayList<>();
		resetField();
	}

	public void play(Player player, int line, int col) {
		if (!this.firstPlay) {
			this.firstPlay = true;
			this.firstPlayer = player;
			
			FieldPosition pos = matrix[line][col];
			pos.canPlay(player);
			
			setNextPlayerTurn(player, true);
			notifyObservers(player, line, col);
			return;
		}
		
		FieldPosition pos = matrix[line][col];
		pos.canPlay(player);
		
		setNextPlayerTurn(player, false);
		
		notifyObservers(player, line, col);
	}

	public void resetField() {
		this.matrix = new FieldPosition[][] {
			{ new FieldPosition(null, false), new FieldPosition(null, false), new FieldPosition(null, false) },
			{ new FieldPosition(null, false), new FieldPosition(null, false), new FieldPosition(null, false) },
			{ new FieldPosition(null, false), new FieldPosition(null, false), new FieldPosition(null, false) }
		};
	}
	
	public Player getPlayerX() {
		return this.playerX;
	}
	
	public Player getPlayerO() {
		return this.playerO;
	}
	
	public void setNextPlayerTurn(Player player, boolean firstPlay) {
		if (firstPlay) {
			if (player.equals(playerX)) {
				this.turn = playerO;
			} else {
				this.turn = playerX;
			}
		} else {
			if (player.equals(playerX)) {
				this.turn = playerO;
			} else {
				this.turn = playerX;
			}
		}
	}
	
	public Player getPlayerOfTurn() {
		return this.turn;
	}
	
	public void addFieldObserver(FieldObserver observer) {
		this.observers.add(observer);
	}
	
	private void notifyObservers(Player player, int line, int col) {
		for (FieldObserver obs: this.observers) {
			obs.update(player, line, col);
		}
	}
}
