package service;

import java.util.List;

import entity.Wish;

public interface IWishService {

    List<Wish> getWishList();

    Wish getWish(Integer wishId);

    void createWish(String label, Integer quantity);

    void removeWish(Integer wishId);

    void updateWish(Wish wish);
}
