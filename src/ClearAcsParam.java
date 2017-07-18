import javax.swing.*;
import java.awt.event.*;

public class ClearAcsParam extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JCheckBox cardRightWeekPlanCheckBox;
    private JCheckBox doorStatusWeekPlanCheckBox;
    private JCheckBox doorStatusHolidayGroupCheckBox;
    private JCheckBox cardRightHolidayGroupCheckBox;
    private JCheckBox cardReaderWeekPlanCheckBox;
    private JCheckBox doorStatusHolidayPlanCheckBox;
    private JCheckBox cardReaderHolidayPlanCheckBox;
    private JCheckBox cardRightHolidayPlanCheckBox;
    private JCheckBox cardReaderHolidayGroupCheckBox;
    private JCheckBox cardReaderVerifyPlanCheckBox;
    private JCheckBox doorStatusPlanTemplateCheckBox;
    private JCheckBox cardRightPlanTemplateCheckBox;
    private JCheckBox cardConfigureCheckBox;
    private JCheckBox groupConfigureCheckBox;
    private JCheckBox antiSneakConfigureCheckBox;
    private JCheckBox eventLinkageCardCheckBox;
    private JCheckBox openDoorByPasswordCheckBox;
    private JCheckBox personStatisticalCheckBox;
    private JButton buttonCancel;

    public ClearAcsParam() {
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
        ClearAcsParam dialog = new ClearAcsParam();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
