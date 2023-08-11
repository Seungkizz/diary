package diary.dto;

import java.util.Date;

public class Diary {

	private int diaryId;
	private String dirarymemberId;
	private String title;
	private String content;
	private String date;
	private String moddate;

	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public Diary(int diaryId, String dirarymemberId, String title, String content, String date, String moddate) {
		super();
		this.diaryId = diaryId;
		this.dirarymemberId = dirarymemberId;
		this.title = title;
		this.content = content;
		this.date = date;
		this.moddate = moddate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public int getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	public String getDirarymemberId() {
		return dirarymemberId;
	}

	public void setDirarymemberId(String dirarymemberId) {
		this.dirarymemberId = dirarymemberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Diary [diaryId=" + diaryId + ", dirarymemberId=" + dirarymemberId + ", title=" + title + ", content="
				+ content + ", date=" + date + "]";
	}

}
