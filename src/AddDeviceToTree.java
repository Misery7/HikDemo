import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;

public class AddDeviceToTree extends JDialog {
    private JPanel contentPane;
    private JButton AddButton;
    private JButton CancelButton;
    private JCheckBox aysnLoginCheckBox;
    private JTextField LocalNodeName;
    private JTextField DeviceUserName;
    private JTextField DeviceIPAddr;
    private JTextField DefaultPort;
    private JPasswordField DevicePwd;

    public AddDeviceToTree() {
        this.setContentPane(contentPane);
        this.setModal(true);
        getRootPane().setDefaultButton(AddButton);

        AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddButton();
            }
        });

        CancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelButton();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancelButton();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelButton();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onAddButton() {
        HCNetSDK.HikInstance.NET_DVR_Init();
        HCNetSDK.HikInstance.NET_DVR_SetLogToFile(3,"D:\\Log\\".getBytes(),true);
        HCNetSDK.HikInstance.NET_DVR_SetConnectTime(2000,1);
        HCNetSDK.HikInstance.NET_DVR_SetReconnect(10000,true);

        HCNetSDK.NET_DVR_USER_LOGIN_INFO struLoginInfo=new HCNetSDK.NET_DVR_USER_LOGIN_INFO();
        struLoginInfo.bUseAsynLogin=false;

        String strIP = DeviceIPAddr.getText().toString();
        byte[] byIP = new byte[strIP.length()];
        byIP = strIP.getBytes();
        for(int i = 0; i < strIP.length(); i++)
        {
            struLoginInfo.sDeviceAddress[i] = byIP[i];
        }

        struLoginInfo.wPort = (short)new Short(DefaultPort.getText().toString()).shortValue();

        String strUser = DeviceUserName.getText().toString();
        byte[] byUser = new byte[strUser.length()];
        byUser = strUser.getBytes();
        for(int i = 0; i < strUser.length(); i++)
        {
            struLoginInfo.sUserName[i] = byUser[i];
        }

        String strPwd = DevicePwd.getText().toString();
        byte[] byPwd = new byte[strPwd.length()];
        byPwd = strPwd.getBytes();
        for(int i = 0; i < strPwd.length(); i++)
        {
            struLoginInfo.sPassword[i] = byPwd[i];
        }

        String strLocal = LocalNodeName.getText().toString();
        String DeviceInfo = strIP + " - " + strLocal;

        HCNetSDK.NET_DVR_DEVICEINFO_V40 struDeviceInfoV40=new HCNetSDK.NET_DVR_DEVICEINFO_V40();
        struDeviceInfoV40.struDeviceV30=new HCNetSDK.NET_DVR_DEVICEINFO_V30();

        NativeLong lUserID = new NativeLong(HCNetSDK.HikInstance.NET_DVR_Login_V40(struLoginInfo,struDeviceInfoV40));

        if(lUserID.longValue()<0){
            System.out.println("Login Failed. Error Code: "+HCNetSDK.HikInstance.NET_DVR_GetLastError());
            AddLog.PrintToTable(HCNetSDK.HikInstance.NET_DVR_GetLastError(),"FAIL", "NET_DVR_Login_V40", DeviceInfo);
            return;
        }
        else{
            System.out.println("Login Succeed.");
            AddLog.PrintToTable(HCNetSDK.HikInstance.NET_DVR_GetLastError(),"SUCC", "NET_DVR_Login_V40", DeviceInfo);
        }

        boolean bGetAbilityRet = HCNetSDK.HikInstance.NET_DVR_GetDeviceAbility(lUserID,HCNetSDK.ACS_ABILITY,);

        int dwDoorReturnLen = 0;
        int dwCardReaderReturnLen = 0;

        HCNetSDK.NET_DVR_DOOR_CFG struDoorCfg = new HCNetSDK.NET_DVR_DOOR_CFG();

        boolean bDoorRet1 = HCNetSDK.HikInstance.NET_DVR_GetDVRConfig(lUserID, HCNetSDK.NET_DVR_GET_DOOR_CFG,
                new NativeLong(1),struDoorCfg.getPointer(), struDoorCfg.size(),new IntByReference(dwDoorReturnLen).getPointer());
        System.out.println("Status Read Door Param:" + bDoorRet1);

        if(!bDoorRet1){
            System.out.println("Failed to get Door Param, Error Code："+HCNetSDK.HikInstance.NET_DVR_GetLastError());
            AddLog.PrintToTable(HCNetSDK.HikInstance.NET_DVR_GetLastError(),"FAIL", "NET_DVR_GET_DOOR_CFG", DeviceInfo);
            HCNetSDK.HikInstance.NET_DVR_Logout(lUserID);
            HCNetSDK.HikInstance.NET_DVR_Cleanup();
            return;
        }
        AddLog.PrintToTable(HCNetSDK.HikInstance.NET_DVR_GetLastError(),"SUCC", "NET_DVR_GET_DOOR_CFG", DeviceInfo);
        //String m_csDoorName="East Door";
        HCNetSDK.NET_DVR_CARD_READER_CFG_V50 struCardReaderCfg = new HCNetSDK.NET_DVR_CARD_READER_CFG_V50();

        boolean bReaderRet1 = HCNetSDK.HikInstance.NET_DVR_GetDVRConfig(lUserID, HCNetSDK.NET_DVR_GET_CARD_READER_CFG_V50,
                new NativeLong(1),struCardReaderCfg.getPointer(),struCardReaderCfg.size(), new IntByReference(dwCardReaderReturnLen).getPointer());
        System.out.println("Status Read Card Reader Param:" + bReaderRet1);

        if(!bReaderRet1){
            System.out.println("Failde to get Card Reader Param, Error Code: "+HCNetSDK.HikInstance.NET_DVR_GetLastError());
            AddLog.PrintToTable(HCNetSDK.HikInstance.NET_DVR_GetLastError(),"FAIL", "NET_DVR_GET_CARD_READER_CFG_V50", DeviceInfo);
            HCNetSDK.HikInstance.NET_DVR_Logout(lUserID);
            HCNetSDK.HikInstance.NET_DVR_Cleanup();
            return;
        }
        AddLog.PrintToTable(HCNetSDK.HikInstance.NET_DVR_GetLastError(),"SUCC", "NET_DVR_GET_CARD_READER_CFG_V50", DeviceInfo);
        //System.out.println(struCardReaderCfg.byMaxReadCardFailNum);

        DefaultMutableTreeNode DoorNode = new DefaultMutableTreeNode("Door1");
        DefaultMutableTreeNode CardReader1Node = new DefaultMutableTreeNode("Card Reader1");
        DefaultMutableTreeNode CardReader2Node = new DefaultMutableTreeNode("Card Reader2");
        DoorNode.add(CardReader1Node);
        DoorNode.add(CardReader2Node);

        HCNetSDK.HikInstance.NET_DVR_Logout(lUserID);
        HCNetSDK.HikInstance.NET_DVR_Cleanup();
    }

    private void onCancelButton() {
        dispose();
    }

    public AddDeviceToTree(JFrame frame) {
        super(frame,"Add Device",true);
        this.setContentPane(new AddDeviceToTree().contentPane);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(500,250);
        this.setResizable(false);
        setLocationRelativeTo(frame);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddDeviceToTree");
        frame.setContentPane(new AddDeviceToTree().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        contentPane = new JPanel();
        AddButton = new JButton();
        CancelButton = new JButton();
        aysnLoginCheckBox = new JCheckBox();
        LocalNodeName = new JTextField();
        DeviceUserName = new JTextField();
        DeviceIPAddr = new JTextField();
        DefaultPort = new JTextField();
        DevicePwd = new JPasswordField();
    }
}
