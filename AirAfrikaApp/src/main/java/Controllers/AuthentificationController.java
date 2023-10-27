package Controllers;

import Dao.Imple.AdminDao;
import Dao.Imple.ClientDao;
import Entity.Admins;
import Entity.Clients;
import Services.hash;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.Objects;

public class AuthentificationController {
    public AuthentificationController() {

    }

    public static Admins isAdminAuth(String email, String password){
        for (Admins admin: new AdminDao().all()){
            if(Objects.equals(admin.getEmail(), email) && Objects.equals(admin.getPassword(), password)){
                return admin;
            }
        }
        return null;
    }

    public static Clients isClientAuth(String email, String password){
        for (Clients client: new ClientDao().all()){
            if(Objects.equals(client.getEmail(), email) && hash.verifiedPassword(client.getPassword(), password)){
                return client;
            }
        }
        return null;
    }



}
