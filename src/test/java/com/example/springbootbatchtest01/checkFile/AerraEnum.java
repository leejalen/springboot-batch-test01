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
public enum AerraEnum {
    RRA_01(1, 3, 0, "差错交易标志"),
    RRA_02(2, 11, 0, "代理机构标识码"),
    RRA_03(3, 11, 0, "发送机构标识码"),
    RRA_04(4, 6, 0, "系统跟踪号"),
    RRA_05(5, 10, 0, "交易传输时间"),
    RRA_06(6, 19, 0, "主账号"),
    RRA_07(7, 12, 0, "交易金额（注：如果是调单回复E05，则为差错费用）"),
    RRA_08(8, 4, 0, "报文类型"),
    RRA_09(9, 6, 0, "交易类型码"),
    RRA_10(10, 4, 0, "商户类型"),
    RRA_11(11, 8, 0, "受卡机终端标识码"),
    RRA_12(12, 12, 0, "上一笔交易检索参考号"),
    RRA_13(13, 2, 0, "服务点条件码"),
    RRA_14(14, 6, 0, "授权应答码"),
    RRA_15(15, 11, 0, "接收机构标识码"),
    RRA_16(16, 11, 0, "发卡银行标识码"),
    RRA_17(17, 6, 0, "上一笔交易的系统跟踪号"),
    RRA_18(18, 2, 0, "交易返回码"),
    RRA_19(19, 3, 0, "服务点输入方式"),
    RRA_20(20, 12, 0, "受理方应收交换费"),
    RRA_21(21, 12, 0, "受理方应付交换费"),
    RRA_22(22, 12, 0, "分期付款附加手续费"),
    RRA_23(23, 12, 0, "转接清算费"),
    RRA_24(24, 12, 0, "应收费用(由于发生了该笔差错交易而收取的费用)"),
    RRA_25(25, 12, 0, "应付费用(由于发生了该笔差错交易而支付的费用，包含给银联的费用。)"),
    RRA_26(26, 4, 0, "差错原因"),
    RRA_27(27, 11, 0, "接收机构标识码/转出机构标识码"),
    RRA_28(28, 19, 0, "转出卡号"),
    RRA_29(29, 11, 0, "转入机构标识码"),
    RRA_30(30, 19, 0, "转入卡号"),
    RRA_31(31, 10, 0, "上一笔交易的日期时间"),
    RRA_32(32, 3, 0, "卡片序列号"),
    RRA_33(33, 1, 0, "终端读取能力"),
    RRA_34(34, 1, 0, "IC卡条件代码"),
    RRA_35(35, 4, 0, "上一笔交易清算日期"),
    RRA_36(36, 12, 0, "上一笔交易金额"),
    RRA_37(37, 1, 0, "交易地域标志"),
    RRA_38(38, 2, 0, "ECI标志"),
    RRA_39(39, 15, 0, "商户代码"),
    RRA_40(40, 11, 0, "发送方清算机构"),
    RRA_41(41, 11, 0, "接收方清算机构/转出方清算机构"),
    RRA_42(42, 11, 0, "转入方清算机构"),
    RRA_43(43, 2, 0, "上一笔交易终端类型"),
    RRA_44(44, 40, 0, "商户名称地址"),
    RRA_45(45, 2, 0, "特殊计费类型"),
    RRA_46(46, 1, 0, "特殊计费档次"),
    RRA_47(47, 8, 0, "保留使用"),
    RRA_48(48, 24, 0, "卡产品标识信息"),
    RRA_49(49, 3, 0, "引发差错交易的最原始交易的交易代码"),
    RRA_50(50, 1, 0, "交易发起方式"),
    RRA_51(51, 2, 0, "账户结算类型"),
    RRA_52(52, 40, 0, "订单号"),
    RRA_53(53, 2, 0, "保留使用"),
    RRA_54(54, 2, 0, "保留使用"),
    RRA_55(55, 4, 0, "原始交易类型"),
    RRA_56(56, 8, 0, "商户手续费"),
    RRA_57(57, 12, 0, "商户结算行"),
    RRA_58(58, 8, 0, "商户结算行费用"),
    RRA_59(59, 12, 0, "收单方服务方角色1"),
    RRA_60(60, 8, 0, "收单方服务方角色1费用"),
    RRA_61(61, 12, 0, "收单方服务方角色2"),
    RRA_62(62, 8, 0, "收单方服务方角色2费用"),
    RRA_63(63, 12, 0, "收单方服务方角色3"),
    RRA_64(64, 8, 0, "收单方服务方角色3费用"),
    RRA_65(65, 12, 0, "收单方服务方角色4"),
    RRA_66(66, 8, 0, "收单方服务方角色4费用"),
    RRA_67(67, 12, 0, "收单方服务方角色5"),
    RRA_68(68, 8, 0, "收单方服务方角色5费用"),
    RRA_69(69, 12, 0, "收单方服务方角色6"),
    RRA_70(70, 8, 0, "收单方服务方角色6费用"),
    RRA_71(71, 12, 0, "收单方服务方角色7"),
    RRA_72(72, 8, 0, "收单方服务方角色7费用"),
    RRA_73(73, 12, 0, "收单方服务方角色8"),
    RRA_74(74, 8, 0, "收单方服务方角色8费用"),
    RRA_75(75, 12, 0, "收单方服务方角色9"),
    RRA_76(76, 9, 0, "收单方服务方角色9费用"),
    RRA_77(77, 9, 0, "银联代理清算收单机构自定义费用1"),
    RRA_78(78, 9, 0, "银联待清算收单机构自定义费用2"),
    RRA_79(79, 9, 0, "银联待清算收单机构自定义费用3"),
    RRA_80(80, 11, 0, "分期付款附加手续费（收单收益）"),
    RRA_81(81, 187, 0, "保留使用"),
    ;

    public static Map<Integer, List<Object>> getAerraMap(){
        Map<Integer, List<Object>> map = new HashMap<>();
        for (AerraEnum aerraEnum : values()){
            List<Object> list = new ArrayList<>();
            list.add(aerraEnum.getStart());
            list.add(aerraEnum.getLength());
            list.add(aerraEnum.getRemark());
            map.put(aerraEnum.getCode(), list);
        }
        int start = 0;
        for (int i = 0; i < map.size(); i++) {
            List<Object> list = map.get(i + 1);
            list.set(0, start);

            int thisFieldLength = (Integer) list.get(1);
            start = start + thisFieldLength + 1;
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

    AerraEnum(Integer code, Integer length, Integer start, String remark) {
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

    public void setStart(Integer start) {
        this.start = start;
    }
}
