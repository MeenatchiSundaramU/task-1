import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;
import java.sql.*;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/resp"})
public class response extends HttpServlet 
{
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String error=req.getParameter("error");
		if(error!=null)
		{
			resp.sendRedirect("http://localhost:8080/final/index.html");
		}
		else if(error==null)
		{
		String code=req.getParameter("code");
		String grand_token_api="https://accounts.zoho.com/oauth/v2/token?grant_type=authorization_code&client_id=1000.CU8EIFGUKKWO76XF6DJI5PMJ072P2T&client_secret=1a69af9c58c99acb88dd7de3be5698fe9de8cfd01a&redirect_uri=http://localhost:8080/final/resp&code="+req.getParameter("code");
		String grand_token=callFun(grand_token_api);
		 int ind1=grand_token.indexOf(":");
	     int ind2=grand_token.indexOf(",");
	     String access_token=callFun("https://accounts.zoho.com/oauth/v2/token/revoke?token="+grand_token.substring(ind1+2,ind2-1));
	     int finind1=access_token.toString().indexOf(":")+2;
	     int finind2=access_token.toString().lastIndexOf('"');
	     if(access_token.toString().substring(finind1, finind2).equals("success")) {
	    	 try {
					uploadDatabase(access_token,req.getParameter("name").toString());
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
				 }
	        	resp.sendRedirect("http://localhost:8080/final/resp.html");
	             }
	     else
	     {
	    	 resp.sendRedirect("http://localhost:8080/final/index.html");
	     }
	     
         }
	}
	String callFun(String url) throws IOException
	{
		URL obj= new URL(url);
	    HttpsURLConnection con=(HttpsURLConnection)obj.openConnection();
	    con.setRequestMethod("POST");
	    int respcode=con.getResponseCode();
		 BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     return response.toString();
	}
	void uploadDatabase(String persistent_tokens,String name) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/users";
		String uname="root";
		String pass="";
		String query="Insert into client values(name,persistent_tokens)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection co=DriverManager.getConnection(url,uname,pass);
		Statement st=co.createStatement();
		ResultSet rs=st.executeQuery(query);
		st.close();
		co.close();
	}
}

