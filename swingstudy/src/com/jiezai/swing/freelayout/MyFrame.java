package com.jiezai.swing.freelayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jiezai.swing.aflayout.AfAnyWhere;
import com.jiezai.swing.aflayout.AfMargin;

public class MyFrame extends JFrame
{
	JLabel a1 = new ColorfulLabel("Hello,World", Color.yellow);
	JLabel a2 = new ColorfulLabel("样例文本", Color.blue);
	JLabel a3 = new ColorfulLabel("Good Boy", Color.CYAN);
	JLabel a4 = new ColorfulLabel("占满剩余", Color.red);
	
	public MyFrame(String title)
	{
		super(title);
		
		// 根容器
		JPanel root = new JPanel();
		this.setContentPane(root);
		
		// 设置为自动位置布局
		root.setLayout(new AfAnyWhere()); 
		
		// 左上 ,相当于 new AfMargin(0,0,-1,-1)
		root.add(a1, AfMargin.TOP_LEFT); 
		
		// 右上 ,相当于 new AfMargin(0,-1,-1,0)
		root.add(a2, AfMargin.TOP_RIGHT);  
		
		// 中间 ,相当于 new AfMargin(-1, -1, -1, -1)
		root.add(a3, AfMargin.CENTER); // 中间
		a3.setPreferredSize(new Dimension(160,80));
		
		// 自由位置定义
		root.add(a4, new AfMargin(-1, 15, 20, 15));
		a4.setPreferredSize(new Dimension(0,40));
	}
	
	
	// ColorfulLabel: 参考4.5节的讲解
	private static class ColorfulLabel extends JLabel
	{
		public ColorfulLabel(String text, Color bgColor)
		{
			super(text);
			
			setOpaque(true);
			setBackground(bgColor);
			//setPreferredSize(new Dimension(60,30));
			setHorizontalAlignment(SwingConstants.CENTER);
			setFont(new Font("宋体", Font.PLAIN, 16));
		}
	}
	
	
}
