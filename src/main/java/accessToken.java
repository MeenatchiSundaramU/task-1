import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/oauth/v2/token"})
public class accessToken 
{
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter out = resp.getWriter();
		out.print(req.getParameter("client_id"));
	}
}
