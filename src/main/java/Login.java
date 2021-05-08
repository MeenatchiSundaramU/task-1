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
         res.sendRedirect("https://accounts.zoho.com/oauth/v2/auth?response_type=code&client_id=1000.CU8EIFGUKKWO76XF6DJI5PMJ072P2T&scope=AaaServer.profile.Read&redirect_uri=http://localhost:8080/final/resp&access_type=offline");
    }
}
///https://accounts.zoho.com/oauth/v2/token?grant_type=authorization_code&client_id=1000.CU8EIFGUKKWO76XF6DJI5PMJ072P2T&client_secret=1a69af9c58c99acb88dd7de3be5698fe9de8cfd01a&redirect_uri=https://www.google.com/&code=1000.edf4a2c614697321eab6916f958c6dae.a05c0d40ec427fab3c8b389ee6093d40
///Generating access token https://accounts.zoho.com/oauth/v2/token?refresh_token=1000.b430d8b3b5c8c97c317b38920e78a59f.7b1da40cc1b2aad72f8eae8e8d5c2186&client_id=1000.CU8EIFGUKKWO76XF6DJI5PMJ072P2T&client_secret=1a69af9c58c99acb88dd7de3be5698fe9de8cfd01a&grant_type=refresh_token
//https://accounts.zoho.com/oauth/v2/token/revoke?token=1000.712646edd8df5029e9400c61ad88c82d.1066268351243f2b7643bc1310e880c6