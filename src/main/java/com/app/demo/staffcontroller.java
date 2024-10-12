package com.app.demo;





import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class staffcontroller {
    
    //Staff all = new Staff("mohamed", "Developer", 17000);
    List <Staff> allstaf = new ArrayList<>();
    
    @GetMapping("/")
    public String getstafname(Model model)
    {
        //List <Staff> allstaf = new ArrayList<>();
       Staff all = new Staff();
        model.addAttribute("staff", all); 
        return "z";
    }


    @PostMapping("/savestaff")
    public String postMethodName(Staff Staff) {
        
        allstaf.add(Staff);
        return "redirect:/x";
    }


    @GetMapping("/x")
    public String getMethodName(Model model) {
        model.addAttribute("staff", allstaf);

        return "mohamed mamdouh";
    }

    
    
    
}
