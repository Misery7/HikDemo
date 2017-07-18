import javax.swing.*;
import java.awt.event.*;

public class ParamCfgFingerPrintMgr extends JDialog {
    private JPanel contentPane;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton deleteButton;
    private JTable table2;
    private JButton addButton;
    private JButton setButton;
    private JButton getButton;
    private JCheckBox cardReader1CheckBox;
    private JCheckBox cardReader2CheckBox;
    private JCheckBox cardReader8CheckBox;
    private JCheckBox cardReader3CheckBox;
    private JCheckBox cardReader4CheckBox;
    private JCheckBox cardReader5CheckBox;
    private JCheckBox cardReader6CheckBox;
    private JCheckBox cardReader7CheckBox;
    private JCheckBox id1CheckBox;
    private JCheckBox id8CheckBox;
    private JCheckBox id7CheckBox;
    private JCheckBox id5CheckBox;
    private JCheckBox id2CheckBox;
    private JCheckBox id6CheckBox;
    private JCheckBox id4CheckBox;
    private JCheckBox id3CheckBox;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button5;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JTextField textField5;
    private JCheckBox equipmentCallbackNonBlockCheckBox;
    private JTextField textField6;
    private JCheckBox deleteAllCheckBox;
    private JButton buttonOK;
    private JButton buttonCancel;

    public ParamCfgFingerPrintMgr() {
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
        ParamCfgFingerPrintMgr dialog = new ParamCfgFingerPrintMgr();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
