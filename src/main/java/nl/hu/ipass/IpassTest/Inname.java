package nl.hu.ipass.IpassTest;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Inname {
    private LocalDate date;
    private Time time;
    private double dosis;
    private Medicatie medicatie;

    public Inname(LocalDate dat, Time tim, double dos, Medicatie med){
    this.date = dat;
    this.time = tim;
    this.dosis = dos;
    this.medicatie = med;
    }

    public Time getTime() {
        return time;
    }

    public double getDosis() {
        return dosis;
    }

    public LocalDate getDate() {
        return date;
    }

    public Medicatie getMedicatie(){return medicatie;}

    @Override
    public String toString() {
        return "Inname{" +
                ", date=" + date +
                ", time=" + time +
                ",  dosis=" + dosis +
                ",  medicatie=" + medicatie +
                "}";
    }
}
