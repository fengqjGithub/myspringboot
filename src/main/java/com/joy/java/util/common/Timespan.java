package com.joy.java.util.common;
/**
 * 时间的间隙类。(两个时间之间的间隔。)
 * 主要用来得到这个时间间隙换算为分钟、小时等。
 */
public class Timespan {
	
	private long milliseconds=0;

	/**
	 * 功能：构造函数。
	 * @param milliseconds 毫秒。
	 */
	public Timespan(long milliseconds) {
		this.milliseconds=milliseconds;
	}
	
	/**
	 * 功能：时间间隙的总天数。（会强制取整，即求模）
	 * @return int
	 */
	public int totalDays(){
		return totalHours()/24;
	}
	
	/**
	 * 功能：时间间隙的总小时数。（会强制取整，即求模）
	 * @return int
	 */
	public int totalHours(){
		return totalMinutes()/60;
	}
	
	/**
	 * 功能：时间间隙的总分钟数。（会强制取整，即求模）
	 * @return int
	 */
	public int totalMinutes(){
		return totalSeconds()/60;
	}
	
	/**
	 * 功能：时间间隙的总秒数。（会强制取整，即求模）
	 * @return int
	 */
	public int totalSeconds(){
		return new Long(milliseconds/1000).intValue();
	}
	
	/**
	 * 功能：时间间隙的总毫秒数。
	 * @return long
	 */
	public long totalMilliseconds(){
		return milliseconds;
	}
	
	/**
	 * 功能：转成多少小时 分钟 秒。
	 * @return long
	 */
	public int[] totalHourMinSecond(){
		//得到小时
		int hours=totalHours();
		//得到分钟
		int min=new Timespan(this.milliseconds-(hours*3600000)).totalMinutes();
		//得到秒
		int sec=new Timespan(this.milliseconds-(hours*3600000)-(min*60000)).totalSeconds();
		return new int[]{hours,min,sec};
	}

}
