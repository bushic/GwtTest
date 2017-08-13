package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class CreateClientEvent extends GwtEvent<CreateClientEventHandler> {
    public static Type<CreateClientEventHandler> TYPE = new Type<CreateClientEventHandler>();

    public Type<CreateClientEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(CreateClientEventHandler handler) {
        handler.onCreateClient(this);
    }
}
