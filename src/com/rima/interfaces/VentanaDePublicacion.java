/*Author: Equipo 5
 *
 *Version: 1.0.0
 *
 */
 package com.rima.interfaces;
 import com.rima.controls.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;
 import java.util.*;
 import java.util.Calendar;

 public class VentanaDePublicacion extends HttpServlet {	 	 
     HttpServletResponse thisResponse;
     HttpServletRequest thisRequest;
     PrintWriter out;
     altaRevista aa;
     int iNumPaginas;
  
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {	
         thisResponse = response;
    	 thisRequest = request;
    	 thisResponse.setContentType("text/html");
    	 out = thisResponse.getWriter();
    	 //Preparar el encabezado de la pagina Web de respuesta
    	 out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
	     out.println("<HTML>");
	     out.println("<HEAD>");
	     out.println("<META http-equiv=Content-Type content=\"text/html\">");
	     out.println("</HEAD>");
	     out.println("<BODY>");
	     out.println("<TITLE>SEng Bytes & Bits</TITLE>");
	     out.println("<h2>RIMA</h2>");
	     out.println("<h3>Dar de alta un autor</h3>");
    
	     String operacion = request.getParameter("operacion");
	    
	     if(operacion == null) { // El menú nos envia un parametro para indicar el inicio de una transaccion
	         iniciarAlta();  
	     }
	    
	     else if(operacion.equals("agregar")) {
	         agregarRevista();
	     }
	    
	     else if (operacion.equals("feedback")) {			     
	         desplegarFeedback();
	     }
  	 }
  
	 public void iniciarAlta() {
	     out.println("<p>Complete los valores indicados.</p>");
	     out.println("<form method=\"GET\" action=\"agregarRevista\">");
	     out.println("<input type=\"hidden\" name=\"operacion\" value=\"agregar\"/>");
	     out.println("<p> Numero Paginas  <input type=\"int\" name=\"NumPaginas\" size=\"34\"></p>");
	     out.println("<p><input type=\"submit\" value=\"Agregar\"></p>");
	     out.println("</form>");
	 
	     out.println("<form method=\"GET\" action=\"menu.html\">");
	     out.println("<p><input type=\"submit\" value=\"Cancelar\"></p>");
	     out.println("</form>");
	
	     out.println("</BODY>");
	     out.println("</HTML>");    
	 }
  
	 public void agregarRevista() {
	     aa = new altaRevista();
		 Calendar cal = Calendar.getInstance();
	     //La funcion trim() elimina espacios antes y despues del valor
		 Date dFechaPublicacion = cal.getTime();
		 iNumPaginas = thisRequest.getParameter("NumPaginas");
	     boolean existe = cc.validarCuenta(idcuenta);
	     aa.agregarAutor(dFechaPublicacion, iNumPaginas, true);
		 desplegarFeedback();
	 }

	 public void desplegarFeedback() {
	     out.println("<p>La revista ha sido publicada exitosamente.</p>");
	     out.println("<p>Presione el boton para terminar.</p>");
	     out.println("<form method=\"GET\" action=\"index.html\">");
	     out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
	     out.println("</form>");
	     out.println("</BODY>");
	     out.println("</HTML>");   
	 }
 }