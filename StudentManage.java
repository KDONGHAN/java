package 자바프로그래밍;

import javax.swing.*;
import java.awt.*;

public class StudentManage extends JFrame {
	private String [] dep= {"컴퓨터공학과", "소프트웨어공학과"};
	private String [] sex= {"남성", "여성"};
	public StudentManage() {
		setTitle("학생관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	
		GridLayout grid = new GridLayout(7, 2);
		grid.setVgap(5);
	
		Container c = getContentPane();
		c.setLayout(grid);
		c.add(new JLabel(" 이름"));
		c.add(new JTextField(""));
		
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		
		c.add(new JLabel(" 학과"));
		JList<String> scrolList = new JList<String>(dep);
		c.add(new JScrollPane(scrolList));
		
		c.add(new JLabel(" 생년월일"));
		c.add(new JTextField(""));
		
		c.add(new JLabel(" 전화번호"));
		c.add(new JTextField(""));
		
		c.add(new JLabel(" 성별 "));
		JList<String> strList = new JList<String>(sex);
		c.add(new JScrollPane(strList));

		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentManage();
	}

}
