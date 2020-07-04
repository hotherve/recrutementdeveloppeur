package ch.ge.dcs.recrutementapp.model;

/**
 * Simple classe de sérialisation / désérialisation de Java <-> JSON
 */
public class SalleEvenementModel {

    // format de date : 2019-07-10T16:24:32
    public static final String TIMEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * string representant l'horodatage
     */
    private String time;
    /**
     * corps de l'evenement
     */
    private String event;
    /**
     * la référence de la salle
     */
    private String room_id;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "SalleEvenementModel{" +
                "time='" + time + '\'' +
                ", event='" + event + '\'' +
                ", room_id='" + room_id + '\'' +
                '}';
    }
}
