package com.example.springbootbatchtest01.checkFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/19
 * @Description
 */
public enum AlfeeEnum {

    FEE_01(1, 11, 0, "受理方一级分行代码"),
    FEE_02(2, 1, 12, "是否银联标准卡"),
    FEE_03(3, 2, 14, "借贷记卡标志"),
    FEE_04(4, 2, 17, "终端类型"),
    FEE_05(5, 1, 20, "卡介质"),
    FEE_06(6, 1, 22, "交易地域标志"),
    FEE_07(7, 4, 24, "商户类型"),
    FEE_08(8, 11, 29, "受理方二级分行代码"),
    FEE_09(9, 11, 41, "受理机构代码"),
    FEE_10(10, 11, 53, "转发机构代码"),
    FEE_11(11, 11, 65, "发卡机构代码"),
    FEE_12(12, 11, 77, "接收机构代码"),
    FEE_13(13, 11, 89, "收单机构代码"),
    FEE_14(14, 4, 101, "报文类型"),
    FEE_15(15, 6, 106, "交易处理码"),
    FEE_16(16, 2, 113, "服务点条件码"),
    FEE_17(17, 6, 116, "系统跟踪号"),
    FEE_18(18, 10, 123, "交易传输日期时间"),
    FEE_19(19, 19, 134, "主账号"),
    FEE_20(20, 28, 154, "转出卡"),
    FEE_21(21, 28, 183, "转入卡"),
    FEE_22(22, 42, 212, "原始交易信息"),
    FEE_23(23, 8, 255, "受卡方终端标识码"),
    FEE_24(24, 15, 264, "受卡方标识码（注：银联商户号）"),
    FEE_25(25, 12, 280, "检索参考号"),
    FEE_26(26, 12, 293, "交易金额"),
    FEE_27(27, 12, 306, "保留使用"),
    FEE_28(28, 12, 319, "品牌服务费"),
    FEE_29(29, 12, 332, "保留使用"),
    FEE_30(30, 13, 345, "保留使用"),
    FEE_31(31, 1, 359, "交易发起方式"),
    FEE_32(32, 99, 361, "保留使用"),
    ;

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

    AlfeeEnum(Integer code, Integer length, Integer start, String remark) {
        this.code = code;
        this.length = length;
        this.start = start;
        this.remark = remark;
    }

    public static Map<Integer, List<Object>> getAlfeeMap(){
        Map<Integer, List<Object>> map = new HashMap<>();
        for (AlfeeEnum alfeeEnum : values()){
            List<Object> list = new ArrayList<>();
            list.add(alfeeEnum.getStart());
            list.add(alfeeEnum.getLength());
            list.add(alfeeEnum.getRemark());
            map.put(alfeeEnum.getCode(), list);
        }
        return map;
    }

    public static Map<Integer, String> getRemarkMap(){
        Map<Integer, String> map = new HashMap<>();
        for (AlfeeEnum alfeeEnum : values()){
            map.put(alfeeEnum.getCode(), alfeeEnum.getRemark());
        }
        return map;
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
