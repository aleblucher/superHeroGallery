package mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.mbeans.UserMBean;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import teste.model.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TarefasController {
	@RequestMapping("/")
	public String execute() {
		return "login";
 }
	
	@RequestMapping(value = "/" ,  method = {RequestMethod.POST})
	public String loginSignup(HttpSession session,
			@RequestParam(value="username", required=true)  String username,
			@RequestParam(value="password", required=true)  String password) {
		
		DAO dao = new DAO();

		User user = dao.getUserByName(username);
		System.out.println("Pagina inicial");
		if(user.getUsername() != null && user.getSenha().equals(password)) {
			System.out.println("autentifica��o executada com sucesso");
			session.setMaxInactiveInterval(1800);
			dao.editUserLastSession(user);
			session.setAttribute("user", user);
			session.setAttribute("listNotes", dao.getNotesFromUser(user));
			return "home";
		}else {
			return "login";
		}
		
		
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
 }
	
	@RequestMapping("/SignUp")
	public String signup() {
		return "signUp";
 }
	

	
}
