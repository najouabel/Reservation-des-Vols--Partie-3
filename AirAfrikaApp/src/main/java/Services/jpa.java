package Services;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class jpa {
        private static jpa instance;

        private final EntityManagerFactory entityManagerFactory;

        private jpa(){
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }

        public static synchronized jpa getInstance(){
            return instance == null ? instance = new jpa() : instance ;
        }

        public void shutdown(){
            if(entityManagerFactory != null){
                entityManagerFactory.close();
                instance = null;
            }
        }

        public EntityManagerFactory getEntityManagerFactory() {
            return entityManagerFactory;
        }


}
