package gscrot.uploader.imgur;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

public class Imgur {
	
	public static final String CLIENT_ID = "e644a52e2191c66";

	public static String upload(BufferedImage image) throws Exception {
		URL url = new URL("https://api.imgur.com/3/image");
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		byte[] bImage = baos.toByteArray();
		String sImage = new BASE64Encoder().encode(bImage);
		String postdata = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(sImage, "UTF-8");

		uc.setDoOutput(true);
		uc.setDoInput(true);
		uc.setRequestMethod("POST");

		uc.setRequestProperty("Authorization", "Client-ID " + CLIENT_ID);

		uc.connect();
		OutputStreamWriter writer = new OutputStreamWriter(uc.getOutputStream());
		writer.write(postdata);
		writer.flush();

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String s = "";

		String line;
		
		while ((line = reader.readLine()) != null) {
			s += line + "\n";
		}
		
		writer.close();
		reader.close();

		return s.toString();
	}
}
