package utils;

public enum UserPermission {
    ADMIN("ADMIN", "Quản trị", 2),
    USER("USER", "Khách hàng", 1),
    GUEST("GUEST", "Khách", 0);
    private String code;
    private String name;
    private int priority;

    UserPermission(String code, String name, int priority) {
        this.code = code;
        this.name = name;
        this.priority = priority;
    }

    public static UserPermission getByCode(String code) {
        for (UserPermission u : values()) {
            if (u.code.equals(code)) {
                return u;
            }
        }
        return GUEST;
    }

    public static UserPermission getByName(String name) {
        for (UserPermission u : values()) {
            if (u.name.equals(name)) {
                return u;
            }
        }
        return GUEST;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int compare(UserPermission other) {
        return priority - other.priority;
    }

}
