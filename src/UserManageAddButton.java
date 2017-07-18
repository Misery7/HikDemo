import javax.swing.*;
import java.awt.event.*;

public class UserManageAddButton extends JDialog {
    private JPanel contentPane;
    private JButton UbuttonAdd;
    private JButton buttonCancel;
    private JButton addButton;
    private JButton confirmButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JCheckBox door4CheckBox;
    private JCheckBox door3CheckBox;
    private JCheckBox door2CheckBox;
    private JCheckBox door1CheckBox;
    private JTable table2;
    private JButton modifyButton;
    private JTextField textField3;
    private JCheckBox equipmentCallbackNonBlockCheckBox;
    private JTextField textField4;
    private JButton browseButton;
    private JComboBox comboBox1;
    private JTextField textField5;
    private JTextField textField6;
    private JCheckBox cardReader8CheckBox;
    private JCheckBox cardReader7CheckBox;
    private JCheckBox cardReader6CheckBox;
    private JCheckBox cardReader3CheckBox;
    private JCheckBox cardReader1CheckBox;
    private JCheckBox cardReader2CheckBox;
    private JCheckBox cardReader4CheckBox;
    private JCheckBox cardReader5CheckBox;
    private JButton modeifyButton;
    private JButton deleteButton;

    public UserManageAddButton() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(UbuttonAdd);

        UbuttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onUbuttonAdd();
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

    private void onUbuttonAdd() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public UserManageAddButton(JFrame frame) {
        super(frame,true);
        frame.setContentPane(new UserManageAddButton().contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(700,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UserManageAddButton dialog = new UserManageAddButton();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
