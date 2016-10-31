package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IWishDao;
import entity.Wish;

@Service
public class WishService implements IWishService {

    @Autowired
    private IWishDao wishDao;

    @Override
    @Transactional(readOnly = true)
    public List<Wish> getWishList() {
        return wishDao.getWishList();
    }

    @Override
    @Transactional(readOnly = true)
    public Wish getWish(Integer wishId) {
        return wishDao.getWish(wishId);
    }

    @Override
    @Transactional
    public void createWish(String label, Integer quantity) {
        Wish newWish = new Wish();
        newWish.setLabel(label);
        newWish.setQuantity(quantity);

        wishDao.createWish(newWish);
    }

    @Override
    @Transactional
    public void removeWish(Integer wishId) {
        wishDao.removeWish(wishId);
    }

    @Override
    @Transactional
    public void updateWish(Wish wish) {
        wishDao.updateWish(wish);
    }
}
