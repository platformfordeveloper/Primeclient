package prime.com.primeclient.controllers.core.resources;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import prime.com.primeclient.models.core.SignUpModel;

/**
 * Created by BrahmaRishi on 27/01/17.
 */

public class Support {
    public String toJson(Object tojson) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(tojson);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
