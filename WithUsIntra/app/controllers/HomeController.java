package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import javax.inject.Inject;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import Models.User;

import com.avaje.ebean.Model;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	
	@Inject
	private FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
 public Result addUser() {
    	
    	Form<User> userForm = formFactory.form(User.class);    	
    	User user = userForm.bindFromRequest().get();
    	    	
    	user.save();
    	
    	//return ok("User: " + user.lastName ); //Debug
    	return redirect(routes.HomeController.index());
    }
  
    public Result getUsers(){
    	
    	Model.Finder<Integer, User> finder = new Model.Finder<>(User.class);    	
    	List<User> users = finder.all();
    	
    	return ok(toJson(users));
    }

}
