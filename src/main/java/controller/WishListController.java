package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Wish;
import service.IWishService;

@Controller
@RequestMapping(value = "/wishList")
public class WishListController {

    @Autowired
    IWishService wishService;

    @RequestMapping(method = RequestMethod.GET)
    public String getWishList(ModelMap modelMap) {
        List<Wish> wishList = wishService.getWishList();
        modelMap.addAttribute("wishList", wishList);

        return "wishList";
    }
}
