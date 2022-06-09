package hu.nye.progkor.aircondshop.model;

import java.util.Objects;

public class TermekLista {


    private Long id;
    private Marka marka;
    private String ar;
    private EnergiaBesorolas energiabesorolas;
    private String kiegeszitok;

    public TermekLista() {
    }

    public TermekLista(Long id, Marka marka, String ar, EnergiaBesorolas energiabesorolas, String kiegeszitok) {
        this.id = id;
        this.marka = marka;
        this.ar = ar;
        this.energiabesorolas = energiabesorolas;
        this.kiegeszitok = kiegeszitok;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public EnergiaBesorolas getEnergiabesorolas() {
        return energiabesorolas;
    }

    public void setEnergiabesorolas(EnergiaBesorolas energiabesorolas) {
        this.energiabesorolas = energiabesorolas;
    }

    public String getKiegeszitok() {
        return kiegeszitok;
    }

    public void setKiegeszitok(String kiegeszitok) {
        this.kiegeszitok = kiegeszitok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermekLista termekLista = (TermekLista) o;
        return Objects.equals(id, termekLista.id) && marka == termekLista.marka && Objects.equals(ar, termekLista.ar) && energiabesorolas == termekLista.energiabesorolas && Objects.equals(kiegeszitok, termekLista.kiegeszitok);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marka, ar, energiabesorolas, kiegeszitok);
    }

    @Override
    public String toString() {
        return "TermekLista{" +
                ", id=" + id +
                ", marka=" + marka +
                ", ar=" + ar +
                ", energiabesorolas= " + energiabesorolas +
                ", kiegeszitok=" + kiegeszitok +
                '}';

    }
}
