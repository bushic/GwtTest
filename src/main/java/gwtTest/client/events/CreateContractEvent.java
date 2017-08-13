package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class CreateContractEvent extends GwtEvent<CreateContractEventHandler> {
    public static Type<CreateContractEventHandler> TYPE = new Type<CreateContractEventHandler>();

    public Type<CreateContractEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(CreateContractEventHandler handler) {
        handler.onCreateContract(this);
    }
}
