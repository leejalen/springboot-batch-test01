package com.example.springbootbatchtest01.checkFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/21
 * @Description
 */
public enum FcpEnum {

    FCP_01(1, 3, 0, "交易代码"),
    FCP_02(2, 11, 0, "交易金额"),
    FCP_03(3, 4, 0, "原因码"),
    FCP_04(4, 11, 0, "发起方一级机构"),
    FCP_05(5, 11, 0, "发起方二级机构"),
    FCP_06(6, 11, 0, "接收方一级机构"),
    FCP_07(7, 11, 0, "接收方二级机构"),
    FCP_08(8, 10, 0, "交易日期时间"),
    FCP_09(9, 6, 0, "系统跟踪号"),
    FCP_10(10, 19, 0, "主账号"),
    FCP_11(11, 100, 0, "收付费附言"),
    FCP_12(12, 99, 0, "保留使用"),
    ;

    public static Map<Integer, List<Object>> getFcpMap(){
        Map<Integer, List<Object>> map = new HashMap<>();
        for (FcpEnum fcpEnum : values()){
            List<Object> list = new ArrayList<>();
            list.add(fcpEnum.getStart());
            list.add(fcpEnum.getLength());
            list.add(fcpEnum.getRemark());
            map.put(fcpEnum.getCode(), list);
        }
        int start = 0;
        for (int i = 0; i < map.size(); i++) {
            List<Object> list = map.get(i + 1);
            list.set(0, start);
            int fieldLength = (Integer) list.get(1);
            start = start + fieldLength + 1;
        }
        return map;
    }
    /**
     * 序号
     * */
    private Integer code;

    /**
     * 字段长度
     * */
    private Integer length;

    /**
     * 起始位置
     * */
    private Integer start;

    /**
     * 备注
     * */
    private String remark;

    FcpEnum(Integer code, Integer length, Integer start, String remark) {
        this.code = code;
        this.length = length;
        this.start = start;
        this.remark = remark;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getStart() {
        return start;
    }

    public String getRemark() {
        return remark;
    }
}
