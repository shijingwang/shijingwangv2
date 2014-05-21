package com.sjw.v2.entity;

import java.util.Comparator;

/**
 * @Author Kulen
 * @CreateTime 2010-5-20上午10:50:05
 * @Version 1.0
 * @Explanation 商品销量数据的比较器
 */
public class ChannelPriorityComparator implements Comparator<Channel> {

	public int compare(Channel channel1, Channel channel2) {
		if (channel1.getPriority() > channel2.getPriority()) {
			return 1;
		} else if (channel1.getPriority() == channel2.getPriority()) {
			return 0;
		}
		return -1;
	}

}
