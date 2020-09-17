package lab1;

public class Sportsman {
	private Integer prizePlace;
	private String fullname;
	private Integer year;
	
	public Integer getPrizePlace()
	{
		return prizePlace;
	}
	public void setPrizePlace(Integer prizePlace)
	{
		this.prizePlace = prizePlace;
	}
	
	public String getFullname()
	{
		return fullname;
	}
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}
	
	public Integer getYear()
	{
		return year;
	}
	public void setYear(Integer year)
	{
		this.year = year;
	}
	
	public Sportsman(Integer prizePlace, String fullname, Integer year)
	{
		this.prizePlace = prizePlace;
		this.fullname = fullname;
		this.year = year;
	}
}
