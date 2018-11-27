package com.patpaw.controller;

import com.patpaw.model.Animal;
import com.patpaw.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    AnimalServiceImpl animalService;

    @RequestMapping(value = "/addAnimal", method = RequestMethod.GET)
    public String newAnimal(ModelMap model) {
        Animal animal = new Animal();
        model.addAttribute("animal",animal);
        return "addAnimal";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAnimal(@Valid Animal animal, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("Error");
            return "addAnimal";
        }

        animalService.save(animal);
        return "redirect:/viewAnimals";
    }

    @RequestMapping(value = "/viewAnimals")
    public ModelAndView getAll() {
        List<Animal> list = animalService.findAll();
        return new ModelAndView("viewAnimals", "list", list);
    }

    @RequestMapping(value = "/editAnimal/{id}")
    public String edit(@PathVariable long id, ModelMap model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "editAnimal";
    }

    @RequestMapping(value = "/editSave", method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("animal") Animal a) {

        Animal animal = animalService.findById(a.getId());
        animal.setName(a.getName());
        animal.setType(a.getType());
        animal.setDescription(a.getDescription());

        animalService.save(animal);
        return new ModelAndView("redirect:/viewAnimals");
    }

    @RequestMapping(value = "/deleteAnimal/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable long id) {
        Animal animal = animalService.findById(id);
        animalService.delete(animal);
        return  new ModelAndView("redirect:/viewAnimals");
    }
























}
