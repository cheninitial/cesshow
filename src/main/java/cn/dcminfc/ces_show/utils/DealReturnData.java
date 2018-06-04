package cn.dcminfc.ces_show.utils;

import com.iot.util.ReturnData;

public class DealReturnData {
    public static ReturnData result(Result result) {
        ReturnData returnData = new ReturnData();
        returnData.setMsgCode(result.getCode());
        returnData.setMsg(result.getMsg());
        return returnData;
    }
}
