
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

@WebServlet("/qt.do")
public class QtController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// www.su.or.kr

		String url = "http://www.su.or.kr/03bible/daily/qtView.do?qtType=QT1";
		URL u = new URL(url);

		// html parsing---->jericho api

		Source src = new Source(u);

		List<Element> list = src.getAllElements(HTMLElementName.BODY);
		String data = list.get(0).toString();
		System.out.println(data);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(data);
	}

}
