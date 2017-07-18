import sun.plugin.dom.css.Rect;
import sun.plugin.javascript.JSClassLoader;
import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by yushun on 2017/7/6.
 */
public class AcsDemo extends JFrame{
    private JPanel LowLevelFrame;
    private JTabbedPane MainTabs;
    private JTextField textDoorName;
    private JTextField textUnlockPwd;
    private JTextField textOpenDuration;
    private JTextField textSuPwd;
    private JTextField textMagnAlarmTimeout;
    private JTextField textStressPwd;
    private JTextField textDisabledCardDuration;
    private JTextField textLeaderCardDuration;
    private JComboBox cBOpenButton;
    private JComboBox cBMagneticType;
    private JCheckBox lockTheClosedDoorCheckBox;
    private JCheckBox enableFirstCardNormalCheckBox;
    private JCheckBox enableOpenButtonCheckBox;
    private JCheckBox detectDoorLockInputCheckBox;
    private JCheckBox isUseLocalControllerCheckBox;
    private JButton SaveConfigButton;
    private JTextField textLocalControlId;
    private JTextField textLocalControlNo;
    private JComboBox cBLocalStatus;
    private JComboBox cBDoorTermianlMode;
    private JComboBox cBLockInputType;
    private JComboBox cBLeaderCardMode;
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
    private JButton ClearLogButton;
    private JButton SaveLogButton;
    private JComboBox SelectLanguage;
    private JTable LogOutput;
    private DefaultTableModel TM_LogOutput;
    private JTextField textAcsXmlUrl;
    private JTextArea textAcsXmlArea1;
    private JTextArea textAcsXmlArea2;
    private JButton operateButton;
    private JButton clearAcsHostButton;
    private JTabbedPane tabbedPane2;
    private JTable DoorStatusT;
    private JComboBox cBLightStatus;
    private JComboBox cBFireAlarmStatus;
    private JCheckBox batteryUnderVoltageCheckBox;
    private JCheckBox startAntiPassbackCheckBox;
    private JCheckBox startHostTamperCheckBox;
    private JCheckBox startMultiDoorInterlockCheckBox;
    private JTextField textAddCardNo;
    private JTextField textBatteryV;
    private JComboBox cBPowerStatus;
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
    private JScrollPane DVRStateScroll;
    private JScrollPane ScrollUser1;
    private JTree DeviceTree;
    private JPanel LeftSideBar;
    private JCheckBox enableCheckBox;
    private JCheckBox enableFailAlarmCheckBox;
    private JCheckBox enableTemparCheckCheckBox;
    private JButton saveButton2;
    private JComboBox cBOKLedPolarity;
    private JComboBox cBErrorLedPolarity;
    private JComboBox cBBuzzerPolarity;
    private JTextField textSwipeInterval;
    private JTextField textPressTimeout;
    private JTextField textLimitFailedTimes;
    private JCheckBox useLocalControllerCheckBox;
    private JTextField textNo;
    private JTextField textReaderID;
    private JTextField textDescription;
    private JComboBox cBReaderChannel;
    private JComboBox cBLevel;
    private JComboBox cBLightCondition;
    private JComboBox cBRecognizeInterval;
    private JComboBox cBFastMode;
    private JComboBox cBPictureQuality;
    private JComboBox cBSensitive;
    private JComboBox cBCompareTimeout;
    private JComboBox cBRecognizeTimeout;
    private JComboBox cBFaceRecognizeInterval;
    private JTextField text11Threshold;
    private JTextField textImageExposure;
    private JTextField textFaceQuality;
    private JTextField text1NThreshold;
    private JComboBox cBCardReaderType;
    private JComboBox cBCardReader;
    private JTextField textOfflineCheckTime;
    private JTextField textBuzzerTime;
    private JComboBox cBLivingDectetion;
    private JButton weekPlanManagementButton2;
    private JButton holidayGroupManagementButton2;
    private JButton holidayPlanManagementButton2;
    private JButton planTemplateManagementButton2;
    private JButton cardReaderPlanManagementButton;
    private JPanel LogButton;
    private JPanel CardReaderConfigLeft;
    private JPanel CardReaderConfigRight;
    private ButtonGroup LogButtonGroup;

    public static void main(String[] args) {
        String look="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try
        {
            UIManager.setLookAndFeel(look);
        }
        catch(Exception ex)
        {
            System.out.println("Exception:"+ex);
        }
        JFrame frame = new JFrame("AcsDemo");

        try{
            frame.setContentPane(new AcsDemo().LowLevelFrame);
        }catch(Exception e){
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,600);
        frame.setResizable(false);

        Toolkit kit = Toolkit.getDefaultToolkit();  // 定义工具包
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width/2;       // 获取屏幕的宽
        int screenHeight = screenSize.height/2;     // 获取屏幕的高
        int height = frame.getHeight();
        int width = frame.getWidth();
        frame.setLocation(screenWidth-width/2, screenHeight-height/2);

        frame.setVisible(true);
    }

    private void createUIComponents() {
        LowLevelFrame = new JPanel();
        MainTabs = new JTabbedPane() ;
        textDoorName = new JTextField();
        textUnlockPwd = new JTextField();
        textOpenDuration = new JTextField();
        textSuPwd = new JTextField();
        textMagnAlarmTimeout = new JTextField();
        textStressPwd = new JTextField();
        textDisabledCardDuration = new JTextField();
        textLeaderCardDuration = new JTextField();
        cBOpenButton= new JComboBox();
        cBMagneticType= new JComboBox();
        lockTheClosedDoorCheckBox = new JCheckBox();
        enableFirstCardNormalCheckBox = new JCheckBox();
        enableOpenButtonCheckBox = new JCheckBox();
        detectDoorLockInputCheckBox = new JCheckBox();
        isUseLocalControllerCheckBox = new JCheckBox();
        SaveConfigButton = new JButton();
        textLocalControlId = new JTextField();
        textLocalControlNo = new JTextField();
        cBLocalStatus= new JComboBox();
        cBDoorTermianlMode= new JComboBox();
        cBLockInputType= new JComboBox();
        cBLeaderCardMode= new JComboBox();
        weekPlanManagementButton = new JButton();
        holidayPlanManagementButton = new JButton();
        holidayGroupManagementButton = new JButton();
        planTemplateManagementButton = new JButton();
        doorsStatusPlanManagementButton = new JButton();
        modifyButton = new JButton();
        deleteButton = new JButton();
        ClearLogButton = new JButton();
        SaveLogButton = new JButton();
        SelectLanguage= new JComboBox();
        textAcsXmlUrl = new JTextField();
        textAcsXmlArea1 = new JTextArea();
        textAcsXmlArea2 = new JTextArea();
        operateButton = new JButton();
        clearAcsHostButton = new JButton();
        tabbedPane2 = new JTabbedPane();
        cBLightStatus= new JComboBox();
        cBFireAlarmStatus= new JComboBox();
        batteryUnderVoltageCheckBox = new JCheckBox();
        startAntiPassbackCheckBox = new JCheckBox();
        startHostTamperCheckBox = new JCheckBox();
        startMultiDoorInterlockCheckBox = new JCheckBox();
        textAddCardNo = new JTextField();
        textBatteryV = new JTextField();
        cBPowerStatus= new JComboBox();
        tabbedPane3 = new JTabbedPane();
        weekPlanManagementButton1 = new JButton();
        holidayGroupManagementButton1 = new JButton();
        holidayPlanManagementButton1 = new JButton();
        planTemplateManagementButton1 = new JButton();
        cardManagementButton = new JButton();
        fingerPrintManagementButton = new JButton();
        cardNumUserLinkageButton = new JButton();
        faceManagementButton = new JButton();
        eventCardLinkageManagementButton = new JButton();
        getAcsHostEventButton = new JButton();
        DeviceInfo = new JPanel() ;
        DvrStatus = new JPanel() ;
        CustomSetting = new JPanel() ;
        DVRStateScroll = new JScrollPane();
        ScrollUser1 = new JScrollPane();
        LeftSideBar = new JPanel() ;
        enableCheckBox = new JCheckBox();
        enableFailAlarmCheckBox = new JCheckBox();
        enableTemparCheckCheckBox = new JCheckBox();
        saveButton2 = new JButton();
        cBOKLedPolarity= new JComboBox();
        cBErrorLedPolarity= new JComboBox();
        cBBuzzerPolarity= new JComboBox();
        textSwipeInterval = new JTextField();
        textPressTimeout = new JTextField();
        textLimitFailedTimes = new JTextField();
        useLocalControllerCheckBox = new JCheckBox();
        textNo = new JTextField();
        textReaderID = new JTextField();
        textDescription = new JTextField();
        cBReaderChannel= new JComboBox();
        cBLevel = new JComboBox();
        cBLightCondition= new JComboBox();
        cBRecognizeInterval= new JComboBox();
        cBFastMode= new JComboBox();
        cBPictureQuality= new JComboBox();
        cBSensitive= new JComboBox();
        cBCompareTimeout= new JComboBox();
        cBRecognizeTimeout= new JComboBox();
        cBFaceRecognizeInterval= new JComboBox();
        text11Threshold = new JTextField();
        textImageExposure = new JTextField();
        textFaceQuality = new JTextField();
        text1NThreshold = new JTextField();
        cBCardReaderType= new JComboBox();
        cBCardReader= new JComboBox();
        textOfflineCheckTime = new JTextField();
        textBuzzerTime = new JTextField();
        cBLivingDectetion= new JComboBox();
        weekPlanManagementButton2 = new JButton();
        holidayGroupManagementButton2 = new JButton();
        holidayPlanManagementButton2 = new JButton();
        planTemplateManagementButton2 = new JButton();
        cardReaderPlanManagementButton = new JButton();
        LogButton = new JPanel() ;
        CardReaderConfigLeft = new JPanel() ;
        CardReaderConfigRight = new JPanel() ;

        // TODO: place custom component creation code here

        String[] columnNameStatus={"Time","State","Operation","DeviceInformation","ErrorMessage"};
        String[] columnNameUserInfo={"Member No","Member Name","Card Amount","Finger PrintAmount"};
        String[] columnNameDoors={"Door No","Door Lock","Magnetic Status","Door Status"};
        String[] columnNameCardReader={"Card Reader No","Online Status","Anti Dismantle Status","Verify Mode"};
        String[] columnNameAlarmIn={"Alarm In No","Protection Status","Alarm In Status"};
        String[] columnNameAlarmOut={"Alarm Out No","Alarm Out Status"};
        String[] columnNameCaseSensor={"Case Sensor No","Case Sensor Status"};
        String[][] tableValue={};

        TM_LogOutput = new DefaultTableModel(tableValue,columnNameStatus);
        LogOutput = new JTable(TM_LogOutput){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        LogOutput.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        LogOutput.getTableHeader().setReorderingAllowed(false);
        LogOutput.getColumnModel().getColumn(0).setPreferredWidth(140);
        LogOutput.getColumnModel().getColumn(1).setPreferredWidth(50);
        LogOutput.getColumnModel().getColumn(2).setPreferredWidth(210);
        LogOutput.getColumnModel().getColumn(3).setPreferredWidth(180);
        LogOutput.getColumnModel().getColumn(4).setPreferredWidth(300);

        localLogRadioButton = new JRadioButton("Local Log");
        alarmInformationRadioButton = new JRadioButton("Alarm Information");
        LogButtonGroup = new ButtonGroup();
        LogButtonGroup.add(localLogRadioButton);
        LogButtonGroup.add(alarmInformationRadioButton);

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

        AddLog.TableInit(TM_LogOutput);

        DefaultMutableTreeNode root=new DefaultMutableTreeNode("Device Tree(Right Click To Add Device)");
        DeviceTree = new JTree(new DefaultTreeModel(root));

        DeviceTree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = e.getButton();
                if(i == MouseEvent.BUTTON3){
                    int x=e.getX();
                    int y=e.getY();

                    double xRangeLow = DeviceTree.getRowBounds(0).getX();
                    double xRangeHigh = DeviceTree.getRowBounds(0).getX()+DeviceTree.getRowBounds(0).getWidth();
                    double yRangeLow = DeviceTree.getRowBounds(0).getY();
                    double yRangeHigh = DeviceTree.getRowBounds(0).getY()+DeviceTree.getRowBounds(0).getHeight();

                    if((x>=xRangeLow&&x<=xRangeHigh)&&(y>=yRangeLow&&y<=yRangeHigh)){
                        AddDeviceToTree AddDevice=new AddDeviceToTree(AcsDemo.this);
                        /*DefaultMutableTreeNode r = (DefaultMutableTreeNode) DeviceTree.getModel().getRoot();
                        System.out.println(r.isRoot());*/
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {            }

            @Override
            public void mouseReleased(MouseEvent e) {            }

            @Override
            public void mouseEntered(MouseEvent e) {            }

            @Override
            public void mouseExited(MouseEvent e) {            }
        });

        addButton=new JButton();
        addButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=e.getButton();
                if(i==MouseEvent.BUTTON1){
                    System.out.println("Click Mouse1");
                    //UserManageAddButton UserAdd=new UserManageAddButton(AcsDemo.this);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {            }

            @Override
            public void mouseReleased(MouseEvent e) {            }

            @Override
            public void mouseEntered(MouseEvent e) {            }

            @Override
            public void mouseExited(MouseEvent e) {            }
        });
    }
}
