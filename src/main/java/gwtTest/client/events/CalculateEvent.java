package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class CalculateEvent extends GwtEvent<CalculateEventHandler> {
    public static Type<CalculateEventHandler> TYPE = new Type<CalculateEventHandler>();

    public Type<CalculateEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(CalculateEventHandler handler) {
        handler.onCalculate(this);
    }
}
