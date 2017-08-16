package gwtTest.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import gwtTest.client.GwtTestService;
import gwtTest.client.dto.ClientDTO;
import gwtTest.client.dto.ContractDTO;
import gwtTest.shared.ClientsEntity;
import gwtTest.shared.ContractsEntity;
import org.hibernate.Session;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GwtTestServiceImpl extends RemoteServiceServlet implements GwtTestService {

    public String saveClient(ClientDTO clientDTO) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ClientsEntity clientsEntity = new ClientsEntity(clientDTO);
        if (clientsEntity.getId() == 0)
            session.save(clientsEntity);
        else session.update(clientsEntity);

        session.getTransaction().commit();

        return "ok";
    }

    public String calculateBonus(ContractDTO contractDTO) {
        if (contractDTO == null)
            return "false";
        double kType = 0, kYear = 0, kSquare = 0;
        int year = 0;
        if (!contractDTO.getConstructionyear().equals(""))
            year = Integer.valueOf(contractDTO.getConstructionyear());
        double square = 0;
        if (!contractDTO.getSquare().equals(""))
            square = Double.valueOf(contractDTO.getSquare());
        if (contractDTO.getPropertytype().equals("Квартира")){
            kType = 1.7;
        } else if (contractDTO.getPropertytype().equals("Дом")){
            kType = 1.5;
        } else if (contractDTO.getPropertytype().equals("Комната")){
            kType = 1.3;
        }

        if (year < 2000){
            kYear = 1.3;
        } else if (year >= 2000 && year < 2015){
            kYear = 1.7;
        } else if (year == 2015){
            kYear = 2;
        }

        if (square < 50){
            kSquare = 1.2;
        } else if (square >= 50 && square < 101){
            kSquare = 1.5;
        } else if (square > 100){
            kSquare = 2;
        }

        long start = contractDTO.getDatestart().getTime();
        long finish = contractDTO.getDatefinish().getTime();
        long days = (finish - start) / 1000 / 3600 / 24;

        double bonus = (1.0 * contractDTO.getSum() / days) * kSquare * kType * kYear;
        if (bonus < 0)
            return "0";

        return String.format(new Locale("ru"), "%(.2f", bonus);
    }

    public List<ContractDTO> getContracts() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<ContractsEntity> contracts = new ArrayList<ContractsEntity>(session.createQuery(
                "from ContractsEntity").list());
        List<ContractDTO> contractDTOS = new ArrayList<ContractDTO>();
        if (contracts != null) {
            for (ContractsEntity contract : contracts) {
                contractDTOS.add(createContractDTO(contract));
            }
        }
        session.getTransaction().commit();
        return contractDTOS;
    }

    public List<ClientDTO> getClients(String surName, String firstName, String middleName) {

        String query = "from ClientsEntity where";
        boolean fSurName = surName.equals(""),fFirstName = firstName.equals(""), fMiddleName = middleName.equals("");
        if (!fSurName){
            query += " surname = '" + surName + "' and";
        }
        if (!fFirstName) {
            query += " firstname = '" + firstName + "' and";
        }
        if (!fMiddleName) {
            query += " middlename = '" + fMiddleName + "' and";
        }
        if (fFirstName && fMiddleName && fSurName){
            query = query.substring(0, query.length()-5);
        } else if (fFirstName || fMiddleName || fSurName){
            query = query.substring(0, query.length()-4);
        }
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<ClientsEntity> clients = new ArrayList<ClientsEntity>(session.createQuery(
                query).list());
        List<ClientDTO> clientDTOS = new ArrayList<ClientDTO>();
        if (clients != null) {
            for (ClientsEntity client : clients) {
                clientDTOS.add(createClientDTO(client));
            }
        }
        session.getTransaction().commit();
        return clientDTOS;
    }

    public String saveContract(ContractDTO contract) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "from ContractsEntity where number=" + contract.getNumber();

        List<ContractsEntity> contracts = new ArrayList<ContractsEntity>(session.createQuery(
                query).list());

        if (contracts.size() != 0 && contract.getId() == 0) {
            return "Договор с таким номером уже существует";
        }

        ContractsEntity contractsEntity = null;
        if (contracts.size() != 0) {
            contractsEntity = contracts.get(0);
            contractsEntity.update(contract);
        }
        else contractsEntity = new ContractsEntity(contract);

        if (contractsEntity.getId() == 0)
            session.save(contractsEntity);
        else session.update(contractsEntity);

        session.getTransaction().commit();

        return "Договор сохранен";
    }

    private ClientDTO createClientDTO(ClientsEntity client) {
        return new ClientDTO(client.getId(),client.getSurname(),client.getFirstname(),client.getMiddlename(),
                client.getBirthday(),client.getPassportseries(),client.getPassportnumber());
    }

    private ContractDTO createContractDTO(ContractsEntity contract) {
        ClientsEntity clientsEntity = contract.getClientsByClient();
        ClientDTO clientDTO = new ClientDTO(clientsEntity.getId(),clientsEntity.getSurname(),clientsEntity.getFirstname(),
                clientsEntity.getMiddlename(),clientsEntity.getBirthday(),clientsEntity.getPassportseries(),
                clientsEntity.getPassportnumber());
        return new ContractDTO(contract.getId(), contract.getSum(), contract.getDatestart(), contract.getDatefinish(),
                contract.getPropertytype(),contract.getConstructionyear(),contract.getSquare(),
                contract.getCalculatedate(),contract.getBonus(),contract.getNumber(),contract.getContractdate(),
                contract.getCountry(),contract.getIndex(),contract.getRepublic(),contract.getArea(),
                contract.getLocality(),contract.getStreet(),contract.getHouse(),contract.getHousing(),
                contract.getBuilding(),contract.getFlat(),contract.getComment(),clientDTO.getId(), clientDTO);
    }

}