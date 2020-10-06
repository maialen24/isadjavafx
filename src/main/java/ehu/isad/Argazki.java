package ehu.isad;

public class Argazki {
    String izena;
    String argazkia;
    public Argazki(String pIzena, String pArgazkia) {
        izena=pIzena;
        argazkia=pArgazkia;
    }
    public String getFitx(){
        return argazkia;
    }
}
