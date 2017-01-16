package pl.edu.pb.wi.sbd.controllers.models;

/**
 * Created by Radosław Naruszewicz on 2017-01-16.
 */
public enum TypeUser {
    BREEDING("HODOWLA"), LOVER("MIŁOŚNIK"), CONTROL("ZARZĄD");
    private final String type;

    TypeUser(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
