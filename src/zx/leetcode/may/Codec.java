package zx.leetcode.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 535. Encode and Decode TinyURL
 * @author Carl_Hugo
 * @date 2017年5月8日
 */
public class Codec {

	List urls = new ArrayList<String>();
	/**
	 * 一个长字符串和短字符串 之间建立一一对应的关系
	 * 其实就相当于字符和index之间的对应关系
	 * @param longUrl
	 * @return
	 */
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return String.valueOf(urls.get(index));
    }
}
