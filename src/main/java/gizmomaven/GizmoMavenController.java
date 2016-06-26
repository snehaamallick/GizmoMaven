package gizmomaven;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import daoimplementations.ProductDAOImpl;
import models.Product;

@Controller
public class GizmoMavenController {
	@RequestMapping(value={"/","gotoindex"})
	public String loadIndexPage()
	{
		return "index";
	}
	 
	@RequestMapping("/aboutus")
	public String loadAboutusPage()
	{
		return "aboutus";
	}
	@RequestMapping("/signup")
	public String loadSignUpPage()
	{
		return "signup";
	}
	@RequestMapping("/Contact")
	public String loadContactPage()
	{
		return "Contact";
	}
	@RequestMapping("/user_product_page")
	public String loaduserproductpage()
	{
		return "user_product_page";
	}
	@RequestMapping("/admn")
	public ModelAndView loadadminpage()
	{
		ProductDAOImpl pdi=new ProductDAOImpl();
		ArrayList<Product> listofproducts=new ArrayList<Product>();
		listofproducts=pdi.productLists();
		String json = new Gson().toJson(listofproducts);  // converting list into Google Gson object which is a string
		
		ModelAndView mv=new ModelAndView("admn");
		mv.addObject("myJson", json);
		return mv;
	}
}
