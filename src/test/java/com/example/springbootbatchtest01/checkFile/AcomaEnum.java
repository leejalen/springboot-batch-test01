package com.example.springbootbatchtest01.checkFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/18
 * @Description
 */
public enum AcomaEnum {

    COM_01(1, 11, 0, "代理机构标识码"),
    COM_02(2, 11, 12, "发送机构标识码"),
    COM_03(3, 6, 24, "系统跟踪号"),
    COM_04(4, 10, 31, "交易传输时间"),
    COM_05(5, 19, 42, "主账号"),
    COM_06(6, 12, 62, "交易金额"),
    COM_07(7, 13, 75, "部分代收时的承兑金额"),
    COM_08(8, 11, 89, "持卡人交易手续费"),
    COM_09(9, 4, 101, "报文类型"),
    COM_10(10, 6, 106, "交易类型码"),
    COM_11(11, 4, 113, "商户类型"),
    COM_12(12, 8, 118, "受卡机终端标识码"),
    COM_13(13, 15, 127, "受卡方标识码(银联商户号)"),
    COM_14(14, 12, 143, "检索参考号"),
    COM_15(15, 2, 156, "服务点条件码"),
    COM_16(16, 6, 159, "授权应答码"),
    COM_17(17, 11, 166, "接收机构标识码"),
    COM_18(18, 6, 178, "原始交易的系统跟踪号"),
    COM_19(19, 2, 185, "交易返回码"),
    COM_20(20, 3, 188, "服务点输入方式"),
    COM_21(21, 12, 192, "受理方应收交换费"),
    COM_22(22, 12, 205, "受理方应付交换费"),
    COM_23(23, 12, 218, "转接清算费"),
    COM_24(24, 1, 231, "单双转换标志"),
    COM_25(25, 3, 233, "卡片序列号"),
    COM_26(26, 1, 237, "终端读取能力"),
    COM_27(27, 1, 239, "IC 卡条件代码"),
    COM_28(28, 10, 241, "原始交易日期时间"),
    COM_29(29, 11, 252, "发卡机构标识码"),
    COM_30(30, 1, 264, "交易地域标志"),
    COM_31(31, 2, 266, "终端类型"),
    COM_32(32, 3, 269, "ECI 标志"),
    COM_33(33, 12, 273, "分期付款附加手续费"),
    COM_34(34, 13, 286, "其他信息"),
    COM_35(35, 11, 300, "发送方清算机构"),
    COM_36(36, 11, 312, "接收方清算机构"),
    COM_37(37, 1, 324, "冲正标志"),
    COM_38(38, 1, 326, "撤销标志"),
    COM_39(39, 4, 328, "清算日期"),
    COM_40(40, 2, 333, "清算场次"),
    COM_41(41, 40, 336, "商户名称地址"),
    COM_42(42, 4, 377, "交易币种"),
    COM_43(43, 8, 382, "银联代理清算收单机构自动折扣手续费(注：应该是银联代机构向商户清算)"),
    COM_44(44, 9, 391, "商户手续费"),
    COM_45(45, 12, 401, "商户结算行"),
    COM_46(46, 8, 414, "商户结算行费用"),
    COM_47(47, 12, 423, "收单方服务方角色1"),
    COM_48(48, 8, 436, "收单方服务方角色1费用"),
    COM_49(49, 12, 445, "收单方服务方角色2"),
    COM_50(50, 8, 458, "收单方服务方角色2费用"),
    COM_51(51, 12, 467, "收单方服务方角色3"),
    COM_52(52, 8, 480, "收单方服务方角色3费用"),
    COM_53(53, 12, 489, "收单方服务方角色4"),
    COM_54(54, 8, 502, "收单方服务方角色4费用"),
    COM_55(55, 12, 511, "收单方服务方角色5"),
    COM_56(56, 8, 524, "收单方服务方角色5费用"),
    COM_57(57, 12, 533, "收单方服务方角色6"),
    COM_58(58, 8, 546, "收单方服务方角色6费用"),
    COM_59(59, 12, 555, "收单方服务方角色7"),
    COM_60(60, 8, 568, "收单方服务方角色7费用"),
    COM_61(61, 12, 577, "收单方服务方角色8"),
    COM_62(62, 8, 590, "收单方服务方角色8费用"),
    COM_63(63, 12, 599, "收单方服务方角色9"),
    COM_64(64, 9, 612, "收单方服务方角色9费用"),
    COM_65(65, 9, 622, "银联代理清算收单机构自定义费用1"),
    COM_66(66, 9, 632, "银联代理清算收单机构自定义费用 2"),
    COM_67(67, 8, 642, "银联代理清算收单机构自定义费用 3"),
    COM_68(68, 19, 651, "转入卡卡号"),
    COM_69(69, 2, 671, "分期付款期数"),
    COM_70(70, 40, 674, "订单号"),
    COM_71(71, 4, 715, "支付方式"),
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

    AcomaEnum(Integer code, Integer length, Integer start, String remark) {
        this.code = code;
        this.remark = remark;
        this.length = length;
        this.start = start;
    }

    public static Map<Integer, List<Object>> getAcomaMap(){
        Map<Integer, List<Object>> map = new HashMap<>();
        for (AcomaEnum acomaEnum : values()){
            List<Object> list = new ArrayList<>();
            list.add(acomaEnum.getStart());
            list.add(acomaEnum.getLength());
            list.add(acomaEnum.getRemark());
            map.put(acomaEnum.getCode(), list);
        }
        return map;
    }

    public static Map<Integer, String> getRemarkMap(){
        Map<Integer, String> map = new HashMap<>();
        for (AcomaEnum acomaEnum : values()){
            map.put(acomaEnum.getCode(), acomaEnum.getRemark());
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
