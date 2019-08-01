package com.abc.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-17 12:53
 **/
public class ComparatorSort {
    public static void main(String[] args) {
        List<UserBean> list = new ArrayList<>();
        UserBean user1 = new UserBean("2", "张三", "男", 23);
        UserBean user2 = new UserBean("4", "李四", "男", 24);
        UserBean user3 = new UserBean("3", "王五", "男", 25);
        UserBean user4 = new UserBean("1", "马六", "男", 26);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        System.out.println("排序前数据");
        for (UserBean userBean : list) {
            System.out.println(userBean.toString());
        }
        System.out.println("排序后数据");
        // 调用排序方法，进行排序
        ComparatorSort.sortById(list);
        for (UserBean userBean : list) {
            System.out.println(userBean.toString());
        }
    }

    /**
     * 按照集合id升序排序
     *
     * @param list
     */
    public static void sortById(List<UserBean> list) {
        Collections.sort(list, new Comparator<UserBean>() {
            @Override
            public int compare(UserBean u1, UserBean u2) {
                String id1 = u1.getId();
                String id2 = u2.getId();
                if (Long.valueOf(id1).intValue() == 2) {
                    return -1;
                } else if (Long.valueOf(id1).intValue() == 1) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });
    }

}

/**
 * 用户pojo
 *
 * @author sunlh
 */
class UserBean {
    private String id;
    private String name;
    private String sex;
    private int age;

    public UserBean(String id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public UserBean() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + "]";
    }
}
