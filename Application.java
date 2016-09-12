package controllers;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by amadou on 12/09/2016.
 */
public class Application extends controller {

    public static Result index() {
        return redirect(routes.HomeController.index());
    }


}
