package com.maxxton.mis.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple web controller that redirects you to the swagger page.
 *
 * @author P.Bohara (s.kelkar@maxxton.com) copyright Maxxton Group 2015
 */
@Controller
public class SwaggerController {
  @RequestMapping("/api-docs")
  public String home() {
    return "redirect:swagger-ui.html";
  }
}