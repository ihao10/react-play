package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
@Indexes(
        @Index(value = "menuId", fields = @Field("menuId"), options = @IndexOptions(unique = true))
)

public class Menu {

    @Id
    private ObjectId id;

    /**
     * 唯一菜单id
     */
    private int menuId;

    /**
     * 菜单名字
     */
    private String name;
    /**
     * 跳转值
     */
    private String value;

    /**
     * 菜单类型，0主菜单，1辅菜单
     */
    private int type;


    public Menu(int menuId, String name, String value, int type) {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
