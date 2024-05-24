package com.Web;



public class Description 
{
    private String todaydate;
    private String description;
    private int intimehour;
    private int intimeminute;
    private int outtimehour;
    private int outtimeminute;
    private int durationhour;
    private int durationminute;

    public Description() {
    }

    public Description(String todaydate, String description, int intimehour, int intimeminute, int outtimehour, int outtimeminute) {
        this.todaydate = todaydate;
        this.description = description;
        this.intimehour = intimehour;
        this.intimeminute = intimeminute;
        this.outtimehour = outtimehour;
        this.outtimeminute = outtimeminute;
    }

    public Description(String todaydate, String description, int intimehour, int intimeminute, int outtimehour, int outtimeminute, int durationhour, int durationminute) {
        this.todaydate = todaydate;
        this.description = description;
        this.intimehour = intimehour;
        this.intimeminute = intimeminute;
        this.outtimehour = outtimehour;
        this.outtimeminute = outtimeminute;
        this.durationhour = durationhour;
        this.durationminute = durationminute;
    }

    public String getTodaydate() {
        return todaydate;
    }

    public void setTodaydate(String todaydate) {
        this.todaydate = todaydate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIntimehour() {
        return intimehour;
    }

    public void setIntimehour(int intimehour) {
        this.intimehour = intimehour;
    }

    public int getIntimeminute() {
        return intimeminute;
    }

    public void setIntimeminute(int intimeminute) {
        this.intimeminute = intimeminute;
    }

    public int getOuttimehour() {
        return outtimehour;
    }

    public void setOuttimehour(int outtimehour) {
        this.outtimehour = outtimehour;
    }

    public int getOuttimeminute() {
        return outtimeminute;
    }

    public void setOuttimeminute(int outtimeminute) {
        this.outtimeminute = outtimeminute;
    }

    public int getDurationhour() {
        return durationhour;
    }

    public void setDurationhour(int durationhour) {
        this.durationhour = durationhour;
    }

    public int getDurationminute() {
        return durationminute;
    }

    public void setDurationminute(int durationminute) {
        this.durationminute = durationminute;
    }
    
    
      
}
