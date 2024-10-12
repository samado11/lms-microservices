package com.app.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class learn_two {
    List <Staff> allstaff = new ArrayList<>(); 

    @GetMapping("/getinfo")
    public String getinfo(Model model, @RequestParam(required=false) String id){

        Staff staff = new Staff();

        int index = getstaffindex(id);

        model.addAttribute("Staff", index == text.no_match ? staff : allstaff.get(index));

        return "Newgetinfo";
    }

    public int getstaffindex(String id){

        for (int i = 0; i < allstaff.size(); i++) {

            if (allstaff.get(i).getid().equals(id)) return i;
        }

        return text.no_match;
    }

    @PostMapping("path")
        public String datasubmation(@Validated @ModelAttribute("Staff") Staff staff, BindingResult result){

            if (result.hasErrors()) {
                return "Newgetinfo";
            }

            int index = getstaffindex(staff.getid());
            
            if (index == text.no_match) {
                allstaff.add(staff);

            } else {

                allstaff.add(index, staff);
            }

            return "redirect:/getallstaff";
        }

        @GetMapping("getallstaff")

        public String getMethodName(Model model) {

            model.addAttribute("staff", allstaff);

            return "mohamed mamdouh";

        }
        
    
   
    

    
}
