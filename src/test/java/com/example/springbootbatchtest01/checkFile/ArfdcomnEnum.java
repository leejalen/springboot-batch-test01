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
public enum ArfdcomnEnum {
    ARF_01(1, 11, 0, "代理机构标识码"),
    ARF_02(2, 11, 0, "发送机构标识码"),
    ARF_03(3, 6, 0, "系统跟踪号"),
    ARF_04(4, 10, 0, "交易传输时间"),
    ARF_05(5, 19, 0, "主账号"),
    ARF_06(6, 12, 0, "交易金额"),
    ARF_07(7, 12, 0, "部分代收时的承兑金额"),
    ARF_08(8, 11, 0, "持卡人交易手续费"),
    ARF_09(9, 4, 0, "报文类型"),
    ARF_10(10, 6, 0, "交易类型码"),
    ARF_11(11, 4, 0, "商户类型"),
    ARF_12(12, 8, 0, "受卡机终端标识码"),
    ARF_13(13, 15, 0, "受卡方标识码(银联商户号)"),
    ARF_14(14, 12, 0, "检索参考号"),
    ARF_15(15, 2, 0, "服务点条件码"),
    ARF_16(16, 6, 0, "授权应答码"),
    ARF_17(17, 11, 0, "接收机构标识码"),
    ARF_18(18, 6, 0, "原始交易的系统跟踪号"),
    ARF_19(19, 2, 0, "交易返回码"),
    ARF_20(20, 3, 0, "服务点输入方式"),
    ARF_21(21, 12, 0, "受理方应收交换费（发卡方应收交换费）"),
    ARF_22(22, 12, 0, "受理方应付交换费（发卡方应付交换费）"),
    ARF_23(23, 11, 0, "转接清算费"),
    ARF_24(24, 1, 0, "单双转换标志"),
    ARF_25(25, 3, 0, "卡片序列号"),
    ARF_26(26, 1, 0, "终端读取能力"),
    ARF_27(27, 1, 0, "IC 卡条件代码"),
    ARF_28(28, 10, 0, "原始交易日期时间"),
    ARF_29(29, 11, 0, "发卡机构标识码"),
    ARF_30(30, 1, 0, "交易地域标志"),
    ARF_31(31, 2, 0, "终端类型"),
    ARF_32(32, 2, 0, "ECI 标志"),
    ARF_33(33, 11, 0, "分期付款附加手续费"),
    ARF_34(34, 14, 0, "其他信息"),
    ARF_35(35, 19, 0, "转入卡卡号"),
    ARF_36(36, 2, 0, "分期付款期数"),
    ARF_37(37, 40, 0, "订单号"),
    ARF_38(38, 4, 0, "支付方式"),
    ARF_39(39, 2, 0, "保留使用"),
    ARF_40(40, 1, 0, "保留使用"),
    ARF_41(41, 19, 0, "保留使用"),
    ARF_42(42, 10, 0, "保留使用"),
    ARF_43(43, 6, 0, "保留使用"),
    ARF_44(44, 1, 0, "保留使用"),
    ARF_45(45, 40, 0, "保留使用"),
    ARF_46(46, 1, 0, "账户等级"),
    ARF_47(47, 1, 0, "是否柜面核身"),
    ARF_48(48, 1, 0, "保留使用"),
    ARF_49(49, 39, 0, "保留使用"),
    ;

    public static Map<Integer, List<Object>> getArfdcomnMap(){
        Map<Integer, List<Object>> map = new HashMap<>();
        for (ArfdcomnEnum arfdcomnEnum : values()){
            List<Object> list = new ArrayList<>();
            list.add(arfdcomnEnum.getStart());
            list.add(arfdcomnEnum.getLength());
            list.add(arfdcomnEnum.getRemark());
            map.put(arfdcomnEnum.getCode(), list);
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

    ArfdcomnEnum(Integer code, Integer length, Integer start, String remark) {
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
