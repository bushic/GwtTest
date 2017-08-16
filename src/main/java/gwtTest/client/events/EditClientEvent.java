package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class EditClientEvent extends GwtEvent<EditClientEventHandler> {
    public static Type<EditClientEventHandler> TYPE = new Type<EditClientEventHandler>();

    public Type<EditClientEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(EditClientEventHandler handler) {
        handler.onEditClient(this);
    }
}
