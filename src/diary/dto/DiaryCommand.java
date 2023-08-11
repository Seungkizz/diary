package diary.dto;

public class DiaryCommand {

	Diary diary;
	String name;
	
	public DiaryCommand() {
	}
	
	public DiaryCommand(Diary diary, String name) {
		super();
		this.diary = diary;
		this.name = name;
	}
	
	public Diary getDiary() {
		return diary;
	}
	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
