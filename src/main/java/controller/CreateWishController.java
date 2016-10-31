package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import entity.Wish;
import form.WishCreationForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.IWishService;

import javax.validation.Valid;

@Controller
public class CreateWishController {

    @Autowired
    private IWishService wishService;

    @RequestMapping(value = "/wishCreation", method = RequestMethod.GET)
    public String WishCreation(final ModelMap modelMap) {
        final List<Wish> wishList = wishService.getWishList();

        modelMap.addAttribute("wishList", wishList);

        if (modelMap.get("wishCreationForm") == null) {
            modelMap.addAttribute("wishCreationForm", new WishCreationForm());
        }
        return "wishCreation";
    }

    @RequestMapping(value = "/addWish", method = RequestMethod.POST)
    public String createWish(@Valid @ModelAttribute(value = "wishCreationForm") final WishCreationForm wishCreationForm,
                             final BindingResult bindingResult, final ModelMap modelMap) {

        if (!bindingResult.hasErrors()) {
            final Integer quantity = Integer.valueOf(wishCreationForm.getQuantity());
            wishService.createWish(wishCreationForm.getLabel(), quantity);
        }
        return WishCreation(modelMap);
    }
}