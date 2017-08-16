package gwtTest.client.events;

import com.google.gwt.event.shared.GwtEvent;
import gwtTest.client.dto.ContractDTO;

public class CreateContractEvent extends GwtEvent<CreateContractEventHandler> {
    public static Type<CreateContractEventHandler> TYPE = new Type<CreateContractEventHandler>();

    private final ContractDTO contractDTO;

    public CreateContractEvent(ContractDTO contractDTO) {
        this.contractDTO = contractDTO;
    }

    public Type<CreateContractEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(CreateContractEventHandler handler) {
        handler.onCreateContract(this);
    }

    public ContractDTO getContractDTO() {
        return contractDTO;
    }
}
