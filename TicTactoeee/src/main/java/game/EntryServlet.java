package game;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import game.GameBean;
public class EntryServlet extends HttpServlet {
/**
* Processes requests for both HTTP &lt;code&gt;GET&lt;/code&gt; and
&lt;code&gt;POST&lt;/code&gt;
* methods.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
protected void processRequest(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
String user = request.getParameter(&quot;User&quot;);
boolean userFirst = user != null;
GameBean game = (GameBean)
request.getSession(true).getAttribute(&quot;gameBean&quot;);
game.setStartByUser(userFirst);
game.startGame();
request.getRequestDispatcher(&quot;/game.jsp&quot;).forward(request,
response);

}
// &lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot;HttpServlet methods.
Click on the + sign on the left to edit the code.&quot;&gt;
/**
* Handles the HTTP &lt;code&gt;GET&lt;/code&gt; method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
processRequest(request, response);
}
/**
* Handles the HTTP &lt;code&gt;POST&lt;/code&gt; method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
processRequest(request, response);
}
/**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
@Override
public String getServletInfo() {
return &quot;Process initial form response.&quot;;
}// &lt;/editor-fold&gt;
}