import sun.plugin.javascript.JSClassLoader;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yushun on 2017/7/6.
 */
public class AcsDemo extends JFrame{
    private JPanel LowLevelFrame;
    private JTabbedPane MainTabs;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JCheckBox lockTheClosedDoorCheckBox;
    private JCheckBox enableFirstCardNormalCheckBox;
    private JCheckBox enableOpenButtonCheckBox;
    private JCheckBox detectDoorLockInputCheckBox;
    private JCheckBox isUseLocalControllerCheckBox;
    private JButton saveButton;
    private JTextField textField2;
    private JTextField textField4;
    private JComboBox comboBox6;
    private JComboBox comboBox5;
    private JComboBox comboBox4;
    private JComboBox comboBox3;
    private JButton weekPlanManagementButton;
    private JButton holidayPlanManagementButton;
    private JButton holidayGroupManagementButton;
    private JButton planTemplateManagementButton;
    private JButton doorsStatusPlanManagementButton;
    private JTable UserInfo;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JRadioButton localLogRadioButton;
    private JRadioButton alarmInformationRadioButton;
    private JButton clearButton;
    private JButton saveButton1;
    private JComboBox SelectLanguage;
    private JTable LogOutput;
    private JTextField textField11;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton operateButton;
    private JButton clearAcsHostButton;
    private JTabbedPane tabbedPane2;
    private JTable DoorStatusT;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JCheckBox batteryUnderVoltageCheckBox;
    private JCheckBox startAntiPassbackCheckBox;
    private JCheckBox startHostTamperCheckBox;
    private JCheckBox startMultiDoorInterlockCheckBox;
    private JTextField textField12;
    private JTextField textField13;
    private JComboBox comboBox7;
    private JTable CardReaderStatusT;
    private JTable AlarmInStatusT;
    private JTable AlarmOutStatusT;
    private JTable CaseStatusT;
    private JTabbedPane tabbedPane3;
    private JButton weekPlanManagementButton1;
    private JButton holidayGroupManagementButton1;
    private JButton holidayPlanManagementButton1;
    private JButton planTemplateManagementButton1;
    private JButton cardManagementButton;
    private JButton fingerPrintManagementButton;
    private JButton cardNumUserLinkageButton;
    private JButton faceManagementButton;
    private JButton eventCardLinkageManagementButton;
    private JButton getAcsHostEventButton;
    private JPanel DeviceInfo;
    private JPanel DvrStatus;
    private JPanel CustomSetting;
    private JScrollPane Scroll1;
    private JScrollPane ScrollUser1;
    private JTree tree1;
    private JPanel LeftSideBar;
    private JPanel VersionInfo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AcsDemo");
        frame.setContentPane(new AcsDemo().LowLevelFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnNameStatus={"Time","State","Operation","DeviceInformation","ErrorMessage"};
        String[] columnNameUserInfo={"Member No","Member Name","Card Amount","Finger PrintAmount"};
        String[] columnNameDoors={"Door No","Door Lock","Magnetic Status","Door Status"};
        String[] columnNameCardReader={"Card Reader No","Online Status","Anti Dismantle Status","Verify Mode"};
        String[] columnNameAlarmIn={"Alarm In No","Protection Status","Alarm In Status"};
        String[] columnNameAlarmOut={"Alarm Out No","Alarm Out Status"};
        String[] columnNameCaseSensor={"Case Sensor No","Case Sensor Status"};
        String[][] tableValue={};

        LogOutput=new JTable(tableValue,columnNameStatus);
        UserInfo=new JTable(tableValue,columnNameUserInfo);
        DoorStatusT=new JTable(tableValue,columnNameDoors);
        CardReaderStatusT=new JTable(tableValue,columnNameCardReader);
        AlarmInStatusT=new JTable(tableValue,columnNameAlarmIn);
        AlarmOutStatusT=new JTable(tableValue,columnNameAlarmOut);
        CaseStatusT=new JTable(tableValue,columnNameCaseSensor);

        JScrollPane scrollp1=new JScrollPane(LogOutput);
        JScrollPane scrollp2=new JScrollPane(UserInfo);
        JScrollPane scrollp3=new JScrollPane(DoorStatusT);
        JScrollPane scrollp4=new JScrollPane(CardReaderStatusT);
        JScrollPane scrollp5=new JScrollPane(AlarmInStatusT);
        JScrollPane scrollp6=new JScrollPane(AlarmOutStatusT);
        JScrollPane scrollp7=new JScrollPane(CaseStatusT);

        getContentPane().add(scrollp1,BorderLayout.CENTER);
        getContentPane().add(scrollp2,BorderLayout.CENTER);
        getContentPane().add(scrollp3,BorderLayout.CENTER);
        getContentPane().add(scrollp4,BorderLayout.CENTER);
        getContentPane().add(scrollp5,BorderLayout.CENTER);
        getContentPane().add(scrollp6,BorderLayout.CENTER);
        getContentPane().add(scrollp7,BorderLayout.CENTER);
    }
}
