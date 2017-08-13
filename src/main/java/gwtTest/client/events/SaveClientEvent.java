package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SaveClientEvent extends GwtEvent<SaveClientEventHandler> {
    public static Type<SaveClientEventHandler> TYPE = new Type<SaveClientEventHandler>();

    public Type<SaveClientEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(SaveClientEventHandler handler) {
        handler.onSaveClient(this);
    }
}
