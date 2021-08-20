package br.com.dotofcodex.tic_tac_toe.model;

public class FieldPosition {
	private Player player;
	private boolean used;

	public FieldPosition(Player player, boolean used) {
		super();
		this.player = player;
		this.used = used;
	}

	public void canPlay(Player player) {
		if (this.used) {
			throw new RuntimeException("Jogada inválida");
		}

		this.player = player;
		this.used = true;
	}

	public Player getPlayer() {
		return player;
	}

	public Boolean getUsed() {
		return used;
	}

}
