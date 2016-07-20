package lv.javaguru.java2.servlet;
import lv.javaguru.java2.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontPageController implements MVCController{
    public MVCModel execute(HttpServletRequest request) {

        List<Product> products = new ArrayList<Product>();

        Product loneLoneItem = new Product();
        loneLoneItem.setId(13L);
        loneLoneItem.setName("Торт 'Одиночество'");
        loneLoneItem.setPrice(13.66);
        loneLoneItem.setDescription("Клёвый торт. Много шоколада , мало взбитых сливок и прочих соплей");
        loneLoneItem.setImagePath("img/products/milk/cheese/mold/colony/139820256.jpg");

        Map<String,String> attributes = new HashMap<String,String>();
        attributes.put("Brand","Фабрика Зоря");
        attributes.put("Вес","1250г");
        attributes.put("Цвет","Чёрный шоколад");
        attributes.put("Бонусы","5 вишинек");
        attributes.put("Форм фактор","Усечённый конус");

        loneLoneItem.setAttributes(attributes);

        Product otherLoneItem = new Product();
        otherLoneItem.setId(14L);
        otherLoneItem.setName("Торт 'Сытость гарантирована'");
        otherLoneItem.setPrice(12.00);
        otherLoneItem.setDescription("Клёвый торт. но торт одиночество круче");
        otherLoneItem.setImagePath("img/products/milk/cheese/goat/sample2/goatcheese.png");

        attributes = new HashMap<String,String>();
        attributes.put("Brand","Фабрика Зоря");
        attributes.put("Вес","1350г");
        attributes.put("Цвет","Белый шоколад");
        attributes.put("Бонусы","Дольки ананаса");
        attributes.put("Форм фактор","Цилиндр");
        otherLoneItem.setAttributes(attributes);

        products.add(loneLoneItem);
        products.add(otherLoneItem);

        return new MVCModel(products, "/frontPage.jsp");
    }
}

