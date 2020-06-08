package com.jiezai.swing.simplelayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame
{
	JLabel a1 = new ColorfulLabel("Hello,World", Color.yellow);
	JLabel a2 = new ColorfulLabel("样例文本", new Color(202,255,112));
	
	public MyFrame(String title)
	{
		super(title);
		
		// 根容器
		Container root = this.getContentPane();
		
		// 设置一个自定义的布局器
		LayoutManager layoutMgr = new SimpleLayout();
		root.setLayout(layoutMgr);
		
		// 由于没有布局器，所以默认地，子控件无法显示
		root.add(a1);
		root.add(a2);
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
	
	private class SimpleLayout implements LayoutManager
	{

		@Override
		public void addLayoutComponent(String name, Component comp)
		{
		}

		@Override
		public void removeLayoutComponent(Component comp)
		{
		}

		@Override
		public Dimension preferredLayoutSize(Container parent)
		{
			return null;
		}

		@Override
		public Dimension minimumLayoutSize(Container parent)
		{
			return null;
		}

		@Override
		public void layoutContainer(Container parent)
		{
			int w = parent.getWidth(); // 父窗口的宽度 width
			int h = parent.getHeight(); // 父窗口的高度 height
			System.out.println("父容器: " + w + ", " + h);
			
			// a1 显示在中间, 以 Preferred Size 作为大小
			if(a1.isVisible())
			{
				// 得取该控件所需的显示尺寸
				Dimension size = a1.getPreferredSize();
				//System.out.println(size);				
				int x = (w - size.width) / 2;
				int y = (h - size.height) /2 ;
				
				// 在设置子控件位置时，其坐标是相对于父窗口的 
				// (0,0) 就是父窗口的左上角
				a1.setBounds(x, y, size.width, size.height);
			}

			// a2 显示在右上角
			if(a2.isVisible())
			{
				Dimension size = a2.getPreferredSize();
				//System.out.println(size);
				int x = (w - size.width);
				int y = 0;
				a2.setBounds(x, y, size.width, size.height);
			}
		}		
	}
}
