package ua.com.nix.entity;

public record Solution(int id, int cost) {

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

}
