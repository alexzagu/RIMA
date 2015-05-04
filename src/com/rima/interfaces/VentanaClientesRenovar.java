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

 public class VentanaClientesRenovar extends HttpServlet {	 	 
     HttpServletResponse thisResponse;
     HttpServletRequest thisRequest;
     PrintWriter out;
     mostrarClientesRenovar mcr;
     Vector vCliente = new Vector();
  
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
	         iniciarMostrar();  
	     }
	    
	     else if(operacion.equals("MostrarClientes")) {
	         mostrarClientesRenovar();
	     }
  	 }
  
	 public void iniciarMostrar() {
	     out.println("<p>Complete los valores indicados.</p>");
	     out.println("<form method=\"GET\" action=\"mostrarClientesRenovar\">");
	     out.println("<input type=\"hidden\" name=\"operacion\" value=\"MostrarClientes\"/>");
	     out.println("<p><input type=\"submit\" value=\"MostrarClientes\"></p>");
	     out.println("</form>"); 
	     out.println("<form method=\"GET\" action=\"menu.html\">");
	     out.println("<p><input type=\"submit\" value=\"Cancelar\"></p>");
	     out.println("</form>");
	
	     out.println("</BODY>");
	     out.println("</HTML>");    
	 }
  
	 public void mostrarClientesRenovar() {
	     mcr = new mostrarClientesRenovar();
	     //La funcion trim() elimina espacios antes y despues del valor
		vCliente = mcr.obtenerClientesRenovar();
		for (int iI = 0; iI < vCliente.size(); iI++) {
			out.println("<p>vCliente.elementAt(iI)<p>");
		}
	 }
 }