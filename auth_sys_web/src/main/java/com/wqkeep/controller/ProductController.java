package com.wqkeep.controller;

import com.wqkeep.domain.Product;
import com.wqkeep.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.findAll();

        mv.addObject("productList", products);
        mv.setViewName("product-list");

        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product){

        productService.save(product);

        return "redirect:findAll.do";
    }

}
