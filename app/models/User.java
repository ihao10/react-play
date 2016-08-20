package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;


@Entity
@Indexes(
        @Index(value = "account", fields = @Field("account"))
)
public class User {

    @Id
    private ObjectId id;

    private String account;

    private String password;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
