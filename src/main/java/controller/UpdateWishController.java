package controller;

import entity.Wish;
import form.WishCreationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.IWishService;

import javax.validation.Valid;

@Controller
public class UpdateWishController {

    @Autowired
    private IWishService wishService;

    @RequestMapping(value = "/wishUpdate", method = RequestMethod.GET)
    public String displayWishUpdate(@RequestParam(value = "wishId") final Integer wishId, ModelMap modelMap) {
        Wish wish = wishService.getWish(wishId);

        WishCreationForm wishCreationForm = new WishCreationForm();
        wishCreationForm.setId(String.valueOf(wishId));
        wishCreationForm.setLabel(wish.getLabel());
        wishCreationForm.setQuantity(String.valueOf(wish.getQuantity()));

        modelMap.addAttribute("wishCreationForm", wishCreationForm);

        return "wishUpdate";
    }

    @RequestMapping(value = "/updateWish", method = RequestMethod.POST)
    public ModelAndView updateWish(@Valid @ModelAttribute(value = "wishCreationForm") final WishCreationForm wishCreationForm,
                                   final BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            final Integer id = Integer.valueOf(wishCreationForm.getId());
            final String label = wishCreationForm.getLabel();
            final Integer quantity = Integer.valueOf(wishCreationForm.getQuantity());

            Wish wish = new Wish();
            wish.setLabel(label);
            wish.setId(id);
            wish.setQuantity(quantity);

            wishService.updateWish(wish);
        }

        return new ModelAndView("redirect:/wishList");
    }
}