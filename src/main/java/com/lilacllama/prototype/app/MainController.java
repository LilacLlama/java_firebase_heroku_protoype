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
@CrossOrigin
public class MainController {

    public MainController() {
    }

    @GetMapping({ "/", "/home" })
    public String adminConsole(Model model) throws Exception {
        System.out.println("Root.");

        model.addAttribute("dataList", new String[] { "Red", "Blue", "Green" });
        return "main";
    }

}
