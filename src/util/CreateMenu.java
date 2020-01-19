package util;

import entity.Button;
import entity.ClickButton;
import entity.PhotoOrAlbumButton;
import entity.SubButton;
import entity.ViewButton;
import net.sf.json.JSONObject;
import service.WxService;

public class CreateMenu {

	public static void main(String[] args) {
		Button btn = new Button();
		btn.getButton().add(new ClickButton("First Click", "1"));
		btn.getButton().add(new ViewButton("First Jump", "http://www.baidu.com"));
		SubButton sb = new SubButton("Sub menu");
		sb.getSub_button().add(new PhotoOrAlbumButton("Upload pic", "31"));
		sb.getSub_button().add(new ClickButton("Click", "32"));
		sb.getSub_button().add(new ViewButton("Neteasy", "http://news.163.com"));
		btn.getButton().add(sb);
		JSONObject jsonObject = JSONObject.fromObject(btn);
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", WxService.getAccessToken());
		String result = Util.post(url, jsonObject.toString());
		System.out.println(result);

	}

}
