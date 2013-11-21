/**
 * 
 */
package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import play.db.ebean.Model;
import util.DateUtil;

/**
 * @author Manzarul.Haque
 *
 */
@Entity(name="location_track")
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"device_id","track_id"})})
public class LocationTrack  extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public long id;
	@Column(name="device_id")
	public String deviceId;
	@Column(name="track_id")
	public String  trackId ;
	@Column(name="lat_long")
	public String latLong;
	@Column(name="created_time")
	public Timestamp timestamp;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the trackId
	 */
	public String getTrackId() {
		return trackId;
	}
	/**
	 * @param trackId the trackId to set
	 */
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	/**
	 * @return the latLong
	 */
	public String getLatLong() {
		return latLong;
	}
	/**
	 * @param latLong the latLong to set
	 */
	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return DateUtil.getSqlTimeStamp(timestamp.getTime());
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}
