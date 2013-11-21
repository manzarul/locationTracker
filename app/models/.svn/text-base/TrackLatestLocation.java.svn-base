/**
 * 
 */
package models;

import java.util.ArrayList;
import java.util.List;

import util.DateUtil;

/**
 * this class contains lasted device location based on device id and all unique
 * track id for that device id.
 * 
 * @author Manzarul.Haque
 * 
 */
public class TrackLatestLocation {
	List<Track> track = new ArrayList<Track>();
    Live live ;

    /**
	 * @return the live
	 */
	public Live getLive() {
		return live;
	}

	/**
	 * @param live the live to set
	 */
	public void setLive(Live live) {
		this.live = live;
	}

	/**
	 * @return the track
	 */
	public List<Track> getTrack() {
		return track;
	}

	/**
	 * @param track
	 *            the track to set
	 */
	public void setTrack(List<Track> track) {
		this.track = track;
	}

	public class Live {
		String latLong;
		String time;

		/**
		 * @return the latLong
		 */
		public String getLatLong() {
			return latLong;
		}

		/**
		 * @param latLong
		 *            the latLong to set
		 */
		public void setLatLong(String latLong) {
			this.latLong = latLong;
		}

		/**
		 * @return the time
		 */
		public String getTime() {
			return  DateUtil.getSqlTimeStamp(DateUtil.convertStringToDate(time));
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(String time) {
			this.time =  DateUtil.getSqlTimeStamp(DateUtil.convertStringToDate(time));;
		}

	}

	public class Track {
		String trackId;
		String time;

		/**
		 * @return the trackId
		 */
		public String getTrackId() {
			return trackId;
		}

		/**
		 * @param trackId
		 *            the trackId to set
		 */
		public void setTrackId(String trackId) {
			this.trackId = trackId;
		}

		/**
		 * @return the time
		 */
		public String getTime() {
			return DateUtil.getSqlTimeStamp(DateUtil.convertStringToDate(time));
		}

		/**
		 * @param time
		 *            the time to set
		 */
		public void setTime(String time) {
			this.time =  DateUtil.getSqlTimeStamp(DateUtil.convertStringToDate(time));
		}
	}

}
