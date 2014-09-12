package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.*;
import play.mvc.*;
import play.libs.Json;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result sayHello() {
        ObjectNode result = Json.newObject();
        result.put("exampleField1", "foobar");
        result.put("exampleField2", "Hello world!");
        return ok(result);
    }

    public static void showUser(String id){
        ok();
    }

}
