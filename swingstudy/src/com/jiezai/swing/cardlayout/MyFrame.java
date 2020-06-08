package com.jiezai.swing.cardlayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class MyFrame extends JFrame
{
	JComboBox<String> options = new JComboBox<>();
	JPanel cards = new JPanel();
	
	public MyFrame(String title)
	{
		super(title);
		
		Container contentPane = getContentPane();
		
		// 给顶层容器，设置 BorderLayout
		contentPane.setLayout(new BorderLayout());
		
		// 创建一个下拉列表，供选择		
		options.addItem("第一个面板");
		options.addItem("第二个面板");
		contentPane.add(options, BorderLayout.PAGE_START);
		contentPane.add(cards, BorderLayout.CENTER);
		
		// 创建第一个面板
		JPanel p1 = new JPanel();
		p1.add(new JButton("红"));
		p1.add(new JButton("绿"));
		p1.add(new JButton("蓝"));
		
		// 创建第二个面板
		JPanel p2 = new JPanel();
		p2.add(new JLabel("输入"));
		p2.add(new JTextField(20));
		
		cards.setLayout(new CardLayout());
		cards.add(p1, "buttons"); // 添加第一张卡片, 名字叫 buttons
		cards.add(p2, "text"); // 添加第二张卡片，名字叫 text
		
		// 添加事件响应
		options.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e)
			{
				itemChanged();
			}			
		});
	}
	
	private void itemChanged()
	{
		// cards.setLayout(): 给cards设置一个布局器
		// cards.getLayout(): 取得它的当前布局器
		CardLayout cardLayout = (CardLayout)cards.getLayout();
		int index = options.getSelectedIndex();
		if(index == 0)
		{
			cardLayout.show(cards, "buttons");
		}
		else if(index == 1)
		{
			cardLayout.show(cards, "text");
		}
	}
	
	
	
}
