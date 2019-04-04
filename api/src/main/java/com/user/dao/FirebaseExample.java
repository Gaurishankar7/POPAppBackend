package com.user.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.opensymphony.xwork2.Action;

public class FirebaseExample {

	// Method to send Notifications from server to client end.
	public final static String AUTH_KEY_FCM = "AIzaSyC_2KFr9lMBBp6iy8QUCJKXB7dFrDWC_Ns";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	public final static String DEVICE_ID = "eui-Ih5ugo0:APA91bH1IM__-qeNGpSE_Vg-WuDgbqTqlpUiXiZUSp_QaF5fbGKQ_3y6pkPXZRIemhaJ4xcgfjIBlDVFnxOB706OKlTl3HJPi4H11njLZBySa7OORnGY8ULAorwK9BpqsPPdYg6tAApl";

	public String execute() {

		String DeviceIdKey = DEVICE_ID;
		String authKey = AUTH_KEY_FCM;
		String FMCurl = API_URL_FCM;

		try {

			URL url = new URL(FMCurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "key=" + authKey);
			conn.setRequestProperty("Content-Type", "application/json; UTF-8");
			System.out.println(DeviceIdKey);
			JSONObject data = new JSONObject();
			data.put("to", DeviceIdKey.trim());
			JSONObject info = new JSONObject();
			info.put("title", "POP_App Notification for orderSummary"); // Notification title
			info.put("body", "new order is placed...inline....please wait"); // Notification body
			data.put("notification", info);
			System.out.println(data.toString());
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data.toString());
			wr.flush();
			wr.close();

			int responseCode = conn.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println("Resonse: " + response);

			return Action.SUCCESS;

		} catch (Exception e) {

			System.out.println(e);
		}

		return Action.SUCCESS;
	}

	public static void main(String args[]) {
		FirebaseExample pushNotification = new FirebaseExample();
		pushNotification.execute();
	}
}