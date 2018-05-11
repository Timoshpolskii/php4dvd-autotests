package dataObjets;

public enum UserRole {
    ADMIN("admin"),
    GUEST("guest"),
    INCORRECT("incorrect");
    String key;
    UserRole(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
}
