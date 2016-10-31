package dao;

import java.util.List;

import entity.Wish;

public interface IWishDao {

    List<Wish> getWishList();

    Wish getWish(Integer wishId);

    void createWish(final Wish wish);

    void removeWish(final Integer wishId);

    void updateWish(final Wish wish);
}
