//package com.company.GameStore.viewmodel;
//
//import com.company.GameStore.models.Games;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class GamesViewModel {
//
//    private int id;
//    private String title;
//    private String esrbRating;
//    private String description;
//    private BigDecimal price;
//    private String studio;
//    private int quantity;
//    private List<Games> games = new ArrayList<>();
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getEsrbRating() {
//        return esrbRating;
//    }
//
//    public void setEsrbRating(String esrbRating) {
//        this.esrbRating = esrbRating;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public String getStudio() {
//        return studio;
//    }
//
//    public void setStudio(String studio) {
//        this.studio = studio;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public List<Games> getGames() {
//        return games;
//    }
//
//    public void setGames(List<Games> games) {
//        this.games = games;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        GamesViewModel that = (GamesViewModel) o;
//        return id == that.id && quantity == that.quantity && Objects.equals(title, that.title) && Objects.equals(esrbRating, that.esrbRating) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(studio, that.studio) && Objects.equals(games, that.games);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, esrbRating, description, price, studio, quantity, games);
//    }
//}
