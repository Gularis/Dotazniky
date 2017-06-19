/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.mvc.controller;

import cz.mendelu.pef.swi.api.dto.UzivatelCreateDTO;
import cz.mendelu.pef.swi.api.facade.UzivatelFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author Martin
 */
@Controller
@ComponentScan(basePackages = "cz.mendelu.pef.swi.service.facade")
@RequestMapping("/registration")
public class RegistrationController {
    final static Logger log = LoggerFactory.getLogger(RegistrationController.class);
    @ModelAttribute("uzivatel")
    public UzivatelCreateDTO getUzivatel() {
        return new UzivatelCreateDTO();
    }
   @Autowired
   private UzivatelFacade uzivatelFacade;
    
    @RequestMapping(method = RequestMethod.GET)
    public String create(Model model) {
        log.info("registration visited");
        model.addAttribute("createUzivatel", new UzivatelCreateDTO());
        return "registration";
    }/*
     @RequestMapping(method = RequestMethod.GET)
    public String create(Model model) {
      
        return "registration";
    }*/
        @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute UzivatelCreateDTO uzivatel, ModelMap model, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {

        log.info("submitted registration: {}", uzivatel);
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.info("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                log.info("FieldError: {}", fe);
            }
            redirectAttributes.addFlashAttribute("alert_failure", "There are some errors with submitted data.");
            return "registration";
        }

        uzivatelFacade.createUzivatel(uzivatel);
        redirectAttributes.addFlashAttribute("alert_success", "You sign up. You can log in now!");

        return "redirect:/login";
}
    
}
