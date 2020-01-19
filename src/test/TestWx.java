package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import entity.*;
import net.sf.json.JSONObject;
import service.WxService;

public class TestWx {

	@Test
	public void testMsg() {
		Map<String, String> map = new HashMap<>();
		map.put("ToUserName", "to");
		map.put("FromUserName", "from");
		map.put("MsgType", "type");
		TextMessage tm = new TextMessage(map, "哈哈哈");
		XStream stream = new XStream();
		stream.processAnnotations(TextMessage.class);
		stream.processAnnotations(ImageMessage.class);
		stream.processAnnotations(MusicMessage.class);
		stream.processAnnotations(NewsMessage.class);
		stream.processAnnotations(VideoMessage.class);
		stream.processAnnotations(VoiceMessage.class);
		String xml = stream.toXML(tm);
		System.out.println(xml);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testGetToken() {
		WxService wx = new WxService();
		System.out.println(wx.getAccessToken());
		System.out.println(wx.getAccessToken());
	}

	@Test
	public void testButton() {
		// 菜单对象
		Button btn = new Button();
		// 第一个一级菜单
		btn.getButton().add(new ClickButton("一级点击", "1"));
		// 第二个一级菜单
		btn.getButton().add(new ViewButton("一级跳转", "http://www.baidu.com"));
		// 创建第三个一级菜单
		SubButton sb = new SubButton("有子菜单");
		// 为第三个一级菜单增加子菜单
		sb.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
		sb.getSub_button().add(new ClickButton("点击", "32"));
		sb.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
		// 加入第三个一级菜单
		btn.getButton().add(sb);
		// 转为json
		JSONObject jsonObject = JSONObject.fromObject(btn);
		System.out.println(jsonObject.toString());
	}

	@Test
	public void testUpload() {
		String file = "C:\\Users\\Shenyifan\\Pictures\\2.jpg";
		WxService ws = new WxService();
		System.out.println(ws.upload(file, "image"));
	}

	@Test
	public void testQrCode() {
		String ticket = WxService.getQrCodeTicket();
		System.out.println(ticket);
	}

	@Test
	public void testGetUserInfo() {
		String user = "oLql6jpUoKmZC9IZ_TDQ0zQSSLSY";
		String info = WxService.getUserInfo(user);
		System.out.println(info);
	}
}
