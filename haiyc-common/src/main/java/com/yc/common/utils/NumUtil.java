package com.yc.common.utils;
import com.yc.common.constant.Constant;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生成编号
 * 〈功能详细描述〉
 *
 * @author 村子里最好的剑
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NumUtil {

    private static final int P = 7;

    private static final int Q = 1428571409;

    private static final BigDecimal BP = new BigDecimal(P);

    private static final BigDecimal BQ = new BigDecimal(Q);
    // max : 9999999863
    private static final BigDecimal BN = BP.multiply(BQ);

    private static AtomicInteger counter = new AtomicInteger(0);

    private NumUtil() {

    }

    public static long hash(long input) {
        BigDecimal bin = new BigDecimal(input);
        BigDecimal pow = bin.pow(P);
        BigDecimal[] result = pow.divideAndRemainder(BN);
        return result[1].longValue();
    }

    /**
     * 功能描述:注意-集群环境中可能会出现重复值，请谨慎使用 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getAtomicCounter() {
        if (counter.get() > 999999) {
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        long returnValue = time * 100 + counter.incrementAndGet();
        return returnValue;
    }

    /**
     * 生成本地会员编号（ “type” + “10位转化结果” ）
     *
     * @param type 账号来源: 10：商户后台。
     * @return 本地12位会员编号
     */
    public static String trans(int type) {
        // long input = getAtomicCounter();
        long input = MessageIdWorker.getInstance().nextId();
        return trans(type, input);
    }

    /**
     * 生成本地会员编号（ “type” + “10位转化结果” ）
     *
     * @param type  账号来源: 10：商户后台
     * @param input 外部账号编号
     * @return 本地12位会员编号
     */
    public static String trans(int type, long input) {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(StringUtils.leftPad(String.valueOf(hash(input)), 10, '0'));
        return sb.toString();
    }

    /**
     * 功能描述: 生成申请记录表中no<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String genOrderId(String type) {
        long input = MessageIdWorker.getInstance().nextId();
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(DateUtil.parseDate(new Date())).append(StringUtils.leftPad(String.valueOf(hash(input)), 6, '0'));
        return sb.toString();
    }

    /**
     * 获取licenseNo
     *
     * @param productId
     * @param entId
     * @return
     */
    public static String genLicenseNo(Long productId, Long entId) {
        long input = MessageIdWorker.getInstance().nextId();
        StringBuilder sb = new StringBuilder();
        sb.append(productId).append(entId).append(DateUtil.parseDate(new Date())).append(StringUtils.leftPad(String.valueOf(hash(input)), 10, '0'));
        return sb.toString();
    }

    /**
     * 获取企业/员工编号
     *
     * @param type
     * @return
     */
    public static String getNo(String type) {
        long input = MessageIdWorker.getInstance().nextId();
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(DateUtil.parseDate(new Date())).append(StringUtils.leftPad(String.valueOf(hash(input)), 10, '0'));
        return sb.toString();
    }

    /**
     * 年月日+随机数
     */
    public static Long getPrimaryKey() {
        long input = MessageIdWorker.getInstance().nextId();
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.parseDate(new Date())).append(StringUtils.leftPad(String.valueOf(hash(input)), 10, '0'));
        return Long.valueOf(sb.toString());
    }

    /**
     * 年月日+随机数
     */
    public static String getPropertyCode() {
        long input = MessageIdWorker.getInstance().nextId();
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.parseDate(new Date())).append(StringUtils.leftPad(String.valueOf(hash(input)), Constant.NUM_8, '0'));
        return sb.toString();
    }




    public static void main(String[] orgs){
        for(int i = 0; i<100; i++){
            System.out.println(NumUtil.trans(Constant.NUM_2020));
        }

    }
}

