package chenyudan.enums;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2022/7/29 16:49
 */
public enum MediaType {

    X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded; charset=UTF-8"),
    JSON("application/json; charset=UTF-8"),
    ;

    private final String value;

    public String getValue() {
        return value;
    }

    MediaType(String value) {
        this.value = value;
    }


}
