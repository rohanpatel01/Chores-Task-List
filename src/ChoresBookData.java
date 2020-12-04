class ChoreBook
{
    // I made a change here!!!
    private String theTask;
    private int month;
    private int day;
    private int year;
    private String importance; //urgent... not urgent...
    private String category;
    private String extraInfo;

    public ChoreBook(String theTask, int month, int day, int year, String importance, String category, String extraInfo)
    {
        this.theTask = theTask;
        this.month = month;
        this.day = day;
        this.year = year;
        this.importance = importance;
        this.category = category;
        this.extraInfo = extraInfo;
    }

    public ChoreBook()
    {

    }

    public String getTheTask()
    {
        return theTask;
    }

    public void setTheTask(String theTask)
    {
        this.theTask = theTask;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getImportance()
    {
        return importance;
    }

    public void setImportance(String importance)
    {
        this.importance = importance;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getExtraInfo()
    {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo)
    {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString()
    {
        return "ChoreBook{" +
                "theTask='" + theTask + '\'' +
                ", month=" + month +
                ", day=" + day +
                ", year=" + year +
                ", importance='" + importance + '\'' +
                ", category='" + category + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }
}