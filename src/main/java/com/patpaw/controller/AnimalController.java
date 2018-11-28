package com.patpaw.controller;

import com.patpaw.model.Animal;
import com.patpaw.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AnimalController {

    @Autowired
    AnimalServiceImpl animalService;

    @RequestMapping(value = "/addAnimal", method = RequestMethod.GET)
    public String newAnimal(Model model) {
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
        Animal savedAnimal = animalService.saveOrUpdate(animal);
        return "redirect:/viewAnimals" + savedAnimal.getId();
    }

    @RequestMapping(value = "/viewAnimals")
    public String getAll(Model model) {
        model.addAttribute("animals", animalService.findAll());
        return  "viewAnimals";
    }

    @RequestMapping(value = "/showAnimal/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("animal", animalService.getById(id));
        return "showAnimal";
    }

    @RequestMapping(value = "/editAnimal/{id}")
    public String edit(@PathVariable String id, Model model) {
        Animal animal = animalService.getById(id);
        model.addAttribute("animal", animal);
        return "editAnimal";
    }

    @RequestMapping(value = "/editSave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("animal") Animal a) {

        Animal animal = animalService.getById(a.getId());
        animal.setName(a.getName());
        animal.setType(a.getType());
        animal.setDescription(a.getDescription());

        animalService.saveOrUpdate(animal);
        return "redirect:/viewAnimals";
    }

    @RequestMapping(value = "/deleteAnimal/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        animalService.delete(id);
        return  "redirect:/viewAnimals";
    }
























}
