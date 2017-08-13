package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class EditClientEvent extends GwtEvent<EditClientEventHandler> {
    public static Type<EditClientEventHandler> TYPE = new Type<EditClientEventHandler>();
    private final String id;

    public EditClientEvent(String id) {
        this.id = id;
    }

    public Type<EditClientEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(EditClientEventHandler handler) {
        handler.onEditClient(this);
    }
}
