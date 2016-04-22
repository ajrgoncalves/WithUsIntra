package controllers;

import javax.inject.Inject;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import Models.User;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	
	@Inject
	private FormFactory formFactory;

  
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
 public Result addUser() {
    	
    	Form<User> userForm = formFactory.form(User.class);    	
    	User user = userForm.bindFromRequest().get();
    	    	
    	user.save();
    	
    	//return ok("User: " + user.lastName ); //Debug
    	return redirect(routes.HomeController.register());
    }
  
//    public Result getUsers(){
//    	
//    	Model.Finder<Integer, User> finder = new Model.Finder<>(User.class);    	
//    	List<User> users = finder.all();
//    	
//    	return ok(toJson(users));
//    }
    
    
    public Result register(){
    	   
    	
    	return ok(views.html.register.render("register"));
    	
    }
    
    public Result login(){
    	
    	return ok(views.html.login.render(formFactory.form(Login.class)));    	
    	//return ok(views.html.login.render(form(Login.class)));
    }
    
    public Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if(loginForm.hasErrors()){
			return badRequest(views.html.login.render(loginForm));
		}else{
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.HomeController.index());
		}
	}
  
    public Result getUsers(){
		return TODO;
	}
	
	public Result createUser(){
		return TODO;
	}

	public static class Login {
    
    	public static String email;
    	public static String password;
    	
    	public static String validate() {
    		if(User.authenticate(email, password) == null) {
    			return "Login Failed";
    		}
    		return null;
    	}
    }
    

}
