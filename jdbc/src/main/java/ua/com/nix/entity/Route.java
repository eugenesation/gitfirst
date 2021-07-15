package ua.com.nix.entity;

public record Route(int id, int fromId, int toId, int cost) {

    public int getFromId() {
        return fromId;
    }

    public int getToId() {
        return toId;
    }

    public int getCost() {
        return cost;
    }

}
