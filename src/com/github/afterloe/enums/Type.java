package com.github.afterloe.enums;

/**
 * Created by afterloe on 4/26/2017.
 */
public enum  Type {

    MEAT("肉类" , 0),
    FISH("鱼类" , 1),
    FRUITS("水果类" , 2),
    VEGETABLES("蔬菜类" , 3),
    OTHER("其他" , 4);

    private String name;
    private int index;

    /**
     * 构造函数
     *
     * @param name
     * @param index
     */
    private Type(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
