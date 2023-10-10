import javax.swing.*;

public class TicTacToeButton extends JButton {
    private String state;

    public TicTacToeButton() {
        state = "";
    }

    public String getState() {
        return state;
    }

    public void setState(String newState) {
        state = newState;
    }
}
