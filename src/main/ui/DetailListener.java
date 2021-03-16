package ui;

import java.util.EventListener;

public interface DetailListener extends EventListener {
    public void detailEventOccurred(DetailEvent de);
}
