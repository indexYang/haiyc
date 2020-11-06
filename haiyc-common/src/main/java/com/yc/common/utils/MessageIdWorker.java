package com.yc.common.utils;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * 〈java生成唯一索引,Long型,区别uuid〉<br>
 * 〈功能详细描述〉
 *
 * @author 村子里最好的剑
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MessageIdWorker {
    // 饿汉式单例
    private static MessageIdWorker instance = new MessageIdWorker();

    // 机器标识
    private static long workerId = new Random(System.currentTimeMillis()).nextInt(31);
    // 数据中心标识
    private static long datacenterId = new Random(System.currentTimeMillis() + RandomUtils.nextLong(0, 99999)).nextInt(31);
    // 毫秒内自增数
    private long sequence = 0L;
    // 2010-11-04 09:42:54转换的毫秒数
    private long twepoch = 1288834974657L;
    // 机器标识位数
    private long workerIdBits = 5L;
    // 数据中心标识位数
    private long datacenterIdBits = 5L;
    // 机器标识最大值
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 数据中心标识最大值
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 毫秒内自增位数
    private long sequenceBits = 12L;
    // 机器标识左移12位
    private long workerIdShift = sequenceBits;
    // 数据中心标识左移17位
    private long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间(毫秒)左移22位
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    // 毫秒内自增数掩码
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    // 私有构造方法
    private MessageIdWorker() {

        // 检查机器标识和数据中心标识
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
    }

    /**
     * 获取单例实例
     *
     * @return IdWorker实例
     */
    public static MessageIdWorker getInstance() {
        return instance;
    }

    public static void main(String[] param) {
        int a = new Random(System.currentTimeMillis()).nextInt(31);
        int b = new Random(System.currentTimeMillis() + RandomUtils.nextLong(0, 99999)).nextInt(31);
    }

    /**
     * 获取全局id
     *
     * @return 全局id
     */
    public synchronized long nextId() {
        // 取当前系统时间戳
        long timestamp = timeGen();
        // 如果当前时间戳小于记录时间戳, 说明时间回退(可能进行了时间校准), 这段时间内不能生成全局id
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        // 毫秒内
        if (lastTimestamp == timestamp) {
            // 自增数加一
            sequence = (sequence + 1) & sequenceMask;
            // 如果自增数等于0, 说明自增数溢出(超过了4095), 等到下1毫秒
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift) | sequence;
    }

    /**
     * 等待, 直到下1毫秒
     *
     * @param lastTimestamp 记录的时间戳
     * @return 系统当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 取系统当前时间毫秒数
     *
     * @return 系统当前时间毫秒数
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
