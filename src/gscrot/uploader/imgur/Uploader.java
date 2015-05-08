package gscrot.uploader.imgur;

import iconlib.IconUtils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.redpois0n.gscrot.Capture;
import com.redpois0n.gscrot.CaptureUploader;
import com.redpois0n.gscrot.UploadResponse;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Imgur", IconUtils.getIcon("imgur", Uploader.class));
	}

	@Override
	public UploadResponse process(Capture capture) throws Exception {
		String response = Imgur.upload(capture.getBinary());
		
		JSONObject jo = (JSONObject) JSONValue.parse(response);
		
		if (!jo.get("success").toString().equalsIgnoreCase("true")) {
			throw new Exception(jo.get("status").toString());
		}
		
		JSONObject data = (JSONObject) jo.get("data");
		Object link = data.get("link");
		Object delhash = data.get("deletehash");
		
		if (link != null && delhash != null) {
			String rmlink = "https://imgur.com/delete/" + delhash;
			
			UploadResponse ur = new UploadResponse(link.toString().replace("http://", "https://"), rmlink);
			ur.setRaw(response);
			
			return ur;
		} else {
			throw new Exception("Error: " + response);
		}
	}

}
