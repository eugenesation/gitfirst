package ua.com.nix.entity;

public record Problem(int id, int fromId, int toId) {

    public int getId() {
        return id;
    }

    public int getFromId() {
        return fromId;
    }

    public int getToId() {
        return toId;
    }

}
