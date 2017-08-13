package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class OpenContractListEvent extends GwtEvent<OpenContractListEventHandler> {
    public static Type<OpenContractListEventHandler> TYPE = new Type<OpenContractListEventHandler>();

    public Type<OpenContractListEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(OpenContractListEventHandler handler) {
        handler.onOpenContractList(this);
    }
}
