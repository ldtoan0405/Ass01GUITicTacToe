import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame implements ActionListener {
    private TicTacToeButton[][] buttons;
    private JButton quitButton;
    private final int ROWS = 3;
    private final int COLS = 3;
    private TicTacToe gameLogic;
    private String currentPlayer;

    public TicTacToeFrame() {
        gameLogic = new TicTacToe();
        currentPlayer = "X";

        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(ROWS + 1, COLS)); // Add 1 row for the quit button

        buttons = new TicTacToeButton[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j] = new TicTacToeButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        add(quitButton);

        setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == quitButton) {
            System.exit(0);
        } else {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (source == buttons[i][j]) {
                        if (gameLogic.makeMove(i, j, currentPlayer)) {
                            buttons[i][j].setText(currentPlayer);
                            buttons[i][j].setEnabled(false); // Disable the button after a move
                            if (gameLogic.isWin(currentPlayer)) {
                                int choice = JOptionPane.showOptionDialog(this, "Player " + currentPlayer + " wins!\nDo you want to start a new game?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New Game", "Quit"}, "New Game");
                                if (choice == JOptionPane.YES_OPTION) {
                                    resetBoard();
                                } else {
                                    System.exit(0);
                                }
                            } else if (gameLogic.isTie()) {
                                int choice = JOptionPane.showOptionDialog(this, "It's a Tie!\nDo you want to start a new game?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New Game", "Quit"}, "New Game");
                                if (choice == JOptionPane.YES_OPTION) {
                                    resetBoard();
                                } else {
                                    System.exit(0);
                                }
                            } else {
                                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid move. Try again.");
                        }
                    }
                }
            }
        }
    }


    private void resetBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true); // Re-enable the buttons
                gameLogic.clearBoard();
            }
        }
        currentPlayer = "X";
    }
}
