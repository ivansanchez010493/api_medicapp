package mx.com.medicapp.app.model.dao;

import mx.com.medicapp.app.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {

    User findByUsername(String usernam);
}
