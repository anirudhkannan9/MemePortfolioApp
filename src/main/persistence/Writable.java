package persistence;

//REFERENCE: modelled on JsonReaderTest class in JsonSerializationDemo project

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
