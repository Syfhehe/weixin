package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.WxService;

@WebServlet("/weixinServlet")
public class weixinServlet extends HttpServlet {

	
	private static final String AppSecret = "a43269ae964d66fe7c604746af83a3ef";
	private static final long serialVersionUID = 1L;

	public weixinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();

		if (WxService.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

//		ServletInputStream is = request.getInputStream();
//		byte[] b = new byte[1024];
//		int len;
//		StringBuilder sb = new StringBuilder();
//		while((len=is.read(b))!=-1) {
//			sb.append(new String(b,0,len));
//		}
//		System.out.println(sb.toString());

//		request.setCharacterEncoding("utf8");
//		response.setCharacterEncoding("utf8");
//
//		Map<String, String> requestMap = WxService.parseRequest(request.getInputStream());

//		System.out.println(requestMap);
//		
//		String respXML = "<xml>\r\n" + 
//				"  <ToUserName><![CDATA[" + requestMap.get("FromUserName") + "]]></ToUserName>\r\n" + 
//				"  <FromUserName><![CDATA[]]></FromUserName>\r\n" + 
//				"  <CreateTime>" + requestMap.get("CreateTime") +"</CreateTime>\r\n" + 
//				"  <MsgType><![CDATA[text]]></MsgType>\r\n" + 
//				"  <Content><![CDATA[" + requestMap.get("Content") +"]]></Content>\r\n" + 
//				"</xml>\r\n" + 
//				"";
//		String respXML = WxService.getResponse(requestMap);
//		System.out.println(respXML);
//		PrintWriter out = response.getWriter();
//		out.print(respXML);
//		out.flush();
//		out.close();

	}

}
