package entities;

public class Question {
	int qno;
	String qtext,opt1,opt2,opt3,opt4;
	char ans;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int qno, String qtext, String opt1, String opt2, String opt3, String opt4, char ans) {
		super();
		this.qno = qno;
		this.qtext = qtext;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.ans = ans;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQtext() {
		return qtext;
	}
	public void setQtext(String qtext) {
		this.qtext = qtext;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public char getAns() {
		return ans;
	}
	public void setAns(char ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "Question [qno=" + qno + ", qtext=" + qtext + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
				+ ", opt4=" + opt4 + ", ans=" + ans + "]";
	}
	
	
}
