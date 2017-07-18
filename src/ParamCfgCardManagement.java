import javax.swing.*;
import java.awt.event.*;

public class ParamCfgCardManagement extends JDialog {
    private JPanel contentPane;
    private JTable table1;
    private JTable table2;
    private JButton editButton;
    private JButton exitButton;
    private JButton deleteAllCardButton;
    private JButton obtainIndividualButton;
    private JButton sendIndividualButton;
    private JButton getAllButton;
    private JButton sendAllButton;
    private JButton batchAddingButton;
    private JTextField textField1;
    private JTable table4;
    private JTable table5;
    private JTable table3;
    private JButton buttonOK;
    private JButton buttonCancel;

    public ParamCfgCardManagement() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ParamCfgCardManagement dialog = new ParamCfgCardManagement();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
