package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class OpenChooseClientViewEvent extends GwtEvent<OpenChooseClientViewEventHandler> {
    public static Type<OpenChooseClientViewEventHandler> TYPE = new Type<OpenChooseClientViewEventHandler>();

    public Type<OpenChooseClientViewEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(OpenChooseClientViewEventHandler handler) {
        handler.onOpenChooseClientView(this);
    }
}
