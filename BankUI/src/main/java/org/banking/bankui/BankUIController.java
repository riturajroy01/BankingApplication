package org.banking.bankui;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BankUIController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
  public String about(Model model) {
        //code here , connect db and get data and send value to html like below
        model.addAttribute("title", "Bank UI");
      return "about";
  }
}
