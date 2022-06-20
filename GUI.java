package ch04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame implements ActionListener, ItemListener,Runnable{

	DTO dto = new DTO();
	TextField in_name;
	TextField in_id;
	TextField in_dep;
	TextField in_tel;
	TextField in_birth;
	Button b1;
	
	public GUI(String str) {
		super(str);
		
		init();
		start();
		
		setVisible(true);
		setSize(300,300);
		setResizable(true);
	}
	
	public void init() {
		Panel p = new Panel();
		setLayout(new BorderLayout());
		Label name = new Label("이름");
		Label id = new Label("학번");
		Label dep = new Label("학과");
		Label tel = new Label("전화번호");
		Label birth = new Label("생년월일");
		b1 = new Button("입력");
		b1.addActionListener(this);
		
		in_name = new TextField(20);
		in_id = new TextField(20);
		in_dep = new TextField(20);
		in_tel = new TextField(20);
		in_birth = new TextField(20);
		
		GridLayout g = new GridLayout(5, 2);
		p.setLayout(g);
		p.add(name);
		p.add(id);
		p.add(dep);
		p.add(tel);
		p.add(birth);
		
		add("Center", p);
		add("South", b1);
	}
	
	public void start() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
		});
	}
	
	public static void main(String[] args) {
		new GUI("정보 입력");
	}
	
	public void run() {
	}
	
	public void itemStateChanged(ItemEvent e) {
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if((Button) obj == b1) {
			dto.setname(in_name.getText());
			dto.setid(in_id.getText());
			dto.setdep(in_dep.getText());
			dto.settel(in_tel.getText());
			dto.setbirth(in_birth.getText());
			
			try {
				insertDAO.create(dto);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
