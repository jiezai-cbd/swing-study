package com.jiezai.swing.linearlayout;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jiezai.swing.aflayout.AfXLayout;

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
		
		// 设置为横向布局 
		// 注: AfXLayout 与 AfRowLayout等效
		root.setLayout(new AfXLayout(8)); // 子控件之间的间距为8像素
		
		root.add(a1, "100px"); // 固定占100像素
		root.add(a2, "30%");  // 固定占30%
		root.add(a3, "auto"); // 按 Preferred Size 设置
		root.add(a4, "1w");   // 按权重设置，权重为1 weight
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
