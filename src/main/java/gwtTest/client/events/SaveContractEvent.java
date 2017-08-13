package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SaveContractEvent extends GwtEvent<SaveContractEventHandler> {
    public static Type<SaveContractEventHandler> TYPE = new Type<SaveContractEventHandler>();

    public Type<SaveContractEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(SaveContractEventHandler handler) {
        handler.onSaveContract(this);
    }
}
