package leetcode;


import java.util.ArrayList;
import java.util.List;

/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
/**
 * 解题思路：
 * 1 注意. 需要转移
 * 2 注意atoi 的写法
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        List<Double> v1List = convert(version1);
        List<Double> v2List = convert(version2);
        for (int i = 0; i < Math.max(v1List.size(), v2List.size()) ; i ++) {
            Double v1Cur = i < v1List.size()  ? v1List.get(i) : 0.0;
            Double v2Cur = i < v2List.size()  ? v2List.get(i) : 0.0;
            if (v1Cur > v2Cur) return 1;
            if (v1Cur < v2Cur) return -1;
        }
        return 0;
    }

    public List<Double> convert(String version) {
        List<Double> result = new ArrayList<>();
        if (version != null && version.length() > 0) {
            String[] data = version.split("\\.");
            for (String item : data) {
                result.add(convertStr(item));
            }
        }
        return result;
    }

    public Double convertStr(String item) {
        Double result = 0.0;
        if (item != null && item.length() > 0) {
            item = item.trim();
            for (int i = 0; i < item.length(); i++) {
                result = result * 10 + (item.charAt(i) - '0');
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CompareVersionNumbers sample = new CompareVersionNumbers();
        System.out.println(sample.compareVersion("1", "0"));
    }
}
