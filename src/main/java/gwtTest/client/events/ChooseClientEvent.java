package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class ChooseClientEvent extends GwtEvent<ChooseClientEventHandler> {
    public static Type<ChooseClientEventHandler> TYPE = new Type<ChooseClientEventHandler>();

    private final String id;

    public ChooseClientEvent(String id) {
        this.id = id;
    }

    public Type<ChooseClientEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ChooseClientEventHandler handler) {
        handler.onChooseClient(this);
    }
}
