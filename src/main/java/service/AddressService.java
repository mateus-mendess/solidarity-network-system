package service;

import dto.AddressDTO;

public class AddressService {

    public static Boolean addressValidate(AddressDTO addressDTO) throws Exception {
        if (! addressDTO.getCep().matches("^\\\\d{5}-\\\\d{3}$")) {
            throw new Exception();
        }

        if (! addressDTO.getStreet().matches("^[\\p{L}0-9\\.\\-\\s]{3,100}$")) {
            throw new Exception();
        }

        if (! addressDTO.getNeighborhood().matches("^[\\p{L}\\s]{2,50}$")) {
            throw new Exception();
        }

        if (! addressDTO.getCity().matches("^[\\p{L}\\s]{2,100}$")) {
            throw new Exception();
        }

        if (! addressDTO.getState().matches("^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$")) {
            throw new Exception();
        }

        return true;
    }
}
