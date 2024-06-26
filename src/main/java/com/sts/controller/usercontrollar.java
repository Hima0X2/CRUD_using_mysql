// UserController.java
package com.sts.controller;

import com.sts.model.Product;
import com.sts.services.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class usercontrollar {

    @Autowired
    private ProductRepo repo;

    @GetMapping("/students")
    public String getStudentList(Model model) {
        Iterable<Product> students = repo.findAll();
        model.addAttribute("students", students);
        model.addAttribute("product", new Product());
        return "user";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Product product) {
        repo.save(product);
        return "redirect:/students";
    }

    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        repo.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/editStudent/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Product product = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", product);
        return "update-student";
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id, @ModelAttribute Product product, Model model) {
        product.setId(id);
        repo.save(product);
        return "redirect:/students";
    }
}
