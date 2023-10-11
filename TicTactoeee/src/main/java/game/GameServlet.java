package game;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import game.GameBean;
import game.GameBean.GamePlayer;
public class GameServlet extends HttpServlet {
/**
* Processes requests for both HTTP &lt;code&gt;GET&lt;/code&gt; and &lt;code&gt;POST&lt;/code&gt;
* methods.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
GameBean game = (GameBean) request.getSession(true).getAttribute(&quot;gameBean&quot;);
int line = Integer.parseInt(request.getParameter(&quot;Line&quot;));
int col = Integer.parseInt(request.getParameter(&quot;Col&quot;));
game.playPlayerTurn(line, col);
GamePlayer winner = game.getWinner();
switch(winner){
case NOBODY:
if(game.hasEmptyCell()){
game.playComputerTurn();
switch(game.getWinner()){
case NOBODY:
break;
case COMPUTER:
request.setAttribute(&quot;winner&quot;, &quot;The computer&quot;);
break;
case USER:
request.setAttribute(&quot;winner&quot;, &quot;You&quot;);
break;
}
}
break;
case COMPUTER:
request.setAttribute(&quot;winner&quot;, &quot;The computer&quot;);
break;
case USER:
request.setAttribute(&quot;winner&quot;, &quot;You&quot;);
break;

}
if(winner == GamePlayer.NOBODY &amp;&amp; !game.hasEmptyCell()){
request.setAttribute(&quot;winner&quot;, &quot;Nobody&quot;);
}
request.getRequestDispatcher(&quot;/game.jsp&quot;).forward(request, response);
}
// &lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot;HttpServlet methods. Click on the + sign on the left
to edit the code.&quot;&gt;
/**
* Handles the HTTP &lt;code&gt;GET&lt;/code&gt; method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
return &quot;Short description&quot;;
}// &lt;/editor-fold&gt;
}