package gizmomaven;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import gizmomaven.StudentService;
import models.Student;







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
private StudentService ss;
	
	@Autowired
	public GizmoMavenController(StudentService ss) {
		this.ss=ss;
	}
	
	 @RequestMapping(value = "/students", method = RequestMethod.GET)
	    public String listPersons(Model model) {
	        model.addAttribute("student", new Student());
	        model.addAttribute("listfromtable", this.ss.listPersons());
	        return "studentdetails";
	    }
	 
	 @RequestMapping(value= "/studentdetails/add", method = RequestMethod.POST)
	    public String addPerson(@ModelAttribute("student") Student p){
	         
	        if(p.getId() == 0){
	            //new person, add it
	            this.ss.addPerson(p);
	        }else{
	            //existing person, call update
	            this.ss.updatePerson(p);
	        }
	         
	        return "redirect:/students";
	         
	    }
	 
	 @RequestMapping("/remove/{id}")
	    public String removePerson(@PathVariable("id") int id){
	         
	        this.ss.removePerson(id);
	        return "redirect:/students";
	    }
	  
	    @RequestMapping("/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, Model model){
	        model.addAttribute("student", this.ss.getPersonById(id));
	        model.addAttribute("listfromtable", this.ss.listPersons());
	        return "studentdetails";
	    }
	
	
	@RequestMapping("/studentdetails")
	public String showIndexPage()
	{
		return("redirect:/students");
	}
	

	/*@RequestMapping("/admn")
	public ModelAndView loadadminpage()
	{
		ProductDAOImpl pdi=new ProductDAOImpl();
		ArrayList<Product> listofproducts=new ArrayList<Product>();
		listofproducts=pdi.productLists();
		String json = new Gson().toJson(listofproducts);  // converting list into Google Gson object which is a string
		
		ModelAndView mv=new ModelAndView("admn");
		mv.addObject("myJson", json);
		return mv;
	}*/
}
