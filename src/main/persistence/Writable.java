package persistence;

//REFERENCE: modelled on JsonReaderTest class in JsonSerializationDemo project

import org.json.JSONObject;

//not a class, no class-level comment
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
