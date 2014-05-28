package com.sjw.v2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kulen.common.core.dao.ChannelDao;
import com.kulen.common.core.dao.WebsiteDao;
import com.kulen.common.core.entity.Channel;
import com.kulen.common.core.entity.Online;
import com.kulen.common.core.entity.Website;
import com.kulen.common.log.KulenLog;
import com.kulen.common.log.KulenLogFactory;
import com.kulen.core.inter.service.WebsiteServiceInter;
import com.kulen.core.inter.vo.WebChannel;
import com.kulen.core.inter.vo.WebPosition;

/**
 * @Author Kulen
 * @CreateTime 2010-6-14上午11:27:48
 * @Version 1.0
 * @Explanation
 */
public class WebsiteService {

	private WebsiteDao websiteDao;

	private ChannelDao channelDao;

	private CoreSequenceNumberService coreSequenceNumberService;

	private static final Map<String, Online> onlineMap = new HashMap<String, Online>();

	/**
	 * OnlineMap中的垃圾数据清理周期
	 */
	private static final long ONLINE_MAP_CLEAN_CYCLE = 1000L * 60L * 5L;

	private static Date lastCleanTime = new Date(System.currentTimeMillis() - ONLINE_MAP_CLEAN_CYCLE - 1000L);

	private static final KulenLog log = KulenLogFactory.getKulenLog(WebsiteService.class);

	// 服务器重启或者CleanMap的时候，会将相应的数据清理掉
	public void guestAccess(String guestId) {
		Online online = onlineMap.get(guestId);
		if (online == null) {
			online = new Online();
			online.setGuestId(guestId);
			online.setGuestLoginTime(new Date());
			online.setLastActionTime(new Date());
			onlineMap.put(online.getGuestId(), online);
		}
	}

	public void guestToCustomer(String guestId, String customerId) {
		Online online = onlineMap.get(guestId);
		online.setCustomerId(customerId);
		online.setCustomerLoginTime(new Date());
		online.setLastActionTime(new Date());
	}

	public void customerToGuest(String customerId, String guestId) {
		Online online = onlineMap.get(guestId);
		online.setCustomerId(null);
		online.setCustomerLoginTime(null);
		online.setLastActionTime(new Date());
	}

	public String newGuestAccess() {
		Online online = new Online();
		online.setGuestId(coreSequenceNumberService.getGuestId());
		online.setGuestLoginTime(new Date());
		online.setLastActionTime(new Date());
		onlineMap.put(online.getGuestId(), online);
		log.info("又有一个新游客访问网站，GuestId为：#0", online.getGuestId());
		return online.getGuestId();
	}

	/**
	 * 在线人数
	 * 
	 * @return
	 */
	public int onlinePersonNumber() {
		this.cleanOnlineMap();
		return onlineMap.size();
	}

	/**
	 * 在线会员数
	 * 
	 * @return
	 */
	public int onlineCustomerNumber() {
		this.cleanOnlineMap();
		int onlineCustomerNumber = 0;
		for (String key : onlineMap.keySet()) {
			Online online = onlineMap.get(key);
			if (online.getCustomerId() != null && online.getCustomerId().trim().length() > 0) {
				onlineCustomerNumber++;
			}
		}
		return onlineCustomerNumber;
	}

	/**
	 * 在线游客数
	 * 
	 * @return
	 */
	public int onlineGuestNumber() {
		this.cleanOnlineMap();
		int onlineGuestNumber = 0;
		for (String key : onlineMap.keySet()) {
			Online online = onlineMap.get(key);
			if (online.getCustomerId() == null || online.getCustomerId().trim().length() == 0) {
				onlineGuestNumber++;
			}
		}
		return onlineGuestNumber;
	}

	/**
	 * 清理过时的数据
	 */
	private void cleanOnlineMap() {
		if (System.currentTimeMillis() - lastCleanTime.getTime() <= ONLINE_MAP_CLEAN_CYCLE) {
			return;
		}
		lastCleanTime = new Date();
		List<String> deleteKeyList = new ArrayList<String>();
		for (String key : onlineMap.keySet()) {
			Online online = onlineMap.get(key);
			if (System.currentTimeMillis() - online.getLastActionTime().getTime() > Online.LIFE_TIMEOUT) {
				deleteKeyList.add(key);
			}
		}
		for (String key : deleteKeyList) {
			onlineMap.remove(key);
		}
	}

	// 会员注册地址
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getCustomerRegisterUrl() {
		return this.getHomePath() + "/healthy/customer.do?action=open";
	}

	// 会员登录地址
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getLoginUrl() {
		return this.getHomePath() + "/healthy/login.do?businessAction=open";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getLogoutUrl() {
		return this.getHomePath() + "/healthy/login.do?businessAction=logout";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getShoppingCartUrl() {
		return this.getHomePath() + "/shop/shoppingCart.do?action=viewList";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getWebsiteName() {
		Website website = websiteDao.findByWebsiteId(WebsiteServiceInter.WEBSITE_ID);
		return website.getName();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getBasePath() {
		return this.getHomePath() + "/healthy";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getBbsPath() {
		return this.getHomePath() + "/bbs";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getHealthyPath() {
		return this.getHomePath() + "/healthy";
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getShopPath() {
		return this.getHomePath() + "/shop";
	}

	// 返回域名
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getDomain() {
		Website website = websiteDao.findByWebsiteId(WebsiteServiceInter.WEBSITE_ID);
		return website.getDomain();
	}

	// 返回相应的端口号
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int getPort() {
		Website website = websiteDao.findByWebsiteId("");
		return website.getPort();
	}

	// 返回首页的相应目录
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String getHomePath() {
		Website website = websiteDao.findByWebsiteId(WebsiteServiceInter.WEBSITE_ID);
		StringBuffer sb = new StringBuffer();
		sb.append("http://");
		sb.append(website.getDomain());
		if (website.getPort() != 80) {
			sb.append(":" + website.getPort());
		}
		return sb.toString();
	}

	// 返回首页的相应位置
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public WebPosition getHomePage() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getHomePath());
		sb.append("/healthy/shijing.do");
		WebPosition webPosition = new WebPosition("首页", sb.toString());
		return webPosition;
	}

	// 返回收藏夹的相应图标
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public WebPosition getFavoriteIcon() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getHomePath());
		sb.append("/healthy/image/favoriteIcon.ico");
		WebPosition webPosition = new WebPosition("收藏夹图标", sb.toString());
		return webPosition;
	}

	// 返回网站的Logo图标
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public WebPosition getLogo() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getHomePath());
		sb.append("/healthy/image/common/logo.gif");
		WebPosition webPosition = new WebPosition("网站Logo图标", sb.toString());
		return webPosition;
	}

	// 返回当前网站的频道
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<WebChannel> getOneLevelChannel() {
		List<Channel> channelList = channelDao.findOneLevelChannel();
		List<WebChannel> webChannelList = new ArrayList<WebChannel>();
		for (Channel channel : channelList) {
			webChannelList.add(this.getChannel(channel));
		}
		return webChannelList;
	}

	// 返回某个频道
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public WebChannel getChannel(String channelId) {
		Channel channel = channelDao.findByChannelId(channelId);
		return this.getChannel(channel);
	}

	public WebChannel getChannel(Channel channel) {
		WebChannel webChannel = new WebChannel();
		webChannel.setDescription(channel.getDescription());
		webChannel.setKeywords(channel.getKeywords());
		webChannel.setName(channel.getName());
		if (channel.getChannelId().equals(WebsiteServiceInter.HOME_PAGE_CHANNEL_ID)) {
			webChannel.setChannelUrl(this.getHomePath());
		} else {
			if (channel.getIndexPath() != null && channel.getIndexPath().length() > 0) {
				webChannel.setChannelUrl(this.getHomePath() + "/" + channel.getAccessPath() + "/" + channel.getIndexPath());
			} else {
				webChannel.setChannelUrl(this.getHomePath() + "/" + channel.getAccessPath() + "/channellist-" + channel.getChannelId() + ".html");
			}
		}
		return webChannel;
	}

}
