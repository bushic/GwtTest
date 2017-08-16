package gwtTest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;

import java.util.ArrayList;
import java.util.List;

public interface GwtTestServiceAsync {
    void saveClient(ClientDTO client, AsyncCallback<String> async);

    void calculateBonus(ContractDTO contractDTO, AsyncCallback<String> async);

    void getContracts(AsyncCallback<List<ContractDTO>> async);

    void getClients(String surName, String firstName, String middleName, AsyncCallback<List<ClientDTO>> async);

    void saveContract(ContractDTO contract, AsyncCallback<String> async);
}
