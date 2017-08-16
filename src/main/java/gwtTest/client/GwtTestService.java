package gwtTest.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;

import java.util.ArrayList;
import java.util.List;

@RemoteServiceRelativePath("GwtTestService")
public interface GwtTestService extends RemoteService {

    String saveClient(ClientDTO client);
    String calculateBonus(ContractDTO contractDTO);
    List<ContractDTO> getContracts();
    List<ClientDTO> getClients(String surName, String firstName, String middleName);
    String saveContract(ContractDTO contract);
}
