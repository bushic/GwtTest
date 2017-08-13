package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class OpenContractEvent extends GwtEvent<OpenContractEventHandler> {
    public static Type<OpenContractEventHandler> TYPE = new Type<OpenContractEventHandler>();

    public Type<OpenContractEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(OpenContractEventHandler handler) {
        handler.onOpenContract(this);
    }
}
