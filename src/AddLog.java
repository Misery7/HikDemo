
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yushun on 2017/7/17.
 */
public class AddLog {
    private static DefaultTableModel LogTableModel;

    public static void TableInit(DefaultTableModel Target){
        LogTableModel = Target;
    }

    public static void PrintToTable(int ErrorNo,String Status,String Operation, String DeviceInfo){
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String LogTime = frmt.format(new Date().getTime());
        String ErrorMsg = HCNetSDK.HikInstance.NET_DVR_GetErrorMsg(new IntByReference(ErrorNo).getPointer());
        if(ErrorNo == 0) ErrorMsg = "";
        String []OpStatus={LogTime, Status, Operation, DeviceInfo, ErrorMsg};
        LogTableModel.addRow(OpStatus);
    }

    public static void main(String[] args){
    }
}
