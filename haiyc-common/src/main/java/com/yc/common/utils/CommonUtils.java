package com.yc.common.utils;

import com.yc.common.constant.Constant;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 通用工具类<br>
 * 〈功能详细描述〉
 *
 * @author 村子里最好的剑
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommonUtils extends BeanUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    private static final Pattern CDATA_CONTENT_PATTERN = Pattern.compile("\\<\\!\\[CDATA\\[(?<text>.*)\\]\\]\\>");

    //    private static final String MOBILE_REG = "^((1[358][0-9])|(147)|(17[0135678]))\\d{8}$";
    private static final String MOBILE_REG = "^1\\d{10}$";

    private static final String MOBILE_PASSWORD_REG = "([a-z0-9A-Z]{4,12})";

    static {
        // 添加日期转换注册器
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlDateConverter(null), Date.class);
        ConvertUtils.register(new SqlTimestampConverter(null),
                java.sql.Timestamp.class);
    }

    private CommonUtils() {

    }

    public static Date etagToDate(String etag) {
        if (etag == null) {
            return null;
        }
        long timestamp = NumberUtils.toLong(etag);
        return timestamp == 0L ? null : new Date(timestamp);
    }

    public static String dateToEtag(Date date) {
        return String.valueOf(date.getTime());
    }

    public static Long etagToLong(String etag) {
        if (etag == null) {
            return null;
        }
        try {
            return Long.parseLong(etag);
        } catch (NumberFormatException nfe) {
            LOGGER.error("数字转换失败", nfe);
            return null;
        }
    }

    public static <Z> Z transform(Object source, Class<Z> tClass) {
        if (source == null) {
            return null;
        }
        try {
            Z target = tClass.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception ex) {
            LOGGER.error("transform error.", ex);
            return null;
        }
    }

    public static <Z, T> List<Z> transformList(Collection<T> sources, Class<Z> tClass) {
        try {
            List<Z> result = new ArrayList<Z>();
            if (sources == null) {
                return result;
            }
            for (T source : sources) {
                if (source == null) {
                    continue;
                }
                Z target = tClass.newInstance();
                BeanUtils.copyProperties(source, target);
                result.add(target);
            }
            return result;
        } catch (Exception ex) {
            LOGGER.error("transformList error.", ex);
            return Collections.emptyList();
        }
    }

    /**
     * 获取指定多少天前的日期（凌晨）
     *
     * @param day day
     * @return time in mill
     */
    public static long getDayAgoInMill(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 功能描述: 分割List,此方法更高效<br>
     * 〈功能详细描述〉
     *
     * @param list 待分割的list
     * @param splitSize 每段list的大小
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> List<List<T>> splitList(List<T> list, int splitSize) {
        int listSize = list.size(); // list的大小
        List<List<T>> listArray = new ArrayList<List<T>>();// 创建list数组,用来保存分割后的list
        int page = (listSize + (splitSize - 1)) / splitSize;// 分成多少个子集
        for (int i = 0; i < page; i++) {
            // 如果是最后一页则做收尾处理
            listArray.add(list.subList(i * splitSize, i == page - 1 ? listSize : (i + 1) * splitSize));
        }
        return listArray;
    }

    /**
     * 功能描述: 取<![CDATA[内容 ]]>中的内容 <br>
     * 〈功能详细描述〉
     *
     * @param content
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getContent(String content) {
        Matcher m = CDATA_CONTENT_PATTERN.matcher(content);
        if (m.matches()) {
            return m.group(1);
        }
        return content;
    }

    /**
     * 根据字符串转换成数字
     *
     * @param typeIds 频道类型id字符串
     * @return Long
     */
    public static List<Integer> buildStrToLongList(String typeIds) {
        List<Integer> typeIdList = new ArrayList<Integer>();
        if (StringUtils.isNotBlank(typeIds)) {
            String[] list = typeIds.split(",");
            for (String s : list) {
                if (StringUtils.isNotBlank(s)) {
                    typeIdList.add(Integer.valueOf(s));
                }
            }
        }
        return typeIdList;
    }

    /**
     * 字段转换成对象属性 例如：user_name to userName
     *
     * @param field
     * @return
     */
    public static String fieldToProperty(String field) {
        if (null == field) {
            return null;
        }
        char[] chars = field.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
                    i++;// NOSONAR
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述: 去掉多余的0<br>
     * 〈功能详细描述〉
     *
     * @param number
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getPrettyNumber(String number) {
        return BigDecimal.valueOf(Double.parseDouble(number)).stripTrailingZeros().toPlainString();
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param percent
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Float percentToDecimal(String percent) {
        try {
            return Float.valueOf(percent.replaceAll("%", "")) / Constant.NUM_100;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param str1
     * @param str2
     * @param append
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String builderStr(String str1, String str2, char append) {
        if (str1 == null) {
            str1 = StringUtils.EMPTY;
        }
        if (str2 == null) {
            str2 = StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(str1).append(append).append(str2).toString();
    }

    /**
     * 校验是否手机(标准格式:13719352010)
     *
     * @param str
     * @return boolean
     */
    public static boolean isMobile(String str) {
        return Pattern.compile(MOBILE_REG).matcher(str).matches();
    }

    /**
     * 校验是否是手机服务密码(服务密码为4到12位的字母或数字)
     *
     * @param str
     * @return boolean
     */
    public static boolean isMobilePassword(String str) {
        return Pattern.compile(MOBILE_PASSWORD_REG).matcher(str).matches();
    }

    /**
     * 判断是否含有emoji表情
     *
     * @param source
     * @return 存在 true 不存在 false
     */
    public static boolean filterEmoji(String source) {
        if (StringUtils.isEmpty(source)) {
            return false;
        } else {
            Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                    Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将emoji表情替换成*
     *
     * @param source
     * @return 过滤后的字符串
     */
    public static String repaceEmoji(String source) {
        if (!StringUtils.isEmpty(source)) {
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
        } else {
            return source;
        }
    }

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumberAndInteger(String str) {
        Pattern pattern = Pattern.compile("^\\d+$|^\\d+\\.\\d+$|-\\d+$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     *
     * 功能描述: 校验密码是否位6-16位的英文字母或数字<br>
     * 〈功能详细描述〉
     *
     * @param str
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static boolean validPwd(String str) {
        return Pattern.compile("^[A-Za-z0-9]{6,16}$").matcher(str).matches();
    }

    /**
     * 校验是否是正确的固定电话格式
     */
    public static boolean isTelephoneBak(String str) {
        String pattern = "^[0][1-9]{2,3}-[0-9]{5,10}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }



    /**
     * 取出list中重复的值
     * @param stream
     * @return
     */
    public static <T> List<T> getDuplicateElements(Stream<T> stream) {
        return stream.collect(Collectors.groupingBy(p -> p,Collectors.counting())).entrySet().stream() // Set<Entry>转换为Stream<Entry>
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());
    }

    /**
     * 判断字符串是否为数字类型
     */
    public static boolean isInteger(String str){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * hashMap 容量初始化 initialCapacity = (需要存储的元素个数 / 负载因子) + 1
     */
    public static int initialCapacity(int size){
        return (int) ((size / 0.75) + 1);
    }
}
