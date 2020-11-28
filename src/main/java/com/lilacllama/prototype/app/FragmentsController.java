package com.lilacllama.prototype.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Lilac Llama
 */
@Controller
public class FragmentsController {

    @GetMapping("/fragments")
    public String getHome() {
        return "fragments.html";
    }
 
    @GetMapping("/markup")
    public String markupPage() {
        return "markup.html";
    }
 
    @GetMapping("/params")
    public String paramsPage() {
        return "params.html";
    }
 
    @GetMapping("/other")
    public String otherPage(Model model) {
        // model.addAttribute("data", StudentUtils.buildStudents());
        return "other.html";
    }

}
