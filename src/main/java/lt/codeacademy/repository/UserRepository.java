package lt.codeacademy.repository;

import lt.codeacademy.entity.User;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.SessionFactory;


public class UserRepository {
        private final SessionFactory sessionFactory;

        public UserRepository() {
            sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
        }

        public void createUser(User user) {
            modifyEntity(session -> session.persist(user));

        }
}
