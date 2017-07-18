import javax.swing.*;
import java.awt.event.*;

public class ParamCfgHolidayPlan extends JDialog {
    private JPanel contentPane;
    private JButton confirmButton;
    private JButton getButton;
    private JButton setButton;
    private JCheckBox enableCheckBox;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField3;
    private JTextField textField4;
    private JTable table1;
    private JCheckBox enableCheckBox1;
    private JButton updateButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public ParamCfgHolidayPlan() {
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
        ParamCfgHolidayPlan dialog = new ParamCfgHolidayPlan();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
