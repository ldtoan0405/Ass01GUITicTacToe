import javax.swing.*;

public class SafeInput {

    /**
     * Get a String which contains at least one character
     *
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            retString = JOptionPane.showInputDialog(null, prompt);
        } while (retString.length() == 0); // until we have some characters

        return retString;
    }

    /**
     * Get an int value within a specified numeric range
     *
     * @param prompt - input prompt msg should not include range info
     * @param low    - low end of inclusive range
     * @param high   - high end of inclusive range
     * @return - int value within the inclusive range
     */
    public static int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;

        do {
            String response = JOptionPane.showInputDialog(null, prompt + " [" + low + "-" + high + "]: ");
            try {
                retVal = Integer.parseInt(response);
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Number is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You must enter an int: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get an int value with no constraints
     *
     * @param prompt - input prompt msg should not include range info
     * @return - unconstrained int value
     */
    public static int getInt(String prompt) {
        int retVal = 0;
        boolean done = false;

        do {
            String response = JOptionPane.showInputDialog(null, prompt + ": ");
            try {
                retVal = Integer.parseInt(response);
                done = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You must enter an int: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * get a double value within an inclusive range
     *
     * @param prompt - input prompt msg should not contain range info
     * @param low    - low value inclusive
     * @param high   - high value inclusive
     * @return - double value within the specified inclusive range
     */
    public static double getRangedDouble(String prompt, int low, int high) {
        double retVal = 0;
        boolean done = false;

        do {
            String response = JOptionPane.showInputDialog(null, prompt + " [" + low + "-" + high + "]: ");
            try {
                retVal = Double.parseDouble(response);
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Number is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You must enter a double: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get an unconstrained double value
     *
     * @param prompt - input prompt msg should not contain range info
     * @return - an unconstrained double value
     */
    public static double getDouble(String prompt) {
        double retVal = 0;
        boolean done = false;

        do {
            String response = JOptionPane.showInputDialog(null, prompt + ": ");
            try {
                retVal = Double.parseDouble(response);
                done = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You must enter a double: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get a [Y/N] confirmation from the user
     *
     * @param prompt - input prompt msg for user does not need [Y/N]
     * @return - true for yes false for no
     */
    public static boolean getYNConfirm(String prompt) {
        int response = JOptionPane.showConfirmDialog(null, prompt, "", JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }

    /**
     * Get a string that matches a RegEx pattern!
     *
     * @param prompt        - prompt for user
     * @param regExPattern - java style RegEx pattern to constrain the input
     * @return a String that matches the RegEx pattern supplied
     */
    public static String getRegExString(String prompt, String regExPattern) {
        String response = "";
        boolean gotAVal = false;

        do {
            response = JOptionPane.showInputDialog(null, prompt + ": ");
            if (response.matches(regExPattern)) {
                gotAVal = true;
            } else {
                JOptionPane.showMessageDialog(null, response + " must match the pattern " + regExPattern + "\nTry again!");
            }
        } while (!gotAVal);

        return response;
    }
}
