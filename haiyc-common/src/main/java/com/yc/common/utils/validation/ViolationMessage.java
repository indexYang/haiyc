package com.yc.common.utils.validation;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author
 * @date 2020年10月30日
 */
public class ViolationMessage implements Serializable {

    private static final long serialVersionUID = -2054757648176115578L;
    private String property;
    private String message;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
