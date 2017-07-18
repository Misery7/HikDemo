import javax.swing.*;
import java.awt.event.*;

public class ParamCfgEventCardLinkage extends JDialog {
    private JPanel contentPane;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox MACAddressLinkageCheckBox;
    private JCheckBox buzzerOnTheHostCheckBox;
    private JCheckBox recordLinkageCheckBox;
    private JCheckBox snapshortLinkageCheckBox;
    private JTextField textField2;
    private JTextField textField1;
    private JCheckBox cardNoLinkageCheckBox;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton getButton;
    private JButton setButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public ParamCfgEventCardLinkage() {
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
        ParamCfgEventCardLinkage dialog = new ParamCfgEventCardLinkage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
