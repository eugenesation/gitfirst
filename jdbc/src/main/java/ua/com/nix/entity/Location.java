package ua.com.nix.entity;

public record Location(int id, String name) {

    public String getName() {
        return name;
    }

}
