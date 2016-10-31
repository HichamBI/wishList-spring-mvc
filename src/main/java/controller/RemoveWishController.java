package controller;

import entity.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.IWishService;

import java.util.List;

@Controller
public class RemoveWishController {

    @Autowired
    private IWishService wishService;

    @RequestMapping(value = "/removeWish", method = RequestMethod.GET)
    public String removeWish(@RequestParam(value = "wishId") final Integer wishId, final ModelMap modelMap) {
        wishService.removeWish(wishId);
        List<Wish> wishList = wishService.getWishList();
        modelMap.addAttribute("wishList", wishList);

        return "wishList";
    }
}