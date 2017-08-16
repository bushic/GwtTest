package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;
import gwtTest.client.dto.ContractDTO;

public class OpenContractEvent extends GwtEvent<OpenContractEventHandler> {
    public static Type<OpenContractEventHandler> TYPE = new Type<OpenContractEventHandler>();

    private final ContractDTO contractDTO;

    public OpenContractEvent(ContractDTO contractDTO) {
        this.contractDTO = contractDTO;
    }

    public Type<OpenContractEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(OpenContractEventHandler handler) {
        handler.onOpenContract(this);
    }

    public ContractDTO getContractDTO() {
        return contractDTO;
    }
}
