package br.com.dotofcodex.tic_tac_toe.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import br.com.dotofcodex.tic_tac_toe.model.Field;
import br.com.dotofcodex.tic_tac_toe.model.FieldObserver;
import br.com.dotofcodex.tic_tac_toe.model.Player;
import br.com.dotofcodex.tic_tac_toe.model.SimpleEventHandler;
import br.com.dotofcodex.tic_tac_toe.util.JanelaPrincipalHelper;

public class JanelaPrincipal extends JFrame {

	private Field ticTacToe;
	private boolean first = false;
	private FieldObserver observer = new FieldObserver() {
		@Override
		public void update(Player player, int line, int col) {
			System.out.println(
					"Jogada completada pelo player: " + player.getSymbol() + ", na posição: " + line + ":" + col);
		}
	};

	public JanelaPrincipal() {
		super("Jogo da Velha");
		this.ticTacToe = new Field();
		this.ticTacToe.init();
		this.ticTacToe.addFieldObserver(observer);
		init();
		buildStage();
	}

	private void init() {
		setSize(new Dimension(400, 400));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void buildStage() {
		JRootPane container = getRootPane();
		JPanel panel = new JPanel(new GridLayout(3, 3));
		container.setContentPane(panel);

		JanelaPrincipalHelper.buildJPanelGripLayout(panel, new SimpleEventHandler() {
			@Override
			public void fieldPosition(int line, int col) {
				Player player = null;
				if (!first) {
					player = ticTacToe.getPlayerX();
					first = true;
				} else {
					player = ticTacToe.getPlayerOfTurn();
				}
				
				try {
					ticTacToe.play(player, line, col);
				} catch(RuntimeException e) {
					JOptionPane.showMessageDialog(JanelaPrincipal.this, e.getMessage());
				}
			}
		});
	}

	public void launch() {
		setVisible(true);
	}
}
