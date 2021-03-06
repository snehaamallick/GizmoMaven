package gizmomaven;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import form.FileUpload;
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
	
	/*===========================*/
	@RequestMapping("/sd")
	public String loadStudentDetailsPage(Model model)
	{
		model.addAttribute("student", new Student());
		model.addAttribute("listfromtable", this.ss.listPersons());
		return "studentlist";
	}
	
	 @RequestMapping("/showdetails/{id}")
	    public String showDetails(@PathVariable("id") int id, Model model){
	        return "showdetails";
	    }
	

	 
	 
	 @RequestMapping(value = "/upload", method = RequestMethod.GET)
	    public String crunchifyDisplayForm() {
	        return "uploadfile";
	    }
	 
	    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
	    public String crunchifySave(
	            @ModelAttribute("uploadForm") FileUpload uploadForm,
	            Model map) throws IllegalStateException, IOException {
	        String saveDirectory = "c:/crunchify/";
	 
	        List<MultipartFile> crunchifyFiles = uploadForm.getFiles();
	 
	        List<String> fileNames = new ArrayList<String>();
	 
	        if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
	            for (MultipartFile multipartFile : crunchifyFiles) {
	 
	                String fileName = multipartFile.getOriginalFilename();
	                if (!"".equalsIgnoreCase(fileName)) {
	                    // Handle file content - multipartFile.getInputStream()
	                    multipartFile
	                            .transferTo(new File(saveDirectory + fileName));
	                    fileNames.add(fileName);
	                }
	            }
	        }
	 
	        map.addAttribute("files", fileNames);
	        return "uploadfilesuccess";
	    }
	
	 
	 
	 	
	
	 
	 
	 
	
	@RequestMapping(value= "/newproductdetails", method = RequestMethod.POST)
    public String addProduct( @ModelAttribute("product") Student p, HttpServletRequest request){
     
		  String filename=null;
		  byte[] bytes;
		  if(!p.getImage().isEmpty())
	        {
			 
	            try
	            {
	            	bytes=p.getImage().getBytes();
	                ss.addPerson(p);
	                System.out.println("Data Inserted");
	            
	           
	        
	                
					String path=request.getSession().getServletContext().getRealPath("/resources/images/"+p.getId()+".jpg");
					System.out.println("Path = "+path);
					System.out.println("File name = "+p.getImage().getOriginalFilename());
					File f=new File(path);
					BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
					bs.write(bytes);
					bs.close();
					System.out.println("Image uploaded");
	            }
				catch(Exception ex)
	            {
	                System.out.println(ex.getMessage());
	            }
	        }
                if(p.getId() == 0){
        this.ss.addPerson(p);
          }
   
   return "redirect:/students";
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