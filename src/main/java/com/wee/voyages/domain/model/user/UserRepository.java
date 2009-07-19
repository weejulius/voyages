package com.wee.voyages.domain.model.user;

/**
 * User: weejulius
 * Date: 2009-7-10
 * Time: 15:50:35
 */
public interface UserRepository {
    public void store(User user); 

    public void update(User user);

    public void delete(User user);
}
