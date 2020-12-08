class ChoreBook
{
    private String theTask;
    private String month;
    private String day;
    private String year;
    private String importance;
    private String category;
    private String extraInfo;

    public ChoreBook(String theTask, String month, String day, String year, String importance, String category, String extraInfo)
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

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
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