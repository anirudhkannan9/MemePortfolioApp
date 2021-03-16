package ui;

import java.util.EventObject;

public class DetailEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    private String text;

    public DetailEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
