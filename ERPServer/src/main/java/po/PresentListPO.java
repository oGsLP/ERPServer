package po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "PresentList")
public class PresentListPO implements Serializable{
    /**
     * id
     */
    public int id;
    /**
     * 日期
     */
    String date;

    /**
     * 赠送商品
     */
    Set<PresentPO> set = new HashSet<>();


    /**
     * 操作员
     */
    String operator;

    /**
     * 客户
     */
    String client;

    /**
     * 状态
     */
    String state;

    public PresentListPO() {
    }

    public PresentListPO(int id, String date, Set<PresentPO> set, String operator, String client) {
        this.id = id;
        this.date = date;
        this.set = set;
        this.operator = operator;
        this.client = client;
    }

    public PresentListPO(int id, String date, Set<PresentPO> set, String operator, String client, String state) {
        this.id = id;
        this.date = date;
        this.set = set;
        this.operator = operator;
        this.client = client;
        this.state = state;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<PresentPO> getSet() {
        return set;
    }

    public void setSet(Set<PresentPO> set) {
        this.set = set;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
