package Model;

import com.blueeagle.realm.MainActivity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class Contact extends RealmObject {
    private int Id;
    private String fullName;
    private String phone;
    private String email;

    @Ignore
    private Logger logger = LoggerFactory.getLogger(Contact.class);

    public Contact() {
        this.Id = getNextID();
        this.fullName = "Nguyen Van Tuan";
        this.phone = "0968 730 184";
        this.email = "Nguyenvantuan.itus@gmail.com";
    }

    public Contact(String fullName, String phone, String email) {
        this.Id = getNextID();
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;

        logger.debug("Created new contact.");
        logger.info("Created new contact.");
    }

    public int getNextID() {
        int key = 1;
        Realm realm = Realm.getInstance(MainActivity.realmConfiguration);
        try {
            key = realm.where(Contact.class).max("Id").intValue() + 1;
        } catch (Exception e) {
            logger.error("Get new contact id: " + e.getMessage());
        }

        return key;
    }

    public int getId() {
        return Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
