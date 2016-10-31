package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;

import org.springframework.stereotype.Repository;

import entity.Wish;

@Repository
public class WishDao implements IWishDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Wish> getWishList() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Wish> wishQuery = criteriaBuilder.createQuery(Wish.class);
        Root<Wish> root = wishQuery.from(Wish.class);
        wishQuery.select(root);

        return entityManager.createQuery(wishQuery).getResultList();
    }

    @Override
    public Wish getWish(Integer wishId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Wish> criteriaQuery = criteriaBuilder.createQuery(Wish.class);
        Root<Wish> wishRoot = criteriaQuery.from(Wish.class);
        Path<Wish> path = wishRoot.get("id");
        Predicate predicate = criteriaBuilder.equal(path, wishId);

        criteriaQuery.where(predicate);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void createWish(final Wish wish) {
        entityManager.persist(wish);
    }

    @Override
    public void removeWish(final Integer wishId) {
        Wish wishToRemove = entityManager.getReference(Wish.class, wishId);
        entityManager.remove(wishToRemove);
    }

    @Override
    public void updateWish(Wish wish) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaUpdate<Wish> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Wish.class);
        Root<Wish> wishRoot = criteriaUpdate.from(Wish.class);
        Path<Wish> path = wishRoot.get("id");
        Predicate predicate = criteriaBuilder.equal(path, wish.getId());

        criteriaUpdate.where(predicate);
        criteriaUpdate.set("label", wish.getLabel());
        criteriaUpdate.set("quantity", wish.getQuantity());

        Query query = entityManager.createQuery(criteriaUpdate);
        int rowCount = query.executeUpdate();

        if (rowCount != 1) {
            final org.hibernate.Query lHQuery = query.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Occurrence (" + rowCount +
                    ") updated is different to 1 for the query" + lSql);
        }
    }
}
