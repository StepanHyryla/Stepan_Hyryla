import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import javax.swing.JOptionPane;
import org.json.*;
import org.junit.Test;



import static org.junit.Assert.*;

public class DropboxTest {

    public static void main(String args[]){

    }
    
    private final String oauth_key = "wZZQsVT3UFoAAAAAAAAAAVHYxjLQUSCa56IleSYG3G6JZF0ueKrSnqjt4YOmkHfC";

    // Uploading new file
    
    public JSONObject UploadFile(){
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response1 = Unirest.post("https://content.dropboxapi.com/2/files/upload")
                    .header("Dropbox-API-Arg", "{\"path\": \"/NewFile.txt\","
                    		+ "\"mode\": \"add\",\"autorename\": true,\"mute\": false,\"strict_conflict\": false}")
                    .header("Content-Type", " application/octet-stream")
                    .header("Authorization", "Bearer "+oauth_key)
                    .body("<file contents here>")
                    .asJson();

            return response1.getBody().getObject();
        }
        catch (UnirestException error){
            JOptionPane.showMessageDialog(null, "ERROR: " + error);
            error.printStackTrace();
            return null;
        }
    }
      
    // Getting metadata
    
    public JSONObject GetMetadata(){
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response2 = Unirest.post("https://api.dropboxapi.com/2/files/get_metadata")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer "+oauth_key)
                    .body("{\r\n    \"path\": \"/NewFile.txt\",\r\n    \"include_media_info\": false,"
                    		+ "\r\n    \"include_deleted\": false,\r\n    \"include_has_explicit_shared_members\": false\r\n}")
                    .asJson();

            return response2.getBody().getObject();
        }catch (UnirestException error){
            JOptionPane.showMessageDialog(null, "ERROR: " + error);
            error.printStackTrace();
            return null;
        }
    }

    
    // Deleting file
    
    public JSONObject DeleteFile(){
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response3 = Unirest.post("https://api.dropboxapi.com/2/files/delete_v2")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer "+oauth_key)
                    .body("{\r\n    \"path\": \"/NewFile.txt\"\r\n}")
                    .asJson();

            return  response3.getBody().getObject();
        }catch (UnirestException error){
            JOptionPane.showMessageDialog(null, "ERROR: " + error);
            error.printStackTrace();
            return null;
        }
    }

    @Test
    public void testUpload() {
        // Checking if file exist
        assertNotNull(UploadFile().has("name"));
    }

    @Test
    public void testGetMetaData(){
        // Checking if metadata exist
        assertTrue(GetMetadata().has("name"));
    }

    @Test
    public void testDelete() {
        // When we delete file, we receive a JSON file with key "metadata", 
    	//so we check if such file exist and compare it with information given from GetMetadata() 
        assertTrue(DeleteFile().has("metadata"));
        if (DeleteFile().has("metadata")) {
            assertEquals(GetMetadata(), DeleteFile().getString("metadata"));
        }
    }

}
