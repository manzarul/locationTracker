package controllers;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import models.LocationTrack;
import models.TrackLatestLocation;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Constants;
import util.DateUtil;
import util.JsonKey;
import util.ResponseCode;
import util.TrackLogger;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

/**
 * 
 * @author Manzarul.Haque
 *
 */
public class Application extends Controller {
     
	private static Application application = null;
	  
	static {
		application = new Application();
	}
	
	/**
	 * 
	 * @return
	 */
	public static Result saveTrack() {
		ObjectNode response = Json.newObject();
		JsonNode json = request().body().asJson();
		String deviceId = "";
		String trackId = "" ;
		String latlong = "";
		boolean isArray = false;
		JsonNode driverIdsArray = null;
		try {
			deviceId = json.get(JsonKey.DEVICEID).asText();
			trackId = json.get(JsonKey.TRACKID).asText();
			isArray = json.get(JsonKey.isArray).asBoolean();
			if (isArray) {
				driverIdsArray = json.get(JsonKey.Array);
			} else {
				latlong = json.get(JsonKey.LATLONG).asText();
			}
		} catch (Exception e) {
			TrackLogger.error(""+e, application);
			return ok(Constants.InvalidDataResponse());
		}
		if (!isArray) {
			LocationTrack location = new LocationTrack();
			location.setDeviceId(deviceId);
			location.setLatLong(latlong);
			location.setTimestamp(new Timestamp(new Date().getTime()));
			location.setTrackId(trackId+deviceId);
			Ebean.save(location);
		} else {
			for (int i = 0; i < driverIdsArray.size(); i++) {
				LocationTrack location = new LocationTrack();
				location.setDeviceId(deviceId);
				JsonNode latlongTime = driverIdsArray.get(i);
				String time = latlongTime.get(JsonKey.TIMESTAMP).asText();
				latlong = latlongTime.get(JsonKey.LATLONG).asText();
				location.setLatLong(latlong);
				location.setTrackId(trackId+deviceId);
				try {
					location.setTimestamp(new Timestamp(DateUtil
							.getDateInDefaultTimeZone(time).getTime()));
				} catch (Exception e) {
					TrackLogger.error(""+e, application);
				}
				Ebean.save(location);
			}
		}
		response.put(JsonKey.STATUSCODE, ResponseCode.Success.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE, ResponseCode.Success.getErrorMessage());
		response.put(JsonKey.RESPONSEDATA, "");
		return ok(response);
	}
  
	/**
	 * 
	 * @return
	 */
	public static Result getTrack() {
		ObjectNode response = Json.newObject();
		JsonNode json = request().body().asJson();
		String deviceId = "";
		long trackId = 0l;
		String fromDate = null;
		String toDate = null;
		try {
			deviceId = json.get(JsonKey.DEVICEID).asText();
			trackId = json.get(JsonKey.TRACKID).asLong();
			fromDate = json.get(JsonKey.FROMDATE).asText();
			toDate = json.get(JsonKey.TODATE).asText();
		} catch (Exception e) {
			TrackLogger.error(""+e, application);
			return ok(Constants.InvalidDataResponse());
		}
		List<LocationTrack> location = new ArrayList<LocationTrack>();
		if (fromDate == null && trackId == 0) {
			location = Ebean.createQuery(LocationTrack.class).where()
					.eq("device_id", deviceId).findList();
		} else if (fromDate != null && toDate == null) {
			location = Ebean.createQuery(LocationTrack.class).where()
					.eq("device_id", deviceId).gt("created_time", fromDate)
					.findList();
		} else if (fromDate != null && toDate != null) {
			location = Ebean.createQuery(LocationTrack.class).where()
					.eq("device_id", deviceId).gt("created_time", fromDate)
					.le("created_time", toDate).findList();
		} else if (fromDate == null && trackId > 0) {
			location = Ebean.createQuery(LocationTrack.class).where()
					.eq("device_id", deviceId).eq("track_id", trackId)
					.findList();
		}
		response.put(JsonKey.STATUSCODE, ResponseCode.Success.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE, ResponseCode.Success.getErrorMessage());
		response.put(JsonKey.RESPONSEDATA, Json.toJson(location));
		return ok(response);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Result getAllTrackByDate() {
		ObjectNode response = Json.newObject();
		JsonNode json = request().body().asJson();
		String fromDate = null;
		String toDate = null;
		try {
			fromDate = json.get(JsonKey.FROMDATE).asText();
			toDate = json.get(JsonKey.TODATE).asText();
		} catch (Exception e) {
			TrackLogger.error(""+e, application);
			return ok(Constants.InvalidDataResponse());
		}
		List<LocationTrack> location = new ArrayList<LocationTrack>();
	   if (fromDate != null && toDate == null) {
			location = Ebean.createQuery(LocationTrack.class).where().gt("created_time", fromDate)
					.findList();
		} else if (fromDate != null && toDate != null) {
			location = Ebean.createQuery(LocationTrack.class).where().gt("created_time", fromDate)
					.le("created_time", toDate).findList();
		} else if (fromDate == null && toDate == null) {
			location = Ebean.createQuery(LocationTrack.class).findList();
		}
	   response.put(JsonKey.STATUSCODE, ResponseCode.Success.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE, ResponseCode.Success.getErrorMessage());
		response.put(JsonKey.RESPONSEDATA, Json.toJson(location));
		return ok(response);
	}
	
	
	
	/**
	 * this method will return all unique device id.
	 * @return
	 */
	public static Result getallDeviceId() {
		ObjectNode response = Json.newObject();
		SqlQuery  query  = Ebean.createSqlQuery("select id,device_id,track_id,lat_long,created_time from location_track group by device_id");
		List<SqlRow> rows = query.findList();
		Iterator<SqlRow> itr = rows.iterator();
		List<LocationTrack> locationTracks  = new ArrayList<LocationTrack>();
		while (itr.hasNext()) {
			LocationTrack locationTrack = new LocationTrack();
			SqlRow row = itr.next();
			locationTrack.setDeviceId(row.getString("device_id"));
			locationTrack.setId(row.getLong("id"));
			locationTrack.setLatLong(row.getString("lat_long"));
			locationTrack.setTimestamp(row.getTimestamp("created_time"));
			locationTrack.setTrackId(row.getString("track_id"));
			locationTracks.add(locationTrack);
		}
		response.put(JsonKey.STATUSCODE, ResponseCode.Success.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE, ResponseCode.Success.getErrorMessage());
		response.put(JsonKey.RESPONSEDATA, Json.toJson(locationTracks));
		return ok(response);
	}
	
	
	/**
	 * this method will return all unique track id and 
	 * last known lat long based on device id.
	 * @param deviceId
	 * @return
	 */
	public static Result getLastLocationAndAllUniquetrackId(String  deviceId) {
		ObjectNode response = Json.newObject();
		SqlQuery query = Ebean
				.createSqlQuery("SELECT lat_long,created_time FROM location_track WHERE device_id=? ORDER BY created_time  DESC  LIMIT 1");
		query.setParameter(1, deviceId);
		List<SqlRow> rows = query.findList();
		Iterator<SqlRow> itr = rows.iterator();
		TrackLatestLocation latestLocation = new TrackLatestLocation();
		while (itr.hasNext()) {
			TrackLatestLocation.Live live = new TrackLatestLocation().new Live();
			SqlRow row = itr.next();
			live.setLatLong(row.getString("lat_long"));
			live.setTime(row.getString("created_time"));
			latestLocation.setLive(live);
		}
		SqlQuery trackInfo = Ebean
				.createSqlQuery("SELECT track_id,created_time FROM location_track WHERE device_id=? GROUP BY track_id ORDER BY created_time DESC");
		trackInfo.setParameter(1, deviceId);
		List<SqlRow> sqltrackInfo = trackInfo.findList();
		Iterator<SqlRow> itrIterator = sqltrackInfo.iterator();
		List<TrackLatestLocation.Track> tracks = new ArrayList<TrackLatestLocation.Track>();
		while (itrIterator.hasNext()) {
			TrackLatestLocation.Track track = new TrackLatestLocation().new Track();
			SqlRow row = itrIterator.next();
			track.setTrackId(row.getString("track_id"));
			track.setTime(row.getString("created_time"));
			tracks.add(track);
		}
		latestLocation.setTrack(tracks);
		response.put(JsonKey.STATUSCODE, ResponseCode.Success.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE,
				ResponseCode.Success.getErrorMessage());
		response.put(JsonKey.RESPONSEDATA, Json.toJson(latestLocation));
		return ok(response);
	}
 
	
	/**
	 * this method will return all lat long and created time 
	 * based on trackId
	 * @param trackId
	 * @return
	 */
	public static Result getAllLocationByTrackId(String trackId ) {
		ObjectNode response = Json.newObject();
		SqlQuery query = Ebean
				.createSqlQuery("SELECT lat_long,created_time FROM location_track WHERE track_id=?  ORDER BY created_time DESC");
		query.setParameter(1, trackId);
		List<SqlRow> rows = query.findList();
		Iterator<SqlRow> itr = rows.iterator();
		TrackLatestLocation allLocation = new TrackLatestLocation();
		List<TrackLatestLocation.Track> tracks = new ArrayList<TrackLatestLocation.Track>();
		while (itr.hasNext()) {
			TrackLatestLocation.Track track = new TrackLatestLocation().new Track();
			SqlRow row = itr.next();
			track.setTrackId((row.getString("lat_long")));
			track.setTime(row.getString("created_time"));
			tracks.add(track);
		}
		allLocation.setTrack(tracks);
		response.put(JsonKey.STATUSCODE, ResponseCode.Success.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE,
				ResponseCode.Success.getErrorMessage());
		response.put(JsonKey.RESPONSEDATA, Json.toJson(allLocation));
		return ok(response);
	}
	
	
}
