import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet
{
    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
         res.sendRedirect("https://accounts.zoho.com/oauth/v2/auth?response_type=code&client_id=1000.R4ZXW88DLXPW6G97J6N810QZHXMPTB&scope=AaaServer.profile.Read&redirect_uri=https://www.google.com/&access_type=offline");
    }
}
