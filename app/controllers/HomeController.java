package controllers;

import play.mvc.*;

import views.html.*;
import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    static ArrayNode productsJson;

    static {
        productsJson = (ArrayNode) Json.parse("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"Ceinture\",\n" +
                "    \"presentationImage\": \"http://www.bootply.com/assets/example/ec_belt.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"Jacket\",\n" +
                "    \"presentationImage\": \"http://www.bootply.com/assets/example/ec_jacket.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"Jeans\",\n" +
                "    \"presentationImage\": \"http://www.bootply.com/assets/example/ec_jeans.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"title\": \"Chaussettes\",\n" +
                "    \"presentationImage\": \"http://www.bootply.com/assets/example/ec_socks.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 5,\n" +
                "    \"title\": \"Pull\",\n" +
                "    \"presentationImage\": \"http://www.bootply.com/assets/example/ec_sweater.jpg\"\n" +
                "  }\n" +
                "]");
        for (int i = 0; i < productsJson.size(); i++) {
            Product p = Json.fromJson(productsJson.get(i), Product.class);
            p.save();
        }
    }


    public static Result addListProduit() {
        List<Product> products = Product.find.findList();

        for (int i = 0; i < productsJson.size(); i++) {

            products.add(Json.fromJson(productsJson.get(i), Product.class));
        }
        return ok(index.render(products
        ));
    }

    public Result product(Long id) {
        return ok(product.render(Product.find.byId(id)));

    }

    @Inject
    FormFactory factory; // Instance automatiquement crÃ©Ã©e.

    public Result createProduct() {
        Form<Product> form = factory.form(Product.class);
        form = form.bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(newProduct.render(form));
        }

        Product product = form.get();
        product.save();
        return redirect(routes.HomeController.product(product.id));
    }



    public Result newProduct() {
        Form<Product> form = factory.form(Product.class);
        return ok(newProduct.render(form));
    }


}
